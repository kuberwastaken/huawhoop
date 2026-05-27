package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.codec.encode;

import com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.codec.CodecContext;
import com.huawei.watchface.videoedit.utils.Releasable;

/* JADX INFO: loaded from: classes6.dex */
public interface Encoder extends Releasable, Initializable {
    void encodeFrame(CodecContext codecContext, boolean z, long j) throws Exception;
}
