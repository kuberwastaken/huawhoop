package defpackage;

import android.text.TextUtils;
import com.huawei.multisimsdk.odsa.response.OdsaResponseParam;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class mzz {
    public static OdsaResponseParam e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        mza.e("OdsaResolveXmlParser", "readResponseFromServer start.");
        if (xmlPullParser == null) {
            mza.c("OdsaResolveXmlParser", "readResponseFromServer parser is null.");
            return null;
        }
        int eventType = xmlPullParser.getEventType();
        OdsaResponseParam odsaResponseParam = new OdsaResponseParam();
        while (eventType != 1) {
            if (eventType == 0) {
                mza.a("OdsaResolveXmlParser", "readResponseFromServer start document");
            } else if (eventType == 2) {
                d(xmlPullParser, odsaResponseParam);
            }
            eventType = xmlPullParser.next();
        }
        mza.e("OdsaResolveXmlParser", odsaResponseParam.toString());
        return odsaResponseParam;
    }

    private static void d(XmlPullParser xmlPullParser, OdsaResponseParam odsaResponseParam) throws XmlPullParserException, IOException {
        int attributeCount = xmlPullParser.getAttributeCount();
        if (attributeCount < 2) {
            mza.c("OdsaResolveXmlParser", "other type");
            return;
        }
        mza.e("OdsaResolveXmlParser", "getEventInfo, count=" + attributeCount);
        String attributeValue = xmlPullParser.getAttributeValue(0);
        String attributeValue2 = xmlPullParser.getAttributeValue(1);
        mza.a("OdsaResolveXmlParser", "key=" + attributeValue + ",value=", attributeValue2);
        if ("version".equals(attributeValue)) {
            odsaResponseParam.setVersion(attributeValue2);
            return;
        }
        if ("validity".equals(attributeValue)) {
            odsaResponseParam.setValidity(attributeValue2);
            return;
        }
        if ("token".equals(attributeValue)) {
            odsaResponseParam.setToken(attributeValue2);
            if (TextUtils.isEmpty(attributeValue2)) {
                return;
            }
            nan.c(attributeValue2);
            return;
        }
        if ("AppID".equals(attributeValue)) {
            odsaResponseParam.setAppId(attributeValue2);
            return;
        }
        if ("OperationResult".equals(attributeValue)) {
            odsaResponseParam.setOperationResult(Integer.parseInt(attributeValue2));
            return;
        }
        if ("CompanionAppEligibility".equals(attributeValue)) {
            odsaResponseParam.setCompanionAppEligibility(attributeValue2);
            odsaResponseParam.setOperationType(nao.e[0]);
            return;
        }
        if ("CompanionDeviceServices".equals(attributeValue)) {
            odsaResponseParam.setCompanionDeviceServices(attributeValue2);
            return;
        }
        if ("NotEnabledURL".equals(attributeValue)) {
            odsaResponseParam.setNotEnabledUrl(attributeValue2);
            return;
        }
        if ("NotEnabledUserData".equals(attributeValue)) {
            odsaResponseParam.setNotEnabledUserData(attributeValue2);
            return;
        }
        if ("NotEnabledContentsType".equals(attributeValue)) {
            odsaResponseParam.setNotEnabledContentsType(attributeValue2);
            return;
        }
        if ("ICCID".equals(attributeValue)) {
            odsaResponseParam.setIccid(attributeValue2);
            odsaResponseParam.setOperationType(nao.e[3]);
            return;
        }
        if ("CompanionDeviceService".equals(attributeValue)) {
            odsaResponseParam.setCompanionDeviceServices(attributeValue2);
            return;
        }
        if ("ServiceStatus".equals(attributeValue)) {
            odsaResponseParam.setServiceStatus(attributeValue2);
            return;
        }
        if ("SubscriptionServiceURL".equals(attributeValue)) {
            odsaResponseParam.setSubscriptionServiceUrl(attributeValue2);
            odsaResponseParam.setOperationType(nao.e[1]);
            return;
        }
        if ("SubscriptionServiceUserData".equals(attributeValue)) {
            odsaResponseParam.setSubscriptionServiceUserData(attributeValue2);
            return;
        }
        if ("SubscriptionServiceContentsType".equals(attributeValue)) {
            odsaResponseParam.setsubscriptionServiceContentsType(attributeValue2);
            return;
        }
        if ("SubscriptionResult".equals(attributeValue)) {
            odsaResponseParam.setSubscriptionResult(Integer.parseInt(attributeValue2));
            return;
        }
        if ("ProfileSmdpAddress".equals(attributeValue)) {
            odsaResponseParam.setProfileSmdpAddress(attributeValue2);
            odsaResponseParam.setOperationType(nao.e[1]);
            return;
        }
        if ("ProfileActivationCode".equals(attributeValue)) {
            odsaResponseParam.setProfileActivationCode(attributeValue2);
            return;
        }
        if ("PollingInterval".equals(attributeValue)) {
            mza.e("OdsaResolveXmlParser", "OdsaHttpConnectionUtils.POLLING_INTERVAL equals name");
            odsaResponseParam.setPollingInterval(Integer.parseInt(attributeValue2));
            odsaResponseParam.setOperationType(nao.e[5]);
        } else if (Constants.NONCE.equals(attributeValue)) {
            odsaResponseParam.setNonce(attributeValue2);
        } else {
            mza.a("OdsaResolveXmlParser", "invalid type");
        }
    }
}
