package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.health.R;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public class f extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation f8341a;
    private Animation b;
    private Animation c;
    private Animation d;
    private ImageView e;
    private ImageView f;

    public void a() {
        a(this.b);
        a(this.f8341a);
        a(this.d);
        a(this.c);
        setVisibility(8);
    }

    private void b(Context context) {
        this.f8341a = AnimationUtils.loadAnimation(context, R.anim._2130772027_res_0x7f01003b);
        this.b = AnimationUtils.loadAnimation(context, R.anim._2130772028_res_0x7f01003c);
        this.f8341a.setDuration(400L);
        this.b.setDuration(400L);
        this.f8341a.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (f.this.e != null) {
                    f.this.e.startAnimation(f.this.b);
                }
            }
        });
        this.b.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (f.this.f != null) {
                    f.this.f.startAnimation(f.this.c);
                }
            }
        });
        this.c = AnimationUtils.loadAnimation(context, R.anim._2130772022_res_0x7f010036);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R.anim._2130772023_res_0x7f010037);
        this.d = animationLoadAnimation;
        animationLoadAnimation.setDuration(400L);
        this.c.setDuration(400L);
        this.c.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (f.this.f != null) {
                    f.this.f.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (f.this.f != null) {
                    f.this.f.startAnimation(f.this.d);
                }
                if (f.this.e != null) {
                    f.this.e.startAnimation(f.this.f8341a);
                }
            }
        });
        this.d.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (f.this.f != null) {
                    f.this.f.setVisibility(4);
                }
            }
        });
    }

    private void a(Animation animation) {
        if (animation != null) {
            animation.cancel();
        }
    }

    private void a(Context context) {
        hq.b("MaskingView", "init");
        inflate(context, R.layout.pps_masking_view, this);
        this.e = (ImageView) findViewById(R.id.hiad_click_hand);
        this.f = (ImageView) findViewById(R.id.hiad_click_arc);
        b(context);
        this.e.startAnimation(this.b);
    }

    public f(Context context) {
        super(context);
        a(context);
    }
}
