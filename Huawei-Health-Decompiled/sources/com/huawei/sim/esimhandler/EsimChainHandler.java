package com.huawei.sim.esimhandler;

/* JADX INFO: loaded from: classes7.dex */
public interface EsimChainHandler extends EsimHandler {
    EsimChainHandler getNext();

    EsimChainHandler getTailHandler();

    void setNext(EsimChainHandler esimChainHandler);
}
