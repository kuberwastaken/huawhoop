package com.huawei.hihealth.util;

import android.text.TextUtils;
import com.huawei.hihealth.api.SyncApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HealthSyncUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<SyncApi> f4309a = new ArrayList();

    private HealthSyncUtil() {
    }

    public static boolean d(SyncApi syncApi) {
        boolean zAdd;
        if (syncApi == null) {
            throw new IllegalArgumentException("add api is null");
        }
        List<SyncApi> list = f4309a;
        synchronized (list) {
            if (list.contains(syncApi)) {
                throw new IllegalArgumentException("api " + syncApi.getClass().getSimpleName() + " existed");
            }
            zAdd = list.add(syncApi);
        }
        return zAdd;
    }

    public static void d(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("label is invalid");
        }
        synchronized (f4309a) {
            i = -1;
            int i2 = 0;
            while (true) {
                List<SyncApi> list = f4309a;
                if (i2 >= list.size()) {
                    break;
                }
                SyncApi syncApi = list.get(i2);
                if (str.equals(syncApi.getLabel())) {
                    syncApi.syncCloud();
                    i = i2;
                }
                i2++;
            }
        }
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException("label " + str + " not existed");
    }

    public static void e(String str, boolean z, Object obj) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("label is invalid");
        }
        List<SyncApi> list = f4309a;
        synchronized (list) {
            z2 = false;
            for (SyncApi syncApi : list) {
                if (str.equals(syncApi.getLabel())) {
                    syncApi.cleanCloud(z, obj);
                    z2 = true;
                }
            }
        }
        if (z2) {
            return;
        }
        throw new IllegalArgumentException("label " + str + " not existed");
    }

    public static boolean b(SyncApi syncApi) {
        boolean zRemove;
        if (syncApi == null) {
            throw new IllegalArgumentException("removeSyncModule api is null");
        }
        List<SyncApi> list = f4309a;
        synchronized (list) {
            zRemove = list.remove(syncApi);
        }
        return zRemove;
    }
}
