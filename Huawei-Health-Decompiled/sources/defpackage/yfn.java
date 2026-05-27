package defpackage;

import org.eclipse.californium.elements.config.BasicDefinition;

/* JADX INFO: loaded from: classes8.dex */
public class yfn extends BasicDefinition<Float> {
    private final Float e;

    public yfn(String str, String str2, Float f) {
        super(str, str2, Float.class, f);
        this.e = null;
    }

    public yfn(String str, String str2, Float f, Float f2) {
        super(str, str2, Float.class, f);
        this.e = f2;
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String writeValue(Float f) {
        return f.toString();
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Float checkValue(Float f) throws yfr {
        if (this.e == null || f == null || f.floatValue() >= this.e.floatValue()) {
            return f;
        }
        throw new yfr("Value " + f + " must be not less than " + this.e + "!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float parseValue(String str) {
        return Float.valueOf(Float.parseFloat(str));
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    public String getTypeName() {
        return "Float";
    }
}
