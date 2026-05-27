package androidx.media3.extractor.text.ssa;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
final class SsaDialogueFormat {
    public final int endTimeIndex;
    public final int length;
    public final int startTimeIndex;
    public final int styleIndex;
    public final int textIndex;

    private SsaDialogueFormat(int i, int i2, int i3, int i4, int i5) {
        this.startTimeIndex = i;
        this.endTimeIndex = i2;
        this.styleIndex = i3;
        this.textIndex = i4;
        this.length = i5;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static SsaDialogueFormat fromFormatLine(String str) {
        byte b;
        Assertions.checkArgument(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String lowerCase = Ascii.toLowerCase(strArrSplit[i5].trim());
            lowerCase.hashCode();
            switch (lowerCase.hashCode()) {
                case 100571:
                    b = lowerCase.equals(TtmlNode.END) ? (byte) 0 : (byte) -1;
                    break;
                case 3556653:
                    b = lowerCase.equals("text") ? (byte) 1 : (byte) -1;
                    break;
                case 109757538:
                    b = lowerCase.equals("start") ? (byte) 2 : (byte) -1;
                    break;
                case 109780401:
                    b = lowerCase.equals("style") ? (byte) 3 : (byte) -1;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i2 = i5;
            } else if (b == 1) {
                i4 = i5;
            } else if (b == 2) {
                i = i5;
            } else if (b == 3) {
                i3 = i5;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new SsaDialogueFormat(i, i2, i3, i4, strArrSplit.length);
    }
}
