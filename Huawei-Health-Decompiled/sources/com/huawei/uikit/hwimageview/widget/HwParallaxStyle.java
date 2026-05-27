package com.huawei.uikit.hwimageview.widget;

import android.graphics.Canvas;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes11.dex */
public interface HwParallaxStyle {
    void onAttachedToImageView(ImageView imageView);

    void onDetachedFromImageView(ImageView imageView);

    void transform(ImageView imageView, Canvas canvas, int[] iArr, int[] iArr2);
}
