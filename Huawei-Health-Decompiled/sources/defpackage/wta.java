package defpackage;

import com.huawei.wearengine.p2p.ReceiverCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class wta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18922a;
    private int c;
    private ReceiverCallback d;

    public wta(int i, int i2, ReceiverCallback receiverCallback) {
        this.f18922a = i;
        this.c = i2;
        this.d = receiverCallback;
    }

    public int c() {
        return this.f18922a;
    }

    public int b() {
        return this.c;
    }

    public ReceiverCallback d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof wta) {
            wta wtaVar = (wta) obj;
            return this.f18922a == wtaVar.f18922a && this.c == wtaVar.c;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f18922a), Integer.valueOf(this.c));
    }
}
