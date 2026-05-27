package com.huawei.healthcloud.plugintrack.golf.cloud;

import com.huawei.featureuserprofile.route.navigationparser.NavigationFileParser;
import health.compact.a.util.LogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes10.dex */
public class GolfZipUtils {
    private static final String TAG = "GolfZipUtils";

    public static void unZipBinFile(File file, String str) {
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().split("\\.")[r2.length - 1].equals(NavigationFileParser.BIN)) {
                        byte[] bArr = new byte[1024];
                        InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                fileOutputStream.write(bArr, 0, i);
                            }
                        }
                        inputStream.close();
                        fileOutputStream.close();
                    }
                }
                zipFile.close();
            } finally {
            }
        } catch (IOException unused) {
            LogUtil.d(TAG, "unZipFile: Failed!");
        }
    }
}
