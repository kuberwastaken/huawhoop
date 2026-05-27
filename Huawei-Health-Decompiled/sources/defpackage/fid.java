package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.UserCloseRecord;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fid {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("maxHr")
    double f12963a;

    @SerializedName("isPremBeat")
    int b;

    @SerializedName("afibRstFlag")
    int c;

    @SerializedName("meanHr")
    double d;

    @SerializedName("firstValley")
    int e;

    @SerializedName("measureType")
    int f;

    @SerializedName("predictProb")
    double g;

    @SerializedName("premPredictProb")
    double h;

    @SerializedName("predictValue")
    int i;

    @SerializedName("minHr")
    double j;

    @SerializedName(UserCloseRecord.TIME_STAMP)
    long k;

    @SerializedName("rriArrayLen")
    int l;

    @SerializedName("premRstFlag")
    int o;

    @SerializedName("rriArray")
    List<Integer> n = new ArrayList();

    @SerializedName("waveClass")
    List<Integer> m = new ArrayList();
}
