package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int li;
    private final int lj;

    public UrlTileProvider(int width, int height) {
        this.li = width;
        this.lj = height;
    }

    /* renamed from: a */
    private static long m3602a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: e */
    private static byte[] m3603e(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m3602a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final Tile getTile(int x, int y, int zoom) {
        URL tileUrl = getTileUrl(x, y, zoom);
        if (tileUrl == null) {
            return NO_TILE;
        }
        try {
            return new Tile(this.li, this.lj, m3603e(tileUrl.openStream()));
        } catch (IOException e) {
            return null;
        }
    }

    public abstract URL getTileUrl(int i, int i2, int i3);
}