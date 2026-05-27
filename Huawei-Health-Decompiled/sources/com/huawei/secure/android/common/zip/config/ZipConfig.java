package com.huawei.secure.android.common.zip.config;

import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes11.dex */
public class ZipConfig {
    private String c;
    private String d;
    private String[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9004a = Constants.WEB_VIEW_CACHE_TOTAL_MAX_SIZE;
    private int b = 6000;
    private String[] f = {"jsp", "php", "php2", "php3", "php4", "php5", "phps", "pht", "phtm", "phtml", "py", "pl", "elf", "lua", "sh", "js"};
    private boolean g = true;
    private boolean h = false;

    public ZipConfig(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    public String[] getBlackListSuffix() {
        return this.f;
    }

    public int getFileNumThreshold() {
        return this.b;
    }

    public String getTargetDir() {
        return this.d;
    }

    public long getTopSizeThreshold() {
        return this.f9004a;
    }

    public String[] getWhiteListSuffix() {
        return this.e;
    }

    public String getZipFile() {
        return this.c;
    }

    public boolean isGbkZipFile() {
        return this.h;
    }

    public boolean isLoadDisk() {
        return this.g;
    }

    public void setBlackListSuffix(String[] strArr) {
        this.f = strArr;
    }

    public void setFileNumThreshold(int i) {
        this.b = i;
    }

    public void setGbkZipFile(boolean z) {
        this.h = z;
    }

    public void setLoadDisk(boolean z) {
        this.g = z;
    }

    public void setTargetDir(String str) {
        this.d = str;
    }

    public void setTopSizeThreshold(long j) {
        this.f9004a = j;
    }

    public void setWhiteListSuffix(String[] strArr) {
        this.e = strArr;
    }

    public void setZipFile(String str) {
        this.c = str;
    }
}
