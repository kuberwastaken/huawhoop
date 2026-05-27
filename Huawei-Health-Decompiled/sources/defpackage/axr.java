package defpackage;

import android.graphics.Bitmap;
import com.huawei.animationkit.computationalwallpaper.graphicanalysis.AiAnalysisStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class axr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AiAnalysisStrategy f369a;

    public axr(AiAnalysisStrategy aiAnalysisStrategy) {
        this.f369a = aiAnalysisStrategy;
    }

    public axt hf_(Bitmap bitmap) throws awb {
        return this.f369a.analyze(bitmap);
    }
}
