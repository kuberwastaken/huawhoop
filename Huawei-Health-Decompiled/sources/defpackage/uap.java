package defpackage;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class uap implements IBaseResponseCallback {
    private static final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f18239a;
    private Handler b;
    private List<Object> c;
    private int d;

    public uap(Handler handler, int i) {
        synchronized (e) {
            this.d = i;
        }
        this.b = handler;
        this.c = new ArrayList(this.d);
        this.f18239a = new int[this.d];
        for (int i2 = 0; i2 < this.d; i2++) {
            this.f18239a[i2] = -1;
        }
    }

    @Override // com.huawei.hwbasemgr.IBaseResponseCallback
    public void onResponse(int i, Object obj) {
        synchronized (e) {
            this.d--;
            this.c.add(obj);
            int[] iArr = this.f18239a;
            int i2 = this.d;
            iArr[i2] = i;
            if (i2 == 0) {
                Message messageObtainMessage = this.b.obtainMessage();
                messageObtainMessage.what = 102;
                messageObtainMessage.obj = this.c;
                this.b.sendMessage(messageObtainMessage);
            }
        }
    }
}
