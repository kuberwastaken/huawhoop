package defpackage;

import com.google.gson.annotations.SerializedName;
import health.compact.a.CommonUtils;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class mgg implements Serializable {
    private static final long serialVersionUID = 6258534691956492071L;

    @SerializedName("mMap")
    private LinkedHashMap<String, String> b = new LinkedHashMap<>();

    @SerializedName("mTimestamp")
    private long d;

    public mgg(String[] strArr) {
        if (strArr.length < 3) {
            return;
        }
        this.d = CommonUtils.j(strArr[1].split("=")[1]);
        for (int i = 2; i < strArr.length; i++) {
            this.b.put(strArr[i].split("=")[0], strArr[i].split("=")[1]);
        }
    }

    public String toString() {
        return "tp=ext;k=" + this.d + ";" + ((CharSequence) d()) + System.lineSeparator();
    }

    private StringBuilder d() {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, String> linkedHashMap = this.b;
        if (linkedHashMap == null) {
            return sb;
        }
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append(";");
        }
        return sb;
    }
}
