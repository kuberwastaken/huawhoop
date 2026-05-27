package defpackage;

import com.huawei.health.device.model.RecordAction;

/* JADX INFO: loaded from: classes6.dex */
class mzi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15959a;
    private String b;

    mzi(String str, String str2) {
        this.f15959a = str;
        this.b = str2;
    }

    public String b() {
        return this.f15959a;
    }

    public String a() {
        return this.b;
    }

    public String toString() {
        return RecordAction.ACT_NAME_TAG + this.f15959a + ", value=" + this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mzi)) {
            return false;
        }
        mzi mziVar = (mzi) obj;
        return d(this.f15959a, mziVar.f15959a) && d(this.b, mziVar.b);
    }

    private boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
