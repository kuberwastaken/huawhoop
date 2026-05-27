package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class yfw extends Exception {
    private static final long serialVersionUID = 1;

    public yfw() {
    }

    public yfw(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        return message == null ? getClass().getSimpleName() : message;
    }
}
