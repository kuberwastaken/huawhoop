package lib.android.paypal.com.magnessdk;

/* JADX INFO: loaded from: classes11.dex */
public enum MagnesSource {
    DEFAULT(19),
    PAYPAL(10),
    EBAY(11),
    BRAINTREE(12),
    SIMILITY(17),
    VENMO(18);

    private int version;

    public int getVersion() {
        return this.version;
    }

    MagnesSource(int i) {
        this.version = i;
    }
}
