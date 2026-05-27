package defpackage;

import com.huawei.ads.adsrec.db.table.AdEventRecord;

/* JADX INFO: loaded from: classes3.dex */
public class apf {
    private AdEventRecord d;

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f250a;
        private String b;
        private Long c;
        private String d;
        private String e;
        private String f;
        private String g;
        private Integer h;
        private Long i;

        public d g(String str) {
            this.b = str;
            return this;
        }

        public d c(String str) {
            this.e = str;
            return this;
        }

        public d d(Long l) {
            this.c = l;
            return this;
        }

        public d b(String str) {
            this.d = str;
            return this;
        }

        public d c(Integer num) {
            this.h = num;
            return this;
        }

        public d d(String str) {
            this.f = str;
            return this;
        }

        public d e(Long l) {
            this.i = l;
            return this;
        }

        public d a(String str) {
            this.f250a = str;
            return this;
        }

        public d e(String str) {
            this.g = str;
            return this;
        }

        public apf d() {
            AdEventRecord adEventRecord = new AdEventRecord();
            adEventRecord.e(this.d);
            adEventRecord.j(this.b);
            adEventRecord.d(this.f250a);
            adEventRecord.a(this.e);
            Long l = this.c;
            if (l != null) {
                adEventRecord.d(l.longValue());
            }
            Integer num = this.h;
            if (num != null) {
                adEventRecord.a(num.intValue());
            }
            adEventRecord.c(this.f);
            Long l2 = this.i;
            if (l2 != null) {
                adEventRecord.e(l2.longValue());
            }
            String str = this.g;
            if (str != null) {
                adEventRecord.b(str);
            }
            return new apf(adEventRecord);
        }
    }

    public String toString() {
        return "AdAffair{" + this.d + '}';
    }

    public AdEventRecord d() {
        return this.d;
    }

    private apf(AdEventRecord adEventRecord) {
        this.d = adEventRecord;
    }
}
