package org.aspectj.lang;

public class NoAspectBoundException extends RuntimeException {
    Throwable cause;

    public NoAspectBoundException(String aspectName, Throwable inner) {
        super(aspectName);
        if (inner != null) {
            aspectName = new StringBuffer().append("Exception while initializing ").append(aspectName).append(": ").append(inner).toString();
        }

        this.cause = inner;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
