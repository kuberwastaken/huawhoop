package com.huawei.ui.main.stories.health.fragment.rqpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.huawei.health.R;
import com.huawei.ui.main.R$string;
import defpackage.tfz;

/* JADX INFO: loaded from: classes8.dex */
public class Vo2maxLevelHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10660a;
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private String h;
    private String i;

    public Vo2maxLevelHelper(Context context) {
        this.b = context;
        e();
    }

    private void e() {
        this.f = this.b.getString(R$string.IDS_device_hagrid_body_element_content_low);
        this.i = this.b.getString(R$string.IDS_hwh_health_vo2max_level_poor);
        this.h = this.b.getString(R$string.IDS_hwh_health_vo2max_level_fair);
        this.e = this.b.getString(R$string.IDS_hwh_health_vo2max_level_average);
        this.d = this.b.getString(R$string.IDS_hwh_health_vo2max_level_good);
        this.f10660a = this.b.getString(R$string.IDS_hwh_health_vo2max_level_verygood);
        this.c = this.b.getString(R$string.IDS_hwh_health_vo2max_level_excellent);
    }

    private SpannableStringBuilder dZj_() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "d").append((CharSequence) this.f).append((CharSequence) "d").append((CharSequence) this.i).append((CharSequence) "d").append((CharSequence) this.h).append((CharSequence) "d").append((CharSequence) this.e);
        if (this.g) {
            spannableStringBuilder.append((CharSequence) System.lineSeparator());
        }
        spannableStringBuilder.append((CharSequence) "d").append((CharSequence) this.d).append((CharSequence) "d").append((CharSequence) this.f10660a).append((CharSequence) "d").append((CharSequence) this.c);
        return spannableStringBuilder;
    }

    public SpannableStringBuilder dZk_(boolean z) {
        this.g = z;
        Drawable drawable = this.b.getDrawable(R.drawable._2131431753_res_0x7f0b1149);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        Drawable drawable2 = this.b.getDrawable(R.drawable._2131431752_res_0x7f0b1148);
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        Drawable drawable3 = this.b.getDrawable(R.drawable._2131431751_res_0x7f0b1147);
        drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
        Drawable drawable4 = this.b.getDrawable(R.drawable._2131431746_res_0x7f0b1142);
        drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
        Drawable drawable5 = this.b.getDrawable(R.drawable._2131431747_res_0x7f0b1143);
        drawable5.setBounds(0, 0, drawable5.getMinimumWidth(), drawable5.getMinimumHeight());
        Drawable drawable6 = this.b.getDrawable(R.drawable._2131431748_res_0x7f0b1144);
        drawable6.setBounds(0, 0, drawable6.getMinimumWidth(), drawable6.getMinimumHeight());
        Drawable drawable7 = this.b.getDrawable(R.drawable._2131431749_res_0x7f0b1145);
        drawable7.setBounds(0, 0, drawable7.getMinimumWidth(), drawable7.getMinimumHeight());
        SpannableStringBuilder spannableStringBuilderDZj_ = dZj_();
        spannableStringBuilderDZj_.setSpan(new tfz(drawable, 0, 15), 0, 1, 1);
        int length = this.f.length();
        int i = length + 1;
        spannableStringBuilderDZj_.setSpan(new tfz(drawable2, 30, 15), i, length + 2, 1);
        int length2 = i + this.i.length();
        int i2 = length2 + 1;
        spannableStringBuilderDZj_.setSpan(new tfz(drawable3, 30, 15), i2, length2 + 2, 1);
        int length3 = i2 + this.h.length();
        int i3 = length3 + 1;
        spannableStringBuilderDZj_.setSpan(new tfz(drawable4, 30, 15), i3, length3 + 2, 1);
        int length4 = i3 + this.e.length() + (this.g ? 2 : 1);
        spannableStringBuilderDZj_.setSpan(new tfz(drawable5, 30, 15), length4, length4 + 1, 1);
        int length5 = length4 + this.d.length();
        int i4 = length5 + 1;
        spannableStringBuilderDZj_.setSpan(new tfz(drawable6, 30, 15), i4, length5 + 2, 1);
        int length6 = i4 + this.f10660a.length();
        spannableStringBuilderDZj_.setSpan(new tfz(drawable7, 30, 15), length6 + 1, length6 + 2, 1);
        return spannableStringBuilderDZj_;
    }
}
