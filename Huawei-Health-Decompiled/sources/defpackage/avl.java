package defpackage;

import android.content.Context;
import com.huawei.health.R;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes10.dex */
public class avl {
    public static String b(Context context, long j) {
        if (j < 0) {
            return "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern("0.##");
        if ((j >> 40) != 0) {
            return context.getString(R.string._2130852364_res_0x7f023a0c, decimalFormat.format((j / 1048576.0f) / 1048576.0f));
        }
        if (((j >> 30) & 1023) != 0) {
            return context.getString(R.string._2130852360_res_0x7f023a08, decimalFormat.format(j / 1.0737418E9f));
        }
        if (((j >> 20) & 1023) != 0) {
            return context.getString(R.string._2130852362_res_0x7f023a0a, decimalFormat.format(j / 1048576.0f));
        }
        float f = j / 1024.0f;
        return f < 1.0f ? context.getString(R.string._2130852361_res_0x7f023a09, decimalFormat.format(f)) : context.getString(R.string._2130852361_res_0x7f023a09, new BigDecimal(f).setScale(0, 4));
    }
}
