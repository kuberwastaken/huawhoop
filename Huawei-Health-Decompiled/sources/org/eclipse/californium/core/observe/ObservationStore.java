package org.eclipse.californium.core.observe;

import defpackage.ycn;
import defpackage.yel;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.elements.EndpointContext;

/* JADX INFO: loaded from: classes8.dex */
public interface ObservationStore {
    yel get(ycn ycnVar);

    yel put(ycn ycnVar, yel yelVar);

    yel putIfAbsent(ycn ycnVar, yel yelVar);

    void remove(ycn ycnVar);

    void setContext(ycn ycnVar, EndpointContext endpointContext);

    void setExecutor(ScheduledExecutorService scheduledExecutorService);

    void start();

    void stop();
}
