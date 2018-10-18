package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;

public final class iz extends Drawable implements Callback {
    private boolean LO;
    private int LV;
    private long LW;
    private int LX;
    private int LY;
    private int LZ;
    private int Ma;
    private boolean Mb;
    private C0470b Mc;
    private Drawable Md;
    private Drawable Me;
    private boolean Mf;
    private boolean Mg;
    private boolean Mh;
    private int Mi;
    private int mFrom;

    /* renamed from: com.google.android.gms.internal.iz$a */
    private static final class C0469a extends Drawable {
        private static final C0469a Mj = new C0469a();
        private static final C0468a Mk = new C0468a();

        /* renamed from: com.google.android.gms.internal.iz$a$a */
        private static final class C0468a extends ConstantState {
            private C0468a() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return C0469a.Mj;
            }
        }

        private C0469a() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return Mk;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* renamed from: com.google.android.gms.internal.iz$b */
    static final class C0470b extends ConstantState {
        int Ml;
        int Mm;

        C0470b(C0470b c0470b) {
            if (c0470b != null) {
                this.Ml = c0470b.Ml;
                this.Mm = c0470b.Mm;
            }
        }

        public int getChangingConfigurations() {
            return this.Ml;
        }

        public Drawable newDrawable() {
            return new iz(this);
        }
    }

    public iz(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = C0469a.Mj;
        }
        this.Md = drawable;
        drawable.setCallback(this);
        C0470b c0470b = this.Mc;
        c0470b.Mm |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = C0469a.Mj;
        }
        this.Me = drawable2;
        drawable2.setCallback(this);
        c0470b = this.Mc;
        c0470b.Mm |= drawable2.getChangingConfigurations();
    }

    iz(C0470b c0470b) {
        this.LV = 0;
        this.LY = MotionEventCompat.ACTION_MASK;
        this.Ma = 0;
        this.LO = true;
        this.Mc = new C0470b(c0470b);
    }

    public boolean canConstantState() {
        if (!this.Mf) {
            boolean z = (this.Md.getConstantState() == null || this.Me.getConstantState() == null) ? false : true;
            this.Mg = z;
            this.Mf = true;
        }
        return this.Mg;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.LV) {
            case 1:
                this.LW = SystemClock.uptimeMillis();
                this.LV = 2;
                break;
            case 2:
                if (this.LW >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.LW)) / ((float) this.LZ);
                    if (uptimeMillis < 1.0f) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.LV = 0;
                    }
                    float min = Math.min(uptimeMillis, 1.0f);
                    this.Ma = (int) ((min * ((float) (this.LX - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.Ma;
        boolean z = this.LO;
        Drawable drawable = this.Md;
        Drawable drawable2 = this.Me;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.LY) {
                drawable2.setAlpha(this.LY);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.LY - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.LY);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.LY);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.Mc.Ml) | this.Mc.Mm;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.Mc.Ml = getChangingConfigurations();
        return this.Mc;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.Md.getIntrinsicHeight(), this.Me.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.Md.getIntrinsicWidth(), this.Me.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.Mh) {
            this.Mi = Drawable.resolveOpacity(this.Md.getOpacity(), this.Me.getOpacity());
            this.Mh = true;
        }
        return this.Mi;
    }

    public Drawable hh() {
        return this.Me;
    }

    public void invalidateDrawable(Drawable who) {
        if (ll.ig()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.Mb && super.mutate() == this) {
            if (canConstantState()) {
                this.Md.mutate();
                this.Me.mutate();
                this.Mb = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect bounds) {
        this.Md.setBounds(bounds);
        this.Me.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (ll.ig()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.Ma == this.LY) {
            this.Ma = alpha;
        }
        this.LY = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.Md.setColorFilter(cf);
        this.Me.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.mFrom = 0;
        this.LX = this.LY;
        this.Ma = 0;
        this.LZ = durationMillis;
        this.LV = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (ll.ig()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }
}
