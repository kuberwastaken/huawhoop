package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.videorender;

import com.huawei.watchface.videoedit.gles.drawer.RenderNode;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface RenderNodeSelectListener {
    List<RenderNode> selectNode(float f, float f2, long j);

    List<RenderNode> selectNode(String str);
}
