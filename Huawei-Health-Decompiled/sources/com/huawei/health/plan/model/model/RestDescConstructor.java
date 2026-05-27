package com.huawei.health.plan.model.model;

import android.content.Context;
import com.huawei.health.R;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class RestDescConstructor {
    private SecureRandom mRandom;
    private List<String> mRestDaySentenceList;
    private String[] mRestDaySentences;

    public void init(Context context) {
        this.mRestDaySentenceList = new ArrayList();
        this.mRandom = new SecureRandom();
        this.mRestDaySentences = context.getResources().getStringArray(R.array._2130968718_res_0x7f04008e);
    }

    public String constructorDesc() {
        if (this.mRestDaySentenceList.size() == 0) {
            this.mRestDaySentenceList.addAll(Arrays.asList(this.mRestDaySentences));
        }
        int iNextInt = this.mRandom.nextInt(this.mRestDaySentenceList.size());
        this.mRestDaySentenceList.remove(iNextInt);
        return this.mRestDaySentences[iNextInt];
    }
}
