package com.huawei.health.suggestion.config;

import com.huawei.health.R;
import defpackage.pla;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public enum MeasurementModeTab {
    TAB_INDEX_ZERO(10, getCountTabNameArray(), getTabTypeArrayByMeasurement(10)),
    TAB_INDEX_ONE(1, getTimeTabNameArray(), getTabTypeArrayByMeasurement(1));

    private int mAIMeasurement;
    private String[] mTabName;
    private int[] mTargetType;

    public static int[] getTabTypeArrayByMeasurement(int i) {
        HashMap map = new HashMap(2);
        map.put(10, new int[]{10, 1, -1});
        map.put(1, new int[]{1, -1});
        return (int[]) map.get(Integer.valueOf(i));
    }

    public static String[] getModeTabName(int i) {
        for (MeasurementModeTab measurementModeTab : values()) {
            if (measurementModeTab.getAIMeasurement() == i) {
                return measurementModeTab.getTabName();
            }
        }
        return getTimeTabNameArray();
    }

    private static String[] getCountTabNameArray() {
        return new String[]{pla.h(R.string._2130849959_res_0x7f0230a7), pla.h(R.string._2130849958_res_0x7f0230a6), pla.h(R.string._2130849960_res_0x7f0230a8)};
    }

    private static String[] getTimeTabNameArray() {
        return new String[]{pla.h(R.string._2130849958_res_0x7f0230a6), pla.h(R.string._2130849960_res_0x7f0230a8)};
    }

    public int getAIMeasurement() {
        return this.mAIMeasurement;
    }

    public void setAIMeasurement(int i) {
        this.mAIMeasurement = i;
    }

    public String[] getTabName() {
        return this.mTabName;
    }

    public void setTabName(String[] strArr) {
        this.mTabName = strArr;
    }

    public int[] getTargetType() {
        return this.mTargetType;
    }

    public void setTargetType(int[] iArr) {
        this.mTargetType = iArr;
    }

    MeasurementModeTab(int i, String[] strArr, int[] iArr) {
        this.mAIMeasurement = i;
        this.mTabName = strArr;
        this.mTargetType = iArr;
    }

    public static boolean isMatch(int i, int i2) {
        int[] targetType;
        for (MeasurementModeTab measurementModeTab : values()) {
            if (i2 == measurementModeTab.getAIMeasurement() && (targetType = measurementModeTab.getTargetType()) != null) {
                for (int i3 : targetType) {
                    if (i == i3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
