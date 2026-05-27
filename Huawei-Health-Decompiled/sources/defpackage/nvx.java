package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class nvx {
    private List<nof> b;
    private nof c;

    public nvx(List<nof> list, nof nofVar) {
        this.b = list;
        this.c = nofVar;
    }

    public List<nof> e() {
        return this.b;
    }

    public nof b() {
        return this.c;
    }

    public String toString() {
        return "LevelDBData{achieveDataList=" + this.b + ", achieveData=" + this.c + '}';
    }
}
