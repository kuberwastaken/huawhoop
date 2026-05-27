package defpackage;

import com.huawei.ui.device.declaration.xmlparser.parser.XmlParser;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes7.dex */
public class puj implements XmlParser<ptu> {
    private XmlParser<ptu> e = new pug();

    @Override // com.huawei.ui.device.declaration.xmlparser.parser.XmlParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ptu parse(InputStream inputStream) throws XmlPullParserException, IOException {
        if (inputStream == null) {
            return new ptu();
        }
        return this.e.parse(inputStream);
    }
}
