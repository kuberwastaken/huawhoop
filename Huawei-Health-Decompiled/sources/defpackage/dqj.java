package defpackage;

import com.huawei.operation.utils.Constants;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dqj extends dqk {
    private static final long serialVersionUID = 6242432055193497137L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12361a;
    private int b;
    private String c;
    private a d;
    private List<d> e;

    public String e() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public a a() {
        return this.d;
    }

    public void b(a aVar) {
        this.d = aVar;
    }

    public String d() {
        return this.f12361a;
    }

    public void d(String str) {
        this.f12361a = str;
    }

    public void a(List<d> list) {
        this.e = list;
    }

    public static class a implements Serializable {
        private static final long serialVersionUID = -563906258663973150L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12362a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private Integer j;
        private String o;

        public String c() {
            return this.h;
        }

        public void g(String str) {
            this.h = str;
        }

        public void f(String str) {
            this.i = str;
        }

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public String a() {
            return this.f;
        }

        public void j(String str) {
            this.f = str;
        }

        public String e() {
            return this.g;
        }

        public void i(String str) {
            this.g = str;
        }

        public void e(String str) {
            this.f12362a = str;
        }

        public String b() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void a(String str) {
            this.e = str;
        }

        public void h(String str) {
            this.o = str;
        }

        public void c(Integer num) {
            this.j = num;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("DevInfo{sn =");
            String str = this.h;
            Object obj = Constants.NULL;
            stringBuffer.append(str == null ? Constants.NULL : dna.b(str)).append("'model =");
            String str2 = this.i;
            if (str2 == null) {
                str2 = Constants.NULL;
            }
            stringBuffer.append(str2).append("'devType =");
            String str3 = this.d;
            if (str3 == null) {
                str3 = Constants.NULL;
            }
            stringBuffer.append(str3).append("'prodId =");
            String str4 = this.f;
            stringBuffer.append(str4 == null ? Constants.NULL : dna.b(str4)).append("'hiv =");
            String str5 = this.f12362a;
            if (str5 == null) {
                str5 = Constants.NULL;
            }
            stringBuffer.append(str5).append("'mac =");
            String str6 = this.c;
            stringBuffer.append(str6 == null ? Constants.NULL : dna.b(str6)).append("'fwv =");
            String str7 = this.b;
            if (str7 == null) {
                str7 = Constants.NULL;
            }
            stringBuffer.append(str7).append("'hwv =");
            String str8 = this.e;
            if (str8 == null) {
                str8 = Constants.NULL;
            }
            stringBuffer.append(str8).append("'swv =");
            String str9 = this.o;
            if (str9 == null) {
                str9 = Constants.NULL;
            }
            stringBuffer.append(str9).append("'protType =");
            Integer num = this.j;
            if (num != null) {
                obj = num;
            }
            stringBuffer.append(obj).append("'}");
            return stringBuffer.toString();
        }
    }

    public static class d implements Serializable {
        private static final long serialVersionUID = 2699365370799290470L;
        private String d;
        private String e;

        public void e(String str) {
            this.e = str;
        }

        public void c(String str) {
            this.d = str;
        }
    }

    @Override // defpackage.dqk
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CoapDiscoverDeviceEntityModel{errorCode =");
        stringBuffer.append(b());
        StringBuffer stringBufferAppend = stringBuffer.append("devInfo =");
        Object obj = this.d;
        Object obj2 = Constants.NULL;
        if (obj == null) {
            obj = Constants.NULL;
        }
        stringBufferAppend.append(obj).append("'mode =");
        stringBuffer.append(this.b).append("'services =");
        List<d> list = this.e;
        if (list != null) {
            obj2 = list;
        }
        stringBuffer.append(obj2).append("'}");
        return stringBuffer.toString();
    }
}
