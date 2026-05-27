package com.huawei.hianalytics;

import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes5.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4031a;

    public final String b(String str) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr;
        byte[] bArr2;
        int i;
        byte[] bArr3;
        File file = new File(a(str), "hianalytics_" + str);
        if (!a(file)) {
            String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
            g1.a(file, strGenerateSecureRandomStr);
            return strGenerateSecureRandomStr;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bArr = new byte[1024];
            bArr2 = new byte[1024];
            i = 0;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            HiLog.e("HASU", "read file error");
            g1.a(fileInputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            g1.a(fileInputStream2);
            throw th;
        }
        while (true) {
            int i2 = fileInputStream.read(bArr2);
            if (i2 == -1) {
                break;
            }
            if (i2 > 0) {
                if (bArr.length - i >= i2) {
                    System.arraycopy(bArr2, 0, bArr, i, i2);
                } else {
                    byte[] bArr4 = new byte[(bArr.length + i2) << 1];
                    System.arraycopy(bArr, 0, bArr4, 0, i);
                    System.arraycopy(bArr2, 0, bArr4, i, i2);
                    bArr = bArr4;
                }
                i += i2;
            }
            return "";
        }
        if (i != 0) {
            if (i <= 0) {
                bArr3 = new byte[0];
            } else {
                bArr3 = new byte[i];
                System.arraycopy(bArr, 0, bArr3, 0, i);
            }
            String str2 = new String(bArr3, StandardCharsets.UTF_8);
            g1.a(fileInputStream);
            return str2;
        }
        g1.a(fileInputStream);
        return "";
    }

    public final boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            HiLog.e("ComponentManager", "create new file error");
            return false;
        }
    }

    public final void a(String str, String str2) throws Throwable {
        File file = new File(a(str));
        File file2 = new File(a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            HiLog.i("ComponentManager", "file directory is mkdirs");
        }
        if (a(file2)) {
            g1.a(file2, str2);
        } else {
            HiLog.w("ComponentManager", "file is not found, file is create failed");
        }
    }

    public final String a(String str) {
        return this.f4031a + "/hianalytics_/component/".replace("component", str);
    }

    public static boolean b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    HiLog.i("ComponentManager", "delete file failed: " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static boolean a() {
        File file;
        try {
            file = new File(EnvUtils.getAppContext().getFilesDir().getCanonicalPath() + File.separator + "/hianalytics_");
        } catch (IOException unused) {
            HiLog.e("ComponentManager", "delete component file error");
            file = null;
        }
        return b(file);
    }

    public o0() {
        try {
            this.f4031a = EnvUtils.getAppContext().getFilesDir().getCanonicalPath() + File.separator;
        } catch (IOException unused) {
            HiLog.e("ComponentManager", "get fileRootDirectory error");
        }
    }
}
