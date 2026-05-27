package ohos.ace.adapter.capability.web;

/* JADX INFO: loaded from: classes11.dex */
public class WebDataBaseHttpAuth {
    private String host;
    private Long id;
    private String realm;

    public WebDataBaseHttpAuth(String str, String str2) {
        this.host = str;
        this.realm = str2;
    }

    public WebDataBaseHttpAuth(Long l, String str, String str2) {
        this.id = l;
        this.host = str;
        this.realm = str2;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public String getRealm() {
        return this.realm;
    }

    public void setRealm(String str) {
        this.realm = str;
    }
}
