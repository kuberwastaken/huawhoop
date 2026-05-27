package com.huawei.hms.opendevice;

import com.huawei.hms.ads.uiengineloader.aj;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m {
    public static void a(File file) throws IOException {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() == null) {
            HMSLog.e(aj.f4559a, "parent file is null.");
            throw new IOException("parent file is null");
        }
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            HMSLog.e(aj.f4559a, "make parent dirs failed.");
            throw new IOException("make parent dirs failed");
        }
        if (file.createNewFile()) {
            return;
        }
        HMSLog.e(aj.f4559a, "create file failed.");
        throw new IOException("create file failed");
    }

    public static String a(String str) throws Throwable {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        Reader reader = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (FileNotFoundException unused) {
                            reader = bufferedReader2;
                            HMSLog.e(aj.f4559a, "file not exist.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly(reader);
                        } catch (IOException unused2) {
                            reader = bufferedReader2;
                            HMSLog.e(aj.f4559a, "read value IOException.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly(reader);
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            reader = inputStreamReader;
                            IOUtils.closeQuietly(reader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            throw th;
                        }
                    }
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                } catch (FileNotFoundException unused3) {
                } catch (IOException unused4) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (FileNotFoundException unused5) {
            inputStreamReader = null;
        } catch (IOException unused6) {
            inputStreamReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly((Reader) bufferedReader);
            throw th;
        }
        return sb.toString();
    }
}
