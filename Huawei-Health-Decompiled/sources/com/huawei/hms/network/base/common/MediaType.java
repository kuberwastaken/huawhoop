package com.huawei.hms.network.base.common;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class MediaType {
    private static final String e = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final String f = "\"([^\"]*)\"";
    private static final Pattern g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private static final Pattern h = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5308a;
    private final String b;
    private final String c;
    private final String d;

    public String type() {
        return this.b;
    }

    public String toString() {
        return this.f5308a;
    }

    public String subtype() {
        return this.c;
    }

    public int hashCode() {
        return this.f5308a.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f5308a.equals(this.f5308a);
    }

    public Charset charset(Charset charset) {
        String str = this.d;
        return str != null ? Charset.forName(str) : charset;
    }

    public Charset charset() {
        String str = this.d;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public static MediaType parse(String str) {
        Matcher matcher = h.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(2).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(1).toLowerCase(Locale.US);
        Matcher matcher2 = g.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                String strGroup2 = matcher2.group(2);
                if (strGroup2 == null) {
                    strGroup2 = matcher2.group(3);
                } else if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                    strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("multiple different charsets: " + str);
                }
                str2 = strGroup2;
            }
        }
        return new MediaType(str, lowerCase2, lowerCase, str2);
    }

    public static MediaType get(String str) {
        Matcher matcher = h.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = g.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"');
            }
            String strGroup = matcher2.group(1);
            if (strGroup != null && strGroup.equalsIgnoreCase("charset")) {
                String strGroup2 = matcher2.group(2);
                if (strGroup2 == null) {
                    strGroup2 = matcher2.group(3);
                } else if (strGroup2.startsWith("'") && strGroup2.endsWith("'") && strGroup2.length() > 2) {
                    strGroup2 = strGroup2.substring(1, strGroup2.length() - 1);
                }
                if (str2 != null && !strGroup2.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup2 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup2;
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    private MediaType(String str, String str2, String str3, String str4) {
        this.d = str4;
        this.c = str3;
        this.f5308a = str;
        this.b = str2;
    }
}
