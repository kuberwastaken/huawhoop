package defpackage;

import android.os.Bundle;
import com.huawei.btsportdevice.callback.MessageOrStateCallback;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dwh {
    private MessageOrStateCallback b;
    private List<Integer> c;
    private boolean d;

    public dwh(MessageOrStateCallback messageOrStateCallback, List<Integer> list) {
        this.d = false;
        this.b = messageOrStateCallback;
        this.c = list;
        if (list == null) {
            this.d = true;
        }
    }

    public boolean d(int i) {
        return this.d || this.c.contains(Integer.valueOf(i));
    }

    public void Ui_(int i, Bundle bundle) {
        this.b.onNewMessage(i, bundle);
    }

    public void e(String str) {
        this.b.onStateChange(str);
    }
}
