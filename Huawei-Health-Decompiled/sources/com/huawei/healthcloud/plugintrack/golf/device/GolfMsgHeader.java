package com.huawei.healthcloud.plugintrack.golf.device;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public class GolfMsgHeader {
    public static final int INVALID_MSG_ID = -1;
    public static final int MAP_STYLE_PIC = 0;
    public static final int MAP_STYLE_VECTOR = 1;
    public static final int RSP_STATE_FAIL = 1;
    public static final int RSP_STATE_SUCCESS = 0;
    private static MsgIdGenerator sMsgIdGenerator = new MsgIdGenerator();
    private int mBusinessHeadLength;
    private int mBusinessType;
    private int mMapStyle;
    private int mMessageId;
    private int mRspState;
    private int mTotalLength;
    private int mVersion;

    public static int getByteSize() {
        return 36;
    }

    private GolfMsgHeader() {
    }

    public GolfMsgHeader(byte[] bArr) {
        if (bArr == null || bArr.length != getByteSize()) {
            return;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        this.mBusinessType = byteBufferWrap.getInt();
        this.mVersion = byteBufferWrap.getInt();
        this.mTotalLength = byteBufferWrap.getInt();
        this.mBusinessHeadLength = byteBufferWrap.getInt();
        this.mMessageId = byteBufferWrap.getInt();
        this.mRspState = byteBufferWrap.getInt();
        this.mMapStyle = byteBufferWrap.getInt();
    }

    public int getMapStyle() {
        return this.mMapStyle;
    }

    public int getRspState() {
        return this.mRspState;
    }

    public int getBusinessType() {
        return this.mBusinessType;
    }

    public int getTotalLength() {
        return this.mTotalLength;
    }

    public int getBusinessHeadLength() {
        return this.mBusinessHeadLength;
    }

    public int getMessageId() {
        return this.mMessageId;
    }

    public static int newMsgId() {
        return sMsgIdGenerator.newMsgId();
    }

    public byte[] getBytes() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getByteSize());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(this.mBusinessType);
        byteBufferAllocate.putInt(this.mVersion);
        byteBufferAllocate.putInt(this.mTotalLength);
        byteBufferAllocate.putInt(this.mBusinessHeadLength);
        byteBufferAllocate.putInt(this.mMessageId);
        byteBufferAllocate.putInt(this.mRspState);
        byteBufferAllocate.putInt(this.mMapStyle);
        byteBufferAllocate.flip();
        return byteBufferAllocate.array();
    }

    public String toString() {
        return "GolfMsgHeader{mBusinessType=" + this.mBusinessType + ", mVersion=" + this.mVersion + ", mTotalLength=" + this.mTotalLength + ", mBusinessHeadLength=" + this.mBusinessHeadLength + ", mMessageId=" + this.mMessageId + ", mRspState=" + this.mRspState + ", mMapStyle=" + this.mMapStyle + '}';
    }

    public static final class Builder {
        private int mBusinessHeadLength;
        private int mBusinessType;
        private int mDataLength;
        private int mMapStyle;
        private int mMessageId;
        private int mVersion;
        private int responseState;

        public Builder setBusinessType(int i) {
            this.mBusinessType = i;
            return this;
        }

        public Builder setVersion(int i) {
            this.mVersion = i;
            return this;
        }

        public Builder setBusinessHeadLength(int i) {
            this.mBusinessHeadLength = i;
            return this;
        }

        public Builder setDataLength(int i) {
            this.mDataLength = i;
            return this;
        }

        public Builder setMessageId(int i) {
            this.mMessageId = i;
            return this;
        }

        public Builder setResponseState(int i) {
            this.responseState = i;
            return this;
        }

        public Builder setMapStyle(int i) {
            this.mMapStyle = i;
            return this;
        }

        public GolfMsgHeader builder() {
            GolfMsgHeader golfMsgHeader = new GolfMsgHeader();
            golfMsgHeader.mBusinessType = this.mBusinessType;
            golfMsgHeader.mVersion = this.mVersion;
            golfMsgHeader.mTotalLength = GolfMsgHeader.getByteSize() + this.mBusinessHeadLength + this.mDataLength;
            golfMsgHeader.mBusinessHeadLength = this.mBusinessHeadLength;
            golfMsgHeader.mMessageId = this.mMessageId;
            golfMsgHeader.mRspState = this.responseState;
            golfMsgHeader.mMapStyle = this.mMapStyle;
            return golfMsgHeader;
        }
    }

    static class MsgIdGenerator {
        private static final int MAX_MSG_ID = 1000000;
        int mMsgId;

        private MsgIdGenerator() {
            this.mMsgId = 0;
        }

        protected int newMsgId() {
            int i;
            synchronized (this) {
                int i2 = this.mMsgId + 1;
                this.mMsgId = i2;
                i = i2 % 1000000;
                this.mMsgId = i;
            }
            return i;
        }

        public int getMsgId() {
            int i;
            synchronized (this) {
                i = this.mMsgId;
            }
            return i;
        }
    }
}
