package defpackage;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.ui.main.R$string;
import com.huawei.ui.main.stories.configuredpage.ConfiguredFlagInterface;

/* JADX INFO: loaded from: classes7.dex */
public class slu implements ConfiguredFlagInterface {
    @Override // com.huawei.ui.main.stories.configuredpage.ConfiguredFlagInterface
    public String getConfiguredContents(String str) {
        return "sleep_heartHealth".equals(str) ? BaseApplication.getContext().getResources().getString(R$string.IDS_health_heart_study_app_install_tips) : "";
    }
}
