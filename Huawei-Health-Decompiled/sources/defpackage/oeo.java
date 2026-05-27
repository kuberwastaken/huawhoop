package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class oeo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f16326a;
    String c;
    List<odz> e;

    public List<odz> b() {
        return this.e;
    }

    public void e(List<odz> list) {
        this.e = list;
    }

    public String e() {
        return this.f16326a;
    }

    public void c(String str) {
        this.f16326a = str;
    }

    public void a(String str) {
        this.c = str;
    }

    public String toString() {
        StringBuffer stringBufferAppend = new StringBuffer("IndexFileStruct{version='").append(this.f16326a);
        stringBufferAppend.append("', updatedTime='").append(this.c);
        stringBufferAppend.append("', plugins='").append(this.e.toString()).append("'}");
        return stringBufferAppend.toString();
    }
}
