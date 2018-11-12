package com.lema.android.heartbeatlistener.sound;

public interface ISoundManager {
    void interupt();

    boolean isRunning();

    void launch();

    void setNewAmplificationRatio(double d);

    void setNewNoiseReductionRatio(double d);
}
