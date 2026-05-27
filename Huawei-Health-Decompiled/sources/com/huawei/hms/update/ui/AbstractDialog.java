package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.UIUtil;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f6258a;
    private AbsUpdateWizard b;

    public void cancel() {
        Dialog dialog = this.f6258a;
        if (dialog != null) {
            dialog.cancel();
        }
    }

    public void dismiss() {
        Dialog dialog = this.f6258a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    protected void fireCancel() {
        AbsUpdateWizard absUpdateWizard = this.b;
        if (absUpdateWizard != null) {
            absUpdateWizard.onCancel(this);
        }
    }

    protected void fireDoWork() {
        AbsUpdateWizard absUpdateWizard = this.b;
        if (absUpdateWizard != null) {
            absUpdateWizard.onDoWork(this);
        }
    }

    protected Activity getActivity() {
        AbsUpdateWizard absUpdateWizard = this.b;
        if (absUpdateWizard != null) {
            return absUpdateWizard.getActivity();
        }
        return null;
    }

    protected int getDialogThemeId() {
        return UIUtil.getDialogThemeId(getActivity());
    }

    public boolean isShowing() {
        Dialog dialog = this.f6258a;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    protected abstract Dialog onCreateDialog();

    public void replaceAlertDialog(Dialog dialog) {
        Dialog dialog2 = this.f6258a;
        if (dialog2 != null) {
            dialog2.setOnCancelListener(null);
            this.f6258a.cancel();
        }
        this.f6258a = dialog;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.hms.update.ui.AbstractDialog.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AbstractDialog.this.fireCancel();
                }
            });
            UIUtil.enableFocusedForButtonsInTV(this.f6258a);
            dialog.show();
        }
    }

    public void setMessage(CharSequence charSequence) {
        Log.w("AbstractDialog", "unsupported.");
    }

    public void setTitle(CharSequence charSequence) {
        Log.w("AbstractDialog", "unsupported.");
    }

    public void show(AbsUpdateWizard absUpdateWizard) {
        this.b = absUpdateWizard;
        if (getActivity() == null || getActivity().isFinishing()) {
            HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        Dialog dialogOnCreateDialog = onCreateDialog();
        this.f6258a = dialogOnCreateDialog;
        if (dialogOnCreateDialog == null) {
            HMSLog.e("AbstractDialog", "In show, The dialog is null.");
            return;
        }
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        this.f6258a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.hms.update.ui.AbstractDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AbstractDialog.this.fireCancel();
            }
        });
        UIUtil.enableFocusedForButtonsInTV(this.f6258a);
        this.f6258a.show();
    }
}
