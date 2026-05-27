package com.huawei.health.sport.model;

import com.huawei.hwcommonmodel.fitnessdatatype.HeartZoneConf;
import defpackage.gjg;

/* JADX INFO: loaded from: classes4.dex */
public class CourseEnvParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HeartZoneConf f3066a;
    protected boolean b;
    protected OnInitCompleteListener c;
    protected boolean d = false;
    protected gjg f;

    public interface OnInitCompleteListener {
        void onInitComplete();
    }

    public HeartZoneConf a() {
        return this.f3066a;
    }

    public gjg j() {
        return this.f;
    }

    public boolean h() {
        return this.d;
    }

    public void d(OnInitCompleteListener onInitCompleteListener) {
        this.c = onInitCompleteListener;
    }

    public void e(boolean z) {
        this.b = z;
    }

    public boolean g() {
        return this.b;
    }
}
