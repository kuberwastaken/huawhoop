package com.huawei.health.h5pro.jsbridge.system.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.health.h5pro.utils.LogUtil;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class AudioManagerApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioVolumeChangeReceiver f2482a;
    public final Context c;
    public AudioManager d;

    public interface AudioVolumeListener {
        void onFailure(int i, String str);

        void onSuccess(int i, int i2, int i3);
    }

    public void unRegisterAudioVolumeChangeListener() {
        AudioVolumeChangeReceiver audioVolumeChangeReceiver;
        Context context = this.c;
        if (context != null && (audioVolumeChangeReceiver = this.f2482a) != null) {
            context.unregisterReceiver(audioVolumeChangeReceiver);
        }
        this.f2482a = null;
    }

    public void setAudioVolume(String str, int i, AudioVolumeListener audioVolumeListener) {
        AudioTypeEnum audioTypeEnumC = c(str);
        if (audioTypeEnumC == null) {
            audioVolumeListener.onFailure(-1, String.format(Locale.ENGLISH, "setAudioVolume: Invalid parameter '%s'", str));
        } else {
            this.d.setStreamVolume(audioTypeEnumC.audioType, Math.min(i, this.d.getStreamMaxVolume(audioTypeEnumC.audioType)), 0);
            c(audioTypeEnumC, audioVolumeListener);
        }
    }

    public void registerAudioVolumeChangeListener(String str, AudioVolumeListener audioVolumeListener) {
        unRegisterAudioVolumeChangeListener();
        AudioTypeEnum audioTypeEnumC = c(str);
        if (audioTypeEnumC == null) {
            audioVolumeListener.onFailure(-1, String.format(Locale.ENGLISH, "registerAudioVolumeChangeListener: Invalid parameter '%s'", str));
            return;
        }
        if (this.c == null) {
            LogUtil.w("H5PRO_AudioManagerApi", "registerAudioVolumeChangeListener: mContext is null");
            return;
        }
        c(audioTypeEnumC, audioVolumeListener);
        AudioVolumeChangeReceiver audioVolumeChangeReceiver = new AudioVolumeChangeReceiver(audioTypeEnumC, audioVolumeListener);
        this.f2482a = audioVolumeChangeReceiver;
        this.c.registerReceiver(audioVolumeChangeReceiver, new IntentFilter(Constants.VOLUME_CHANGED_ACTION));
    }

    public void getAudioVolume(String str, AudioVolumeListener audioVolumeListener) {
        AudioTypeEnum audioTypeEnumC = c(str);
        if (audioTypeEnumC == null) {
            audioVolumeListener.onFailure(-1, String.format(Locale.ENGLISH, "getAudioVolume: Invalid parameter '%s'", str));
        } else {
            c(audioTypeEnumC, audioVolumeListener);
        }
    }

    public enum AudioTypeEnum {
        AUDIO_TYPE_MUSIC(3),
        AUDIO_TYPE_RING(2),
        AUDIO_TYPE_SYSTEM(1),
        AUDIO_TYPE_ALARM(4),
        AUDIO_TYPE_NOTIFICATION(5),
        AUDIO_TYPE_VOICE_CALL(0);

        public final int audioType;

        AudioTypeEnum(int i) {
            this.audioType = i;
        }
    }

    private AudioTypeEnum c(String str) {
        try {
            return AudioTypeEnum.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public class AudioVolumeChangeReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioTypeEnum f2483a;
        public final AudioVolumeListener d;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (!TextUtils.equals(action, Constants.VOLUME_CHANGED_ACTION)) {
                LogUtil.w("H5PRO_AudioManagerApi", "onReceive: action -> " + action);
                return;
            }
            int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            AudioTypeEnum audioTypeEnum = this.f2483a;
            if (audioTypeEnum == null || intExtra != audioTypeEnum.audioType) {
                LogUtil.w("H5PRO_AudioManagerApi", "onReceive: audioType -> " + intExtra);
            } else {
                AudioVolumeListener audioVolumeListener = this.d;
                if (audioVolumeListener != null) {
                    AudioManagerApi.this.c(this.f2483a, audioVolumeListener);
                }
            }
        }

        public AudioVolumeChangeReceiver(AudioTypeEnum audioTypeEnum, AudioVolumeListener audioVolumeListener) {
            this.f2483a = audioTypeEnum;
            this.d = audioVolumeListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AudioTypeEnum audioTypeEnum, AudioVolumeListener audioVolumeListener) {
        AudioManager audioManager = this.d;
        if (audioManager == null) {
            LogUtil.w("H5PRO_AudioManagerApi", "mAudioManager is null");
        } else {
            audioVolumeListener.onSuccess(audioManager.getStreamVolume(audioTypeEnum.audioType), this.d.getStreamMaxVolume(audioTypeEnum.audioType), Build.VERSION.SDK_INT >= 28 ? this.d.getStreamMinVolume(audioTypeEnum.audioType) : 0);
        }
    }

    public AudioManagerApi(Context context) {
        this.d = null;
        this.c = context;
        AudioManager audioManager = (AudioManager) context.getSystemService(AudioManager.class);
        this.d = audioManager;
        if (audioManager == null) {
            this.d = (AudioManager) context.getSystemService("audio");
        }
    }
}
