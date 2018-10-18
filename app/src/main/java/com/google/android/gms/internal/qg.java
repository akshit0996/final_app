package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.C1589b;

public class qg implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        final String str = googleTransactionId;
        final String str2 = merchantTransactionId;
        final int i = requestCode;
        googleApiClient.mo926a(new C1589b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            /* renamed from: a */
            protected void m5626a(qh qhVar) {
                qhVar.m4556d(str, str2, i);
                m2447b(Status.Kw);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.mo926a(new C1589b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            /* renamed from: a */
            protected void m5620a(qh qhVar) {
                qhVar.gk(requestCode);
                m2447b(Status.Kw);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.mo926a(new C1589b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            /* renamed from: a */
            protected void m5624a(qh qhVar) {
                qhVar.m4553a(request, requestCode);
                m2447b(Status.Kw);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.mo926a(new C1589b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            /* renamed from: a */
            protected void m5622a(qh qhVar) {
                qhVar.m4554a(request, requestCode);
                m2447b(Status.Kw);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.mo926a(new C1589b(this, googleApiClient) {
            final /* synthetic */ qg awA;

            /* renamed from: a */
            protected void m5628a(qh qhVar) {
                qhVar.m4555a(request);
                m2447b(Status.Kw);
            }
        });
    }
}
