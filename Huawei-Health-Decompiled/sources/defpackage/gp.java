package defpackage;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class gp implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f13573a;
    private final List<ContentModel> b;
    private final String c;

    public gp(String str, List<ContentModel> list, boolean z) {
        this.c = str;
        this.b = list;
        this.f13573a = z;
    }

    public String b() {
        return this.c;
    }

    public List<ContentModel> c() {
        return this.b;
    }

    public boolean e() {
        return this.f13573a;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, cx cxVar, BaseLayer baseLayer) {
        return new em(lottieDrawable, baseLayer, this, cxVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.c + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
