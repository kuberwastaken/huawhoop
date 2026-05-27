package defpackage;

import android.content.Context;
import com.huawei.ui.commonui.R$color;

/* JADX INFO: loaded from: classes7.dex */
public class pkh {
    private static final float[] c = {70.0f, 80.0f, 90.0f, 100.0f};
    private static final float[] e = {68.0f, 76.0f, 84.0f, 92.0f, 100.0f};

    public static boolean a(int i) {
        return i <= 100 && i >= 70;
    }

    public static int c(double d) {
        return d < 70.0d ? (int) ((d / 70.0d) * 62.0d) : d < 90.0d ? ((int) (((d - 70.0d) * 266.0d) / 20.0d)) + 64 : (int) (((double) 332) + ((((double) 128) * (d - 90.0d)) / 10.0d));
    }

    public static int b(Context context, int i, boolean z) {
        if (context == null || !a(i)) {
            return 0;
        }
        if (z) {
            if (i >= 90) {
                return context.getResources().getColor(R$color.blood_oxygen_level_deep_green_color);
            }
            return context.getResources().getColor(R$color.blood_oxygen_level_orange_color);
        }
        if (i >= 90) {
            return context.getResources().getColor(R$color.blood_oxygen_level_deep_green_selected_color);
        }
        return context.getResources().getColor(R$color.blood_oxygen_level_orange_selected_color);
    }

    public static int e(Context context, int i) {
        if (context == null || !a(i)) {
            return 0;
        }
        if (i >= 90) {
            return context.getResources().getColor(R$color.blood_oxygen_level_deep_green_selected_color);
        }
        return context.getResources().getColor(R$color.blood_oxygen_level_orange_selected_color);
    }

    public static float[] e(boolean z) {
        if (z) {
            return (float[]) e.clone();
        }
        return (float[]) c.clone();
    }
}
