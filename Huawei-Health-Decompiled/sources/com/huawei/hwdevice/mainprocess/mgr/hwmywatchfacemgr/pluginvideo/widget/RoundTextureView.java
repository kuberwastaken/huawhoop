package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.widget;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes6.dex */
public class RoundTextureView extends TextureView {
    public static final float CIRCLE_SCREEN_RATIO = 0.24074075f;
    private static final int DEFAULT_SCREEN = 466;
    private static final String TAG = "RoundTextureView";
    private int screenHeight;
    private int screenWidth;
    private View textureViewRectangle;

    public RoundTextureView(Context context) {
        this(context, null);
    }

    public RoundTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.screenWidth = 466;
        this.screenHeight = 466;
        init();
    }

    /* JADX INFO: loaded from: classes11.dex */
    static class RoundViewOutlineProvider extends ViewOutlineProvider {
        private RoundViewOutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            RoundTextureView roundTextureView = (RoundTextureView) view;
            int screenWidth = roundTextureView.getScreenWidth();
            int screenHeight = roundTextureView.getScreenHeight();
            Rect rect = new Rect(0, 0, measuredWidth, measuredHeight);
            float f = measuredWidth / 2;
            if (screenWidth != screenHeight) {
                f = 0.24074075f * measuredWidth;
                View textureViewRectangle = roundTextureView.getTextureViewRectangle();
                if (textureViewRectangle != null && (textureViewRectangle.getBackground() instanceof GradientDrawable)) {
                    ((GradientDrawable) textureViewRectangle.getBackground()).setCornerRadius(f);
                    textureViewRectangle.setVisibility(0);
                }
            }
            outline.setRoundRect(rect, f);
        }
    }

    private void init() {
        setOutlineProvider(new RoundViewOutlineProvider());
        setClipToOutline(true);
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public void setScreenWidth(int i) {
        this.screenWidth = i;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public void setScreenHeight(int i) {
        this.screenHeight = i;
    }

    public void setScreenWidthAndHeight(int i, int i2) {
        this.screenWidth = i;
        this.screenHeight = i2;
    }

    public View getTextureViewRectangle() {
        return this.textureViewRectangle;
    }

    public void setTextureViewRectangle(View view) {
        this.textureViewRectangle = view;
    }
}
