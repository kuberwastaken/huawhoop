package com.huawei.openalliance.ad;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public final class hs extends ho {
    @Override // com.huawei.openalliance.ad.hv
    public void a(hx hxVar, int i, String str) {
        if (hxVar == null) {
            return;
        }
        a(hxVar.b(), i, str);
        if (this.f7165a != null) {
            this.f7165a.a(hxVar, i, str);
        }
    }

    @Override // com.huawei.openalliance.ad.hv
    public hv a(String str, String str2) {
        if (this.f7165a != null) {
            this.f7165a.a(str, str2);
        }
        return this;
    }

    private void a(String str, int i, String str2) {
        if (str == null) {
            return;
        }
        if (i == 3) {
            Log.d(str2, str);
            return;
        }
        if (i != 4) {
            if (i == 5) {
                Log.w(str2, str);
                return;
            } else if (i == 6) {
                Log.e(str2, str);
                return;
            }
        }
        Log.i(str2, str);
    }

    public static hv a() {
        return new hs();
    }

    private hs() {
    }
}
