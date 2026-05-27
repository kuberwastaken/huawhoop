package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit;

import android.net.Uri;
import com.huawei.watchface.utils.HwLog;

/* JADX INFO: loaded from: classes6.dex */
public final class VideoEditorJumper {
    private static final String DURATION = "duration";
    private static final String END = "end";
    public static final String INPUT_FILE_PATH = "input-file-path";
    private static final int ORIGIN_VALUE = -1;
    private static final String START = "start";
    private static final String TAG = "VideoEditorJumper";
    private static final String TYPE = "type";
    private static final String VIDEO = "video";
    private static final String VIDEO_SCHEME = "video.edit";

    private VideoEditorJumper() {
    }

    public static Uri.Builder append(Uri.Builder builder, int i, int i2, int i3) {
        if (builder == null) {
            HwLog.e(TAG, "in append : builder is null");
            return new Uri.Builder();
        }
        if (i >= 0) {
            builder.appendQueryParameter("start", String.valueOf(i));
        }
        if (i2 >= 0) {
            builder.appendQueryParameter("end", String.valueOf(i2));
        }
        if (i3 >= 0) {
            builder.appendQueryParameter("duration", String.valueOf(i3));
        }
        return builder;
    }

    public static Uri genVideoUri(String str) {
        return genVideoUri(str, -1);
    }

    public static Uri genVideoUri(String str, int i) {
        return genVideoUri(str, -1, -1, i);
    }

    public static Uri genVideoUri(String str, int i, int i2, int i3) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(VIDEO_SCHEME);
        builder.authority(str);
        builder.appendQueryParameter("type", "video");
        if (i >= 0) {
            builder.appendQueryParameter("start", String.valueOf(i));
        }
        if (i2 >= 0) {
            builder.appendQueryParameter("end", String.valueOf(i2));
        }
        if (i3 >= 0) {
            builder.appendQueryParameter("duration", String.valueOf(i3));
        }
        return builder.build();
    }
}
