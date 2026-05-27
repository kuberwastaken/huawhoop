package defpackage;

import com.careforeyou.library.enums.Weight_Digit;
import com.careforeyou.library.enums.Weight_Unit;
import com.google.common.primitives.UnsignedBytes;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes3.dex */
public class wo {
    public static float b(float f) {
        return f * 0.5f;
    }

    public static float e(float f) {
        return f * 0.4535924f;
    }

    public static float b(String str) {
        return new BigDecimal(str.split(":").length == 2 ? e((Integer.parseInt(r3[0]) * 14) + Float.parseFloat(r3[1])) : 0.0f).setScale(3, 4).floatValue();
    }

    public static wg d(byte b, byte b2, byte b3, boolean z) {
        Weight_Digit weight_DigitJ;
        if (z) {
            weight_DigitJ = wh.a(b3);
        } else {
            weight_DigitJ = wh.j(b3);
        }
        return b(b, b2, b3, weight_DigitJ, false);
    }

    public static wg b(byte b, byte b2, byte b3, Weight_Digit weight_Digit, boolean z) {
        Weight_Unit weight_UnitI;
        float fB;
        if (z) {
            weight_UnitI = wh.h(b3);
        } else {
            weight_UnitI = wh.i(b3);
        }
        wg wgVar = new wg();
        int i = 0;
        byte[] bArr = {b, b2};
        if (weight_Digit == Weight_Digit.ONE) {
            fB = wh.b(bArr) / 10.0f;
            i = 1;
        } else if (weight_Digit == Weight_Digit.TWO) {
            fB = wh.b(bArr) / 100.0f;
            i = 2;
        } else {
            fB = wh.b(bArr);
        }
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(FilenameUtils.EXTENSION_SEPARATOR);
        float fFloatValue = new BigDecimal(fB).setScale(i, 4).floatValue();
        if (weight_UnitI == Weight_Unit.ST) {
            wgVar.d = (b & UnsignedBytes.MAX_VALUE) + ":" + ((b2 & UnsignedBytes.MAX_VALUE) / 10.0f);
        } else if (i == 0) {
            wgVar.d = "" + ((int) fFloatValue);
        } else if (i == 1) {
            wgVar.d = new DecimalFormat("#0.0", decimalFormatSymbols).format(fFloatValue);
        } else if (i == 2) {
            wgVar.d = new DecimalFormat("#0.00", decimalFormatSymbols).format(fFloatValue);
        }
        if (weight_UnitI == Weight_Unit.JIN) {
            wgVar.f18848a = b(fFloatValue);
        } else if (weight_UnitI == Weight_Unit.LB) {
            wgVar.f18848a = e(fFloatValue);
        } else if (weight_UnitI == Weight_Unit.ST) {
            wgVar.f18848a = b(wgVar.d);
        } else {
            wgVar.f18848a = fFloatValue;
        }
        wgVar.f18848a = new BigDecimal(wgVar.f18848a).setScale(i, 4).doubleValue();
        return wgVar;
    }
}
