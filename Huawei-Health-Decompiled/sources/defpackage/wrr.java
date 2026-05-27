package defpackage;

import android.os.IBinder;
import com.huawei.wearengine.ClientToken;
import com.huawei.wearengine.common.ApplicationIdManager;
import com.huawei.wearengine.core.common.ClientBinderDied;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class wrr implements ApplicationIdManager {
    private ConcurrentHashMap<Integer, IBinder> b;
    private ConcurrentHashMap<ClientToken, String> e = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Map<Integer, Integer>> c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IBinder.DeathRecipient f18878a = new IBinder.DeathRecipient() { // from class: wrr.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            wro.a("ClientManager", "BinderService binderDied enter");
            Iterator it = wrr.this.e.entrySet().iterator();
            while (it.hasNext()) {
                ClientToken clientToken = (ClientToken) ((Map.Entry) it.next()).getKey();
                if (!clientToken.asBinder().pingBinder()) {
                    wrr.this.d(clientToken);
                    it.remove();
                }
            }
        }
    };
    private ConcurrentHashMap<Integer, String> d = new ConcurrentHashMap<>();

    public wrr(ConcurrentHashMap<Integer, IBinder> concurrentHashMap) {
        this.b = concurrentHashMap;
    }

    public void b(int i, ClientToken clientToken, String str) {
        if (clientToken != null && wru.c(str) && wru.b(i, str)) {
            this.e.put(clientToken, str);
        }
    }

    public IBinder.DeathRecipient fBE_() {
        return this.f18878a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ClientToken clientToken) {
        String str = this.e.get(clientToken);
        for (IBinder iBinder : this.b.values()) {
            if (iBinder instanceof ClientBinderDied) {
                ((ClientBinderDied) iBinder).handleClientBinderDied(str);
            }
        }
        clientToken.asBinder().unlinkToDeath(this.f18878a, 0);
    }

    public void e(int i, int i2, int i3) {
        if (!this.c.containsKey(Integer.valueOf(i))) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
            Map<Integer, Integer> mapPutIfAbsent = this.c.putIfAbsent(Integer.valueOf(i), concurrentHashMap);
            if (mapPutIfAbsent == null) {
                return;
            }
            mapPutIfAbsent.put(Integer.valueOf(i2), Integer.valueOf(i3));
            return;
        }
        Map<Integer, Integer> map = this.c.get(Integer.valueOf(i));
        if (map != null) {
            map.put(Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public int d(int i, int i2) {
        Map<Integer, Integer> map;
        if (this.c.containsKey(Integer.valueOf(i)) && (map = this.c.get(Integer.valueOf(i))) != null) {
            return map.get(Integer.valueOf(i2)).intValue();
        }
        wro.a("ClientManager", "getSdkApiLevel default value");
        return 0;
    }

    @Override // com.huawei.wearengine.common.ApplicationIdManager
    public void setApplicationId(Integer num, String str) {
        this.d.put(num, str);
        wro.a("ClientManager", "set Application pid is " + num + " applicationId is " + str + " mapSize " + this.d.size());
    }

    @Override // com.huawei.wearengine.common.ApplicationIdManager
    public String getApplicationIdByPid(Integer num) {
        wro.a("ClientManager", "getApplication pid is " + num + " mapSize " + this.d.size());
        return this.d.containsKey(num) ? this.d.get(num) : "";
    }
}
