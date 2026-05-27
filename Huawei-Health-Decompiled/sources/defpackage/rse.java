package defpackage;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes7.dex */
public class rse {
    public static pxc dCt_(boolean z, rsc rscVar, rsd rsdVar, CompoundButton.OnCheckedChangeListener... onCheckedChangeListenerArr) {
        pxc pxcVar = new pxc();
        if (rscVar != null && rsdVar != null) {
            pxcVar.c(rscVar.a());
            pxcVar.b(rscVar.b());
            pxcVar.b(rsdVar.d());
            pxcVar.a(rsdVar.a());
            pxcVar.c(rsdVar.b());
            pxcVar.d(rscVar.e());
            pxcVar.b(z);
            if (onCheckedChangeListenerArr.length != 0) {
                pxcVar.dhK_(onCheckedChangeListenerArr[0]);
            }
        }
        return pxcVar;
    }
}
