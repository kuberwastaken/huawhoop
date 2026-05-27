package defpackage;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes11.dex */
public class ndt extends LinkMovementMethod {
    private int b;
    private int e;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            ClickableSpan[] clickableSpanArrCgD_ = cgD_(textView, spannable, motionEvent);
            if (clickableSpanArrCgD_.length != 0) {
                clickableSpanArrCgD_[0].onClick(textView);
                if (this.e != 0) {
                    spannable.setSpan(new ForegroundColorSpan(this.e), spannable.getSpanStart(clickableSpanArrCgD_[0]), spannable.getSpanEnd(clickableSpanArrCgD_[0]), 33);
                }
                return true;
            }
        } else {
            if (action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            ClickableSpan[] clickableSpanArrCgD_2 = cgD_(textView, spannable, motionEvent);
            if (clickableSpanArrCgD_2.length != 0) {
                if (this.b != 0) {
                    spannable.setSpan(new ForegroundColorSpan(this.b), spannable.getSpanStart(clickableSpanArrCgD_2[0]), spannable.getSpanEnd(clickableSpanArrCgD_2[0]), 33);
                }
                return true;
            }
        }
        Selection.removeSelection(spannable);
        Touch.onTouchEvent(textView, spannable, motionEvent);
        return false;
    }

    private ClickableSpan[] cgD_(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = textView.getTotalPaddingLeft();
        int totalPaddingTop = textView.getTotalPaddingTop();
        int scrollX = textView.getScrollX();
        int scrollY = textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - totalPaddingTop) + scrollY), (x - totalPaddingLeft) + scrollX);
        return (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
    }

    public ndt(int i, int i2) {
        this.e = i;
        this.b = i2;
    }
}
