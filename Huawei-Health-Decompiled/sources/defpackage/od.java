package defpackage;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: loaded from: classes9.dex */
public class od extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16297a;
    public int c;
    public oa e;

    public od(oa oaVar, int i, String str) {
        super(null);
        this.e = oaVar;
        this.c = i;
        this.f16297a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        oa oaVar = this.e;
        if (oaVar != null) {
            oaVar.c(this.c, this.f16297a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
