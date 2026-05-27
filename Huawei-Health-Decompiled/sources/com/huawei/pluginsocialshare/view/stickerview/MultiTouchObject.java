package com.huawei.pluginsocialshare.view.stickerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import com.huawei.haf.application.BaseApplication;
import defpackage.oli;
import defpackage.plt;
import health.compact.a.LanguageUtil;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class MultiTouchObject implements Serializable {
    protected static final int DEFAULT_BORDER_COLOR = -1;
    protected static final int DEFAULT_TWO_SIZE = 2;
    protected static final int DELETE_MAX_WIDTH = 24;
    protected static final int DELETE_MIN_WIDTH = 8;
    protected static final int DRAWABLE_PADDING = 16;
    protected static final int GRAB_AREA_SIZE = 40;
    private static final String TAG = "Share_MultiTouchObject";
    private static final int UI_MODE_ANISOTROPIC_SCALE = 2;
    private static final int UI_MODE_ROTATE = 1;
    protected boolean isRTLLanguage;
    protected float mAngle;
    protected float mCenterX;
    protected float mCenterY;
    protected int mDisplayHeight;
    protected int mDisplayWidth;
    protected boolean mFlippedHorizontally;
    protected float mGrabAreaX1;
    protected float mGrabAreaX2;
    protected float mGrabAreaY1;
    protected float mGrabAreaY2;
    protected int mHeight;
    protected float mMaxX;
    protected float mMaxY;
    protected float mMinX;
    protected float mMinY;
    protected float mScaleX;
    protected float mScaleY;
    protected float mStartMidX;
    protected float mStartMidY;
    protected int mWidth;
    protected boolean mIsFirstLoad = true;
    protected final transient Paint mBorderPaint = new Paint();
    protected int mBorderColor = -1;
    protected boolean isGrabAreaSelected = false;
    protected boolean isLatestSelected = false;
    protected final int mUIMode = 1;

    public abstract void draw(Canvas canvas);

    public abstract void init(Context context, float f, float f2);

    public abstract void unload();

    public MultiTouchObject(Resources resources) {
        init(resources);
    }

    protected void init(Resources resources) {
        int iMax;
        int iMin;
        if (resources == null) {
            return;
        }
        this.mFlippedHorizontally = false;
        this.isRTLLanguage = LanguageUtil.ay(BaseApplication.a());
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (resources.getConfiguration().orientation == 2) {
            iMax = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            iMax = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        this.mDisplayHeight = iMax;
        if (resources.getConfiguration().orientation == 2) {
            iMin = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            iMin = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        this.mDisplayWidth = iMin;
    }

    public boolean setPos(oli oliVar) {
        float fA = oliVar.a();
        return setPos(oliVar.e(), oliVar.h(), oliVar.a(), fA, oliVar.d());
    }

    protected boolean setPos(float f, float f2, float f3, float f4, float f5) {
        float f6 = (this.mWidth / 2.0f) * f3;
        float f7 = (this.mHeight / 2.0f) * f4;
        float fB = plt.b(BaseApplication.a(), 16.0f);
        this.mMinX = (f - f6) - fB;
        this.mMinY = (f2 - f7) - fB;
        float f8 = f6 + f + fB;
        this.mMaxX = f8;
        float f9 = f7 + f2 + fB;
        this.mMaxY = f9;
        this.mGrabAreaX1 = f8 - 40.0f;
        this.mGrabAreaY1 = f9 - 40.0f;
        this.mGrabAreaX2 = f8;
        this.mGrabAreaY2 = f9;
        this.mScaleX = f3;
        this.mScaleY = f4;
        this.mCenterX = f;
        this.mCenterY = f2;
        this.mAngle = f5;
        return true;
    }

    public boolean containsPoint(float f, float f2) {
        return f >= this.mMinX && f <= this.mMaxX && f2 >= this.mMinY && f2 <= this.mMaxY;
    }

    public boolean containsDeletePoint(MultiTouchObject multiTouchObject, float f, float f2) {
        float centerX = multiTouchObject.getCenterX();
        float centerY = multiTouchObject.getCenterY();
        double maxX = multiTouchObject.getMaxX();
        double minY = multiTouchObject.getMinY();
        if (this.isRTLLanguage) {
            maxX = ((double) (2.0f * centerX)) - maxX;
        }
        double d = centerX;
        double d2 = maxX - d;
        double d3 = centerY;
        double d4 = minY - d3;
        double angle = multiTouchObject.getAngle();
        double dCos = Math.cos(angle);
        double dSin = Math.sin(angle);
        double dSin2 = Math.sin(angle);
        double dCos2 = Math.cos(angle);
        float f3 = (float) (d + ((dCos * d2) - (dSin * d4)));
        StickerImageView.b = f3 - plt.b(BaseApplication.a(), 24.0f);
        StickerImageView.e = f3 + plt.b(BaseApplication.a(), 8.0f);
        float f4 = (float) (d3 + (d2 * dSin2) + (d4 * dCos2));
        StickerImageView.f8887a = f4 - plt.b(BaseApplication.a(), 8.0f);
        StickerImageView.c = f4 + plt.b(BaseApplication.a(), 24.0f);
        return containsDeletePoint(f, f2);
    }

    public static boolean containsDeletePoint(float f, float f2) {
        return f >= StickerImageView.b && f <= StickerImageView.e && f2 >= StickerImageView.f8887a && f2 <= StickerImageView.c;
    }

    public void reload(Context context) {
        this.mIsFirstLoad = false;
        init(context, this.mCenterX, this.mCenterY);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public void setSelected(boolean z) {
        this.isLatestSelected = z;
    }

    public boolean isSelected() {
        return this.isLatestSelected;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getMaxX() {
        return this.mMaxX;
    }

    public float getMinY() {
        return this.mMinY;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
        this.mBorderPaint.setColor(i);
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getDisplayWidth() {
        return this.mDisplayWidth;
    }

    public void setDisplayWidth(int i) {
        this.mDisplayWidth = i;
    }

    public int getDisplayHeight() {
        return this.mDisplayHeight;
    }

    public void setDisplayHeight(int i) {
        this.mDisplayHeight = i;
    }

    public boolean isFlippedHorizontally() {
        return this.mFlippedHorizontally;
    }

    public void setFlippedHorizontally(boolean z) {
        this.mFlippedHorizontally = z;
    }
}
