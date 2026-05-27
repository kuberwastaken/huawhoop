package defpackage;

import com.huawei.ui.device.declaration.xmlparser.DeclarationConstants;

/* JADX INFO: loaded from: classes7.dex */
public class ptr extends ptt {
    private static final long serialVersionUID = 232733746650473673L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DeclarationConstants.SwitchFaceState f16876a;
    private String b;
    private String c;

    public String d() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public DeclarationConstants.SwitchFaceState a() {
        return this.f16876a;
    }

    public void a(DeclarationConstants.SwitchFaceState switchFaceState) {
        this.f16876a = switchFaceState;
    }

    public void b(String str) {
        this.b = str;
    }

    public String toString() {
        return "SwitchFaceConfig{state=" + this.f16876a + ", action='" + this.b + "'}";
    }
}
