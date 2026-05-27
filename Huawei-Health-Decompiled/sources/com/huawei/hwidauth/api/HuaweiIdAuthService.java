package com.huawei.hwidauth.api;

import android.content.Intent;
import com.huawei.hmf.tasks.Task;

/* JADX INFO: loaded from: classes11.dex */
public interface HuaweiIdAuthService {
    Intent getSignInIntent();

    Task<Void> signOut();
}
