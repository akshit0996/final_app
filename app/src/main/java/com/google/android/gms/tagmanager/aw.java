package com.google.android.gms.tagmanager;

import com.google.android.gms.wallet.WalletConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class aw implements bm {
    private HttpURLConnection arE;

    aw() {
    }

    /* renamed from: a */
    private InputStream m3688a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == WalletConstants.ERROR_CODE_INVALID_PARAMETERS) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    /* renamed from: b */
    private void m3689b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public InputStream cF(String str) throws IOException {
        this.arE = cG(str);
        return m3688a(this.arE);
    }

    HttpURLConnection cG(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }

    public void close() {
        m3689b(this.arE);
    }
}
