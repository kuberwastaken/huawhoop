package defpackage;

import android.view.MotionEvent;
import android.view.View;
import com.huawei.uikit.hwrecyclerview.widget.HwRollbackRuleDetector;

/* JADX INFO: loaded from: classes8.dex */
public class voy {
    private HwRollbackRuleDetector c;

    public voy(HwRollbackRuleDetector.RollBackScrollListener rollBackScrollListener) {
        this.c = new HwRollbackRuleDetector(rollBackScrollListener);
    }

    public void a() {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.c;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.d("com.huawei.control.intent.action.RollBackUsedEvent");
        }
    }

    public void c() {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.c;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.c();
        }
    }

    public void eEm_(MotionEvent motionEvent) {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.c;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.eEk_(motionEvent);
        }
    }

    public void eEn_(View view) {
        HwRollbackRuleDetector hwRollbackRuleDetector = this.c;
        if (hwRollbackRuleDetector != null) {
            hwRollbackRuleDetector.eEl_(view);
        }
    }
}
