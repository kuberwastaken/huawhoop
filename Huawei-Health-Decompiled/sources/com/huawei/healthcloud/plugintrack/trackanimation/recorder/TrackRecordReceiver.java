package com.huawei.healthcloud.plugintrack.trackanimation.recorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.haf.localbroadcastmanager.LocalBroadcastManager;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;

/* JADX INFO: loaded from: classes5.dex */
public class TrackRecordReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IntentFilter f3698a;
    private TrackRecordListener b;
    private Context e;

    public interface TrackRecordListener {
        void onRecordFinish(long j, boolean z);

        void onRecordStart();
    }

    public TrackRecordReceiver(Context context) {
        this.e = context;
    }

    public void c(Context context, TrackRecordListener trackRecordListener) {
        this.b = trackRecordListener;
        IntentFilter intentFilter = new IntentFilter();
        this.f3698a = intentFilter;
        intentFilter.addAction("sta_track_record_start");
        this.f3698a.addAction("sta_track_record_finish");
        LocalBroadcastManager.getInstance().unregisterReceiver(this);
        LocalBroadcastManager.getInstance().registerReceiver(this, this.f3698a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            ReleaseLogUtil.c("Suggestion_TrackRecordReceiver", "onReceive: intent is null");
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            ReleaseLogUtil.c("Suggestion_TrackRecordReceiver", "onReceive: action is empty");
            return;
        }
        if (this.b == null) {
            ReleaseLogUtil.c("Suggestion_TrackRecordReceiver", "onReceive: listener is null");
            return;
        }
        ReleaseLogUtil.d("Suggestion_TrackRecordReceiver", "onReceive: action is ", action);
        action.hashCode();
        if (action.equals("sta_track_record_finish")) {
            this.b.onRecordFinish(intent.getLongExtra("data_key_video_duration", 0L), intent.getBooleanExtra("data_key_video_record_error", false));
        } else if (action.equals("sta_track_record_start")) {
            this.b.onRecordStart();
        }
    }

    public void d() {
        LocalBroadcastManager.getInstance().unregisterReceiver(this);
        this.e = null;
    }

    public void e() {
        if (this.e != null) {
            LocalBroadcastManager.getInstance().sendBroadcast(new Intent("ats_track_record_stop"));
        }
    }

    public void b() {
        if (this.e != null) {
            LocalBroadcastManager.getInstance().sendBroadcast(new Intent("ats_track_record_stop_when_pause"));
        }
    }
}
