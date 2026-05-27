package defpackage;

import com.huawei.haf.application.BaseApplication;
import com.huawei.health.R;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class hmx {
    public static String b() {
        int hours = new Date().getHours();
        if (hours >= 0 && hours < 5) {
            return BaseApplication.a().getResources().getString(R.string._2130845340_res_0x7f021e9c);
        }
        if (hours >= 5 && hours < 9) {
            return BaseApplication.a().getResources().getString(R.string._2130845150_res_0x7f021dde);
        }
        if (hours >= 9 && hours < 11) {
            return BaseApplication.a().getResources().getString(R.string._2130845151_res_0x7f021ddf);
        }
        if (hours >= 11 && hours < 13) {
            return BaseApplication.a().getResources().getString(R.string._2130845152_res_0x7f021de0);
        }
        if (hours >= 13 && hours < 17) {
            return BaseApplication.a().getResources().getString(R.string._2130845153_res_0x7f021de1);
        }
        if (hours >= 17 && hours < 19) {
            return BaseApplication.a().getResources().getString(R.string._2130845154_res_0x7f021de2);
        }
        if (hours >= 19 && hours < 21) {
            return BaseApplication.a().getResources().getString(R.string._2130845155_res_0x7f021de3);
        }
        if (hours >= 21) {
            return BaseApplication.a().getResources().getString(R.string._2130845340_res_0x7f021e9c);
        }
        return BaseApplication.a().getResources().getString(R.string._2130845150_res_0x7f021dde);
    }

    public static String a() {
        int hours = new Date().getHours();
        if ((hours >= 0 && hours < 5) || hours >= 21) {
            return BaseApplication.a().getResources().getString(R.string._2130845341_res_0x7f021e9d);
        }
        return BaseApplication.a().getResources().getString(R.string._2130845307_res_0x7f021e7b);
    }
}
