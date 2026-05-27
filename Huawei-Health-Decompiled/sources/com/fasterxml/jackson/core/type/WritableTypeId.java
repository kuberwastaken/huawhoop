package com.fasterxml.jackson.core.type;

import com.fasterxml.jackson.core.JsonToken;

/* JADX INFO: loaded from: classes9.dex */
public class WritableTypeId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1661a;
    public Inclusion b;
    public String c;
    public Object d;
    public Class<?> e;
    public JsonToken h;
    public boolean j;

    public enum Inclusion {
        WRAPPER_ARRAY,
        WRAPPER_OBJECT,
        METADATA_PROPERTY,
        PAYLOAD_PROPERTY,
        PARENT_PROPERTY;

        public boolean requiresObjectContext() {
            return this == METADATA_PROPERTY || this == PAYLOAD_PROPERTY;
        }
    }

    public WritableTypeId() {
    }

    public WritableTypeId(Object obj, JsonToken jsonToken) {
        this(obj, jsonToken, null);
    }

    public WritableTypeId(Object obj, JsonToken jsonToken, Object obj2) {
        this.f1661a = obj;
        this.d = obj2;
        this.h = jsonToken;
    }
}
