package com.huawei.openalliance.ad;

import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class jk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static jk f7379a;
    private static final byte[] b = new byte[0];
    private final byte[] c = new byte[0];
    private final Map<String, Set<a>> d = new HashMap();

    public interface a {
        void a(String str, Intent intent);
    }

    public void b(String str, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        synchronized (this.c) {
            Set<a> set = this.d.get(str);
            if (set != null) {
                set.remove(aVar);
                if (set.isEmpty()) {
                    this.d.remove(str);
                }
            }
        }
    }

    public void a(String str, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        synchronized (this.c) {
            Set<a> hashSet = this.d.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.d.put(str, hashSet);
            }
            hashSet.add(aVar);
        }
    }

    public void a(final String str, final Intent intent) {
        synchronized (this.c) {
            Set<a> set = this.d.get(str);
            if (set != null) {
                for (final a aVar : set) {
                    if (aVar != null) {
                        com.huawei.openalliance.ad.utils.n.a(new Runnable() { // from class: com.huawei.openalliance.ad.jk.1
                            @Override // java.lang.Runnable
                            public void run() {
                                aVar.a(str, intent);
                            }
                        });
                    }
                }
            }
        }
    }

    public static jk a() {
        jk jkVar;
        synchronized (b) {
            if (f7379a == null) {
                f7379a = new jk();
            }
            jkVar = f7379a;
        }
        return jkVar;
    }

    private jk() {
    }
}
