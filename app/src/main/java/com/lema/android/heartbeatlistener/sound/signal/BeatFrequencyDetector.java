package com.lema.android.heartbeatlistener.sound.signal;

import com.lema.android.heartbeatlistener.sound.signal.event.SignalEvent;
import com.lema.android.heartbeatlistener.sound.signal.event.SignalEventComparatorByPeriod;
import com.lema.android.heartbeatlistener.sound.signal.event.SignalEventComparatorByTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class BeatFrequencyDetector {
    protected final int EVENT_LOG_SIZE = 20;
    /* renamed from: N */
    protected int f60N;
    protected final int WINDOW_BUFFER_SIZE = 512;
    protected final double WINDOW_REAL_DURATION;
    protected final double WINDOW_TIME_LENGTH = 10.0d;
    boolean acquiringFrequency;
    int eventDurationThreshold;
    TreeSet<SignalEvent> eventLogSortedByTime;
    int eventMinPeriodThreshold;
    int eventOffset;
    boolean eventPending;
    protected LinkedList<Integer> eventPeriodLog;
    LinkedList<Integer> eventTimeLog;
    public double frequency;
    int pendingEventStartTime;
    float[] previousData;
    int previousDataUsedSize;
    double[] previousWindowData;
    protected double samplingFrequency;
    double signalPeriod;
    float threshold;

    public BeatFrequencyDetector(double samplingFrequency) {
        this.samplingFrequency = samplingFrequency;
        this.f60N = (int) (0.01f * ((float) samplingFrequency));
        this.WINDOW_REAL_DURATION = ((double) this.f60N) / samplingFrequency;
        this.previousData = new float[this.f60N];
        this.previousWindowData = new double[512];
        this.previousDataUsedSize = 0;
        this.eventTimeLog = new LinkedList();
        this.eventPeriodLog = new LinkedList();
        this.eventPending = false;
        this.threshold = 19660.201f;
        this.eventDurationThreshold = 3;
        this.eventMinPeriodThreshold = (int) (0.30000001192092896d / this.WINDOW_REAL_DURATION);
        this.eventOffset = 0;
        this.eventTimeLog.add(Integer.valueOf(0));
        this.acquiringFrequency = true;
        this.eventLogSortedByTime = new TreeSet(new SignalEventComparatorByTime());
        for (int i = 0; i < 20; i++) {
            this.eventLogSortedByTime.add(new SignalEvent(0, 0.0d));
        }
        this.frequency = Double.NaN;
        this.signalPeriod = 0.0d;
    }

    public void treatData(short[] buffer, int bufferSize) {
        int i;
        float sum = 0.0f;
        int windowDataMaxSize = (this.previousDataUsedSize + bufferSize) / this.f60N;
        float[] windowData = new float[windowDataMaxSize];
        for (i = 0; i < this.previousDataUsedSize; i++) {
            sum += Math.abs(this.previousData[i]);
        }
        i = 0;
        int j = 0;
        int k = this.previousDataUsedSize;
        while (i < bufferSize && j < windowDataMaxSize) {
            sum += (float) Math.abs(buffer[i]);
            k++;
            i++;
            if (k >= this.f60N) {
                windowData[j] = sum / ((float) (k + 1));
                k = 0;
                j++;
            }
        }
        int windowDataUsedSize = j;
        for (int p = 0; p < k; p++) {
            this.previousData[p] = (float) buffer[(bufferSize - k) + p];
        }
        this.previousDataUsedSize = k;
        treatWindowData(windowData, windowDataUsedSize);
    }

    private void treatWindowData(float[] windowData, int usedSize) {
        int currentTime = this.eventOffset;
        for (int i = 0; i < usedSize; i++) {
            currentTime = this.eventOffset + i;
            if (windowData[i] > this.threshold) {
                if (!this.eventPending) {
                    this.eventPending = true;
                    this.pendingEventStartTime = currentTime;
                }
            } else if (this.eventPending) {
                if (currentTime - this.pendingEventStartTime < this.eventDurationThreshold || currentTime <= ((Integer) this.eventTimeLog.getLast()).intValue() + this.eventMinPeriodThreshold) {
                    ((Integer) this.eventTimeLog.getLast()).intValue();
                } else {
                    logEvent((this.pendingEventStartTime + currentTime) / 2);
                }
                this.eventPending = false;
            }
        }
        this.eventOffset += usedSize;
    }

    private void logEvent(int eventTime) {
        synchronized (this.eventLogSortedByTime) {
            SignalEvent newEvent = new SignalEvent(eventTime, ((double) (eventTime - ((SignalEvent) this.eventLogSortedByTime.last()).absoluteTime)) * this.WINDOW_REAL_DURATION);
            this.eventLogSortedByTime.pollFirst();
            this.eventLogSortedByTime.add(newEvent);
        }
    }

    public void updateFrequency() {
        TreeSet<SignalEvent> eventLogSortedByPeriod = new TreeSet(new SignalEventComparatorByPeriod());
        synchronized (this.eventLogSortedByTime) {
            eventLogSortedByPeriod.addAll(this.eventLogSortedByTime);
        }
        if (this.acquiringFrequency) {
            int trancatedPartNumber = (int) (((double) eventLogSortedByPeriod.size()) * 0.2d);
            for (int i = 0; i < trancatedPartNumber; i++) {
                eventLogSortedByPeriod.pollLast();
            }
        } else {
            SignalEvent lowThreshold = new SignalEvent(0, this.signalPeriod * (1.0d - 0.15d));
            eventLogSortedByPeriod.headSet(new SignalEvent(0, this.signalPeriod * (1.0d + 0.15d)));
            eventLogSortedByPeriod.tailSet(lowThreshold);
        }
        double meanPeriod = 0.0d;
        boolean meanValidity = false;
        Iterator it = eventLogSortedByPeriod.iterator();
        while (it.hasNext()) {
            meanPeriod += ((SignalEvent) it.next()).periodFromPrevious;
            meanValidity = true;
        }
        if (meanValidity) {
            meanPeriod /= (double) eventLogSortedByPeriod.size();
            this.signalPeriod = meanPeriod;
            this.frequency = 60.0d / (2.0d * meanPeriod);
        }
    }
}
