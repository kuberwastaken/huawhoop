package com.picooc.health.formula;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import defpackage.xbd;
import huawei.android.hwcolorpicker.HwColorPicker;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes8.dex */
public class Formula {
    protected static native float[] calculateBasicDataByImpedanceOldVersion2(int i, float f, int i2, float f2, int i3);

    static {
        System.loadLibrary("dataFormula");
    }

    public static byte[] c(byte[] bArr) {
        byte b = bArr[0];
        if (b == 48) {
            return new byte[]{-15, 3, 48};
        }
        if (b == 53) {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            return new byte[]{-15, 8, 53, (byte) ((4278190080L & jCurrentTimeMillis) >> 24), (byte) ((16711680 & jCurrentTimeMillis) >> 16), (byte) ((65280 & jCurrentTimeMillis) >> 8), (byte) (jCurrentTimeMillis & 255), 0};
        }
        if (b == 54) {
            return new byte[]{-15, 3, 54};
        }
        if (b == 55) {
            return new byte[]{-15, 3, 55};
        }
        if (b == 57) {
            return new byte[]{-15, 3, 57};
        }
        return new byte[0];
    }

    public static xbd c(byte[] bArr, float f, int i, int i2) {
        xbd xbdVar = new xbd();
        byte b = bArr[0];
        if (b != 48 && b != 53) {
            if (b == 54) {
                long j = ((bArr[2] << Ascii.CAN) & (-16777216)) + ((bArr[3] << 16) & HwColorPicker.MASK_RESULT_STATE) + ((bArr[4] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[5] & UnsignedBytes.MAX_VALUE);
                float fRound = Math.round(((((bArr[6] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[7] & UnsignedBytes.MAX_VALUE)) / 20.0f) * 10.0f) / 10.0f;
                float[] fArrCalculateBasicDataByImpedanceOldVersion2 = calculateBasicDataByImpedanceOldVersion2(i, f, i2, fRound, (((bArr[8] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[9] & UnsignedBytes.MAX_VALUE)) / 10);
                xbdVar.e(2);
                xbdVar.c(fRound);
                xbdVar.d(fArrCalculateBasicDataByImpedanceOldVersion2[1]);
                xbdVar.e(fArrCalculateBasicDataByImpedanceOldVersion2[2]);
                xbdVar.d(j * 1000);
            } else if (b == 55) {
                xbdVar.e(3);
            } else if (b == 57) {
                long j2 = ((bArr[2] << Ascii.CAN) & (-16777216)) + ((bArr[3] << 16) & HwColorPicker.MASK_RESULT_STATE) + ((bArr[4] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[5] & UnsignedBytes.MAX_VALUE);
                float fRound2 = Math.round(((((bArr[6] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[7] & UnsignedBytes.MAX_VALUE)) / 20.0f) * 10.0f) / 10.0f;
                if (fRound2 > 0.0f) {
                    float[] fArrCalculateBasicDataByImpedanceOldVersion22 = calculateBasicDataByImpedanceOldVersion2(i, f, i2, fRound2, c((((bArr[8] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr[9] & UnsignedBytes.MAX_VALUE)) / 100.0f) * 10);
                    xbdVar.e(1);
                    xbdVar.c(fRound2);
                    xbdVar.d(fArrCalculateBasicDataByImpedanceOldVersion22[1]);
                    xbdVar.e(fArrCalculateBasicDataByImpedanceOldVersion22[2]);
                    xbdVar.d(j2 * 1000);
                }
            }
        }
        return xbdVar;
    }

    private static int c(float f) {
        return new BigDecimal(f).setScale(0, 4).intValue();
    }
}
