package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.ix;
import com.amap.api.col.p0003sl.jz;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class jy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1166a;
    private ix b;
    private boolean c = true;
    private String d = "40C27E38DCAD404B5465362914090908";
    private kb e = new kb("40C27E38DCAD404B5465362914090908");

    public final void a(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        try {
            ix ixVarA = new ix.a(str, str2, str).a(strArr).a(str3).a();
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f1166a = applicationContext;
                this.b = ixVarA;
                this.c = z;
                this.e.a(applicationContext, ixVarA);
            }
        } catch (ik unused) {
        }
    }

    public final void a(String str, String str2) {
        List<ix> listA = this.e.a(this.f1166a);
        jz jzVar = jz.a.f1167a;
        jz.a(this.f1166a, str, str2, listA, this.c, this.b);
    }
}
