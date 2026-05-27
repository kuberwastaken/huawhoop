package ohos.ace.adapter.capability.editing;

/* JADX INFO: loaded from: classes8.dex */
public enum TextInputAction {
    UNSPECIFIED(0),
    NONE(1),
    GO(2),
    SEARCH(3),
    SEND(4),
    NEXT(5),
    DONE(6),
    PREVIOUS(7),
    NEW_LINE(8);

    private int value;

    TextInputAction(int i) {
        this.value = i;
    }

    public static TextInputAction of(Integer num) {
        if (num == null || num.intValue() < 0 || num.intValue() >= values().length) {
            return UNSPECIFIED;
        }
        return values()[num.intValue()];
    }

    public int getValue() {
        return this.value;
    }
}
