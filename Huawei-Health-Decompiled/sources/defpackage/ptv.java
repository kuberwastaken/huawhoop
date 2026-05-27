package defpackage;

import com.huawei.ui.device.declaration.xmlparser.DeclarationConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ptv extends ptn {
    private static final long serialVersionUID = 6236452322340363024L;
    protected DeclarationConstants.PartType d;
    private List<puc> e = new ArrayList(8);

    public void d(DeclarationConstants.PartType partType) {
        this.d = partType;
    }

    public List<puc> e() {
        return this.e;
    }

    public void d(puc pucVar) {
        this.e.add(pucVar);
    }
}
