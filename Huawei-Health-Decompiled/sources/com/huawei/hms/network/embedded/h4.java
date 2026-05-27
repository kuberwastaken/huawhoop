package com.huawei.hms.network.embedded;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes10.dex */
public class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f5474a;
    public final Condition b;
    public final Condition c;
    public final Object[] d;
    public int e;
    public int f;
    public int g;

    public Object take() throws InterruptedException {
        int i;
        this.f5474a.lock();
        while (true) {
            try {
                i = this.g;
                if (i != 0) {
                    break;
                }
                this.c.await();
            } finally {
                this.f5474a.unlock();
            }
        }
        Object[] objArr = this.d;
        int i2 = this.f;
        Object obj = objArr[i2];
        int i3 = i2 + 1;
        this.f = i3;
        if (i3 == objArr.length) {
            this.f = 0;
        }
        this.g = i - 1;
        this.b.signal();
        return obj;
    }

    public void put(Object obj) throws InterruptedException {
        int i;
        Object[] objArr;
        this.f5474a.lock();
        while (true) {
            try {
                i = this.g;
                objArr = this.d;
                if (i != objArr.length) {
                    break;
                } else {
                    this.b.await();
                }
            } finally {
                this.f5474a.unlock();
            }
        }
        int i2 = this.e;
        objArr[i2] = obj;
        int i3 = i2 + 1;
        this.e = i3;
        if (i3 == objArr.length) {
            this.e = 0;
        }
        this.g = i + 1;
        this.c.signal();
    }

    public h4() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f5474a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.c = reentrantLock.newCondition();
        this.d = new Object[1];
    }
}
