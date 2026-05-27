package ohos.ace.adapter.capability.web;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebDownloadStartObject {
    private static final String LOG_TAG = "AceWebDownloadStartObject";
    private String contentDisposition;
    private long contentLength;
    private String mimetype;
    private String url;
    private String userAgent;

    public AceWebDownloadStartObject(String str, String str2, String str3, String str4, long j) {
        this.url = str;
        this.userAgent = str2;
        this.contentDisposition = str3;
        this.mimetype = str4;
        this.contentLength = j;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public String getMimetype() {
        return this.mimetype;
    }

    public long getContentLength() {
        return this.contentLength;
    }
}
