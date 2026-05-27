package defpackage;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class oim extends ShareDataInfo implements Serializable {
    private static final long serialVersionUID = 2809903449040264040L;
    private int c;

    public void e(int i) {
        this.c = i;
    }

    public int d() {
        return this.c;
    }
}
