package com.huawei.operation.utils;

import android.content.Intent;

/* JADX INFO: loaded from: classes6.dex */
public interface OperationWebActivityIntentBuilder {
    Intent build();

    OperationWebActivityIntentBuilder setBI(String str, String str2, String str3, String str4);

    OperationWebActivityIntentBuilder setFlags(int i);

    OperationWebActivityIntentBuilder setIntType(int i);

    OperationWebActivityIntentBuilder setStringType(String str);
}
