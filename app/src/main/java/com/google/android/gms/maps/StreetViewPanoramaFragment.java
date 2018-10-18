package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0270a;
import com.google.android.gms.dynamic.C0273f;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C0545u.C1154a;
import com.google.android.gms.maps.internal.C0547w;
import com.google.android.gms.maps.internal.C0548x;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaFragment extends Fragment {
    private final C1091b all = new C1091b(this);
    private StreetViewPanorama alm;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment$b */
    static class C1091b extends C0270a<C1459a> {
        private final Fragment TG;
        protected C0273f<C1459a> akW;
        private final List<OnStreetViewPanoramaReadyCallback> alq = new ArrayList();
        private Activity nB;

        C1091b(Fragment fragment) {
            this.TG = fragment;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
            nO();
        }

        /* renamed from: a */
        protected void mo2135a(C0273f<C1459a> c0273f) {
            this.akW = c0273f;
            nO();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (je() != null) {
                ((C1459a) je()).getStreetViewPanoramaAsync(callback);
            } else {
                this.alq.add(callback);
            }
        }

        public void nO() {
            if (this.nB != null && this.akW != null && je() == null) {
                try {
                    MapsInitializer.initialize(this.nB);
                    this.akW.mo1131a(new C1459a(this.TG, C0548x.m1974S(this.nB).mo2306k(C1332e.m4013k(this.nB))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.alq) {
                        ((C1459a) je()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.alq.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment$a */
    static class C1459a implements StreetViewLifecycleDelegate {
        private final Fragment TG;
        private final IStreetViewPanoramaFragmentDelegate aln;

        public C1459a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.aln = (IStreetViewPanoramaFragmentDelegate) jx.m1582i(iStreetViewPanoramaFragmentDelegate);
            this.TG = (Fragment) jx.m1582i(fragment);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.aln.getStreetViewPanoramaAsync(new C1154a(this) {
                    final /* synthetic */ C1459a alp;

                    /* renamed from: a */
                    public void mo2332a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IStreetViewPanoramaFragmentDelegate nR() {
            return this.aln;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.TG.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                C0547w.m1973a(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.aln.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1332e.m4012f(this.aln.onCreateView(C1332e.m4013k(inflater), C1332e.m4013k(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.aln.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.aln.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.aln.onInflate(C1332e.m4013k(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.aln.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.aln.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.aln.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.aln.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate nR = nR();
        if (nR == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = nR.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.alm == null || this.alm.nQ().asBinder() != streetViewPanorama.asBinder()) {
                this.alm = new StreetViewPanorama(streetViewPanorama);
            }
            return this.alm;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
        this.all.getStreetViewPanoramaAsync(callback);
    }

    protected IStreetViewPanoramaFragmentDelegate nR() {
        this.all.nO();
        return this.all.je() == null ? null : ((C1459a) this.all.je()).nR();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.all.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.all.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.all.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.all.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.all.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.all.setActivity(activity);
        this.all.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.all.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.all.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.all.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.all.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
