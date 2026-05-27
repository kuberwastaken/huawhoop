package com.huawei.uikit.hwprogressbutton.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.huawei.health.R;
import com.huawei.uikit.hwbutton.widget.HwButton;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import defpackage.vpc;
import defpackage.vpd;

/* JADX INFO: loaded from: classes11.dex */
public class HwProgressButtonBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HwButton f11174a;
    private HwButton b;
    private HwProgressButton c;
    private HwTextView d;
    private HwTextView e;
    private int f;
    private int g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private ColorStateList k;
    private ColorStateList l;
    private int m;
    private ColorStateList n;
    private int o;
    private ColorStateList p;

    class b implements Runnable {

        class c implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ HwButton f11175a;
            final /* synthetic */ HwProgressButton b;
            final /* synthetic */ HwButton c;
            final /* synthetic */ String d;
            final /* synthetic */ HwTextView e;

            c(HwTextView hwTextView, HwProgressButton hwProgressButton, String str, HwButton hwButton, HwButton hwButton2) {
                this.e = hwTextView;
                this.b = hwProgressButton;
                this.d = str;
                this.f11175a = hwButton;
                this.c = hwButton2;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (!"".equals(this.e.getText().toString())) {
                    return false;
                }
                this.b.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = this.b.getMeasuredHeight();
                this.b.setIdleText(this.d);
                this.f11175a.setMinHeight(measuredHeight);
                this.c.setMinHeight(measuredHeight);
                this.f11175a.setMaxLines(1);
                this.c.setMaxLines(1);
                this.e.setMinHeight(measuredHeight);
                ViewGroup startContainer = HwProgressButtonBar.this.getStartContainer();
                ViewGroup endContainer = HwProgressButtonBar.this.getEndContainer();
                if (startContainer != null && endContainer != null) {
                    int i = measuredHeight + HwProgressButtonBar.this.m;
                    startContainer.setMinimumWidth(i);
                    startContainer.setMinimumHeight(i);
                    endContainer.setMinimumWidth(i);
                    endContainer.setMinimumHeight(i);
                }
                return true;
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwTextView percentage;
            HwProgressButton hwProgressButton = HwProgressButtonBar.this.getHwProgressButton();
            HwButton applyButton = HwProgressButtonBar.this.getApplyButton();
            HwButton updateButton = HwProgressButtonBar.this.getUpdateButton();
            if (hwProgressButton == null || applyButton == null || updateButton == null || (percentage = hwProgressButton.getPercentage()) == null) {
                return;
            }
            String string = percentage.getText().toString();
            hwProgressButton.setIdleText("");
            hwProgressButton.getViewTreeObserver().addOnPreDrawListener(new c(percentage, hwProgressButton, string, applyButton, updateButton));
        }
    }

    public HwProgressButtonBar(Context context) {
        this(context, null);
    }

    private ColorStateList getSmartIconColor() {
        return this.n;
    }

    private ColorStateList getSmartTitleColor() {
        return this.p;
    }

    private void setIconBounds(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.g;
            if (intrinsicWidth > i) {
                if (intrinsicWidth != 0) {
                    intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                }
                intrinsicWidth = i;
            }
            if (intrinsicHeight <= i) {
                i = intrinsicHeight;
            } else if (intrinsicHeight != 0) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
    }

    public HwButton getApplyButton() {
        return this.b;
    }

    public int getApplyButtonId() {
        return R.id.hwprogressbutton_bar_apply_button;
    }

    public ViewGroup getEndContainer() {
        return this.h;
    }

    public int getEndItemId() {
        return R.id.hwprogressbutton_bar_end_container;
    }

    public HwProgressButton getHwProgressButton() {
        return this.c;
    }

    public int getHwProgressButtonId() {
        return R.id.hwprogressbutton_bar_progressbutton;
    }

    public ViewGroup getStartContainer() {
        return this.j;
    }

    public int getStartItemId() {
        return R.id.hwprogressbutton_bar_start_container;
    }

    public int getStyleMode() {
        return this.f;
    }

    public HwButton getUpdateButton() {
        return this.f11174a;
    }

    public int getUpdateButtonId() {
        return R.id.hwprogressbutton_bar_update_button;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        HwTextView hwTextView = this.d;
        int lineCount = hwTextView != null ? hwTextView.getLineCount() : 0;
        HwTextView hwTextView2 = this.e;
        int lineCount2 = hwTextView2 != null ? hwTextView2.getLineCount() : 0;
        if (this.e != null && this.d != null) {
            if (lineCount > 1 || lineCount2 > 1) {
                int i3 = this.o;
                setPadding(0, i3, 0, i3);
                this.j.setGravity(49);
                this.h.setGravity(49);
            } else {
                setPadding(0, 0, 0, 0);
                this.j.setGravity(17);
                this.h.setGravity(17);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setApplyButtonClickListener(View.OnClickListener onClickListener) {
        HwButton hwButton = this.b;
        if (hwButton == null) {
            Log.w("HwProgressButtonBar", "primary button is null ");
        } else {
            hwButton.setOnClickListener(onClickListener);
        }
    }

    public void setButtonsText(CharSequence charSequence, CharSequence charSequence2) {
        e(charSequence, this.b);
        e(charSequence2, this.f11174a);
    }

    public void setEndItem(Drawable drawable, CharSequence charSequence) {
        eBR_(this.h, this.e, drawable, charSequence);
    }

    public void setEndItemClickListener(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.h;
        if (linearLayout == null) {
            Log.w("HwProgressButtonBar", "endItem is null");
        } else {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void setSmartIconColor(ColorStateList colorStateList) {
        this.n = colorStateList;
    }

    public void setSmartTitleColor(ColorStateList colorStateList) {
        this.p = colorStateList;
    }

    public void setStartAndEndItem(Drawable drawable, CharSequence charSequence, Drawable drawable2, CharSequence charSequence2) {
        eBR_(this.j, this.d, drawable, charSequence);
        eBR_(this.h, this.e, drawable2, charSequence2);
    }

    public void setStartItem(Drawable drawable, CharSequence charSequence) {
        eBR_(this.j, this.d, drawable, charSequence);
    }

    public void setStartItemClickListener(View.OnClickListener onClickListener) {
        LinearLayout linearLayout = this.j;
        if (linearLayout == null) {
            Log.w("HwProgressButtonBar", "startItem is null");
        } else {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void setStyleMode(int i) {
        this.f = i;
        if (i == 0) {
            this.i.setVisibility(8);
            this.c.setVisibility(0);
        } else {
            if (i != 1) {
                return;
            }
            this.i.setVisibility(0);
            this.c.setVisibility(8);
        }
    }

    public void setUpdateButtonClickListener(View.OnClickListener onClickListener) {
        HwButton hwButton = this.f11174a;
        if (hwButton == null) {
            Log.w("HwProgressButtonBar", "primary button is null ");
        } else {
            hwButton.setOnClickListener(onClickListener);
        }
    }

    public HwProgressButtonBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100656_res_0x7f0603f0);
    }

    private static Context c(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwProgressButton);
    }

    public void setEndItem(int i, int i2) {
        eBR_(this.h, this.e, ContextCompat.getDrawable(getContext(), i), getContext().getResources().getText(i2));
    }

    public void setStartItem(int i, int i2) {
        eBR_(this.j, this.d, ContextCompat.getDrawable(getContext(), i), getContext().getResources().getText(i2));
    }

    public HwProgressButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(c(context, i), attributeSet, i);
        eBQ_(context, attributeSet, R.layout.hwprogressbuttonbar_layout);
    }

    private void eBQ_(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, true);
        this.d = (HwTextView) findViewById(R.id.hwprogressbutton_bar_start_text_view);
        this.e = (HwTextView) findViewById(R.id.hwprogressbutton_bar_end_text_view);
        this.b = (HwButton) findViewById(R.id.hwprogressbutton_bar_apply_button);
        this.f11174a = (HwButton) findViewById(R.id.hwprogressbutton_bar_update_button);
        this.c = (HwProgressButton) findViewById(R.id.hwprogressbutton_bar_progressbutton);
        this.i = (LinearLayout) findViewById(R.id.hwprogressbutton_bar_button_layout);
        this.j = (LinearLayout) findViewById(R.id.hwprogressbutton_bar_start_container);
        this.h = (LinearLayout) findViewById(R.id.hwprogressbutton_bar_end_container);
        try {
            this.o = getResources().getDimensionPixelSize(R.dimen._2131364342_res_0x7f0a09f6);
            this.g = getResources().getDimensionPixelSize(R.dimen._2131364339_res_0x7f0a09f3);
            this.m = (int) context.getResources().getDimension(R.dimen._2131364338_res_0x7f0a09f2);
        } catch (Resources.NotFoundException unused) {
            Log.e("HwProgressButtonBar", "resource not found");
        }
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable._2131429472_res_0x7f0b0860);
        Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable._2131429471_res_0x7f0b085f);
        Drawable drawable3 = ContextCompat.getDrawable(context, R.drawable._2131429471_res_0x7f0b085f);
        Drawable drawable4 = ContextCompat.getDrawable(context, R.drawable._2131429472_res_0x7f0b0860);
        Drawable drawableMutate = DrawableCompat.wrap(drawable2).mutate();
        Drawable drawableMutate2 = DrawableCompat.wrap(drawable3).mutate();
        DrawableCompat.setTint(drawableMutate, ContextCompat.getColor(context, R.color.emui_accent));
        DrawableCompat.setTint(drawableMutate2, ContextCompat.getColor(context, R.color.emui_accent));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableMutate, drawable});
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawableMutate2, drawable4});
        this.b.setBackground(layerDrawable);
        this.f11174a.setBackground(layerDrawable2);
        Resources.Theme theme = context.getTheme();
        if (theme != null && (typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.textSize, android.R.attr.minHeight, android.R.attr.paddingStart, android.R.attr.paddingEnd, R.attr._2131100522_res_0x7f06036a, R.attr._2131100523_res_0x7f06036b, R.attr._2131100524_res_0x7f06036c, R.attr._2131100526_res_0x7f06036e, R.attr._2131100527_res_0x7f06036f, R.attr._2131100528_res_0x7f060370, R.attr._2131100529_res_0x7f060371, R.attr._2131100551_res_0x7f060387, R.attr._2131100650_res_0x7f0603ea, R.attr._2131100651_res_0x7f0603eb, R.attr._2131100652_res_0x7f0603ec, R.attr._2131100653_res_0x7f0603ed, R.attr._2131100654_res_0x7f0603ee, R.attr._2131100655_res_0x7f0603ef, R.attr._2131100657_res_0x7f0603f1, R.attr._2131100658_res_0x7f0603f2, R.attr._2131100659_res_0x7f0603f3, R.attr._2131100660_res_0x7f0603f4, R.attr._2131100661_res_0x7f0603f5, R.attr._2131100662_res_0x7f0603f6}, R.attr._2131100654_res_0x7f0603ee, R.style.Widget_Emui_HwProgressButtonBar_Button_Small)) != null) {
            this.k = typedArrayObtainStyledAttributes.getColorStateList(17);
            this.l = typedArrayObtainStyledAttributes.getColorStateList(15);
            typedArrayObtainStyledAttributes.recycle();
        }
        setStyleMode(0);
        e(getContext());
    }

    public void setButtonsText(int i, int i2) {
        e(getContext().getResources().getText(i), this.b);
        e(getContext().getResources().getText(i2), this.f11174a);
    }

    public void setStartAndEndItem(int i, int i2, int i3, int i4) {
        Resources resources = getContext().getResources();
        eBR_(this.j, this.d, ContextCompat.getDrawable(getContext(), i), resources.getText(i2));
        eBR_(this.h, this.e, ContextCompat.getDrawable(getContext(), i3), resources.getText(i4));
    }

    private void e(Context context) {
        if (Build.VERSION.SDK_INT < 29 || !vpc.c(context) || Float.compare(vpc.a(context), 1.75f) < 0) {
            return;
        }
        post(new b());
    }

    private void eBR_(LinearLayout linearLayout, HwTextView hwTextView, Drawable drawable, CharSequence charSequence) {
        if (hwTextView != null && linearLayout != null) {
            hwTextView.setText(charSequence);
            if (drawable == null && !b(hwTextView)) {
                linearLayout.setVisibility(8);
                return;
            }
            setIconBounds(drawable);
            if (b(hwTextView)) {
                hwTextView.setBackground(null);
                hwTextView.setCompoundDrawables(null, drawable, null, null);
            } else {
                hwTextView.setCompoundDrawables(null, null, null, null);
                hwTextView.setBackground(drawable);
            }
            ColorStateList smartIconColor = getSmartIconColor();
            ColorStateList smartTitleColor = getSmartTitleColor();
            Drawable drawableMutate = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (smartIconColor != null && smartTitleColor != null) {
                if (drawableMutate != null) {
                    DrawableCompat.setTintList(drawableMutate, smartIconColor);
                }
                hwTextView.setTextColor(smartTitleColor);
                return;
            }
            ColorStateList colorStateList = this.l;
            if (colorStateList != null && drawableMutate != null) {
                DrawableCompat.setTintList(drawableMutate, colorStateList);
            }
            ColorStateList colorStateList2 = this.k;
            if (colorStateList2 != null) {
                hwTextView.setTextColor(colorStateList2);
                return;
            }
            return;
        }
        Log.w("HwProgressButtonBar", "item layout initialization failed");
    }

    private boolean b(HwTextView hwTextView) {
        return !TextUtils.isEmpty(hwTextView.getText());
    }

    private void e(CharSequence charSequence, HwButton hwButton) {
        if (hwButton == null) {
            Log.w("HwProgressButtonBar", "button layout initialization failed");
        } else {
            hwButton.setText(charSequence);
        }
    }
}
