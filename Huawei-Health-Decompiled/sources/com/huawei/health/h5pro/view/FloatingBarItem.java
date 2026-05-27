package com.huawei.health.h5pro.view;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public class FloatingBarItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f2507a;
    public String c;
    public View.OnClickListener e;

    public void setDistName(String str) {
        this.c = str;
    }

    public void setDistIcon(Drawable drawable) {
        this.f2507a = drawable;
    }

    public void setClickCallback(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public String getDistName() {
        return this.c;
    }

    public Drawable getDistIcon() {
        return this.f2507a;
    }

    public View.OnClickListener getClickCallback() {
        return this.e;
    }

    public FloatingBarItem(String str, Drawable drawable, View.OnClickListener onClickListener) {
        this.c = str;
        this.f2507a = drawable;
        this.e = onClickListener;
    }
}
