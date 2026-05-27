package com.huawei.animation.physical2;

import android.os.SystemClock;
import android.util.Log;
import com.huawei.animation.physical2.SpringNode;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SimpleSpringNode extends SpringNode {
    private static final String TAG = "SimpleSpringNode";
    protected int maximumDistanceDelta;
    protected int minimumDistanceDelta;
    protected Spring spring;
    protected float value;
    protected float valueAccuracy;
    protected float velocity;

    @Override // com.huawei.animation.physical2.SpringNode
    protected void doDistanceToNeighbor() {
    }

    public SimpleSpringNode(int i, float f) {
        super(i);
        this.velocity = 0.0f;
        this.valueAccuracy = 1.0f;
        this.minimumDistanceDelta = -1;
        this.maximumDistanceDelta = -1;
        this.value = f;
        this.spring = new Spring();
    }

    public SimpleSpringNode(int i) {
        this(i, 0.0f);
    }

    @Override // com.huawei.animation.physical2.SpringNode
    void setValue(float f) {
        super.setValue(f);
        this.value = f;
        onUpdateInternal();
        notifyNext(f, this.velocity);
    }

    @Override // com.huawei.animation.physical2.SpringNode
    void endToValue(float f, float f2) {
        super.endToValue(f, f2);
        if (this.isRunning) {
            if (this.adapter.getControlNode().isAnimToEnd()) {
                this.startTime = SystemClock.uptimeMillis() - 16;
            } else {
                this.startTime = SystemClock.uptimeMillis() - ((long) ((int) (getFrameDelta() * 16.0f)));
            }
            this.spring.e(this.value).c(f).a(this.velocity).h(this.valueAccuracy).c();
            onRunning();
        } else {
            this.startTime = SystemClock.uptimeMillis();
            this.isRunning = true;
            this.spring.e(this.value).c(f).a(f2).h(this.valueAccuracy).c();
            isDoFrame();
        }
        notifyNext(f, f2);
    }

    @Override // com.huawei.animation.physical2.SpringNode
    public void cancel() {
        this.isRunning = false;
        this.velocity = 0.0f;
        onEnd(this.value);
    }

    @Override // com.huawei.animation.physical2.SpringNode
    void transferParams(float f, float f2) {
        this.spring.d(f).b(f2);
    }

    protected void notifyNext(float f, float f2) {
        if (this != this.adapter.getControlNode()) {
            return;
        }
        SpringNode next = this.adapter.getNext(this);
        while (next != null) {
            next.endToValue(f, f2);
            next = this.adapter.getNext(next);
        }
    }

    @Override // com.huawei.animation.physical2.SpringNode
    public boolean isDoFrame() {
        if (!this.isRunning) {
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.value = this.spring.c(jUptimeMillis);
        float fA = this.spring.a(jUptimeMillis);
        this.velocity = fA;
        if (this.spring.c(this.value, fA)) {
            this.isRunning = false;
            this.value = this.spring.b();
            this.velocity = 0.0f;
            onUpdateInternal();
            onEnd(this.value);
            Log.w(TAG, "isDoFrame: index:" + getIndex() + " is at equilibrium value:" + this.value);
        } else {
            onUpdateInternal();
            this.isRunning = true;
        }
        return !this.isRunning;
    }

    protected void onUpdateInternal() {
        onUpdate(this.value, this.velocity);
        for (SpringNode.Listener listener : this.listenerList) {
            if (listener != null) {
                listener.onAnimationUpdate(this.value, this.velocity);
            }
        }
    }

    public SimpleSpringNode setValueAccuracy(float f) {
        this.valueAccuracy = f;
        return this;
    }

    public float getValue() {
        return this.value;
    }

    public float getVelocity() {
        return this.velocity;
    }

    @Override // com.huawei.animation.physical2.SpringNode
    public void resetValue(float f) {
        this.value = f;
        onUpdateInternal();
    }

    public void resetNode(float f, float f2) {
        this.value = f;
        this.velocity = f2;
        onUpdateInternal();
    }

    @Override // com.huawei.animation.physical2.SpringNode
    protected void setDistanceDelta(int i, int i2) {
        if (i < 0 || i2 < 0 || i2 < i) {
            return;
        }
        this.minimumDistanceDelta = i;
        this.maximumDistanceDelta = i2;
    }
}
