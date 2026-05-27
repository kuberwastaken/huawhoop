package defpackage;

import android.os.ParcelFileDescriptor;
import com.huawei.health.devicemgr.business.constant.TransferFileReqType;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class lfk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15137a;
    private String b;
    private List<Integer> c;
    private String d;
    private String e;
    private ParcelFileDescriptor f = null;
    private String g;
    private long h;
    private String i;
    private int j;
    private TransferFileReqType k;
    private String l;
    private long m;
    private boolean n;
    private int o;
    private int[] p;
    private String q;
    private String s;

    public TransferFileReqType o() {
        return this.k;
    }

    public void c(TransferFileReqType transferFileReqType) {
        this.k = transferFileReqType;
    }

    public List<Integer> d() {
        return this.c;
    }

    public void b(List<Integer> list) {
        this.c = list;
    }

    public String f() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public int l() {
        return this.o;
    }

    public void e(int i) {
        this.o = i;
    }

    public String g() {
        return this.i;
    }

    public void g(String str) {
        this.i = str;
    }

    public long k() {
        return this.m;
    }

    public void b(long j) {
        this.m = j;
    }

    public String n() {
        return this.l;
    }

    public void h(String str) {
        this.l = str;
    }

    public boolean r() {
        return this.n;
    }

    public void d(boolean z) {
        this.n = z;
    }

    public int[] s() {
        int[] iArr = this.p;
        if (iArr != null) {
            return (int[]) iArr.clone();
        }
        return null;
    }

    public void d(int[] iArr) {
        if (iArr != null) {
            this.p = (int[]) iArr.clone();
        }
    }

    public String b() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public int i() {
        return this.j;
    }

    public void d(int i) {
        this.j = i;
    }

    public ParcelFileDescriptor bPa_() {
        return this.f;
    }

    public void bPb_(ParcelFileDescriptor parcelFileDescriptor) {
        this.f = parcelFileDescriptor;
    }

    public long h() {
        return this.h;
    }

    public void e(long j) {
        this.h = j;
    }

    public String q() {
        return this.s;
    }

    public void f(String str) {
        this.s = str;
    }

    public String c() {
        return this.f15137a;
    }

    public void d(String str) {
        this.f15137a = str;
    }

    public String m() {
        return this.q;
    }

    public void j(String str) {
        this.q = str;
    }

    public String a() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }
}
