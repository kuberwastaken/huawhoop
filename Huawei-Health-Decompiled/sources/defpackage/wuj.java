package defpackage;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes11.dex */
public class wuj {
    public static byte[] fDK_(Bitmap bitmap) {
        if (bitmap == null) {
            wro.d("BitmapUtil", "getBytesByBitmap bitmap == null");
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
            wro.d("BitmapUtil", "The bitmap can't be reconstructed by passing a corresponding inputstream to BitmapFactory.");
            return new byte[0];
        }
        return byteArrayOutputStream.toByteArray();
    }
}
