package defpackage;

import com.huawei.health.marketing.datatype.ResourceBriefInfo;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public class fic implements Comparator, Serializable {
    private static final long serialVersionUID = 1712882890291443210L;

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (!(obj instanceof ResourceBriefInfo) || !(obj2 instanceof ResourceBriefInfo)) {
            return 1;
        }
        ResourceBriefInfo resourceBriefInfo = (ResourceBriefInfo) obj;
        ResourceBriefInfo resourceBriefInfo2 = (ResourceBriefInfo) obj2;
        if (resourceBriefInfo2.getPriority() > resourceBriefInfo.getPriority()) {
            return 1;
        }
        if (resourceBriefInfo2.getPriority() < resourceBriefInfo.getPriority()) {
            return -1;
        }
        return Long.compare(resourceBriefInfo2.getEffectiveTime(), resourceBriefInfo.getEffectiveTime());
    }
}
