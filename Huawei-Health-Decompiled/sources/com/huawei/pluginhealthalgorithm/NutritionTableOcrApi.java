package com.huawei.pluginhealthalgorithm;

import android.content.Context;
import android.graphics.Bitmap;
import com.huawei.health.h5pro.jsbridge.base.JsModuleBase;

/* JADX INFO: loaded from: classes9.dex */
public interface NutritionTableOcrApi {
    String getNutritionTableOcrResult(Context context, Bitmap bitmap);

    Class<? extends JsModuleBase> getOcrJsApi(String str);

    void release();
}
