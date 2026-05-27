package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class vly {
    private List<vmb> devices;

    @SerializedName("resultCode")
    private int resultCode;

    public List<vmb> getDevices() {
        if (mgx.d(this.devices)) {
            return new ArrayList(16);
        }
        return this.devices;
    }

    public List<vmb> getBindDevices() {
        if (mgx.d(this.devices)) {
            return new ArrayList(16);
        }
        ArrayList arrayList = new ArrayList();
        for (vmb vmbVar : this.devices) {
            if (vmbVar.getBindStatus() == 1) {
                arrayList.add(vmbVar);
            }
        }
        return arrayList;
    }

    public int getResultCode() {
        return this.resultCode;
    }
}
