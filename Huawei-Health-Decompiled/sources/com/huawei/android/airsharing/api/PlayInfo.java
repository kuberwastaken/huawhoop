package com.huawei.android.airsharing.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.Constants;
import defpackage.arb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PlayInfo implements Parcelable {
    public static final int ADAPT_MODE_NONE = 1;
    public static final int DRM_TYPE_BASE = 1;
    public static final int DRM_TYPE_CHINADRM = 16;
    public static final int DRM_TYPE_CLEARKEY = 2;
    public static final int DRM_TYPE_PLAYREADY = 8;
    public static final int DRM_TYPE_WIDEVINE = 4;
    public static final int ID_MAX_LEN = 100;
    public static final String KEY_ALBUM_COVER_URL = "ALBUM_COVER_URL";
    public static final String KEY_ALBUM_TITLE = "ALBUM_TITLE";
    public static final String KEY_APP_ICON_URL = "APP_ICON_URL";
    public static final String KEY_APP_NAME = "APP_NAME";
    public static final String KEY_AUDIO_TRACK_NAME = "AUDIO_TRACK_NAME";
    public static final String KEY_CLOSING_CREDITS_POSITION = "CLOSING_CREDITS_POSITION";
    public static final String KEY_DRM_TYPE = "DRM_TYPE";
    public static final String KEY_DURATION = "DURATION";
    public static final String KEY_LRC_CONTENT = "LRC_CONTENT";
    public static final String KEY_LRC_URL = "LRC_URL";
    public static final String KEY_MEDIA_ARTIST = "MEDIA_ARTIST";
    public static final String KEY_MEDIA_ID = "MEDIA_ID";
    public static final String KEY_MEDIA_NAME = "MEDIA_NAME";
    public static final String KEY_MEDIA_SIZE = "MEDIA_SIZE";
    public static final String KEY_MEDIA_TYPE = "MEDIA_TYPE";
    public static final String KEY_MEDIA_URL = "MEDIA_URL";
    public static final String KEY_START_POSITION = "START_POSITION";
    private static final String KEY_SUBTITLE_LANGUAGE = "SUBTITLE_LANGUAGE";
    public static final String KEY_SUBTITLE_TRACK_NAME = "SUBTITLE_TRACK_NAME";
    private static final String KEY_SUBTITLE_TYPE = "SUBTITLE_TYPE";
    private static final String KEY_SUBTITLE_URL = "SUBTITLE_URL";
    public static final String KEY_SUB_TITLE = "SUB_TITLE";
    public static final String KEY_UX_ADAPT_MODE = "UX_ADAPT_MODE";
    public static final String KEY_VIDEO_TRACK_NAME = "VIDEO_TRACK_NAME";
    private static final String TAG = "HiSight-S-PlayInfo";
    private static final int TITLE_MAX_LEN = 200;
    private static final int URL_MASK_LEN = 20;
    private static final int URL_MAX_LEN = 2083;
    private JSONObject mInfoObject;
    private List<d> mSubTitleList;
    public static final Parcelable.Creator<PlayInfo> CREATOR = new Parcelable.Creator<PlayInfo>() { // from class: com.huawei.android.airsharing.api.PlayInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public PlayInfo[] newArray(int i) {
            return new PlayInfo[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: eX_, reason: merged with bridge method [inline-methods] */
        public PlayInfo createFromParcel(Parcel parcel) {
            return new PlayInfo(parcel.readString());
        }
    };
    private static arb sLog = arb.d();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlayInfo(EHwMediaInfoType eHwMediaInfoType) {
        this.mSubTitleList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        this.mInfoObject = jSONObject;
        try {
            jSONObject.put(KEY_MEDIA_TYPE, eHwMediaInfoType.toString());
        } catch (JSONException e) {
            sLog.b(TAG, "ERROR: PlayInfo JSONException " + e);
        }
    }

    private PlayInfo(String str) {
        this.mSubTitleList = new ArrayList();
        this.mInfoObject = new JSONObject();
        try {
            this.mInfoObject = new JSONObject(str);
        } catch (JSONException e) {
            sLog.b(TAG, "ERROR: createFromParcel JSONException " + e);
        }
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject(this.mInfoObject.toString());
            if (jSONObject.has(KEY_MEDIA_URL)) {
                jSONObject.put(KEY_MEDIA_URL, maskUrl(jSONObject.getString(KEY_MEDIA_URL)));
            }
            if (jSONObject.has(KEY_ALBUM_COVER_URL)) {
                jSONObject.put(KEY_ALBUM_COVER_URL, maskUrl(jSONObject.getString(KEY_ALBUM_COVER_URL)));
            }
            if (jSONObject.has(KEY_LRC_URL)) {
                jSONObject.put(KEY_LRC_URL, maskUrl(jSONObject.getString(KEY_LRC_URL)));
            }
            if (jSONObject.has(KEY_APP_ICON_URL)) {
                jSONObject.put(KEY_APP_ICON_URL, maskUrl(jSONObject.getString(KEY_APP_ICON_URL)));
            }
            if (jSONObject.has(KEY_SUBTITLE_URL)) {
                jSONObject.put(KEY_SUBTITLE_URL, maskUrl(jSONObject.getString(KEY_SUBTITLE_URL)));
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            sLog.b(TAG, "PlayInfo toString JSONException");
            return "";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.mInfoObject.toString());
    }

    public boolean addSubtitle(String str, String str2, String str3) {
        if (!verifyInputParameters(KEY_SUBTITLE_URL, str)) {
            sLog.b(TAG, "addSubtitle url invalid, url is " + maskUrl(str));
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            sLog.b(TAG, "addSubtitle type invalid, type is " + str3);
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            sLog.b(TAG, "addSubtitle language invalid, language is " + str3);
            return false;
        }
        d dVar = new d(str, str2, str3);
        this.mSubTitleList.add(dVar);
        try {
            this.mInfoObject.put(KEY_SUB_TITLE, subTitleListToArray(this.mSubTitleList));
            return true;
        } catch (JSONException e) {
            sLog.b(TAG, "addSubtitle throw JSONException e:" + e.toString());
            this.mSubTitleList.remove(dVar);
            return false;
        }
    }

    public List<d> getSubtitleList() {
        return this.mSubTitleList;
    }

    public boolean putString(String str, String str2) {
        if (!verifyInputParameters(str, str2)) {
            sLog.b(TAG, "putString key or value is illegal, key is " + str + ", value is " + str2);
            return false;
        }
        try {
            this.mInfoObject.put(str, str2);
            return true;
        } catch (JSONException unused) {
            sLog.b(TAG, "putString throw JSONException, key: " + str);
            return false;
        }
    }

    public boolean putInt(String str, int i) {
        if (!verifyInputParameters(str, i)) {
            sLog.b(TAG, "putInt key or value is illegal, key is " + str + ", value is " + i);
            return false;
        }
        try {
            this.mInfoObject.put(str, i);
            return true;
        } catch (JSONException unused) {
            sLog.b(TAG, "PlayInfo putInt throw JSONException, key: " + str);
            return false;
        }
    }

    public boolean putLong(String str, long j) {
        if (!verifyInputParameters(str, j)) {
            sLog.b(TAG, "putLong key or value is illegal, key is " + str + ", value is " + j);
            return false;
        }
        try {
            this.mInfoObject.put(str, j);
            return true;
        } catch (JSONException unused) {
            sLog.b(TAG, "PlayInfo putLong throw JSONException, key: " + str);
            return false;
        }
    }

    public boolean setMediaId(String str) {
        return putString(KEY_MEDIA_ID, str);
    }

    public String getMediaId() {
        return getString(KEY_MEDIA_ID);
    }

    public boolean setMediaName(String str) {
        return putString(KEY_MEDIA_NAME, str);
    }

    public String getMediaName() {
        return getString(KEY_MEDIA_NAME);
    }

    public boolean setMediaUrl(String str) {
        return putString(KEY_MEDIA_URL, str);
    }

    public String getMediaUrl() {
        return getString(KEY_MEDIA_URL);
    }

    private boolean setMediaType(String str) {
        return putString(KEY_MEDIA_TYPE, str);
    }

    public EHwMediaInfoType getMediaType() {
        try {
            return EHwMediaInfoType.valueOf(getString(KEY_MEDIA_TYPE));
        } catch (IllegalArgumentException e) {
            sLog.b(TAG, "getMediaType " + e);
            return EHwMediaInfoType.UNKNOWN;
        }
    }

    public boolean setMediaSize(long j) {
        return putLong(KEY_MEDIA_SIZE, j);
    }

    public long getMediaSize() {
        return getLong(KEY_MEDIA_SIZE);
    }

    public boolean setStartPosition(int i) {
        return putInt(KEY_START_POSITION, i);
    }

    public int getStartPosition() {
        return getInt(KEY_START_POSITION);
    }

    public boolean setDuration(int i) {
        return putInt(KEY_DURATION, i);
    }

    public int getDuration() {
        return getInt(KEY_DURATION);
    }

    public boolean setClosingCreditsPosition(int i) {
        return putInt(KEY_CLOSING_CREDITS_POSITION, i);
    }

    public int getClosingCreditsPosition() {
        return getInt(KEY_CLOSING_CREDITS_POSITION);
    }

    public boolean setAlbumCoverUrl(String str) {
        return putString(KEY_ALBUM_COVER_URL, str);
    }

    public String getAlbumCoverUrl() {
        return getString(KEY_ALBUM_COVER_URL);
    }

    public boolean setAlbumTitle(String str) {
        return putString(KEY_ALBUM_TITLE, str);
    }

    public String getAlbumTitle() {
        return getString(KEY_ALBUM_TITLE);
    }

    public boolean setMediaArtist(String str) {
        return putString(KEY_MEDIA_ARTIST, str);
    }

    public String getMediaArtist() {
        return getString(KEY_MEDIA_ARTIST);
    }

    public boolean setLrcUrl(String str) {
        return putString(KEY_LRC_URL, str);
    }

    public String getLrcUrl() {
        return getString(KEY_LRC_URL);
    }

    public boolean setLrcContent(String str) {
        return putString(KEY_LRC_CONTENT, str);
    }

    public String getLrcContent() {
        return getString(KEY_LRC_CONTENT);
    }

    public boolean setAppIconUrl(String str) {
        return putString(KEY_APP_ICON_URL, str);
    }

    public String getAppIconUrl() {
        return getString(KEY_APP_ICON_URL);
    }

    public boolean setAppName(String str) {
        return putString(KEY_APP_NAME, str);
    }

    public String getAppName() {
        return getString(KEY_APP_NAME);
    }

    public boolean setDrmType(int i) {
        return putInt(KEY_DRM_TYPE, i);
    }

    public int getDrmType() {
        return getInt(KEY_DRM_TYPE);
    }

    public boolean setAudioTrackName(String str) {
        return putString(KEY_AUDIO_TRACK_NAME, str);
    }

    public String getAudioTrackName() {
        return getString(KEY_AUDIO_TRACK_NAME);
    }

    public boolean setVideoTrackName(String str) {
        return putString(KEY_VIDEO_TRACK_NAME, str);
    }

    public String getVideoTrackName() {
        return getString(KEY_VIDEO_TRACK_NAME);
    }

    public boolean setSubtitleTrackName(String str) {
        return putString(KEY_SUBTITLE_TRACK_NAME, str);
    }

    public String getSubtitleTrackName() {
        return getString(KEY_SUBTITLE_TRACK_NAME);
    }

    public boolean setUxAdaptMode(int i) {
        return putInt(KEY_UX_ADAPT_MODE, i);
    }

    public int getUxAdaptMode() {
        return getInt(KEY_UX_ADAPT_MODE);
    }

    public int getInt(String str) {
        return this.mInfoObject.optInt(str, -1);
    }

    public long getLong(String str) {
        return this.mInfoObject.optLong(str, -1L);
    }

    public String getString(String str) {
        return this.mInfoObject.optString(str, "");
    }

    public boolean isEmpty(String str) {
        return this.mInfoObject.isNull(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean verifyInputParameters(java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.airsharing.api.PlayInfo.verifyInputParameters(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean verifyInputParameters(java.lang.String r6, int r7) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            r6.hashCode()
            int r0 = r6.hashCode()
            r2 = -1409705850(0xffffffffabf99886, float:-1.7734848E-12)
            r3 = 2
            r4 = 1
            if (r0 == r2) goto L37
            r2 = 307645946(0x12564dfa, float:6.7622607E-28)
            if (r0 == r2) goto L2c
            r2 = 1823963576(0x6cb779b8, float:1.7744658E27)
            if (r0 == r2) goto L21
            goto L3f
        L21:
            java.lang.String r0 = "CLOSING_CREDITS_POSITION"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L2a
            goto L3f
        L2a:
            r6 = r3
            goto L42
        L2c:
            java.lang.String r0 = "DRM_TYPE"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L35
            goto L3f
        L35:
            r6 = r4
            goto L42
        L37:
            java.lang.String r0 = "START_POSITION"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L41
        L3f:
            r6 = -1
            goto L42
        L41:
            r6 = r1
        L42:
            if (r6 == 0) goto L5a
            if (r6 == r4) goto L49
            if (r6 == r3) goto L5a
            return r4
        L49:
            if (r7 == r4) goto L58
            if (r7 == r3) goto L58
            r6 = 4
            if (r7 == r6) goto L58
            r6 = 8
            if (r7 == r6) goto L58
            r6 = 16
            if (r7 != r6) goto L59
        L58:
            r1 = r4
        L59:
            return r1
        L5a:
            if (r7 < 0) goto L5d
            r1 = r4
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.airsharing.api.PlayInfo.verifyInputParameters(java.lang.String, int):boolean");
    }

    private boolean verifyInputParameters(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        return !str.equals(KEY_MEDIA_SIZE) || j >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayInfo)) {
            return false;
        }
        PlayInfo playInfo = (PlayInfo) obj;
        return getMediaType() != null && Objects.equals(getMediaType(), playInfo.getMediaType()) && !TextUtils.isEmpty(getMediaUrl()) && Objects.equals(getMediaUrl(), playInfo.getMediaUrl()) && !TextUtils.isEmpty(getMediaId()) && Objects.equals(getMediaId(), playInfo.getMediaId());
    }

    public int hashCode() {
        return Objects.hash(getMediaType() + getMediaUrl() + getMediaId());
    }

    public static String maskUrl(String str) {
        int length;
        if (str == null || (length = str.length()) <= 20) {
            return Constants.CONFUSION_CHARS;
        }
        return str.substring(0, (length - 20) / 2) + Constants.CONFUSION_CHARS + str.substring((length + 20) / 2);
    }

    public static boolean checkPlayInfo(PlayInfo playInfo) {
        if (playInfo == null) {
            sLog.e(TAG, "in checkPlayInfo, playInfo not valid");
            return false;
        }
        if (playInfo.getMediaType() != EHwMediaInfoType.IMAGE && playInfo.getMediaType() != EHwMediaInfoType.AUDIO && playInfo.getMediaType() != EHwMediaInfoType.VIDEO) {
            sLog.e(TAG, "in checkPlayInfo, PlayMediaType not valid");
            return false;
        }
        return !TextUtils.isEmpty(playInfo.getMediaUrl());
    }

    private JSONArray subTitleListToArray(List<d> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (d dVar : list) {
            if (dVar == null) {
                throw new IllegalArgumentException("subTitleListToArray subTitle is null");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_SUBTITLE_URL, dVar.b());
            jSONObject.put(KEY_SUBTITLE_TYPE, dVar.e());
            jSONObject.put(KEY_SUBTITLE_LANGUAGE, dVar.a());
            jSONArray.put(jSONObject.toString());
        }
        return jSONArray;
    }

    public static PlayInfo toJavaBean(JSONObject jSONObject) {
        boolean zJsonArrayToSubtitle;
        if (jSONObject == null) {
            sLog.b(TAG, "toJavaBean, dataObj not valid");
            return null;
        }
        try {
            PlayInfo playInfo = new PlayInfo(EHwMediaInfoType.valueOf(jSONObject.getString(KEY_MEDIA_TYPE)));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    zJsonArrayToSubtitle = playInfo.putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    zJsonArrayToSubtitle = playInfo.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    zJsonArrayToSubtitle = playInfo.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof JSONArray) {
                    zJsonArrayToSubtitle = jsonArrayToSubtitle(playInfo, next, (JSONArray) obj);
                } else {
                    sLog.b(TAG, "toJavaBean, unknown value type");
                    sLog.b(TAG, "toJavaBean, put invalid param to playinfo, key is " + next + ", value is " + obj);
                }
                if (!zJsonArrayToSubtitle) {
                    sLog.b(TAG, "toJavaBean, put invalid param to playinfo, key is " + next + ", value is " + obj);
                }
            }
            return playInfo;
        } catch (IllegalArgumentException | JSONException e) {
            sLog.b(TAG, "toJavaBean Exception " + e);
            return null;
        }
    }

    private static boolean jsonArrayToSubtitle(PlayInfo playInfo, String str, JSONArray jSONArray) throws JSONException {
        if (!KEY_SUB_TITLE.equals(str)) {
            return false;
        }
        boolean zAddSubtitle = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = new JSONObject(jSONArray.getString(i));
            zAddSubtitle = playInfo.addSubtitle(jSONObject.optString(KEY_SUBTITLE_URL, ""), jSONObject.optString(KEY_SUBTITLE_TYPE, ""), jSONObject.optString(KEY_SUBTITLE_LANGUAGE, ""));
        }
        return zAddSubtitle;
    }

    public JSONObject toJsonObject() {
        return this.mInfoObject;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class d {
        private String b;
        private String d;
        private String e;

        d(String str, String str2, String str3) {
            this.e = str;
            this.b = str2;
            this.d = str3;
        }

        public String b() {
            return this.e;
        }

        public String e() {
            return this.b;
        }

        public String a() {
            return this.d;
        }
    }
}
