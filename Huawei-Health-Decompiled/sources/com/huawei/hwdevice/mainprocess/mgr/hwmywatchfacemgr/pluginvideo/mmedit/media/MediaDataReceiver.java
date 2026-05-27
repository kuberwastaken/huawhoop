package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.mmedit.media;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public interface MediaDataReceiver {

    public enum StreamType {
        VIDEO_STREAM
    }

    int onDataReceive(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, StreamType streamType);
}
