package androidx.media3.common;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes2.dex */
public final class MimeTypes {
    public static final String APPLICATION_AIT = "application/vnd.dvb.ait";
    public static final String APPLICATION_CAMERA_MOTION = "application/x-camera-motion";
    public static final String APPLICATION_CEA608 = "application/cea-608";
    public static final String APPLICATION_CEA708 = "application/cea-708";
    public static final String APPLICATION_DVBSUBS = "application/dvbsubs";
    public static final String APPLICATION_EMSG = "application/x-emsg";
    public static final String APPLICATION_EXIF = "application/x-exif";
    public static final String APPLICATION_EXTERNALLY_LOADED_IMAGE = "application/x-image-uri";
    public static final String APPLICATION_ICY = "application/x-icy";
    public static final String APPLICATION_ID3 = "application/id3";
    public static final String APPLICATION_M3U8 = "application/x-mpegURL";
    public static final String APPLICATION_MATROSKA = "application/x-matroska";
    public static final String APPLICATION_MEDIA3_CUES = "application/x-media3-cues";
    public static final String APPLICATION_MP4 = "application/mp4";
    public static final String APPLICATION_MP4CEA608 = "application/x-mp4-cea-608";
    public static final String APPLICATION_MP4VTT = "application/x-mp4-vtt";
    public static final String APPLICATION_MPD = "application/dash+xml";
    public static final String APPLICATION_PGS = "application/pgs";

