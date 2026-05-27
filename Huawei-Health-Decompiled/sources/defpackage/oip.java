package defpackage;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class oip extends ShareDataInfo implements Serializable {
    private static final long serialVersionUID = 2809903449040264040L;
    private int b;
    private int e;

    public int b() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int c() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }
}
