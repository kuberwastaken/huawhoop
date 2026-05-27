package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes11.dex */
class wok {
    wok() {
    }

    public static int e(Context context) {
        return fzN_(context).widthPixels;
    }

    private static DisplayMetrics fzN_(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int a(Context context) {
        return fzN_(context).heightPixels;
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (((float) displayMetrics.heightPixels) / ((float) displayMetrics.widthPixels) <= 1.1428572f && context.getResources().getConfiguration().screenHeightDp >= 400) ? 1 : 2;
    }
}
