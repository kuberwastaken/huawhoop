package defpackage;

import android.graphics.Paint;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class pio {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f16715a;

    @SerializedName("endY")
    private float b;

    @SerializedName("centerX")
    private float c;

    @SerializedName("centerY")
    private float d;

    @SerializedName("endX")
    private float e;

    @SerializedName("startY")
    private float g;

    @SerializedName("startX")
    private float h;

    @SerializedName("pathData")
    private String i;

    public float c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    public String b() {
        return this.i;
    }

    public float j() {
        return this.h;
    }

    public float h() {
        return this.g;
    }

    public float e() {
        return this.b;
    }

    public Paint cOE_() {
        return this.f16715a;
    }

    public void cOF_(Paint paint) {
        this.f16715a = paint;
    }
}
