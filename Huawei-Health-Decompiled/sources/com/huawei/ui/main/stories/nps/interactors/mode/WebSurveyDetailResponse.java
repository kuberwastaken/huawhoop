package com.huawei.ui.main.stories.nps.interactors.mode;

/* JADX INFO: loaded from: classes8.dex */
public class WebSurveyDetailResponse {
    private String responseCode;
    private ResponseData responseData;
    private String responseDesc;

    public static class ResponseData {
        private String activatedTime;
        private String firstTime;
        private String lastPushDate;
        private String model;
        private String notificationContent;
        private String notificationTitle;
        private String npsLink;
        private String pushTimes;
        private String queryTimes;
        private String surveyReqCycleTime;
        private String surveyType;
        private String topEnable;
        private int topTime;

        public String getSurveyType() {
            return this.surveyType;
        }

        public void setSurveyType(String str) {
            this.surveyType = str;
        }

        public String getTopEnable() {
            return this.topEnable;
        }

        public void setTopEnable(String str) {
            this.topEnable = str;
        }

        public String getNotificationTitle() {
            return this.notificationTitle;
        }

        public void setNotificationTitle(String str) {
            this.notificationTitle = str;
        }

        public String getPushTimes() {
            return this.pushTimes;
        }

        public void setPushTimes(String str) {
            this.pushTimes = str;
        }

        public String getQueryTimes() {
            return this.queryTimes;
        }

        public void setQueryTimes(String str) {
            this.queryTimes = str;
        }

        public int getTopTime() {
            return this.topTime;
        }

        public void setTopTime(int i) {
            this.topTime = i;
        }

        public String getNotificationContent() {
            return this.notificationContent;
        }

        public void setNotificationContent(String str) {
            this.notificationContent = str;
        }

        public String getNpsLink() {
            return this.npsLink;
        }

        public void setNpsLink(String str) {
            this.npsLink = str;
        }

        public String getSurveyReqCycleTime() {
            return this.surveyReqCycleTime;
        }

        public void setSurveyReqCycleTime(String str) {
            this.surveyReqCycleTime = str;
        }

        public String getFirstTime() {
            return this.firstTime;
        }

        public void setFirstTime(String str) {
            this.firstTime = str;
        }

        public String getActivatedTime() {
            return this.activatedTime;
        }

        public void setActivatedTime(String str) {
            this.activatedTime = str;
        }

        public String getLastPushDate() {
            return this.lastPushDate;
        }

        public void setLastPushDate(String str) {
            this.lastPushDate = str;
        }

        public String getModel() {
            return this.model;
        }

        public void setModel(String str) {
            this.model = str;
        }

        public String toString() {
            return "ResponseData{surveyType='" + this.surveyType + "', topEnable='" + this.topEnable + "', notificationTitle='" + this.notificationTitle + "', pushTimes='" + this.pushTimes + "', queryTimes='" + this.queryTimes + "', topTime=" + this.topTime + ", notificationContent='" + this.notificationContent + "', npsLink='" + this.npsLink + "', surveyReqCycleTime='" + this.surveyReqCycleTime + "', firstTime='" + this.firstTime + "', activatedTime='" + this.activatedTime + "', lastPushDate='" + this.lastPushDate + "', model='" + this.model + "'}";
        }
    }

    public String getResponseDesc() {
        return this.responseDesc;
    }

    public void setResponseDesc(String str) {
        this.responseDesc = str;
    }

    public ResponseData getResponseData() {
        return this.responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String toString() {
        return "WebSurveyDetailResponse{responseDesc='" + this.responseDesc + "', responseData=" + this.responseData + ", responseCode='" + this.responseCode + "'}";
    }
}
