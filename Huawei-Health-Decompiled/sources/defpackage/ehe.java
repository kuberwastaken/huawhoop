package defpackage;

import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class ehe {
    private static final DecimalFormat c = new DecimalFormat("###.#");

    public static String e(int i) {
        StringBuilder sb = new StringBuilder(16);
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        sb.setLength(0);
        if (i4 > 0) {
            return formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString();
        }
        return formatter.format("%d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }

    public static String b(long j) {
        return c.format(j / 60.0f);
    }
}
