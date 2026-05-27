package com.huawei.animationkit.computationalwallpaper.pattern.pattern;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import com.huawei.animationkit.computationalwallpaper.coloranalysis.ColorResult;
import com.huawei.animationkit.computationalwallpaper.pattern.UpdateListener;
import defpackage.awb;
import java.io.File;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes10.dex */
public interface Pattern extends Parcelable {
    default void cancelAnimation() {
    }

    void draw(Canvas canvas);

    Rect getBounds();

    List<Integer> getFinalColors() throws awb;

    String getTag();

    default void goFirstFrame() {
    }

    default void load(File file, Properties properties, ColorResult colorResult) throws awb {
    }

    void releaseBitmap();

    default void save(File file, Properties properties) throws awb {
    }

    void setBounds(Rect rect);

    void setColor(ColorResult colorResult);

    void setResource(List<String> list) throws awb;

    void setTag(String str);

    default void setUpdateListener(UpdateListener updateListener) {
    }

    default void startAnimation() {
    }

    Bitmap toBitmap();
}
