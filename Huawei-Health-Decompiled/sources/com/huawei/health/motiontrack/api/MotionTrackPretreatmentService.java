package com.huawei.health.motiontrack.api;

import com.huawei.haf.router.facade.service.PretreatmentService;

/* JADX INFO: loaded from: classes.dex */
public interface MotionTrackPretreatmentService extends PretreatmentService {
    int getSportType(int i);

    int getTargetType(String str);
}
