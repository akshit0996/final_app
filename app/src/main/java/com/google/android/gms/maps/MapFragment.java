package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.google.android.gms.maps.internal.C0537m.C1138a;
import com.google.android.gms.maps.internal.C0547w;
import com.google.android.gms.maps.internal.C0548x;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {
    private final C1089b akR = new C1089b(this);
    private GoogleMap akS;

    /* renamed from: com.google.android.gms.maps.MapFragment$b */
    static class C1089b extends C0270a<C1452a> {
        private final Fragment TG;
        protected C0273f<C1452a> akW;
        private final List<OnMapReadyCallback> akX = new ArrayList();
        private Activity nB;

        C1089b(Fragment fragment) {
            this.TG = fragment;
        }

        private void setActivity(Activity activity) {
            this.nB = activity;
            nO();
        }

        /* renamed from: a */
        protected void mo2135a(C0273f<C1452a> c0273f) {
            this.akW = c0273f;
            nO();
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (je() != null) {
                ((C1452a) je()).getMapAsync(callback);
            } else {
                this.akX.add(callback);
            }
        }

        public void nO() {
            if (this.nB != null && this.akW != null && je() == null) {
                try {
                    MapsInitializer.initialize(this.nB);
                    this.akW.mo1131a(new C1452a(this.TG, C0548x.m1974S(this.nB).mo2305j(C1332e.m4013k(this.nB))));
                    for (OnMapReadyCallback mapAsync : this.akX) {
                        ((C1452a) je()).getMapAsync(mapAsync);
                    }
                    this.akX.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment$a */
    static class C1452a implements MapLifecycleDelegate {
        private final Fragment TG;
        private final IMapFragmentDelegate akT;

        public C1452a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.akT = (IMapFragmentDelegate) jx.m1582i(iMapFragmentDelegate);
            this.TG = (Fragment) jx.m1582i(fragment);
        }

        public void getMapAsync(final OnMapReadyCallback callback) {
            try {
                this.akT.getMapAsync(new C1138a(this) {
                    final /* synthetic */ C1452a akV;

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
            Bundle arguments = this.TG.getArguments();
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

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
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
        this.akR.getMapAsync(callback);
    }

    protected IMapFragmentDelegate nN() {
        this.akR.nO();
        return this.akR.je() == null ? null : ((C1452a) this.akR.je()).nN();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.akR.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.akR.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.akR.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.akR.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.akR.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.akR.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.akR.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.akR.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.akR.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.akR.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.akR.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
