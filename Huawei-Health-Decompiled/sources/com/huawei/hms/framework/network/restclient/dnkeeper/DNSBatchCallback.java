package com.huawei.hms.framework.network.restclient.dnkeeper;

import com.huawei.hms.framework.network.restclient.hwhttp.dns.DnsResult;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public interface DNSBatchCallback {
    void onResult(HashMap<String, DnsResult> map);
}
