package com.huawei.skinner.internal;

import android.graphics.drawable.Drawable;
import defpackage.ouk;

/* JADX INFO: loaded from: classes11.dex */
public interface IThemeService {
    int getCurrentAccentColor();

    int getCustomThemeColor();

    ouk getThemeInfo();

    Drawable themeBackground();

    void updateThemeInfo(ouk oukVar);
}
