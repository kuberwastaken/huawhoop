package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes6.dex */
public class am extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8325a;

    public interface a {
        void a(View view, int i, int i2, int i3, int i4);
    }

    public void setScrollChangedListener(a aVar) {
        this.f8325a = aVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.f8325a;
        if (aVar != null) {
            aVar.a(this, i, i2, i3, i4);
        }
    }

    public am(Context context) {
        super(context);
    }
}
