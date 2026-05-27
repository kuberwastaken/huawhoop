package com.huawei.haf.bundle;

/* JADX INFO: loaded from: classes.dex */
public class InstallException extends RuntimeException {
    private static final long serialVersionUID = 3544204721266317471L;
    private final int d;

    public InstallException(int i) {
        this(i, null);
    }

    public InstallException(int i, Throwable th) {
        super("Module Install Error: " + i, th);
        this.d = i;
    }

    public int d() {
        return this.d;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String localizedMessage = getLocalizedMessage();
        if (localizedMessage == null) {
            return "InstallException";
        }
        return "InstallException: " + localizedMessage;
    }
}
