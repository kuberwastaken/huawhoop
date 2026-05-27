package com.huawei.uikit.hwedittext.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.huawei.health.R;
import com.huawei.uikit.hwedittext.R$dimen;
import defpackage.vpb;
import defpackage.vpd;

/* JADX INFO: loaded from: classes8.dex */
public class HwErrorTipTextLayout extends RelativeLayout {
    private static final String k = "HwErrorTipTextLayout";
    private static final int l = 3;
    private static final int m = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11157a;
    private int b;
    private int c;
    private int d;
    private HwShapeMode e;
    private int f;
    private int g;
    private int h;
    private int i;
    private LinearLayout j;
    protected EditText mEditText;
    protected int mErrorTextAppearance;
    protected TextView mErrorView;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean b;

        a(boolean z) {
            this.b = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            HwErrorTipTextLayout.this.setBackground(this.b);
            HwErrorTipTextLayout.this.mErrorView.setAlpha(this.b ? 1.0f : 0.0f);
            HwErrorTipTextLayout.this.mErrorView.setVisibility(this.b ? 0 : 8);
        }
    }

    /* JADX INFO: loaded from: classes11.dex */
    class b extends View.AccessibilityDelegate {
        private b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (view == null || accessibilityEvent == null) {
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(HwErrorTipTextLayout.k);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        /* synthetic */ b(HwErrorTipTextLayout hwErrorTipTextLayout, a aVar) {
            this();
        }
    }

    public HwErrorTipTextLayout(Context context) {
        this(context, null);
    }

    private static Context a(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwEditText);
    }

    public static HwErrorTipTextLayout instantiate(Context context) {
        Object objC = vpb.c(context, vpb.d(context, HwErrorTipTextLayout.class, vpb.e(context, 3, 1)), HwErrorTipTextLayout.class);
        if (objC instanceof HwErrorTipTextLayout) {
            return (HwErrorTipTextLayout) objC;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, updateEditTextMargin(layoutParams));
        }
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public CharSequence getError() {
        TextView textView = this.mErrorView;
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    public CharSequence getHint() {
        EditText editText = this.mEditText;
        if (editText == null) {
            return null;
        }
        return editText.getHint();
    }

    protected void initErrorView() {
        TextView textView = new TextView(getContext());
        this.mErrorView = textView;
        textView.setVisibility(8);
        this.mErrorView.setPaddingRelative(this.mEditText.getPaddingLeft(), getResources().getDimensionPixelSize(R$dimen.hwedittext_dimens_text_margin_fifth), this.mEditText.getPaddingRight(), 0);
        TextViewCompat.setTextAppearance(this.mErrorView, this.mErrorTextAppearance);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.mEditText.getId());
        this.mErrorView.setLayoutParams(layoutParams);
        addView(this.mErrorView);
    }

    public boolean isErrorEnabled() {
        return this.f11157a;
    }

    protected void setBackground(boolean z) {
        EditText editText = this.mEditText;
        if (editText == null || this.mErrorView == null) {
            return;
        }
        HwShapeMode hwShapeMode = this.e;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            editText.setBackgroundResource(z ? this.b : this.f);
            return;
        }
        if (hwShapeMode == HwShapeMode.LINEAR) {
            editText.setBackgroundResource(z ? this.d : this.h);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            editText.setBackgroundResource(z ? this.c : this.g);
        } else {
            editText.setBackgroundResource(z ? this.d : this.i);
        }
    }

    protected void setEditText(EditText editText) {
        if (this.mEditText != null) {
            return;
        }
        this.mEditText = editText;
        this.mEditText.setImeOptions(editText.getImeOptions() | 33554432);
        HwShapeMode hwShapeMode = this.e;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            this.mEditText.setBackgroundResource(this.f);
        } else if (hwShapeMode == HwShapeMode.LINEAR) {
            this.mEditText.setBackgroundResource(this.h);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            this.mEditText.setBackgroundResource(this.g);
        } else {
            this.mEditText.setBackgroundResource(this.i);
        }
        initErrorView();
    }

    public void setError(CharSequence charSequence) {
        if (this.mEditText == null || this.mErrorView == null || !this.f11157a) {
            return;
        }
        boolean z = !TextUtils.isEmpty(charSequence);
        this.mErrorView.setText(charSequence);
        this.mErrorView.animate().setInterpolator(new LinearInterpolator()).setDuration(200L).alpha(z ? 1.0f : 0.0f).setListener(new a(z)).start();
        sendAccessibilityEvent(2048);
    }

    public void setErrorEnabled(boolean z) {
        TextView textView;
        if (z == this.f11157a || (textView = this.mErrorView) == null) {
            return;
        }
        textView.setAlpha(z ? 1.0f : 0.0f);
        this.mErrorView.setVisibility(z ? 0 : 8);
        this.f11157a = z;
    }

    public void setHint(CharSequence charSequence) {
        EditText editText = this.mEditText;
        if (editText == null) {
            return;
        }
        editText.setHint(charSequence);
        sendAccessibilityEvent(2048);
    }

    protected ViewGroup.LayoutParams updateEditTextMargin(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null ? new RelativeLayout.LayoutParams(layoutParams) : generateDefaultLayoutParams();
    }

    public HwErrorTipTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100479_res_0x7f06033f);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        setAddStatesFromChildren(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100471_res_0x7f060337, R.attr._2131100472_res_0x7f060338, R.attr._2131100474_res_0x7f06033a, R.attr._2131100475_res_0x7f06033b, R.attr._2131100476_res_0x7f06033c, R.attr._2131100477_res_0x7f06033d, R.attr._2131100478_res_0x7f06033e, R.attr._2131100587_res_0x7f0603ab, R.attr._2131100731_res_0x7f06043b, R.attr._2131100740_res_0x7f060444}, i, R.style.Widget_Emui_HwErrorTipTextLayout);
        this.f = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.g = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        this.h = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.i = typedArrayObtainStyledAttributes.getResourceId(9, 0);
        this.b = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.c = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.mErrorTextAppearance = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.d = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f11157a = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.e = HwShapeMode.values()[typedArrayObtainStyledAttributes.getInt(8, 0)];
        typedArrayObtainStyledAttributes.recycle();
        setAccessibilityDelegate(new b(this, null));
    }

    public HwErrorTipTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(a(context, i), attributeSet, i);
        a(super.getContext(), attributeSet, i);
    }
}
