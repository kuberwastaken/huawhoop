package com.fasterxml.jackson.databind.jsonFormatVisitors;

import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public interface JsonValueFormatVisitor {
    void enumTypes(Set<String> set);

    void format(JsonValueFormat jsonValueFormat);
}
