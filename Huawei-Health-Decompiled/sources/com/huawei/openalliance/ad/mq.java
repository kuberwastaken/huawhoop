package com.huawei.openalliance.ad;

import com.iab.omid.library.huawei.adsession.media.InteractionType;

/* JADX INFO: loaded from: classes6.dex */
public enum mq {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");

    private static boolean d;
    String c;

    @Override // java.lang.Enum
    public String toString() {
        return this.c;
    }

    public static boolean a() {
        return d;
    }

    public static InteractionType a(mq mqVar) {
        if (!d) {
            return null;
        }
        int i = AnonymousClass1.f7523a[mqVar.ordinal()];
        if (i == 1) {
            return InteractionType.CLICK;
        }
        if (i != 2) {
            return null;
        }
        return InteractionType.INVITATION_ACCEPTED;
    }

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.mq$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7523a;

        static {
            int[] iArr = new int[mq.values().length];
            f7523a = iArr;
            try {
                iArr[mq.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7523a[mq.INVITATION_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    mq(String str) {
        this.c = str;
    }

    static {
        d = false;
        d = mc.a("com.iab.omid.library.huawei.adsession.media.InteractionType");
    }
}
