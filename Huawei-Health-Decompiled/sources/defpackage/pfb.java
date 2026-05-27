package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
class pfb extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16667a;
    private float b;
    private int c;
    private float d;

    pfb(View view, float f, float f2) {
        super(view.getResources(), cLb_(view));
        pew pewVar = (pew) view.getTag();
        this.b = pewVar.cLa_().top;
        this.c = pewVar.cLa_().left;
        this.d = f;
        this.f16667a = f2;
        setBounds(pewVar.cLa_().left, pewVar.cLa_().top, pewVar.cLa_().right, pewVar.cLa_().bottom);
    }

    void cLc_(MotionEvent motionEvent) {
        int y = (int) ((this.b - this.d) + motionEvent.getY());
        int x = (int) ((this.c - this.f16667a) + motionEvent.getX());
        setBounds(x, y, getIntrinsicWidth() + x, getIntrinsicHeight() + y);
    }

    static Bitmap cLb_(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }
}
