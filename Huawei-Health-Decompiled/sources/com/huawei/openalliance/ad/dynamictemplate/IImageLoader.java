package com.huawei.openalliance.ad.dynamictemplate;

import android.widget.ImageView;
import com.huawei.openalliance.ad.dynamictemplate.view.IDrawableSetter;

/* JADX INFO: loaded from: classes11.dex */
public interface IImageLoader {
    void load(ImageView imageView, String str);

    void loadDrawable(IDrawableSetter iDrawableSetter, String str);
}
