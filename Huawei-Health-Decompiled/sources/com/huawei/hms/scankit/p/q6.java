package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f6048a;
    private final List b;

    public q6(o3 o3Var) {
        this.f6048a = o3Var;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new p3(o3Var, new int[]{1}));
    }

    private p3 a(int i) {
        if (i >= this.b.size()) {
            List list = this.b;
            p3 p3VarC = (p3) list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                o3 o3Var = this.f6048a;
                p3VarC = p3VarC.c(new p3(o3Var, new int[]{1, o3Var.a((size - 1) + o3Var.a())}));
                this.b.add(p3VarC);
            }
        }
        return (p3) this.b.get(i);
    }

    public void a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                p3 p3VarA = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] iArrA = new p3(this.f6048a, iArr2).a(i, 1).b(p3VarA)[1].a();
                int length2 = i - iArrA.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(iArrA, 0, iArr, length + length2, iArrA.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
