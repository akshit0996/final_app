package com.lema.android.heartbeatlistener.sound.signal.event;

import java.util.Comparator;

public class SignalEventComparatorByPeriod implements Comparator<SignalEvent> {
    public int compare(SignalEvent lhs, SignalEvent rhs) {
        if (lhs.periodFromPrevious != rhs.periodFromPrevious) {
            return (int) Math.signum(lhs.periodFromPrevious - rhs.periodFromPrevious);
        }
        if (lhs.equals(rhs)) {
            return 0;
        }
        return lhs.uniqueID - rhs.uniqueID;
    }
}
