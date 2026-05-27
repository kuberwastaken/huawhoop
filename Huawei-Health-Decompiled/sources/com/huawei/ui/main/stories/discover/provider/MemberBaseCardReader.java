package com.huawei.ui.main.stories.discover.provider;

import com.huawei.health.marketing.datatype.RecommendResourceInfo;
import defpackage.uge;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface MemberBaseCardReader {
    void initCardReader(List<RecommendResourceInfo> list);

    void queryLabel();

    void registerCardListener(MemberCardListener memberCardListener);

    void setDataChangeTrue();

    void setOrder(int i);

    void setPrivacyStatus(boolean z, boolean z2, uge ugeVar);

    void unRegisterListener();
}
