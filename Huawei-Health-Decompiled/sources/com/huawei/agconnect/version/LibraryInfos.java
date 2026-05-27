package com.huawei.agconnect.version;

/* JADX INFO: loaded from: classes3.dex */
public class LibraryInfos {
    private static final LibraryInfos INSTANCE = new LibraryInfos();
    private String libraryType = "Java";

    public void registerLibraryType(String str) {
        this.libraryType = str;
    }

    public String getLibraryType() {
        return this.libraryType;
    }

    public static LibraryInfos getInstance() {
        return INSTANCE;
    }

    LibraryInfos() {
    }
}
