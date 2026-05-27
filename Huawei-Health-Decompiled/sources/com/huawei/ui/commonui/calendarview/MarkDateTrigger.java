package com.huawei.ui.commonui.calendarview;

import android.os.Parcelable;
import com.huawei.basefitnessadvice.callback.UiCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface MarkDateTrigger extends Parcelable {
    void retrieveMarkDate(long j, long j2, UiCallback<Map<String, HealthCalendar>> uiCallback);
}
