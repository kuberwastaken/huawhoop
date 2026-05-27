package defpackage;

import com.huawei.networkclient.IRequest;
import com.huawei.operation.ble.BleConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class ftz implements IRequest {
    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bl();
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("page", String.valueOf(1));
        map.put(BleConstants.LIMIT, String.valueOf(200));
        map.put("language", ofk.e(null));
        return map;
    }
}
