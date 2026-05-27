package com.huawei.animationkit.computationalwallpaper.generator;

import android.graphics.Bitmap;
import android.os.Parcelable;
import defpackage.awb;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public interface Wallpaper extends Parcelable {
    WatchFaceClock getClock();

    String getTag();

    void save(File file) throws awb;

    Bitmap toBitmap();
}
