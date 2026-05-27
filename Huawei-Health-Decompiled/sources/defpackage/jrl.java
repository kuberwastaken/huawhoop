package defpackage;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes9.dex */
public class jrl {
    private ContentValues e;

    public boolean c(int i) {
        return i == -1 || i == -2;
    }

    public jrl(ContentValues contentValues) {
        this.e = contentValues;
    }

    public boolean j() {
        return this.e.getAsBoolean("needCheckAppAuth").booleanValue();
    }

    public String g() {
        return this.e.getAsString("packageName");
    }

    public String c() {
        return this.e.getAsString("dataFilter");
    }

    public boolean f() {
        return e("withoutDefaultZero");
    }

    public String h() {
        return this.e.getAsString("metadataFilter");
    }

    public String e() {
        return this.e.getAsString("deleteDeviceUuid");
    }

    public int a() {
        return b("deleteType");
    }

    public int b() {
        return b("deleteLevel");
    }

    public int d() {
        return b("deleteInterval");
    }

    public int i() {
        return b("sequenceDataType");
    }

    public boolean o() {
        return e("lastDayDetail");
    }

    public boolean m() {
        return e("isGroupByTime");
    }

    private int b(String str) {
        if (!this.e.containsKey(str)) {
            return -1;
        }
        if (this.e.getAsInteger(str) == null) {
            return -2;
        }
        return this.e.getAsInteger(str).intValue();
    }

    private boolean e(String str) {
        ContentValues contentValues = this.e;
        if (contentValues == null || !contentValues.containsKey(str) || this.e.getAsBoolean(str) == null) {
            return false;
        }
        return this.e.getAsBoolean(str).booleanValue();
    }

    public static d b(boolean z) {
        return new d(z);
    }

    public static class d {
        private ContentValues b;

        private d(boolean z) {
            bCQ_().put("needCheckAppAuth", Boolean.valueOf(z));
        }

        public d c(String str) {
            bCQ_().put("packageName", str);
            return this;
        }

        public d a(String str) {
            bCQ_().put("dataFilter", str);
            return this;
        }

        public d c(boolean z) {
            bCQ_().put("withoutDefaultZero", Boolean.valueOf(z));
            return this;
        }

        public d d(String str) {
            bCQ_().put("metadataFilter", str);
            return this;
        }

        public d a(Integer num) {
            bCQ_().put("deleteType", num);
            return this;
        }

        public d b(String str) {
            bCQ_().put("deleteDeviceUuid", str);
            return this;
        }

        public d c(Integer num) {
            bCQ_().put("deleteLevel", num);
            return this;
        }

        public d b(Integer num) {
            bCQ_().put("deleteInterval", num);
            return this;
        }

        public d e(Integer num) {
            bCQ_().put("sequenceDataType", num);
            return this;
        }

        public d a(boolean z) {
            bCQ_().put("lastDayDetail", Boolean.valueOf(z));
            return this;
        }

        public d b(boolean z) {
            bCQ_().put("isGroupByTime", Boolean.valueOf(z));
            return this;
        }

        public jrl d() {
            return new jrl(this.b);
        }

        private ContentValues bCQ_() {
            if (this.b == null) {
                this.b = new ContentValues();
            }
            return this.b;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiDataReadOp{");
        stringBuffer.append(this.e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
