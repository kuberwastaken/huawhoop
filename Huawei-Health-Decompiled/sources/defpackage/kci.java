package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class kci {
    private String mPackageName;
    private String mPackageSignature;
    private int mUid;

    public kci(String str, String str2, int i) {
        this.mPackageName = str;
        this.mPackageSignature = str2;
        this.mUid = i;
    }

    public void setUid(int i) {
        this.mUid = i;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getPackageSignature() {
        return this.mPackageSignature;
    }

    public int getUid() {
        return this.mUid;
    }
}
