package defpackage;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.filter.TokenFilter;

/* JADX INFO: loaded from: classes9.dex */
public class wx extends JsonStreamContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final wx f18961a;
    protected TokenFilter b;
    protected boolean c;
    protected String d;
    protected wx e;
    protected boolean i;

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public Object getCurrentValue() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public void setCurrentValue(Object obj) {
    }

    protected wx(int i, wx wxVar, TokenFilter tokenFilter, boolean z) {
        this._type = i;
        this.f18961a = wxVar;
        this.b = tokenFilter;
        this._index = -1;
        this.i = z;
        this.c = false;
    }

    protected wx d(int i, TokenFilter tokenFilter, boolean z) {
        this._type = i;
        this.b = tokenFilter;
        this._index = -1;
        this.d = null;
        this.i = z;
        this.c = false;
        return this;
    }

    public static wx c(TokenFilter tokenFilter) {
        return new wx(0, null, tokenFilter, true);
    }

    public wx a(TokenFilter tokenFilter, boolean z) {
        wx wxVar = this.e;
        if (wxVar == null) {
            wx wxVar2 = new wx(1, this, tokenFilter, z);
            this.e = wxVar2;
            return wxVar2;
        }
        return wxVar.d(1, tokenFilter, z);
    }

    public wx e(TokenFilter tokenFilter, boolean z) {
        wx wxVar = this.e;
        if (wxVar == null) {
            wx wxVar2 = new wx(2, this, tokenFilter, z);
            this.e = wxVar2;
            return wxVar2;
        }
        return wxVar.d(2, tokenFilter, z);
    }

    public TokenFilter a(String str) throws xa {
        this.d = str;
        this.c = true;
        return this.b;
    }

    public TokenFilter a(TokenFilter tokenFilter) {
        if (this._type == 2) {
            return tokenFilter;
        }
        int i = this._index + 1;
        this._index = i;
        if (this._type == 1) {
            return tokenFilter.e(i);
        }
        return tokenFilter.c(i);
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final wx getParent() {
        return this.f18961a;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final String getCurrentName() {
        return this.d;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public boolean hasCurrentName() {
        return this.d != null;
    }

    public TokenFilter c() {
        return this.b;
    }

    public boolean b() {
        return this.i;
    }

    public JsonToken e() {
        if (!this.i) {
            this.i = true;
            if (this._type == 2) {
                return JsonToken.START_OBJECT;
            }
            return JsonToken.START_ARRAY;
        }
        if (!this.c || this._type != 2) {
            return null;
        }
        this.c = false;
        return JsonToken.FIELD_NAME;
    }

    public wx a(wx wxVar) {
        wx wxVar2 = this.f18961a;
        if (wxVar2 == wxVar) {
            return this;
        }
        while (wxVar2 != null) {
            wx wxVar3 = wxVar2.f18961a;
            if (wxVar3 == wxVar) {
                return wxVar2;
            }
            wxVar2 = wxVar3;
        }
        return null;
    }

    protected void d(StringBuilder sb) {
        wx wxVar = this.f18961a;
        if (wxVar != null) {
            wxVar.d(sb);
        }
        if (this._type == 2) {
            sb.append('{');
            if (this.d != null) {
                sb.append('\"');
                sb.append(this.d);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
            return;
        }
        if (this._type == 1) {
            sb.append('[');
            sb.append(getCurrentIndex());
            sb.append(']');
            return;
        }
        sb.append("/");
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        d(sb);
        return sb.toString();
    }
}
