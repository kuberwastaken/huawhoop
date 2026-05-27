package defpackage;

import android.content.Context;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public class pcf {
    public static String d(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                String str2 = new String(bArr, "utf-8");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return str2;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void b(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
