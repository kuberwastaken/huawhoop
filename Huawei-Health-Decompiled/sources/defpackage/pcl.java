package defpackage;

import android.text.TextPaint;

/* JADX INFO: loaded from: classes11.dex */
public class pcl {
    public static float d(String str, float f) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f);
        return textPaint.measureText(str);
    }
}
