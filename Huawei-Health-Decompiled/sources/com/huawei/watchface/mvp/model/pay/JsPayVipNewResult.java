package com.huawei.watchface.mvp.model.pay;

import com.huawei.watchface.mvp.model.info.VipPayInfoCoupons;

/* JADX INFO: loaded from: classes11.dex */
public class JsPayVipNewResult extends JsPayResult {
    private VipPayInfoCoupons mVipPayInfoCoupons;

    public VipPayInfoCoupons getVipPayInfoCoupons() {
        return this.mVipPayInfoCoupons;
    }

    public void setVipPayInfoCoupons(VipPayInfoCoupons vipPayInfoCoupons) {
        this.mVipPayInfoCoupons = vipPayInfoCoupons;
    }
}
