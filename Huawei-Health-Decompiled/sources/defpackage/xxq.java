package defpackage;

import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes8.dex */
public final class xxq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19193a = File.separator;
    public static final Charset c;
    public static final Charset d;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        c = charsetForName;
        d = charsetForName;
    }
}
