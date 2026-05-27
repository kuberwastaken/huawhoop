package defpackage;

import com.huawei.animation.physical2.ParamTransfer;

/* JADX INFO: loaded from: classes10.dex */
public class avv implements ParamTransfer<Float> {
    private float c;

    public avv() {
        this(0.0f);
    }

    public avv(float f) {
        this.c = f;
    }

    @Override // com.huawei.animation.physical2.ParamTransfer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float transfer(Float f, int i) {
        return Float.valueOf((float) (Math.pow(i + 1, (-this.c) * 0.18f) * ((double) f.floatValue())));
    }
}
