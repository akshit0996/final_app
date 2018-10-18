package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.runtime.reflect.Factory;

public class TimeToSampleBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TYPE = "stts";
    private static final /* synthetic */ StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ StaticPart ajc$tjp_2 = null;
    static Map<List<Entry>, SoftReference<long[]>> cache = new WeakHashMap();
    List<Entry> entries = Collections.emptyList();

    public static class Entry {
        long count;
        long delta;

        public Entry(long count, long delta) {
            this.count = count;
            this.delta = delta;
        }

        public long getCount() {
            return this.count;
        }

        public long getDelta() {
            return this.delta;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public void setDelta(long delta) {
            this.delta = delta;
        }

        public String toString() {
            return "Entry{count=" + this.count + ", delta=" + this.delta + '}';
        }
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("TimeToSampleBox.java", TimeToSampleBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    static {
        boolean z;
        ajc$preClinit();
        if (TimeToSampleBox.class.desiredAssertionStatus()) {
            z = $assertionsDisabled;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    public TimeToSampleBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) ((this.entries.size() * 8) + 8);
    }

    public void _parseDetails(ByteBuffer content) {
        parseVersionAndFlags(content);
        int entryCount = CastUtils.l2i(IsoTypeReader.readUInt32(content));
        this.entries = new ArrayList(entryCount);
        for (int i = 0; i < entryCount; i++) {
            this.entries.add(new Entry(IsoTypeReader.readUInt32(content), IsoTypeReader.readUInt32(content)));
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, (long) this.entries.size());
        for (Entry entry : this.entries) {
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getCount());
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getDelta());
        }
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> entries) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, (Object) this, (Object) this, (Object) entries));
        this.entries = entries;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return "TimeToSampleBox[entryCount=" + this.entries.size() + "]";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized long[] blowupTimeToSamples(java.util.List<com.coremedia.iso.boxes.TimeToSampleBox.Entry> r15) {
        /*
        r10 = com.coremedia.iso.boxes.TimeToSampleBox.class;
        monitor-enter(r10);
        r9 = cache;	 Catch:{ all -> 0x0034 }
        r0 = r9.get(r15);	 Catch:{ all -> 0x0034 }
        r0 = (java.lang.ref.SoftReference) r0;	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r0.get();	 Catch:{ all -> 0x0034 }
        r1 = (long[]) r1;	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r10);
        return r1;
    L_0x0017:
        r7 = 0;
        r9 = r15.iterator();	 Catch:{ all -> 0x0034 }
    L_0x001d:
        r11 = r9.hasNext();	 Catch:{ all -> 0x0034 }
        if (r11 != 0) goto L_0x0037;
    L_0x0023:
        r9 = $assertionsDisabled;	 Catch:{ all -> 0x0034 }
        if (r9 != 0) goto L_0x0043;
    L_0x0027:
        r11 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1));
        if (r9 <= 0) goto L_0x0043;
    L_0x002e:
        r9 = new java.lang.AssertionError;	 Catch:{ all -> 0x0034 }
        r9.<init>();	 Catch:{ all -> 0x0034 }
        throw r9;	 Catch:{ all -> 0x0034 }
    L_0x0034:
        r9 = move-exception;
        monitor-exit(r10);
        throw r9;
    L_0x0037:
        r5 = r9.next();	 Catch:{ all -> 0x0034 }
        r5 = (com.coremedia.iso.boxes.TimeToSampleBox.Entry) r5;	 Catch:{ all -> 0x0034 }
        r11 = r5.getCount();	 Catch:{ all -> 0x0034 }
        r7 = r7 + r11;
        goto L_0x001d;
    L_0x0043:
        r9 = (int) r7;	 Catch:{ all -> 0x0034 }
        r4 = new long[r9];	 Catch:{ all -> 0x0034 }
        r2 = 0;
        r9 = r15.iterator();	 Catch:{ all -> 0x0034 }
    L_0x004b:
        r11 = r9.hasNext();	 Catch:{ all -> 0x0034 }
        if (r11 != 0) goto L_0x005d;
    L_0x0051:
        r9 = cache;	 Catch:{ all -> 0x0034 }
        r11 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x0034 }
        r11.<init>(r4);	 Catch:{ all -> 0x0034 }
        r9.put(r15, r11);	 Catch:{ all -> 0x0034 }
        r1 = r4;
        goto L_0x0015;
    L_0x005d:
        r5 = r9.next();	 Catch:{ all -> 0x0034 }
        r5 = (com.coremedia.iso.boxes.TimeToSampleBox.Entry) r5;	 Catch:{ all -> 0x0034 }
        r6 = 0;
        r3 = r2;
    L_0x0065:
        r11 = (long) r6;	 Catch:{ all -> 0x0034 }
        r13 = r5.getCount();	 Catch:{ all -> 0x0034 }
        r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
        if (r11 < 0) goto L_0x0070;
    L_0x006e:
        r2 = r3;
        goto L_0x004b;
    L_0x0070:
        r2 = r3 + 1;
        r11 = r5.getDelta();	 Catch:{ all -> 0x0034 }
        r4[r3] = r11;	 Catch:{ all -> 0x0034 }
        r6 = r6 + 1;
        r3 = r2;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coremedia.iso.boxes.TimeToSampleBox.blowupTimeToSamples(java.util.List):long[]");
    }
}
