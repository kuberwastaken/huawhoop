package com.huawei.health.trusport_ee_jni;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class TruSport_EE_sample_t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected transient boolean f3584a;
    private transient long d;

    protected TruSport_EE_sample_t(long j, boolean z) {
        this.f3584a = z;
        this.d = j;
    }

    public static long e(TruSport_EE_sample_t truSport_EE_sample_t) {
        if (truSport_EE_sample_t == null) {
            return 0L;
        }
        return truSport_EE_sample_t.d;
    }

    protected void finalize() {
        a();
    }

    public void a() {
        synchronized (this) {
            long j = this.d;
            if (j != 0) {
                if (this.f3584a) {
                    this.f3584a = false;
                    trusport_eeJNI.delete_TruSport_EE_sample_t(j);
                }
                this.d = 0L;
            }
        }
    }

    public void e(BigInteger bigInteger) {
        trusport_eeJNI.TruSport_EE_sample_t_timestamp_set(this.d, this, bigInteger);
    }

    public void c(float f) {
        trusport_eeJNI.TruSport_EE_sample_t_speed_set(this.d, this, f);
    }

    public void b(float f) {
        trusport_eeJNI.TruSport_EE_sample_t_steprate_set(this.d, this, f);
    }

    public void d(short s) {
        trusport_eeJNI.TruSport_EE_sample_t_hr_set(this.d, this, s);
    }

    public TruSport_EE_sample_t() {
        this(trusport_eeJNI.new_TruSport_EE_sample_t(), true);
    }
}
