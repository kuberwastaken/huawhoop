package com.amap.api.col.p0003sl;

import com.google.android.material.timepicker.TimeModel;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: classes9.dex */
public final class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f909a = "0123456789";

    public static String a() {
        Random random = new Random();
        String str = String.format(Locale.US, "%05d", Integer.valueOf(random.nextInt(10)));
        int iNextInt = random.nextInt(10);
        int iNextInt2 = random.nextInt(100);
        return new a(f909a, iNextInt2).a(iNextInt, str) + String.format(Locale.US, "%01d", Integer.valueOf(iNextInt)) + String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(iNextInt2));
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f910a;
        private int b;
        private int c;

        public a(String str, int i) {
            this.b = 1103515245;
            this.c = 12345;
            this.f910a = a(str, i, str.length());
        }

        public a() {
            this((byte) 0);
        }

        private a(byte b) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }

        private char a(int i) {
            this.f910a.length();
            return this.f910a.charAt(i);
        }

        private int a(char c) {
            this.f910a.length();
            return this.f910a.indexOf(c);
        }

        private int b(int i) {
            return (int) (((((long) i) * ((long) this.b)) + ((long) this.c)) & 2147483647L);
        }

        private String a(String str, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i3 = 0; i3 < i2; i3++) {
                int iB = b(i);
                int i4 = iB % length;
                i = b(iB);
                int i5 = i % length;
                char cCharAt = stringBuffer.charAt(i4);
                stringBuffer.setCharAt(i4, stringBuffer.charAt(i5));
                stringBuffer.setCharAt(i5, cCharAt);
            }
            return stringBuffer.toString();
        }

        private String b(int i, String str) {
            StringBuilder sb = new StringBuilder();
            int length = this.f910a.length();
            int length2 = str.length();
            for (int i2 = 0; i2 < length2; i2++) {
                int iA = a(str.charAt(i2));
                if (iA < 0) {
                    break;
                }
                sb.append(a(((iA + i) + i2) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        public final String a(int i, String str) {
            return b(i, str);
        }
    }
}
