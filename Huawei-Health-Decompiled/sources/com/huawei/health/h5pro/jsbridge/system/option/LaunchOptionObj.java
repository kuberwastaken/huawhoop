package com.huawei.health.h5pro.jsbridge.system.option;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes10.dex */
public class LaunchOptionObj {

    @SerializedName(BleConstants.KEY_PATH)
    public String g = "";

    @SerializedName("isStatusBarTextBlack")
    public int j = 0;

    @SerializedName("isImmerse")
    public int c = 0;

    @SerializedName("isShowStatusBar")
    public int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isNeedSoftInputAdapter")
    public int f2457a = 0;

    @SerializedName("forceDarkMode")
    public int b = -1;

    @SerializedName("startFlag")
    public String f = IntentStartFlag.FLAG_ACTIVITY_STANDARD.flagKey;

    @SerializedName(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)
    public int e = -1;

    @SerializedName("isKeepCustomizeJsModule")
    public int d = 0;

    public void setStartFlag(IntentStartFlag intentStartFlag) {
        this.f = intentStartFlag.flagKey;
    }

    public void setPath(String str) {
        this.g = str;
    }

    public void setIsStatusBarTextBlack(int i) {
        this.j = i;
    }

    public void setIsShowStatusBar(int i) {
        this.i = i;
    }

    public void setIsNeedSoftInputAdapter(int i) {
        this.f2457a = i;
    }

    public void setIsKeepCustomizeJsModule(int i) {
        this.d = i;
    }

    public void setIsImmerse(int i) {
        this.c = i;
    }

    public void setForceDarkMode(int i) {
        this.b = i;
    }

    public void setBackgroundColor(int i) {
        this.e = i;
    }

    public int getStartFlag() {
        IntentStartFlag intentStartFlag;
        if (TextUtils.equals(this.f, IntentStartFlag.FLAG_ACTIVITY_NEW_TASK.flagKey)) {
            intentStartFlag = IntentStartFlag.FLAG_ACTIVITY_NEW_TASK;
        } else {
            intentStartFlag = TextUtils.equals(this.f, IntentStartFlag.FLAG_ACTIVITY_SINGLE_TOP.flagKey) ? IntentStartFlag.FLAG_ACTIVITY_SINGLE_TOP : IntentStartFlag.FLAG_ACTIVITY_STANDARD;
        }
        return intentStartFlag.flagValue;
    }

    public String getPath() {
        return this.g;
    }

    public int getIsStatusBarTextBlack() {
        return this.j;
    }

    public int getIsShowStatusBar() {
        return this.i;
    }

    public int getIsNeedSoftInputAdapter() {
        return this.f2457a;
    }

    public enum IntentStartFlag {
        FLAG_ACTIVITY_SINGLE_TOP("FLAG_ACTIVITY_SINGLE_TOP", 536870912),
        FLAG_ACTIVITY_NEW_TASK("FLAG_ACTIVITY_NEW_TASK", 268435456),
        FLAG_ACTIVITY_STANDARD("FLAG_ACTIVITY_STANDARD", 0);

        public final String flagKey;
        public final int flagValue;

        IntentStartFlag(String str, int i) {
            this.flagKey = str;
            this.flagValue = i;
        }
    }

    public int getIsKeepCustomizeJsModule() {
        return this.d;
    }

    public int getIsImmerse() {
        return this.c;
    }

    public int getForceDarkMode() {
        return this.b;
    }

    public int getBackgroundColor() {
        return this.e;
    }
}
