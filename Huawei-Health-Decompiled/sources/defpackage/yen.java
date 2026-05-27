package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class yen<T> {
    private final String key;
    private final Class<T> valueType;

    public yen(String str, Class<T> cls) {
        this(str, cls, null);
    }

    public yen(String str, Class<T> cls, yep<yen<?>> yepVar) {
        if (str == null) {
            throw new NullPointerException("Key must not be null!");
        }
        if (cls == null) {
            throw new NullPointerException("Value Type must not be null!");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Key must not be empty!");
        }
        this.key = str;
        this.valueType = cls;
        if (yepVar != null) {
            yepVar.d(this);
        }
    }

    public final Class<T> getValueType() {
        return this.valueType;
    }

    public final String getKey() {
        return this.key;
    }

    public String toString() {
        return this.key;
    }
}
