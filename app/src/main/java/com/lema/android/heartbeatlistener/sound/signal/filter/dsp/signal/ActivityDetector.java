package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.signal;

import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.util.IntArray;

public class ActivityDetector {
    /* renamed from: $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$signal$ActivityDetector$SegmentType */
    private static /* synthetic */ int[] f85x75f741b2;
    private IntArray activeZones;
    private int minActivityLen;
    private int minSilenceLen;
    private int pos;
    private float[] signalEnvelope;
    private float thresholdLevel;

    private enum SegmentType {
        active,
        silence,
        undef
    }

    /* renamed from: $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$signal$ActivityDetector$SegmentType */
    static /* synthetic */ int[] m2339x75f741b2() {
        int[] iArr = f85x75f741b2;
        if (iArr == null) {
            iArr = new int[SegmentType.values().length];
            try {
                iArr[SegmentType.active.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SegmentType.silence.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SegmentType.undef.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f85x75f741b2 = iArr;
        }
        return iArr;
    }

    public ActivityDetector(float thresholdLevel, int minActivityLen, int minSilenceLen) {
        this.thresholdLevel = thresholdLevel;
        this.minActivityLen = minActivityLen;
        this.minSilenceLen = minSilenceLen;
    }

    public int[] process(float[] signalEnvelope) {
        this.signalEnvelope = signalEnvelope;
        this.pos = 0;
        this.activeZones = new IntArray(32);
        int activeStartPos = -1;
        int undefStartPos = -1;
        while (this.pos < signalEnvelope.length) {
            int segmentStartPos = this.pos;
            switch (m2339x75f741b2()[scanSegment().ordinal()]) {
                case 1:
                    if (activeStartPos == -1) {
                        if (undefStartPos != -1) {
                            activeStartPos = undefStartPos;
                        } else {
                            activeStartPos = segmentStartPos;
                        }
                        break;
                    }
                    break;
                case 2:
                    if (activeStartPos != -1) {
                        addActiveZone(activeStartPos, segmentStartPos);
                        activeStartPos = -1;
                    }
                    undefStartPos = -1;
                    break;
                case 3:
                    if (undefStartPos != -1) {
                        break;
                    }
                    undefStartPos = segmentStartPos;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (activeStartPos != -1) {
            addActiveZone(activeStartPos, this.pos);
        }
        return this.activeZones.toArray();
    }

    private SegmentType scanSegment() {
        int startPos = this.pos;
        if (this.pos >= this.signalEnvelope.length) {
            throw new AssertionError();
        }
        boolean active;
        float[] fArr = this.signalEnvelope;
        int i = this.pos;
        this.pos = i + 1;
        if (fArr[i] >= this.thresholdLevel) {
            active = true;
        } else {
            active = false;
        }
        while (this.pos < this.signalEnvelope.length) {
            boolean z;
            if (this.signalEnvelope[this.pos] >= this.thresholdLevel) {
                z = true;
            } else {
                z = false;
            }
            if (z != active) {
                break;
            }
            this.pos++;
        }
        if (this.pos - startPos < (active ? this.minActivityLen : this.minSilenceLen)) {
            return SegmentType.undef;
        }
        return active ? SegmentType.active : SegmentType.silence;
    }

    private void addActiveZone(int startPos, int endPos) {
        this.activeZones.add(startPos);
        this.activeZones.add(endPos);
    }
}
