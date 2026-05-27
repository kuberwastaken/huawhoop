package com.huawei.ui.main.stories.health.fragment.rqpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.huawei.health.R;
import com.huawei.ui.main.R$string;
import defpackage.tfz;

/* JADX INFO: loaded from: classes8.dex */
public class StateIndexDayHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10659a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private String h;

    public StateIndexDayHelper(Context context) {
        this.f10659a = context;
        a();
    }

    private void a() {
        this.h = this.f10659a.getString(R$string.IDS_data_index_very_pool);
        this.d = this.f10659a.getString(R$string.IDS_data_index_pool);
        this.b = this.f10659a.getString(R$string.IDS_data_index_normal);
        this.f = this.f10659a.getString(R$string.IDS_data_index_well);
        this.c = this.f10659a.getString(R$string.IDS_data_index_very_well);
    }

    private SpannableStringBuilder dZh_() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "d").append((CharSequence) this.h).append((CharSequence) "d").append((CharSequence) this.d).append((CharSequence) "d").append((CharSequence) this.b);
        if (this.e) {
            spannableStringBuilder.append((CharSequence) System.lineSeparator());
        }
        spannableStringBuilder.append((CharSequence) "d").append((CharSequence) this.f).append((CharSequence) "d").append((CharSequence) this.c);
        return spannableStringBuilder;
    }

    public SpannableStringBuilder dZi_(boolean z) {
        this.e = z;
        Drawable drawable = this.f10659a.getDrawable(R.drawable._2131431753_res_0x7f0b1149);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        Drawable drawable2 = this.f10659a.getDrawable(R.drawable._2131431752_res_0x7f0b1148);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        Drawable drawable3 = this.f10659a.getDrawable(R.drawable._2131431746_res_0x7f0b1142);
        drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
        Drawable drawable4 = this.f10659a.getDrawable(R.drawable._2131431747_res_0x7f0b1143);
        drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
        Drawable drawable5 = this.f10659a.getDrawable(R.drawable._2131431749_res_0x7f0b1145);
        drawable5.setBounds(0, 0, drawable5.getMinimumWidth(), drawable5.getMinimumHeight());
        SpannableStringBuilder spannableStringBuilderDZh_ = dZh_();
        spannableStringBuilderDZh_.setSpan(new tfz(drawable, 0, 15), 0, 1, 1);
        int length = this.h.length();
        int i = length + 1;
        spannableStringBuilderDZh_.setSpan(new tfz(drawable2, 70, 15), i, length + 2, 1);
        int length2 = i + this.d.length();
        int i2 = length2 + 1;
        spannableStringBuilderDZh_.setSpan(new tfz(drawable3, 70, 15), i2, length2 + 2, 1);
        int length3 = i2 + this.b.length() + (this.e ? 2 : 1);
        spannableStringBuilderDZh_.setSpan(new tfz(drawable4, 70, 15), length3, length3 + 1, 1);
        int length4 = length3 + this.f.length();
        spannableStringBuilderDZh_.setSpan(new tfz(drawable5, 70, 15), length4 + 1, length4 + 2, 1);
        this.c.length();
        return spannableStringBuilderDZh_;
    }
}
