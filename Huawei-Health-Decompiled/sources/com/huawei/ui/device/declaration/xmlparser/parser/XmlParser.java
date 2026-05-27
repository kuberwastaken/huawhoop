package com.huawei.ui.device.declaration.xmlparser.parser;

import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlParser<T> {
    T parse(InputStream inputStream) throws XmlPullParserException, IOException;
}
