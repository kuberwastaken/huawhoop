package com.huawei.phoneservice.feedback.entity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class c implements Serializable {
    private static final long serialVersionUID = -3865037260659453289L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f8552a;
    private String b;
    private TextView c;
    private View d;
    private ImageView e;
    private String f;
    private int h;

    public View cks_() {
        return this.d;
    }

    public TextView ckr_() {
        return this.c;
    }

    public String b() {
        return this.f;
    }

    public String e() {
        return this.b;
    }

    public int a() {
        return this.h;
    }

    public void b(String str) {
        this.f = str;
    }

    public void ckq_(ImageView imageView) {
        this.f8552a = imageView;
    }

    public ImageView ckp_() {
        return this.f8552a;
    }

    public void a(String str) {
        this.b = str;
    }

    public void cko_(TextView textView) {
        this.c = textView;
    }

    public void ckn_(ImageView imageView) {
        this.e = imageView;
    }

    public void a(View view) {
        this.d = view;
    }

    public void b(int i) {
        this.h = i;
    }

    public ImageView ckm_() {
        return this.e;
    }
}
