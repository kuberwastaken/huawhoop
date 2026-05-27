package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes7.dex */
public class piy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16723a;
    private float b;
    private float c;
    private final Handler d;
    private MotionEvent e;
    private int f;
    private boolean h;
    private final GestureDetector.OnGestureListener i;

    class e extends Handler {
        e() {
        }

        e(Handler handler) {
            super(handler.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                return;
            }
            piy.this.d();
        }
    }

    public piy(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public piy(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.d = new e(handler);
        } else {
            this.d = new e();
        }
        this.i = onGestureListener;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f = scaledTouchSlop * scaledTouchSlop;
    }

    public void cQy_(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        cQx_(motionEvent, motionEvent.getAction(), motionEvent.getX(), motionEvent.getY());
    }

    private void cQx_(MotionEvent motionEvent, int i, float f, float f2) {
        int i2 = i & 255;
        if (i2 == 0) {
            this.c = f;
            this.b = f2;
            MotionEvent motionEvent2 = this.e;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.e = MotionEvent.obtain(motionEvent);
            this.f16723a = true;
            this.h = false;
            this.d.removeMessages(2);
            this.d.sendEmptyMessageAtTime(2, this.e.getDownTime() + 50);
            return;
        }
        if (i2 == 1) {
            if (this.f16723a) {
                this.i.onSingleTapUp(motionEvent);
            }
            this.d.removeMessages(2);
            this.f16723a = false;
            this.h = false;
            return;
        }
        if (i2 != 2) {
            if (i2 == 3 || i2 == 5) {
                this.d.removeMessages(2);
                this.f16723a = false;
                this.h = false;
                return;
            }
            return;
        }
        if (!this.h && this.f16723a) {
            int i3 = (int) (f - this.c);
            int i4 = (int) (f2 - this.b);
            if ((i3 * i3) + (i4 * i4) > this.f) {
                this.f16723a = false;
                this.d.removeMessages(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.h = true;
        this.i.onLongPress(this.e);
    }
}
