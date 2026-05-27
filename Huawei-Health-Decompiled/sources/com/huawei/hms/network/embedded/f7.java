package com.huawei.hms.network.embedded;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface f7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f7 f5438a = new f7() { // from class: com.huawei.hms.network.embedded.f7$$ExternalSyntheticLambda0
        @Override // com.huawei.hms.network.embedded.f7
        public final List lookup(String str) {
            return f7.a(str);
        }
    };

    List<InetAddress> lookup(String str) throws UnknownHostException;

    static /* synthetic */ List a(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        try {
            return Arrays.asList(InetAddress.getAllByName(str));
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
