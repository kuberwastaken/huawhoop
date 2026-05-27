package com.huawei.ui.commonui.calendarview;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class HealthMark implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9128a;
    private transient Drawable b;
    private String c;
    private int d;
    private boolean e;
    private int g;
    private MarkType i;
    private transient View j;

    public enum MarkType {
        TEXT,
        COLOR,
        DRAWABLE,
        TEXT_DRAWABLE,
        VIEW
    }

    public HealthMark() {
        this.i = MarkType.DRAWABLE;
    }

    public HealthMark(MarkType markType) {
        MarkType markType2 = MarkType.DRAWABLE;
        this.i = markType;
    }

    public HealthMark(Drawable drawable, String str, int i) {
        this.i = MarkType.DRAWABLE;
        this.b = drawable;
        this.c = str;
        this.d = i;
        this.i = MarkType.DRAWABLE;
        this.e = true;
    }

    public boolean g() {
        return this.e;
    }

    public MarkType f() {
        return this.i;
    }

    public void a(MarkType markType) {
        this.i = markType;
    }

    public int e() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
        this.e = true;
        this.i = MarkType.COLOR;
    }

    public void cHz_(Drawable drawable) {
        this.b = drawable;
        this.i = MarkType.DRAWABLE;
    }

    public String d() {
        return this.c;
    }

    public View cHy_() {
        return this.j;
    }

    public Drawable cHx_() {
        return this.b;
    }

    public void cHA_(View view) {
        this.j = view;
        this.i = MarkType.VIEW;
    }

    public void d(int i) {
        View view = this.j;
        if (view == null || view.getMeasuredHeight() > 0) {
            return;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        this.j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        this.j.layout(0, 0, this.j.getMeasuredWidth(), this.j.getMeasuredHeight());
    }

    public int c() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public int b() {
        return this.f9128a;
    }
}
