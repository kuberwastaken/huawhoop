package com.huawei.watchface.videoedit.utils;

import java.util.HashSet;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public class UuidManager {
    private HashSet<String> mUsedIdSet = new HashSet<>();

    public String generateNewId() {
        String string;
        do {
            string = UUID.randomUUID().toString();
        } while (this.mUsedIdSet.contains(string));
        this.mUsedIdSet.add(string);
        return string;
    }

    public String generateNewIdWithPrefix(String str) {
        String strConcat;
        if (str == null) {
            str = "";
        }
        do {
            strConcat = str.concat(UUID.randomUUID().toString());
        } while (this.mUsedIdSet.contains(strConcat));
        this.mUsedIdSet.add(strConcat);
        return strConcat;
    }
}
