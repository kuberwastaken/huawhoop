package com.huawei.health.motiontrack.api;

import android.app.Activity;
import android.content.Context;
import com.huawei.basefitnessadvice.callback.UiCallback;
import com.huawei.ui.commonui.model.ICityLatLonCallBack;
import defpackage.pip;

/* JADX INFO: loaded from: classes4.dex */
public interface LocationApi {
    void getLocation(Context context, ICityLatLonCallBack iCityLatLonCallBack, UiCallback uiCallback);

    pip getUserLocation(Activity activity);
}
