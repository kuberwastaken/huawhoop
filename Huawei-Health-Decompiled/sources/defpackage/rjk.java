package defpackage;

import com.huawei.ui.homehealth.runcard.operation.recommendalgo.sportlevelmapping.SportLevelByVo2Max;

/* JADX INFO: loaded from: classes11.dex */
public class rjk extends SportLevelByVo2Max {
    public rjk(int i) {
        if (i == 1) {
            this.mVeryPoorLimit = 15;
            this.mPoorHigherLimit = 18;
            this.mFairHigherLimit = 21;
            this.mAverageHigherLimit = 24;
            this.mGoodHigherLimit = 27;
            this.mIsInit = true;
            return;
        }
        if (i == 0) {
            this.mVeryPoorLimit = 20;
            this.mPoorHigherLimit = 24;
            this.mFairHigherLimit = 28;
            this.mAverageHigherLimit = 32;
            this.mGoodHigherLimit = 36;
            this.mIsInit = true;
            return;
        }
        this.mIsInit = false;
    }
}
