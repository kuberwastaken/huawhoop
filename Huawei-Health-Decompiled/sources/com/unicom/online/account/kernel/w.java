package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes8.dex */
public final class w extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11959a;
    private final String b;

    public w(q qVar, Exception exc) {
        super(qVar.A);
        this.f11959a = Integer.parseInt(qVar.z);
        this.b = qVar.A + " case by : " + exc.getMessage();
    }

    public w(q qVar) {
        super(qVar.A);
        this.f11959a = Integer.parseInt(qVar.z);
        this.b = qVar.A;
    }
}
