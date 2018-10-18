package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class it extends il {
    private static final long HR = TimeUnit.HOURS.toMillis(24);
    private static final long HS = TimeUnit.HOURS.toMillis(24);
    private static final long HT = TimeUnit.HOURS.toMillis(24);
    private static final long HU = TimeUnit.SECONDS.toMillis(1);
    private static final String NAMESPACE = in.aG("com.google.cast.media");
    private long HV;
    private MediaStatus HW;
    private final iw HX;
    private final iw HY;
    private final iw HZ;
    private final iw Ia;
    private final iw Ib;
    private final iw Ic;
    private final iw Id;
    private final iw Ie;
    private final iw If;
    private final iw Ig;
    private final List<iw> Ih;
    private final Runnable Ii;
    private boolean Ij;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.it$a */
    private class C0465a implements Runnable {
        final /* synthetic */ it Ik;

        private C0465a(it itVar) {
            this.Ik = itVar;
        }

        public void run() {
            boolean z = false;
            this.Ik.Ij = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (iw e : this.Ik.Ih) {
                e.m1480e(elapsedRealtime, RemoteMediaPlayer.STATUS_TIMED_OUT);
            }
            synchronized (iw.Ip) {
                for (iw e2 : this.Ik.Ih) {
                    z = e2.gr() ? true : z;
                }
            }
            this.Ik.m3275J(z);
        }
    }

    public it() {
        this(null);
    }

    public it(String str) {
        super(NAMESPACE, "MediaControlChannel", str);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Ii = new C0465a();
        this.Ih = new ArrayList();
        this.HX = new iw(HS);
        this.Ih.add(this.HX);
        this.HY = new iw(HR);
        this.Ih.add(this.HY);
        this.HZ = new iw(HR);
        this.Ih.add(this.HZ);
        this.Ia = new iw(HR);
        this.Ih.add(this.Ia);
        this.Ib = new iw(HT);
        this.Ih.add(this.Ib);
        this.Ic = new iw(HR);
        this.Ih.add(this.Ic);
        this.Id = new iw(HR);
        this.Ih.add(this.Id);
        this.Ie = new iw(HR);
        this.Ih.add(this.Ie);
        this.If = new iw(HR);
        this.Ih.add(this.If);
        this.Ig = new iw(HR);
        this.Ih.add(this.Ig);
        gp();
    }

    /* renamed from: J */
    private void m3275J(boolean z) {
        if (this.Ij != z) {
            this.Ij = z;
            if (z) {
                this.mHandler.postDelayed(this.Ii, HU);
            } else {
                this.mHandler.removeCallbacks(this.Ii);
            }
        }
    }

    /* renamed from: a */
    private void m3277a(long j, JSONObject jSONObject) throws JSONException {
        int i = 1;
        boolean p = this.HX.m1481p(j);
        int i2 = (!this.Ib.gr() || this.Ib.m1481p(j)) ? 0 : 1;
        if ((!this.Ic.gr() || this.Ic.m1481p(j)) && (!this.Id.gr() || this.Id.m1481p(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (p || this.HW == null) {
            this.HW = new MediaStatus(jSONObject);
            this.HV = SystemClock.elapsedRealtime();
            i2 = 7;
        } else {
            i2 = this.HW.m110a(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.HV = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.HV = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        for (iw d : this.Ih) {
            d.m1479d(j, 0);
        }
    }

    private void gp() {
        m3275J(false);
        this.HV = 0;
        this.HW = null;
        this.HX.clear();
        this.Ib.clear();
        this.Ic.clear();
    }

    /* renamed from: a */
    public long m3280a(iv ivVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long fU = fU();
        this.Ie.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject.put("requestId", fU);
            jSONObject.put("type", "GET_STATUS");
            if (this.HW != null) {
                jSONObject.put("mediaSessionId", this.HW.fR());
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject.toString(), fU, null);
        return fU;
    }

    /* renamed from: a */
    public long m3281a(iv ivVar, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long fU = fU();
        this.Ic.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject2.put("requestId", fU);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", fR());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject2.toString(), fU, null);
        return fU;
    }

    /* renamed from: a */
    public long m3282a(iv ivVar, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long fU = fU();
        this.Ib.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject2.put("requestId", fU);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", fR());
            jSONObject2.put("currentTime", in.m1450o(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject2.toString(), fU, null);
        return fU;
    }

    /* renamed from: a */
    public long m3283a(iv ivVar, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long fU = fU();
        this.HX.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject2.put("requestId", fU);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", in.m1450o(j));
            if (jArr != null && jArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject2.toString(), fU, null);
        return fU;
    }

    /* renamed from: a */
    public long m3284a(iv ivVar, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long fU = fU();
        this.Ig.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject.put("requestId", fU);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", fR());
        } catch (JSONException e) {
        }
        m1445a(jSONObject.toString(), fU, null);
        return fU;
    }

    /* renamed from: a */
    public long m3285a(iv ivVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long fU = fU();
        this.HY.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject2.put("requestId", fU);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", fR());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject2.toString(), fU, null);
        return fU;
    }

    /* renamed from: a */
    public long m3286a(iv ivVar, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long fU = fU();
        this.Id.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject2.put("requestId", fU);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", fR());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject2.toString(), fU, null);
        return fU;
    }

    /* renamed from: a */
    public long m3287a(iv ivVar, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long fU = fU();
        this.If.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject.put("requestId", fU);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", fR());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        m1445a(jSONObject.toString(), fU, null);
        return fU;
    }

    public final void aD(String str) {
        this.He.m1470b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    m3277a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.HW = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.Ie.m1479d(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.He.m1472d("received unexpected error: Invalid Player State.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (iw b : this.Ih) {
                    b.m1478b(optLong, RemoteMediaPlayer.STATUS_FAILED, r1);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.HX.m1478b(optLong, RemoteMediaPlayer.STATUS_FAILED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.HX.m1478b(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.He.m1472d("received unexpected error: Invalid Request.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (iw b2 : this.Ih) {
                    b2.m1478b(optLong, RemoteMediaPlayer.STATUS_FAILED, r1);
                }
            }
        } catch (JSONException e) {
            this.He.m1472d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* renamed from: b */
    public long m3288b(iv ivVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long fU = fU();
        this.Ia.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject2.put("requestId", fU);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", fR());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject2.toString(), fU, null);
        return fU;
    }

    /* renamed from: b */
    public void mo1851b(long j, int i) {
        for (iw d : this.Ih) {
            d.m1479d(j, i);
        }
    }

    /* renamed from: c */
    public long m3290c(iv ivVar, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long fU = fU();
        this.HZ.m1477a(fU, ivVar);
        m3275J(true);
        try {
            jSONObject2.put("requestId", fU);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", fR());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m1445a(jSONObject2.toString(), fU, null);
        return fU;
    }

    public long fR() throws IllegalStateException {
        if (this.HW != null) {
            return this.HW.fR();
        }
        throw new IllegalStateException("No current media session");
    }

    public void fV() {
        gp();
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.HV == 0) {
            return 0;
        }
        double playbackRate = this.HW.getPlaybackRate();
        long streamPosition = this.HW.getStreamPosition();
        int playerState = this.HW.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.HV;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (elapsedRealtime <= 0 || streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.HW == null ? null : this.HW.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.HW;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }
}
