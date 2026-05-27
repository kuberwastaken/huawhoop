package defpackage;

import android.text.TextUtils;
import com.huawei.hihealthservice.hihealthkit.cpcheck.OnRequestCallBack;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class kbd<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f14578a;
    private final String b;
    private final OnRequestCallBack<T> c;
    private final Map<String, Object> d;
    private final boolean e;
    private final String f;

    private kbd(b<T> bVar) {
        this.f = ((b) bVar).j;
        this.c = ((b) bVar).f14579a;
        this.b = ((b) bVar).d;
        this.d = ((b) bVar).b;
        this.f14578a = ((b) bVar).e;
        this.e = ((b) bVar).c;
    }

    public Map<String, Object> d() {
        return this.f14578a;
    }

    public String e() {
        return this.b;
    }

    public String a() {
        return this.f;
    }

    public Map<String, Object> c() {
        return this.d;
    }

    public OnRequestCallBack<T> b() {
        return this.c;
    }

    public boolean j() {
        return this.e;
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private OnRequestCallBack<T> f14579a;
        private Map<String, Object> b;
        private boolean c;
        private String d;
        private Map<String, Object> e;
        private String j;

        public b(String str) {
            this.j = str;
        }

        public b<T> a(OnRequestCallBack<T> onRequestCallBack) {
            this.f14579a = onRequestCallBack;
            return this;
        }

        public b<T> e(String str) {
            this.d = str;
            return this;
        }

        public b<T> e(Map<String, Object> map) {
            this.b = map;
            return this;
        }

        public b<T> d(Map<String, Object> map) {
            this.e = map;
            return this;
        }

        public b<T> b(boolean z) {
            this.c = z;
            return this;
        }

        public kbd<T> b() {
            if (TextUtils.isEmpty(this.j)) {
                throw new IllegalArgumentException("the url is empty");
            }
            if (this.f14579a == null) {
                throw new IllegalArgumentException("the OnRequestCallBack is null");
            }
            if (this.b == null) {
                this.b = new HashMap(10);
            }
            if (this.e == null) {
                this.e = new HashMap(10);
            }
            if (TextUtils.isEmpty(this.d)) {
                this.d = "GET";
            }
            return new kbd<>(this);
        }
    }
}
