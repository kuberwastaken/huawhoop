package defpackage;

import android.util.Log;
import com.huawei.openplatform.abl.log.a;
import com.huawei.openplatform.abl.log.i;

/* JADX INFO: loaded from: classes6.dex */
public final class ndz extends a {
    @Override // com.huawei.openplatform.abl.log.i
    public void a(nef nefVar, int i, String str) {
        if (nefVar == null) {
            return;
        }
        b(nefVar.a(), i, str);
        i iVar = this.f8510a;
        if (iVar != null) {
            iVar.a(nefVar, i, str);
        }
    }

    @Override // com.huawei.openplatform.abl.log.i
    public i a(String str, String str2) {
        i iVar = this.f8510a;
        if (iVar != null) {
            iVar.a(str, str2);
        }
        return this;
    }

    private void b(String str, int i, String str2) {
        if (str == null) {
            return;
        }
        if (i == 3) {
            Log.d(str2, str);
            return;
        }
        if (i == 5) {
            Log.w(str2, str);
        } else if (i != 6) {
            Log.i(str2, str);
        } else {
            Log.e(str2, str);
        }
    }

    public static i b() {
        return new ndz();
    }

    private ndz() {
    }
}
