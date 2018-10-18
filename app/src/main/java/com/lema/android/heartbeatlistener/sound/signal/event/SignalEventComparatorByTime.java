package com.lema.android.heartbeatlistener.sound.signal.event;

import java.util.Comparator;

public class SignalEventComparatorByTime implements Comparator<SignalEvent> {
    public int compare(SignalEvent lhs, SignalEvent rhs) {
        if (lhs.absoluteTime != rhs.absoluteTime) {
            return lhs.absoluteTime - rhs.absoluteTime;
        }
        if (lhs.equals(rhs)) {
            return 0;
        }
        return lhs.uniqueID - rhs.uniqueID;
    }
}
