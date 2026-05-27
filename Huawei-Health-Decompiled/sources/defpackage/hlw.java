package defpackage;

import com.huawei.health.suggestion.ui.tabfragments.repository.Repository;
import com.huawei.hwcommonmodel.utils.httputils.pluginoperation.HttpResCallback;
import com.huawei.hwlogsmodel.LogUtil;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes10.dex */
public class hlw implements Repository {
    private JSONArray e = null;

    public static /* synthetic */ void c(HashMap map, HashMap map2, HttpResCallback httpResCallback, String str) {
        LogUtil.e("Suggestion_RecommendActivityRepository", "HttpPost request url:", str, "/activity/getActivities", " params:", map.toString(), ",headers:", map2.toString());
        krb.a(str + "/activity/getActivities", map, map2, httpResCallback);
    }
}
