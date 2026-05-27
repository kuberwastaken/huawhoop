package defpackage;

import android.content.res.Resources;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes7.dex */
public class sve {
    private static sve c;
    private static final Object e = new Object();

    public static sve b() {
        sve sveVar;
        synchronized (e) {
            if (c == null) {
                c = new sve();
            }
            sveVar = c;
        }
        return sveVar;
    }

    public float dPZ_(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (float) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public float dQa_(Paint paint, String str) {
        if (str.length() == 0) {
            return 0.0f;
        }
        return paint.measureText(str, 0, str.length());
    }

    public float dPY_(Paint paint, String str) {
        if (str.length() == 0) {
            return 0.0f;
        }
        return dPZ_(paint) * str.length();
    }

    public static float b(int i, float f) {
        return TypedValue.applyDimension(i, f, Resources.getSystem().getDisplayMetrics());
    }
}
