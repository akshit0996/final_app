package com.googlecode.mp4parser.boxes.cenc;

import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat.Pair;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class CommonEncryptionSampleList extends AbstractList<Sample> {
    static Cipher cipher;
    List<CencSampleAuxiliaryDataFormat> auxiliaryDataFormats;
    List<Sample> parent;
    SecretKey secretKey;

    private class EncryptedSampleImpl implements Sample {
        static final /* synthetic */ boolean $assertionsDisabled = (!CommonEncryptionSampleList.class.desiredAssertionStatus());
        private final CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat;
        private final Cipher cipher;
        private final Sample clearSample;

        private EncryptedSampleImpl(Sample clearSample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher) {
            this.clearSample = clearSample;
            this.cencSampleAuxiliaryDataFormat = cencSampleAuxiliaryDataFormat;
            this.cipher = cipher;
        }

        public void writeTo(WritableByteChannel channel) throws IOException {
            ByteBuffer sample = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
            CommonEncryptionSampleList.this.initCipher(this.cencSampleAuxiliaryDataFormat.iv);
            try {
                if (this.cencSampleAuxiliaryDataFormat.pairs == null || this.cencSampleAuxiliaryDataFormat.pairs.size() <= 0) {
                    byte[] fullyEncryptedSample = new byte[sample.limit()];
                    sample.get(fullyEncryptedSample);
                    channel.write(ByteBuffer.wrap(this.cipher.doFinal(fullyEncryptedSample)));
                } else {
                    for (Pair pair : this.cencSampleAuxiliaryDataFormat.pairs) {
                        byte[] clears = new byte[pair.clear];
                        sample.get(clears);
                        channel.write(ByteBuffer.wrap(clears));
                        if (pair.encrypted > 0) {
                            byte[] toBeEncrypted = new byte[CastUtils.l2i(pair.encrypted)];
                            sample.get(toBeEncrypted);
                            if ($assertionsDisabled || toBeEncrypted.length % 16 == 0) {
                                byte[] encrypted = this.cipher.update(toBeEncrypted);
                                if ($assertionsDisabled || encrypted.length == toBeEncrypted.length) {
                                    channel.write(ByteBuffer.wrap(encrypted));
                                } else {
                                    throw new AssertionError();
                                }
                            }
                            throw new AssertionError();
                        }
                    }
                }
                sample.rewind();
            } catch (IllegalBlockSizeException e) {
                throw new RuntimeException(e);
            } catch (BadPaddingException e2) {
                throw new RuntimeException(e2);
            }
        }

        public long getSize() {
            return this.clearSample.getSize();
        }

        public ByteBuffer asByteBuffer() {
            ByteBuffer sample = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
            ByteBuffer encSample = ByteBuffer.allocate(sample.limit());
            CencSampleAuxiliaryDataFormat entry = this.cencSampleAuxiliaryDataFormat;
            CommonEncryptionSampleList.this.initCipher(this.cencSampleAuxiliaryDataFormat.iv);
            try {
                if (entry.pairs != null) {
                    for (Pair pair : entry.pairs) {
                        byte[] clears = new byte[pair.clear];
                        sample.get(clears);
                        encSample.put(clears);
                        if (pair.encrypted > 0) {
                            byte[] toBeEncrypted = new byte[CastUtils.l2i(pair.encrypted)];
                            sample.get(toBeEncrypted);
                            if ($assertionsDisabled || toBeEncrypted.length % 16 == 0) {
                                byte[] encrypted = this.cipher.update(toBeEncrypted);
                                if ($assertionsDisabled || encrypted.length == toBeEncrypted.length) {
                                    encSample.put(encrypted);
                                } else {
                                    throw new AssertionError();
                                }
                            }
                            throw new AssertionError();
                        }
                    }
                } else {
                    byte[] fullyEncryptedSample = new byte[sample.limit()];
                    sample.get(fullyEncryptedSample);
                    encSample.put(this.cipher.doFinal(fullyEncryptedSample));
                }
                sample.rewind();
                encSample.rewind();
                return encSample;
            } catch (IllegalBlockSizeException e) {
                throw new RuntimeException(e);
            } catch (BadPaddingException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    static {
        try {
            cipher = Cipher.getInstance("AES/CTR/NoPadding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public CommonEncryptionSampleList(SecretKey secretKey, List<Sample> parent, List<CencSampleAuxiliaryDataFormat> auxiliaryDataFormats) {
        this.auxiliaryDataFormats = auxiliaryDataFormats;
        this.secretKey = secretKey;
        this.parent = parent;
    }

    public Sample get(int index) {
        return new EncryptedSampleImpl((Sample) this.parent.get(index), (CencSampleAuxiliaryDataFormat) this.auxiliaryDataFormats.get(index), cipher);
    }

    protected void initCipher(byte[] iv) {
        try {
            byte[] fullIv = new byte[16];
            System.arraycopy(iv, 0, fullIv, 0, iv.length);
            cipher.init(1, this.secretKey, new IvParameterSpec(fullIv));
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int size() {
        return this.parent.size();
    }
}
