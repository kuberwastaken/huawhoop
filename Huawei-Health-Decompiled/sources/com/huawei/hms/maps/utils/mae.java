package com.huawei.hms.maps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class mae extends maa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5226a;
    private Bitmap b;

    @Override // com.huawei.hms.maps.utils.maa
    public Bitmap a(Context context) {
        StringBuilder sb;
        FileInputStream fileInputStreamOpenFileInput = null;
        try {
            try {
                fileInputStreamOpenFileInput = context.openFileInput(this.f5226a);
                this.b = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException e) {
                        e = e;
                        sb = new StringBuilder("generateBitmap close fileInputStream IOException : ");
                        sb.append(e.toString());
                        LogM.d("FileBitmapDescriptor", sb.toString());
                    }
                }
            } catch (IOException e2) {
                LogM.e("FileBitmapDescriptor", "generateBitmap IOException : " + e2.toString());
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder("generateBitmap close fileInputStream IOException : ");
                        sb.append(e.toString());
                        LogM.d("FileBitmapDescriptor", sb.toString());
                    }
                }
            } catch (OutOfMemoryError unused) {
                LogM.e("FileBitmapDescriptor", "generateBitmap OutOfMemoryError: ");
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException e4) {
                        e = e4;
                        sb = new StringBuilder("generateBitmap close fileInputStream IOException : ");
                        sb.append(e.toString());
                        LogM.d("FileBitmapDescriptor", sb.toString());
                    }
                }
            }
            return this.b;
        } catch (Throwable th) {
            if (fileInputStreamOpenFileInput != null) {
                try {
                    fileInputStreamOpenFileInput.close();
                } catch (IOException e5) {
                    LogM.d("FileBitmapDescriptor", "generateBitmap close fileInputStream IOException : " + e5.toString());
                }
            }
            throw th;
        }
    }

    public mae(String str) {
        this.f5226a = str;
    }
}
