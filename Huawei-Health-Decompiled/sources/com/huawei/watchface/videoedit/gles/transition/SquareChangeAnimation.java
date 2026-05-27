package com.huawei.watchface.videoedit.gles.transition;

import com.huawei.watchface.videoedit.gles.animations.MeshChanger;

/* JADX INFO: loaded from: classes8.dex */
public class SquareChangeAnimation implements MeshChanger {
    public static final String BIG = "big";
    private static final float DELTA = 0.05f;
    public static final String DOWN = "down";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    private static final float SCALE_EXTRA = 1.5f;
    public static final String SMALL = "small";
    public static final String UP = "up";
    private float mDelta = 0.05f;
    private final String mType;

    public SquareChangeAnimation(String str) {
        this.mType = str;
    }

    public MeshChanger setDelta(float f) {
        this.mDelta = f;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    @Override // com.huawei.watchface.videoedit.gles.animations.MeshChanger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void changeMesh(float[] r8, float r9, int r10) {
        /*
            r7 = this;
            java.lang.String r0 = r7.mType
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L9
            return
        L9:
            java.lang.String r0 = r7.mType
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r1) {
                case 3739: goto L52;
                case 97536: goto L47;
                case 3089570: goto L3c;
                case 3317767: goto L31;
                case 108511772: goto L26;
                case 109548807: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L5e
        L1b:
            java.lang.String r1 = "small"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L24
            goto L5e
        L24:
            r0 = r2
            goto L5f
        L26:
            java.lang.String r1 = "right"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2f
            goto L5e
        L2f:
            r0 = r3
            goto L5f
        L31:
            java.lang.String r1 = "left"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3a
            goto L5e
        L3a:
            r0 = r4
            goto L5f
        L3c:
            java.lang.String r1 = "down"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L45
            goto L5e
        L45:
            r0 = r5
            goto L5f
        L47:
            java.lang.String r1 = "big"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            goto L5e
        L50:
            r0 = r6
            goto L5f
        L52:
            java.lang.String r1 = "up"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5c
            goto L5e
        L5c:
            r0 = 0
            goto L5f
        L5e:
            r0 = -1
        L5f:
            if (r0 == 0) goto L8e
            r1 = 1069547520(0x3fc00000, float:1.5)
            if (r0 == r6) goto L87
            if (r0 == r5) goto L81
            if (r0 == r4) goto L7b
            if (r0 == r3) goto L75
            if (r0 == r2) goto L6e
            return
        L6e:
            float r0 = r7.mDelta
            float r0 = r0 * r1
            r7.small(r8, r9, r0)
            goto L93
        L75:
            float r0 = r7.mDelta
            r7.right(r8, r9, r0)
            goto L93
        L7b:
            float r0 = r7.mDelta
            r7.left(r8, r9, r0)
            goto L93
        L81:
            float r0 = r7.mDelta
            r7.down(r8, r9, r0)
            goto L93
        L87:
            float r0 = r7.mDelta
            float r0 = r0 * r1
            r7.big(r8, r9, r0)
            goto L93
        L8e:
            float r0 = r7.mDelta
            r7.up(r8, r9, r0)
        L93:
            com.huawei.watchface.videoedit.utils.Utils.vboBindData(r10, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.watchface.videoedit.gles.transition.SquareChangeAnimation.changeMesh(float[], float, int):void");
    }

    private void up(float[] fArr, float f, float f2) {
        float f3 = 2.0f * f2;
        setCoordinateUv(fArr, 1.0f - ((1.0f - f) * f3), f3 * f, f2, 1.0f - f2);
    }

    private void down(float[] fArr, float f, float f2) {
        float f3 = 2.0f * f2;
        setCoordinateUv(fArr, 1.0f - (f3 * f), f3 * (1.0f - f), f2, 1.0f - f2);
    }

    private void left(float[] fArr, float f, float f2) {
        float f3 = 2.0f * f2;
        setCoordinateUv(fArr, 1.0f - f2, f2, f3 * f, 1.0f - (f3 * (1.0f - f)));
    }

    private void right(float[] fArr, float f, float f2) {
        float f3 = 2.0f * f2;
        setCoordinateUv(fArr, 1.0f - f2, f2, f3 * (1.0f - f), 1.0f - (f3 * f));
    }

    private void big(float[] fArr, float f, float f2) {
        float f3 = f2 * f;
        float f4 = 1.0f - f3;
        setCoordinateUv(fArr, f4, f3, f3, f4);
    }

    private void small(float[] fArr, float f, float f2) {
        float f3 = f2 * (1.0f - f);
        float f4 = 1.0f - f3;
        setCoordinateUv(fArr, f4, f3, f3, f4);
    }

    private void setCoordinateUv(float[] fArr, float f, float f2, float f3, float f4) {
        fArr[11] = f;
        fArr[15] = f;
        fArr[3] = f2;
        fArr[7] = f2;
        fArr[2] = f3;
        fArr[10] = f3;
        fArr[6] = f4;
        fArr[14] = f4;
    }
}
