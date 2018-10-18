package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class jb extends ImageView {
    private Uri Mn;
    private int Mo;
    private int Mp;
    private C0473a Mq;
    private int Mr;
    private float Ms;

    /* renamed from: com.google.android.gms.internal.jb$a */
    public interface C0473a {
        /* renamed from: g */
        Path m1493g(int i, int i2);
    }

    public void aB(int i) {
        this.Mo = i;
    }

    /* renamed from: g */
    public void m1494g(Uri uri) {
        this.Mn = uri;
    }

    public int hj() {
        return this.Mo;
    }

    protected void onDraw(Canvas canvas) {
        if (this.Mq != null) {
            canvas.clipPath(this.Mq.m1493g(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.Mp != 0) {
            canvas.drawColor(this.Mp);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.Mr) {
            case 1:
                measuredHeight = getMeasuredHeight();
                i = (int) (((float) measuredHeight) * this.Ms);
                break;
            case 2:
                i = getMeasuredWidth();
                measuredHeight = (int) (((float) i) / this.Ms);
                break;
            default:
                return;
        }
        setMeasuredDimension(i, measuredHeight);
    }
}
