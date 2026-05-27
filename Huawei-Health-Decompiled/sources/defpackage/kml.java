package defpackage;

import com.huawei.common.util.Utils;
import com.huawei.health.ecologydevice.networkclient.HealthEngineRequestManager;
import com.huawei.login.ui.login.LoginInit;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class kml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f14757a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f14757a = map;
        map.put("healthRecommendUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("activityUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("messageCenterUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("sportSuggestUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("achievementUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("healthCloudUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("socialCloudUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("socialCloudProfileUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("socialCloudRankUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("healthDeviceUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("healthAPPToDeviceUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("hilinkDevicePrimaryCloudUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("hilinkDeviceStandbyCloudUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("tradeService", Utils.SERVICE_HEALTH_CLOUD);
        map.put("healthcare", Utils.SERVICE_HEALTH_CLOUD);
        map.put("healthOperationUrl", Utils.SERVICE_HEALTH_CLOUD);
        map.put("healthOperationUrlCn", Utils.SERVICE_HEALTH_CLOUD);
        map.put("knowledgeUrl", "com.huawei.health");
        map.put("knowledgeContextUrl", "com.huawei.health");
        map.put("materialUrl", "com.huawei.health");
        map.put(HealthEngineRequestManager.GRS_KEY, "com.huawei.health");
        map.put("agreementservice", "com.huawei.health");
        map.put("biOperation", "com.huawei.health");
        map.put("getLatestVersion", "com.huawei.health");
        map.put("userInfoAgreement", "com.huawei.health");
        map.put("newVersionUrl", "com.huawei.health");
        map.put("getToken", "com.huawei.health");
        map.put("getBatchPluginUrl", "com.huawei.health");
        map.put("getAgnssPluginUrl", "com.huawei.health");
        map.put("getNewBatchPluginUrl", "com.huawei.health");
        map.put("watchFace", "com.huawei.health.watchface");
        map.put("watchFaceH5", "com.huawei.health.watchface");
        map.put("Music", "com.huawei.cloud.music");
        map.put("domainResourcephsVmall", "com.huawei.health");
        map.put("domainVenusVmall", "com.huawei.health");
        map.put("domainContentcenterDbankcdn", "com.huawei.health");
        map.put("domainContentcenterDbankcdnNew", "com.huawei.health");
        map.put("domainPassWalletHicloud", "com.huawei.health");
        map.put("domainNjtestlf2Hwcloudtest", "com.huawei.health");
        map.put("domainVcardmgtWalletHicloud", "com.huawei.health");
        map.put("domainNjtestlf2Hwcloudtest", "com.huawei.health");
        map.put("domainTsmHicloud", "com.huawei.health");
        map.put("domainLfpaytest01Hwcloudtest", "com.huawei.health");
        map.put("domainHealthVmall", "com.huawei.health");
        map.put("domainAVmall", "com.huawei.health");
        map.put("domainHealthrecommendHicloud", "com.huawei.health");
        map.put("domainUrlCloudHuawei", "com.huawei.health");
        map.put("domainUrlDreCloudHuawei", "com.huawei.health");
        map.put("domainApiVmall", "com.huawei.health");
        map.put("domainHwidVmall", "com.huawei.health");
        map.put("domainMVmall", "com.huawei.health");
        map.put("domainMVmallDetail", "com.huawei.health");
        map.put("domainSearchVmallDetail", "com.huawei.health");
        map.put("domainSearchVmallImg", "com.huawei.health");
        map.put("domainGlobalSearch", "com.huawei.health");
        map.put("domainOpenapiVmall", "com.huawei.health");
        map.put("domainOpenapiSitVmall", "com.huawei.health");
        map.put("domainWwwHuawei", "com.huawei.health");
        map.put("domainCcpceConsumerHuawei", "com.huawei.health");
        map.put("domainSettingHicloud", "com.huawei.health");
        map.put("domainTsmServiceHicloud", "com.huawei.health");
        map.put("marketingUrl", "com.huawei.health");
        map.put("marketingGateWayUrl", "com.huawei.health");
        map.put("knitRequest", "com.huawei.health");
        map.put("domainThemeCloud", "com.huawei.health");
        map.put("hiCloudUrl", "com.huawei.health");
        map.put("domainClubHuawei", "com.huawei.health");
        map.put("domainCnClubVmall", "com.huawei.health");
        map.put("domainMessagecenterHicloud", "com.huawei.health");
        map.put("domainMessagecenterHicloudNew", "com.huawei.health");
        map.put("domainAppgalleryCloudHuawei", "com.huawei.health");
        map.put("domainWapHispaceHicloud", "com.huawei.health");
        map.put("domainTipsResDbankcdn", "com.huawei.health");
        map.put("domainSmarthomeHicloud", "com.huawei.health");
        map.put("appMarketUrl", "com.huawei.health");
        map.put("appMarketRequestUrl", "com.huawei.health");
        map.put("appMarketH5Url", "com.huawei.health");
        map.put("appMarketCloudUrl", "com.huawei.health");
        map.put("domainLogserviceHicloud", "com.huawei.health");
        map.put("domainLogtransformHicloud", "com.huawei.health");
        map.put("domainCcpcConsumerHuawei", "com.huawei.health");
        map.put("domainSgwCcpcHuawei", "com.huawei.health");
        map.put("domainPasscommonDrcnWalletHicloud", "com.huawei.health");
        map.put("domainConsumerHuawei", "com.huawei.health");
        map.put("domainPrivacyLegalCloudHuawei", "com.huawei.health");
        map.put("domainPrivacyConsumerHuawei", "com.huawei.health");
        map.put("domainLegalCloudHuawei", "com.huawei.health");
        map.put("domainTipsResDbankcdn", "com.huawei.health");
        map.put("domainHealthcommonHicloud", "com.huawei.health");
        map.put("domainSnsHicloud", "com.huawei.health");
        map.put("domainImHicloud", "com.huawei.health");
        map.put("domainCisHicloud", "com.huawei.health");
        map.put("domainQueryHicloud", "com.huawei.health");
        map.put("domainNfcwsHicloud", "com.huawei.health");
        map.put("domainHagHicloud", "com.huawei.health");
        map.put("weatherKitUrl", "com.huawei.health");
        map.put("domainScopeOauth", "com.huawei.health");
        map.put("ROOT", "com.huawei.cloud.hota");
        map.put("helpCustomerUrl", "com.huawei.health");
        map.put("domainKlgMapDtlUrl", "com.huawei.health");
        map.put("SITEID", Utils.HEALTH_OVER_SEA_BETA);
        map.put("SITEID", Utils.HEALTH_OVER_SEA);
        map.put("domainHealthCloudCommon", "com.huawei.health");
        map.put("enterpriseUrl", "com.huawei.health");
        map.put("domainTipsResDbankcdnNew", "com.huawei.health");
        map.put("domainSportrankingHicloud", "com.huawei.health");
        map.put("domainAccessTokenUrl", "com.huawei.health");
        map.put("domainOAuthLogin", "com.huawei.health");
        map.put("domainComplaintCenterUrl", "com.huawei.health");
        map.put("domainHealthdataHicloud", "com.huawei.health");
        map.put("domainQrcodeMatchRules", "com.huawei.health");
        map.put("domainHuafenUrl", "com.huawei.health");
        map.put("domainbroadoldurl", "com.huawei.health");
        map.put("domainbroadnewurl", "com.huawei.health");
        map.put("userAgreementDomain", "com.huawei.health");
        map.put("psiUploadUrl", "com.huawei.health");
        map.put("domainMyHuawei", "com.huawei.health");
        map.put("domainMyHuaweiUpLogin", "com.huawei.health");
        map.put("domainMyHuaweiOauthLogin", "com.huawei.health");
        map.put("recordNumberQueryUrl", "com.huawei.health");
        map.put("domainSportsuggestHicloud", "com.huawei.health");
        map.put("crowdTestUrl", "com.huawei.health");
        map.put("SITE_SERVER", "hiwalletServices");
        map.put("domainTipsKeepAlive", "com.huawei.health");
    }

    public static String a(String str) {
        return f14757a.get(str);
    }

    public static String a(String str, String str2) {
        String strA = a(str);
        if (!c(str, str2)) {
            return strA;
        }
        return strA + Utils.KOREA_SUFFIX;
    }

    public static boolean c(String str, String str2) {
        boolean zEquals = LoginInit.KOREA.equals(str2);
        String str3 = f14757a.get(str);
        return zEquals && (Utils.SERVICE_HEALTH_CLOUD.equals(str3) || "com.huawei.health".equals(str3) || Utils.HEALTH_OVER_SEA_BETA.equals(str3) || Utils.HEALTH_OVER_SEA.equals(str3));
    }
}
