package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.C0271c.C0869a;

/* renamed from: com.google.android.gms.dynamic.b */
public final class C1331b extends C0869a {
    private Fragment TG;

    private C1331b(Fragment fragment) {
        this.TG = fragment;
    }

    /* renamed from: a */
    public static C1331b m4009a(Fragment fragment) {
        return fragment != null ? new C1331b(fragment) : null;
    }

    /* renamed from: d */
    public void mo1134d(C0272d c0272d) {
        this.TG.registerForContextMenu((View) C1332e.m4012f(c0272d));
    }

    /* renamed from: e */
    public void mo1135e(C0272d c0272d) {
        this.TG.unregisterForContextMenu((View) C1332e.m4012f(c0272d));
    }

    public Bundle getArguments() {
        return this.TG.getArguments();
    }

    public int getId() {
        return this.TG.getId();
    }

    public boolean getRetainInstance() {
        return this.TG.getRetainInstance();
    }

    public String getTag() {
        return this.TG.getTag();
    }

    public int getTargetRequestCode() {
        return this.TG.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.TG.getUserVisibleHint();
    }

    public C0272d getView() {
        return C1332e.m4013k(this.TG.getView());
    }

    public boolean isAdded() {
        return this.TG.isAdded();
    }

    public boolean isDetached() {
        return this.TG.isDetached();
    }

    public boolean isHidden() {
        return this.TG.isHidden();
    }

    public boolean isInLayout() {
        return this.TG.isInLayout();
    }

    public boolean isRemoving() {
        return this.TG.isRemoving();
    }

    public boolean isResumed() {
        return this.TG.isResumed();
    }

    public boolean isVisible() {
        return this.TG.isVisible();
    }

    public C0272d jf() {
        return C1332e.m4013k(this.TG.getActivity());
    }

    public C0271c jg() {
        return C1331b.m4009a(this.TG.getParentFragment());
    }

    public C0272d jh() {
        return C1332e.m4013k(this.TG.getResources());
    }

    public C0271c ji() {
        return C1331b.m4009a(this.TG.getTargetFragment());
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.TG.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.TG.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.TG.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.TG.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.TG.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.TG.startActivityForResult(intent, requestCode);
    }
}
