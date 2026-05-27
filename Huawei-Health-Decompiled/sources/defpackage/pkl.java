package defpackage;

import android.content.Context;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes7.dex */
public class pkl {
    public static int e(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int e(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen._2131362012_res_0x7f0a00dc);
    }
}
