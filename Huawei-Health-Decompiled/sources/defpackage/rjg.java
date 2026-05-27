package defpackage;

import com.huawei.ui.homehealth.runcard.operation.recommendalgo.sportlevelmapping.SportLevelByVo2Max;

/* JADX INFO: loaded from: classes11.dex */
public class rjg extends SportLevelByVo2Max {
    public rjg(int i) {
        if (i == 1) {
            this.mVeryPoorLimit = 18;
            this.mPoorHigherLimit = 22;
            this.mFairHigherLimit = 25;
            this.mAverageHigherLimit = 29;
            this.mGoodHigherLimit = 32;
            this.mIsInit = true;
            return;
        }
        if (i == 0) {
            this.mVeryPoorLimit = 23;
            this.mPoorHigherLimit = 27;
            this.mFairHigherLimit = 32;
            this.mAverageHigherLimit = 36;
            this.mGoodHigherLimit = 41;
            this.mIsInit = true;
            return;
        }
        this.mIsInit = false;
    }
}
