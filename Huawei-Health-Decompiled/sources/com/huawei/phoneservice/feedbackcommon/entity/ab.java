package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("problemCatalogCode")
    private String f8606a;

    @SerializedName("languageCode")
    private String b;

    @SerializedName("countryCode")
    private String c;

    @SerializedName("emuiLanguageCode")
    private String d;

    @SerializedName("problemSourceCode")
    private String e;

    @SerializedName("contact")
    private String f;

    @SerializedName("attachs")
    private List<String> g;

    @SerializedName("logPath")
    private String h;

    @SerializedName("sn")
    private String i;

    @SerializedName("problemDesc")
    private String j;

    @SerializedName(FaqConstants.FAQ_SOFT_VERSION)
    private String k;

    @SerializedName("model")
    private String l;

    @SerializedName("accessToken")
    private String m;

    @SerializedName("appVersion")
    private String n;

    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String o;

    @SerializedName("uploadUrls")
    private List<FeedbackZipBean> p;

    @SerializedName("parentProblemId")
    private String q;

    @SerializedName("srno")
    private String r;

    @SerializedName("id")
    private Long s;

    @SerializedName("uniqueCode")
    private String t;

    public void t(String str) {
        this.t = str;
    }

    public void p(String str) {
        this.r = str;
    }

    public void m(String str) {
        this.k = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public void k(String str) {
        this.e = str;
    }

    public void l(String str) {
        this.j = str;
    }

    public void n(String str) {
        this.f8606a = str;
    }

    public void j(String str) {
        this.q = str;
    }

    public void g(String str) {
        this.l = str;
    }

    public void f(String str) {
        this.h = str;
    }

    public void h(String str) {
        this.b = str;
    }

    public void i(String str) {
        this.o = str;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(List<FeedbackZipBean> list) {
        this.p = list;
    }

    public void d(String str) {
        this.n = str;
    }

    public void a(List<String> list) {
        this.g = list;
    }

    public void e(String str) {
        this.m = str;
    }

    public void a(Long l) {
        this.s = l;
    }
}
