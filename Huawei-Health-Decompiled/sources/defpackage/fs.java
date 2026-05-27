package defpackage;

import com.airbnb.lottie.model.KeyPathElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class fs {
    public static final fs d = new fs("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private KeyPathElement f13123a;
    private final List<String> c;

    public fs(String... strArr) {
        this.c = Arrays.asList(strArr);
    }

    private fs(fs fsVar) {
        this.c = new ArrayList(fsVar.c);
        this.f13123a = fsVar.f13123a;
    }

    public fs b(String str) {
        fs fsVar = new fs(this);
        fsVar.c.add(str);
        return fsVar;
    }

    public fs d(KeyPathElement keyPathElement) {
        fs fsVar = new fs(this);
        fsVar.f13123a = keyPathElement;
        return fsVar;
    }

    public KeyPathElement d() {
        return this.f13123a;
    }

    public boolean d(String str, int i) {
        if (a(str)) {
            return true;
        }
        if (i >= this.c.size()) {
            return false;
        }
        return this.c.get(i).equals(str) || this.c.get(i).equals("**") || this.c.get(i).equals("*");
    }

    public int c(String str, int i) {
        if (a(str)) {
            return 0;
        }
        if (this.c.get(i).equals("**")) {
            return (i != this.c.size() - 1 && this.c.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean b(String str, int i) {
        if (i >= this.c.size()) {
            return false;
        }
        boolean z = i == this.c.size() - 1;
        String str2 = this.c.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.c.size() + (-2) && c())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.c.get(i + 1).equals(str)) {
            return i == this.c.size() + (-2) || (i == this.c.size() + (-3) && c());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.c.size() - 1) {
            return false;
        }
        return this.c.get(i2).equals(str);
    }

    public boolean a(String str, int i) {
        return "__container".equals(str) || i < this.c.size() - 1 || this.c.get(i).equals("**");
    }

    private boolean a(String str) {
        return "__container".equals(str);
    }

    private boolean c() {
        return this.c.get(r0.size() - 1).equals("**");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fs fsVar = (fs) obj;
        if (!this.c.equals(fsVar.c)) {
            return false;
        }
        KeyPathElement keyPathElement = this.f13123a;
        KeyPathElement keyPathElement2 = fsVar.f13123a;
        return keyPathElement != null ? keyPathElement.equals(keyPathElement2) : keyPathElement2 == null;
    }

    public int hashCode() {
        int iHashCode = this.c.hashCode();
        KeyPathElement keyPathElement = this.f13123a;
        return (iHashCode * 31) + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.c);
        sb.append(",resolved=");
        sb.append(this.f13123a != null);
        sb.append('}');
        return sb.toString();
    }
}
