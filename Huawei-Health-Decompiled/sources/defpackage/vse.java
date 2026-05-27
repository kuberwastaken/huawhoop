package defpackage;

import android.text.TextUtils;
import com.huawei.unitedevice.p2p.P2pReceiver;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class vse {
    private String b;
    private String c;
    private String d;
    private P2pReceiver e;

    public vse(String str, String str2, String str3, P2pReceiver p2pReceiver) {
        this.c = str;
        this.d = str2;
        this.b = str3;
        this.e = p2pReceiver;
    }

    public String a() {
        return this.c;
    }

    public P2pReceiver b() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof vse) {
            vse vseVar = (vse) obj;
            boolean zEquals = TextUtils.isEmpty(this.c) ? true : this.c.equals(vseVar.c);
            if (zEquals && !TextUtils.isEmpty(this.d)) {
                zEquals = this.d.equals(vseVar.d);
            }
            return (!zEquals || TextUtils.isEmpty(this.b)) ? zEquals : this.d.equals(vseVar.d);
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, this.b);
    }
}
