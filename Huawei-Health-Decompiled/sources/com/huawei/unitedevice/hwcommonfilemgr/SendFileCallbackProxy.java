package com.huawei.unitedevice.hwcommonfilemgr;

import android.os.RemoteException;
import com.huawei.health.deviceconnect.callback.SendCallback;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.kit.awareness.barrier.internal.e.a;
import com.huawei.unitedevice.callback.IResultAIDLCallback;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes11.dex */
public class SendFileCallbackProxy extends IResultAIDLCallback.Stub {
    private SendCallback e;

    public SendFileCallbackProxy(SendCallback sendCallback) {
        this.e = sendCallback;
    }

    @Override // com.huawei.unitedevice.callback.IResultAIDLCallback
    public void onFileTransferState(int i, String str) throws RemoteException {
        LogUtil.c("SendFileCallbackProxy", "onFileTransferState enter");
        this.e.onSendProgress(i);
    }

    @Override // com.huawei.unitedevice.callback.IResultAIDLCallback
    public void onTransferFailed(int i, String str) throws RemoteException {
        LogUtil.c("SendFileCallbackProxy", "onUpgradeFailed enter");
        SendCallback sendCallback = this.e;
        if (sendCallback != null) {
            sendCallback.onSendResult(a(i));
        }
    }

    @Override // com.huawei.unitedevice.callback.IResultAIDLCallback
    public void onFileRespond(int i, String str) throws RemoteException {
        LogUtil.c("SendFileCallbackProxy", "onFileRespond enter");
        SendCallback sendCallback = this.e;
        if (sendCallback != null) {
            sendCallback.onSendResult(a(i));
        }
    }

    @Override // com.huawei.unitedevice.callback.IResultAIDLCallback
    public void onFileTransferReport(String str) throws RemoteException {
        LogUtil.c("SendFileCallbackProxy", "onFileTransferReport enter");
        SendCallback sendCallback = this.e;
        if (sendCallback != null) {
            sendCallback.onFileTransferReport(str);
        }
    }

    private int a(int i) {
        LogUtil.a("SendFileCallbackProxy", "getInnerErrorCode old errorCode: ", Integer.valueOf(i));
        if (i == 1) {
            return a.w;
        }
        int iAbs = (Math.abs(i) % ExceptionCode.CRASH_EXCEPTION) + 1990000000;
        LogUtil.a("SendFileCallbackProxy", "getInnerErrorCode new errorCode: ", Integer.valueOf(iAbs));
        return iAbs;
    }
}
