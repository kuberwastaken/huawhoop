package defpackage;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.main.R$string;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class vec {
    public static int e(int i) {
        if (i >= 1 && i <= 29) {
            return 1;
        }
        if (i <= 29 || i >= 60) {
            return (i < 60 || i >= 80) ? 4 : 3;
        }
        return 2;
    }

    public static String d(int i) {
        return a(e(i));
    }

    private static String a(int i) {
        HashMap map = new HashMap(4);
        map.put(1, BaseApplication.getContext().getResources().getString(R$string.IDS_hw_pressure_relaxed));
        map.put(2, BaseApplication.getContext().getResources().getString(R$string.IDS_hw_pressure_normal));
        map.put(3, BaseApplication.getContext().getResources().getString(R$string.IDS_hw_show_card_pressure_measure_calibrate_grade_item_3));
        map.put(4, BaseApplication.getContext().getResources().getString(R$string.IDS_hw_pressure_highly));
        return (String) map.get(Integer.valueOf(i));
    }

    public static boolean e(List<vea> list) {
        Iterator<vea> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().e() > 0) {
                return true;
            }
        }
        return false;
    }
}
