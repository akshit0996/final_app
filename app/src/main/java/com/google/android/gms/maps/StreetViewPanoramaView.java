package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0270a;
import com.google.android.gms.dynamic.C0273f;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C0545u.C1154a;
import com.google.android.gms.maps.internal.C0548x;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama alm;
    private final C1092b aly;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$b */
    static class C1092b extends C0270a<C1461a> {
        protected C0273f<C1461a> akW;
        private final StreetViewPanoramaOptions alC;
        private final ViewGroup ald;
        private final List<OnStreetViewPanoramaReadyCallback> alq = new ArrayList();
        private final Context mContext;

        C1092b(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.ald = viewGroup;
            this.mContext = context;
            this.alC = streetViewPanoramaOptions;
        }

        /* renamed from: a */
        protected void mo2135a(C0273f<C1461a> c0273f) {
            this.akW = c0273f;
            nO();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (je() != null) {
                ((C1461a) je()).getStreetViewPanoramaAsync(callback);
            } else {
                this.alq.add(callback);
            }
        }

        public void nO() {
            if (this.akW != null && je() == null) {
                try {
                    this.akW.mo1131a(new C1461a(this.ald, C0548x.m1974S(this.mContext).mo2302a(C1332e.m4013k(this.mContext), this.alC)));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.alq) {
                        ((C1461a) je()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.alq.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$a */
    static class C1461a implements StreetViewLifecycleDelegate {
        private final ViewGroup akZ;
        private View alA;
        private final IStreetViewPanoramaViewDelegate alz;

        public C1461a(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.alz = (IStreetViewPanoramaViewDelegate) jx.m1582i(iStreetViewPanoramaViewDelegate);
            this.akZ = (ViewGroup) jx.m1582i(viewGroup);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.alz.getStreetViewPanoramaAsync(new C1154a(this) {
                    final /* synthetic */ C1461a alB;

                    /* renamed from: a */
                    public void mo2332a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IStreetViewPanoramaViewDelegate nV() {
            return this.alz;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.alz.onCreate(savedInstanceState);
                this.alA = (View) C1332e.m4012f(this.alz.getView());
                this.akZ.removeAllViews();
                this.akZ.addView(this.alA);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.alz.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.alz.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.alz.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.alz.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.alz.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.aly = new C1092b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.aly = new C1092b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.aly = new C1092b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.aly = new C1092b(this, context, options);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.alm != null) {
            return this.alm;
        }
        this.aly.nO();
        if (this.aly.je() == null) {
            return null;
        }
        try {
            this.alm = new StreetViewPanorama(((C1461a) this.aly.je()).nV().getStreetViewPanorama());
            return this.alm;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
        this.aly.getStreetViewPanoramaAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.aly.onCreate(savedInstanceState);
        if (this.aly.je() == null) {
            C0270a.m507b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.aly.onDestroy();
    }

    public final void onLowMemory() {
        this.aly.onLowMemory();
    }

    public final void onPause() {
        this.aly.onPause();
    }

    public final void onResume() {
        this.aly.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.aly.onSaveInstanceState(outState);
    }
}
