package com.googlecode.mp4parser.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat.Pair;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.runtime.reflect.Factory;

public abstract class AbstractSampleEncryptionBox extends AbstractFullBox {
    private static final /* synthetic */ StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_3 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_4 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_5 = null;
    protected int algorithmId = -1;
    List<CencSampleAuxiliaryDataFormat> entries = new LinkedList();
    protected int ivSize = -1;
    protected byte[] kid = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 33);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 92);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 96);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 164);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 191);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 199);
    }

    protected AbstractSampleEncryptionBox(String type) {
        super(type);
    }

    public int getOffsetToFirstIV() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return ((getSize() > 4294967296L ? 16 : 8) + (isOverrideTrackEncryptionBoxParameters() ? this.kid.length + 4 : 0)) + 4;
    }

    public void _parseDetails(ByteBuffer content) {
        parseVersionAndFlags(content);
        if ((getFlags() & 1) > 0) {
            this.algorithmId = IsoTypeReader.readUInt24(content);
            this.ivSize = IsoTypeReader.readUInt8(content);
            this.kid = new byte[16];
            content.get(this.kid);
        }
        long numOfEntries = IsoTypeReader.readUInt32(content);
        ByteBuffer parseEight = content.duplicate();
        ByteBuffer parseSixteen = content.duplicate();
        this.entries = parseEntries(parseEight, numOfEntries, 8);
        if (this.entries == null) {
            this.entries = parseEntries(parseSixteen, numOfEntries, 16);
            content.position((content.position() + content.remaining()) - parseSixteen.remaining());
        } else {
            content.position((content.position() + content.remaining()) - parseEight.remaining());
        }
        if (this.entries == null) {
            throw new RuntimeException("Cannot parse SampleEncryptionBox");
        }
    }

    private List<CencSampleAuxiliaryDataFormat> parseEntries(ByteBuffer content, long numOfEntries, int ivSize) {
        List _entries = new LinkedList();
        long remainingNumOfEntries = numOfEntries;
        while (true) {
            long remainingNumOfEntries2 = remainingNumOfEntries - 1;
            if (remainingNumOfEntries <= 0) {
                return _entries;
            }
            try {
                CencSampleAuxiliaryDataFormat e = new CencSampleAuxiliaryDataFormat();
                e.iv = new byte[ivSize];
                content.get(e.iv);
                if ((getFlags() & 2) > 0) {
                    int numOfPairs = IsoTypeReader.readUInt16(content);
                    e.pairs = new LinkedList();
                    int numOfPairs2 = numOfPairs;
                    while (true) {
                        numOfPairs = numOfPairs2 - 1;
                        if (numOfPairs2 <= 0) {
                            break;
                        }
                        e.pairs.add(e.createPair(IsoTypeReader.readUInt16(content), IsoTypeReader.readUInt32(content)));
                        numOfPairs2 = numOfPairs;
                    }
                }
                _entries.add(e);
                remainingNumOfEntries = remainingNumOfEntries2;
            } catch (BufferUnderflowException e2) {
                return null;
            }
        }
    }

    public List<CencSampleAuxiliaryDataFormat> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
        return this.entries;
    }

    public void setEntries(List<CencSampleAuxiliaryDataFormat> entries) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, (Object) this, (Object) this, (Object) entries));
        this.entries = entries;
    }

    @DoNotParseDetail
    public boolean isSubSampleEncryption() {
        return (getFlags() & 2) > 0;
    }

    @DoNotParseDetail
    protected boolean isOverrideTrackEncryptionBoxParameters() {
        return (getFlags() & 1) > 0;
    }

    @DoNotParseDetail
    public void setSubSampleEncryption(boolean b) {
        if (b) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & 16777213);
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (isOverrideTrackEncryptionBoxParameters()) {
            IsoTypeWriter.writeUInt24(byteBuffer, this.algorithmId);
            IsoTypeWriter.writeUInt8(byteBuffer, this.ivSize);
            byteBuffer.put(this.kid);
        }
        IsoTypeWriter.writeUInt32(byteBuffer, (long) this.entries.size());
        for (CencSampleAuxiliaryDataFormat entry : this.entries) {
            if (entry.iv.length == 8 || entry.iv.length == 16) {
                byteBuffer.put(entry.iv);
                if (isSubSampleEncryption()) {
                    IsoTypeWriter.writeUInt16(byteBuffer, entry.pairs.size());
                    for (Pair pair : entry.pairs) {
                        IsoTypeWriter.writeUInt16(byteBuffer, pair.clear);
                        IsoTypeWriter.writeUInt32(byteBuffer, pair.encrypted);
                    }
                }
            } else {
                throw new RuntimeException("IV must be either 8 or 16 bytes");
            }
        }
    }

    protected long getContentSize() {
        long contentSize = 4;
        if (isOverrideTrackEncryptionBoxParameters()) {
            contentSize = (4 + 4) + ((long) this.kid.length);
        }
        contentSize += 4;
        for (CencSampleAuxiliaryDataFormat entry : this.entries) {
            contentSize += (long) entry.getSize();
        }
        return contentSize;
    }

    public void getBox(WritableByteChannel os) throws IOException {
        super.getBox(os);
    }

    public boolean equals(Object o) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, (Object) this, (Object) this, o));
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractSampleEncryptionBox that = (AbstractSampleEncryptionBox) o;
        if (this.algorithmId != that.algorithmId) {
            return false;
        }
        if (this.ivSize != that.ivSize) {
            return false;
        }
        if (this.entries == null ? that.entries != null : !this.entries.equals(that.entries)) {
            return false;
        }
        if (Arrays.equals(this.kid, that.kid)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        int i2 = ((this.algorithmId * 31) + this.ivSize) * 31;
        if (this.kid != null) {
            hashCode = Arrays.hashCode(this.kid);
        } else {
            hashCode = 0;
        }
        hashCode = (i2 + hashCode) * 31;
        if (this.entries != null) {
            i = this.entries.hashCode();
        }
        return hashCode + i;
    }

    public List<Short> getEntrySizes() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
        List entrySizes = new ArrayList(this.entries.size());
        for (CencSampleAuxiliaryDataFormat entry : this.entries) {
            short size = (short) entry.iv.length;
            if (isSubSampleEncryption()) {
                size = (short) ((entry.pairs.size() * 6) + ((short) (size + 2)));
            }
            entrySizes.add(Short.valueOf(size));
        }
        return entrySizes;
    }
}
