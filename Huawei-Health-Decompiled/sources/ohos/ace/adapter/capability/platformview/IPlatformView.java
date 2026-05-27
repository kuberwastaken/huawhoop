package ohos.ace.adapter.capability.platformview;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public interface IPlatformView {
    String getPlatformViewID();

    View getView();

    void onDispose();
}
