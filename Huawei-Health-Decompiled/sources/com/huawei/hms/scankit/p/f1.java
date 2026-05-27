package com.huawei.hms.scankit.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes10.dex */
abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1 f5963a = new a("DATA_MASK_000", 0);
    public static final f1 b = new f1("DATA_MASK_001", 1) { // from class: com.huawei.hms.scankit.p.f1.b
        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i2, int i3) {
            return (i2 & 1) == 0;
        }

        {
            a aVar = null;
        }
    };
    public static final f1 c = new f1("DATA_MASK_010", 2) { // from class: com.huawei.hms.scankit.p.f1.c
        {
            a aVar = null;
        }

        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i2, int i3) {
            return i3 % 3 == 0;
        }
    };
    public static final f1 d = new f1("DATA_MASK_011", 3) { // from class: com.huawei.hms.scankit.p.f1.d
        {
            a aVar = null;
        }

        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i2, int i3) {
            return (i2 + i3) % 3 == 0;
        }
    };
    public static final f1 e = new f1("DATA_MASK_100", 4) { // from class: com.huawei.hms.scankit.p.f1.e
        {
            a aVar = null;
        }

        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i2, int i3) {
            return (((i2 / 2) + (i3 / 3)) & 1) == 0;
        }
    };
    public static final f1 f = new f1("DATA_MASK_101", 5) { // from class: com.huawei.hms.scankit.p.f1.f
        {
            a aVar = null;
        }

        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i2, int i3) {
            return (i2 * i3) % 6 == 0;
        }
    };
    public static final f1 g = new f1("DATA_MASK_110", 6) { // from class: com.huawei.hms.scankit.p.f1.g
        {
            a aVar = null;
        }

        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i2, int i3) {
            return (i2 * i3) % 6 < 3;
        }
    };
    public static final f1 h = new f1("DATA_MASK_111", 7) { // from class: com.huawei.hms.scankit.p.f1.h
        {
            a aVar = null;
        }

        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i2, int i3) {
            return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
        }
    };
    private static final /* synthetic */ f1[] i = a();

    public static f1 valueOf(String str) {
        return (f1) Enum.valueOf(f1.class, str);
    }

    public static f1[] values() {
        return (f1[]) i.clone();
    }

    abstract boolean a(int i2, int i3);

    private f1(String str, int i2) {
    }

    private static /* synthetic */ f1[] a() {
        return new f1[]{f5963a, b, c, d, e, f, g, h};
    }

    enum a extends f1 {
        @Override // com.huawei.hms.scankit.p.f1
        boolean a(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }

        a(String str, int i) {
            super(str, i, null);
        }
    }

    /* synthetic */ f1(String str, int i2, a aVar) {
        this(str, i2);
    }

    final void a(s sVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (a(i3, i4)) {
                    sVar.a(i4, i3);
                }
            }
        }
    }
}
