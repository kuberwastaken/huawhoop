package com.github.promeg.pinyinhelper;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface PinyinDict {
    String[] toPinyin(String str);

    Set<String> words();
}
