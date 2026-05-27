package defpackage;

import org.eclipse.californium.elements.config.BasicDefinition;

/* JADX INFO: loaded from: classes8.dex */
public class yfk extends BasicDefinition<Boolean> {
    public yfk(String str, String str2) {
        super(str, str2, Boolean.class, null);
    }

    public yfk(String str, String str2, Boolean bool) {
        super(str, str2, Boolean.class, bool);
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String writeValue(Boolean bool) {
        return bool.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean parseValue(String str) {
        return Boolean.valueOf(Boolean.parseBoolean(str));
    }

    @Override // org.eclipse.californium.elements.config.DocumentedDefinition
    public String getTypeName() {
        return "Boolean";
    }
}
