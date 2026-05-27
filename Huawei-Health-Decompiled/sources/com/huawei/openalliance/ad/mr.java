package com.huawei.openalliance.ad;

import com.iab.omid.library.huawei.adsession.media.Position;

/* JADX INFO: loaded from: classes6.dex */
public enum mr {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private static boolean e;
    private final String f;

    @Override // java.lang.Enum
    public String toString() {
        return this.f;
    }

    public static Position a(mr mrVar) {
        if (!e) {
            return null;
        }
        int i = AnonymousClass1.f7525a[mrVar.ordinal()];
        if (i == 1 || i == 2) {
            return Position.PREROLL;
        }
        if (i == 3) {
            return Position.POSTROLL;
        }
        if (i != 4) {
            return null;
        }
        return Position.STANDALONE;
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.mr$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7525a;

        static {
            int[] iArr = new int[mr.values().length];
            f7525a = iArr;
            try {
                iArr[mr.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7525a[mr.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7525a[mr.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7525a[mr.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    mr(String str) {
        this.f = str;
    }

    static {
        e = false;
        e = mc.a("com.iab.omid.library.huawei.adsession.media.Position");
    }
}
