package defpackage;

import com.huawei.hwlogsmodel.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class lal {
    private int b;
    private String c;
    private String[] e;

    public int d() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String[] e() {
        String[] strArr = this.e;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        LogUtil.e("ApduCardBean", "swInfos is null");
        return null;
    }
}
