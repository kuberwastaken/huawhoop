package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwlogsmodel.LogUtil;
import defpackage.kqt;

/* JADX INFO: loaded from: classes.dex */
public class HeartZoneConf extends HeartRateZoneThreshold {
    private static final int HEARTRATELIMIT = 220;
    public static final int INVALID_HEART_RATE_TYPE = -1;
    public static final int MAX_HEART_RATE_TYPE = 0;
    public static final int REST_HEART_RATE_TYPE = 1;
    private static final String TAG = "HeartZoneConf";
    private static final int ZONE1 = 0;
    private static final int ZONE2 = 1;
    private static final int ZONE3 = 2;
    private static final int ZONE4 = 3;
    private static final int ZONE5 = 4;
    int classifyMethod;
    boolean warningEnble;
    boolean warningEnbleHRR;
    int warningLimitHR;
    int warningLimitHRHRR;

    private float getRateRegionRatio(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        float f;
        float f2;
        if (i >= 220) {
            return -1.0f;
        }
        if (i >= i2) {
            return 100.0f;
        }
        if (i >= i3) {
            f = i - i3;
            f2 = i2 - i3;
        } else if (i >= i4) {
            f = i - i4;
            f2 = i3 - i4;
        } else if (i >= i5) {
            f = i - i5;
            f2 = i4 - i5;
        } else if (i >= i6) {
            f = i - i6;
            f2 = i5 - i6;
        } else {
            if (i < i7) {
                return -1.0f;
            }
            f = i - i7;
            f2 = i6 - i7;
        }
        return f / f2;
    }

