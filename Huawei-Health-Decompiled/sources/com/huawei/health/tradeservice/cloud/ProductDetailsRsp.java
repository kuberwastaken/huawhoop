package com.huawei.health.tradeservice.cloud;

import com.huawei.trade.datatype.Product;

/* JADX INFO: loaded from: classes5.dex */
public class ProductDetailsRsp extends BaseRsp {
    private Product productInfo;

    public Product getProductInfo() {
        return this.productInfo;
    }

    public void setProductInfo(Product product) {
        this.productInfo = product;
    }
}
