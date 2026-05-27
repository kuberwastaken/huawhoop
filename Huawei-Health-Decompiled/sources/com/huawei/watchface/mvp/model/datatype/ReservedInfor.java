package com.huawei.watchface.mvp.model.datatype;

/* JADX INFO: loaded from: classes11.dex */
public class ReservedInfor {
    private AccountInfo accountInfo;
    private OrderPurchaseExtensionInformation orderPurchaseExtensionInformation;
    private PromotionalOffer promotionalOffer;

    public PromotionalOffer getPromotionalOffer() {
        return this.promotionalOffer;
    }

    public void setPromotionalOffer(PromotionalOffer promotionalOffer) {
        this.promotionalOffer = promotionalOffer;
    }

    public OrderPurchaseExtensionInformation getOrderPurchaseExtensionInformation() {
        return this.orderPurchaseExtensionInformation;
    }

    public void setOrderPurchaseExtensionInformation(OrderPurchaseExtensionInformation orderPurchaseExtensionInformation) {
        this.orderPurchaseExtensionInformation = orderPurchaseExtensionInformation;
    }

    public AccountInfo getAccountInfo() {
        return this.accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }
}
