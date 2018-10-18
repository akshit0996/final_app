package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class lt {
    private static final List<TimeUnit> TS = Arrays.asList(new TimeUnit[]{TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS});

    /* renamed from: a */
    public static long m1649a(long j, TimeUnit timeUnit, TimeUnit timeUnit2) {
        return timeUnit.convert(timeUnit2.convert(j, timeUnit), timeUnit2);
    }

    /* renamed from: a */
    public static boolean m1650a(TimeUnit timeUnit) {
        return m1651a(timeUnit, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    private static boolean m1651a(TimeUnit timeUnit, TimeUnit timeUnit2) {
        return TS.indexOf(timeUnit) < TS.indexOf(timeUnit2);
    }
}
