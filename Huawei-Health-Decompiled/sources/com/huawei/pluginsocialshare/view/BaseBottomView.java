package com.huawei.pluginsocialshare.view;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseBottomView {
    public abstract View getRootView();

    public abstract void onActivityResult(int i, Intent intent);

    public abstract void onDeleteSticker(int i);

    public abstract void onTemplateSelected(int i);
}
