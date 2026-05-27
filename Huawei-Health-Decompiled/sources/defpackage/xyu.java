package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class xyu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f19218a;
    public final String b;
    public final Boolean c;
    public final String d;

    public xyu(PackageInfo packageInfo, boolean z) {
        this(packageInfo.packageName, fFw_(packageInfo.signatures), packageInfo.versionName, z);
    }

    public xyu(String str, Set<String> set, String str2, boolean z) {
        this.b = str;
        this.f19218a = set;
        this.d = str2;
        this.c = Boolean.valueOf(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof xyu)) {
            return false;
        }
        xyu xyuVar = (xyu) obj;
        return this.b.equals(xyuVar.b) && this.d.equals(xyuVar.d) && this.c == xyuVar.c && this.f19218a.equals(xyuVar.f19218a);
    }

    public int hashCode() {
        int iHashCode = (((this.b.hashCode() * 92821) + this.d.hashCode()) * 92821) + (this.c.booleanValue() ? 1 : 0);
        Iterator<String> it = this.f19218a.iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 92821) + it.next().hashCode();
        }
        return iHashCode;
    }

    public static String fFv_(Signature signature) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-512").digest(signature.toByteArray()), 10);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("Platform does not supportSHA-512 hashing");
        }
    }

    public static Set<String> fFw_(Signature[] signatureArr) {
        HashSet hashSet = new HashSet();
        for (Signature signature : signatureArr) {
            hashSet.add(fFv_(signature));
        }
        return hashSet;
    }
}
