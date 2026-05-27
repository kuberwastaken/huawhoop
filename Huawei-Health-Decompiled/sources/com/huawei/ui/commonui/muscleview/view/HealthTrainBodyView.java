package com.huawei.ui.commonui.muscleview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.core.graphics.PathParser;
import com.huawei.ui.commonui.R$color;
import com.huawei.ui.commonui.muscleview.data.HealthBodyPath;
import com.huawei.ui.commonui.muscleview.data.HealthMusclePath;
import defpackage.nwp;
import defpackage.pio;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class HealthTrainBodyView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9271a;
    private Paint b;
    private Paint c;
    private int d;
    private volatile List<HealthBodyPath> e;
    private int[] f;
    private int[] g;
    private volatile List<HealthMusclePath> h;
    private float[] i;
    private volatile List<HealthBodyPath> j;
    private SparseArray<Integer> l;
    private int n;

    public HealthTrainBodyView(Context context) {
        super(context);
        this.f = new int[]{getResources().getColor(R$color.emui_color_muscle_total_low), getResources().getColor(R$color.emui_color_muscle_total_top)};
        this.g = new int[]{getResources().getColor(R$color.emui_color_muscle_slight_top), getResources().getColor(R$color.emui_color_muscle_slight_top)};
        this.i = new float[]{0.0f, 1.0f};
        this.f9271a = getResources().getColor(R$color.emui_color_muscle_backgroud);
        this.d = getResources().getColor(R$color.emui_color_muscle_body_backgroud);
        e();
    }

    public HealthTrainBodyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new int[]{getResources().getColor(R$color.emui_color_muscle_total_low), getResources().getColor(R$color.emui_color_muscle_total_top)};
        this.g = new int[]{getResources().getColor(R$color.emui_color_muscle_slight_top), getResources().getColor(R$color.emui_color_muscle_slight_top)};
        this.i = new float[]{0.0f, 1.0f};
        this.f9271a = getResources().getColor(R$color.emui_color_muscle_backgroud);
        this.d = getResources().getColor(R$color.emui_color_muscle_body_backgroud);
        e();
    }

    public HealthTrainBodyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new int[]{getResources().getColor(R$color.emui_color_muscle_total_low), getResources().getColor(R$color.emui_color_muscle_total_top)};
        this.g = new int[]{getResources().getColor(R$color.emui_color_muscle_slight_top), getResources().getColor(R$color.emui_color_muscle_slight_top)};
        this.i = new float[]{0.0f, 1.0f};
        this.f9271a = getResources().getColor(R$color.emui_color_muscle_backgroud);
        this.d = getResources().getColor(R$color.emui_color_muscle_body_backgroud);
        e();
    }

    private void e() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setColor(this.f9271a);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(this.d);
        this.b.setStrokeWidth(1.0f);
        this.n = 1;
        invalidate();
    }

    public void setSecondColors(int... iArr) {
        this.f = iArr;
    }

    public void setFirstColors(int... iArr) {
        this.g = iArr;
    }

    public void setFrontViewData(List<HealthBodyPath> list, List<HealthMusclePath> list2, SparseArray<Integer> sparseArray) {
        this.n = 1;
        this.j = list;
        this.h = list2;
        this.l = sparseArray;
        b();
    }

    public void setBackViewData(List<HealthBodyPath> list, List<HealthMusclePath> list2, SparseArray<Integer> sparseArray) {
        this.n = 2;
        this.e = list;
        this.h = list2;
        this.l = sparseArray;
        b();
    }

    private void b() {
        if (this.h != null) {
            for (HealthMusclePath healthMusclePath : this.h) {
                if (healthMusclePath != null) {
                    if (this.l == null) {
                        break;
                    }
                    for (int i = 0; i < this.l.size(); i++) {
                        int iKeyAt = this.l.keyAt(i);
                        if (iKeyAt == healthMusclePath.d()) {
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            List<pio> listE = healthMusclePath.e();
                            if (listE != null && !listE.isEmpty()) {
                                int iIntValue = this.l.get(iKeyAt).intValue();
                                for (pio pioVar : listE) {
                                    if (pioVar != null) {
                                        if (iIntValue >= 1) {
                                            LinearGradient linearGradient = new LinearGradient(pioVar.j(), pioVar.h(), pioVar.j(), pioVar.e(), iIntValue > 1 ? this.f : this.g, this.i, Shader.TileMode.CLAMP);
                                            Paint paint2 = new Paint();
                                            paint2.setAntiAlias(true);
                                            paint2.setShader(linearGradient);
                                            pioVar.cOF_(paint2);
                                            paint = paint2;
                                        } else {
                                            paint.setColor(this.f9271a);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.n;
        if (i == 1) {
            cOL_(canvas);
        } else if (i != 2) {
            return;
        } else {
            cOJ_(canvas);
        }
        cOM_(canvas);
    }

    private void cOM_(Canvas canvas) {
        if (this.h == null || this.h.isEmpty()) {
            return;
        }
        for (HealthMusclePath healthMusclePath : this.h) {
            if (healthMusclePath != null && healthMusclePath.e() != null && !healthMusclePath.e().isEmpty()) {
                for (pio pioVar : healthMusclePath.e()) {
                    if (pioVar != null && pioVar.cOE_() != null) {
                        int iSave = canvas.save();
                        canvas.scale(nwp.b(getContext()), nwp.b(getContext()));
                        canvas.drawPath(PathParser.createPathFromPathData(pioVar.b()), pioVar.cOE_());
                        canvas.restoreToCount(iSave);
                    }
                }
            }
        }
    }

    private void cOL_(Canvas canvas) {
        if (this.j == null || this.j.isEmpty()) {
            return;
        }
        cOK_(canvas, this.j);
    }

    private void cOJ_(Canvas canvas) {
        if (this.e == null || this.e.isEmpty()) {
            return;
        }
        cOK_(canvas, this.e);
    }

    public HealthMusclePath d(int i) {
        for (HealthMusclePath healthMusclePath : this.h) {
            if (healthMusclePath != null && i == healthMusclePath.d()) {
                return healthMusclePath;
            }
        }
        return null;
    }

    public int getType() {
        return this.n;
    }

    public void setBgColor(int i) {
        this.f9271a = i;
        this.c.setColor(i);
        invalidate();
    }

    private void cOK_(Canvas canvas, List<HealthBodyPath> list) {
        boolean z = true;
        for (HealthBodyPath healthBodyPath : list) {
            if (healthBodyPath != null) {
                int iSave = canvas.save();
                canvas.scale(nwp.b(getContext()), nwp.b(getContext()));
                if (z) {
                    canvas.drawPath(PathParser.createPathFromPathData(healthBodyPath.e()), this.b);
                    canvas.restoreToCount(iSave);
                    z = false;
                } else {
                    canvas.drawPath(PathParser.createPathFromPathData(healthBodyPath.e()), this.c);
                    canvas.restoreToCount(iSave);
                }
            }
        }
    }
}
