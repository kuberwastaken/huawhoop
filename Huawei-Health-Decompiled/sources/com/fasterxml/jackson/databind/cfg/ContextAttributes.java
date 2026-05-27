package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ContextAttributes {
    public abstract Object getAttribute(Object obj);

    public abstract ContextAttributes withPerCallAttribute(Object obj, Object obj2);

    public abstract ContextAttributes withSharedAttribute(Object obj, Object obj2);

    public abstract ContextAttributes withSharedAttributes(Map<?, ?> map);

    public abstract ContextAttributes withoutSharedAttribute(Object obj);

    public static ContextAttributes getEmpty() {
        return b.b();
    }

    public static class b extends ContextAttributes implements Serializable {
        private static final long serialVersionUID = 1;
        protected final Map<?, ?> b;
        protected transient Map<Object, Object> d;
        protected static final b c = new b(Collections.emptyMap());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected static final Object f1668a = new Object();

        protected b(Map<?, ?> map) {
            this.b = map;
            this.d = null;
        }

        protected b(Map<?, ?> map, Map<Object, Object> map2) {
            this.b = map;
            this.d = map2;
        }

        public static ContextAttributes b() {
            return c;
        }

        @Override // com.fasterxml.jackson.databind.cfg.ContextAttributes
        public ContextAttributes withSharedAttribute(Object obj, Object obj2) {
            Map<Object, Object> mapC;
            if (this == c) {
                mapC = new HashMap<>(8);
            } else {
                mapC = c(this.b);
            }
            mapC.put(obj, obj2);
            return new b(mapC);
        }

        @Override // com.fasterxml.jackson.databind.cfg.ContextAttributes
        public ContextAttributes withSharedAttributes(Map<?, ?> map) {
            return new b(map);
        }

        @Override // com.fasterxml.jackson.databind.cfg.ContextAttributes
        public ContextAttributes withoutSharedAttribute(Object obj) {
            if (this.b.isEmpty() || !this.b.containsKey(obj)) {
                return this;
            }
            if (this.b.size() == 1) {
                return c;
            }
            Map<Object, Object> mapC = c(this.b);
            mapC.remove(obj);
            return new b(mapC);
        }

        @Override // com.fasterxml.jackson.databind.cfg.ContextAttributes
        public Object getAttribute(Object obj) {
            Object obj2;
            Map<Object, Object> map = this.d;
            if (map != null && (obj2 = map.get(obj)) != null) {
                if (obj2 == f1668a) {
                    return null;
                }
                return obj2;
            }
            return this.b.get(obj);
        }

        @Override // com.fasterxml.jackson.databind.cfg.ContextAttributes
        public ContextAttributes withPerCallAttribute(Object obj, Object obj2) {
            if (obj2 == null) {
                if (this.b.containsKey(obj)) {
                    obj2 = f1668a;
                } else {
                    Map<Object, Object> map = this.d;
                    if (map != null && map.containsKey(obj)) {
                        this.d.remove(obj);
                    }
                    return this;
                }
            }
            Map<Object, Object> map2 = this.d;
            if (map2 == null) {
                return b(obj, obj2);
            }
            map2.put(obj, obj2);
            return this;
        }

        protected ContextAttributes b(Object obj, Object obj2) {
            HashMap map = new HashMap();
            if (obj2 == null) {
                obj2 = f1668a;
            }
            map.put(obj, obj2);
            return new b(this.b, map);
        }

        private Map<Object, Object> c(Map<?, ?> map) {
            return new HashMap(map);
        }
    }
}
