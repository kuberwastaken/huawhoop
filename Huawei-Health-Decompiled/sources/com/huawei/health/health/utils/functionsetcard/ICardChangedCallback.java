package com.huawei.health.health.utils.functionsetcard;

import android.view.View;
import com.huawei.health.health.utils.functionsetcard.reader.FunctionSetSubCardData;

/* JADX INFO: loaded from: classes4.dex */
public interface ICardChangedCallback {
    View loadMarketingView(String str, int i);

    void notifyCardChanged(FunctionSetSubCardData functionSetSubCardData);

    void notifyCardDelete(FunctionSetSubCardData functionSetSubCardData);

    void notifyCardScrolled(FunctionSetSubCardData functionSetSubCardData);
}
