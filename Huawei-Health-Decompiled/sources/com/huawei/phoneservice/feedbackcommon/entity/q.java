package com.huawei.phoneservice.feedbackcommon.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class q {

    @SerializedName("data")
    private List<e> b = new ArrayList();

    /* JADX INFO: loaded from: classes11.dex */
    public class e {

        @SerializedName("srcno")
        private String b;

        @SerializedName("read")
        private boolean e;

        public boolean a() {
            return !TextUtils.isEmpty(this.b);
        }

        public boolean d() {
            return this.e;
        }
    }

    public List<e> a() {
        return this.b;
    }
}
