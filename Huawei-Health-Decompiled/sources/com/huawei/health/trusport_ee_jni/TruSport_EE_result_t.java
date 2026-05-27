package com.huawei.health.trusport_ee_jni;

/* JADX INFO: loaded from: classes5.dex */
public class TruSport_EE_result_t {
    private transient long c;
    protected transient boolean e;

    protected TruSport_EE_result_t(long j, boolean z) {
        this.e = z;
        this.c = j;
    }

    public static long a(TruSport_EE_result_t truSport_EE_result_t) {
        if (truSport_EE_result_t == null) {
            return 0L;
        }
        return truSport_EE_result_t.c;
    }

    protected void finalize() {
        e();
    }

    public void e() {
        synchronized (this) {
            long j = this.c;
            if (j != 0) {
                if (this.e) {
                    this.e = false;
                    trusport_eeJNI.delete_TruSport_EE_result_t(j);
                }
                this.c = 0L;
            }
        }
    }

    public float a() {
        return trusport_eeJNI.TruSport_EE_result_t_total_get(this.c, this);
    }

    public float c() {
        return trusport_eeJNI.TruSport_EE_result_t_active_get(this.c, this);
    }

    public float b() {
        return trusport_eeJNI.TruSport_EE_result_t_resting_get(this.c, this);
    }

    public TruSport_EE_result_t() {
        this(trusport_eeJNI.new_TruSport_EE_result_t(), true);
    }
}
