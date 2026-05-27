package defpackage;

import com.airbnb.lottie.animation.keyframe.KeyframeAnimation;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class fc extends KeyframeAnimation<gi> {
    private final gi b;

    public fc(List<jf<gi>> list) {
        super(list);
        int iMax = 0;
        for (int i = 0; i < list.size(); i++) {
            gi giVar = list.get(i).h;
            if (giVar != null) {
                iMax = Math.max(iMax, giVar.d());
            }
        }
        this.b = new gi(new float[iMax], new int[iMax]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public gi getValue(jf<gi> jfVar, float f) {
        this.b.d(jfVar.h, jfVar.f14389a, f);
        return this.b;
    }
}
