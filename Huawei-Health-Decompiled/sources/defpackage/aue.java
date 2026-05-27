package defpackage;

import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class aue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f325a;
    private int b;
    private String e;
    private ArrayList<UnstructData> d = new ArrayList<>(10);
    private ArrayList<UnstructData> c = new ArrayList<>(10);

    public ArrayList<UnstructData> a() {
        return this.c;
    }

    public ArrayList<UnstructData> b() {
        return this.d;
    }

    public void b(ArrayList<UnstructData> arrayList) {
        this.d = arrayList;
    }

    public int c() {
        return this.b;
    }

    public void c(String str) {
        this.f325a = str;
    }

    public String d() {
        return this.f325a;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String toString() {
        return "UpdateResult [id=" + this.f325a + ", guid=" + this.e + ", recycleStatus=" + this.b + ", downFileList=" + this.d.toString() + ", deleteFileList=" + this.c.toString() + "]";
    }
}
