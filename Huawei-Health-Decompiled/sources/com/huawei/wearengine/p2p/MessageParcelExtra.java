package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class MessageParcelExtra extends MessageParcel implements Parcelable {
    public static final Parcelable.Creator<MessageParcelExtra> CREATOR = new Parcelable.Creator<MessageParcelExtra>() { // from class: com.huawei.wearengine.p2p.MessageParcelExtra.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: fCO_, reason: merged with bridge method [inline-methods] */
        public MessageParcelExtra createFromParcel(Parcel parcel) {
            MessageParcelExtra messageParcelExtra = new MessageParcelExtra();
            if (parcel != null) {
                int i = parcel.readInt();
                messageParcelExtra.setType(i);
                if (MessageParcelExtra.isData(i)) {
                    messageParcelExtra.setData(parcel.createByteArray());
                } else {
                    messageParcelExtra.setParcelFileDescriptor(parcel.readFileDescriptor());
                }
                messageParcelExtra.setFileName(parcel.readString());
                messageParcelExtra.setDescription(parcel.readString());
                messageParcelExtra.setFileSha256(parcel.readString());
                messageParcelExtra.setExtendJson(parcel.readString());
            }
            return messageParcelExtra;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public MessageParcelExtra[] newArray(int i) {
            return (i > 65535 || i < 0) ? new MessageParcelExtra[0] : new MessageParcelExtra[i];
        }
    };
    public static final int MESSAGE_TYPE_DATA = 1;
    public static final int MESSAGE_TYPE_FILE = 2;
    private String mExtendJson;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isData(int i) {
        return i == 1;
    }

    public void setExtendJson(String str) {
        this.mExtendJson = str;
    }

    public String getExtendJson() {
        return this.mExtendJson;
    }

    @Override // com.huawei.wearengine.p2p.MessageParcel, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            return;
        }
        writeToParcelBase(parcel);
        parcel.writeString(this.mExtendJson);
    }

    @Override // com.huawei.wearengine.p2p.MessageParcel
    public void readFromParcel(Parcel parcel) {
        if (parcel == null) {
            return;
        }
        readFromParcelBase(parcel);
        this.mExtendJson = parcel.readString();
    }
}
