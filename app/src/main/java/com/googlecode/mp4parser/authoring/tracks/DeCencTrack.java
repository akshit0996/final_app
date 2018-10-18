package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.ProtectionSchemeInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.h264.AvcConfigurationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.MemoryDataSourceImpl;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Mp4TrackImpl;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat.Pair;
import com.googlecode.mp4parser.util.Path;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DeCencTrack extends AbstractTrack {
    Track original;
    DecryptedSampleList samples;

    public class DecryptedSampleList extends AbstractList<Sample> {
        AvcConfigurationBox avcC = null;
        List<Sample> parent;
        SecretKey secretKey;
        List<CencSampleAuxiliaryDataFormat> sencInfo;

        public DecryptedSampleList(SecretKey secretKey, List<Sample> parent, Track track, List<CencSampleAuxiliaryDataFormat> sencInfo) {
            this.sencInfo = sencInfo;
            this.secretKey = secretKey;
            this.parent = parent;
            for (Box box : track.getSampleDescriptionBox().getSampleEntry().getBoxes()) {
                if (box instanceof AvcConfigurationBox) {
                    this.avcC = (AvcConfigurationBox) box;
                }
            }
        }

        Cipher getCipher(SecretKey sk, byte[] iv) {
            byte[] fullIv = new byte[16];
            System.arraycopy(iv, 0, fullIv, 0, iv.length);
            try {
                Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
                cipher.init(2, sk, new IvParameterSpec(fullIv));
                return cipher;
            } catch (InvalidAlgorithmParameterException e) {
                throw new RuntimeException(e);
            } catch (InvalidKeyException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(e3);
            } catch (NoSuchPaddingException e4) {
                throw new RuntimeException(e4);
            }
        }

        public Sample get(int index) {
            Sample encSample = (Sample) this.parent.get(index);
            ByteBuffer encSampleBuffer = encSample.asByteBuffer();
            encSampleBuffer.rewind();
            ByteBuffer decSampleBuffer = ByteBuffer.allocate(encSampleBuffer.limit());
            CencSampleAuxiliaryDataFormat sencEntry = (CencSampleAuxiliaryDataFormat) this.sencInfo.get(index);
            Cipher cipher = getCipher(this.secretKey, sencEntry.iv);
            try {
                if (this.avcC != null) {
                    for (Pair pair : sencEntry.pairs) {
                        int encrypted = (int) pair.encrypted;
                        byte[] clears = new byte[pair.clear];
                        encSampleBuffer.get(clears);
                        decSampleBuffer.put(clears);
                        if (encrypted > 0) {
                            byte[] encs = new byte[encrypted];
                            encSampleBuffer.get(encs);
                            decSampleBuffer.put(cipher.update(encs));
                        }
                    }
                    if (encSampleBuffer.remaining() > 0) {
                        System.err.println("Decrypted sample but still data remaining: " + encSample.getSize());
                    }
                    decSampleBuffer.put(cipher.doFinal());
                } else {
                    byte[] fullyEncryptedSample = new byte[encSampleBuffer.limit()];
                    encSampleBuffer.get(fullyEncryptedSample);
                    decSampleBuffer.put(cipher.doFinal(fullyEncryptedSample));
                }
                encSampleBuffer.rewind();
                decSampleBuffer.rewind();
                return new SampleImpl(decSampleBuffer);
            } catch (IllegalBlockSizeException e) {
                throw new RuntimeException(e);
            } catch (BadPaddingException e2) {
                throw new RuntimeException(e2);
            }
        }

        public int size() {
            return this.parent.size();
        }
    }

    public DeCencTrack(Mp4TrackImpl original, SecretKey key) {
        this.original = original;
        if ("cenc".equals(((SchemeTypeBox) Path.getPath(original.getSampleDescriptionBox(), "enc./sinf/schm")).getSchemeType())) {
            this.samples = new DecryptedSampleList(key, original.getSamples(), original, original.getSampleEncryptionEntries());
            return;
        }
        throw new RuntimeException("You can only use the DeCencTrack with CENC encrypted tracks");
    }

    public long[] getSyncSamples() {
        return this.original.getSyncSamples();
    }

    public SampleDescriptionBox getSampleDescriptionBox() {
        OriginalFormatBox frma = (OriginalFormatBox) Path.getPath(this.original.getSampleDescriptionBox(), "enc./sinf/frma");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            this.original.getSampleDescriptionBox().getBox(Channels.newChannel(baos));
            SampleDescriptionBox stsd = (SampleDescriptionBox) new IsoFile(new MemoryDataSourceImpl(baos.toByteArray())).getBoxes().get(0);
            if (stsd.getSampleEntry() instanceof AudioSampleEntry) {
                ((AudioSampleEntry) stsd.getSampleEntry()).setType(frma.getDataFormat());
            } else if (stsd.getSampleEntry() instanceof VisualSampleEntry) {
                ((VisualSampleEntry) stsd.getSampleEntry()).setType(frma.getDataFormat());
            } else {
                throw new RuntimeException("I don't know " + stsd.getSampleEntry().getType());
            }
            List<Box> nuBoxes = new LinkedList();
            for (Box box : stsd.getSampleEntry().getBoxes()) {
                if (!box.getType().equals(ProtectionSchemeInformationBox.TYPE)) {
                    nuBoxes.add(box);
                }
            }
            stsd.getSampleEntry().setBoxes(nuBoxes);
            return stsd;
        } catch (IOException e) {
            throw new RuntimeException("Dumping stsd to memory failed");
        }
    }

    public long[] getSampleDurations() {
        return this.original.getSampleDurations();
    }

    public TrackMetaData getTrackMetaData() {
        return this.original.getTrackMetaData();
    }

    public String getHandler() {
        return this.original.getHandler();
    }

    public List<Sample> getSamples() {
        return this.samples;
    }

    public Box getMediaHeaderBox() {
        return this.original.getMediaHeaderBox();
    }
}
