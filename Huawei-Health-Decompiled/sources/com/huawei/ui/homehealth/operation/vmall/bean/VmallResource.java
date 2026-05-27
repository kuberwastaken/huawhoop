package com.huawei.ui.homehealth.operation.vmall.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import defpackage.rfu;

/* JADX INFO: loaded from: classes7.dex */
public class VmallResource extends rfu {

    @SerializedName("mIsNameVisibility")
    private boolean b;

    @SerializedName("mVmallTitle")
    private String c;

    @SerializedName("mVmallUrl")
    private String d;

    public VmallResource() {
    }

    public VmallResource(String str, boolean z, String str2) {
        this.c = str;
        this.b = z;
        this.d = str2;
    }

    public String c() {
        return this.c;
    }

    public boolean e() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public String a() {
        return this.d;
    }

    @Override // defpackage.rfu
    public boolean d() {
        String str;
        return (this.c == null || (str = this.d) == null || !str.startsWith("http")) ? false : true;
    }

    public boolean d(VmallResource vmallResource) {
        return vmallResource != null && TextUtils.equals(this.d, vmallResource.a()) && TextUtils.equals(this.c, vmallResource.c()) && this.b == vmallResource.e();
    }
}
