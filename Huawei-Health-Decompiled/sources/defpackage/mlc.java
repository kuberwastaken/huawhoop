package defpackage;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes6.dex */
public class mlc extends AlertDialog {
    @Override // android.app.AlertDialog
    public void setView(View view) {
        super.setView(view);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        e(true);
        try {
            super.onBackPressed();
        } catch (Exception unused) {
            mly.b("CustomAlertDialog", "catch Exception", true);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean onSearchRequested() {
        e(true);
        return super.onSearchRequested();
    }

    public void e(final boolean z) {
        try {
            AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: mlc.4
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        mly.a("CustomAlertDialog", "Brand:" + Build.MANUFACTURER + "Type:" + Build.MODEL, true);
                        Class<?> superclass = mlc.this.getClass();
                        int i = 0;
                        while (!superclass.getName().equals("android.app.Dialog") && i < 10) {
                            superclass = superclass.getSuperclass();
                            i++;
                            mly.a("CustomAlertDialog", "Super Class:" + superclass.getName() + " Index:" + i, true);
                        }
                        Field declaredField = superclass.getDeclaredField("mShowing");
                        declaredField.setAccessible(true);
                        declaredField.set(mlc.this, Boolean.valueOf(z));
                        if (!z) {
                            return null;
                        }
                        mlc.this.dismiss();
                        return null;
                    } catch (RuntimeException e) {
                        mly.b("CustomAlertDialog", "RuntimeException: " + e.getClass().getSimpleName(), true);
                        return null;
                    } catch (Exception e2) {
                        mly.b("CustomAlertDialog", "Exception: " + e2.getClass().getSimpleName(), true);
                        return null;
                    }
                }
            });
        } catch (Exception e) {
            mly.b("CustomAlertDialog", "Exception: " + e.getClass().getSimpleName(), true);
        }
    }

    public static class c extends AlertDialog.Builder {
        public c(Context context, int i) {
            super(context, i);
        }
    }
}
