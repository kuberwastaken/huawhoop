package com.huawei.health.marketing.datatype;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ControlItem {
    private String buttonColor;
    private String buttonName;
    private int controlId;
    private String controlName;
    private List<ControlPic> controlPicUrlList;
    private String controlPosition;
    private int controlType;
    private String fontColor;
    private String jumpLink;
    private String previewPicUrl;

    public int getControlId() {
        return this.controlId;
    }

    public String getControlName() {
        return this.controlName;
    }

    public String getControlPosition() {
        return this.controlPosition;
    }

    public int getControlType() {
        return this.controlType;
    }

    public String getPreviewPicUrl() {
        return this.previewPicUrl;
    }

    public List<ControlPic> getControlPicUrlList() {
        return this.controlPicUrlList;
    }

    public String getButtonName() {
        return this.buttonName;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    public String getJumpLink() {
        return this.jumpLink;
    }
}
