package defpackage;

import android.graphics.Color;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ayr {
    public static int d(int i, float f) {
        Color colorValueOf = Color.valueOf(i);
        return Color.valueOf(colorValueOf.red(), colorValueOf.green(), colorValueOf.blue(), f).toArgb();
    }

    public static awi e(List<awi> list) {
        for (awi awiVar : list) {
            if (awiVar.b() >= 0.08f) {
                return awiVar;
            }
        }
        return list.get(0);
    }
}
