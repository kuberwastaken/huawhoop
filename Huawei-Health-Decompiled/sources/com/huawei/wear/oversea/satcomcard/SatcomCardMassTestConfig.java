package com.huawei.wear.oversea.satcomcard;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class SatcomCardMassTestConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("BeiDouAuditCycle")
    private int f11736a;

    @SerializedName("IsMsgCustomized")
    private int b;

    @SerializedName("MaxMsgCnt")
    private int c;

    @SerializedName("BeidouAuditWaitDay")
    private int d;

    @SerializedName("MassTestPeriod")
    private String e;

    @SerializedName("SatcomStopTips")
    private String f;

    @SerializedName("PresetMsg")
    private String i;

    /* JADX INFO: loaded from: classes11.dex */
    public interface AuditCycleType {
        public static final int DEFAULT = 0;
        public static final int FIX_CYCLE = 1;
    }

    public int c() {
        return this.f11736a;
    }

    public int a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }
}
