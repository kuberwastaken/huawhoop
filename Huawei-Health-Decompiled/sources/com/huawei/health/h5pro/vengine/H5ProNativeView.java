package com.huawei.health.h5pro.vengine;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class H5ProNativeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public H5ProEventInterceptor f2505a;
    public View d;
    public String e;

    public void setView(View view) {
        this.d = view;
    }

    public void setEventInterceptor(H5ProEventInterceptor h5ProEventInterceptor) {
        this.f2505a = h5ProEventInterceptor;
    }

    public void setData(String str) {
        this.e = str;
    }

    public View getView() {
        return this.d;
    }

    public H5ProEventInterceptor getEventInterceptor() {
        return this.f2505a;
    }

    public String getData() {
        return this.e;
    }

    public H5ProNativeView(View view, String str) {
        this.d = view;
        this.e = str;
    }

    public H5ProNativeView(View view) {
        this.d = view;
    }

    public H5ProNativeView() {
    }
}
