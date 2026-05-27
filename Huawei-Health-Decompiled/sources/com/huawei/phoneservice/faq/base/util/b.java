package com.huawei.phoneservice.faq.base.util;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class b implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f8532a = Pattern.compile("[\\u0733\\u0734\\u0736\\u0737]");

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.f8532a.matcher(charSequence).find()) {
            return "";
        }
        return null;
    }
}
