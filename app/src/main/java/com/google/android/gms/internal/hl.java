package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class hl {

    /* renamed from: com.google.android.gms.internal.hl$a */
    public static class C0977a implements SafeParcelable {
        public static final hm CREATOR = new hm();
        final int CK;
        public final Account Dc;

        public C0977a() {
            this(null);
        }

        C0977a(int i, Account account) {
            this.CK = i;
            this.Dc = account;
        }

        public C0977a(Account account) {
            this(1, account);
        }

        public int describeContents() {
            hm hmVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            hm hmVar = CREATOR;
            hm.m1397a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.hl$b */
    public static class C0978b implements Result, SafeParcelable {
        public static final hn CREATOR = new hn();
        final int CK;
        public Status Dd;
        public List<hr> De;

        public C0978b() {
            this.CK = 1;
        }

        C0978b(int i, Status status, List<hr> list) {
            this.CK = i;
            this.Dd = status;
            this.De = list;
        }

        public int describeContents() {
            hn hnVar = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.Dd;
        }

        public void writeToParcel(Parcel out, int flags) {
            hn hnVar = CREATOR;
            hn.m1400a(this, out, flags);
        }
    }
}
