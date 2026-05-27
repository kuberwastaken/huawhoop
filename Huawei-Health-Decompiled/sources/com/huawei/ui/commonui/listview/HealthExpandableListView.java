package com.huawei.ui.commonui.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ExpandableListView;
import com.huawei.ui.commonui.utils.StatusBarClickedListener;

/* JADX INFO: loaded from: classes7.dex */
public class HealthExpandableListView extends ExpandableListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StatusBarClickedListener f9265a;
    private final HealthExpandableListView c;
    private boolean d;

    public HealthExpandableListView(Context context) {
        super(context);
        this.d = true;
        this.c = this;
    }

    public HealthExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = true;
        this.c = this;
    }

    public HealthExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.c = this;
    }

    public void d() {
        if (this.d) {
            smoothScrollToPositionFromTop(0, 0);
            new Handler().postDelayed(new Runnable() { // from class: com.huawei.ui.commonui.listview.HealthExpandableListView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HealthExpandableListView.this.getFirstVisiblePosition() > 0) {
                        HealthExpandableListView.this.setSelectionAfterHeaderView();
                    }
                }
            }, 100L);
        }
    }

    public void setScrollTopEnable(boolean z) {
        this.d = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        super.dispatchWindowFocusChanged(z);
        setScrollTopEnable(z);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("HealthExpandableListView", "onAttachedToWindow");
        if (this.f9265a == null) {
            this.f9265a = new StatusBarClickedListener() { // from class: com.huawei.ui.commonui.listview.HealthExpandableListView.4
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (HealthExpandableListView.this.c != null) {
                        HealthExpandableListView.this.c.d();
                    }
                }
            };
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("HealthExpandableListView", "onDetachedFromWindow");
        StatusBarClickedListener statusBarClickedListener = this.f9265a;
        if (statusBarClickedListener != null) {
            statusBarClickedListener.unregister();
            this.f9265a = null;
        }
    }
}
