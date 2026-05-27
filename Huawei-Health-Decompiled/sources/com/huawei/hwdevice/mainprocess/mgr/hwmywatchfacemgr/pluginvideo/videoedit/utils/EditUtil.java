package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import androidx.media3.common.MimeTypes;
import com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.mmedit.EmuiUtils;
import com.huawei.secure.android.common.util.SafeString;
import com.huawei.watchface.utils.HwLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class EditUtil {
    private static final long MAX_FILE_SIZE = 4294967295L;
    private static final long MIN_FILE_SIZE = 0;
    private static final String TAG = "EditUtil";
    private static final ArrayList VALID_AUDIO_MIMES = new ArrayList(Arrays.asList(MimeTypes.AUDIO_AAC, MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_AMR_NB));
    private static final ArrayList VALID_VIDEO_MIMES = new ArrayList(Arrays.asList(MimeTypes.VIDEO_H264, MimeTypes.VIDEO_H265, MimeTypes.VIDEO_MP4V));
    private static final ArrayList VALID_FILE_EXTENSIONS = new ArrayList(Arrays.asList("3g2", "3gp", "mp4", "m4v", "mkv", "mov"));

    protected static String getFileExt(String str) {
        String lowerCase = new File(str).getName().toLowerCase(Locale.ENGLISH);
        return SafeString.substring(lowerCase, lowerCase.lastIndexOf(".") + 1);
    }

    protected static boolean isSupportFileExtensions(String str) {
        if (VALID_FILE_EXTENSIONS.contains(str)) {
            return true;
        }
        HwLog.e(TAG, "isSupportFileExtensions --- " + str + " not valid format");
        return false;
    }

    protected static long getFileSize(String str) {
        return new File(str).length();
    }

    public boolean isSupportFormat(String str) {
        HwLog.i(TAG, "isSupportFormat file ");
        if (!isSupportFileExtensions(getFileExt(str))) {
            HwLog.e(TAG, "isSupportFormat --- not valid format");
            return false;
        }
        long fileSize = getFileSize(str);
        HwLog.i(TAG, "input file size is " + fileSize);
        HwLog.i(TAG, "input file max size is 4294967295");
        if (fileSize <= 4294967295L && fileSize > 0) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                if (trackCount <= 0) {
                    HwLog.e(TAG, "isSupportFormat --- Extractor parse failed.");
                    mediaExtractor.release();
                    return false;
                }
                MediaFormat mediaFormat = null;
                String str2 = "";
                String str3 = str2;
                MediaFormat mediaFormat2 = null;
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime")) {
                        String string = trackFormat.getString("mime");
                        HwLog.i(TAG, "isSupportFormat --- mime:" + string);
                        if (string.startsWith("audio/")) {
                            mediaFormat2 = trackFormat;
                            str2 = string;
                        } else if (!string.startsWith("video/")) {
                            continue;
                        } else {
                            if (!isSupportVideoSize(MimeTypes.VIDEO_H264, trackFormat.getInteger("width"), trackFormat.getInteger("height"))) {
                                return false;
                            }
                            if (mediaFormat != null) {
                                mediaExtractor.release();
                                return false;
                            }
                            mediaFormat = trackFormat;
                            str3 = string;
                        }
                    }
                }
                mediaExtractor.release();
                if (mediaFormat == null) {
                    HwLog.e(TAG, "isSupportFormat --- no valid video track");
                    return false;
                }
                if (mediaFormat2 != null) {
                    if (!isSupportAudioMime(mediaFormat2, str2)) {
                        HwLog.e(TAG, "isSupportFormat --- media mime not valid audio mime:" + str2);
                        return false;
                    }
                    if (!mediaFormat2.containsKey("sample-rate")) {
                        return false;
                    }
                    int integer = mediaFormat2.getInteger("sample-rate");
                    if (integer > 48000) {
                        HwLog.e(TAG, "isSupportFormat --- audio samplerate:" + integer + " but the max supported sampleRate is 48000");
                        return false;
                    }
                }
                if (!isSupportVideoMime(mediaFormat, str3)) {
                    HwLog.e(TAG, "isSupportFormat --- media mime not valid video mime:" + str3);
                    return false;
                }
                HwLog.e(TAG, "isSupportFormat true");
                return true;
            } catch (IOException e) {
                HwLog.e(TAG, "isSupportFormat --- extractor error: " + HwLog.printException((Exception) e));
                return false;
            }
        }
        HwLog.e(TAG, "isSupportFormat --- input file size is " + fileSize + " , invalid file size.");
        return false;
    }

    protected static boolean isSupportVideoMime(MediaFormat mediaFormat, String str) {
        int integer;
        if (!VALID_VIDEO_MIMES.contains(str)) {
            HwLog.i(TAG, "isSupportVideoMime not support: " + str);
            return false;
        }
        if (!MimeTypes.VIDEO_MP4V.equals(str) || !mediaFormat.containsKey("level") || (integer = mediaFormat.getInteger("level")) <= 4) {
            return true;
        }
        HwLog.e(TAG, "isSupportVideoMime --- mp4v-es level: " + integer + " only support level 4");
        return false;
    }

    protected static boolean isSupportAudioMime(MediaFormat mediaFormat, String str) {
        if (!VALID_AUDIO_MIMES.contains(str)) {
            HwLog.i(TAG, "isSupportAudioMime not support: " + str);
            return false;
        }
        if (!MimeTypes.AUDIO_AAC.equals(str) || !mediaFormat.containsKey("aac-profile")) {
            return true;
        }
        int integer = mediaFormat.getInteger("aac-profile");
        long j = integer;
        if (j == 2 || j == 5) {
            return true;
        }
        HwLog.e(TAG, "MediaFormat.KEY_AAC_PROFILE: aac-profile profile: " + integer + " is not supported!");
        return false;
    }

    private boolean isSupportVideoSize(String str, int i, int i2) {
        if (EmuiUtils.PRODUCT_4K && i <= 4096 && i2 <= 4096) {
            HwLog.d(TAG, "is 4K product, skip check");
            return true;
        }
        MediaCodec mediaCodec = null;
        try {
            try {
                MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(str);
                if (mediaCodecCreateEncoderByType == null) {
                    HwLog.e(TAG, "videoEncoder is null");
                    if (mediaCodecCreateEncoderByType != null) {
                        mediaCodecCreateEncoderByType.stop();
                        mediaCodecCreateEncoderByType.release();
                    }
                    return false;
                }
                MediaCodecInfo mediaCodecInfoSelectCodec = selectCodec(mediaCodecCreateEncoderByType);
                if (mediaCodecCreateEncoderByType != null) {
                    mediaCodecCreateEncoderByType.stop();
                    mediaCodecCreateEncoderByType.release();
                }
                if (mediaCodecInfoSelectCodec == null) {
                    HwLog.e(TAG, "codecInfo is null");
                    return false;
                }
                MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfoSelectCodec.getCapabilitiesForType(str).getVideoCapabilities();
                int iIntValue = ((Integer) videoCapabilities.getSupportedWidths().getUpper()).intValue();
                int iIntValue2 = ((Integer) videoCapabilities.getSupportedHeights().getUpper()).intValue();
                int iIntValue3 = ((Integer) videoCapabilities.getSupportedWidths().getLower()).intValue();
                int iIntValue4 = ((Integer) videoCapabilities.getSupportedHeights().getLower()).intValue();
                HwLog.d(TAG, "maxWidth = " + iIntValue + ", maxHeight = " + iIntValue2 + ", minWidth = " + iIntValue3 + ", minHeight = " + iIntValue4 + ", videoWidth = " + i + ", videoHeight = " + i2 + ", isSizeSupported = " + videoCapabilities.isSizeSupported(i, i2));
                if (iIntValue < iIntValue2) {
                    iIntValue2 = iIntValue;
                    iIntValue = iIntValue2;
                }
                if (iIntValue3 < iIntValue4) {
                    iIntValue4 = iIntValue3;
                    iIntValue3 = iIntValue4;
                }
                if (i < i2) {
                    i2 = i;
                    i = i2;
                }
                boolean z = iIntValue >= i && iIntValue2 >= i2 && iIntValue3 <= i && iIntValue4 <= i2;
                HwLog.d(TAG, "videoCodec resolution support is " + z);
                return z;
            } catch (IOException unused) {
                HwLog.e(TAG, "create video encoder failed");
                if (0 != 0) {
                    mediaCodec.stop();
                    mediaCodec.release();
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            throw th;
        }
    }

    private MediaCodecInfo selectCodec(MediaCodec mediaCodec) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            String name = codecInfoAt.getName();
            if (name != null && name.equals(mediaCodec.getName())) {
                return codecInfoAt;
            }
        }
        return null;
    }

    public static String getTextString(int i, int i2) {
        int i3 = i2 - i;
        if (i3 > 10200) {
            return String.valueOf((int) Math.ceil(i3 / 1000.0f));
        }
        return String.valueOf(i3 / 1000);
    }
}
