package ohos.ace.adapter.capability.web;

/* JADX INFO: loaded from: classes11.dex */
public class WebDataBaseGeolocationPermissions {
    private Long _id;
    private String origin;
    private Integer result;

    public WebDataBaseGeolocationPermissions(String str, Integer num) {
        this.origin = str;
        this.result = num;
    }

    public WebDataBaseGeolocationPermissions(Long l, String str, Integer num) {
        this._id = l;
        this.origin = str;
        this.result = num;
    }

    public Long getId() {
        return this._id;
    }

    public void setId(Long l) {
        this._id = l;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer num) {
        this.result = num;
    }

    public String toString() {
        return "WebDataBaseGeolocationPermissions{_id=" + this._id + ", origin='" + this.origin + "', result=" + this.result + '}';
    }
}
