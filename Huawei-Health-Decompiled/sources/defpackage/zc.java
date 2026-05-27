package defpackage;

import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class zc implements Serializable {
    private static final int b = CoercionInputShape.values().length;
    private static final long serialVersionUID = 1;
    protected final CoercionAction[] d = new CoercionAction[b];
    protected Boolean c = false;

    public CoercionAction b(CoercionInputShape coercionInputShape) {
        return this.d[coercionInputShape.ordinal()];
    }

    public Boolean d() {
        return this.c;
    }
}
