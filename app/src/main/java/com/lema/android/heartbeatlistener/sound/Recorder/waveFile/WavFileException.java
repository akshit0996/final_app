package com.lema.android.heartbeatlistener.sound.Recorder.waveFile;

public class WavFileException extends Exception {
    private static final long serialVersionUID = 4744242702711185174L;

    public WavFileException(String message) {
        super(message);
    }

    public WavFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WavFileException(Throwable cause) {
        super(cause);
    }
}
