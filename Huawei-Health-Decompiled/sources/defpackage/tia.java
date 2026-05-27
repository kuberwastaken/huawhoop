package defpackage;

import com.huawei.ui.commonui.base.Consumable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class tia implements Consumable<thy>, Serializable {
    private static final long serialVersionUID = 1;
    private Consumable.ConsumableType d;
    private thy e;

    public tia(Consumable.ConsumableType consumableType, thy thyVar) {
        this.d = consumableType;
        this.e = thyVar;
    }

    @Override // com.huawei.ui.commonui.base.Consumable
    public Consumable.ConsumableType getType() {
        return this.d;
    }

    @Override // com.huawei.ui.commonui.base.Consumable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public thy getData() {
        return this.e;
    }
}
