package defpackage;

import org.eclipse.californium.elements.config.BasicDefinition;

/* JADX INFO: loaded from: classes8.dex */
public class yfo extends BasicDefinition<Integer> {
    private final Integer c;

    public yfo(String str, String str2) {
        super(str, str2, Integer.class, null);
        this.c = null;
    }

    public yfo(String str, String str2, Integer num) {
        super(str, str2, Integer.class, num);
        this.c = null;
    }

    public yfo(String str, String str2, Integer num, Integer num2) {
        super(str, str2, Integer.class, num);
        this.c = num2;
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String writeValue(Integer num) {
        return num.toString();
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer checkValue(Integer num) throws yfr {
        if (this.c == null || num == null || num.intValue() >= this.c.intValue()) {
            return num;
        }
        throw new yfr("Value " + num + " must be not less than " + this.c + "!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer parseValue(String str) {
        return Integer.valueOf(Integer.parseInt(str));
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    public String getTypeName() {
        return "Integer";
    }
}
