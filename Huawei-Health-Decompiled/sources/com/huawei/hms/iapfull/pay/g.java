package com.huawei.hms.iapfull.pay;

import android.text.TextUtils;
import com.huawei.featureuserprofile.route.hwgpxmodel.Wpt;
import com.huawei.hms.iapfull.network.model.DeveloperSignResponse;
import com.huawei.hms.iapfull.network.model.MyPayType;
import com.huawei.hms.iapfull.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<MyPayType> f4934a = new CopyOnWriteArrayList();
    private boolean b = true;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f4935a = new g();
    }

    public List<MyPayType> a() {
        ArrayList<MyPayType> arrayList = new ArrayList();
        MyPayType myPayType = null;
        for (MyPayType myPayType2 : this.f4934a) {
            if (17 == myPayType2.getPayType() && !this.b) {
                y0.b("PayManager", "getSupportPayTypeList: wx not support");
                myPayType = myPayType2;
            } else if (myPayType2.getMode() == 0) {
                arrayList.add(myPayType2);
            }
        }
        if (myPayType != null) {
            this.f4934a.remove(myPayType);
        }
        if (arrayList.isEmpty()) {
            y0.b("PayManager", "removePayTypeToLast： not stop service");
        } else {
            for (MyPayType myPayType3 : arrayList) {
                if (this.f4934a.contains(myPayType3)) {
                    this.f4934a.remove(myPayType3);
                }
            }
            this.f4934a.addAll(arrayList);
        }
        return this.f4934a;
    }

    public void a(List<DeveloperSignResponse.MyDics> list, String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            y0.b("PayManager", "setPayChannelListMap: appId is null");
            return;
        }
        for (DeveloperSignResponse.MyDics myDics : list) {
            if ("FP_PayTypePolices".equals(myDics.getName())) {
                String value = myDics.getValue();
                if (TextUtils.isEmpty(value)) {
                    str2 = "setPayTypePolicesList: FP_PAY_TYPE_POLICES value is null";
                } else {
                    try {
                        JSONArray jSONArrayOptJSONArray = new JSONObject(value).optJSONArray("payList");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                                int iOptInt = jSONObjectOptJSONObject.optInt("payType");
                                for (int i2 = 0; i2 < this.f4934a.size(); i2++) {
                                    if (iOptInt == this.f4934a.get(i2).getPayType()) {
                                        this.f4934a.get(i2).setMode(jSONObjectOptJSONObject.optInt(Wpt.MODE));
                                    }
                                }
                            }
                        }
                    } catch (JSONException unused) {
                        str2 = "setPayTypePolicesList: FP_PAY_TYPE_POLICES value is JSONException";
                        y0.a("PayManager", str2);
                    }
                }
                y0.a("PayManager", str2);
            } else if ("liteSdkWXNotSupportMerchants".equals(myDics.getName())) {
                String value2 = myDics.getValue();
                if (TextUtils.isEmpty(value2)) {
                    str3 = "setWxPayTypeMode: setWxPayTypeMode value is null";
                } else if (TextUtils.isEmpty(str)) {
                    str3 = "setWxPayTypeMode: setWxPayTypeMode packageName is null";
                } else {
                    try {
                        JSONArray jSONArray = new JSONArray(value2);
                        if (jSONArray.length() > 0) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= jSONArray.length()) {
                                    break;
                                }
                                if (str.equals(jSONArray.optJSONObject(i3).optString("merchant"))) {
                                    this.b = false;
                                    break;
                                }
                                i3++;
                            }
                        }
                    } catch (JSONException unused2) {
                        str3 = "setPayTypePolicesList: WX_SUPPORT_MERCHANTS value is JSONException";
                        y0.a("PayManager", str3);
                    }
                }
                y0.a("PayManager", str3);
            }
        }
    }

    public boolean b() {
        Iterator<MyPayType> it = this.f4934a.iterator();
        while (it.hasNext()) {
            if (1 == it.next().getMode()) {
                return true;
            }
        }
        return false;
    }

    public void a(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            y0.b("PayManager", "setPayChannelListMap: listPayType is null");
            return;
        }
        this.f4934a.clear();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (f.a(iIntValue)) {
                MyPayType myPayType = new MyPayType();
                myPayType.setPayType(iIntValue);
                myPayType.setMode(1);
                this.f4934a.add(myPayType);
            }
        }
    }
}
