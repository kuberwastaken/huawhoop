package defpackage;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.huawei.watchface.mvp.model.latona.provider.WatchFaceProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f12982a;
    private ct b;
    private final fw<String> h = new fw<>();
    private final Map<fw<String>, Typeface> e = new HashMap();
    private final Map<String, Typeface> d = new HashMap();
    private String c = WatchFaceProvider.SVG_TTF;

    public fj(Drawable.Callback callback, ct ctVar) {
        this.b = ctVar;
        if (!(callback instanceof View)) {
            iy.c("LottieDrawable must be inside of a view for images to work.");
            this.f12982a = null;
        } else {
            this.f12982a = ((View) callback).getContext().getAssets();
        }
    }

    public void e(ct ctVar) {
        this.b = ctVar;
    }

    public void b(String str) {
        this.c = str;
    }

    public Typeface aa_(fo foVar) {
        this.h.b(foVar.a(), foVar.b());
        Typeface typeface = this.e.get(this.h);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceZ_ = Z_(Y_(foVar), foVar.b());
        this.e.put(this.h, typefaceZ_);
        return typefaceZ_;
    }

    private Typeface Y_(fo foVar) {
        Typeface typefaceCreateFromAsset;
        String strA = foVar.a();
        Typeface typeface = this.d.get(strA);
        if (typeface != null) {
            return typeface;
        }
        String strB = foVar.b();
        String strC = foVar.c();
        ct ctVar = this.b;
        if (ctVar != null) {
            typefaceCreateFromAsset = ctVar.q_(strA, strB, strC);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.b.p_(strA);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        ct ctVar2 = this.b;
        if (ctVar2 != null && typefaceCreateFromAsset == null) {
            String strD = ctVar2.d(strA, strB, strC);
            if (strD == null) {
                strD = this.b.a(strA);
            }
            if (strD != null) {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.f12982a, strD);
            }
        }
        if (foVar.ah_() != null) {
            return foVar.ah_();
        }
        if (typefaceCreateFromAsset == null) {
            typefaceCreateFromAsset = Typeface.createFromAsset(this.f12982a, "fonts/" + strA + this.c);
        }
        this.d.put(strA, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface Z_(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
