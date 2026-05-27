package defpackage;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class vm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18656a;
    private int b;
    private byte c;
    private float d;
    private boolean e = false;
    private float j;

    public static float a(float f, byte b, float f2, float f3) {
        return ((100.0f - f2) - f3) - (((b == 1 ? 3.0f : 2.5f) / f) * 100.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static float c(float r8, float r9, byte r10, int r11) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vm.c(float, float, byte, int):float");
    }

    public static float d(float f, float f2, byte b, int i, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = (f2 / (f * f)) * 100.0f * 100.0f;
        float f11 = (((f10 * f10) * (-5.686f)) + (f10 * 241.7f)) - 2470.0f;
        if (f11 < 55.0f) {
            f11 = 55.0f;
        }
        if (f11 > 96.0f) {
            f11 = 96.0f;
        }
        float f12 = f3 + (i * 0.03f);
        if (b == 1) {
            float f13 = f12 * f12;
            float f14 = f13 * f12;
            f6 = ((((f14 * f12) * 1.085E-4f) - (f14 * 0.003181f)) - (f13 * 0.2952f)) + (f12 * 10.85f) + 0.4248f;
            f7 = 0.77f;
        } else {
            float f15 = f12 * f12;
            float f16 = f15 * f12;
            f6 = (((((f16 * f12) * 2.469E-4f) - (f16 * 0.02788f)) + (f15 * 0.9597f)) - (f12 * 10.02f)) + 80.42f;
            f7 = 0.735f;
        }
        float f17 = ((double) f6) >= 55.0d ? f6 : 55.0f;
        float f18 = (f4 + 90.0f) - (f2 * f7);
        float f19 = f18 <= 100.0f ? f18 : 100.0f;
        if (f5 >= 15.0d) {
            f8 = -50.0f;
        } else {
            float f20 = f5 * f5;
            float f21 = f20 * f5;
            float f22 = f21 * f5;
            f8 = (((((f22 * f5) * 0.007212f) - (f22 * 0.2825f)) + (f21 * 3.912f)) - (f20 * 22.27f)) + (30.38f * f5) + 89.35f;
        }
        float f23 = f8 >= -50.0f ? f8 : -50.0f;
        float f24 = 0.0f;
        if (f5 == 0.0f) {
            f9 = 0.48f;
        } else {
            f24 = 0.08f;
            f9 = 0.4f;
        }
        int i2 = (int) ((f9 * f11) + (f17 * 0.4f) + (f19 * 0.1f) + (f24 * f23));
        if (i2 < 45) {
            i2 = 45;
        }
        if (i2 > 100) {
            i2 = 100;
        }
        return i2;
    }

    private static float e(byte b, float f) {
        float f2;
        float f3;
        if (b == 1) {
            f2 = f - 80.0f;
            f3 = 0.7f;
        } else {
            f2 = f - 70.0f;
            f3 = 0.6f;
        }
        return f2 * f3;
    }

    public float j() {
        return this.d;
    }

    public byte g() {
        return this.c;
    }

    public vm(float f, float f2, byte b, int i, float f3) {
        this.d = f;
        this.j = f2;
        this.c = b;
        this.b = i;
        this.f18656a = f3;
    }

    public static int b(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        String[] strArrSplit = str.trim().split("\\|");
        if (strArrSplit.length <= 0) {
            return 0;
        }
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.trim().split("\\:");
            if (strArrSplit2.length > 1 && strArrSplit2[0].equals("2")) {
                return Integer.parseInt(strArrSplit2[1]);
            }
        }
        return 0;
    }

    public float b() {
        float f = this.j;
        float f2 = this.d;
        return (f / (f2 * f2)) * 100.0f * 100.0f;
    }

    public float f() {
        return (c() * this.j) / 100.0f;
    }

    private float o() {
        float f;
        float f2;
        float f3;
        if (this.e) {
            if (this.c == 1) {
                float f4 = this.d;
                f = this.j;
                f2 = (f4 * (-0.2893f)) + (0.6143f * f) + (this.b * 0.0355f) + (this.f18656a * 0.0207f);
                f3 = 7.9298f;
            } else {
                float f5 = this.d;
                f = this.j;
                f2 = (f5 * (-0.2923f)) + (0.787f * f) + (this.b * 0.0071f) + (this.f18656a * 0.0139f);
                f3 = 9.6791f;
            }
        } else if (this.c == 1) {
            float f6 = this.d;
            f = this.j;
            f2 = (f6 * (-0.3315f)) + (0.6216f * f) + (this.b * 1.0f * 0.0183f) + (this.f18656a * 0.0085f);
            f3 = 22.554f;
        } else {
            float f7 = this.d;
            f = this.j;
            f2 = (f7 * (-0.3332f)) + (0.7509f * f) + (this.b * 1.0f * 0.0196f) + (this.f18656a * 0.0072f);
            f3 = 22.7193f;
        }
        return ((f2 + f3) / f) * 100.0f;
    }

    public float c() {
        float fO = o();
        if (fO < 5.0f) {
            fO = 5.0f;
        }
        if (fO > 45.0f) {
            return 45.0f;
        }
        return fO;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float m() {
        /*
            r5 = this;
            int r0 = r5.b
            r1 = 17
            if (r0 <= r1) goto La9
            boolean r1 = r5.e
            r2 = 1
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L4e
            byte r1 = r5.c
            if (r1 != r2) goto L2f
            float r1 = r5.d
            r2 = -1098988179(0xffffffffbe7ec56d, float:-0.2488)
            float r1 = r1 * r2
            float r2 = r5.j
            r4 = 1052652863(0x3ebe353f, float:0.3715)
            float r2 = r2 * r4
            float r1 = r1 + r2
            float r0 = (float) r0
            r2 = 1040831637(0x3e09d495, float:0.1346)
            float r0 = r0 * r2
            float r1 = r1 + r0
            float r0 = r5.f18656a
            r2 = 1007049035(0x3c06594b, float:0.0082)
            float r0 = r0 * r2
            float r1 = r1 + r0
            r0 = 1098804258(0x417e6c22, float:15.9014)
            goto L8f
        L2f:
            float r1 = r5.d
            r2 = -1110879869(0xffffffffbdc95183, float:-0.0983)
            float r1 = r1 * r2
            float r2 = r5.j
            r4 = 1049867846(0x3e93b646, float:0.2885)
            float r2 = r2 * r4
            float r1 = r1 + r2
            float r0 = (float) r0
            r2 = 1033194648(0x3d954c98, float:0.0729)
            float r0 = r0 * r2
            float r1 = r1 + r0
            float r0 = r5.f18656a
            r2 = 1007478532(0x3c0ce704, float:0.0086)
            float r0 = r0 * r2
            float r1 = r1 + r0
            r0 = 1083611021(0x4096978d, float:4.706)
            float r1 = r1 - r0
            goto L90
        L4e:
            byte r1 = r5.c
            if (r1 != r2) goto L71
            float r1 = r5.d
            r2 = -1098320445(0xffffffffbe88f5c3, float:-0.2675)
            float r1 = r1 * r2
            float r2 = r5.j
            r4 = 1054280253(0x3ed70a3d, float:0.42)
            float r2 = r2 * r4
            float r1 = r1 + r2
            float r0 = (float) r0
            float r0 = r0 * r3
            r2 = 1041610100(0x3e15b574, float:0.1462)
            float r0 = r0 * r2
            float r1 = r1 + r0
            float r0 = r5.f18656a
            r2 = 1011451376(0x3c4985f0, float:0.0123)
            float r0 = r0 * r2
            float r1 = r1 + r0
            r0 = 1096796969(0x415fcb29, float:13.9871)
            goto L8f
        L71:
            float r1 = r5.d
            r2 = -1104605191(0xffffffffbe290ff9, float:-0.1651)
            float r1 = r1 * r2
            float r2 = r5.j
            r4 = 1049005497(0x3e868db9, float:0.2628)
            float r2 = r2 * r4
            float r1 = r1 + r2
            float r0 = (float) r0
            float r0 = r0 * r3
            r2 = 1032120907(0x3d84ea4b, float:0.0649)
            float r0 = r0 * r2
            float r1 = r1 + r0
            float r0 = r5.f18656a
            r2 = 991775058(0x3b1d4952, float:0.0024)
            float r0 = r0 * r2
            float r1 = r1 + r0
            r0 = 1095074578(0x41458312, float:12.3445)
        L8f:
            float r1 = r1 + r0
        L90:
            int r0 = (int) r1
            float r0 = (float) r0
            float r1 = r1 - r0
            r2 = 1056964608(0x3f000000, float:0.5)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L9a
            goto L9b
        L9a:
            float r0 = r0 + r2
        L9b:
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 >= 0) goto La0
            goto Laa
        La0:
            r3 = 1114374144(0x426c0000, float:59.0)
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 <= 0) goto La7
            goto Laa
        La7:
            r3 = r0
            goto Laa
        La9:
            r3 = 0
        Laa:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vm.m():float");
    }

    public float k() {
        float f;
        float f2;
        float f3;
        int i = this.b;
        if (i <= 17) {
            return 0.0f;
        }
        if (this.e) {
            if (this.c == 1) {
                float f4 = this.d;
                f = this.j;
                f2 = (((f4 * 0.2224f) + (0.167f * f)) - (i * 0.0411f)) - (this.f18656a * 0.0311f);
                f3 = 6.9026f;
            } else {
                float f5 = this.d;
                f = this.j;
                f2 = (((f5 * 0.1058f) + (0.2168f * f)) - (i * 0.0016f)) - (this.f18656a * 0.016f);
                f3 = 9.8471f;
            }
        } else if (this.c == 1) {
            float f6 = this.d;
            f = this.j;
            f2 = (((f6 * 0.0939f) + (0.3758f * f)) - ((i * 1.0f) * 0.0032f)) - (this.f18656a * 0.006925f);
            f3 = 0.097f;
        } else {
            float f7 = this.d;
            f = this.j;
            f2 = (((f7 * 0.0877f) + (0.2973f * f)) + ((i * 1.0f) * 0.0128f)) - (this.f18656a * 0.00603f);
            f3 = 0.5175f;
        }
        float f8 = ((f2 + f3) / f) * 100.0f;
        if (f8 < 20.0f) {
            f8 = 20.0f;
        }
        if (f8 > 85.0f) {
            f8 = 85.0f;
        }
        return new BigDecimal(f8).setScale(2, 4).floatValue();
    }

    private float l() {
        float f;
        float f2;
        float f3;
        float f4;
        float fO = o();
        if (fO > 45.0f) {
            float f5 = this.j;
            f4 = f5 - (0.45f * f5);
            f = 4.0f;
        } else {
            f = 1.0f;
            if (fO < 5.0f) {
                float f6 = this.j;
                f4 = f6 - (0.05f * f6);
            } else {
                if (this.e) {
                    if (this.c == 1) {
                        f2 = (((this.d * 0.2764f) + (this.j * 0.3662f)) - (this.b * 0.0337f)) - (this.f18656a * 0.0199f);
                        f3 = 7.739f;
                    } else {
                        f2 = (((this.d * 0.2676f) + (this.j * 0.1948f)) - (this.b * 0.0063f)) - (this.f18656a * 0.0127f);
                        f3 = 7.8411f;
                    }
                } else if (this.c == 1) {
                    f2 = (((this.d * 0.2867f) + (this.j * 0.3894f)) - ((this.b * 1.0f) * 0.0408f)) - (this.f18656a * 0.01235f);
                    f3 = 15.7665f;
                } else {
                    f2 = (((this.d * 0.3186f) + (this.j * 0.1934f)) - ((this.b * 1.0f) * 0.0206f)) - (this.f18656a * 0.0132f);
                    f3 = 16.4556f;
                }
                float f7 = f2 - f3;
                if (f7 < 7.0f) {
                    f7 = 7.0f;
                }
                if (f7 > 141.5f) {
                    return 141.5f;
                }
                return f7;
            }
        }
        return f4 - f;
    }

    public float e(float f) {
        float f2 = this.j;
        float f3 = 0.0f;
        if (f2 > 0.0f) {
            if (f == 0.0f) {
                f = l();
                f2 = this.j;
            }
            f3 = (f / f2) * 100.0f;
        }
        return new BigDecimal(f3).setScale(2, 4).floatValue();
    }

    public float h() {
        float f = (this.j - f()) - l();
        float f2 = 1.0f;
        if (f >= 1.0f) {
            f2 = 4.0f;
            if (f <= 4.0f) {
                return f;
            }
        }
        return f2;
    }

    public float e() {
        float f;
        float f2;
        if (this.e) {
            if (this.c == 1) {
                f = (((this.d * 7.2819f) + (this.j * 12.3775f)) - (this.b * 4.4731f)) - (this.f18656a * 0.5458f);
                f2 = 84.7412f;
            } else {
                f = (((this.d * 6.3442f) + (this.j * 9.8875f)) - (this.b * 3.4612f)) - (this.f18656a * 0.3056f);
                f2 = 59.9762f;
            }
        } else if (this.c == 1) {
            f = (((this.d * 7.5037f) + (this.j * 13.1523f)) - ((this.b * 1.0f) * 4.3376f)) - (this.f18656a * 0.3486f);
            f2 = 311.7751f;
        } else {
            f = (((this.d * 7.5432f) + (this.j * 9.9474f)) - ((this.b * 1.0f) * 3.4382f)) - (this.f18656a * 0.309f);
            f2 = 288.2821f;
        }
        return new BigDecimal(f - f2).setScale(1, 4).floatValue();
    }

    public int d() {
        float f;
        float f2;
        int i = this.b;
        if (i <= 17) {
            return 0;
        }
        if (this.e) {
            if (this.c == 1) {
                f = (this.d * (-0.5378f)) + (this.j * 0.7642f) + (i * 0.3667f) + (this.f18656a * 0.039f);
                f2 = 33.8131f;
            } else {
                f = (this.d * (-0.9531f)) + (this.j * 1.5246f) + (i * 0.4584f) + (this.f18656a * 0.0374f);
                f2 = 58.5035f;
            }
        } else if (this.c == 1) {
            f = (this.d * (-0.7471f)) + (this.j * 0.9161f) + (i * 1.0f * 0.4184f) + (this.f18656a * 0.0517f);
            f2 = 54.2267f;
        } else {
            f = (this.d * (-1.1165f)) + (this.j * 1.5784f) + (i * 1.0f * 0.4615f) + (this.f18656a * 0.0415f);
            f2 = 83.2548f;
        }
        int i2 = (int) (f + f2);
        if (i2 - i > 10) {
            i2 = i + 10;
        } else if (i - i2 > 10) {
            i2 = i - 10;
        }
        if (i2 < 18) {
            i2 = 18;
        }
        if (i2 > 80) {
            return 80;
        }
        return i2;
    }

    public float a() {
        return e(this.c, this.d);
    }

    public float n() {
        return c(c(), b(), this.c, this.b);
    }

    public float i() {
        return e(this.d, this.j, this.c, this.b, c(), l(), m());
    }

    private float e(float f, float f2, byte b, int i, float f3, float f4, float f5) {
        if (i > 17) {
            return d(f, f2, b, i, f3, f4, f5);
        }
        return 0.0f;
    }

    public static float b(float f, float f2, byte b, int i, float f3) {
        return c(f3, (f2 / (f * f)) * 100.0f * 100.0f, b, i);
    }
}
