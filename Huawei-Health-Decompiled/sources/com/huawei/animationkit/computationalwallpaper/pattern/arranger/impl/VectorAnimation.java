package com.huawei.animationkit.computationalwallpaper.pattern.arranger.impl;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface VectorAnimation {
    int getDuration();

    default long getStartDelay() {
        return 0L;
    }

    default List<a> getTranslateXKeyFrames() {
        return Collections.emptyList();
    }

    default List<a> getTranslateYKeyFrames() {
        return Collections.emptyList();
    }

    default List<a> getScaleKeyFrames() {
        return Collections.emptyList();
    }

    default List<a> getRotateKeyFrame() {
        return Collections.emptyList();
    }

    default Interpolator getInterpolator() {
        return new PathInterpolator(0.3f, 0.0f, 0.3f, 1.0f);
    }

    public static class a {
        private final float c;
        private final float d;

        public a(float f, float f2) {
            this.c = f;
            this.d = f2;
        }

        public float b() {
            return this.c;
        }

        public float c() {
            return this.d;
        }
    }
}
