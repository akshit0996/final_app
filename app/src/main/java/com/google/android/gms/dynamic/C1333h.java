package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.C0271c.C0869a;

/* renamed from: com.google.android.gms.dynamic.h */
public final class C1333h extends C0869a {
    private Fragment Mx;

    private C1333h(Fragment fragment) {
        this.Mx = fragment;
    }

    /* renamed from: a */
    public static C1333h m4014a(Fragment fragment) {
        return fragment != null ? new C1333h(fragment) : null;
    }

    /* renamed from: d */
    public void mo1134d(C0272d c0272d) {
        this.Mx.registerForContextMenu((View) C1332e.m4012f(c0272d));
    }

    /* renamed from: e */
    public void mo1135e(C0272d c0272d) {
        this.Mx.unregisterForContextMenu((View) C1332e.m4012f(c0272d));
    }

    public Bundle getArguments() {
        return this.Mx.getArguments();
    }

    public int getId() {
        return this.Mx.getId();
    }

    public boolean getRetainInstance() {
        return this.Mx.getRetainInstance();
    }

    public String getTag() {
        return this.Mx.getTag();
    }

    public int getTargetRequestCode() {
        return this.Mx.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Mx.getUserVisibleHint();
    }

    public C0272d getView() {
        return C1332e.m4013k(this.Mx.getView());
    }

    public boolean isAdded() {
        return this.Mx.isAdded();
    }

    public boolean isDetached() {
        return this.Mx.isDetached();
    }

    public boolean isHidden() {
        return this.Mx.isHidden();
    }

    public boolean isInLayout() {
        return this.Mx.isInLayout();
    }

    public boolean isRemoving() {
        return this.Mx.isRemoving();
    }

    public boolean isResumed() {
        return this.Mx.isResumed();
    }

    public boolean isVisible() {
        return this.Mx.isVisible();
    }

    public C0272d jf() {
        return C1332e.m4013k(this.Mx.getActivity());
    }

    public C0271c jg() {
        return C1333h.m4014a(this.Mx.getParentFragment());
    }

    public C0272d jh() {
        return C1332e.m4013k(this.Mx.getResources());
    }

    public C0271c ji() {
        return C1333h.m4014a(this.Mx.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Mx.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Mx.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Mx.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Mx.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Mx.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Mx.startActivityForResult(intent, requestCode);
    }
}
