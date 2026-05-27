package ohos.ace.adapter.capability.editing;

/* JADX INFO: loaded from: classes8.dex */
public enum TextInputType {
    TEXT(0),
    MULTILINE(1),
    NUMBER(2),
    PHONE(3),
    DATETIME(4),
    EMAIL_ADDRESS(5),
    URL(6),
    VISIBLE_PASSWORD(7),
    NUMBER_PASSWORD(8);

    private int value;

    public static TextInputType of(Integer num) {
        if (num == null || num.intValue() < 0 || num.intValue() >= values().length) {
            return TEXT;
        }
        return values()[num.intValue()];
    }

    public int getValue() {
        return this.value;
    }

    TextInputType(int i) {
        this.value = i;
    }
}
