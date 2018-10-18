package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class SubtitleSampleEntry extends AbstractSampleEntry {
    public static final String TYPE1 = "stpp";
    private String imageMimeType = "";
    private String namespace = "";
    private String schemaLocation = "";

    public SubtitleSampleEntry() {
        super(TYPE1);
    }

    public long getSize() {
        long s = getContainerSize();
        long t = (long) ((((this.namespace.length() + 8) + this.schemaLocation.length()) + this.imageMimeType.length()) + 3);
        long j = s + t;
        int i = (this.largeBox || (s + t) + 8 >= 4294967296L) ? 16 : 8;
        return j + ((long) i);
    }

    public void parse(DataSource dataSource, ByteBuffer header, long contentSize, BoxParser boxParser) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        dataSource.read((ByteBuffer) byteBuffer.rewind());
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
        long start = dataSource.position();
        ByteBuffer content = ByteBuffer.allocate(1024);
        dataSource.read((ByteBuffer) content.rewind());
        this.namespace = IsoTypeReader.readString((ByteBuffer) content.rewind());
        dataSource.position((((long) this.namespace.length()) + start) + 1);
        dataSource.read((ByteBuffer) content.rewind());
        this.schemaLocation = IsoTypeReader.readString((ByteBuffer) content.rewind());
        dataSource.position(((((long) this.namespace.length()) + start) + ((long) this.schemaLocation.length())) + 2);
        dataSource.read((ByteBuffer) content.rewind());
        this.imageMimeType = IsoTypeReader.readString((ByteBuffer) content.rewind());
        dataSource.position((((((long) this.namespace.length()) + start) + ((long) this.schemaLocation.length())) + ((long) this.imageMimeType.length())) + 3);
        parseContainer(dataSource, contentSize - ((long) ((((header.remaining() + this.namespace.length()) + this.schemaLocation.length()) + this.imageMimeType.length()) + 3)), boxParser);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer byteBuffer = ByteBuffer.allocate((((this.namespace.length() + 8) + this.schemaLocation.length()) + this.imageMimeType.length()) + 3);
        byteBuffer.position(6);
        IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.namespace);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.schemaLocation);
        IsoTypeWriter.writeZeroTermUtf8String(byteBuffer, this.imageMimeType);
        writableByteChannel.write((ByteBuffer) byteBuffer.rewind());
        writeContainer(writableByteChannel);
    }

    public String getNamespace() {
        return this.namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getImageMimeType() {
        return this.imageMimeType;
    }

    public void setImageMimeType(String imageMimeType) {
        this.imageMimeType = imageMimeType;
    }
}