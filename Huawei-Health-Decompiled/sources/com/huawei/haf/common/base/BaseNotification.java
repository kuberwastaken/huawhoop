package com.huawei.haf.common.base;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.haf.application.BaseApplication;
import com.huawei.haf.application.BroadcastManager;
import health.compact.a.CommonUtils;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class BaseNotification {
    private int b;
    private int d;
    private String e;

    protected void bLx_(NotificationManager notificationManager) {
    }

    class LocaleChangedReceiver extends BroadcastReceiver {
        private LocaleChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BaseNotification.this.e();
        }
    }

    public void b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            str = "channel_common_id";
        }
        this.e = str;
        this.d = i;
        this.b = i2;
        BroadcastManager.xO_(new LocaleChangedReceiver());
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        NotificationManager notificationManagerZg_ = CommonUtils.zg_();
        if (notificationManagerZg_ == null) {
            return;
        }
        try {
            yH_(notificationManagerZg_);
        } catch (Exception e) {
            LogUtil.a("HAF_Notification", "createNotificationChannel ex=", LogUtil.c(e));
        }
        try {
            bLx_(notificationManagerZg_);
        } catch (Exception e2) {
            LogUtil.a("HAF_Notification", "deleteAllOldNotificationChannel ex=", LogUtil.c(e2));
        }
    }

    private void yH_(NotificationManager notificationManager) {
        NotificationChannel notificationChannel = new NotificationChannel(this.e, b(), this.b);
        bLy_(notificationChannel);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private String b() {
        try {
            return BaseApplication.a().getString(this.d);
        } catch (Resources.NotFoundException e) {
            LogUtil.a("HAF_Notification", "getChannelName ex=", LogUtil.c(e));
            return "channel_common_name";
        }
    }

    public void bLy_(NotificationChannel notificationChannel) {
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
    }

    public static int e(String str, String str2) {
        Resources resources = BaseApplication.a().getResources();
        int identifier = resources.getIdentifier(str, "string", BaseApplication.d());
        boolean z = identifier != 0;
        if (!z) {
            identifier = resources.getIdentifier(str2, "string", BaseApplication.d());
        }
        LogUtil.a("HAF_Notification", "channelResId=", Integer.valueOf(identifier), ", isFirstName=", Boolean.valueOf(z));
        return identifier;
    }

    public void yM_(Notification.Builder builder) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("hw_disable_ntf_delete_menu", true);
        builder.addExtras(bundle);
    }

    public Notification.Builder yJ_() {
        return new Notification.Builder(BaseApplication.a(), this.e);
    }

    public void yL_(int i, Notification notification) {
        NotificationManager notificationManagerZg_ = CommonUtils.zg_();
        if (notificationManagerZg_ != null) {
            notificationManagerZg_.notify(i, notification);
        }
    }

    public void d(int i) {
        NotificationManager notificationManagerZg_ = CommonUtils.zg_();
        if (notificationManagerZg_ != null) {
            notificationManagerZg_.cancel(i);
        }
    }

    public void d() {
        NotificationManager notificationManagerZg_ = CommonUtils.zg_();
        if (notificationManagerZg_ != null) {
            notificationManagerZg_.cancelAll();
        }
    }
}
