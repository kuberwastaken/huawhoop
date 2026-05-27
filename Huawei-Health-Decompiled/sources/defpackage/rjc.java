package defpackage;

import com.huawei.ui.homehealth.runcard.operation.recommendalgo.sportlevelmapping.SportLevelByVo2Max;

/* JADX INFO: loaded from: classes11.dex */
public class rjc extends SportLevelByVo2Max {
    public rjc(int i) {
        if (i == 1) {
            this.mVeryPoorLimit = 25;
            this.mPoorHigherLimit = 30;
            this.mFairHigherLimit = 35;
            this.mAverageHigherLimit = 40;
            this.mGoodHigherLimit = 44;
            this.mIsInit = true;
            return;
        }
        if (i == 0) {
            this.mVeryPoorLimit = 30;
            this.mPoorHigherLimit = 35;
            this.mFairHigherLimit = 42;
            this.mAverageHigherLimit = 48;
            this.mGoodHigherLimit = 53;
            this.mIsInit = true;
            return;
        }
        this.mIsInit = false;
    }
}
