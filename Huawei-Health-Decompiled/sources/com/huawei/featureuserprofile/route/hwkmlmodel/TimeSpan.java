package com.huawei.featureuserprofile.route.hwkmlmodel;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.featureuserprofile.route.hwgpxmodel.xmlparser.Ignore;
import com.huawei.featureuserprofile.route.hwgpxmodel.xmlparser.Tag;
import com.huawei.route.utils.RouteSourceUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TimeSpan {

    @Ignore
    private long mBegin;

    @Ignore
    private long mEnd;

    @Tag("begin")
    private String mStringBegin;

    @Tag(order = 1, value = TtmlNode.END)
    private String mStringEnd;

    public void setBegin(long j) {
        this.mBegin = j;
        this.mEnd = j;
        String strLongTimeToString = longTimeToString(j);
        this.mStringBegin = strLongTimeToString;
        this.mStringEnd = strLongTimeToString;
    }

    public long getBegin() {
        return this.mBegin;
    }

    private String longTimeToString(long j) {
        return RouteSourceUtils.longTimeToString(j);
    }

    public String getStringBegin() {
        return this.mStringBegin;
    }

    public String getStringEnd() {
        return this.mStringEnd;
    }
}
