package com.huawei.health.ui.notification.manager;

/* JADX INFO: loaded from: classes.dex */
public interface IUiNotificationManager {
    void changeGoalNotificationStateAsSync(boolean z);

    void changeGoalNotificationStateAsUser(boolean z);

    void changeStepsNotificationStateAsSync(boolean z);

    void changeStepsNotificationStateAsUser(boolean z);

    boolean isGetGoalNotificationState();

    boolean isGetNotificationSupport();

    boolean isGetStepsNotificationState();

    void resetGoalNotification();

    void resetStepsNotification();

    void stepsNotificationRemoveAndRebind();
}
