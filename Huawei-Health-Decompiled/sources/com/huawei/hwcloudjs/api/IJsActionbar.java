package com.huawei.hwcloudjs.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes11.dex */
public interface IJsActionbar {
    Drawable getActionbarBackground();

    String getActionbarTitle();

    Drawable getBackLayoutBackground();

    ActionbarClickListenner getStartClickListenner();

    Drawable getStartIcon();

    void handleOptionsItemSelected(MenuItem menuItem);

    boolean isShow();

    void setContext(Context context);

    void setControlIcon(Context context, WebView webView, String str, View view, Menu menu);

    String textcolorID();
}
