package com.huawei.health.facardagds;

/* JADX INFO: loaded from: classes9.dex */
public enum FACard {
    SPORTS_FA_CARD(FaCardAgdsApi.STEP_FA_CARD_PACKAGE_NAME, FaCardAgdsApi.FA_CARD, "com.huawei.ohos.health.FormAbility", "sports_card_medium", "2x2"),
    SPORTS_MINI_CARD(FaCardAgdsApi.STEP_FA_CARD_PACKAGE_NAME, FaCardAgdsApi.FA_CARD, "com.huawei.ohos.health.FormAbility", "sports_card_mini", "1x2"),
    FITNESS_FA_CARD(FaCardAgdsApi.FA_CARD_PACKAGE_NAME, FaCardAgdsApi.SPORT_FA_CARD, "com.huawei.ohos.healthservice.sport.FitnessCoursesFormAbility", "fitness_courses_medium", "2x2"),
    SLEEP_FA_CARD(FaCardAgdsApi.FA_CARD_PACKAGE_NAME, FaCardAgdsApi.SLEEP_FA_CARD, "com.huawei.ohos.healthservice.sleep.SleepCardAbility", "sleep_card_medium", "2x2"),
    SLEEP_MUSIC_CARD(FaCardAgdsApi.FA_CARD_PACKAGE_NAME, FaCardAgdsApi.SLEEP_FA_CARD, "com.huawei.ohos.healthservice.sleep.SleepMusicFormAbility", "sleep_music_mini", "1x2"),
    SLEEP_DATA_CARD(FaCardAgdsApi.FA_CARD_PACKAGE_NAME, FaCardAgdsApi.SLEEP_FA_CARD, "com.huawei.ohos.healthservice.sleep.SleepDataFormAbility", "sleep_data_mini", "1x2"),
    DIET_FA_CARD(FaCardAgdsApi.FA_CARD_PACKAGE_NAME, FaCardAgdsApi.DIET_FA_CARD, "com.huawei.ohos.healthservice.diet.DietDiaryMediumFormAbility", "diet_diary_medium", "2x2"),
    DIET_MINI_CARD(FaCardAgdsApi.FA_CARD_PACKAGE_NAME, FaCardAgdsApi.DIET_FA_CARD, "com.huawei.ohos.healthservice.diet.DietDiaryMiniFormAbility", "diet_diary_mini", "1x2");

    public final String mAbilityName;
    public final String mBundleName;
    public final String mDimensionName;
    public final String mFormName;
    public final String mModuleName;

    FACard(String str, String str2, String str3, String str4, String str5) {
        this.mBundleName = str;
        this.mModuleName = str2;
        this.mAbilityName = str3;
        this.mFormName = str4;
        this.mDimensionName = str5;
    }

    public static FACard get(String str) {
        for (FACard fACard : values()) {
            if (fACard.mFormName.equals(str)) {
                return fACard;
            }
        }
        return null;
    }
}
