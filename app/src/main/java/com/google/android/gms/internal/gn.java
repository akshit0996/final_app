package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@ey
public class gn {
    public static final C0444a<Void> wN = new C09721();

    /* renamed from: com.google.android.gms.internal.gn$a */
    public interface C0444a<T> {
        /* renamed from: b */
        T mo1793b(InputStream inputStream);

        T cQ();
    }

    /* renamed from: com.google.android.gms.internal.gn$1 */
    static class C09721 implements C0444a {
        C09721() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo1793b(InputStream inputStream) {
            return m3210c(inputStream);
        }

        /* renamed from: c */
        public Void m3210c(InputStream inputStream) {
            return null;
        }

        public /* synthetic */ Object cQ() {
            return dz();
        }

        public Void dz() {
            return null;
        }
    }

    /* renamed from: a */
    public <T> Future<T> m1328a(final String str, final C0444a<T> c0444a) {
        return gh.submit(new Callable<T>(this) {
            final /* synthetic */ gn wQ;

            public T call() {
                Throwable th;
                Throwable th2;
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection2.connect();
                        int responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode < 200 || responseCode > 299) {
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return c0444a.cQ();
                        }
                        T b = c0444a.mo1793b(httpURLConnection2.getInputStream());
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return b;
                    } catch (Throwable e) {
                        th = e;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        try {
                            gr.m1345d("Error making HTTP request.", th2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return c0444a.cQ();
                        } catch (Throwable th3) {
                            th2 = th3;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th2;
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        gr.m1345d("Error making HTTP request.", th2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return c0444a.cQ();
                    } catch (Throwable e22) {
                        th = e22;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th2;
                    }
                } catch (MalformedURLException e3) {
                    th2 = e3;
                    gr.m1345d("Error making HTTP request.", th2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return c0444a.cQ();
                } catch (IOException e4) {
                    th2 = e4;
                    gr.m1345d("Error making HTTP request.", th2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return c0444a.cQ();
                }
            }
        });
    }
}
