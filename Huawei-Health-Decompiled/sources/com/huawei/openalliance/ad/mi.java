package com.huawei.openalliance.ad;

import com.iab.omid.library.huawei.adsession.CreativeType;

/* JADX INFO: loaded from: classes6.dex */
public enum mi {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO("audio");

    private static boolean f;
    private final String g;

    @Override // java.lang.Enum
    public String toString() {
        return this.g;
    }

    public static boolean a() {
        return f;
    }

    public static CreativeType a(mi miVar) {
        if (!f) {
            return null;
        }
        int i = AnonymousClass1.f7514a[miVar.ordinal()];
        if (i == 1) {
            return CreativeType.DEFINED_BY_JAVASCRIPT;
        }
        if (i == 2) {
            return CreativeType.HTML_DISPLAY;
        }
        if (i == 3) {
            return CreativeType.NATIVE_DISPLAY;
        }
        if (i == 4) {
            return CreativeType.VIDEO;
        }
        if (i != 5) {
            return null;
        }
        return CreativeType.AUDIO;
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.mi$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7514a;

        static {
            int[] iArr = new int[mi.values().length];
            f7514a = iArr;
            try {
                iArr[mi.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7514a[mi.HTML_DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7514a[mi.NATIVE_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7514a[mi.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7514a[mi.AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    mi(String str) {
        this.g = str;
    }

    static {
        f = false;
        f = mc.a("com.iab.omid.library.huawei.adsession.CreativeType");
    }
}
