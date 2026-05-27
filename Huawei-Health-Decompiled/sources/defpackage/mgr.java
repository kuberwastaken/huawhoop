package defpackage;

import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mgr {
    public static int b(float f, List<mgj> list) {
        if (f > 360.0f) {
            ReleaseLogUtil.c("Track_AbnormalSkipUtil", "avgSkipSpeed SKIP_SPEED_ABNORMAL", Float.valueOf(f));
            return 1;
        }
        if (mgx.d(list)) {
            return 0;
        }
        for (mgj mgjVar : list) {
            if (mgjVar != null && mgjVar.b() > 360) {
                ReleaseLogUtil.c("Track_AbnormalSkipUtil", "list SKIP_SPEED_ABNORMAL", Integer.valueOf(mgjVar.b()));
                return 1;
            }
        }
        return 0;
    }
}
