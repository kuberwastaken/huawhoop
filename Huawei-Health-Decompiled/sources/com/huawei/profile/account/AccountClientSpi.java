package com.huawei.profile.account;

import com.huawei.profile.coordinator.exception.ProfileRequestException;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface AccountClientSpi {
    Map<String, String> generateRequestHeader() throws ProfileRequestException;

    boolean isExpiredAccount();

    void registerAccountReceiver();

    void setAccount(Account account);

    void setAccountInvalid();

    void updateExpiredAccount();
}
