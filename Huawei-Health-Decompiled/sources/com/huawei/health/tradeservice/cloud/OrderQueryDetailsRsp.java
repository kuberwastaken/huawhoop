package com.huawei.health.tradeservice.cloud;

import com.huawei.trade.datatype.OrderDetail;

/* JADX INFO: loaded from: classes5.dex */
public class OrderQueryDetailsRsp extends BaseRsp {
    private OrderDetail orderDetail;

    public OrderDetail getOrderDetail() {
        return this.orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
