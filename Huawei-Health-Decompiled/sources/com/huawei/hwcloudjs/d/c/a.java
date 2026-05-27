package com.huawei.hwcloudjs.d.c;

import com.huawei.hwcloudjs.e.b.c;
import com.huawei.hwcloudjs.e.b.d;

/* JADX INFO: loaded from: classes5.dex */
public class a extends c<C0174a> {
    private static a b = new a();

    /* JADX INFO: renamed from: com.huawei.hwcloudjs.d.c.a$a, reason: collision with other inner class name */
    public static final class C0174a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6411a;
        private int[] b;

        public int b() {
            return this.f6411a;
        }

        public int[] a() {
            int[] iArr = this.b;
            return iArr != null ? (int[]) iArr.clone() : new int[0];
        }

        public void a(int[] iArr) {
            if (iArr != null) {
                this.b = (int[]) iArr.clone();
            }
        }

        public void a(int i) {
            this.f6411a = i;
        }
    }

    public static a a() {
        return b;
    }
}
