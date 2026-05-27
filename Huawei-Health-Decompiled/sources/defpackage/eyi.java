package defpackage;

import com.huawei.health.device.api.JsonParserApi;
import com.huawei.health.device.wifi.entity.utils.JsonParser;
import com.huawei.hmf.annotation.ApiDefine;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@ApiDefine(uri = JsonParserApi.class)
public class eyi implements JsonParserApi {
    @Override // com.huawei.health.device.api.JsonParserApi
    public Map<String, Object> fromJsonObject(String str) {
        return JsonParser.e(str);
    }

    @Override // com.huawei.health.device.api.JsonParserApi
    public JSONObject toJsonObject(Map<?, ?> map) {
        return JsonParser.b(map);
    }
}
