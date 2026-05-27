package defpackage;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.health.IBaseCommonCallback;
import com.huawei.hwdevice.phoneprocess.mgr.hwcommonfilemgr.bean.Priority;
import com.huawei.hwservicesmgr.IAppTransferFileResultAIDLCallback;
import com.huawei.hwservicesmgr.IBaseCallback;
import com.huawei.hwservicesmgr.IOTAResultAIDLCallback;
import com.huawei.hwservicesmgr.ITransferSleepAndDFXFileCallback;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public class loz {
    private String aa;
    private ParcelFileDescriptor ab;
    private String ac;
    private Priority ad;
    private long ag;
    private long ai;
    private int b;
    private ByteBuffer c;
    private ByteBuffer e;
    private String g;
    private String i;
    private String j;
    private int k;
    private int m;
    private int n;
    private String p;
    private int q;
    private int r;
    private int s;
    private boolean w;
    private int x;
    private String z;
    private String o = "";
    private boolean v = true;
    private String u = "";
    private long ah = -1;
    private int af = 0;
    private int ae = 0;
    private int f = 0;
    private IBaseCallback h = null;
    private IOTAResultAIDLCallback l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAppTransferFileResultAIDLCallback f15368a = null;
    private ITransferSleepAndDFXFileCallback t = null;
    private IBaseCommonCallback y = null;
    private boolean d = false;
    private int ak = -1;

    public IBaseCallback b() {
        return this.h;
    }

    public void c(IBaseCallback iBaseCallback) {
        this.h = iBaseCallback;
    }

    public int r() {
        return this.q;
    }

    public void h(int i) {
        this.q = i;
    }

    public long ah() {
        return this.ah;
    }

    public void d(long j) {
        this.ah = j;
    }

    public IOTAResultAIDLCallback i() {
        return this.l;
    }

    public void d(IOTAResultAIDLCallback iOTAResultAIDLCallback) {
        this.l = iOTAResultAIDLCallback;
    }

    public IAppTransferFileResultAIDLCallback ai() {
        return this.f15368a;
    }

    public void a(IAppTransferFileResultAIDLCallback iAppTransferFileResultAIDLCallback) {
        this.f15368a = iAppTransferFileResultAIDLCallback;
    }

    public ITransferSleepAndDFXFileCallback t() {
        return this.t;
    }

    public void d(ITransferSleepAndDFXFileCallback iTransferSleepAndDFXFileCallback) {
        this.t = iTransferSleepAndDFXFileCallback;
    }

    public int f() {
        return this.m;
    }

    public void c(int i) {
        this.m = i;
    }

    public String k() {
        return this.o;
    }

    public void e(String str) {
        this.o = str;
    }

    public int s() {
        return this.x;
    }

    public void f(int i) {
        this.x = i;
    }

    public String m() {
        return this.p;
    }

    public void a(String str) {
        this.p = str;
    }

    public boolean ak() {
        return this.v;
    }

    public void b(boolean z) {
        this.v = z;
    }

    public String q() {
        return this.u;
    }

    public void g(String str) {
        this.u = str;
    }

    public int o() {
        return this.k;
    }

    public void b(int i) {
        this.k = i;
    }

    public int n() {
        return this.n;
    }

    public void a(int i) {
        this.n = i;
    }

    public int l() {
        return this.r;
    }

    public void j(int i) {
        this.r = i;
    }

    public int p() {
        return this.s;
    }

    public void i(int i) {
        this.s = i;
    }

    public ByteBuffer e() {
        return this.c;
    }

    public void b(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
    }

    public ByteBuffer d() {
        return this.e;
    }

    public void c(ByteBuffer byteBuffer) {
        this.e = byteBuffer;
    }

    public IBaseCommonCallback v() {
        return this.y;
    }

    public void a(IBaseCommonCallback iBaseCommonCallback) {
        this.y = iBaseCommonCallback;
    }

    public int ab() {
        return this.af;
    }

    public void l(int i) {
        this.af = i;
    }

    public int ad() {
        return this.ae;
    }

    public void g(int i) {
        this.ae = i;
    }

    public int j() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public String aa() {
        return this.ac;
    }

    public void j(String str) {
        this.ac = str;
    }

    public String g() {
        return this.g;
    }

    public void d(String str) {
        this.g = str;
    }

    public String a() {
        return this.i;
    }

    public void c(String str) {
        this.i = str;
    }

    public int c() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
    }

    public Priority u() {
        return this.ad;
    }

    public void e(Priority priority) {
        this.ad = priority;
    }

    public long z() {
        return this.ag;
    }

    public void e(long j) {
        this.ag = j;
    }

    public long ac() {
        return this.ai;
    }

    public void a(long j) {
        this.ai = j;
    }

    public ParcelFileDescriptor bRr_() {
        return this.ab;
    }

    public void bRs_(ParcelFileDescriptor parcelFileDescriptor) {
        this.ab = parcelFileDescriptor;
    }

    public String x() {
        return this.aa;
    }

    public void f(String str) {
        this.aa = str;
    }

    public String w() {
        return this.z;
    }

    public void i(String str) {
        this.z = str;
    }

    public String h() {
        return this.j;
    }

    public void b(String str) {
        this.j = str;
    }

    public boolean af() {
        return this.w;
    }

    public void e(boolean z) {
        this.w = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof loz)) {
            return false;
        }
        loz lozVar = (loz) obj;
        return s() == lozVar.s() && TextUtils.equals(aa(), lozVar.aa()) && TextUtils.equals(g(), lozVar.g()) && TextUtils.equals(k(), lozVar.k());
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean ae() {
        return this.d;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public int ag() {
        return this.ak;
    }

    public void o(int i) {
        this.ak = i;
    }
}
