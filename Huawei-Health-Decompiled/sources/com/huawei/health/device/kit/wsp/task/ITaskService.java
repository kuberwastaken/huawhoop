package com.huawei.health.device.kit.wsp.task;

import defpackage.dgj;

/* JADX INFO: loaded from: classes4.dex */
public interface ITaskService {
    void disable(dgj dgjVar, IAsynBleTaskCallback iAsynBleTaskCallback);

    void enable(dgj dgjVar, IAsynBleTaskCallback iAsynBleTaskCallback);

    void write(dgj dgjVar, IAsynBleTaskCallback iAsynBleTaskCallback);
}
