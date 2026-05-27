package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.huawei.ui.commonui.R$drawable;
import com.huawei.ui.commonui.R$styleable;

/* JADX INFO: loaded from: classes7.dex */
public class pjo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16730a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private boolean f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int s;

    public pjo(Context context, AttributeSet attributeSet) {
        this.f16730a = false;
        this.d = false;
        this.i = false;
        this.g = true;
        this.f = true;
        this.j = false;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HealthTableWidget, 0, 0);
        try {
            this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.HealthTableWidget_cellMargin, 0);
            this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.HealthTableWidget_cellHorizontalMargin, this.e);
            this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.HealthTableWidget_cellVerticalMargin, this.e);
            this.f16730a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthTableWidget_columnHeaderFixed, false);
            this.d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthTableWidget_rowHeaderFixed, false);
            this.i = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthTableWidget_statisticFixed, false);
            this.f = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthTableWidget_isShowLeftRightGrid, false);
            this.g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthTableWidget_isShowTopBottomGrid, false);
            this.j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.HealthTableWidget_isShowShadow, false);
            this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.HealthTableWidget_shadowThick, 20);
            this.s = typedArrayObtainStyledAttributes.getResourceId(R$styleable.HealthTableWidget_shadowTop, R$drawable.common_table_shadow_top);
            this.m = typedArrayObtainStyledAttributes.getResourceId(R$styleable.HealthTableWidget_shadowBottom, R$drawable.common_table_shadow_bottom);
            this.l = typedArrayObtainStyledAttributes.getResourceId(R$styleable.HealthTableWidget_shadowLeft, R$drawable.common_table_shadow_left);
            this.o = typedArrayObtainStyledAttributes.getResourceId(R$styleable.HealthTableWidget_shadowRight, R$drawable.common_table_shadow_right);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int e() {
        return this.k;
    }

    public pjo c(int i) {
        this.k = i;
        return this;
    }

    public int b() {
        return this.h;
    }

    public pjo d(int i) {
        this.h = i;
        return this;
    }

    public boolean i() {
        return this.f16730a;
    }

    public boolean m() {
        return this.d;
    }

    public boolean o() {
        return this.i;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public boolean n() {
        return this.g;
    }

    public boolean l() {
        return this.f;
    }

    public boolean k() {
        return this.j;
    }

    public int j() {
        return this.n;
    }

    public int g() {
        return this.s;
    }

    public int a() {
        return this.m;
    }

    public int h() {
        return this.l;
    }

    public int f() {
        return this.o;
    }
}
