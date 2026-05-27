package com.huawei.openalliance.ad;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.n;

/* JADX INFO: loaded from: classes6.dex */
public interface g {
    n.a a();

    Object a(Context context, String str);

    void a(Activity activity);

    void a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);

    void a(String str);

    void b(String str);
}
