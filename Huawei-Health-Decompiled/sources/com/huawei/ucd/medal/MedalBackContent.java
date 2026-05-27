package com.huawei.ucd.medal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import com.huawei.ucd.medal.MedalBackType;
import com.huawei.ui.commonui.R$styleable;
import defpackage.pci;
import defpackage.pcj;
import defpackage.pco;
import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public class MedalBackContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MedalBackType.ColorType f9102a;
    public MedalBackType.ModelType b;
    public Bitmap c;
    public String[] d;
    public pco e;
    public int f;
    public pco i;

    /* synthetic */ MedalBackContent(AnonymousClass5 anonymousClass5) {
        this();
    }

    private MedalBackContent() {
        this.e = new pco();
        this.i = new pco();
    }

    public String toString() {
        return "MedalBackContent{mModelType=" + this.b + ", mColorType=" + this.f9102a + ", mTextColor=" + this.f + ", mFirstStrOffsetXTopY=" + this.e.toString() + ", mSecondStrOffsetXTopY=" + this.i.toString() + ", mContents=" + Arrays.toString(this.d) + ", mIconContent=" + this.c + '}';
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pco f9104a;
        public pco b;
        private MedalBackType.ColorType c;
        private String[] d;
        private Context e;
        private MedalBackType.ModelType g;
        private Bitmap h;
        private Integer i;

        public Builder(Context context) {
            this.e = context;
        }

        public Builder c(MedalBackType.ModelType modelType) {
            this.g = modelType;
            return this;
        }

        public Builder c(MedalBackType.ColorType colorType) {
            this.c = colorType;
            return this;
        }

        public Builder b(String[] strArr) {
            this.d = strArr;
            return this;
        }

        public Builder cGB_(Bitmap bitmap) {
            this.h = bitmap;
            return this;
        }

        public MedalBackContent d() {
            MedalBackContent medalBackContent = new MedalBackContent(null);
            medalBackContent.b = this.g;
            medalBackContent.f9102a = this.c;
            medalBackContent.d = this.d;
            a(medalBackContent);
            d(medalBackContent);
            c(medalBackContent);
            b(medalBackContent);
            if (this.g != null && this.c != null && this.d != null) {
                pcj.b("MedalBackContent", "MedalBackContent build mModelType= " + this.g.toString() + "mColorType= " + this.c.toString() + "mContents= " + Arrays.toString(this.d));
            }
            return medalBackContent;
        }

        private void b(MedalBackContent medalBackContent) {
            Bitmap bitmap = this.h;
            if (bitmap == null) {
                switch (AnonymousClass5.f9103a[this.g.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        int i = AnonymousClass5.c[this.c.ordinal()];
                        if (i == 1) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_solid_copper.png");
                            break;
                        } else if (i == 2) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_solid_silver.png");
                            break;
                        } else if (i == 3) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_solid_gold.png");
                            break;
                        }
                        break;
                    case 4:
                    case 5:
                        int i2 = AnonymousClass5.c[this.c.ordinal()];
                        if (i2 == 1) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_hexagon_copper.png");
                            break;
                        } else if (i2 == 2) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_hexagon_silver.png");
                            break;
                        } else if (i2 == 3) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_hexagon_gold.png");
                            break;
                        }
                        break;
                    case 6:
                        int i3 = AnonymousClass5.c[this.c.ordinal()];
                        if (i3 == 1) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_tetragonum_copper.png");
                            break;
                        } else if (i3 == 2) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_tetragonum_silver.png");
                            break;
                        } else if (i3 == 3) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_tetragonum_gold.png");
                            break;
                        }
                        break;
                    case 7:
                        int i4 = AnonymousClass5.c[this.c.ordinal()];
                        if (i4 == 1) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_triangle_copper.png");
                            break;
                        } else if (i4 == 2) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_triangle_silver.png");
                            break;
                        } else if (i4 == 3) {
                            medalBackContent.c = pci.cGs_(this.e, "medal/medal_back_icon_hollow_triangle_gold.png");
                            break;
                        }
                        break;
                }
            }
            medalBackContent.c = bitmap;
        }

        private void c(MedalBackContent medalBackContent) {
            Integer num = this.i;
            if (num == null) {
                int i = AnonymousClass5.c[this.c.ordinal()];
                if (i == 1) {
                    medalBackContent.f = Color.argb(255, 112, 49, 3);
                    return;
                } else if (i == 2) {
                    medalBackContent.f = Color.argb(255, 111, 111, 111);
                    return;
                } else {
                    if (i != 3) {
                        return;
                    }
                    medalBackContent.f = Color.argb(255, 176, R$styleable.AppCompatTheme_windowMinWidthMajor, 8);
                    return;
                }
            }
            medalBackContent.f = num.intValue();
        }

        private void a(MedalBackContent medalBackContent) {
            if (this.f9104a == null) {
                this.f9104a = new pco(0.0f, 300.0f);
                switch (AnonymousClass5.f9103a[this.g.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                    case 5:
                        this.f9104a.c = 376.0f;
                        break;
                    case 6:
                        this.f9104a.f16623a = -20.0f;
                        this.f9104a.c = 376.0f;
                        break;
                    case 7:
                        this.f9104a.c = 284.0f;
                        break;
                    default:
                        this.f9104a.c = 300.0f;
                        break;
                }
            }
            medalBackContent.e = this.f9104a;
        }

        private void d(MedalBackContent medalBackContent) {
            if (this.b == null) {
                this.b = new pco(0.0f, 324.0f);
                switch (AnonymousClass5.f9103a[this.g.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                    case 5:
                        this.b.c = 390.0f;
                        break;
                    case 6:
                        this.b.f16623a = -20.0f;
                        this.b.c = 390.0f;
                        break;
                    case 7:
                        this.b.c = 316.0f;
                        break;
                    default:
                        this.b.c = 324.0f;
                        break;
                }
            }
            medalBackContent.i = this.b;
        }
    }

    /* JADX INFO: renamed from: com.huawei.ucd.medal.MedalBackContent$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9103a;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[MedalBackType.ModelType.values().length];
            f9103a = iArr;
            try {
                iArr[MedalBackType.ModelType.SOLID_CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9103a[MedalBackType.ModelType.SOLID_FLOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9103a[MedalBackType.ModelType.SOLID_PENTAGON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9103a[MedalBackType.ModelType.HOLLOW_CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9103a[MedalBackType.ModelType.HOLLOW_HEXAGON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9103a[MedalBackType.ModelType.HOLLOW_TETRAGONUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9103a[MedalBackType.ModelType.HOLLOW_TRIANGLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[MedalBackType.ColorType.values().length];
            c = iArr2;
            try {
                iArr2[MedalBackType.ColorType.COPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[MedalBackType.ColorType.SILVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[MedalBackType.ColorType.GOLD.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }
}
