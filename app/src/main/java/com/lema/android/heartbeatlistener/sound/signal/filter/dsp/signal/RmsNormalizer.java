package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.signal;

public class RmsNormalizer {
    public static void normalize(float[][] signals, float targetRms, int segmentSize) {
        double maxRms = findMaxRmsLevel(signals, segmentSize);
        if (maxRms != 0.0d) {
            amplifySignal(signals, ((double) targetRms) / maxRms);
        }
    }

    private static double findMaxRmsLevel(float[][] signals, int segmentSize) {
        double maxRms = 0.0d;
        for (float[] findMaxRmsLevel : signals) {
            double rms = findMaxRmsLevel(findMaxRmsLevel, segmentSize);
            if (rms > maxRms) {
                maxRms = rms;
            }
        }
        return maxRms;
    }

    private static double findMaxRmsLevel(float[] signal, int segmentSize) {
        double maxRms = 0.0d;
        int p = 0;
        while (p < signal.length) {
            int endP = ((segmentSize * 5) / 3) + p > signal.length ? signal.length : p + segmentSize;
            double rms = computeRms(signal, p, endP - p);
            if (rms > maxRms) {
                maxRms = rms;
            }
            p = endP;
        }
        return maxRms;
    }

    private static double computeRms(float[] signal, int startPos, int len) {
        double a = 0.0d;
        for (int p = startPos; p < startPos + len; p++) {
            a += (double) (signal[p] * signal[p]);
        }
        return Math.sqrt(a / ((double) len));
    }

    private static void amplifySignal(float[][] signals, double factor) {
        for (float[] amplifySignal : signals) {
            amplifySignal(amplifySignal, factor);
        }
    }

    private static void amplifySignal(float[] signal, double factor) {
        for (int p = 0; p < signal.length; p++) {
            signal[p] = (float) (((double) signal[p]) * factor);
        }
    }
}
