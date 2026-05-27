package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f11872a;

    public c(Bundle bundle) {
        this.f11872a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f11872a.put(str, bundle.getString(str));
            }
        }
    }

    public c(HashMap<String, String> map) {
        this.f11872a = new HashMap<>(map);
    }

    public String toString() {
        return "BaseData{time=" + this.f11872a.get("time") + ", name=" + this.f11872a.get("interface_name") + '}';
    }
}
