package com.huawei.uikit.hwedittext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.huawei.health.R;
import defpackage.vpd;

/* JADX INFO: loaded from: classes11.dex */
public class HwHelpTextLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HwWidgetStyle f11158a;
    private EditText b;
    protected HwShapeMode c;
    private CharSequence d;
    private TextView e;
    private int f;
    private CharSequence g;
    private CharSequence i;

    public HwHelpTextLayout(Context context) {
        this(context, null);
    }

    private static Context c(Context context, int i) {
        return vpd.d(context, i, R.style.Theme_Emui_HwEditText);
    }

    public EditText getEditText() {
        return this.b;
    }

    public CharSequence getHelp() {
        return this.e.getText();
    }

    public CharSequence getHint() {
        return this.b.getHint();
    }

    public CharSequence getText() {
        return this.b.getText();
    }

    public TextView getTextView() {
        return this.e;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setHelp(CharSequence charSequence) {
        this.e.setText(charSequence);
    }

    public void setHint(CharSequence charSequence) {
        this.b.setHint(charSequence);
    }

    public void setText(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public HwHelpTextLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr._2131100539_res_0x7f06037b);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr._2131100537_res_0x7f060379, R.attr._2131100538_res_0x7f06037a, R.attr._2131100540_res_0x7f06037c, R.attr._2131100731_res_0x7f06043b, R.attr._2131100779_res_0x7f06046b, R.attr._2131100821_res_0x7f060495}, i, R.style.Widget_Emui_HwHelpTextLayout);
        this.c = HwShapeMode.values()[typedArrayObtainStyledAttributes.getInt(3, 0)];
        this.f11158a = HwWidgetStyle.values()[typedArrayObtainStyledAttributes.getInt(5, 0)];
        this.d = typedArrayObtainStyledAttributes.getString(2);
        this.i = typedArrayObtainStyledAttributes.getString(4);
        this.g = typedArrayObtainStyledAttributes.getString(0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public HwHelpTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(c(context, i), attributeSet, i);
        a(super.getContext(), attributeSet, i);
        HwShapeMode hwShapeMode = this.c;
        if (hwShapeMode == HwShapeMode.BUBBLE) {
            c(R.layout.hwedittext_help_text_layout_bubble, R.layout.hwedittext_help_text_layout_bubble_dark, R.layout.hwedittext_help_text_layout_bubble_translucent);
            return;
        }
        if (hwShapeMode == HwShapeMode.LINEAR) {
            c(R.layout.hwedittext_help_text_layout_linear, R.layout.hwedittext_help_text_layout_linear_dark, R.layout.hwedittext_help_text_layout_linear_translucent);
        } else if (hwShapeMode == HwShapeMode.WHITE) {
            c(R.layout.hwedittext_help_text_layout_bubble_white, R.layout.hwedittext_help_text_layout_bubble_white_dark, R.layout.hwedittext_help_text_layout_bubble_white_translucent);
        } else {
            c(R.layout.hwedittext_help_text_layout_space, R.layout.hwedittext_help_text_layout_space_dark, R.layout.hwedittext_help_text_layout_space_translucent);
        }
    }

    private void e(int i) {
        View.inflate(getContext(), i, this);
        EditText editText = (EditText) findViewById(R.id.hwedittext_edit);
        this.b = editText;
        if (editText != null) {
            editText.setHint(this.d);
            this.b.setText(this.i);
        }
        TextView textView = (TextView) findViewById(R.id.hwedittext_text_assist);
        this.e = textView;
        if (textView != null) {
            textView.setText(this.g);
            TextViewCompat.setTextAppearance(this.e, this.f);
        }
    }

    private void c(int i, int i2, int i3) {
        HwWidgetStyle hwWidgetStyle = this.f11158a;
        if (hwWidgetStyle == HwWidgetStyle.LIGHT) {
            e(i);
        } else if (hwWidgetStyle == HwWidgetStyle.DARK) {
            e(i2);
        } else {
            e(i3);
        }
    }
}
