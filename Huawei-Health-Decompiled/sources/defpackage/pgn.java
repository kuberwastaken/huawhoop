package defpackage;

import com.huawei.ui.commonui.linechart.common.MotionType;
import com.huawei.ui.commonui.linechart.common.MultiMotionBarModel;
import com.huawei.ui.commonui.linechart.icommon.IStorageModel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class pgn implements IStorageModel, MultiMotionBarModel {
    private Map<MotionType, Float> b = new HashMap();

    @Override // com.huawei.ui.commonui.linechart.common.MultiMotionBarModel
    public void put(MotionType motionType, float f) {
        this.b.put(motionType, Float.valueOf(f));
    }

    @Override // com.huawei.ui.commonui.linechart.common.MultiMotionBarModel
    public float getMotionType(MotionType motionType) {
        if (this.b.get(motionType) != null) {
            return this.b.get(motionType).floatValue();
        }
        return 0.0f;
    }
}
