package defpackage;

import android.graphics.Bitmap;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class gho {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mCustomizeVideoPath")
    private String f13461a;

    @SerializedName("mImagePath")
    private String c;

    @SerializedName("mIsBackground")
    private boolean d;

    @SerializedName("mPackageName")
    private String e;

    @SerializedName("mShareType")
    private int g;

    @SerializedName("mRequestShareBiMap")
    private Map<String, Object> h;

    @SerializedName("mPresetBackgroundList")
    private List<Integer> j;

    @SerializedName("watermarkInfos")
    private List<ght> k;

    @SerializedName("mTabTitle")
    private String l;

    @SerializedName("mUri")
    private String m;

    @SerializedName("mWatermarkData")
    private gib n;

    @SerializedName("mSportType")
    private int f = 0;

    @SerializedName("mIsEditable")
    private boolean b = true;

    @SerializedName("mPreviewBitmap")
    private Bitmap i = null;

    public void b(String str) {
        this.l = str;
    }

    public String g() {
        return this.l;
    }

    public void d(List<ght> list) {
        this.k = list;
    }

    public List<ght> m() {
        return this.k;
    }

    public List<Integer> o() {
        return this.j;
    }

    public void a(List<Integer> list) {
        this.j = list;
    }

    public int i() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public boolean k() {
        return this.b;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public Bitmap azu_() {
        return this.i;
    }

    public void azv_(Bitmap bitmap) {
        this.i = bitmap;
    }

    public void e(String str) {
        this.f13461a = str;
    }

    public String a() {
        return this.f13461a;
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public Map<String, Object> b() {
        return this.h;
    }

    public void d(Map<String, Object> map) {
        this.h = map;
    }

    public int f() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public void d(gib gibVar) {
        this.n = gibVar;
    }

    public gib j() {
        return this.n;
    }

    public boolean n() {
        return this.d;
    }

    public void l() {
        Bitmap bitmapAzu_ = azu_();
        if (bitmapAzu_ != null && !bitmapAzu_.isRecycled()) {
            bitmapAzu_.recycle();
        }
        azv_(null);
    }

    public String h() {
        return this.m;
    }

    public String e() {
        return this.e;
    }
}
