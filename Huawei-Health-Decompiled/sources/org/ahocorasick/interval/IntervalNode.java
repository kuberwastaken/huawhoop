package org.ahocorasick.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class IntervalNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IntervalNode f16468a;
    private int b;
    private List<Intervalable> c = new ArrayList();
    private IntervalNode d;

    enum Direction {
        LEFT,
        RIGHT
    }

    public IntervalNode(List<Intervalable> list) {
        this.f16468a = null;
        this.d = null;
        this.b = c(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Intervalable intervalable : list) {
            if (intervalable.getEnd() < this.b) {
                arrayList.add(intervalable);
            } else if (intervalable.getStart() > this.b) {
                arrayList2.add(intervalable);
            } else {
                this.c.add(intervalable);
            }
        }
        if (arrayList.size() > 0) {
            this.f16468a = new IntervalNode(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.d = new IntervalNode(arrayList2);
        }
    }

    public int c(List<Intervalable> list) {
        int i = -1;
        int i2 = -1;
        for (Intervalable intervalable : list) {
            int start = intervalable.getStart();
            int end = intervalable.getEnd();
            if (i == -1 || start < i) {
                i = start;
            }
            if (i2 == -1 || end > i2) {
                i2 = end;
            }
        }
        return (i + i2) / 2;
    }

    public List<Intervalable> b(Intervalable intervalable) {
        ArrayList arrayList = new ArrayList();
        if (this.b < intervalable.getStart()) {
            b(intervalable, arrayList, d(this.d, intervalable));
            b(intervalable, arrayList, e(intervalable));
        } else if (this.b > intervalable.getEnd()) {
            b(intervalable, arrayList, d(this.f16468a, intervalable));
            b(intervalable, arrayList, c(intervalable));
        } else {
            b(intervalable, arrayList, this.c);
            b(intervalable, arrayList, d(this.f16468a, intervalable));
            b(intervalable, arrayList, d(this.d, intervalable));
        }
        return arrayList;
    }

    protected void b(Intervalable intervalable, List<Intervalable> list, List<Intervalable> list2) {
        for (Intervalable intervalable2 : list2) {
            if (!intervalable2.equals(intervalable)) {
                list.add(intervalable2);
            }
        }
    }

    protected List<Intervalable> c(Intervalable intervalable) {
        return b(intervalable, Direction.LEFT);
    }

    protected List<Intervalable> e(Intervalable intervalable) {
        return b(intervalable, Direction.RIGHT);
    }

    protected List<Intervalable> b(Intervalable intervalable, Direction direction) {
        ArrayList arrayList = new ArrayList();
        for (Intervalable intervalable2 : this.c) {
            int i = AnonymousClass3.f16469a[direction.ordinal()];
            if (i == 1) {
                if (intervalable2.getStart() <= intervalable.getEnd()) {
                    arrayList.add(intervalable2);
                }
            } else if (i == 2 && intervalable2.getEnd() >= intervalable.getStart()) {
                arrayList.add(intervalable2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: org.ahocorasick.interval.IntervalNode$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16469a;

        static {
            int[] iArr = new int[Direction.values().length];
            f16469a = iArr;
            try {
                iArr[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16469a[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected List<Intervalable> d(IntervalNode intervalNode, Intervalable intervalable) {
        if (intervalNode != null) {
            return intervalNode.b(intervalable);
        }
        return Collections.emptyList();
    }
}
