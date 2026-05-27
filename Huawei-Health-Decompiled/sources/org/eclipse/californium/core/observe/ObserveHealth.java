package org.eclipse.californium.core.observe;

/* JADX INFO: loaded from: classes8.dex */
public interface ObserveHealth {
    void receivingCancelRequest();

    void receivingObserveRequest();

    void receivingReject();

    void setObserveEndpoints(int i);

    void setObserveRelations(int i);
}
