package com.huawei.pluginachievement.ui.listview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import com.huawei.ui.commonui.listview.StatusBarListenListView;

/* JADX INFO: loaded from: classes11.dex */
public class AchieveReboundListView extends StatusBarListenListView implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8746a;
    private boolean b;
    private boolean c;
    private boolean d;
    private float e;
    private int f;
    private int g;
    private Handler h;
    private float i;
    private int j;
    private boolean k;
    private int m;
    private int n;

    public AchieveReboundListView(Context context) {
        super(context);
        this.k = true;
        this.c = true;
        this.h = new Handler();
        d();
    }

    public AchieveReboundListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = true;
        this.c = true;
        this.h = new Handler();
        d();
    }

    public AchieveReboundListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = true;
        this.c = true;
        this.h = new Handler();
        d();
    }

    public void setTopNotChange() {
        this.k = false;
    }

    private void d() {
        this.g = getPaddingLeft();
        this.m = getPaddingRight();
        this.n = getPaddingTop();
        this.j = getPaddingBottom();
        setOnScrollListener(this);
        setOverScrollMode(2);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.h.removeCallbacksAndMessages(null);
                float y = motionEvent.getY();
                this.i = y;
                int i = (int) ((y - this.e) / 2.5f);
                boolean z = i > 0;
                this.d = z;
                if (z) {
                    if (this.k && this.b && this.f != 2) {
                        setPadding(this.g, i + this.n, this.m, this.j);
                        setSelection(0);
                    }
                } else if (this.c && this.f8746a && this.f != 2) {
                    setPadding(this.g, this.n, this.m, -(i - this.j));
                    setSelection(getCount() - 1);
                }
            }
        } else if (this.d) {
            a();
        } else {
            e();
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a() {
        if (this.k) {
            final int paddingTop = getPaddingTop();
            int i = 0;
            while (paddingTop > this.n) {
                paddingTop -= 20;
                i += 10;
                this.h.postDelayed(new Runnable() { // from class: com.huawei.pluginachievement.ui.listview.AchieveReboundListView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (paddingTop < AchieveReboundListView.this.n) {
                            AchieveReboundListView achieveReboundListView = AchieveReboundListView.this;
                            achieveReboundListView.setPadding(achieveReboundListView.g, AchieveReboundListView.this.n, AchieveReboundListView.this.m, AchieveReboundListView.this.j);
                        } else {
                            AchieveReboundListView achieveReboundListView2 = AchieveReboundListView.this;
                            achieveReboundListView2.setPadding(achieveReboundListView2.g, paddingTop, AchieveReboundListView.this.m, AchieveReboundListView.this.j);
                        }
                    }
                }, i);
            }
        }
    }

    private void e() {
        if (this.c) {
            final int paddingBottom = getPaddingBottom();
            int i = 0;
            while (paddingBottom > this.j) {
                paddingBottom -= 20;
                i += 10;
                this.h.postDelayed(new Runnable() { // from class: com.huawei.pluginachievement.ui.listview.AchieveReboundListView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (paddingBottom < AchieveReboundListView.this.j) {
                            AchieveReboundListView achieveReboundListView = AchieveReboundListView.this;
                            achieveReboundListView.setPadding(achieveReboundListView.g, AchieveReboundListView.this.n, AchieveReboundListView.this.m, AchieveReboundListView.this.j);
                        } else {
                            AchieveReboundListView achieveReboundListView2 = AchieveReboundListView.this;
                            achieveReboundListView2.setPadding(achieveReboundListView2.g, AchieveReboundListView.this.n, AchieveReboundListView.this.m, paddingBottom);
                        }
                    }
                }, i);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.b = i == 0;
        this.f8746a = i + i2 == i3;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f = i;
    }
}
