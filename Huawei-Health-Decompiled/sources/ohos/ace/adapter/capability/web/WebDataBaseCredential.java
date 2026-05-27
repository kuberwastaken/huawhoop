package ohos.ace.adapter.capability.web;

/* JADX INFO: loaded from: classes11.dex */
public class WebDataBaseCredential {
    private Long httpAuthId;
    private Long id;
    private String password;
    private String username;

    public WebDataBaseCredential(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public WebDataBaseCredential(Long l, String str, String str2, Long l2) {
        this.id = l;
        this.username = str;
        this.password = str2;
        this.httpAuthId = l2;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public Long getHttpAuthId() {
        return this.httpAuthId;
    }

    public void setHttpAuthId(Long l) {
        this.httpAuthId = l;
    }
}
