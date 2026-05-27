package com.huawei.openalliance.ad;

import com.iab.omid.library.huawei.adsession.ImpressionType;

/* JADX INFO: loaded from: classes6.dex */
public enum ml {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");

    private static boolean i;
    private final String j;

    @Override // java.lang.Enum
    public String toString() {
        return this.j;
    }

    public static boolean a() {
        return i;
    }

    public static ImpressionType a(ml mlVar) {
        if (!i) {
            return null;
        }
        switch (AnonymousClass1.f7518a[mlVar.ordinal()]) {
            case 1:
                return ImpressionType.DEFINED_BY_JAVASCRIPT;
            case 2:
                return ImpressionType.UNSPECIFIED;
            case 3:
                return ImpressionType.LOADED;
            case 4:
                return ImpressionType.BEGIN_TO_RENDER;
            case 5:
                return ImpressionType.ONE_PIXEL;
            case 6:
                return ImpressionType.VIEWABLE;
            case 7:
                return ImpressionType.AUDIBLE;
            case 8:
                return ImpressionType.OTHER;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.ml$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7518a;

        static {
            int[] iArr = new int[ml.values().length];
            f7518a = iArr;
            try {
                iArr[ml.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7518a[ml.UNSPECIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7518a[ml.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7518a[ml.BEGIN_TO_RENDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7518a[ml.ONE_PIXEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7518a[ml.VIEWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7518a[ml.AUDIBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7518a[ml.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    ml(String str) {
        this.j = str;
    }

    static {
        i = false;
        i = mc.a("com.iab.omid.library.huawei.adsession.ImpressionType");
    }
}
