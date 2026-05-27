package defpackage;

import android.text.TextUtils;
import com.huawei.picture.security.account.bean.AuthErrorBean;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class nmy {
    private final List<AuthErrorBean> d;

    private nmy() {
        this.d = new CopyOnWriteArrayList();
    }

    static class a {
        private static final nmy d = new nmy();
    }

    public static nmy d() {
        return a.d;
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            nni.d("AuthErrorHelper", "isNeedRefreshToken url empty: " + TextUtils.isEmpty(str) + " ;result empty: " + TextUtils.isEmpty(str2));
            return false;
        }
        try {
            String path = new URL(str).getPath();
            JSONObject jSONObject = new JSONObject(str2);
            for (AuthErrorBean authErrorBean : this.d) {
                if (path.equals(authErrorBean.getPath()) && jSONObject.optString(authErrorBean.getCodeKey()).equals(authErrorBean.getCodeValue()) && (TextUtils.isEmpty(authErrorBean.getMsgKey()) || TextUtils.isEmpty(authErrorBean.getMsgValue()) || jSONObject.optString(authErrorBean.getMsgKey()).equals(authErrorBean.getMsgValue()))) {
                    return true;
                }
            }
        } catch (Exception e) {
            nni.c("AuthErrorHelper", "isNeedRefreshToken Exception: ", e);
        }
        return false;
    }

    public void a(List<AuthErrorBean> list) {
        c();
        if (nnl.b(list)) {
            return;
        }
        nni.d("AuthErrorHelper", "updateAuthErrorList authErrorStrList " + list.size());
        for (AuthErrorBean authErrorBean : list) {
            if (authErrorBean != null) {
                this.d.add(authErrorBean);
            }
        }
    }

    private void c() {
        this.d.clear();
    }
}
