package defpackage;

import android.text.TextUtils;
import com.huawei.operation.utils.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class dpe {
    private String d;
    private ArrayList<dpg> e;

    public String d() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    public ArrayList<dpg> c() {
        return this.e;
    }

    public void b(ArrayList<dpg> arrayList) {
        this.e = arrayList;
    }

    public void a(dpg dpgVar) {
        if (this.e == null) {
            this.e = new ArrayList<>(16);
        }
        this.e.add(dpgVar);
    }

    public void d(String str, String str2, String str3) {
        if (this.e == null) {
            this.e = new ArrayList<>(16);
        }
        dpg dpgVar = new dpg();
        dpgVar.e(str);
        dpgVar.d(str2);
        dpgVar.a(str3);
        this.e.add(dpgVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("DeviceUserInfo{mDeviceId ='");
        String str = this.d;
        String string = Constants.NULL;
        stringBuffer.append(str == null ? Constants.NULL : dna.b(str)).append("'mUsers ='");
        ArrayList<dpg> arrayList = this.e;
        if (arrayList != null) {
            string = arrayList.toString();
        }
        stringBuffer.append(string).append("'}");
        return stringBuffer.toString();
    }

    public boolean a() {
        ArrayList<dpg> arrayList;
        return TextUtils.isEmpty(this.d) || (arrayList = this.e) == null || arrayList.size() <= 0;
    }
}
