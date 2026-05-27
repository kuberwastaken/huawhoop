package defpackage;

import com.huawei.hwcloudmodel.model.unite.HealthDetail;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public class kgt implements Comparator<HealthDetail>, Serializable {
    private static final long serialVersionUID = 537036553028345437L;

    public static kgt d() {
        return c.c;
    }

    static class c {
        private static final kgt c = new kgt();
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compare(HealthDetail healthDetail, HealthDetail healthDetail2) {
        if (healthDetail == null || healthDetail2 == null) {
            return 0;
        }
        int iE = e(Long.valueOf(healthDetail.getVersion()), Long.valueOf(healthDetail2.getVersion()));
        return iE != 0 ? iE : e(healthDetail.getStartTime(), healthDetail2.getStartTime());
    }

    private int e(Long l, Long l2) {
        long jLongValue = l == null ? 0L : l.longValue();
        long jLongValue2 = l2 != null ? l2.longValue() : 0L;
        if (jLongValue > jLongValue2) {
            return 1;
        }
        return jLongValue < jLongValue2 ? -1 : 0;
    }
}
