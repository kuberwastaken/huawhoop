package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.health.suggestion.model.FitRunPlayAudio;

/* JADX INFO: loaded from: classes9.dex */
public class nt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16172a;
    public Context b;
    public SharedPreferences c;
    public SharedPreferences.Editor d = null;
    public boolean e;

    public nt(Context context, String str, String str2, boolean z, boolean z2) {
        this.c = null;
        this.e = z2;
        this.f16172a = str2;
        this.b = context;
        if (context != null) {
            this.c = context.getSharedPreferences(str2, 0);
        }
    }

    public void b(String str) {
        if (ng.a(str) || str.equals(FitRunPlayAudio.PLAY_TYPE_T)) {
            return;
        }
        e();
        SharedPreferences.Editor editor = this.d;
        if (editor != null) {
            editor.remove(str);
        }
    }

    public final void e() {
        SharedPreferences sharedPreferences;
        if (this.d != null || (sharedPreferences = this.c) == null) {
            return;
        }
        this.d = sharedPreferences.edit();
    }

    public void e(String str, String str2) {
        if (ng.a(str) || str.equals(FitRunPlayAudio.PLAY_TYPE_T)) {
            return;
        }
        e();
        SharedPreferences.Editor editor = this.d;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r5.d
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r5.e
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r5.c
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r5.d
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = r3
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r5.c
            if (r1 == 0) goto L31
            android.content.Context r1 = r5.b
            if (r1 == 0) goto L31
            java.lang.String r2 = r5.f16172a
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r5.c = r1
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nt.d():boolean");
    }

    public String d(String str) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!ng.a(string)) {
                return string;
            }
        }
        return "";
    }
}
