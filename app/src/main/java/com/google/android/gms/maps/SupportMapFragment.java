package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0270a;
import com.google.android.gms.dynamic.C0273f;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C0537m.C1138a;
import com.google.android.gms.maps.internal.C0547w;
import com.google.android.gms.maps.internal.C0548x;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
    private GoogleMap akS;
    private final C1093b alD = new C1093b(this);

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$b */
    static class C1093b extends C0270a<C1463a> {
        private final Fragment Mx;
        protected C0273f<C1463a> akW;
        private final List<OnMapReadyCallback> akX = new ArrayList();
        private Activity nB;

        C1093b(Fragment fragment) {
            this.Mx = fragment;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
            nO();
        }

        /* renamed from: a */
        protected void mo2135a(C0273f<C1463a> c0273f) {
            this.akW = c0273f;
            nO();
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (je() != null) {
                ((C1463a) je()).getMapAsync(callback);
            } else {
                this.akX.add(callback);
            }
        }

        public void nO() {
            if (this.nB != null && this.akW != null && je() == null) {
                try {
                    MapsInitializer.initialize(this.nB);
                    this.akW.mo1131a(new C1463a(this.Mx, C0548x.m1974S(this.nB).mo2305j(C1332e.m4013k(this.nB))));
                    for (OnMapReadyCallback mapAsync : this.akX) {
                        ((C1463a) je()).getMapAsync(mapAsync);
                    }
                    this.akX.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$a */
    static class C1463a implements MapLifecycleDelegate {
        private final Fragment Mx;
        private final IMapFragmentDelegate akT;

        public C1463a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.akT = (IMapFragmentDelegate) jx.m1582i(iMapFragmentDelegate);
            this.Mx = (Fragment) jx.m1582i(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.akT.getMapAsync(new C1138a(this) {
                    final /* synthetic */ C1463a alE;

                    /* renamed from: a */
                    public void mo2321a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                        callback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IMapFragmentDelegate nN() {
            return this.akT;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.Mx.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0547w.m1973a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.akT.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1332e.m4012f(this.akT.onCreateView(C1332e.m4013k(inflater), C1332e.m4013k(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.akT.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.akT.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.akT.onInflate(C1332e.m4013k(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.akT.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.akT.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.akT.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.akT.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate nN = nN();
        if (nN == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = nN.getMap();
            if (map == null) {
                return null;
            }
            if (this.akS == null || this.akS.nC().asBinder() != map.asBinder()) {
                this.akS = new GoogleMap(map);
            }
            return this.akS;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        jx.aU("getMapAsync must be called on the main thread.");
        this.alD.getMapAsync(callback);
    }

    protected IMapFragmentDelegate nN() {
        this.alD.nO();
        return this.alD.je() == null ? null : ((C1463a) this.alD.je()).nN();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.alD.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.alD.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.alD.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.alD.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.alD.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.alD.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.alD.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.alD.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.alD.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.alD.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.alD.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
