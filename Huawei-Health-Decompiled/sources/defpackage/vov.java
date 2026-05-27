package defpackage;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

/* JADX INFO: loaded from: classes11.dex */
public class vov extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18703a;
    private int b;
    private int c;
    private float d;
    private int e;
    private float g;

    public void a(int i, int i2) {
        this.e = i;
        this.b = i2;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.e("AnimDrawable", "draw: canvas is null");
            return;
        }
        canvas.save();
        canvas.clipRect(this.c, this.f18703a, canvas.getWidth(), canvas.getHeight());
        canvas.translate(this.e + this.c, this.b + this.f18703a);
        canvas.scale(this.d, this.g);
        super.draw(canvas);
        canvas.restore();
    }

    public void e(int i, int i2) {
        this.c = i;
        this.f18703a = i2;
    }
}
