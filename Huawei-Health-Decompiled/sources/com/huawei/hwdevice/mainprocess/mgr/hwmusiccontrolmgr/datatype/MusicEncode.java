package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

/* JADX INFO: loaded from: classes5.dex */
public enum MusicEncode {
    MUSIC_ENCODE_0(0, "adts"),
    MUSIC_ENCODE_1(1, "mp3"),
    MUSIC_ENCODE_2(2, "flac"),
    MUSIC_ENCODE_3(3, "aac lc"),
    MUSIC_ENCODE_4(4, "aac hev1"),
    MUSIC_ENCODE_5(5, "aac hev2"),
    MUSIC_ENCODE_6(6, "pcm"),
    MUSIC_ENCODE_7(7, "connection position"),
    MUSIC_ENCODE_8(8, "alac"),
    MUSIC_ENCODE_9(9, "opus");

    private final int bitValue;
    private final String description;

    MusicEncode(int i, String str) {
        this.bitValue = i;
        this.description = str;
    }

    public int getBitValue() {
        return this.bitValue;
    }

    public String getDescription() {
        return this.description;
    }
}
