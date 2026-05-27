package org.ahocorasick.trie;

import defpackage.ybq;

/* JADX INFO: loaded from: classes11.dex */
public abstract class Token {
    private String fragment;

    public abstract ybq getEmit();

    public abstract boolean isMatch();

    public Token(String str) {
        this.fragment = str;
    }

    public String getFragment() {
        return this.fragment;
    }
}
