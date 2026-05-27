package defpackage;

import android.text.TextUtils;
import android.util.Xml;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.ui.device.declaration.xmlparser.parser.XmlParser;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes7.dex */
public class pug implements XmlParser<ptu> {
    private XmlPullParser c;

    @Override // com.huawei.ui.device.declaration.xmlparser.parser.XmlParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ptu parse(InputStream inputStream) throws XmlPullParserException, IOException {
        if (inputStream == null) {
            throw new NullPointerException("parameter 'xmlInputStream' is null.");
        }
        a(inputStream);
        ptu ptuVarC = c();
        inputStream.close();
        return ptuVarC;
    }

    private ptu c() throws XmlPullParserException, IOException {
        ptu ptuVar = new ptu();
        int eventType = this.c.getEventType();
        String text = "";
        String attributeValue = "";
        while (eventType != 1) {
            String name = this.c.getName();
            if (eventType == 0) {
                LogUtil.b("ResourceParserImpl", "parse xml begin.");
            } else if (eventType != 2) {
                if (eventType == 3) {
                    LogUtil.b("ResourceParserImpl", "parse xml end.");
                    text = null;
                    attributeValue = null;
                } else if (eventType == 4) {
                    boolean z = !TextUtils.isEmpty(attributeValue);
                    if (z) {
                        text = this.c.getText();
                    }
                    boolean zIsEmpty = TextUtils.isEmpty(text);
                    if (z && (!zIsEmpty)) {
                        ptuVar.c(attributeValue, text);
                    }
                } else {
                    LogUtil.b("ResourceParserImpl", "default case.");
                }
            } else if ("string".equals(name)) {
                attributeValue = this.c.getAttributeValue(0);
            }
            eventType = this.c.next();
        }
        return ptuVar;
    }

    private void a(InputStream inputStream) throws XmlPullParserException {
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        this.c = xmlPullParserNewPullParser;
        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        this.c.setInput(inputStream, "UTF-8");
    }
}
