package com.huawei.health.h5pro.jsbridge.system.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.google.common.primitives.UnsignedBytes;
import com.huawei.health.h5pro.ext.permission.H5ProPermissionCallback;
import com.huawei.health.h5pro.utils.GeneralUtil;
import com.huawei.health.h5pro.utils.LogUtil;
import com.huawei.health.h5pro.utils.PermissionUtil;
import com.huawei.health.h5pro.webkit.FileDownloadManager;
import com.huawei.openalliance.ad.constant.IntentFailError;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidStorage implements Storage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2471a;
    public String b;
    public String c;
    public final Context d;
    public Callback e;

    public interface Callback {
        void onFailure(String str);

        <T> void onSuccess(T t);
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void writeText(String str, String str2, boolean z) throws IOException {
        LogUtil.i("H5PRO_AndroidStorage", "write text:" + str + " " + str2);
        File file = new File(str);
        if (!z && file.exists() && !file.delete()) {
            throw new IOException("delete old file fail");
        }
        if (StorageUtil.ensureFileExists(file)) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(str2.getBytes(StandardCharsets.UTF_8));
            randomAccessFile.close();
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void writeArrayBuffer(String str, String str2) throws IOException {
        byte[] bArrHexStringToByte = hexStringToByte(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        try {
            fileOutputStream.write(bArrHexStringToByte);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void setValueByKey(String str, String str2, String str3) {
        SharedPreferences.Editor editorEdit = this.d.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }

    public void saveImageToAlbumAfterPermission(String str, String str2, String str3, final Callback callback) {
        final String str4 = TextUtils.isEmpty(str3) ? String.format(Locale.ENGLISH, "%d.jpg", Long.valueOf(System.currentTimeMillis())) : String.format(Locale.ENGLISH, "%d_%s", Long.valueOf(System.currentTimeMillis()), str3);
        final File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        try {
            String canonicalPath = externalStoragePublicDirectory.getCanonicalPath();
            if ("BASE64".equalsIgnoreCase(str)) {
                base64ToImageFile(canonicalPath + File.separator + str4, str2, new Callback() { // from class: com.huawei.health.h5pro.jsbridge.system.storage.AndroidStorage.3
                    @Override // com.huawei.health.h5pro.jsbridge.system.storage.AndroidStorage.Callback
                    public <T> void onSuccess(T t) {
                        AndroidStorage.this.d.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(externalStoragePublicDirectory, str4))));
                        callback.onSuccess(t);
                    }

                    @Override // com.huawei.health.h5pro.jsbridge.system.storage.AndroidStorage.Callback
                    public void onFailure(String str5) {
                        callback.onFailure(str5);
                    }
                });
            } else if ("URL".equalsIgnoreCase(str)) {
                FileDownloadManager.download(str2, canonicalPath, str4, new FileDownloadManager.DownloadCallback() { // from class: com.huawei.health.h5pro.jsbridge.system.storage.AndroidStorage.4
                    @Override // com.huawei.health.h5pro.webkit.FileDownloadManager.DownloadCallback
                    public void onSuccess(File file) {
                        LogUtil.i("H5PRO_AndroidStorage", "saveImageToAlbum: onSuccess-> " + file);
                        callback.onSuccess(file.getAbsolutePath());
                        AndroidStorage.this.d.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(externalStoragePublicDirectory, str4))));
                    }

                    @Override // com.huawei.health.h5pro.webkit.FileDownloadManager.DownloadCallback
                    public void onFailure(int i, String str5) {
                        LogUtil.e("H5PRO_AndroidStorage", "saveImageToAlbum: onFailure-> " + i + "===" + str5);
                        callback.onFailure(String.format(Locale.ROOT, "saveImageToAlbum fail: errorCode=%s, errorMsg=%s", Integer.valueOf(i), str5));
                    }
                });
            } else {
                LogUtil.w("H5PRO_AndroidStorage", "unsupported resource type: " + str);
            }
        } catch (IOException e) {
            LogUtil.e("H5PRO_AndroidStorage", "saveImageToAlbum: ioException-> " + e.getMessage());
            callback.onFailure(e.getMessage());
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void saveImageToAlbum(String str, String str2, String str3, Callback callback) {
        this.b = str3;
        this.c = str;
        this.f2471a = str2;
        this.e = callback;
        PermissionUtil.getInstance().checkAndRequestPermissions((Activity) this.d, PermissionUtil.f2502a, 11, new H5ProPermissionCallback() { // from class: com.huawei.health.h5pro.jsbridge.system.storage.AndroidStorage.2
            @Override // com.huawei.health.h5pro.ext.permission.H5ProPermissionCallback
            public void onGranted() {
                AndroidStorage androidStorage = AndroidStorage.this;
                androidStorage.saveImageToAlbumAfterPermission(androidStorage.c, AndroidStorage.this.f2471a, AndroidStorage.this.b, AndroidStorage.this.e);
            }

            @Override // com.huawei.health.h5pro.ext.permission.H5ProPermissionCallback
            public void onForeverDenied(String[] strArr) {
                if (AndroidStorage.this.e != null) {
                    AndroidStorage.this.e.onFailure(IntentFailError.NO_PERMISSION);
                }
            }

            @Override // com.huawei.health.h5pro.ext.permission.H5ProPermissionCallback
            public void onDenied(String str4) {
                if (AndroidStorage.this.e != null) {
                    AndroidStorage.this.e.onFailure(IntentFailError.NO_PERMISSION);
                }
            }
        });
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void rmdir(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            throw new IllegalArgumentException("remove fail: dir not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("remove fail: not a dir");
        }
        c(file);
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public String readText(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            throw new IllegalArgumentException("file not exist");
        }
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                            return sb.toString();
                        }
                        sb.append(line);
                        sb.append(System.lineSeparator());
                    } finally {
                    }
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public String readArrayBuffer(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            if (fileInputStream.read(bArr) < 0) {
                throw new IOException("read inputStream fail");
            }
            String strBytesToHexString = bytesToHexString(bArr);
            fileInputStream.close();
            return strBytesToHexString;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 11) {
            if (b(iArr)) {
                saveImageToAlbumAfterPermission(this.c, this.f2471a, this.b, this.e);
                return;
            }
            Callback callback = this.e;
            if (callback != null) {
                callback.onFailure(IntentFailError.NO_PERMISSION);
            }
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void move(String str, String str2) throws IOException {
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            throw new IllegalArgumentException("file not exist or is dir");
        }
        if (!StorageUtil.ensureDirExists(new File(str2).getParentFile())) {
            throw new IOException("move file create parent dir fail");
        }
        if (!file.renameTo(new File(str2))) {
            throw new IOException("move file fail");
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void mkdir(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("already has a file with this path");
            }
        } else if (!new File(str).mkdir()) {
            throw new IOException("mkdir fail");
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public String[] list(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return file.list();
        }
        throw new IllegalArgumentException("dir path invalid");
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public String getValueByKey(String str, String str2) {
        return this.d.getSharedPreferences(str, 0).getString(str2, "");
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public String get(String str) {
        File file = new File(str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", file.getName());
            jSONObject.put("size", file.length());
            jSONObject.put("time", file.lastModified());
            jSONObject.put("type", file.isDirectory() ? "dir" : "file");
        } catch (JSONException e) {
            LogUtil.e("H5PRO_AndroidStorage", "get: exception -> " + e.getMessage());
        }
        return jSONObject.toString();
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void delete(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            throw new IllegalArgumentException("file not exist");
        }
        if (file.isDirectory()) {
            throw new IllegalArgumentException("is a dir");
        }
        if (!file.delete()) {
            throw new IOException("delete file fail");
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void copy(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        StorageUtil.ensureDirExists(new File(str2).getParentFile());
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } finally {
            }
            try {
                byte[] bArr = new byte[1024];
                int i = 0;
                do {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 <= 0) {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    } else {
                        fileOutputStream.write(bArr, 0, i2);
                        i += i2;
                    }
                } while (i <= 104857600);
                throw new IOException("exceed max file size:104857600");
            } finally {
            }
        } catch (Exception e) {
            throw new IOException("copy file fail" + e.getMessage());
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void clearKeyValues(String str) {
        SharedPreferences.Editor editorEdit = this.d.getSharedPreferences(str, 0).edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void base64ToImageFile(final String str, final String str2, final Callback callback) {
        if (!GeneralUtil.isSafePath(str)) {
            LogUtil.w("H5PRO_AndroidStorage", "base64ToImageFile: invalid path");
            callback.onFailure("invalid path");
        } else {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.huawei.health.h5pro.jsbridge.system.storage.AndroidStorage.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtil.i("H5PRO_AndroidStorage", "base64ToImageFile: start");
                    if (!StorageUtil.ensureFileExists(new File(str))) {
                        callback.onFailure("base64ToImageFile fail: create file fail" + str);
                        return;
                    }
                    byte[] bArrDecode = Base64.decode(str2.replace("data:image/jpeg;base64,", ""), 0);
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                        try {
                            bitmapDecodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            LogUtil.i("H5PRO_AndroidStorage", "base64ToImageFile: end - " + bArrDecode.length);
                            callback.onSuccess(str);
                            bufferedOutputStream.close();
                        } finally {
                        }
                    } catch (IOException e) {
                        callback.onFailure(e.getMessage());
                    }
                }
            });
            executorServiceNewSingleThreadExecutor.shutdown();
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public void base64ToFile(String str, String str2) throws IOException {
        if (!StorageUtil.ensureFileExists(new File(str))) {
            throw new IOException("base64ToImageFile fail: create file fail" + str);
        }
        byte[] bArrDecode = Base64.decode(Pattern.compile("data:\\w+/\\w+;base64,").matcher(str2).replaceFirst(""), 0);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        try {
            fileOutputStream.write(bArrDecode);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.huawei.health.h5pro.jsbridge.system.storage.Storage
    public boolean access(String str) {
        return new File(str).exists();
    }

    public static byte toByte(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }

    private void c(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                c(file2);
            } else if (!file2.delete()) {
                throw new IOException("delete sub file fail");
            }
        }
        if (!file.delete()) {
            throw new IOException("delete dir fail");
        }
    }

    private boolean b(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static byte[] hexStringToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (toByte(charArray[i2 + 1]) | (toByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public AndroidStorage(Context context) {
        this.d = context;
    }
}
