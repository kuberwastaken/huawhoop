package com.huawei.ui.commonui.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;
import com.huawei.ui.commonui.utils.StatusBarClickedListener;

/* JADX INFO: loaded from: classes11.dex */
public class StatusBarListenListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StatusBarListenListView f9266a;
    private boolean b;
    private StatusBarClickedListener c;

    public StatusBarListenListView(Context context) {
        super(context);
        this.b = true;
        this.f9266a = this;
    }

    public StatusBarListenListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        this.f9266a = this;
    }

    public StatusBarListenListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        this.f9266a = this;
    }

    public void b() {
        if (this.b) {
            smoothScrollToPosition(0);
            new Handler().postDelayed(new Runnable() { // from class: com.huawei.ui.commonui.listview.StatusBarListenListView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (StatusBarListenListView.this.getFirstVisiblePosition() > 0) {
                        StatusBarListenListView.this.setSelectionAfterHeaderView();
                    }
                }
            }, 100L);
        }
    }

    public void setScrollTopEnable(boolean z) {
        this.b = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        super.dispatchWindowFocusChanged(z);
        setScrollTopEnable(z);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("StatusBarListenListView", "onAttachedToWindow");
        if (this.c == null) {
            this.c = new StatusBarClickedListener() { // from class: com.huawei.ui.commonui.listview.StatusBarListenListView.3
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (StatusBarListenListView.this.f9266a != null) {
                        StatusBarListenListView.this.f9266a.b();
                    }
                }
            };
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("StatusBarListenListView", "onDetachedFromWindow");
        StatusBarClickedListener statusBarClickedListener = this.c;
        if (statusBarClickedListener != null) {
            statusBarClickedListener.unregister();
            this.c = null;
        }
    }
}
