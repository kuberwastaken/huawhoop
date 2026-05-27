package com.huawei.uikit.hwcommon.anim;

import android.animation.Animator;
import android.content.res.ColorStateList;
import android.util.Pair;
import android.view.View;
import com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class HwFocusColorGradientAnimListener implements HwGradientAnimatorMgr.OnAnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11118a;
    private View b;
    private boolean c;
    private ColorStateList d;
    private UpdateColorCallback e;
    private ColorStateList g;
    private UpdateColorCallback h;
    private UpdateColorCallback i;
    private boolean j;

    public interface UpdateColorCallback {
        void onEnd(ColorStateList colorStateList);

        void onStart();

        void onUpdate(int i);
    }

    private int ezm_(int[] iArr, ColorStateList colorStateList) {
        if (colorStateList != null) {
            return colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        }
        return 0;
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationCancel(Animator animator, String str) {
        onAnimationEnd(animator, str);
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationEnd(Animator animator, String str) {
        UpdateColorCallback updateColorCallback;
        ColorStateList colorStateList;
        UpdateColorCallback updateColorCallback2;
        ColorStateList colorStateList2;
        if (this.f11118a && "icon_color".equals(str) && (updateColorCallback2 = this.i) != null && (colorStateList2 = this.d) != null) {
            updateColorCallback2.onEnd(colorStateList2);
        }
        if (this.j && "text_color".equals(str) && (updateColorCallback = this.h) != null && (colorStateList = this.g) != null) {
            updateColorCallback.onEnd(colorStateList);
        }
        if ("background_color".equals(str)) {
            ColorStateList backgroundTintList = this.b.getBackgroundTintList();
            UpdateColorCallback updateColorCallback3 = this.e;
            if (updateColorCallback3 == null || backgroundTintList == null) {
                return;
            }
            updateColorCallback3.onEnd(backgroundTintList);
        }
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationStart(Animator animator, String str) {
        UpdateColorCallback updateColorCallback;
        UpdateColorCallback updateColorCallback2;
        UpdateColorCallback updateColorCallback3;
        if (this.f11118a && "icon_color".equals(str) && (updateColorCallback3 = this.i) != null && this.d != null) {
            updateColorCallback3.onStart();
        }
        if (this.j && "text_color".equals(str) && (updateColorCallback2 = this.h) != null && this.g != null) {
            updateColorCallback2.onStart();
        }
        if (!"background_color".equals(str) || (updateColorCallback = this.e) == null) {
            return;
        }
        updateColorCallback.onStart();
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public void onAnimationUpdate(Animator animator, String str, int i) {
        UpdateColorCallback updateColorCallback;
        UpdateColorCallback updateColorCallback2;
        if (this.f11118a && "icon_color".equals(str) && (updateColorCallback2 = this.i) != null && this.d != null) {
            updateColorCallback2.onUpdate(i);
        }
        if (this.j && "text_color".equals(str) && (updateColorCallback = this.h) != null && this.g != null) {
            updateColorCallback.onUpdate(i);
        }
        if ("background_color".equals(str)) {
            c(i);
        }
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr.OnAnimatorListener
    public boolean onPrepareAnimation(int[] iArr, int[] iArr2, int i, int i2, Map<String, Pair<Integer, Integer>> map) {
        int iEzm_;
        int iEzm_2;
        boolean z;
        int iEzm_3;
        int iEzm_4;
        boolean z2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        if (!this.c) {
            return false;
        }
        boolean zB = b(iArr2);
        boolean zB2 = b(iArr);
        if ((!zB || zB2) && (zB || !zB2)) {
            c(i);
            return false;
        }
        boolean z3 = i != i2;
        if (!this.f11118a || (colorStateList2 = this.d) == null || this.i == null) {
            iEzm_ = 0;
            iEzm_2 = 0;
            z = false;
        } else {
            iEzm_ = ezm_(iArr2, colorStateList2);
            iEzm_2 = ezm_(iArr, this.d);
            z = iEzm_ != iEzm_2;
        }
        if (!this.j || (colorStateList = this.g) == null || this.h == null) {
            iEzm_3 = 0;
            iEzm_4 = 0;
            z2 = false;
        } else {
            iEzm_4 = ezm_(iArr2, colorStateList);
            iEzm_3 = ezm_(iArr, this.g);
            z2 = iEzm_4 != iEzm_3;
        }
        if (!z3 && !z && !z2) {
            c(i);
            return false;
        }
        if (z3) {
            map.put("background_color", new Pair<>(Integer.valueOf(i2), Integer.valueOf(i)));
        }
        if (z) {
            map.put("icon_color", new Pair<>(Integer.valueOf(iEzm_), Integer.valueOf(iEzm_2)));
        }
        if (z2) {
            map.put("text_color", new Pair<>(Integer.valueOf(iEzm_4), Integer.valueOf(iEzm_3)));
        }
        return true;
    }

    private boolean b(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842908) {
                z = true;
            }
            if (i == 16842909) {
                z2 = true;
            }
        }
        return z && z2;
    }

    private void c(int i) {
        UpdateColorCallback updateColorCallback = this.e;
        if (updateColorCallback == null) {
            this.b.getBackground().setTint(i);
        } else {
            updateColorCallback.onUpdate(i);
        }
        this.b.invalidate();
    }
}
