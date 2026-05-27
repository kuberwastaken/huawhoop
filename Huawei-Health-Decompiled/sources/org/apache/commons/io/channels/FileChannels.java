package org.apache.commons.io.channels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public final class FileChannels {
    public static boolean contentEquals(FileChannel fileChannel, FileChannel fileChannel2, int i) throws IOException {
        if (Objects.equals(fileChannel, fileChannel2)) {
            return true;
        }
        long size = size(fileChannel);
        long size2 = size(fileChannel2);
        if (size != size2) {
            return false;
        }
        if (size == 0 && size2 == 0) {
            return true;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(i);
        do {
            int i2 = fileChannel.read(byteBufferAllocateDirect);
            int i3 = fileChannel2.read(byteBufferAllocateDirect2);
            byteBufferAllocateDirect.clear();
            byteBufferAllocateDirect2.clear();
            if (i2 == -1 && i3 == -1) {
                return byteBufferAllocateDirect.equals(byteBufferAllocateDirect2);
            }
            if (i2 != i3) {
                return false;
            }
        } while (byteBufferAllocateDirect.equals(byteBufferAllocateDirect2));
        return false;
    }

    private static long size(FileChannel fileChannel) throws IOException {
        if (fileChannel != null) {
            return fileChannel.size();
        }
        return 0L;
    }

    private FileChannels() {
    }
}
