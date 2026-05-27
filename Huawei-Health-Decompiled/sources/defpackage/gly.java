package defpackage;

import com.huawei.health.sportservice.utils.SmoothDataParser;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes10.dex */
public class gly implements SmoothDataParser {
    private Queue<Float> e = new LinkedList();
    private float d = 0.0f;

    @Override // com.huawei.health.sportservice.utils.SmoothDataParser
    public float getAverage(float f) {
        Float fPoll;
        this.e.offer(Float.valueOf(f));
        if (this.e.size() > 6 && (fPoll = this.e.poll()) != null) {
            this.d -= fPoll.floatValue();
        }
        float f2 = this.d + f;
        this.d = f2;
        return f2 / this.e.size();
    }

    @Override // com.huawei.health.sportservice.utils.SmoothDataParser
    public void clear() {
        this.e.clear();
        this.d = 0.0f;
    }
}
