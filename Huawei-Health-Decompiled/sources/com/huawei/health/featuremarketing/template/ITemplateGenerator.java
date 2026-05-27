package com.huawei.health.featuremarketing.template;

import com.huawei.health.marketing.datatype.ResourceBriefInfo;
import com.huawei.health.marketing.datatype.templates.BaseTemplate;

/* JADX INFO: loaded from: classes4.dex */
public interface ITemplateGenerator<T extends BaseTemplate> {
    T generate(ResourceBriefInfo resourceBriefInfo);
}
