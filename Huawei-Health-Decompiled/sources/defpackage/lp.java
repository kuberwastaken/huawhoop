package defpackage;

import android.content.Context;
import com.alipay.sdk.m.j0.a;
import com.huawei.openalliance.ad.constant.VastAttribute;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class lp {
    public a b;
    public File c;

    public void d(Context context) {
        new Thread(new ln(this)).start();
    }

    public final void d() {
        synchronized (this) {
            File file = this.c;
            if (file == null) {
                return;
            }
            if (file.exists() && this.c.isDirectory() && this.c.list().length != 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.c.list()) {
                    arrayList.add(str);
                }
                Collections.sort(arrayList);
                String str2 = (String) arrayList.get(arrayList.size() - 1);
                int size = arrayList.size();
                if (str2.equals(c())) {
                    if (arrayList.size() < 2) {
                        return;
                    }
                    str2 = (String) arrayList.get(arrayList.size() - 2);
                    size--;
                }
                if (!this.b.logCollect(d(kq.e(this.c.getAbsolutePath(), str2)))) {
                    size--;
                }
                for (int i = 0; i < size; i++) {
                    new File(this.c, (String) arrayList.get(i)).delete();
                }
            }
        }
    }

    public static String c() {
        return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log";
    }

    public static String d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put(VastAttribute.ERROR, str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public lp(String str, a aVar) {
        this.c = null;
        this.b = null;
        this.c = new File(str);
        this.b = aVar;
    }
}
