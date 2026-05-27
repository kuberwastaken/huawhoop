package defpackage;

import com.huawei.wearengine.device.Device;

/* JADX INFO: loaded from: classes11.dex */
public class wsz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Device f18919a;
    private String b;
    private String c;

    protected wsz(d dVar) {
        this.f18919a = dVar.f18920a;
        this.c = dVar.b;
        this.b = dVar.d;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Device f18920a;
        private String b;
        private String d;

        public d b(Device device) {
            this.f18920a = device;
            return this;
        }

        public d a(String str) {
            this.b = str;
            return this;
        }

        public d b(String str) {
            this.d = str;
            return this;
        }

        public wsz c() {
            return new wsz(this);
        }
    }

    public Device c() {
        return this.f18919a;
    }

    public String e() {
        return this.c;
    }

    public String d() {
        return this.b;
    }
}
