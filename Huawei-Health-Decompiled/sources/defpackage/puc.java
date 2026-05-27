package defpackage;

import com.huawei.ui.device.declaration.xmlparser.DeclarationConstants;

/* JADX INFO: loaded from: classes7.dex */
public class puc extends ptn {
    private static final long serialVersionUID = 7974573066439337805L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected DeclarationConstants.PlaceholderType f16881a;
    protected String d;

    public String b() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public DeclarationConstants.PlaceholderType d() {
        return this.f16881a;
    }

    public void e(DeclarationConstants.PlaceholderType placeholderType) {
        this.f16881a = placeholderType;
    }

    public String toString() {
        return "Placeholder{value='" + this.d + "', placeholderType=" + this.f16881a + '}';
    }
}
