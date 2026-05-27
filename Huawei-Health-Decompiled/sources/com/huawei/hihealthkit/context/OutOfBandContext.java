package com.huawei.hihealthkit.context;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class OutOfBandContext extends ContextWrapper {
    public abstract OutOfBandData getOutOfBandData();

    public OutOfBandContext(Context context) {
        super(context.getApplicationContext());
    }
}
