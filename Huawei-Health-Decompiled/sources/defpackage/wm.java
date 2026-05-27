package defpackage;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class wm implements ObjectIdResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<ObjectIdGenerator.b, Object> f18853a;

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public void bindItem(ObjectIdGenerator.b bVar, Object obj) {
        Map<ObjectIdGenerator.b, Object> map = this.f18853a;
        if (map == null) {
            this.f18853a = new HashMap();
        } else {
            Object obj2 = map.get(bVar);
            if (obj2 != null) {
                if (obj2 == obj) {
                    return;
                }
                throw new IllegalStateException("Already had POJO for id (" + bVar.f1657a.getClass().getName() + ") [" + bVar + "]");
            }
        }
        this.f18853a.put(bVar, obj);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public Object resolveId(ObjectIdGenerator.b bVar) {
        Map<ObjectIdGenerator.b, Object> map = this.f18853a;
        if (map == null) {
            return null;
        }
        return map.get(bVar);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public boolean canUseFor(ObjectIdResolver objectIdResolver) {
        return objectIdResolver.getClass() == getClass();
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdResolver
    public ObjectIdResolver newForDeserialization(Object obj) {
        return new wm();
    }
}
