package defpackage;

import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class auc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<UnstructData> f323a;
    private String b;
    private String c;
    private String d;
    private String e;
    private long g;
    private String h;
    private int i;
    private String j;

    public String a() {
        return this.d;
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(List<UnstructData> list) {
        this.f323a = list;
    }

    public List<UnstructData> b() {
        return this.f323a;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public void d(String str) {
        this.c = str;
    }

    public String e() {
        return this.c;
    }

    public void e(String str) {
        this.d = str;
    }

    public String f() {
        return this.j;
    }

    public String g() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public long j() {
        return this.g;
    }

    public String toString() {
        return "[id = " + this.c + " , unstruct_uuuid = " + this.j + " , uuid = " + this.h + " , recycleStatus = " + this.i + ", extraParam = " + this.b + "]";
    }
}
