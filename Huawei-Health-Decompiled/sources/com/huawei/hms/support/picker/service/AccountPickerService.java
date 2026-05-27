package com.huawei.hms.support.picker.service;

import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.HuaweiApiInterface;

/* JADX INFO: loaded from: classes5.dex */
public interface AccountPickerService extends HuaweiApiInterface {
    Task<Void> cancelAuthorization(String str);

    Intent signIn();

    Intent signInByMcp();

    Task<Void> signOut();
}
