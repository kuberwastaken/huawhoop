package defpackage;

import android.app.ActionBar;
import com.huawei.android.app.ActionBarEx;
import com.huawei.hms.framework.common.EmuiUtil;

/* JADX INFO: loaded from: classes6.dex */
public class mlk {
    private static int b = 0;
    private static boolean d = false;
    private static int e = -1;

    public static boolean g() {
        return true;
    }

    public static boolean j() {
        return true;
    }

    static {
        h();
    }

    public static boolean e() {
        return b >= 21;
    }

    public static boolean b() {
        return b >= 17;
    }

    public static boolean c() {
        return e == 50;
    }

    public static boolean d() {
        return e == 60;
    }

    public static boolean a() {
        return e == 81;
    }

    private static void f() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    e = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    e = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    e = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    e = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    e = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    e = 60;
                }
            }
        } catch (RuntimeException unused) {
            mly.b("EmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            mly.b("EmuiUtil", "getEmuiType Exception.", true);
        }
    }

    private static void h() {
        b = i();
        mly.a("EmuiUtil", "getEmuiType emuiVersionCode=" + b, true);
        int i = b;
        if (i >= 15) {
            e = 81;
        } else if (i >= 14) {
            e = 60;
        } else if (i >= 11) {
            e = 50;
        } else if (i >= 10) {
            e = 41;
        } else if (i >= 9) {
            e = 40;
        } else if (i >= 8) {
            e = 31;
        } else if (i >= 7) {
            e = 30;
        }
        if (e == -1) {
            f();
        }
        d = n();
        mly.c("EmuiUtil", " init emui version is" + e + ", hasActionBarEx=" + d, true);
    }

    private static int i() {
        int iIntValue;
        Object objD = mmb.d(EmuiUtil.BUILDEX_VERSION, EmuiUtil.EMUI_SDK_INT);
        if (objD != null) {
            try {
                iIntValue = ((Integer) objD).intValue();
            } catch (ClassCastException unused) {
                mly.b("EmuiUtil", "getEMUIVersionCode is not a number", true);
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        mly.a("EmuiUtil", "the emui version code is::" + iIntValue, true);
        return iIntValue;
    }

    private static boolean n() {
        boolean z = true;
        try {
            if (e != -1) {
                ActionBarEx.getDragAnimationStage((ActionBar) null);
            } else {
                z = false;
            }
            return z;
        } catch (Exception unused) {
            mly.b("EmuiUtil", "ActionBarEx class not found: ", true);
            return false;
        }
    }
}
