package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public class TokenFilter {
    public static final TokenFilter c = new TokenFilter();

    public enum Inclusion {
        ONLY_INCLUDE_ALL,
        INCLUDE_ALL_AND_PATH,
        INCLUDE_NON_NULL
    }

    public TokenFilter a() {
        return this;
    }

    public TokenFilter b(String str) {
        return this;
    }

    public void b() {
    }

    public TokenFilter c(int i) {
        return this;
    }

    protected boolean c() {
        return true;
    }

    public TokenFilter d() {
        return this;
    }

    public TokenFilter e(int i) {
        return this;
    }

    protected TokenFilter() {
    }

    public boolean a(JsonParser jsonParser) throws IOException {
        return c();
    }

    public String toString() {
        return this == c ? "TokenFilter.INCLUDE_ALL" : super.toString();
    }
}
