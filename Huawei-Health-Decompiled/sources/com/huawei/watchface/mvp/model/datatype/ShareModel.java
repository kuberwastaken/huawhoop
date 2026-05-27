package com.huawei.watchface.mvp.model.datatype;

import android.net.Uri;

/* JADX INFO: loaded from: classes11.dex */
public class ShareModel {
    private String imageUrl;
    private String shareContentType;
    private String shareImagePath;
    private String shareImageStr;
    private Uri shareImageUri;
    private String shareModule;
    private String shareTextContent;
    private String shareTitleContent;
    private String shareType;
    private String shareUrlContent;

    public String getShareUrlContent() {
        return this.shareUrlContent;
    }

    public void setShareUrlContent(String str) {
        this.shareUrlContent = str;
    }

    public String getShareType() {
        return this.shareType;
    }

    public void setShareType(String str) {
        this.shareType = str;
    }

    public String getShareTitleContent() {
        return this.shareTitleContent;
    }

    public void setShareTitleContent(String str) {
        this.shareTitleContent = str;
    }

    public String getShareTextContent() {
        return this.shareTextContent;
    }

    public void setShareTextContent(String str) {
        this.shareTextContent = str;
    }

    public String getShareModule() {
        return this.shareModule;
    }

    public void setShareModule(String str) {
        this.shareModule = str;
    }

    public String getShareImageStr() {
        return this.shareImageStr;
    }

    public void setShareImageStr(String str) {
        this.shareImageStr = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getShareContentType() {
        return this.shareContentType;
    }

    public void setShareContentType(String str) {
        this.shareContentType = str;
    }

    public String getShareImagePath() {
        return this.shareImagePath;
    }

    public void setShareImagePath(String str) {
        this.shareImagePath = str;
    }

    public Uri getShareImageUri() {
        return this.shareImageUri;
    }

    public void setShareImageUri(Uri uri) {
        this.shareImageUri = uri;
    }
}
