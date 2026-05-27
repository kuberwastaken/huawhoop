package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.health.R;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes9.dex */
public class StringResourceValueReader {
    private final Resources zzeu;
    private final String zzev;

    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zzeu = resources;
        this.zzev = resources.getResourcePackageName(R.string._2130851904_res_0x7f023840);
    }

    @Nullable
    public String getString(String str) {
        int identifier = this.zzeu.getIdentifier(str, "string", this.zzev);
        if (identifier == 0) {
            return null;
        }
        return this.zzeu.getString(identifier);
    }
}
