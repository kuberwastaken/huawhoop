package defpackage;

/* JADX INFO: loaded from: classes10.dex */
final class asm {
    private final String b;
    private final String e;

    asm(String str, String str2) {
        this.e = str;
        this.b = str2;
    }

    String e() {
        return this.e;
    }

    String a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof asm)) {
            return false;
        }
        asm asmVar = (asm) obj;
        return asmVar.e.equals(this.e) && asmVar.b.equals(this.b);
    }

    public int hashCode() {
        return this.e.hashCode() + this.b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("oldVer:");
        sb.append(this.e);
        sb.append(", newVer:");
        sb.append(this.b);
        return sb.toString();
    }
}
