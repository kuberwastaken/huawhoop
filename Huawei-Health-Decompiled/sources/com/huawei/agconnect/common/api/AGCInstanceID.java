package com.huawei.agconnect.common.api;

import android.content.Context;
import com.huawei.agconnect.common.aaid.AaidUtils;
import com.huawei.agconnect.common.aaid.HMSInstanceIdWrapper;
import com.huawei.agconnect.common.aaid.PushPreferences;

/* JADX INFO: loaded from: classes3.dex */
public class AGCInstanceID {
    private final PushPreferences preferences;
    private final HMSInstanceIdWrapper wrapper;

    public String getId() {
        return this.wrapper.a() ? this.wrapper.d() : AaidUtils.a(this.preferences);
    }

    public long getCreationTime() {
        if (this.wrapper.a()) {
            return this.wrapper.c();
        }
        try {
            if (!this.preferences.a(AaidUtils.b)) {
                getId();
            }
            return this.preferences.d(AaidUtils.b);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public void deleteAAID() {
        if (this.wrapper.a()) {
            this.wrapper.b();
        } else if (this.preferences.a(AaidUtils.f1731a)) {
            this.preferences.f(AaidUtils.f1731a);
            this.preferences.f(AaidUtils.b);
        }
    }

    public static AGCInstanceID getInstance(Context context) {
        return new AGCInstanceID(context);
    }

    private AGCInstanceID(Context context) {
        this.wrapper = new HMSInstanceIdWrapper(context);
        this.preferences = new PushPreferences(context, AaidUtils.f1731a);
    }
}
