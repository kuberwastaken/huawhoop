package defpackage;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.main.R$string;

/* JADX INFO: loaded from: classes8.dex */
public class uin {
    public static final String b = BaseApplication.getAppPackage();

    public static class b {
        public static String a(int i) {
            Context context = BaseApplication.getContext();
            if (i == 2) {
                return context.getString(R$string.IDS_privacy_measure_with_wrong_posture);
            }
            if (i == 3) {
                return context.getString(R$string.IDS_privacy_measure_no_remain_stationary);
            }
            if (i == 4) {
                return context.getString(R$string.IDS_privacy_measure_after_exercise);
            }
            if (i == 5) {
                return context.getString(R$string.IDS_privacy_measure_wear_wrongly);
            }
            if (i != 9) {
                return i != 10 ? "" : context.getString(R$string.IDS_privacy_measure_wear_loose);
            }
            return context.getString(R$string.IDS_privacy_measure_abnomal_heart_rate);
        }
    }
}
