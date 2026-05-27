package com.huawei.openalliance.ad.beans.metadata.v3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TemplateV3 implements Serializable {
    private static final long serialVersionUID = -8566137528932430260L;
    private String style;
    private String styleExt;
    private String styleId;
    private TemplateData templateData;
    private String templateId;
    private String templateUrl;

    public String f() {
        return this.styleId;
    }

    public String e() {
        return this.styleExt;
    }

    public void d(String str) {
        this.styleExt = str;
    }

    public String d() {
        return this.style;
    }

    public void c(String str) {
        this.style = str;
    }

    public String c() {
        return this.templateUrl;
    }

    public void b(String str) {
        this.templateUrl = str;
    }

    public TemplateData b() {
        return this.templateData;
    }

    public void a(String str) {
        this.templateId = str;
    }

    public void a(TemplateData templateData) {
        this.templateData = templateData;
    }

    public String a() {
        return this.templateId;
    }
}
