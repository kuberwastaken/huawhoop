package com.huawei.health.marketing.datatype;

import com.huawei.health.marketing.datatype.ColumRecommendInfo;

/* JADX INFO: loaded from: classes4.dex */
public class SingleDailyMomentContent extends ColumRecommendInfo {
    public static final String ACTIVITY_TYPE = "Activity";
    public static final int BUTTON_TYPE_CUSTOM = 2;
    public static final int BUTTON_TYPE_DEFAULT = 1;
    public static final String COURSE_TYPE = "Course";
    public static final String INFORMATION_TYPE = "Information";
    public static final String SLEEP_MUSIC_TYPE = "SleepMusic";
    public static final int THEME_TYPE_CUSTOM = 2;
    public static final int THEME_TYPE_DEFAULT = 1;
    public static final String URL_TYPE = "Url";
    private String appearTime;
    private String contentId;
    private ControlItem controlItem;
    private String coverLinkType;
    private String coverLinkValue;
    private String coverPicture;
    private String customTheme;
    private String disappearTime;
    private int displayPriority;
    private String latestShowTime;
    private boolean pictureStandardTemplateSwitch;
    private String subTheme;
    private Boolean subThemeVisibility;
    private int themeType;
    private boolean themeVisibility;
    private int timeRule;

    private SingleDailyMomentContent(SingleDailyMomentContentBuilder singleDailyMomentContentBuilder) {
        super(singleDailyMomentContentBuilder);
        this.timeRule = 1;
        this.contentId = singleDailyMomentContentBuilder.contentId;
        this.coverPicture = singleDailyMomentContentBuilder.coverPicture;
        this.coverLinkType = singleDailyMomentContentBuilder.coverLinkType;
        this.coverLinkValue = singleDailyMomentContentBuilder.coverLinkValue;
        this.displayPriority = singleDailyMomentContentBuilder.displayPriority;
        this.timeRule = singleDailyMomentContentBuilder.timeRule;
        this.appearTime = singleDailyMomentContentBuilder.appearTime;
        this.disappearTime = singleDailyMomentContentBuilder.disappearTime;
        this.themeVisibility = singleDailyMomentContentBuilder.themeVisibility;
        this.themeType = singleDailyMomentContentBuilder.themeType;
        this.customTheme = singleDailyMomentContentBuilder.customTheme;
        this.subThemeVisibility = singleDailyMomentContentBuilder.subThemeVisibility;
        this.subTheme = singleDailyMomentContentBuilder.subTheme;
        this.pictureStandardTemplateSwitch = singleDailyMomentContentBuilder.pictureStandardTemplateSwitch;
        this.controlItem = singleDailyMomentContentBuilder.controlItem;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class SingleDailyMomentContentBuilder extends ColumRecommendInfo.Builder {
        private String appearTime;
        private String buttonLinkType;
        private String buttonLinkValue;
        private int buttonType;
        private boolean buttonVisibility;
        private String contentId;
        private ControlItem controlItem;
        private String coverLinkType;
        private String coverLinkValue;
        private String coverPicture;
        private String customButton;
        private String customTheme;
        private String disappearTime;
        private int displayPriority;
        private boolean pictureStandardTemplateSwitch;
        private String subTheme;
        private Boolean subThemeVisibility;
        private int themeType;
        private boolean themeVisibility;
        private int timeRule;

        public SingleDailyMomentContentBuilder setContentId(String str) {
            this.contentId = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setCoverPicture(String str) {
            this.coverPicture = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setCoverLinkType(String str) {
            this.coverLinkType = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setCoverLinkValue(String str) {
            this.coverLinkValue = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setDisplayPriority(int i) {
            this.displayPriority = i;
            return this;
        }

        public SingleDailyMomentContentBuilder setTimeRule(int i) {
            this.timeRule = i;
            return this;
        }

        public SingleDailyMomentContentBuilder setAppearTime(String str) {
            this.appearTime = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setDisappearTime(String str) {
            this.disappearTime = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setThemeVisibility(boolean z) {
            this.themeVisibility = z;
            return this;
        }

        public SingleDailyMomentContentBuilder setThemeType(int i) {
            this.themeType = i;
            return this;
        }

        public SingleDailyMomentContentBuilder setCustomTheme(String str) {
            this.customTheme = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setSubThemeVisibility(Boolean bool) {
            this.subThemeVisibility = bool;
            return this;
        }

        public SingleDailyMomentContentBuilder setSubTheme(String str) {
            this.subTheme = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setButtonVisibility(boolean z) {
            this.buttonVisibility = z;
            return this;
        }

        public SingleDailyMomentContentBuilder setButtonType(int i) {
            this.buttonType = i;
            return this;
        }

        public SingleDailyMomentContentBuilder setCustomButton(String str) {
            this.customButton = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setButtonLinkType(String str) {
            this.buttonLinkType = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setButtonLinkValue(String str) {
            this.buttonLinkValue = str;
            return this;
        }

        public SingleDailyMomentContentBuilder setPictureStandardTemplateSwitch(boolean z) {
            this.pictureStandardTemplateSwitch = z;
            return this;
        }

        public SingleDailyMomentContentBuilder setControlItem(ControlItem controlItem) {
            this.controlItem = controlItem;
            return this;
        }

        @Override // com.huawei.health.marketing.datatype.ColumRecommendInfo.Builder
        public SingleDailyMomentContent build() {
            return new SingleDailyMomentContent(this);
        }
    }

    public String getContentId() {
        return this.contentId;
    }

    public String getCoverPicture() {
        return this.coverPicture;
    }

    public String getCoverLinkType() {
        return this.coverLinkType;
    }

    public String getCoverLinkValue() {
        return this.coverLinkValue;
    }

    public int getDisplayPriority() {
        return this.displayPriority;
    }

    public int getTimeRule() {
        return this.timeRule;
    }

    public String getAppearTime() {
        return this.appearTime;
    }

    public String getDisappearTime() {
        return this.disappearTime;
    }

    public boolean getThemeVisibility() {
        return this.themeVisibility;
    }

    public int getThemeType() {
        return this.themeType;
    }

    public String getCustomTheme() {
        return this.customTheme;
    }

    public Boolean getSubThemeVisibility() {
        return this.subThemeVisibility;
    }

    public String getSubTheme() {
        return this.subTheme;
    }

    public String getLatestShowTime() {
        return this.latestShowTime;
    }

    public void setLatestShowTime(String str) {
        this.latestShowTime = str;
    }

    public boolean isPictureStandardTemplateSwitch() {
        return this.pictureStandardTemplateSwitch;
    }

    public ControlItem getControlItem() {
        return this.controlItem;
    }

    @Override // com.huawei.health.marketing.datatype.ColumRecommendInfo
    public String toString() {
        return "SingleDailyMomentContent{contentId='" + this.contentId + "', coverPicture='" + this.coverPicture + "', coverLinkType='" + this.coverLinkType + "', coverLinkValue='" + this.coverLinkValue + "', displayPriority=" + this.displayPriority + ", timeRule=" + this.timeRule + ", appearTime='" + this.appearTime + "', disappearTime='" + this.disappearTime + "', themeVisibility=" + this.themeVisibility + ", themeType=" + this.themeType + ", customTheme='" + this.customTheme + "', subThemeVisibility=" + this.subThemeVisibility + ", subTheme='" + this.subTheme + "', pictureStandardTemplateSwitch='" + this.pictureStandardTemplateSwitch + "', latestShowTime='" + this.latestShowTime + '\'' + super.toString() + '}';
    }
}
