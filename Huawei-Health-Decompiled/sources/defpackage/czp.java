package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class czp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f12108a;
    List<dsk> b;
    String c;

    czp() {
    }

    public List<dsk> c() {
        return this.b;
    }

    public void c(List<dsk> list) {
        this.b = list;
    }

    public String e() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.f12108a = str;
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("IndexFileStruct{version='").append(this.c);
        stringBufferAppend.append("', updatedTime='").append(this.f12108a);
        stringBufferAppend.append("', plugins='").append(this.b.toString()).append("'}");
        return stringBufferAppend.toString();
    }
}
