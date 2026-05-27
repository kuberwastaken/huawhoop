package defpackage;

import com.huawei.health.R;

/* JADX INFO: loaded from: classes4.dex */
public class gjc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f13485a;
    private int[] b;
    private String[] c;
    private String[] d;
    private String[] e;
    private String[] g = bmh.c().getResources().getStringArray(R.array._2130968618_res_0x7f04002a);

    public gjc(int i) {
        if (i == 0 || i == 1) {
            this.c = bmh.c().getResources().getStringArray(R.array._2130968619_res_0x7f04002b);
            this.b = bmh.c().getResources().getIntArray(R.array._2130968714_res_0x7f04008a);
            this.f13485a = bmh.c().getResources().getIntArray(R.array._2130968715_res_0x7f04008b);
            this.e = bmh.c().getResources().getStringArray(R.array._2130968620_res_0x7f04002c);
            this.d = bmh.c().getResources().getStringArray(R.array._2130968621_res_0x7f04002d);
            return;
        }
        this.c = bmh.c().getResources().getStringArray(R.array._2130968622_res_0x7f04002e);
        this.b = bmh.c().getResources().getIntArray(R.array._2130968716_res_0x7f04008c);
        this.f13485a = bmh.c().getResources().getIntArray(R.array._2130968717_res_0x7f04008d);
        this.e = bmh.c().getResources().getStringArray(R.array._2130968623_res_0x7f04002f);
        this.d = bmh.c().getResources().getStringArray(R.array._2130968624_res_0x7f040030);
    }

    public String a(int i) {
        if (i >= 0) {
            String[] strArr = this.g;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return String.valueOf(i);
    }

    public String b(int i) {
        if (i >= 0) {
            String[] strArr = this.c;
            if (strArr.length > i) {
                return strArr[i];
            }
        }
        return String.valueOf(i);
    }

    public int d(int i) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (iArr.length >= i) {
                return iArr[i];
            }
        }
        return this.b[0];
    }

    public int e(int i) {
        if (i >= 0) {
            int[] iArr = this.f13485a;
            if (iArr.length >= i) {
                return iArr[i];
            }
        }
        return this.f13485a[0];
    }
}
