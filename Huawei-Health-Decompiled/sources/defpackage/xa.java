package defpackage;

import com.fasterxml.jackson.core.JacksonException;

/* JADX INFO: loaded from: classes9.dex */
public class xa extends JacksonException {
    private static final long serialVersionUID = 123;
    protected ws _location;

    protected String getMessageSuffix() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JacksonException
    public Object getProcessor() {
        return null;
    }

    public xa(String str, ws wsVar, Throwable th) {
        super(str, th);
        this._location = wsVar;
    }

    public xa(String str) {
        super(str);
    }

    public xa(String str, ws wsVar) {
        this(str, wsVar, null);
    }

    protected xa(String str, Throwable th) {
        this(str, null, th);
    }

    protected xa(Throwable th) {
        this(null, null, th);
    }

    @Override // com.fasterxml.jackson.core.JacksonException
    public ws getLocation() {
        return this._location;
    }

    public void clearLocation() {
        this._location = null;
    }

    @Override // com.fasterxml.jackson.core.JacksonException
    public String getOriginalMessage() {
        return super.getMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        ws location = getLocation();
        String messageSuffix = getMessageSuffix();
        if (location == null && messageSuffix == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (messageSuffix != null) {
            sb.append(messageSuffix);
        }
        if (location != null) {
            sb.append("\n at ");
            sb.append(location.toString());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
