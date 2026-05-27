package ohos.ace.adapter.capability.web;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebRefreshAccessedHistoryObject {
    private static final String LOG_TAG = "AceWebRefreshAccessedHistoryObject";
    private boolean isRefreshed;
    private String url;

    public AceWebRefreshAccessedHistoryObject(String str, boolean z) {
        this.url = str;
        this.isRefreshed = z;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean getIsRefreshed() {
        return this.isRefreshed;
    }
}
