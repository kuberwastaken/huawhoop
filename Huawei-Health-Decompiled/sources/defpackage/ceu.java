package defpackage;

import android.text.TextUtils;
import com.huawei.devicesdk.entity.ReceiveDataInterface;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ceu implements ReceiveDataInterface {
    private Map<String, ReceiveDataInterface> d;

    private ceu() {
        this.d = new ConcurrentHashMap();
    }

    public void d(String str, ReceiveDataInterface receiveDataInterface) {
        if (str == null || receiveDataInterface == null) {
            return;
        }
        this.d.put(str, receiveDataInterface);
    }

    @Override // com.huawei.devicesdk.entity.ReceiveDataInterface
    public void clearDevice(String str) {
        if (!TextUtils.isEmpty(str) && this.d.containsKey(str)) {
            this.d.remove(str).clearDevice(str);
        }
    }

    @Override // com.huawei.devicesdk.entity.ReceiveDataInterface
    public void clearReceiveDataByUuid(String str, String str2) {
        ReceiveDataInterface receiveDataInterface;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (receiveDataInterface = this.d.get(str)) == null) {
            return;
        }
        receiveDataInterface.clearReceiveDataByUuid(str, str2);
    }

    public static ceu b() {
        return b.e;
    }

    static class b {
        private static ceu e = new ceu();
    }
}
