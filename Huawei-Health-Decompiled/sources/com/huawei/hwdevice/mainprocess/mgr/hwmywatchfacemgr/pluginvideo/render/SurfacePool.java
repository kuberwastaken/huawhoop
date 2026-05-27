package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.render;

import android.view.Surface;
import com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videorender.RenderSurfaceListener;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface SurfacePool {
    void setSurfacePool(List<Surface> list, RenderSurfaceListener renderSurfaceListener);
}
