package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videorender;

import android.graphics.Bitmap;
import android.view.Surface;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface RenderSurfaceListener {
    List<Surface> getVideoSurfaces();

    void onBitmapLoaded(Bitmap bitmap, String str);

    void onSurfaceBind(String str, int i);

    void onSurfaceUnBind(String str, int i);

    boolean queryBitmapIsCached(String str);

    void registerFrameAvailalbleLister(SurfaceFrameAvailableListener surfaceFrameAvailableListener);
}