    private int whichRateRegion(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i >= 220) {
            return -1;
        }
        if (i >= i2) {
            return 4;
        }
        if (i >= i3) {
            return 3;
        }
        if (i >= i4) {
            return 2;
        }
        if (i >= i5) {
            return 1;
        }
        return i >= i6 ? 0 : -1;
    }

    public HeartZoneConf() {
        this(30);
    }

    public void setHeartZoneConf(HeartZoneConf heartZoneConf) {
        this.warningEnble = heartZoneConf.warningEnble;
        this.warningLimitHR = heartZoneConf.warningLimitHR;
        this.warningEnbleHRR = heartZoneConf.warningEnbleHRR;
        this.warningLimitHRHRR = heartZoneConf.warningLimitHRHRR;
        setFitnessThreshold(heartZoneConf.getFitnessThreshold());
        setWarmUpThreshold(heartZoneConf.getWarmUpThreshold());
        setFatBurnThreshold(heartZoneConf.getFatBurnThreshold());
        setAerobicThreshold(heartZoneConf.getAerobicThreshold());
        setAnaerobicThreshold(heartZoneConf.getAnaerobicThreshold());
        setMaxThreshold(heartZoneConf.getMaxThreshold());
    }

    public void setHRRHeartZoneConf(HeartZoneConf heartZoneConf) {
        this.warningEnble = heartZoneConf.warningEnble;
        this.warningLimitHR = heartZoneConf.warningLimitHR;
        this.warningEnbleHRR = heartZoneConf.warningEnbleHRR;
        this.warningLimitHRHRR = heartZoneConf.warningLimitHRHRR;
        setAerobicBaseThreshold(heartZoneConf.getAerobicBaseThreshold());
        setAerobicAdvanceThreshold(heartZoneConf.getAerobicAdvanceThreshold());
        setLacticAcidThreshold(heartZoneConf.getLacticAcidThreshold());
        setAnaerobicBaseThreshold(heartZoneConf.getAnaerobicBaseThreshold());
        setAnaerobicAdvanceThreshold(heartZoneConf.getAnaerobicAdvanceThreshold());
        setHrrMaxThreshold(heartZoneConf.getHrrMaxThreshold());
    }

    public void resetHeartZoneConf(int i) {
        resetHrrHeartRateZoneThreshold(i);
        resetHeartRateZoneThreshold(i);
    }

    public HeartZoneConf(int i) {
        super(i);
        setRestHeartRate(60);
        setRestHeartRateDefault(60);
        this.warningEnble = true;
        this.warningEnbleHRR = true;
        this.warningLimitHR = getMaxThreshold();
        this.warningLimitHRHRR = getHrrMaxThreshold();
    }

    public void setWarningEnble(boolean z) {
        this.warningEnble = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public void setWarningLimitHR(int i) {
        this.warningLimitHR = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void setWarningEnbleHRR(boolean z) {
        this.warningEnbleHRR = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public void setWarningLimitHRHRR(int i) {
        this.warningLimitHRHRR = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void setClassifyMethod(int i) {
        this.classifyMethod = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public boolean isWarningEnble() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.warningEnble))).booleanValue();
    }

    public int getWarningLimitHR() {
        return ((Integer) kqt.e(Integer.valueOf(this.warningLimitHR))).intValue();
    }

    public String getHRZoneConfStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.warningEnble ? "1" : "0");
        sb.append("|");
        sb.append(this.warningLimitHR);
        return (String) kqt.e(sb.toString());
    }

    public boolean isWarningEnbleHRR() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.warningEnbleHRR))).booleanValue();
    }

    public int getWarningLimitHRHRR() {
        return ((Integer) kqt.e(Integer.valueOf(this.warningLimitHRHRR))).intValue();
    }

    public String getHRRHRZoneConfStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.warningEnbleHRR ? "1" : "0");
        sb.append("|");
        sb.append(this.warningLimitHRHRR);
        return (String) kqt.e(sb.toString());
    }

    public int getClassifyMethod() {
        return ((Integer) kqt.e(Integer.valueOf(this.classifyMethod))).intValue();
    }

    public void setHRZoneConf(String str) {
        LogUtil.b(TAG, "setThreshold :", str);
        if (str.isEmpty()) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        try {
            if (strArrSplit.length == 2) {
                if (Integer.parseInt(strArrSplit[0]) == 0) {
                    this.warningEnble = false;
                } else {
                    this.warningEnble = true;
                }
                this.warningLimitHR = Integer.parseInt(strArrSplit[1]);
            }
        } catch (NumberFormatException e) {
            LogUtil.b(TAG, "getThreshold ", str, " meet e:", e);
        }
    }

    public void setHRRHRZoneConf(String str) {
        LogUtil.b(TAG, "setHRRHRZoneConf :", str);
        if (str.isEmpty()) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        try {
            if (strArrSplit.length == 2) {
                if (Integer.parseInt(strArrSplit[0]) == 0) {
                    this.warningEnbleHRR = false;
                } else {
                    this.warningEnbleHRR = true;
                }
                this.warningLimitHRHRR = Integer.parseInt(strArrSplit[1]);
            }
        } catch (NumberFormatException e) {
            LogUtil.b(TAG, "getThreshold ", str, " meet e:", e);
        }
    }

    public int findRateRegion(int i) {
        if (this.classifyMethod == 0) {
            return whichRateRegion(i, getAnaerobicThreshold(), getAerobicThreshold(), getFatBurnThreshold(), getWarmUpThreshold(), getFitnessThreshold());
        }
        return whichRateRegion(i, getAnaerobicAdvanceThreshold(), getAnaerobicBaseThreshold(), getLacticAcidThreshold(), getAerobicAdvanceThreshold(), getAerobicBaseThreshold());
    }

    public int findRateRegion(int i, int i2) {
        if (i2 == 0) {
            return whichRateRegion(i, getAnaerobicThreshold(), getAerobicThreshold(), getFatBurnThreshold(), getWarmUpThreshold(), getFitnessThreshold());
        }
        if (i2 == 3) {
            return whichRateRegion(i, getLthrAnaerobicInterval(), getLthrLactateThreshold(), getLthrAerobicHighZone(), getLthrAerobicLowZone(), getLthrRecoveryInterval());
        }
        return whichRateRegion(i, getAnaerobicAdvanceThreshold(), getAnaerobicBaseThreshold(), getLacticAcidThreshold(), getAerobicAdvanceThreshold(), getAerobicBaseThreshold());
    }

    public float findRateRegionRatio(int i, int i2) {
        if (i2 == 0) {
            return getRateRegionRatio(i, getMaxThreshold(), getAnaerobicThreshold(), getAerobicThreshold(), getFatBurnThreshold(), getWarmUpThreshold(), getFitnessThreshold());
        }
        if (i2 == 3) {
            return getRateRegionRatio(i, getLthrAnaerobicInterval(), getLthrAnaerobicInterval(), getLthrLactateThreshold(), getLthrAerobicHighZone(), getLthrAerobicLowZone(), getLthrRecoveryInterval());
        }
        return getRateRegionRatio(i, getHrrMaxThreshold(), getAnaerobicAdvanceThreshold(), getAnaerobicBaseThreshold(), getLacticAcidThreshold(), getAerobicAdvanceThreshold(), getAerobicBaseThreshold());
    }

    public int getZoneValue(int i, boolean z) {
        return getZoneValue(i, z, getClassifyMethod());
    }

    public int getZoneValue(int i, boolean z, int i2) {
        if (i2 == 0) {
            return getZoneValue(i, z, new int[]{getFitnessThreshold(), getWarmUpThreshold(), getFatBurnThreshold(), getAerobicThreshold(), getAnaerobicThreshold(), getMaxThreshold()});
        }
        return getZoneValue(i, z, new int[]{getAerobicBaseThreshold(), getAerobicAdvanceThreshold(), getLacticAcidThreshold(), getAnaerobicBaseThreshold(), getAnaerobicAdvanceThreshold(), getMaxThreshold()});
    }

    private int getZoneValue(int i, boolean z, int[] iArr) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return z ? iArr[i] : iArr[i + 1] - 1;
        }
        if (i == 4) {
            return z ? iArr[i] : iArr[i + 1];
        }
        if (i < 0) {
            return iArr[0];
        }
        return iArr[5];
    }

    @Override // com.huawei.hwcommonmodel.fitnessdatatype.HeartRateZoneThreshold
    public String toString() {
        return "HeartZoneConf{warningEnble=" + this.warningEnble + ", warningLimitHR=" + this.warningLimitHR + ",warningEnbleHRR=" + this.warningEnbleHRR + ", warningLimitHRHRR=" + this.warningLimitHRHRR + ", clssifyMethod=" + this.classifyMethod + ", mRestHeartRate=" + this.mRestHeartRate + " " + super.toString() + '}';
    }
}
