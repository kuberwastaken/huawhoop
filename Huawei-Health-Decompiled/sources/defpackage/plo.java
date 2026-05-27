package defpackage;

import android.graphics.Typeface;
import com.huawei.haf.application.BaseApplication;
import com.huawei.ui.commonui.R$string;

/* JADX INFO: loaded from: classes7.dex */
public class plo {
    public static Typeface cWu_() {
        return Typeface.createFromAsset(BaseApplication.a().getAssets(), "font/HarmonyOSCondensedClockProportional-Medium.ttf");
    }

    public static Typeface cWt_() {
        return Typeface.createFromAsset(BaseApplication.a().getAssets(), "font/hw_digit_medium.otf");
    }

    public static Typeface cWw_() {
        return Typeface.create(BaseApplication.a().getResources().getString(R$string.textFontFamilyMedium), 0);
    }

    public static Typeface cWx_() {
        return Typeface.create(BaseApplication.a().getResources().getString(R$string.textFontFamilyRegular), 0);
    }

    public static Typeface cWv_() {
        return Typeface.createFromAsset(com.huawei.hwcommonmodel.application.BaseApplication.getContext().getAssets(), "fonts/Harmony-Heavy.ttf");
    }

    public static Typeface cWs_() {
        return Typeface.createFromAsset(com.huawei.hwcommonmodel.application.BaseApplication.getContext().getAssets(), "fonts/Anton-Regular.ttf");
    }
}
