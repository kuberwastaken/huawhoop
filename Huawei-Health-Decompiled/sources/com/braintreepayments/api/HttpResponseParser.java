package com.braintreepayments.api;

import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes9.dex */
public interface HttpResponseParser {
    String parse(int i, HttpURLConnection httpURLConnection) throws Exception;
}
