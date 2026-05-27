package defpackage;

import com.huawei.ui.commonui.linechart.common.DataLayerType;
import com.huawei.ui.commonui.linechart.icommon.IStorageModel;
import com.huawei.ui.commonui.linechart.model.MultiDataBarModel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class suy implements IStorageModel, MultiDataBarModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sva f17878a;
    private Map<DataLayerType, Float> d = new HashMap();

    @Override // com.huawei.ui.commonui.linechart.model.MultiDataBarModel
    public void put(DataLayerType dataLayerType, float f) {
        this.d.put(dataLayerType, Float.valueOf(f));
    }

    @Override // com.huawei.ui.commonui.linechart.model.MultiDataBarModel
    public float getCeil(DataLayerType dataLayerType) {
        if (this.d.get(dataLayerType) != null) {
            return this.d.get(dataLayerType).floatValue();
        }
        return 0.0f;
    }

    @Override // com.huawei.ui.commonui.linechart.model.MultiDataBarModel
    public float getCeil() {
        sva svaVar = this.f17878a;
        if (svaVar != null) {
            return getCeil(svaVar.e());
        }
        return 0.0f;
    }

    public void c(sva svaVar) {
        this.f17878a = svaVar;
    }
}
