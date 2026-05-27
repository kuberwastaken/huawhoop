package com.huawei.unitedevice.hwwifip2ptransfermgr;

import defpackage.vrk;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public interface WifiP2pSendFileInterface {
    long getDeviceReceived(vrk vrkVar);

    int getReadLength(vrk vrkVar);

    int getSocketBufferLength(vrk vrkVar);

    long getWantSendLength(vrk vrkVar);

    int readFile(ByteBuffer byteBuffer, long j, FileInputStream fileInputStream) throws IOException;

    ByteBuffer wrapSendData(ByteBuffer byteBuffer, long j, int i);

    void writeSocket(DataOutputStream dataOutputStream, ByteBuffer byteBuffer, int i, int i2) throws IOException;
}
