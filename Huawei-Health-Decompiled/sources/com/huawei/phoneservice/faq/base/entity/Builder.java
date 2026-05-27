package com.huawei.phoneservice.faq.base.entity;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.e;
import com.huawei.phoneservice.faq.base.util.h;
import com.huawei.phoneservice.faq.base.util.l;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class Builder {
    private static final String TAG = "Builder";
    private Map<String, String> map = new ConcurrentHashMap();

    public Builder setUri(Uri uri) {
        String message;
        try {
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(queryParameter)) {
                    this.map.put(str, queryParameter);
                }
            }
        } catch (UnsupportedOperationException e) {
            message = e.getMessage();
            h.e(TAG, message);
        } catch (Exception e2) {
            message = e2.getMessage();
            h.e(TAG, message);
        }
        return this;
    }

    public Builder setJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject.optString(next))) {
                    this.map.put(next, jSONObject.optString(next));
                }
            }
        } catch (JSONException unused) {
            Log.e(TAG, "  JSONException  ");
        }
        return this;
    }

    public Builder set(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.map.put(str, str2);
        }
        return this;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.map.get("language")) || TextUtils.isEmpty(this.map.get("country")) || TextUtils.isEmpty(this.map.get("channel")) || TextUtils.isEmpty(this.map.get("appVersion"));
    }

    public Map<String, String> build() {
        if (this.map.containsKey("language")) {
            this.map.put("language", getLanguageCode(this.map.get("language"), this.map.get("country")));
        }
        if (!this.map.containsKey("model") || TextUtils.isEmpty(this.map.get("model"))) {
            String strB = e.b();
            if (!TextUtils.isEmpty(strB)) {
                this.map.put("model", strB);
            }
        }
        if (!this.map.containsKey(FaqConstants.FAQ_EMUIVERSION) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_EMUIVERSION))) {
            String strD = e.d();
            if (!TextUtils.isEmpty(strD)) {
                this.map.put(FaqConstants.FAQ_EMUIVERSION, strD);
            }
        }
        if (!this.map.containsKey("osVersion") || TextUtils.isEmpty(this.map.get("osVersion"))) {
            this.map.put("osVersion", e.e());
        }
        if ((!this.map.containsKey("languageCode") || TextUtils.isEmpty(this.map.get("languageCode"))) && !TextUtils.isEmpty(this.map.get("language"))) {
            Map<String, String> map = this.map;
            map.put("languageCode", map.get("language"));
        }
        setIsDeepLink();
        return this.map;
    }

    private void setIsDeepLink() {
        Map<String, String> map;
        String str;
        if (!this.map.containsKey(FaqConstants.FAQ_IS_DEEPLICK) || TextUtils.isEmpty(this.map.get(FaqConstants.FAQ_IS_DEEPLICK))) {
            map = this.map;
            str = "N";
        } else {
            map = this.map;
            str = map.get(FaqConstants.FAQ_IS_DEEPLICK);
        }
        map.put(FaqConstants.FAQ_IS_DEEPLICK, str);
    }

    private String getLanguageCode(String str, String str2) {
        if (str.contains("_")) {
            str = str.replace("_", Constants.LINK);
        }
        if (!str.contains(Constants.LINK) || str.split(Constants.LINK).length <= 0) {
            return str;
        }
        if (str.split(Constants.LINK).length != 1 && !l.c(str.split(Constants.LINK)[1])) {
            return str;
        }
        return str.split(Constants.LINK)[0] + Constants.LINK + str2;
    }
}
