package defpackage;

import com.huawei.hihealth.HiUserInfo;
import com.huawei.up.model.UserInfomation;

/* JADX INFO: loaded from: classes3.dex */
public class bzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f554a;
    private int b;
    private int c;
    private float d;
    private int e;

    private float a(float f) {
        if (f <= 0.0f) {
            return 60.0f;
        }
        if (f < 30.0f) {
            return 30.0f;
        }
        if (f > 250.0f) {
            return 250.0f;
        }
        return f;
    }

    private int a(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return (i == -1 || i == 2) ? -1 : 1;
    }

    private float b(float f) {
        if (f <= 0.0f) {
            return 1.7f;
        }
        if (f > 0.0f && f < 0.5f) {
            return 0.5f;
        }
        if (f > 2.5f) {
            return 2.5f;
        }
        return f;
    }

    public bzr(d dVar) {
        this.b = d(dVar.d);
        this.f554a = b(dVar.e);
        this.d = a(dVar.f555a);
        this.e = a(dVar.c);
        this.c = dVar.b;
    }

    /* JADX INFO: loaded from: classes.dex */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f555a;
        private int b;
        private int c;
        private int d;
        private float e;

        public d e(int i) {
            this.d = i;
            return this;
        }

        public d d(float f) {
            this.f555a = f;
            return this;
        }

        public d b(float f) {
            this.e = f;
            return this;
        }

        public d c(int i) {
            this.c = i;
            return this;
        }

        public bzr d() {
            return new bzr(this);
        }
    }

    public int d() {
        return d(this.b);
    }

    public float c() {
        return a(this.d);
    }

    public float b() {
        return b(this.f554a);
    }

    public int e() {
        return a(this.e);
    }

    public int a() {
        return this.c;
    }

    public static bzr d(UserInfomation userInfomation) {
        d dVar = new d();
        if (userInfomation != null) {
            int gender = 1;
            if (userInfomation.getGender() != 0) {
                gender = userInfomation.getGender() == 1 ? 0 : userInfomation.getGender();
            }
            dVar.e(userInfomation.getAge()).b(userInfomation.getHeight() / 100.0f).d(userInfomation.getWeight()).c(gender);
        }
        return dVar.d();
    }

    private int d(int i) {
        if (i <= 0) {
            return new HiUserInfo().getAgeOrDefaultValue();
        }
        if (i < 16) {
            return 16;
        }
        return Math.min(i, 80);
    }
}
