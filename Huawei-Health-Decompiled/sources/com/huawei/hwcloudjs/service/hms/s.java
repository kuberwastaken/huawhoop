package com.huawei.hwcloudjs.service.hms;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s f6455a = new s();
    private final Map<String, Parcelable> b = new HashMap();

    public PendingIntent b(String str) {
        synchronized (this.b) {
            Parcelable parcelable = this.b.get(str);
            if (!(parcelable instanceof PendingIntent)) {
                return null;
            }
            return (PendingIntent) parcelable;
        }
    }

    public void a(String str, Intent intent) {
        synchronized (this.b) {
            this.b.put(str, intent);
        }
    }

    public void a(String str, PendingIntent pendingIntent) {
        synchronized (this.b) {
            this.b.put(str, pendingIntent);
        }
    }

    public Intent a(String str) {
        synchronized (this.b) {
            Parcelable parcelable = this.b.get(str);
            if (!(parcelable instanceof Intent)) {
                return null;
            }
            return (Intent) parcelable;
        }
    }

    public static s a() {
        return f6455a;
    }
}
