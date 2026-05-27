package com.huawei.watchface;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public enum bn {
    WEIXIN_FRIEND(0),
    WEIXIN_MOMENT(1),
    XIAOHONGSHU(2),
    DOUYIN(3),
    QQ(4),
    QQ_ZONE(5),
    WEIBO(6),
    SAVE_LOCAL(7),
    SAVE_CLIPBOARD(8),
    MORE(9),
    FACEBOOK(10),
    TELEGRAM(11),
    INSTAGRAM(12),
    WHATSAPP(13),
    TWITTER(14),
    LINKEDIN(15),
    VK(16),
    UNKNOWN(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, bn> f11435a = new HashMap();
    private final int mValue;

    static {
        for (bn bnVar : values()) {
            f11435a.put(Integer.valueOf(bnVar.getValue()), bnVar);
        }
    }

    bn(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }

    public static bn fromValue(int i) {
        bn bnVar = f11435a.get(Integer.valueOf(i));
        return bnVar != null ? bnVar : UNKNOWN;
    }
}
