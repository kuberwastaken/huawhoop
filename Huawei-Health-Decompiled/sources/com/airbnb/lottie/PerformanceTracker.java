package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import defpackage.jd;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class PerformanceTracker {
    private boolean d = false;
    private final Set<FrameListener> c = new ArraySet();
    private final Map<String, jd> b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f720a = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.PerformanceTracker.3
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.second.floatValue();
            float fFloatValue2 = pair2.second.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public interface FrameListener {
        void onFrameRendered(float f);
    }

    public void c(boolean z) {
        this.d = z;
    }

    public void c(String str, float f) {
        if (this.d) {
            jd jdVar = this.b.get(str);
            if (jdVar == null) {
                jdVar = new jd();
                this.b.put(str, jdVar);
            }
            jdVar.c(f);
            if (str.equals("__container")) {
                Iterator<FrameListener> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().onFrameRendered(f);
                }
            }
        }
    }
}
