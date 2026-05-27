package com.huawei.health.trusport_ee_jni;

import defpackage.hse;

/* JADX INFO: loaded from: classes5.dex */
public class TruSport_EE_profile_t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient long f3583a;
    protected transient boolean d;

    protected TruSport_EE_profile_t(long j, boolean z) {
        this.d = z;
        this.f3583a = j;
    }

    public static long e(TruSport_EE_profile_t truSport_EE_profile_t) {
        if (truSport_EE_profile_t == null) {
            return 0L;
        }
        return truSport_EE_profile_t.f3583a;
    }

    protected void finalize() {
        c();
    }

    public void c() {
        synchronized (this) {
            long j = this.f3583a;
            if (j != 0) {
                if (this.d) {
                    this.d = false;
                    trusport_eeJNI.delete_TruSport_EE_profile_t(j);
                }
                this.f3583a = 0L;
            }
        }
    }

    public void b(short s) {
        trusport_eeJNI.TruSport_EE_profile_t_age_set(this.f3583a, this, s);
    }

    public void e(float f) {
        trusport_eeJNI.TruSport_EE_profile_t_height_set(this.f3583a, this, f);
    }

    public void b(float f) {
        trusport_eeJNI.TruSport_EE_profile_t_weight_set(this.f3583a, this, f);
    }

    public void e(hse hseVar) {
        trusport_eeJNI.TruSport_EE_profile_t_sex_set(this.f3583a, this, hseVar.e());
    }

    public TruSport_EE_profile_t() {
        this(trusport_eeJNI.new_TruSport_EE_profile_t(), true);
    }
}
