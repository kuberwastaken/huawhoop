package com.huawei.ui.main.stories.nps.interactors.cache;

import com.huawei.ui.main.stories.nps.interactors.mode.QuestionSureyResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class QuestionCache {
    private static String sNpsLink;
    private static List<QuestionSureyResponse> sQuestions = new ArrayList(16);

    private QuestionCache() {
    }

    public static List<QuestionSureyResponse> getQuestions() {
        return sQuestions;
    }

    public static void setQuestions(List<QuestionSureyResponse> list) {
        sQuestions = list;
    }

    public static String getNpsLink() {
        return sNpsLink;
    }

    public static void setNpsLink(String str) {
        sNpsLink = str;
    }
}
