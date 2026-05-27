package defpackage;

import com.huawei.ui.commonui.tablewidget.model.ItemData;

/* JADX INFO: loaded from: classes5.dex */
public class isa implements ItemData {
    private String c;
    private String e;

    public isa(String str, String str2) {
        this.c = str;
        this.e = str2;
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.ItemData
    public String getValue() {
        return this.c;
    }

    @Override // com.huawei.ui.commonui.tablewidget.model.ItemData
    public void setValue(String str) {
        this.c = str;
    }

    public String d() {
        return this.e;
    }
}
