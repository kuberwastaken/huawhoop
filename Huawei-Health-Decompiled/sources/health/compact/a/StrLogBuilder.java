package health.compact.a;

import android.os.Process;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class StrLogBuilder {
    private StringBuilder b;
    private StringBuilder c = new StringBuilder(560);

    StrLogBuilder(boolean z) {
        if (z) {
            this.b = new StringBuilder(560);
        }
    }

    public void d(String str) {
        if (this.c.capacity() > 560) {
            this.c = new StringBuilder(560);
        } else {
            StringBuilder sb = this.c;
            sb.delete(0, sb.length());
        }
        StringBuilder sb2 = this.b;
        if (sb2 != null) {
            if (sb2.capacity() > 560) {
                this.b = new StringBuilder(560);
            } else {
                StringBuilder sb3 = this.b;
                sb3.delete(0, sb3.length());
            }
            c(this.b);
            StringBuilder sb4 = this.b;
            sb4.append(str);
            sb4.append("|");
        }
    }

    public int b(String str, String str2, Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return this.c.length();
        }
        if (str != null) {
            this.c.append(str);
        }
        if (str2 != null) {
            StringBuilder sb = this.c;
            sb.append(str2);
            sb.append("|");
        }
        for (Object obj : objArr) {
            this.c.append(obj);
        }
        return this.c.length();
    }

    public String c(int i, int i2) {
        return this.c.substring(i, i2);
    }

    public void c(StringBuffer stringBuffer, String str) {
        StringBuilder sb = this.b;
        if (sb == null || stringBuffer == null) {
            return;
        }
        int length = sb.length();
        if (str != null) {
            StringBuilder sb2 = this.b;
            sb2.append(str);
            sb2.append(System.lineSeparator());
        } else {
            StringBuilder sb3 = this.b;
            sb3.append((CharSequence) this.c);
            sb3.append(System.lineSeparator());
        }
        stringBuffer.append((CharSequence) this.b);
        StringBuilder sb4 = this.b;
        sb4.delete(length, sb4.length());
    }

    private void c(StringBuilder sb) {
        Calendar calendar = Calendar.getInstance();
        sb.append(calendar.get(1));
        b(sb, calendar.get(2) + 1, "", false);
        b(sb, calendar.get(5), Constants.LINK, false);
        b(sb, calendar.get(11), ":", false);
        b(sb, calendar.get(12), ":", false);
        b(sb, calendar.get(13), ".", false);
        b(sb, calendar.get(14), "|", true);
        sb.append(Process.myTid());
        sb.append("|");
    }

    private void b(StringBuilder sb, int i, String str, boolean z) {
        if (z && i < 100) {
            sb.append("0");
        }
        if (i < 10) {
            sb.append("0");
        }
        sb.append(i);
        sb.append(str);
    }
}
