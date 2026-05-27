package defpackage;

import com.huawei.haf.application.BaseApplication;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ehc {
    private static List<String> d = Arrays.asList("IndoorEquipDisplayActivity", "IndoorEquipLandDisplayActivity", "SportBaseActivity", "CoachActivity");

    public static String e() {
        return BaseApplication.xE_() == null ? "" : BaseApplication.xE_().getClass().getSimpleName();
    }

    public static boolean b() {
        return d.contains(e());
    }
}
