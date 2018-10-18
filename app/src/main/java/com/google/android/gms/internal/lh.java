package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class lh {
    /* renamed from: a */
    public static long m1638a(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return m1639a(inputStream, outputStream, z, 1024);
    }

    /* renamed from: a */
    public static long m1639a(InputStream inputStream, OutputStream outputStream, boolean z, int i) throws IOException {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    m1642b(inputStream);
                    m1642b(outputStream);
                }
            }
        }
        return j;
    }

    /* renamed from: a */
    public static void m1640a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static byte[] m1641a(InputStream inputStream, boolean z) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m1638a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public static void m1642b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: d */
    public static byte[] m1643d(InputStream inputStream) throws IOException {
        return m1641a(inputStream, true);
    }
}
