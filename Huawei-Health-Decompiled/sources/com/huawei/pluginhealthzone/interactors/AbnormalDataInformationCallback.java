package com.huawei.pluginhealthzone.interactors;

import defpackage.obz;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface AbnormalDataInformationCallback {
    void onFailure(int i, String str);

    void onSuccess(List<obz> list);
}
