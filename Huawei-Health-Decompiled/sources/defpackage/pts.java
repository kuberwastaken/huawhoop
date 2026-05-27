package defpackage;

import com.huawei.ui.device.declaration.xmlparser.DeclarationConstants;

/* JADX INFO: loaded from: classes7.dex */
public class pts extends ptn {
    private static final long serialVersionUID = -9205085941889233060L;
    private String c;
    private boolean d;
    private DeclarationConstants.Position e;

    public String b() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public DeclarationConstants.Position d() {
        return this.e;
    }

    public void b(DeclarationConstants.Position position) {
        this.e = position;
    }

    public boolean a() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public String toString() {
        return "Title{value='" + this.c + "', checkboxPosition=" + this.e + ", isChecked=" + this.d + '}';
    }
}
