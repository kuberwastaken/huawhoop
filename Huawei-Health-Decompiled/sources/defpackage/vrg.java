package defpackage;

import com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
class vrg implements WifiP2pSendFileInterface {
    vrg() {
    }

    @Override // com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface
    public int getSocketBufferLength(vrk vrkVar) {
        return getReadLength(vrkVar);
    }

    @Override // com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface
    public ByteBuffer wrapSendData(ByteBuffer byteBuffer, long j, int i) {
        if (byteBuffer == null || i != 0) {
            return byteBuffer;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.array().length + 5);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(chj.a(chj.e(j)));
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(chj.h(i));
        System.arraycopy(byteBufferWrap.array(), 0, byteBufferAllocate.array(), 0, 4);
        System.arraycopy(byteBufferWrap2.array(), 0, byteBufferAllocate.array(), 4, 1);
        System.arraycopy(byteBuffer.array(), 0, byteBufferAllocate.array(), 5, byteBuffer.array().length);
        return byteBufferAllocate;
    }

    @Override // com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface
    public int readFile(ByteBuffer byteBuffer, long j, FileInputStream fileInputStream) throws IOException {
        if (byteBuffer == null || fileInputStream == null) {
            return 0;
        }
        return fileInputStream.getChannel().read(byteBuffer, j);
    }

    @Override // com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface
    public void writeSocket(DataOutputStream dataOutputStream, ByteBuffer byteBuffer, int i, int i2) throws IOException {
        if (dataOutputStream == null || byteBuffer == null) {
            return;
        }
        if (i2 == 0) {
            dataOutputStream.write(byteBuffer.array(), 0, i + 5);
        } else {
            dataOutputStream.write(byteBuffer.array(), 0, i);
        }
    }

    @Override // com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface
    public int getReadLength(vrk vrkVar) {
        if (vrkVar == null) {
            return 147456;
        }
        return (int) Math.min(vrkVar.p(), 147456L);
    }

    @Override // com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface
    public long getWantSendLength(vrk vrkVar) {
        if (vrkVar == null) {
            return 0L;
        }
        return vrkVar.p() + vrkVar.n();
    }

    @Override // com.huawei.unitedevice.hwwifip2ptransfermgr.WifiP2pSendFileInterface
    public long getDeviceReceived(vrk vrkVar) {
        if (vrkVar == null) {
            return 0L;
        }
        return vrkVar.r() + vrkVar.s();
    }
}
