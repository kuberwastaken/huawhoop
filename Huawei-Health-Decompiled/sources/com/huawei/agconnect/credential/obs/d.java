package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.analytics.connector.ConnectorManager;
import com.huawei.hms.analytics.instance.CallBack;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConnectorManager f1817a;
    f b;

    @Override // com.huawei.agconnect.credential.obs.c
    public final void syncOaid(com.huawei.agconnect.credential.obs.a aVar) {
        if (aVar == null) {
            return;
        }
        ConnectorManager connectorManager = this.f1817a;
        if (connectorManager == null) {
            aVar.result(-101, "Ha sdk init failed");
            return;
        }
        try {
            connectorManager.syncOaid(new a(aVar));
        } catch (Throwable th) {
            Log.w("BridgeInstance", "syncOaid error, " + th.getMessage());
        }
    }

    @Override // com.huawei.agconnect.credential.obs.c
    public final void c(boolean z) {
        ConnectorManager connectorManager = this.f1817a;
        if (connectorManager != null) {
            connectorManager.setEnableAndroidID(Boolean.valueOf(z));
        }
    }

    @Override // com.huawei.agconnect.credential.obs.c
    public final Map<String, String> b(boolean z) {
        ConnectorManager connectorManager = this.f1817a;
        return connectorManager != null ? connectorManager.getUserProfiles(z) : new HashMap();
    }

    @Override // com.huawei.agconnect.credential.obs.c
    public final void a(boolean z) {
        ConnectorManager connectorManager = this.f1817a;
        if (connectorManager != null) {
            try {
                connectorManager.setAnalyticsEnabled(z);
            } catch (Throwable th) {
                Log.w("BridgeInstance", "setAnalyticsEnabled: " + th.getMessage());
            }
        }
    }

    @Override // com.huawei.agconnect.credential.obs.c
    public final void a(String str, Bundle bundle) {
        ConnectorManager connectorManager = this.f1817a;
        if (connectorManager != null) {
            connectorManager.onEvent(str, bundle);
        }
    }

    final void a(Context context, f fVar) {
        this.b = fVar;
        try {
            if (TextUtils.isEmpty(fVar.c)) {
                this.f1817a = new ConnectorManager(context, fVar.f1820a, fVar.b);
            } else {
                this.f1817a = new ConnectorManager(context, fVar.f1820a, fVar.b, fVar.c);
            }
        } catch (Exception | NoClassDefFoundError unused) {
            Log.e("BridgeInstance", "createInstance error");
            this.f1817a = null;
        }
    }

    final class a implements CallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.agconnect.credential.obs.a f1818a;

        public final void onResult(int i, String str) {
            this.f1818a.result(i, str);
        }

        a(com.huawei.agconnect.credential.obs.a aVar) {
            this.f1818a = aVar;
        }
    }

    @Override // com.huawei.agconnect.credential.obs.c
    public final void a() {
        ConnectorManager connectorManager = this.f1817a;
        if (connectorManager != null) {
            connectorManager.onReport();
        }
    }

    @Override // com.huawei.agconnect.credential.obs.c
    public final Map<String, String[]> a(String str) {
        if (this.f1817a == null) {
            return new HashMap();
        }
        if (TextUtils.isEmpty(str)) {
            Log.w("BridgeInstance", "Invalid parameter.");
            return new HashMap();
        }
        try {
            return this.f1817a.getDataUploadSiteInfo(str);
        } catch (Throwable th) {
            Log.w("BridgeInstance", "getDataUploadSiteInfo error. " + th.getMessage());
            return new HashMap();
        }
    }

    public d(Context context, f fVar) {
        a(context, fVar);
    }
}
