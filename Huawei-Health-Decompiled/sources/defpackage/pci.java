package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public class pci {
    public static Bitmap cGs_(Context context, String str) {
        return BitmapFactory.decodeStream(b(context, str));
    }

    public static InputStream b(Context context, String str) {
        pcj.b("AssetsHelper", pcj.a());
        try {
            return context.getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            pcj.b("AssetsHelper", pcj.a() + " e=" + e.getMessage());
            return null;
        }
    }
}
