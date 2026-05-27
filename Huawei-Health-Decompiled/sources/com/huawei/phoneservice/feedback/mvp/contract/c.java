package com.huawei.phoneservice.feedback.mvp.contract;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.feedback.mvp.base.g;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface c extends g {
    void a(FeedBackResponse.ProblemEnity problemEnity);

    void a(List<FeedBackResponse.ProblemEnity> list);

    void a(boolean z, com.huawei.phoneservice.feedback.entity.c cVar);

    void c(com.huawei.phoneservice.feedback.entity.c cVar);

    void d();

    void setErrorView(FaqConstants.FaqErrorCode faqErrorCode);

    void setThrowableView(Throwable th);
}
