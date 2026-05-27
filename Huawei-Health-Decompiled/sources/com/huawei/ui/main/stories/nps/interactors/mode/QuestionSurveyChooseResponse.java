package com.huawei.ui.main.stories.nps.interactors.mode;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class QuestionSurveyChooseResponse {

    @SerializedName("feedback_flag")
    private boolean feedback_flag;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("nextId")
    private Integer nextId;

    @SerializedName("remark")
    private String remark;

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public Integer getNextId() {
        return this.nextId;
    }

    public void setNextId(Integer num) {
        this.nextId = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isFeedbackFlag() {
        return this.feedback_flag;
    }

    public void setFeedbackFlag(boolean z) {
        this.feedback_flag = z;
    }
}
