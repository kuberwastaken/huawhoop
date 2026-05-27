package com.huawei.openalliance.ad;

import android.os.FileObserver;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class dm extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f6950a;

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (i == 16) {
            if (hq.a()) {
                hq.a("FileListener", "CLOSE_NOWRITE, path= %s", str);
            }
            d(str);
        } else {
            if (i != 32) {
                return;
            }
            if (hq.a()) {
                hq.a("FileListener", "OPEN, path= %s", str);
            }
            c(str);
        }
    }

    public boolean a(String str) {
        if (hq.a()) {
            hq.a("FileListener", "accessMap = %s", Arrays.asList(this.f6950a));
        }
        return b(str);
    }

    private void d(String str) {
        if (hq.a()) {
            hq.a("FileListener", "setNotAccessed, accessMap = %s", Arrays.asList(this.f6950a));
        }
        if (this.f6950a.containsKey(str)) {
            if (this.f6950a.get(str).intValue() <= 1) {
                this.f6950a.remove(str);
            } else {
                Map<String, Integer> map = this.f6950a;
                map.put(str, Integer.valueOf(map.get(str).intValue() - 1));
            }
        }
    }

    private void c(String str) {
        Map<String, Integer> map;
        int iValueOf;
        if (hq.a()) {
            hq.a("FileListener", "setNotAccessed, accessMap = %s", Arrays.asList(this.f6950a));
        }
        hq.a("FileListener", "setAccessed, accessMap = %s", Arrays.asList(this.f6950a));
        if (this.f6950a.containsKey(str)) {
            map = this.f6950a;
            iValueOf = Integer.valueOf(map.get(str).intValue() + 1);
        } else {
            map = this.f6950a;
            iValueOf = 1;
        }
        map.put(str, iValueOf);
    }

    private boolean b(String str) {
        return this.f6950a.containsKey(str) && this.f6950a.get(str).intValue() > 0;
    }

    public dm(String str) {
        super(str);
        this.f6950a = new ConcurrentHashMap();
    }

    public dm(File file) {
        super(file);
        this.f6950a = new ConcurrentHashMap();
    }
}
