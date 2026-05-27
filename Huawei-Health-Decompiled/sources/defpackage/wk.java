package defpackage;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class wk {
    public static float c(float f) {
        return new BigDecimal(Double.toString(Double.parseDouble(String.valueOf(f)))).setScale(1, 4).floatValue();
    }
}
