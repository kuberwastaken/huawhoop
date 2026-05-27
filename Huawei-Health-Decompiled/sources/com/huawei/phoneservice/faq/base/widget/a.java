package com.huawei.phoneservice.faq.base.widget;

import android.app.ActionBar;
import android.content.res.ColorStateList;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f8539a;
    private static boolean b;
    private static CharSequence c;
    private static ColorStateList d;
    private static Boolean e;

    private static void cjY_(ActionBar actionBar) {
        View customView = actionBar.getCustomView();
        if (customView == null || customView.getTag() == null) {
            return;
        }
        TextView textView = (TextView) cjS_(customView, R.id.title);
        ColorStateList colorStateList = d;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        float f = f8539a;
        if (f != 0.0f) {
            textView.setTextSize(0, f);
        }
    }

    public static void cjX_(ActionBar actionBar, CharSequence charSequence) {
        c = charSequence;
        View customView = actionBar.getCustomView();
        if (customView == null || customView.getTag() == null) {
            return;
        }
        ((TextView) cjS_(customView, R.id.title)).setText(c);
    }

    public static void cjW_(ActionBar actionBar, boolean z) {
        actionBar.setHomeButtonEnabled(c() && z);
    }

    public static void cjV_(ActionBar actionBar, boolean z, View.OnClickListener onClickListener) {
        actionBar.setDisplayHomeAsUpEnabled(c() && z);
        View customView = c() ? actionBar.getCustomView() : cjT_(actionBar);
        if (customView != null && customView.getTag() != null) {
            View viewCjS_ = cjS_(customView, R.id.btn_start);
            viewCjS_.setOnClickListener(onClickListener);
            viewCjS_.setVisibility(z ? 0 : 8);
        }
        b = z;
    }

    public static boolean c() {
        synchronized (a.class) {
            if (e == null) {
                e = Boolean.valueOf(a("com.huawei.android.app.ActionBarEx") && a("huawei.com.android.internal.app.HwActionBarImpl"));
            }
        }
        return e.booleanValue();
    }

    private static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void cjU_(ActionBar actionBar, TextView textView) {
        d = textView.getTextColors();
        f8539a = textView.getTextSize();
        cjY_(actionBar);
    }

    private static View cjT_(ActionBar actionBar) {
        View customView = actionBar.getCustomView();
        if (customView != null) {
            return customView;
        }
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-1, -1);
        View viewInflate = LayoutInflater.from(actionBar.getThemedContext()).inflate(R.layout.faq_base_sdk_actionbar_layout, (ViewGroup) new LinearLayout(actionBar.getThemedContext()), false);
        actionBar.setCustomView(viewInflate, layoutParams);
        TextView textView = (TextView) cjS_(viewInflate, R.id.title);
        CharSequence title = c;
        if (title == null) {
            title = actionBar.getTitle();
        }
        textView.setText(title);
        cjY_(actionBar);
        cjS_(viewInflate, R.id.btn_start).setVisibility(b ? 0 : 8);
        return viewInflate;
    }

    protected static <T extends View> T cjS_(View view, int i) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            view.setTag(sparseArray);
        }
        T t = (T) sparseArray.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) view.findViewById(i);
        sparseArray.put(i, t2);
        return t2;
    }
}
