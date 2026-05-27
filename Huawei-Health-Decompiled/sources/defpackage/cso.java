package defpackage;

import android.os.RemoteException;
import com.huawei.harmonyos.interwork.base.ability.IInitCallBack;
import com.huawei.harmonyos.interwork.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class cso extends e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Set<cso>> f12022a = new HashMap();
    private final IInitCallBack e;

    private cso(IInitCallBack iInitCallBack) {
        if (iInitCallBack == null) {
            throw new NullPointerException("No callback specified");
        }
        this.e = iInitCallBack;
    }

    public static cso a(String str, IInitCallBack iInitCallBack) {
        Map<String, Set<cso>> map = f12022a;
        synchronized (map) {
            Set<cso> set = map.get(str);
            if (set == null) {
                HashSet hashSet = new HashSet();
                cso csoVar = new cso(iInitCallBack);
                hashSet.add(csoVar);
                map.put(str, hashSet);
                return csoVar;
            }
            for (cso csoVar2 : set) {
                if (csoVar2.e == iInitCallBack) {
                    return csoVar2;
                }
            }
            cso csoVar3 = new cso(iInitCallBack);
            set.add(csoVar3);
            return csoVar3;
        }
    }

    public static cso d(String str, IInitCallBack iInitCallBack) {
        Map<String, Set<cso>> map = f12022a;
        synchronized (map) {
            Set<cso> set = map.get(str);
            if (set == null) {
                return null;
            }
            Iterator<cso> it = set.iterator();
            while (it.hasNext()) {
                cso next = it.next();
                if (next.e == iInitCallBack) {
                    it.remove();
                    if (set.isEmpty()) {
                        f12022a.remove(str);
                    }
                    return next;
                }
            }
            return null;
        }
    }

    @Override // com.huawei.harmonyos.interwork.e
    public final void a(String str) throws RemoteException {
        this.e.onInitSuccess(str);
    }

    @Override // com.huawei.harmonyos.interwork.e
    public final void a(String str, int i) throws RemoteException {
        this.e.onInitFailure(str, i);
    }
}
