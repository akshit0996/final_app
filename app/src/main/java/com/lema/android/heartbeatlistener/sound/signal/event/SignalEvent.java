package com.lema.android.heartbeatlistener.sound.signal.event;

public class SignalEvent {
    private static int idCounter = 0;
    public int absoluteTime;
    public double periodFromPrevious;
    protected int uniqueID;

    public SignalEvent(int absoluteTime, double periodFromPrevious) {
        int i = idCounter;
        idCounter = i + 1;
        this.uniqueID = i;
        this.absoluteTime = absoluteTime;
        this.periodFromPrevious = periodFromPrevious;
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof SignalEvent) && ((SignalEvent) o).uniqueID == this.uniqueID) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "SignalEvent [uniqueID=" + this.uniqueID + ", absoluteTime=" + this.absoluteTime + ", periodFromPrevious=" + this.periodFromPrevious + "]";
    }
}