    @Deprecated
    public static final String APPLICATION_RAWCC = "application/x-rawcc";
    public static final String APPLICATION_RTSP = "application/x-rtsp";
    public static final String APPLICATION_SCTE35 = "application/x-scte35";
    public static final String APPLICATION_SS = "application/vnd.ms-sstr+xml";
    public static final String APPLICATION_SUBRIP = "application/x-subrip";
    public static final String APPLICATION_TTML = "application/ttml+xml";
    public static final String APPLICATION_TX3G = "application/x-quicktime-tx3g";
    public static final String APPLICATION_VOBSUB = "application/vobsub";
    public static final String APPLICATION_WEBM = "application/webm";
    public static final String AUDIO_AAC = "audio/mp4a-latm";
    public static final String AUDIO_AC3 = "audio/ac3";
    public static final String AUDIO_AC4 = "audio/ac4";
    public static final String AUDIO_ALAC = "audio/alac";
    public static final String AUDIO_ALAW = "audio/g711-alaw";
    public static final String AUDIO_AMR = "audio/amr";
    public static final String AUDIO_AMR_NB = "audio/3gpp";
    public static final String AUDIO_AMR_WB = "audio/amr-wb";
    public static final String AUDIO_DTS = "audio/vnd.dts";
    public static final String AUDIO_DTS_EXPRESS = "audio/vnd.dts.hd;profile=lbr";
    public static final String AUDIO_DTS_HD = "audio/vnd.dts.hd";
    public static final String AUDIO_DTS_X = "audio/vnd.dts.uhd;profile=p2";
    public static final String AUDIO_EXOPLAYER_MIDI = "audio/x-exoplayer-midi";
    public static final String AUDIO_E_AC3 = "audio/eac3";
    public static final String AUDIO_E_AC3_JOC = "audio/eac3-joc";
    public static final String AUDIO_FLAC = "audio/flac";
    public static final String AUDIO_MATROSKA = "audio/x-matroska";
    public static final String AUDIO_MIDI = "audio/midi";
    public static final String AUDIO_MLAW = "audio/g711-mlaw";
    public static final String AUDIO_MP4 = "audio/mp4";
    public static final String AUDIO_MPEG = "audio/mpeg";
    public static final String AUDIO_MPEGH_MHA1 = "audio/mha1";
    public static final String AUDIO_MPEGH_MHM1 = "audio/mhm1";
    public static final String AUDIO_MPEG_L1 = "audio/mpeg-L1";
    public static final String AUDIO_MPEG_L2 = "audio/mpeg-L2";
    public static final String AUDIO_MSGSM = "audio/gsm";
    public static final String AUDIO_OGG = "audio/ogg";
    public static final String AUDIO_OPUS = "audio/opus";
    public static final String AUDIO_RAW = "audio/raw";
    public static final String AUDIO_TRUEHD = "audio/true-hd";
    public static final String AUDIO_UNKNOWN = "audio/x-unknown";
    public static final String AUDIO_VORBIS = "audio/vorbis";
    public static final String AUDIO_WAV = "audio/wav";
    public static final String AUDIO_WEBM = "audio/webm";
    public static final String BASE_TYPE_APPLICATION = "application";
    public static final String BASE_TYPE_AUDIO = "audio";
    public static final String BASE_TYPE_IMAGE = "image";
    public static final String BASE_TYPE_TEXT = "text";
    public static final String BASE_TYPE_VIDEO = "video";
    public static final String CODEC_E_AC3_JOC = "ec+3";
    public static final String IMAGE_AVIF = "image/avif";
    public static final String IMAGE_BMP = "image/bmp";
    public static final String IMAGE_HEIC = "image/heic";
    public static final String IMAGE_HEIF = "image/heif";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_JPEG_R = "image/jpeg_r";
    public static final String IMAGE_PNG = "image/png";
    public static final String IMAGE_RAW = "image/raw";
    public static final String IMAGE_WEBP = "image/webp";
    public static final String TEXT_SSA = "text/x-ssa";
    public static final String TEXT_UNKNOWN = "text/x-unknown";
    public static final String TEXT_VTT = "text/vtt";
    public static final String VIDEO_AV1 = "video/av01";
    public static final String VIDEO_AVI = "video/x-msvideo";
    public static final String VIDEO_DIVX = "video/divx";
    public static final String VIDEO_DOLBY_VISION = "video/dolby-vision";
    public static final String VIDEO_FLV = "video/x-flv";
    public static final String VIDEO_H263 = "video/3gpp";
    public static final String VIDEO_H264 = "video/avc";
    public static final String VIDEO_H265 = "video/hevc";
    public static final String VIDEO_MATROSKA = "video/x-matroska";
    public static final String VIDEO_MJPEG = "video/mjpeg";
    public static final String VIDEO_MP2T = "video/mp2t";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_MP42 = "video/mp42";
    public static final String VIDEO_MP43 = "video/mp43";
    public static final String VIDEO_MP4V = "video/mp4v-es";
    public static final String VIDEO_MPEG = "video/mpeg";
    public static final String VIDEO_MPEG2 = "video/mpeg2";
    public static final String VIDEO_OGG = "video/ogg";
    public static final String VIDEO_PS = "video/mp2p";
    public static final String VIDEO_RAW = "video/raw";
    public static final String VIDEO_UNKNOWN = "video/x-unknown";
    public static final String VIDEO_VC1 = "video/wvc1";
    public static final String VIDEO_VP8 = "video/x-vnd.on2.vp8";
    public static final String VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static final String VIDEO_WEBM = "video/webm";
    private static final ArrayList<CustomMimeType> customMimeTypes = new ArrayList<>();
    private static final Pattern MP4A_RFC_6381_CODEC_PATTERN = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static void registerCustomMimeType(String str, String str2, int i) {
        CustomMimeType customMimeType = new CustomMimeType(str, str2, i);
        int size = customMimeTypes.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            ArrayList<CustomMimeType> arrayList = customMimeTypes;
            if (str.equals(arrayList.get(i2).mimeType)) {
                arrayList.remove(i2);
                break;
            }
            i2++;
        }
        customMimeTypes.add(customMimeType);
    }

    public static boolean isAudio(String str) {
        return "audio".equals(getTopLevelType(str));
    }

    public static boolean isVideo(String str) {
        return "video".equals(getTopLevelType(str));
    }

    @Pure
    public static boolean isText(String str) {
        return "text".equals(getTopLevelType(str)) || APPLICATION_MEDIA3_CUES.equals(str) || APPLICATION_CEA608.equals(str) || APPLICATION_CEA708.equals(str) || APPLICATION_MP4CEA608.equals(str) || APPLICATION_SUBRIP.equals(str) || APPLICATION_TTML.equals(str) || APPLICATION_TX3G.equals(str) || APPLICATION_MP4VTT.equals(str) || APPLICATION_RAWCC.equals(str) || APPLICATION_VOBSUB.equals(str) || APPLICATION_PGS.equals(str) || APPLICATION_DVBSUBS.equals(str);
    }

    public static boolean isImage(String str) {
        return "image".equals(getTopLevelType(str)) || APPLICATION_EXTERNALLY_LOADED_IMAGE.equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean allSamplesAreSyncSamples(java.lang.String r3, java.lang.String r4) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.MimeTypes.allSamplesAreSyncSamples(java.lang.String, java.lang.String):boolean");
    }

    public static String getVideoMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isVideo(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static boolean containsCodecsCorrespondingToMimeType(String str, String str2) {
        return getCodecsCorrespondingToMimeType(str, str2) != null;
    }

    public static String getCodecsCorrespondingToMimeType(String str, String str2) {
        if (str != null && str2 != null) {
            String[] strArrSplitCodecs = Util.splitCodecs(str);
            StringBuilder sb = new StringBuilder();
            for (String str3 : strArrSplitCodecs) {
                if (str2.equals(getMediaMimeType(str3))) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str3);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static String getAudioMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isAudio(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static String getTextMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isText(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static String getMediaMimeType(String str) {
        Mp4aObjectType objectTypeFromMp4aRFC6381CodecString;
        String mimeTypeFromMp4ObjectType = null;
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (lowerCase.startsWith("avc1") || lowerCase.startsWith("avc3")) {
            return VIDEO_H264;
        }
        if (lowerCase.startsWith("hev1") || lowerCase.startsWith("hvc1")) {
            return VIDEO_H265;
        }
        if (lowerCase.startsWith("dvav") || lowerCase.startsWith("dva1") || lowerCase.startsWith("dvhe") || lowerCase.startsWith("dvh1")) {
            return VIDEO_DOLBY_VISION;
        }
        if (lowerCase.startsWith("av01")) {
            return VIDEO_AV1;
        }
        if (lowerCase.startsWith("vp9") || lowerCase.startsWith("vp09")) {
            return VIDEO_VP9;
        }
        if (lowerCase.startsWith("vp8") || lowerCase.startsWith("vp08")) {
            return VIDEO_VP8;
        }
        if (!lowerCase.startsWith("mp4a")) {
            return lowerCase.startsWith("mha1") ? AUDIO_MPEGH_MHA1 : lowerCase.startsWith("mhm1") ? AUDIO_MPEGH_MHM1 : (lowerCase.startsWith("ac-3") || lowerCase.startsWith("dac3")) ? AUDIO_AC3 : (lowerCase.startsWith("ec-3") || lowerCase.startsWith("dec3")) ? AUDIO_E_AC3 : lowerCase.startsWith(CODEC_E_AC3_JOC) ? AUDIO_E_AC3_JOC : (lowerCase.startsWith("ac-4") || lowerCase.startsWith("dac4")) ? AUDIO_AC4 : lowerCase.startsWith("dtsc") ? AUDIO_DTS : lowerCase.startsWith("dtse") ? AUDIO_DTS_EXPRESS : (lowerCase.startsWith("dtsh") || lowerCase.startsWith("dtsl")) ? AUDIO_DTS_HD : lowerCase.startsWith("dtsx") ? AUDIO_DTS_X : lowerCase.startsWith("opus") ? AUDIO_OPUS : lowerCase.startsWith("vorbis") ? AUDIO_VORBIS : lowerCase.startsWith("flac") ? AUDIO_FLAC : lowerCase.startsWith("stpp") ? APPLICATION_TTML : lowerCase.startsWith("wvtt") ? TEXT_VTT : lowerCase.contains("cea708") ? APPLICATION_CEA708 : (lowerCase.contains("eia608") || lowerCase.contains("cea608")) ? APPLICATION_CEA608 : getCustomMimeTypeForCodec(lowerCase);
        }
        if (lowerCase.startsWith("mp4a.") && (objectTypeFromMp4aRFC6381CodecString = getObjectTypeFromMp4aRFC6381CodecString(lowerCase)) != null) {
            mimeTypeFromMp4ObjectType = getMimeTypeFromMp4ObjectType(objectTypeFromMp4aRFC6381CodecString.objectTypeIndication);
        }
        return mimeTypeFromMp4ObjectType == null ? AUDIO_AAC : mimeTypeFromMp4ObjectType;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Byte getMp4ObjectTypeFromMimeType(java.lang.String r4) {
        /*
            r4.hashCode()
            int r0 = r4.hashCode()
            r1 = -1003765268(0xffffffffc42bc1ec, float:-687.03)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2f
            r1 = -53558318(0xfffffffffccec3d2, float:-8.588679E36)
            if (r0 == r1) goto L24
            r1 = 1187890754(0x46cdc642, float:26339.129)
            if (r0 == r1) goto L19
            goto L37
        L19:
            java.lang.String r0 = "video/mp4v-es"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L22
            goto L37
        L22:
            r4 = r2
            goto L3a
        L24:
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2d
            goto L37
        L2d:
            r4 = r3
            goto L3a
        L2f:
            java.lang.String r0 = "audio/vorbis"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L39
        L37:
            r4 = -1
            goto L3a
        L39:
            r4 = 0
        L3a:
            if (r4 == 0) goto L50
            if (r4 == r3) goto L49
            if (r4 == r2) goto L42
            r4 = 0
            return r4
        L42:
            r4 = 32
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)
            return r4
        L49:
            r4 = 64
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)
            return r4
        L50:
            r4 = -35
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.MimeTypes.getMp4ObjectTypeFromMimeType(java.lang.String):java.lang.Byte");
    }

    public static int getTrackType(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (isAudio(str)) {
            return 1;
        }
        if (isVideo(str)) {
            return 2;
        }
        if (isText(str)) {
            return 3;
        }
        if (isImage(str)) {
            return 4;
        }
        if (APPLICATION_ID3.equals(str) || APPLICATION_EMSG.equals(str) || APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        return getTrackTypeForCustomMimeType(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getEncoding(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.MimeTypes.getEncoding(java.lang.String, java.lang.String):int");
    }

    public static int getTrackTypeOfCodec(String str) {
        return getTrackType(getMediaMimeType(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String normalizeMimeType(java.lang.String r6) {
        /*
            if (r6 != 0) goto L4
            r6 = 0
            return r6
        L4:
            java.lang.String r6 = com.google.common.base.Ascii.toLowerCase(r6)
            r6.hashCode()
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1007807498: goto L4f;
                case -979095690: goto L44;
                case -586683234: goto L39;
                case -432836268: goto L2e;
                case -432836267: goto L23;
                case 187090231: goto L18;
                default: goto L17;
            }
        L17:
            goto L5a
        L18:
            java.lang.String r0 = "audio/mp3"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L21
            goto L5a
        L21:
            r0 = r1
            goto L5b
        L23:
            java.lang.String r0 = "audio/mpeg-l2"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L2c
            goto L5a
        L2c:
            r0 = r2
            goto L5b
        L2e:
            java.lang.String r0 = "audio/mpeg-l1"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L37
            goto L5a
        L37:
            r0 = r3
            goto L5b
        L39:
            java.lang.String r0 = "audio/x-wav"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L42
            goto L5a
        L42:
            r0 = r4
            goto L5b
        L44:
            java.lang.String r0 = "application/x-mpegurl"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L4d
            goto L5a
        L4d:
            r0 = r5
            goto L5b
        L4f:
            java.lang.String r0 = "audio/x-flac"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L58
            goto L5a
        L58:
            r0 = 0
            goto L5b
        L5a:
            r0 = -1
        L5b:
            if (r0 == 0) goto L77
            if (r0 == r5) goto L74
            if (r0 == r4) goto L71
            if (r0 == r3) goto L6e
            if (r0 == r2) goto L6b
            if (r0 == r1) goto L68
            return r6
        L68:
            java.lang.String r6 = "audio/mpeg"
            return r6
        L6b:
            java.lang.String r6 = "audio/mpeg-L2"
            return r6
        L6e:
            java.lang.String r6 = "audio/mpeg-L1"
            return r6
        L71:
            java.lang.String r6 = "audio/wav"
            return r6
        L74:
            java.lang.String r6 = "application/x-mpegURL"
            return r6
        L77:
            java.lang.String r6 = "audio/flac"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.MimeTypes.normalizeMimeType(java.lang.String):java.lang.String");
    }

    public static boolean isMatroska(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(VIDEO_WEBM) || str.startsWith(AUDIO_WEBM) || str.startsWith(APPLICATION_WEBM) || str.startsWith(VIDEO_MATROSKA) || str.startsWith(AUDIO_MATROSKA) || str.startsWith(APPLICATION_MATROSKA);
    }

    private static String getTopLevelType(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    private static String getCustomMimeTypeForCodec(String str) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (str.startsWith(customMimeType.codecPrefix)) {
                return customMimeType.mimeType;
            }
        }
        return null;
    }

    private static int getTrackTypeForCustomMimeType(String str) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (str.equals(customMimeType.mimeType)) {
                return customMimeType.trackType;
            }
        }
        return -1;
    }

    private MimeTypes() {
    }

    static Mp4aObjectType getObjectTypeFromMp4aRFC6381CodecString(String str) {
        Matcher matcher = MP4A_RFC_6381_CODEC_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) Assertions.checkNotNull(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new Mp4aObjectType(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static final class Mp4aObjectType {
        public final int audioObjectTypeIndication;
        public final int objectTypeIndication;

        public Mp4aObjectType(int i, int i2) {
            this.objectTypeIndication = i;
            this.audioObjectTypeIndication = i2;
        }

        public int getEncoding() {
            int i = this.audioObjectTypeIndication;
            if (i == 2) {
                return 10;
            }
            if (i == 5) {
                return 11;
            }
            if (i == 29) {
                return 12;
            }
            if (i == 42) {
                return 16;
            }
            if (i != 22) {
                return i != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    static final class CustomMimeType {
        public final String codecPrefix;
        public final String mimeType;
        public final int trackType;

        public CustomMimeType(String str, String str2, int i) {
            this.mimeType = str;
            this.codecPrefix = str2;
            this.trackType = i;
        }
    }

    public static String getMimeTypeFromMp4ObjectType(int i) {
        if (i == 32) {
            return VIDEO_MP4V;
        }
        if (i == 33) {
            return VIDEO_H264;
        }
        if (i == 35) {
            return VIDEO_H265;
        }
        if (i == 64) {
            return AUDIO_AAC;
        }
        if (i == 163) {
            return VIDEO_VC1;
        }
        if (i == 177) {
            return VIDEO_VP9;
        }
        if (i == 221) {
            return AUDIO_VORBIS;
        }
        if (i == 165) {
            return AUDIO_AC3;
        }
        if (i == 166) {
            return AUDIO_E_AC3;
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return AUDIO_AAC;
            case 105:
            case 107:
                return AUDIO_MPEG;
            case 106:
                return VIDEO_MPEG;
            case 108:
                return "image/jpeg";
            default:
                switch (i) {
                    case 169:
                    case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                        return AUDIO_DTS;
                    case 170:
                    case 171:
                        return AUDIO_DTS_HD;
                    case 173:
                        return AUDIO_OPUS;
                    case 174:
                        return AUDIO_AC4;
                    default:
                        return null;
                }
        }
    }
}
