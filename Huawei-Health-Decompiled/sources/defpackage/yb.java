package defpackage;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class yb extends ConcurrentHashMap<String, String> {
    public static final yb c = new yb();
    private static final long serialVersionUID = 1;
    private final Object b;

    private yb() {
        super(180, 0.8f, 4);
        this.b = new Object();
    }

    public String c(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.b) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String strIntern = str.intern();
        put(strIntern, strIntern);
        return strIntern;
    }
}
