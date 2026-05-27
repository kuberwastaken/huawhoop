package com.huawei.healthcloud.plugintrack.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import defpackage.ivi;
import defpackage.mgx;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ExplodeAnimationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PointF f3956a;
    private Size b;
    private ArrayList<ivi> c = new ArrayList<>();
    private final ExplodeAnimationCallback d;
    private ViewGroup e;
    private List<List<Bitmap>> g;
    private boolean h;

    public interface ExplodeAnimationCallback {
        void onAnimationComplete();
    }

    public ExplodeAnimationHelper(List<List<Bitmap>> list, ViewGroup viewGroup, PointF pointF, ExplodeAnimationCallback explodeAnimationCallback) {
        this.d = explodeAnimationCallback;
        this.g = list;
        this.e = viewGroup;
        this.f3956a = pointF;
    }

    public void bqv_(Size size) {
        this.b = size;
    }

    public void c() {
        ViewGroup viewGroup;
        Bitmap bitmap;
        if (mgx.d(this.g) || (viewGroup = this.e) == null || this.f3956a == null) {
            return;
        }
        viewGroup.removeAllViews();
        this.c.clear();
        for (List<Bitmap> list : this.g) {
            if (!mgx.d(list) && (bitmap = list.get(new SecureRandom().nextInt(list.size()))) != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Size size = this.b;
                if (size != null) {
                    width = Math.min(width, size.getWidth());
                    height = Math.min(height, this.b.getHeight());
                }
                bqu_(this.e, bitmap, width, height, this.f3956a);
            }
        }
    }

    private ImageView bqt_(Context context) {
        return new ImageView(context);
    }

    private void bqu_(ViewGroup viewGroup, Bitmap bitmap, int i, int i2, PointF pointF) {
        for (int i3 = 0; i3 < 31; i3++) {
            ImageView imageViewBqt_ = bqt_(viewGroup.getContext());
            imageViewBqt_.setImageBitmap(bitmap);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            float f = i / 2.0f;
            layoutParams.leftMargin = Math.round(pointF.x - f);
            float f2 = i2 / 2.0f;
            layoutParams.topMargin = Math.round(pointF.y - f2);
            layoutParams.addRule(9, -1);
            layoutParams.addRule(10, -1);
            viewGroup.addView(imageViewBqt_, layoutParams);
            this.c.add(new ivi(imageViewBqt_, new PointF(pointF.x - f, pointF.y - f2)));
        }
    }

    public void bqw_(View view) {
        this.h = true;
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).a();
        }
        view.postDelayed(new Runnable() { // from class: ivf
            @Override // java.lang.Runnable
            public final void run() {
                this.c.b();
            }
        }, 3200L);
    }

    public /* synthetic */ void b() {
        this.h = false;
        ExplodeAnimationCallback explodeAnimationCallback = this.d;
        if (explodeAnimationCallback != null) {
            explodeAnimationCallback.onAnimationComplete();
        }
    }
}
