package defpackage;

import com.huawei.health.sportservice.utils.SmoothDataParser;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes10.dex */
public class glu implements SmoothDataParser {
    private Queue<Integer> d = new LinkedList();
    private int c = 0;

    @Override // com.huawei.health.sportservice.utils.SmoothDataParser
    public float getAverage(float f) {
        Integer numPoll;
        this.d.offer(Integer.valueOf((int) f));
        if (this.d.size() > 6 && (numPoll = this.d.poll()) != null) {
            this.c -= numPoll.intValue();
        }
        this.c = (int) (this.c + f);
        return Math.round(r3 / this.d.size());
    }

    @Override // com.huawei.health.sportservice.utils.SmoothDataParser
    public void clear() {
        this.d.clear();
        this.c = 0;
    }
}
