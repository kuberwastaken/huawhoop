package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ConfigOverride {
    protected JsonFormat.b _format;
    protected JsonIgnoreProperties.b _ignorals;
    protected JsonInclude.d _include;
    protected JsonInclude.d _includeAsProperty;
    protected Boolean _isIgnoredType;
    protected Boolean _mergeable;
    protected JsonSetter.b _setterInfo;
    protected JsonAutoDetect.b _visibility;

    public ConfigOverride() {
    }

    protected ConfigOverride(ConfigOverride configOverride) {
        this._format = configOverride._format;
        this._include = configOverride._include;
        this._includeAsProperty = configOverride._includeAsProperty;
        this._ignorals = configOverride._ignorals;
        this._setterInfo = configOverride._setterInfo;
        this._visibility = configOverride._visibility;
        this._isIgnoredType = configOverride._isIgnoredType;
        this._mergeable = configOverride._mergeable;
    }

    public static ConfigOverride empty() {
        return e.e;
    }

    public JsonFormat.b getFormat() {
        return this._format;
    }

    public JsonInclude.d getInclude() {
        return this._include;
    }

    public JsonInclude.d getIncludeAsProperty() {
        return this._includeAsProperty;
    }

    public JsonIgnoreProperties.b getIgnorals() {
        return this._ignorals;
    }

    public Boolean getIsIgnoredType() {
        return this._isIgnoredType;
    }

    public JsonSetter.b getSetterInfo() {
        return this._setterInfo;
    }

    public JsonAutoDetect.b getVisibility() {
        return this._visibility;
    }

    public Boolean getMergeable() {
        return this._mergeable;
    }

    static final class e extends ConfigOverride {
        static final e e = new e();

        private e() {
        }
    }
}
