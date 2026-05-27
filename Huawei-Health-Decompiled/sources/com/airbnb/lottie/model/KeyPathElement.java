package com.airbnb.lottie.model;

import defpackage.fs;
import defpackage.ji;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t, ji<T> jiVar);

    void resolveKeyPath(fs fsVar, int i, List<fs> list, fs fsVar2);
}
