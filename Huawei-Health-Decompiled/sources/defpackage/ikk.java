package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;

/* JADX INFO: loaded from: classes5.dex */
public class ikk {
    public static SpannableString bfn_(Context context, String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        bfm_(context, spannableString, i);
        return spannableString;
    }

    private static ikm b(Context context, int i, int i2) {
        Drawable drawable = context.getResources().getDrawable(i);
        int i3 = (i2 * 13) / 10;
        drawable.setBounds(0, 0, i3, i3);
        return new ikm(drawable);
    }

    private static void bfm_(Context context, SpannableString spannableString, int i) {
        for (int i2 = 0; i2 < spannableString.length(); i2++) {
            if (spannableString.charAt(i2) == '[') {
                int i3 = i2 + 4;
                if (i3 > spannableString.length()) {
                    return;
                }
                int iA = ikn.a(spannableString.subSequence(i2, i3).toString());
                if (iA > 0) {
                    spannableString.setSpan(b(context, iA, i), i2, i3, 33);
                }
            }
        }
    }
}
