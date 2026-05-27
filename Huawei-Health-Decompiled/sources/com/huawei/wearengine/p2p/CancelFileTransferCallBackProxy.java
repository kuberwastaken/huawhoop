package com.huawei.wearengine.p2p;

import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.kit.awareness.barrier.internal.e.a;
import com.huawei.hwservicesmgr.IBaseCallback;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes8.dex */
public class CancelFileTransferCallBackProxy extends IBaseCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11761a;
    private SendFileCallbackCleanup b;
    private P2pCancelFileTransferCallBack c;
    private String d;
    private String e;

    public CancelFileTransferCallBackProxy(SendFileCallbackCleanup sendFileCallbackCleanup, P2pCancelFileTransferCallBack p2pCancelFileTransferCallBack, String str, String str2, String str3) {
        this.b = sendFileCallbackCleanup;
        this.c = p2pCancelFileTransferCallBack;
        this.e = str;
        this.d = str2;
        this.f11761a = str3;
    }

    @Override // com.huawei.hwservicesmgr.IBaseCallback
    public void onResponse(int i, String str) {
        LogUtil.a("WearEngine_CancelFileTransferCallBackProxy", "CancelFileTransferCallBackProxy onResponse enter, errCode: " + i);
        try {
            this.c.onCancelFileTransferResult(b(i), str);
        } catch (Exception unused) {
            LogUtil.d("WearEngine_CancelFileTransferCallBackProxy", "CancelFileTransferCallBackProxy onResponse Exception");
        }
        this.b.onCleanupCancelFileTransfer(this, this.e, this.d, this.f11761a);
    }

    private int b(int i) {
        LogUtil.a("WearEngine_CancelFileTransferCallBackProxy", "getInnerErrorCode old errorCode:" + i);
        if (i == 20003) {
            return a.w;
        }
        int iAbs = (Math.abs(i) % ExceptionCode.CRASH_EXCEPTION) + 1990000000;
        LogUtil.a("WearEngine_CancelFileTransferCallBackProxy", "getInnerErrorCode new errorCode:" + iAbs);
        return iAbs;
    }
}
