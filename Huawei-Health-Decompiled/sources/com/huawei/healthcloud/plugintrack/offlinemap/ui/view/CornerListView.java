package com.huawei.healthcloud.plugintrack.offlinemap.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.huawei.health.R;

/* JADX INFO: loaded from: classes10.dex */
public class CornerListView extends ListView {
    public CornerListView(Context context) {
        super(context);
    }

    public CornerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CornerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iPointToPosition;
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() == 0 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1) {
            if (iPointToPosition == 0) {
                if (iPointToPosition == getAdapter().getCount() - 1) {
                    setSelector(R.drawable._2131432455_res_0x7f0b1407);
                } else {
                    setSelector(R.drawable._2131432452_res_0x7f0b1404);
                }
            } else if (iPointToPosition == getAdapter().getCount() - 1) {
                setSelector(R.drawable._2131432453_res_0x7f0b1405);
            } else {
                setSelector(R.drawable._2131432454_res_0x7f0b1406);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
