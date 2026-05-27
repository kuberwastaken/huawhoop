package defpackage;

import com.huawei.wearengine.notify.Action;
import com.huawei.wearengine.notify.NotificationTemplate;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public class wsq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18910a;
    private HashMap<Integer, String> b;
    private Action c;
    private int d;
    private String e;
    private int f;
    private String g;
    private String i;

    private wsq(b bVar) {
        this.d = bVar.c;
        this.e = bVar.f18911a;
        this.i = bVar.f;
        this.g = bVar.j;
        this.b = bVar.b;
        this.f = bVar.i;
        this.f18910a = bVar.d;
        this.c = bVar.e;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f18911a;
        private HashMap<Integer, String> b;
        private Action e;
        private String f;
        private String j;
        private int c = -1;
        private int i = 2;
        private int d = -1;

        public b a(NotificationTemplate notificationTemplate) {
            this.c = notificationTemplate == null ? -1 : notificationTemplate.value();
            return this;
        }

        public b e(String str) {
            this.f18911a = str;
            return this;
        }

        public b c(String str) {
            this.f = str;
            return this;
        }

        public b a(String str) {
            this.j = str;
            return this;
        }

        public b e(HashMap<Integer, String> map) {
            this.b = map;
            return this;
        }

        public b b(Action action) {
            this.e = action;
            return this;
        }

        public wsq c() {
            return new wsq(this);
        }
    }

    public int c() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String f() {
        return this.i;
    }

    public String a() {
        return this.g;
    }

    public HashMap<Integer, String> e() {
        return this.b;
    }

    public Action d() {
        return this.c;
    }
}
