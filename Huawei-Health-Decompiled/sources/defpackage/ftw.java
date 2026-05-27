package defpackage;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.health.messagecenter.model.MessageConstant;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftw implements IRequest {

    @SerializedName("planId")
    private String c;

    @SerializedName("bestRecords")
    private b d;

    @SerializedName("userBestRecords")
    private a e;

    private ftw(e eVar) {
        this.c = eVar.c;
        this.d = eVar.d;
        this.e = eVar.b;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("6")
        private Integer f13180a;

        @SerializedName("4")
        private Integer b;

        @SerializedName("3")
        private Integer c;

        @SerializedName("103")
        private Integer d;

        @SerializedName("7")
        private Integer e;

        @SerializedName("2")
        private Integer f;

        @SerializedName("1")
        private Integer g;

        @SerializedName("8")
        private Integer h;

        @SerializedName("11")
        private Float i;

        @SerializedName("5")
        private Integer j;

        @SerializedName("9")
        private Float l;

        @SerializedName("10")
        private Integer n;

        @SerializedName(MessageConstant.CERTIFICATE)
        private String o;

        private b(e eVar) {
            this.d = eVar.b;
            this.g = eVar.j;
            this.f = eVar.h;
            this.c = eVar.c;
            this.b = eVar.f13181a;
            this.j = eVar.i;
            this.f13180a = eVar.d;
            this.e = eVar.e;
            this.h = eVar.g;
            this.l = eVar.n;
            this.n = eVar.o;
            this.o = eVar.m;
            this.i = eVar.f;
        }

        public static final class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Integer f13181a;
            private Integer b;
            private Integer c;
            private Integer d;
            private Integer e;
            private Float f;
            private Integer g;
            private Integer h;
            private Integer i;
            private Integer j;
            private String m;
            private Float n;
            private Integer o;

            public e e(Integer num) {
                if (num.intValue() > 0) {
                    this.b = num;
                }
                return this;
            }

            public e i(Integer num) {
                if (num.intValue() > 0) {
                    this.j = num;
                }
                return this;
            }

            public e f(Integer num) {
                if (num.intValue() > 0) {
                    this.h = num;
                }
                return this;
            }

            public e d(Integer num) {
                if (num.intValue() > 0) {
                    this.c = num;
                }
                return this;
            }

            public e a(Integer num) {
                if (num.intValue() > 0) {
                    this.f13181a = num;
                }
                return this;
            }

            public e g(Integer num) {
                if (num.intValue() > 0) {
                    this.i = num;
                }
                return this;
            }

            public e c(Integer num) {
                if (num.intValue() > 0) {
                    this.d = num;
                }
                return this;
            }

            public e b(Integer num) {
                if (num.intValue() > 0) {
                    this.e = num;
                }
                return this;
            }

            public e j(Integer num) {
                if (num.intValue() > 0) {
                    this.g = num;
                }
                return this;
            }

            public e e(Float f) {
                if (f.floatValue() > 0.0f) {
                    this.n = f;
                }
                return this;
            }

            public e h(Integer num) {
                if (num.intValue() > 0) {
                    this.o = num;
                }
                return this;
            }

            public e a(String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.m = str;
                }
                return this;
            }

            public e c(Float f) {
                if (f.floatValue() > 0.0f) {
                    this.f = f;
                }
                return this;
            }

            public b b() {
                return new b(this);
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("206")
        private Integer f13178a;

        @SerializedName("204")
        private Integer b;

        @SerializedName("207")
        private Integer c;

        @SerializedName("205")
        private Integer e;

        private a(C0320a c0320a) {
            this.b = c0320a.c;
            this.e = c0320a.f13179a;
            this.f13178a = c0320a.d;
            this.c = c0320a.e;
        }

        /* JADX INFO: renamed from: ftw$a$a, reason: collision with other inner class name */
        public static final class C0320a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Integer f13179a;
            private Integer c;
            private Integer d;
            private Integer e;

            public C0320a c(Integer num) {
                if (num.intValue() > 0) {
                    this.c = num;
                }
                return this;
            }

            public C0320a d(Integer num) {
                if (num.intValue() > 0) {
                    this.f13179a = num;
                }
                return this;
            }

            public C0320a b(Integer num) {
                if (num.intValue() > 0) {
                    this.d = num;
                }
                return this;
            }

            public C0320a e(Integer num) {
                if (num.intValue() > 0) {
                    this.e = num;
                }
                return this;
            }

            public a a() {
                return new a(this);
            }
        }
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bc();
    }

    public static final class e {
        private a b;
        private String c;
        private b d;

        public e b(String str) {
            this.c = str;
            return this;
        }

        public e e(b bVar) {
            this.d = bVar;
            return this;
        }

        public e a(a aVar) {
            this.b = aVar;
            return this;
        }

        public ftw b() {
            return new ftw(this);
        }
    }
}
