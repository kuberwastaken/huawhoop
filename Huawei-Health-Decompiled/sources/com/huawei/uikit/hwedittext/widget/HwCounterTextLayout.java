package com.huawei.uikit.hwedittext.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.huawei.health.R;
import com.huawei.uikit.hwedittext.R$dimen;
import defpackage.vpd;

/* JADX INFO: loaded from: classes11.dex */
public class HwCounterTextLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11154a;
    private HwShapeMode b;
    private int c;
    private int d;
    private EditText e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private d l;
    private int m;
    private int n;
    private Animation o;
    private b t;

    class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f11155a;

        private b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            TextViewCompat.setTextAppearance(HwCounterTextLayout.this.f11154a, HwCounterTextLayout.this.d);
            HwCounterTextLayout.this.setBackground(false);
            this.f11155a = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            HwCounterTextLayout.this.f11154a.setTextColor(HwCounterTextLayout.this.c);
            HwCounterTextLayout.this.setBackground(this.f11155a);
        }

        /* synthetic */ b(HwCounterTextLayout hwCounterTextLayout, bzrwd bzrwdVar) {
            this();
        }
    }

    class bzrwd extends TextView {
        bzrwd(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        protected void onVisibilityChanged(View view, int i) {
            super.onVisibilityChanged(view, i);
            if (HwCounterTextLayout.this.b == HwShapeMode.BUBBLE || HwCounterTextLayout.this.b == HwShapeMode.WHITE) {
                HwCounterTextLayout.this.d();
            }
        }
    }

    class d implements TextWatcher {
        private d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            HwCounterTextLayout.this.d(charSequence);
        }

        /* synthetic */ d(HwCounterTextLayout hwCounterTextLayout, bzrwd bzrwdVar) {
            this();
        }
    }

    class e extends View.AccessibilityDelegate {
        private e() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (view == null || accessibilityEvent == null) {
                return;
            }
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("HwCounterTextLayout");
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            if (view == null || accessibilityNodeInfo == null) {
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("HwCounterTextLayout");
            if (HwCounterTextLayout.this.e != null) {
                accessibilityNodeInfo.setLabelFor(HwCounterTextLayout.this.e);
            }
            CharSequence error = HwCounterTextLayout.this.getError();
            if (TextUtils.isEmpty(error)) {
                return;
            }
            AccessibilityNodeInfoCompat.obtain().setContentInvalid(true);
            AccessibilityNodeInfoCompat.obtain().setError(error);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        /* synthetic */ e(HwCounterTextLayout hwCounterTextLayout, bzrwd bzrwdVar) {
            this();
        }
    }

    public HwCounterTextLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackground(boolean z) {
        HwShapeMode hwShapeMode = this.b;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            this.e.setBackgroundResource(z ? this.j : this.g);
            d();
        } else if (hwShapeMode == HwShapeMode.LINEAR) {
            this.e.setBackgroundResource(z ? this.m : this.n);
        } else if (hwShapeMode != HwShapeMode.WHITE) {
            this.e.setBackgroundResource(z ? this.m : this.k);
        } else {
            this.e.setBackgroundResource(z ? this.i : this.h);
            d();
        }
    }

    private void setEditText(EditText editText) {
        if (this.e != null) {
            return;
        }
        this.e = editText;
        this.e.setImeOptions(editText.getImeOptions() | 33554432);
        HwShapeMode hwShapeMode = this.b;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            this.e.setBackgroundResource(this.g);
            return;
        }
        if (hwShapeMode == HwShapeMode.LINEAR) {
            this.e.setBackgroundResource(this.n);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            this.e.setBackgroundResource(this.h);
        } else {
            this.e.setBackgroundResource(this.k);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText) || layoutParams == null) {
            super.addView(view, i, layoutParams);
            return;
        }
        setEditText((EditText) view);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(view, 0, layoutParams2);
        super.addView(frameLayout, 0, layoutParams2);
        a();
    }

    public EditText getEditText() {
        return this.e;
    }

    public CharSequence getError() {
        TextView textView = this.f11154a;
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    public CharSequence getHint() {
        EditText editText = this.e;
        if (editText == null) {
            return null;
        }
        return editText.getHint();
    }

    public int getMaxLength() {
        return this.f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.e;
        if (editText == null) {
            return;
        }
        HwShapeMode hwShapeMode = this.b;
        if ((hwShapeMode == HwShapeMode.BUBBLE || hwShapeMode == HwShapeMode.WHITE) && (editText.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.e.getParent();
            this.e.layout(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        }
        if (this.l == null) {
            d dVar = new d(this, null);
            this.l = dVar;
            this.e.addTextChangedListener(dVar);
            EditText editText2 = this.e;
            editText2.setText(editText2.getText());
        }
    }

    public void setError(CharSequence charSequence) {
        if (this.e == null || this.f11154a == null) {
            return;
        }
        boolean z = !TextUtils.isEmpty(charSequence);
        this.f11154a.setText(charSequence);
        this.f11154a.setVisibility(z ? 0 : 8);
        this.f11154a.animate().setInterpolator(new LinearInterpolator()).setDuration(50L).alpha(z ? 1.0f : 0.0f).start();
        HwShapeMode hwShapeMode = this.b;
        if (hwShapeMode == HwShapeMode.BUBBLE || hwShapeMode == HwShapeMode.WHITE) {
            d();
        }
        sendAccessibilityEvent(2048);
    }

    public void setHint(CharSequence charSequence) {
        EditText editText = this.e;
        if (editText == null) {
            return;
        }
        editText.setHint(charSequence);
        sendAccessibilityEvent(2048);
    }

    public void setMaxLength(int i) {
        this.f = i;
    }

    public HwCounterTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100452_res_0x7f060324);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ViewGroup.LayoutParams layoutParams = this.f11154a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int height = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (this.f11154a.getVisibility() == 0) {
                height += this.f11154a.getHeight() + getResources().getDimensionPixelSize(R$dimen.hwedittext_dimens_text_margin_fifth);
            }
            EditText editText = this.e;
            editText.setPaddingRelative(editText.getPaddingStart(), this.e.getPaddingTop(), this.e.getPaddingEnd(), height);
        }
    }

    public HwCounterTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(a(context, i), attributeSet, i);
        eAS_(super.getContext(), attributeSet, i);
    }

    private static Context a(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwEditText);
    }

    private void eAS_(Context context, AttributeSet attributeSet, int i) {
        int color;
        setOrientation(1);
        try {
            color = ContextCompat.getColor(context, R.color._2131298420_res_0x7f090874);
        } catch (Resources.NotFoundException unused) {
            Log.d("HwCounterTextLayout", "initCounterTextErrorColor: resource error color not found");
            color = 0;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100450_res_0x7f060322, R.attr._2131100451_res_0x7f060323, R.attr._2131100471_res_0x7f060337, R.attr._2131100472_res_0x7f060338, R.attr._2131100475_res_0x7f06033b, R.attr._2131100476_res_0x7f06033c, R.attr._2131100477_res_0x7f06033d, R.attr._2131100587_res_0x7f0603ab, R.attr._2131100597_res_0x7f0603b5, R.attr._2131100731_res_0x7f06043b, R.attr._2131100740_res_0x7f060444}, i, R.style.Widget_Emui_HwCounterTextLayout);
        this.d = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.c = typedArrayObtainStyledAttributes.getColor(1, color);
        this.b = HwShapeMode.values()[typedArrayObtainStyledAttributes.getInt(9, 0)];
        this.n = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.k = typedArrayObtainStyledAttributes.getResourceId(10, 0);
        this.j = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.i = typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.g = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.h = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f = typedArrayObtainStyledAttributes.getInteger(8, -1);
        this.m = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setAccessibilityDelegate(new e(this, null));
        Resources resources = getResources();
        setPaddingRelative(resources.getDimensionPixelSize(R$dimen.hwedittext_dimens_max_start), 0, resources.getDimensionPixelSize(R$dimen.hwedittext_dimens_max_end), 0);
    }

    private void a() {
        bzrwd bzrwdVar = new bzrwd(getContext());
        this.f11154a = bzrwdVar;
        TextViewCompat.setTextAppearance(bzrwdVar, this.d);
        this.f11154a.setGravity(17);
        this.f11154a.setTextDirection(5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        HwShapeMode hwShapeMode = this.b;
        if (hwShapeMode != HwShapeMode.BUBBLE && hwShapeMode != HwShapeMode.WHITE) {
            layoutParams.gravity = 8388693;
            this.f11154a.setPaddingRelative(0, getResources().getDimensionPixelSize(R$dimen.hwedittext_dimens_text_margin_fifth), 0, 0);
            addView(this.f11154a, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = 8388693;
        layoutParams2.setMarginEnd(this.e.getPaddingEnd());
        layoutParams2.bottomMargin = this.e.getPaddingBottom();
        ViewParent parent = this.e.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(this.f11154a, layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CharSequence charSequence) {
        bzrwd bzrwdVar = null;
        if (this.f == -1) {
            setError(null);
            return;
        }
        if (charSequence instanceof Editable) {
            Editable editable = (Editable) charSequence;
            int length = editable.length();
            int i = this.f;
            if (length <= i) {
                if (length >= i * 0.9f) {
                    setError(getResources().getString(R.string._2130852415_res_0x7f023a3f, Integer.valueOf(length), Integer.valueOf(this.f)));
                    return;
                } else {
                    setError(null);
                    return;
                }
            }
            int selectionEnd = this.e.getSelectionEnd();
            editable.delete(this.f, editable.length());
            EditText editText = this.e;
            int i2 = this.f;
            if (selectionEnd > i2) {
                selectionEnd = i2;
            }
            editText.setSelection(selectionEnd);
            if (this.o == null) {
                this.o = AnimationUtils.loadAnimation(getContext(), R.anim._2130772046_res_0x7f01004e);
                b bVar = new b(this, bzrwdVar);
                this.t = bVar;
                Animation animation = this.o;
                if (animation != null) {
                    animation.setAnimationListener(bVar);
                }
            }
            this.t.f11155a = true;
            this.e.startAnimation(this.o);
        }
    }
}
