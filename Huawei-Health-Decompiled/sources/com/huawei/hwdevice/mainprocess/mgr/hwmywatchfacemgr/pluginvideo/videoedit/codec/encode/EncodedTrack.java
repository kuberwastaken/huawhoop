package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.codec.encode;

/* JADX INFO: loaded from: classes6.dex */
public interface EncodedTrack {
    public static final int INVALID_INDEX = -1;

    int getTrackIndex();

    boolean isAddedToMuxer();

    boolean isTrackFinished();
}
