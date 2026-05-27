package com.huawei.health.playercontroller.api;

import defpackage.fye;

/* JADX INFO: loaded from: classes4.dex */
public interface PlayerEventApi {
    void onPlayStatusChangeFromNotification(fye fyeVar, int i);

    void onPlayerFinishedMediaEvent(fye fyeVar, long j, int i, long j2);

    void onPlayerPauseEvent(fye fyeVar, long j, int i, long j2);

    void onPlayerProgressChange(fye fyeVar, long j, int i);

    void onPlayerStartPlayEvent(fye fyeVar, long j, int i, long j2);

    void onPlayerStopEvent(fye fyeVar, long j, int i, long j2, boolean z);
}
