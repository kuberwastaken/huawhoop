package defpackage;

import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class adg implements ClassIntrospector.MixInResolver, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ClassIntrospector.MixInResolver f179a;
    protected Map<ahi, Class<?>> c;

    public adg(ClassIntrospector.MixInResolver mixInResolver) {
        this.f179a = mixInResolver;
    }

    protected adg(ClassIntrospector.MixInResolver mixInResolver, Map<ahi, Class<?>> map) {
        this.f179a = mixInResolver;
        this.c = map;
    }

    public void b(Class<?> cls, Class<?> cls2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(new ahi(cls), cls2);
    }

    @Override // com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public adg copy() {
        ClassIntrospector.MixInResolver mixInResolver = this.f179a;
        return new adg(mixInResolver == null ? null : mixInResolver.copy(), this.c != null ? new HashMap(this.c) : null);
    }

    @Override // com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver
    public Class<?> findMixInClassFor(Class<?> cls) {
        Map<ahi, Class<?>> map;
        ClassIntrospector.MixInResolver mixInResolver = this.f179a;
        Class<?> clsFindMixInClassFor = mixInResolver == null ? null : mixInResolver.findMixInClassFor(cls);
        return (clsFindMixInClassFor != null || (map = this.c) == null) ? clsFindMixInClassFor : map.get(new ahi(cls));
    }

    public int d() {
        Map<ahi, Class<?>> map = this.c;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public boolean c() {
        if (this.c != null) {
            return true;
        }
        ClassIntrospector.MixInResolver mixInResolver = this.f179a;
        if (mixInResolver == null) {
            return false;
        }
        if (mixInResolver instanceof adg) {
            return ((adg) mixInResolver).c();
        }
        return true;
    }
}
