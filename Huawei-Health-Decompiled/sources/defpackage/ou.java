package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayInputStream;
import java.io.Closeable;

/* JADX INFO: loaded from: classes9.dex */
public class ou {
    public static Drawable a(String str, Context context) {
        return by_(str, context, 480);
    }

    public static Drawable by_(String str, Context context, int i) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(np.b(str));
        } catch (Throwable unused) {
            byteArrayInputStream = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (i <= 0) {
                i = 240;
            }
            options.inDensity = i;
            options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(byteArrayInputStream, null, options));
            c(byteArrayInputStream);
            return bitmapDrawable;
        } catch (Throwable unused2) {
            c(byteArrayInputStream);
            return null;
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
