package org.eclipse.californium.elements.config;

import defpackage.yen;
import defpackage.yfr;
import defpackage.ylq;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes8.dex */
public abstract class DocumentedDefinition<T> extends yen<T> {
    protected static final Logger LOGGER = ylq.a((Class<?>) DocumentedDefinition.class);
    private final T defaultValue;
    private final String documentation;

    public T checkValue(T t) throws yfr {
        return t;
    }

    protected abstract T parseValue(String str) throws yfr;

    protected boolean useTrim() {
        return true;
    }

    public abstract String writeValue(T t);

    public DocumentedDefinition(String str, String str2, Class<T> cls, T t) {
        super(str, cls);
        this.documentation = str2;
        this.defaultValue = t;
    }

    public String getTypeName() {
        return getValueType().getSimpleName();
    }

    public String getDocumentation() {
        return this.documentation;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public T readValue(String str) {
        String str2;
        if (str == null) {
            throw new NullPointerException(String.format("Key '%s': textual value must not be null!", getKey()));
        }
        if (useTrim()) {
            str = str.trim();
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException(String.format("Key '%s': textual value must not be empty!", getKey()));
        }
        try {
            return checkValue(parseValue(str));
        } catch (NumberFormatException unused) {
            str2 = String.format("Key '%s': value '%s' is no %s", getKey(), str, getTypeName());
            throw new IllegalArgumentException(str2);
        } catch (IllegalArgumentException e) {
            str2 = String.format("Key '%s': value '%s' %s", getKey(), str, e.getMessage());
            throw new IllegalArgumentException(str2);
        } catch (yfr e2) {
            str2 = String.format("Key '%s': %s", getKey(), e2.getMessage());
            throw new IllegalArgumentException(str2);
        }
    }

    public boolean isAssignableFrom(Object obj) {
        return getValueType().isInstance(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Object checkRawValue(Object obj) throws yfr {
        return checkValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String write(Object obj) {
        return writeValue(obj);
    }
}
