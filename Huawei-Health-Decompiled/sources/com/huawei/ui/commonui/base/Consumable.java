package com.huawei.ui.commonui.base;

/* JADX INFO: loaded from: classes11.dex */
public interface Consumable<T> {

    public interface ConsumableType {
        public static final ConsumableType UNKNOW_CONSUMABLE_TYPE = new ConsumableType() { // from class: com.huawei.ui.commonui.base.Consumable.ConsumableType.2
        };
    }

    T getData();

    ConsumableType getType();
}
