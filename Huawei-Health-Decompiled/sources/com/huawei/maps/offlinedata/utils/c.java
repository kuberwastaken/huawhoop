package com.huawei.maps.offlinedata.utils;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            b(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                b(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
            b(file);
        }
    }

    public static boolean b(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        return file.delete();
    }

    public static boolean c(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        return (!file.isFile() && file.isDirectory() && ((fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0)) ? false : true;
    }
}
