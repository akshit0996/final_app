package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C1494a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iu;
import com.google.android.gms.internal.iv;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final it Gw = new C12981(this);
    private final C0797a Gx = new C0797a(this);
    private OnMetadataUpdatedListener Gy;
    private OnStatusUpdatedListener Gz;
    private final Object mH = new Object();

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a */
    private class C0797a implements iu {
        final /* synthetic */ RemoteMediaPlayer GA;
        private GoogleApiClient GN;
        private long GO = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a$a */
        private final class C0796a implements ResultCallback<Status> {
            private final long GP;
            final /* synthetic */ C0797a GQ;

            C0796a(C0797a c0797a, long j) {
                this.GQ = c0797a;
                this.GP = j;
            }

            /* renamed from: j */
            public void m2433j(Status status) {
                if (!status.isSuccess()) {
                    this.GQ.GA.Gw.mo1851b(this.GP, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m2433j((Status) x0);
            }
        }

        public C0797a(RemoteMediaPlayer remoteMediaPlayer) {
            this.GA = remoteMediaPlayer;
        }

        /* renamed from: a */
        public void mo900a(String str, String str2, long j, String str3) throws IOException {
            if (this.GN == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.GN, str, str2).setResultCallback(new C0796a(this, j));
        }

        /* renamed from: b */
        public void m2435b(GoogleApiClient googleApiClient) {
            this.GN = googleApiClient;
        }

        public long fS() {
            long j = this.GO + 1;
            this.GO = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$1 */
    class C12981 extends it {
        final /* synthetic */ RemoteMediaPlayer GA;

        C12981(RemoteMediaPlayer remoteMediaPlayer) {
            this.GA = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.GA.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.GA.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$c */
    private static final class C1300c implements MediaChannelResult {
        private final Status Eb;
        private final JSONObject Ga;

        C1300c(Status status, JSONObject jSONObject) {
            this.Eb = status;
            this.Ga = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.Ga;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$b */
    private static abstract class C1547b extends C1494a<MediaChannelResult> {
        iv GR = new C07981(this);

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$b$1 */
        class C07981 implements iv {
            final /* synthetic */ C1547b GS;

            C07981(C1547b c1547b) {
                this.GS = c1547b;
            }

            /* renamed from: a */
            public void mo902a(long j, int i, JSONObject jSONObject) {
                this.GS.m2447b(new C1300c(new Status(i), jSONObject));
            }

            /* renamed from: n */
            public void mo903n(long j) {
                this.GS.m2447b(this.GS.m4990k(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        C1547b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4990k(status);
        }

        /* renamed from: k */
        public MediaChannelResult m4990k(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ C1547b GS;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public RemoteMediaPlayer() {
        this.Gw.m1444a(this.Gx);
    }

    private void onMetadataUpdated() {
        if (this.Gy != null) {
            this.Gy.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.Gz != null) {
            this.Gz.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.mH) {
            approximateStreamPosition = this.Gw.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.mH) {
            mediaInfo = this.Gw.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.mH) {
            mediaStatus = this.Gw.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.Gw.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.mH) {
            streamDuration = this.Gw.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5259a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(googleApiClient);
                    try {
                        this.GA.Gw.m3283a(this.GR, mediaInfo2, z, j, jArr, jSONObject);
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.Gw.aD(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5261a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(apiClient);
                    try {
                        this.GA.Gw.m3285a(this.GR, customData);
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5265a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(apiClient);
                    try {
                        this.GA.Gw.m3290c(this.GR, customData);
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5253a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(apiClient);
                    try {
                        this.GA.Gw.m3280a(this.GR);
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5267a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(googleApiClient);
                    try {
                        this.GA.Gw.m3282a(this.GR, j, i, jSONObject);
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null && trackIds.length != 0) {
            return apiClient.mo928b(new C1547b(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer GA;

                /* renamed from: a */
                protected void m5255a(im imVar) {
                    synchronized (this.GA.mH) {
                        this.GA.Gx.m2435b(apiClient);
                        try {
                            this.GA.Gw.m3287a(this.GR, trackIds);
                            this.GA.Gx.m2435b(null);
                        } catch (IOException e) {
                            m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                            this.GA.Gx.m2435b(null);
                        } catch (Throwable th) {
                            this.GA.Gx.m2435b(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null or empty");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.Gy = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.Gz = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final boolean z = muteState;
        final JSONObject jSONObject = customData;
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5251a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(googleApiClient);
                    try {
                        this.GA.Gw.m3286a(this.GR, z, jSONObject);
                        this.GA.Gx.m2435b(null);
                    } catch (IllegalStateException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e2) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5269a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(googleApiClient);
                    try {
                        this.GA.Gw.m3281a(this.GR, d, jSONObject);
                        this.GA.Gx.m2435b(null);
                    } catch (IllegalStateException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (IllegalArgumentException e2) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e3) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.mo928b(new C1547b(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer GA;

                /* renamed from: a */
                protected void m5257a(im imVar) {
                    synchronized (this.GA.mH) {
                        this.GA.Gx.m2435b(apiClient);
                        try {
                            this.GA.Gw.m3284a(this.GR, trackStyle);
                            this.GA.Gx.m2435b(null);
                        } catch (IOException e) {
                            m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                            this.GA.Gx.m2435b(null);
                        } catch (Throwable th) {
                            this.GA.Gx.m2435b(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo928b(new C1547b(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer GA;

            /* renamed from: a */
            protected void m5263a(im imVar) {
                synchronized (this.GA.mH) {
                    this.GA.Gx.m2435b(apiClient);
                    try {
                        this.GA.Gw.m3288b(this.GR, customData);
                        this.GA.Gx.m2435b(null);
                    } catch (IOException e) {
                        m2447b(m4990k(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.GA.Gx.m2435b(null);
                    } catch (Throwable th) {
                        this.GA.Gx.m2435b(null);
                    }
                }
            }
        });
    }
}
