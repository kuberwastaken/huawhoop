package com.huawei.hwdevice.api;

import com.huawei.hwbasemgr.ResponseCallback;
import com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.h5pro.TransferProgressResp;
import com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.h5pro.TransmitWatchFace;
import com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.weardevice.AlbumWatchFaceInfo;
import com.huawei.networkclient.ResultCallback;

/* JADX INFO: loaded from: classes5.dex */
public interface AlbumWatchFaceApi {
    void getAlbumWatchFacePath(int i, ResponseCallback<String> responseCallback);

    void getColorPictures(String str, ResultCallback<String> resultCallback);

    void getDeviceWatchFaceInfo(ResultCallback<TransmitWatchFace<AlbumWatchFaceInfo>> resultCallback);

    void getSmartPictureList(String str, ResultCallback<String> resultCallback);

    void setAlbumWatchFaceInfo(String str, ResultCallback<TransferProgressResp> resultCallback);
}
