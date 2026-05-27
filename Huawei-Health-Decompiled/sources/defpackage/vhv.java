package defpackage;

import android.util.Base64;
import health.compact.a.WhiteBoxManager;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes9.dex */
public class vhv {
    public static String d(int i, int i2, int i3, int i4) {
        WhiteBoxManager whiteBoxManagerC = WhiteBoxManager.c();
        return new String(whiteBoxManagerC.d(Base64.decode(whiteBoxManagerC.a(i, i2) + whiteBoxManagerC.a(i, i3) + whiteBoxManagerC.a(i, i4), 0)), StandardCharsets.UTF_8);
    }
}
