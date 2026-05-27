package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.huawei.health.R;
import com.huawei.wear.wallet.ui.dialog.WidgetBuilder;

/* JADX INFO: loaded from: classes11.dex */
public class woh {
    private static final String e = "com.huawei.wear.wallet.ui.dialog.HwDialogUtil";

    public static void fzC_(Dialog dialog, int i, double d, boolean z) {
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            int dimensionPixelOffset = dialog.getContext().getResources().getDimensionPixelOffset(R.dimen._2131362028_res_0x7f0a00ec);
            String str = e;
            vwc.e(str, "setDialogWidthAndHeight [dialog] phone not pad or open");
            attributes.y = i;
            attributes.gravity = 81;
            int iE = wok.e(dialog.getContext());
            int iA = wok.a(dialog.getContext());
            vwc.e(str, "setDialogWidthAndHeight [dialog] phone width | height : " + iE + " | " + iA);
            if (iE > iA) {
                attributes.width = iA - (dimensionPixelOffset * 2);
            } else {
                attributes.width = iE - (dimensionPixelOffset * 2);
            }
            vwc.e(str, "setDialogWidthAndHeight [dialog] lp w | h: " + attributes.width + " | " + attributes.height);
            window.setAttributes(attributes);
        }
    }

    public static void fzz_(boolean z, Dialog dialog) {
        if (z) {
            return;
        }
        dialog.dismiss();
    }

    public static void fzA_(View view, View view2, View view3) {
        if (view2.getVisibility() == 0 && view3.getVisibility() == 0) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static void fzF_(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static void fzB_(Context context, LinearLayout linearLayout) {
        int i;
        context.getResources().getConfiguration();
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen._2131362027_res_0x7f0a00eb);
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.heightPixels / 5;
        } else {
            i = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        if (WidgetBuilder.b(context) || wok.b(context) == 1) {
            vwc.e(e, "setDialogWidth [dialog] phone pad or open");
            wok.a(context);
            int iE = wok.e(context);
            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen._2131362029_res_0x7f0a00ed);
            layoutParams.height = -2;
            int i2 = iE - (dimensionPixelOffset * 2);
            if (dimensionPixelOffset2 > i2) {
                layoutParams.width = i2;
                layoutParams.setMargins(0, i, 0, 0);
                return;
            } else {
                layoutParams.width = dimensionPixelOffset2;
                layoutParams.setMargins(0, 0, 0, 0);
                return;
            }
        }
        layoutParams.width = wok.e(context) - (dimensionPixelOffset * 2);
        layoutParams.setMargins(0, 0, 0, 0);
        String str = e;
        vwc.e(str, "setDialogWidth [dialog] phone not pad or open w | h: " + layoutParams.width + " | " + layoutParams.height);
        vwc.e(str, "setDialogWidth [dialog] lp top | w | h: " + i + "|" + layoutParams.width + " | " + layoutParams.height);
        linearLayout.setLayoutParams(layoutParams);
    }

    public static void fzE_(final TextView textView, TextView textView2, Context context, int i) {
        if (textView2.getVisibility() == 0 || textView.getVisibility() != 0) {
            return;
        }
        textView.setPadding(0, context.getResources().getDimensionPixelOffset(i), 0, 0);
        textView.post(new Runnable() { // from class: woh.4
            @Override // java.lang.Runnable
            public void run() {
                if (textView.getLineCount() == 1) {
                    textView.setGravity(1);
                } else {
                    textView.setGravity(GravityCompat.START);
                }
            }
        });
    }

    public static void fzD_(Dialog dialog, int i, double d) {
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (WidgetBuilder.b(dialog.getContext())) {
                int dimensionPixelOffset = dialog.getContext().getResources().getDimensionPixelOffset(R.dimen._2131362027_res_0x7f0a00eb);
                int dimensionPixelOffset2 = dialog.getContext().getResources().getDimensionPixelOffset(R.dimen._2131362029_res_0x7f0a00ed);
                int iE = wok.e(dialog.getContext());
                attributes.height = -2;
                int i2 = iE - dimensionPixelOffset;
                if (dimensionPixelOffset2 > i2) {
                    attributes.width = i2;
                } else {
                    attributes.width = dimensionPixelOffset2;
                }
            } else {
                int dimensionPixelOffset3 = dialog.getContext().getResources().getDimensionPixelOffset(R.dimen._2131362027_res_0x7f0a00eb);
                vwc.e(e, "current dialog device is not pad");
                attributes.y = i;
                attributes.gravity = 80;
                int iE2 = wok.e(dialog.getContext());
                int iA = wok.a(dialog.getContext());
                if (iE2 > iA) {
                    attributes.width = iA - (dimensionPixelOffset3 * 2);
                } else {
                    attributes.width = iE2 - (dimensionPixelOffset3 * 2);
                }
            }
            window.setAttributes(attributes);
        }
    }
}
