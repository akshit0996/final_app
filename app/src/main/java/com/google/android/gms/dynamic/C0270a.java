package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0270a<T extends LifecycleDelegate> {
    private T Tu;
    private Bundle Tv;
    private LinkedList<C0269a> Tw;
    private final C0273f<T> Tx = new C08621(this);

    /* renamed from: com.google.android.gms.dynamic.a$a */
    private interface C0269a {
        /* renamed from: b */
        void mo1132b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a$1 */
    class C08621 implements C0273f<T> {
        final /* synthetic */ C0270a Ty;

        C08621(C0270a c0270a) {
            this.Ty = c0270a;
        }

        /* renamed from: a */
        public void mo1131a(T t) {
            this.Ty.Tu = t;
            Iterator it = this.Ty.Tw.iterator();
            while (it.hasNext()) {
                ((C0269a) it.next()).mo1132b(this.Ty.Tu);
            }
            this.Ty.Tw.clear();
            this.Ty.Tv = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a$6 */
    class C08666 implements C0269a {
        final /* synthetic */ C0270a Ty;

        C08666(C0270a c0270a) {
            this.Ty = c0270a;
        }

        /* renamed from: b */
        public void mo1132b(LifecycleDelegate lifecycleDelegate) {
            this.Ty.Tu.onStart();
        }

        public int getState() {
            return 4;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a$7 */
    class C08677 implements C0269a {
        final /* synthetic */ C0270a Ty;

        C08677(C0270a c0270a) {
            this.Ty = c0270a;
        }

        /* renamed from: b */
        public void mo1132b(LifecycleDelegate lifecycleDelegate) {
            this.Ty.Tu.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    /* renamed from: a */
    private void m505a(Bundle bundle, C0269a c0269a) {
        if (this.Tu != null) {
            c0269a.mo1132b(this.Tu);
            return;
        }
        if (this.Tw == null) {
            this.Tw = new LinkedList();
        }
        this.Tw.add(c0269a);
        if (bundle != null) {
            if (this.Tv == null) {
                this.Tv = (Bundle) bundle.clone();
            } else {
                this.Tv.putAll(bundle);
            }
        }
        mo2135a(this.Tx);
    }

    /* renamed from: b */
    public static void m507b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence b = GooglePlayServicesUtil.m134b(context, isGooglePlayServicesAvailable);
        CharSequence c = GooglePlayServicesUtil.m139c(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (c != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(c);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.aj(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void cG(int i) {
        while (!this.Tw.isEmpty() && ((C0269a) this.Tw.getLast()).getState() >= i) {
            this.Tw.removeLast();
        }
    }

    /* renamed from: a */
    protected void mo2593a(FrameLayout frameLayout) {
        C0270a.m507b(frameLayout);
    }

    /* renamed from: a */
    protected abstract void mo2135a(C0273f<T> c0273f);

    public T je() {
        return this.Tu;
    }

    public void onCreate(final Bundle savedInstanceState) {
        m505a(savedInstanceState, new C0269a(this) {
            final /* synthetic */ C0270a Ty;

            /* renamed from: b */
            public void mo1132b(LifecycleDelegate lifecycleDelegate) {
                this.Ty.Tu.onCreate(savedInstanceState);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        m505a(savedInstanceState, new C0269a(this) {
            final /* synthetic */ C0270a Ty;

            /* renamed from: b */
            public void mo1132b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.Ty.Tu.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.Tu == null) {
            mo2593a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.Tu != null) {
            this.Tu.onDestroy();
        } else {
            cG(1);
        }
    }

    public void onDestroyView() {
        if (this.Tu != null) {
            this.Tu.onDestroyView();
        } else {
            cG(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        m505a(savedInstanceState, new C0269a(this) {
            final /* synthetic */ C0270a Ty;

            /* renamed from: b */
            public void mo1132b(LifecycleDelegate lifecycleDelegate) {
                this.Ty.Tu.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.Tu != null) {
            this.Tu.onLowMemory();
        }
    }

    public void onPause() {
        if (this.Tu != null) {
            this.Tu.onPause();
        } else {
            cG(5);
        }
    }

    public void onResume() {
        m505a(null, new C08677(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.Tu != null) {
            this.Tu.onSaveInstanceState(outState);
        } else if (this.Tv != null) {
            outState.putAll(this.Tv);
        }
    }

    public void onStart() {
        m505a(null, new C08666(this));
    }

    public void onStop() {
        if (this.Tu != null) {
            this.Tu.onStop();
        } else {
            cG(4);
        }
    }
}
