package com.huawei.phoneservice.feedbackcommon.utils;

import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface SdkFeedBackCallback {
    void setListView(List<FeedBackResponse.ProblemEnity> list);

    void setThrowableView(Throwable th);
}
