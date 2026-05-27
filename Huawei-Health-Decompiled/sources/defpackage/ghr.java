package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.health.socialshare.model.SaveBitampCallback;
import com.huawei.hwcommonmodel.constants.AnalyticsValue;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.operation.utils.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ghr implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("editContents")
    private ArrayList<gho> f13462a;

    @SerializedName("shareTitleContent")
    private String aa;

    @SerializedName("thumbImage")
    private Bitmap ab;

    @SerializedName("shareUrlContent")
    private String ac;

    @SerializedName(Constants.ACTIVITY_SHARE_TYPE)
    private int ad;

    @SerializedName("imagePath")
    private String b;

    @SerializedName("imageUriList")
    private ArrayList<Uri> c;

    @SerializedName("imageNum")
    private int d;

    @SerializedName("isNeedPrint")
    private boolean h;

    @SerializedName("inSampleSize")
    private int i;

    @SerializedName("isNeedSavePdf")
    private boolean j;

    @SerializedName("mFilePath")
    private String k;

    @SerializedName("isSharePicCompress")
    private boolean l;

    @SerializedName("mFileUri")
    private Uri n;

    @SerializedName("mVideoPath")
    private String p;

    @SerializedName("requestShareBiMap")
    private Map<String, Object> s;

    @SerializedName("mVideoUri")
    private Uri t;

    @SerializedName("saveBitampCallback")
    private SaveBitampCallback u;

    @SerializedName("saveFileImages")
    private ArrayList<String> v;

    @SerializedName("sharePicUrl")
    private String w;

    @SerializedName("sharePicContent")
    private Bitmap x;

    @SerializedName("shareFrom")
    private int y;

    @SerializedName("shareTextContent")
    private String z;

    @SerializedName("isShareFamily")
    private boolean f = true;

    @SerializedName("requestShareModule")
    private String q = AnalyticsValue.SHARE_1140001.value();

    @SerializedName("defaultPreviewIndex")
    private int e = 0;

    @SerializedName("isShowTab")
    private boolean o = false;

    @SerializedName("mShareSportData")
    private HashMap<String, String> r = new HashMap<>();

    @SerializedName("isNeedWatermark")
    private boolean g = true;

    @SerializedName("isShowUserinfoButton")
    private boolean m = true;

    public ghr(int i) {
        this.ad = i;
    }

    public int ad() {
        return this.y;
    }

    public boolean f() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean ac() {
        return this.j;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public boolean ab() {
        return this.h;
    }

    public void e(boolean z) {
        this.h = z;
    }

    public final void a(int i) {
        this.y = i;
    }

    public String h() {
        return this.b;
    }

    public final void d(String str) {
        this.b = str;
    }

    public ArrayList<String> n() {
        return this.v;
    }

    public void b(ArrayList<String> arrayList) {
        this.v = arrayList;
    }

    public int e() {
        return this.d;
    }

    public final void b(int i) {
        this.d = i;
    }

    public ArrayList<Uri> i() {
        ArrayList<Uri> arrayList = this.c;
        return arrayList == null ? new ArrayList<>(0) : arrayList;
    }

    public final void a(ArrayList<Uri> arrayList) {
        this.c = arrayList;
    }

    public int j() {
        return this.i;
    }

    public final void e(int i) {
        this.i = i;
    }

    public boolean z() {
        return this.l;
    }

    public final void g(boolean z) {
        this.l = z;
    }

    public int x() {
        return this.ad;
    }

    public void d(int i) {
        this.ad = i;
    }

    public boolean g() {
        return this.f;
    }

    public void d(boolean z) {
        this.f = z;
    }

    public String q() {
        return this.z;
    }

    public final void a(String str) {
        this.z = str;
    }

    public String s() {
        return this.aa;
    }

    public final void e(String str) {
        this.aa = str;
    }

    public String v() {
        return this.ac;
    }

    public final void j(String str) {
        this.ac = str;
    }

    public Bitmap azo_() {
        return this.x;
    }

    public final void azr_(Bitmap bitmap) {
        this.x = bitmap;
    }

    public String p() {
        return this.w;
    }

    public String m() {
        return this.q;
    }

    public final void c(String str) {
        this.q = str;
    }

    public SaveBitampCallback k() {
        return this.u;
    }

    public void a(SaveBitampCallback saveBitampCallback) {
        this.u = saveBitampCallback;
    }

    public Map<String, Object> l() {
        return this.s;
    }

    public final void b(Map<String, Object> map) {
        this.s = map;
    }

    public ArrayList<gho> c() {
        ArrayList<gho> arrayList = this.f13462a;
        return arrayList == null ? new ArrayList<>(0) : arrayList;
    }

    public final void e(ArrayList<gho> arrayList) {
        this.f13462a = arrayList;
    }

    public void b(gho ghoVar) {
        if (this.f13462a == null) {
            this.f13462a = new ArrayList<>(3);
        }
        this.f13462a.add(ghoVar);
    }

    public int a() {
        return this.e;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void c(boolean z) {
        this.o = z;
    }

    public boolean o() {
        return this.o;
    }

    public final void h(String str) {
        this.p = str;
    }

    public String y() {
        return this.p;
    }

    public final void azt_(Uri uri) {
        this.t = uri;
    }

    public Uri azq_() {
        return this.t;
    }

    public String b() {
        return this.k;
    }

    public void b(String str) {
        this.k = str;
    }

    public Uri azn_() {
        return this.n;
    }

    public HashMap<String, String> t() {
        return this.r;
    }

    public final void c(HashMap<String, String> map) {
        this.r = map;
    }

    public Bitmap azp_() {
        return this.ab;
    }

    public void azs_(Bitmap bitmap) {
        this.ab = bitmap;
    }

    public void i(boolean z) {
        this.m = z;
    }

    public boolean aa() {
        return this.m;
    }

    public String toString() {
        return "shareType = " + this.ad;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            LogUtil.a("ShareContent", "clone CloneNotSupportedException");
            ghr ghrVar = new ghr(this.ad);
            ghrVar.c(this.e);
            ghrVar.azr_(this.x);
            ghrVar.c(this.q);
            ghrVar.e(this.f13462a);
            ghrVar.b(this.d);
            ghrVar.d(this.b);
            ghrVar.b(this.v);
            ghrVar.a(this.c);
            ghrVar.e(this.i);
            ghrVar.c(this.o);
            ghrVar.g(this.l);
            ghrVar.a(this.z);
            ghrVar.c(this.r);
            ghrVar.e(this.aa);
            ghrVar.j(this.ac);
            ghrVar.h(this.p);
            ghrVar.azt_(this.t);
            ghrVar.a(this.y);
            ghrVar.b(this.s);
            ghrVar.i(this.m);
            return ghrVar;
        }
    }

    public void ae() {
        Bitmap bitmapAzo_ = azo_();
        if (bitmapAzo_ != null && !bitmapAzo_.isRecycled()) {
            bitmapAzo_.recycle();
        }
        azr_(null);
        ArrayList<gho> arrayListC = c();
        if (CollectionUtils.isEmpty(arrayListC)) {
            return;
        }
        for (gho ghoVar : arrayListC) {
            if (ghoVar != null) {
                ghoVar.l();
            }
        }
        e((ArrayList<gho>) null);
    }
}
