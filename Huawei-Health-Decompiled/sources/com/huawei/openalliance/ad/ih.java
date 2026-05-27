package com.huawei.openalliance.ad;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes6.dex */
class ih {
    static void b(File file) throws IOException {
        long length = file.length();
        if (length < 1) {
            length = 0;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte b = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(b);
        randomAccessFile.close();
    }

    static void a(File file) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLastModified = file.lastModified();
        if (jLastModified == jCurrentTimeMillis) {
            jCurrentTimeMillis++;
        }
        if (file.setLastModified(jCurrentTimeMillis)) {
            return;
        }
        try {
            b(file);
        } catch (IOException e) {
            hq.d("DiskFiles", "Failed to manually update lastModifyTime to file %s with error %s", file.getName(), e.getClass().getSimpleName());
        }
        if (jLastModified < jCurrentTimeMillis) {
            hq.c("DiskFiles", "Failed to manually update lastModifyTime to file %s", file.getName());
        }
    }
}
