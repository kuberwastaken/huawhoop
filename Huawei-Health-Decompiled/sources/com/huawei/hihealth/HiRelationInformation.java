package com.huawei.hihealth;

import android.content.ContentValues;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class HiRelationInformation {

    @SerializedName("mRelationId")
    private int b;

    @SerializedName("mValueHolder")
    private ContentValues c;

    @SerializedName("mRelationType")
    private int d;

    public int a() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }
}
