package com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder;

import androidx.media3.extractor.ts.TsExtractor;
import com.huawei.hihealthservice.old.model.OldToNewMotionPath;
import com.huawei.hwlogsmodel.LogUtil;
import com.huawei.up.model.UserInfomation;
import defpackage.vjl;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class FitDesign {

    public static class e extends BaseData {
        int c = 14;
        int b = 100;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11063a = 15;
        private String e = ".FIT";
        public int d = 0;

        @Override // com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.BaseData
        public DataOutputStream write(DataOutputStream dataOutputStream) throws IOException {
            int i = this.d;
            byte[] bArr = {14, 32, -90, 82, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255), 46, 70, 73, 84};
            vjl vjlVar = new vjl();
            dataOutputStream.write(bArr);
            long value = vjlVar.getValue();
            dataOutputStream.write((byte) (value & 255));
            dataOutputStream.write((byte) ((value >> 8) & 255));
            return dataOutputStream;
        }

        @Override // com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.BaseData
        public int getSize() {
            return this.c;
        }
    }

    public static class d extends BaseData {
        public short c = 0;
        public short d = 0;

        @Override // com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.BaseData
        public int getSize() {
            return 1;
        }

        @Override // com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.BaseData
        public DataOutputStream write(DataOutputStream dataOutputStream) throws IOException {
            LogUtil.b("FitFile_BaseMessageHead", "write message mLocalMessageType is ", Short.valueOf(this.d));
            dataOutputStream.writeByte((byte) ((((this.c & 1) << 6) | (this.d & 15)) & 255));
            return dataOutputStream;
        }
    }

    public static class a extends BaseData {
        public FieldType b;
        public short c;
        public Object d;

        public a(short s, FieldType fieldType, Object obj, double d, double d2) {
            this.c = s;
            this.b = fieldType;
            this.d = c(obj, d, d2);
            this.mSize = FitDesign.a(this.b);
        }

        @Override // com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.BaseData
        public DataOutputStream write(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeByte(this.c);
            dataOutputStream.writeByte(this.mSize);
            dataOutputStream.writeByte(this.b.getTypeId());
            return dataOutputStream;
        }

        @Override // com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.BaseData
        public int getSize() {
            return this.mSize;
        }

        public Object c(Object obj, double d, double d2) {
            return obj instanceof Number ? (d == 1.0d && d2 == 0.0d) ? obj : Long.valueOf(Math.round((((Number) obj).doubleValue() + d2) * d)) : obj;
        }
    }

    /* JADX INFO: renamed from: com.huawei.ui.thirdpartservice.syncdata.fit.FitEncoder.FitDesign$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[FieldType.values().length];
            c = iArr;
            try {
                iArr[FieldType.ENUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[FieldType.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[FieldType.SINT8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[FieldType.UINT8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[FieldType.SINT16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[FieldType.UINT16.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[FieldType.SINT32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[FieldType.UINT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[FieldType.SINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[FieldType.UINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[FieldType.FLOAT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                c[FieldType.FLOAT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                c[FieldType.STRING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public static byte a(FieldType fieldType) {
        switch (AnonymousClass4.c[fieldType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return (byte) 1;
            case 5:
            case 6:
                return (byte) 2;
            case 7:
            case 8:
                return (byte) 4;
            case 9:
            case 10:
                return (byte) 8;
            case 11:
                return (byte) 4;
            case 12:
                return (byte) 8;
            case 13:
                return (byte) 32;
            default:
                return (byte) 0;
        }
    }

    public enum FieldType {
        ENUM(0),
        SINT8(1),
        UINT8(2),
        SINT16(131),
        UINT16(UserInfomation.WEIGHT_DEFAULT_ENGLISH),
        SINT32(OldToNewMotionPath.SPORT_TYPE_VOLLEYBALL),
        UINT32(134),
        STRING(7),
        FLOAT32(TsExtractor.TS_STREAM_TYPE_DTS_HD),
        FLOAT64(137),
        BYTE(13),
        SINT64(142),
        UINT64(143);

        private final int mTypeId;

        FieldType(int i) {
            this.mTypeId = i;
        }

        public int getTypeId() {
            return this.mTypeId;
        }
    }

    public enum MessageNum {
        NONE(-1),
        FILE_ID(0),
        ACTIVITY(34),
        SESSION(18),
        LAP(19),
        RECORD(20),
        EVENT(21),
        DEVICE_INFO(23);

        private final int mTypeId;

        MessageNum(int i) {
            this.mTypeId = i;
        }

        public int getTypeId() {
            return this.mTypeId;
        }
    }

    public enum ActivityType {
        GENERIC(0),
        RUNNING(1),
        CYCLING(2),
        FITNESS_EQUIPMENT(4),
        SWIMMING(5),
        TENNIS(8),
        TRAINING(10),
        WALKING(11),
        CROSS_COUNTRY_SKIING(12),
        ALPINE_SKIING(13),
        SNOWBOARDING(14),
        ROWING(15),
        ROCK_CLIMBING(31),
        SAILING(32),
        ICE_SKATING(33),
        STAND_UP_PADDLEBOARDING(37),
        SURFING(38),
        KAYAKING(41),
        HIIT(62);

        private final int typeId;

        ActivityType(int i) {
            this.typeId = i;
        }

        public int getTypeId() {
            return this.typeId;
        }
    }

    public enum SubActivityType {
        GENERIC(0),
        TREADMILL(1),
        STREET(2),
        TRAIL(3),
        TRACK(4),
        INDOOR_CYCLING(6),
        ROAD(7),
        ELLIPTICAL(15),
        STAIR_CLIMBING(16),
        LAP_SWIMMING(17),
        OPEN_WATER(18),
        STRENGTH_TRAINING(20),
        EXERCISE(23),
        INDOOR_WALKING(27),
        CASUAL_WALKING(30),
        BACKCOUNTRY(37),
        SKATE_SKIING(42),
        YOGA(43),
        PILATES(44),
        HIIT(70),
        INVALID(255);

        private final int typeId;

        SubActivityType(int i) {
            this.typeId = i;
        }

        public int getTypeId() {
            return this.typeId;
        }
    }
}
