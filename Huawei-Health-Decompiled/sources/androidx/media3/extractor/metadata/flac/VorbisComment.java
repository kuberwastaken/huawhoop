package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new Parcelable.Creator<VorbisComment>() { // from class: androidx.media3.extractor.metadata.flac.VorbisComment.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VorbisComment[] newArray(int i) {
            return new VorbisComment[i];
        }
    };
    public final String key;
    public final String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VorbisComment(String str, String str2) {
        this.key = Ascii.toUpperCase(str);
        this.value = str2;
    }

    public VorbisComment(Parcel parcel) {
        this.key = (String) Util.castNonNull(parcel.readString());
        this.value = (String) Util.castNonNull(parcel.readString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    @Override // androidx.media3.common.Metadata.Entry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void populateMediaMetadata(androidx.media3.common.MediaMetadata.Builder r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.key
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case 62359119: goto L3d;
                case 79833656: goto L32;
                case 428414940: goto L27;
                case 1746739798: goto L1c;
                case 1939198791: goto L11;
                default: goto L10;
            }
        L10:
            goto L48
        L11:
            java.lang.String r1 = "ARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1a
            goto L48
        L1a:
            r0 = r2
            goto L49
        L1c:
            java.lang.String r1 = "ALBUMARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L25
            goto L48
        L25:
            r0 = r3
            goto L49
        L27:
            java.lang.String r1 = "DESCRIPTION"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L30
            goto L48
        L30:
            r0 = r4
            goto L49
        L32:
            java.lang.String r1 = "TITLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3b
            goto L48
        L3b:
            r0 = r5
            goto L49
        L3d:
            java.lang.String r1 = "ALBUM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L46
            goto L48
        L46:
            r0 = 0
            goto L49
        L48:
            r0 = -1
        L49:
            if (r0 == 0) goto L6c
            if (r0 == r5) goto L66
            if (r0 == r4) goto L60
            if (r0 == r3) goto L5a
            if (r0 == r2) goto L54
            goto L71
        L54:
            java.lang.String r0 = r6.value
            r7.setArtist(r0)
            goto L71
        L5a:
            java.lang.String r0 = r6.value
            r7.setAlbumArtist(r0)
            goto L71
        L60:
            java.lang.String r0 = r6.value
            r7.setDescription(r0)
            goto L71
        L66:
            java.lang.String r0 = r6.value
            r7.setTitle(r0)
            goto L71
        L6c:
            java.lang.String r0 = r6.value
            r7.setAlbumTitle(r0)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.flac.VorbisComment.populateMediaMetadata(androidx.media3.common.MediaMetadata$Builder):void");
    }

    public String toString() {
        return "VC: " + this.key + "=" + this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value);
    }

    public int hashCode() {
        return ((this.key.hashCode() + 527) * 31) + this.value.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
    }
}
