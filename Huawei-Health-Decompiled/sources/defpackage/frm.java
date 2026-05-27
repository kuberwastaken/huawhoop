package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.basefitnessadvice.model.intplan.RecordData;

/* JADX INFO: loaded from: classes4.dex */
public class frm implements RecordData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("actualCalorie")
    private float f13112a;
    private long b;

    @SerializedName("actualDistance")
    private int c;
    private String d;
    private long e;
    private int f;
    private String g;
    private int h;
    private long i;
    private String j;

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public String getWorkoutId() {
        return this.g;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public String getRecordId() {
        return this.j;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public int getSportType() {
        return this.f;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public long getStartTime() {
        return this.i;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public long getEndTime() {
        return this.b;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public long getDuration() {
        return this.e;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public int getActualDistance() {
        return this.c;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public float getActualCalorie() {
        return this.f13112a;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public int getIsInPlan() {
        return this.h;
    }

    @Override // com.huawei.basefitnessadvice.model.intplan.RecordData
    public String getExtraInfo() {
        return this.d;
    }

    public void e(String str) {
        this.g = str;
    }

    public void a(String str) {
        this.j = str;
    }

    public void e(int i) {
        this.f = i;
    }

    public void c(long j) {
        this.i = j;
    }

    public void e(long j) {
        this.b = j;
    }

    public void d(long j) {
        this.e = j;
    }

    public void d(int i) {
        this.c = i;
    }

    public void d(float f) {
        this.f13112a = f;
    }

    public void a(int i) {
        this.h = i;
    }

    public void d(String str) {
        this.d = str;
    }

    public frm c(nzy nzyVar) {
        if (nzyVar != null) {
            e(nzyVar.m());
            a(nzyVar.g());
            e(nzyVar.j());
            c(nzyVar.i());
            e(nzyVar.a());
            d(nzyVar.c());
            d(nzyVar.b());
            d(nzyVar.d());
            a(nzyVar.f());
            d(nzyVar.h());
        }
        return this;
    }
}
