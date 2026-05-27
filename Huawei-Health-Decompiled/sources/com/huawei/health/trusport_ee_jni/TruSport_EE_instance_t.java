package com.huawei.health.trusport_ee_jni;

/* JADX INFO: loaded from: classes5.dex */
public class TruSport_EE_instance_t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient long f3582a;
    protected transient boolean c;

    protected TruSport_EE_instance_t(long j, boolean z) {
        this.c = z;
        this.f3582a = j;
    }

    public static long e(TruSport_EE_instance_t truSport_EE_instance_t) {
        if (truSport_EE_instance_t == null) {
            return 0L;
        }
        return truSport_EE_instance_t.f3582a;
    }

    protected void finalize() {
        a();
    }

    public void a() {
        synchronized (this) {
            long j = this.f3582a;
            if (j != 0) {
                if (this.c) {
                    this.c = false;
                    trusport_eeJNI.delete_TruSport_EE_instance_t(j);
                }
                this.f3582a = 0L;
            }
        }
    }

    public TruSport_EE_instance_t() {
        this(trusport_eeJNI.new_TruSport_EE_instance_t(), true);
    }
}
