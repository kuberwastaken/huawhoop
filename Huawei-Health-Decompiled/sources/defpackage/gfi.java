package defpackage;

import com.huawei.health.marketing.datatype.SingleGridContent;
import com.huawei.ui.commonui.listener.OnClickSectionListener;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class gfi {
    private List<SingleGridContent> b;
    private OnClickSectionListener e;

    public OnClickSectionListener b() {
        return this.e;
    }

    public void b(OnClickSectionListener onClickSectionListener) {
        this.e = onClickSectionListener;
    }

    public List<SingleGridContent> d() {
        return this.b;
    }

    public void a(List<SingleGridContent> list) {
        this.b = list;
    }
}
