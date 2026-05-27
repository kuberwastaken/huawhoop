package com.huawei.hms.network.embedded;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import ohos.ace.adapter.capability.web.WebDataBaseColumns;

/* JADX INFO: loaded from: classes10.dex */
public final class w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5745a;
    public final Map<String, String> b;

    public String toString() {
        return this.f5745a + " authParams=" + this.b;
    }

    public int hashCode() {
        return ((this.f5745a.hashCode() + 899) * 31) + this.b.hashCode();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof w6) {
            w6 w6Var = (w6) obj;
            if (w6Var.f5745a.equals(this.f5745a) && w6Var.b.equals(this.b)) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        return this.f5745a;
    }

    public String c() {
        return this.b.get(WebDataBaseColumns.EntryColumns.COLUMN_NAME_REALM);
    }

    public Charset b() {
        String str = this.b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return StandardCharsets.ISO_8859_1;
    }

    public Map<String, String> a() {
        return this.b;
    }

    public w6 a(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.b);
        linkedHashMap.put("charset", charset.name());
        return new w6(this.f5745a, linkedHashMap);
    }

    public w6(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (map == null) {
            throw new NullPointerException("authParams == null");
        }
        this.f5745a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.b = Collections.unmodifiableMap(linkedHashMap);
    }

    public w6(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str2 == null) {
            throw new NullPointerException("realm == null");
        }
        this.f5745a = str;
        this.b = Collections.singletonMap(WebDataBaseColumns.EntryColumns.COLUMN_NAME_REALM, str2);
    }
}
