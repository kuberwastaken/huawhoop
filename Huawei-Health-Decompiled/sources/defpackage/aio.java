package defpackage;

import com.fasterxml.jackson.core.JsonStreamContext;

/* JADX INFO: loaded from: classes9.dex */
public class aio extends JsonStreamContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ws f243a;
    protected final JsonStreamContext b;
    protected Object c;
    protected String d;

    protected aio(JsonStreamContext jsonStreamContext, ws wsVar) {
        super(jsonStreamContext);
        this.b = jsonStreamContext.getParent();
        this.d = jsonStreamContext.getCurrentName();
        this.c = jsonStreamContext.getCurrentValue();
        this.f243a = wsVar;
    }

    protected aio() {
        super(0, -1);
        this.b = null;
        this.f243a = ws.e;
    }

    protected aio(aio aioVar, int i, int i2) {
        super(i, i2);
        this.b = aioVar;
        this.f243a = aioVar.f243a;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return this.c;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
        this.c = obj;
    }

    public static aio d(JsonStreamContext jsonStreamContext) {
        if (jsonStreamContext == null) {
            return new aio();
        }
        return new aio(jsonStreamContext, null);
    }

    public aio e() {
        this._index++;
        return new aio(this, 1, -1);
    }

    public aio d() {
        this._index++;
        return new aio(this, 2, -1);
    }

    public aio b() {
        JsonStreamContext jsonStreamContext = this.b;
        if (jsonStreamContext instanceof aio) {
            return (aio) jsonStreamContext;
        }
        if (jsonStreamContext == null) {
            return new aio();
        }
        return new aio(jsonStreamContext, this.f243a);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String getCurrentName() {
        return this.d;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public boolean hasCurrentName() {
        return this.d != null;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public JsonStreamContext getParent() {
        return this.b;
    }

    public void c(String str) throws xa {
        this.d = str;
    }

    public void a() {
        this._index++;
    }
}
