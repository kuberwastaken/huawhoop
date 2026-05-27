package defpackage;

import com.huawei.ui.commonui.tablewidget.model.ItemData;

/* JADX INFO: loaded from: classes5.dex */
public class irx implements ItemData {
    private String b;

    public irx(String str) {
        this.b = str;
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.ItemData
    public String getValue() {
        return this.b;
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.ItemData
    public void setValue(String str) {
        this.b = str;
    }
}
