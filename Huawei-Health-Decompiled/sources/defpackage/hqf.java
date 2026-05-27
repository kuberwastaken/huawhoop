package defpackage;

import com.huawei.health.threeCircle.remind.model.ThreeCircleRemindData;
import com.huawei.operation.utils.Constants;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes5.dex */
public class hqf {
    private PriorityQueue<ThreeCircleRemindData> c = new PriorityQueue<>(3, new Comparator() { // from class: hqi
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return hqf.a((ThreeCircleRemindData) obj, (ThreeCircleRemindData) obj2);
        }
    });

    static /* synthetic */ int a(ThreeCircleRemindData threeCircleRemindData, ThreeCircleRemindData threeCircleRemindData2) {
        return threeCircleRemindData.getPriority() - threeCircleRemindData2.getPriority();
    }

    public void a(ThreeCircleRemindData threeCircleRemindData) {
        synchronized (this) {
            ReleaseLogUtil.d("R_REMIND_DATA_QUEUE", "offer data:", threeCircleRemindData.getRemindType(), threeCircleRemindData.getSubRemindType(), threeCircleRemindData.getRemindText());
            this.c.offer(threeCircleRemindData);
            while (this.c.size() > 1) {
                ThreeCircleRemindData threeCircleRemindDataPoll = this.c.poll();
                if (threeCircleRemindDataPoll != null) {
                    ReleaseLogUtil.d("R_REMIND_DATA_QUEUE", "poll data:", threeCircleRemindDataPoll.getRemindType());
                }
            }
        }
    }

    public ThreeCircleRemindData d() {
        ThreeCircleRemindData threeCircleRemindDataPeek;
        synchronized (this) {
            threeCircleRemindDataPeek = this.c.peek();
            Object[] objArr = new Object[2];
            objArr[0] = "peek:";
            objArr[1] = threeCircleRemindDataPeek == null ? Constants.NULL : threeCircleRemindDataPeek.getRemindType();
            ReleaseLogUtil.d("R_REMIND_DATA_QUEUE", objArr);
        }
        return threeCircleRemindDataPeek;
    }

    public void c() {
        synchronized (this) {
            ReleaseLogUtil.d("R_REMIND_DATA_QUEUE", "postProcess clear");
            this.c.clear();
        }
    }
}
