package com.huawei.hms.support.hwid.common.cloudservice;

import android.os.Bundle;
import com.huawei.hwid.core.helper.handler.ErrorStatus;

/* JADX INFO: loaded from: classes10.dex */
public interface CloudRequestHandler {
    void onError(ErrorStatus errorStatus);

    void onFinish(Bundle bundle);
}
