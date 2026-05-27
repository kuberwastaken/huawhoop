package ohos.ace.adapter.capability.editing;

import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class TextInputFilter implements InputFilter {
    private String filterRule;
    private int maxLength = -1;
    private TextInputErrorTextHandler handler = null;

    public TextInputFilter(String str) {
        this.filterRule = str;
    }

    public void setMaxLength(int i) {
        this.maxLength = i;
    }

    private boolean isMatch(char c) {
        return Character.toString(c).matches(this.filterRule);
    }

    public void setTextInputErrorTextHandler(TextInputErrorTextHandler textInputErrorTextHandler) {
        this.handler = textInputErrorTextHandler;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence.toString())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i5 = i; i5 < i2; i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (isMatch(cCharAt)) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        if (this.handler != null && sb2.length() > 0) {
            this.handler.onTextInputErrorTextChanged(sb2.toString());
        }
        if (!(charSequence instanceof Spanned)) {
            return sb;
        }
        SpannableString spannableString = new SpannableString(sb);
        TextUtils.copySpansFrom((Spanned) charSequence, i, sb.length(), null, spannableString, 0);
        return spannableString;
    }
}
