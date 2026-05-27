package defpackage;

import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.constant.Constants;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
class ty {
    private byte[] e;
    private String f;
    private String h;
    private Map<String, String> d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f18213a = new HashMap();
    private String c = "";
    private final int g = 30000;
    private final int b = 30000;

    ty() {
    }

    ty a(String str) {
        this.h = str;
        return this;
    }

    ty c(String str) {
        this.c = str;
        return this;
    }

    ty e(String str) {
        this.e = str.getBytes(StandardCharsets.UTF_8);
        return this;
    }

    ty b(String str) {
        this.f = str;
        return this;
    }

    ty d(String str, String str2) {
        this.f18213a.put(str, str2);
        return this;
    }

    String j() {
        return this.h;
    }

    byte[] d() {
        return this.e;
    }

    void b() {
        byte[] bArr = this.e;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    String c() {
        return this.f;
    }

    Map<String, String> e() {
        if (this.d == null) {
            HashMap map = new HashMap();
            this.d = map;
            map.put("Accept-Encoding", Constants.GZIP);
            this.d.put(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().getLanguage());
            this.d.putAll(this.f18213a);
        }
        return Collections.unmodifiableMap(this.d);
    }

    int h() {
        return this.g;
    }

    int a() {
        return this.b;
    }

    URL f() throws MalformedURLException, URISyntaxException {
        if (this.h.startsWith("http")) {
            return new URL(this.h);
        }
        URI uri = new URL(this.c).toURI();
        return uri.resolve(e(uri.getPath(), this.h)).normalize().toURL();
    }

    private static String e(String str, String str2) {
        return new File(new File(str), str2).getPath();
    }
}
