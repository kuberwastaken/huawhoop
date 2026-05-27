package androidx.media3.effect;

import android.graphics.Matrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;

/* JADX INFO: loaded from: classes9.dex */
public final class Crop implements MatrixTransformation {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private Matrix transformationMatrix;

    public Crop(float f, float f2, float f3, float f4) {
        Assertions.checkArgument(f2 > f, "right value " + f2 + " should be greater than left value " + f);
        Assertions.checkArgument(f4 > f3, "top value " + f4 + " should be greater than bottom value " + f3);
        this.left = f;
        this.right = f2;
        this.bottom = f3;
        this.top = f4;
        this.transformationMatrix = new Matrix();
    }

    @Override // androidx.media3.effect.GlMatrixTransformation
    public Size configure(int i, int i2) {
        Assertions.checkArgument(i > 0, "inputWidth must be positive");
        Assertions.checkArgument(i2 > 0, "inputHeight must be positive");
        Matrix matrix = new Matrix();
        this.transformationMatrix = matrix;
        float f = this.left;
        if (f == -1.0f && this.right == 1.0f && this.bottom == -1.0f && this.top == 1.0f) {
            return new Size(i, i2);
        }
        float f2 = this.right;
        float f3 = (f2 - f) / 2.0f;
        float f4 = this.top;
        float f5 = this.bottom;
        float f6 = (f4 - f5) / 2.0f;
        matrix.postTranslate(-((f + f2) / 2.0f), -((f5 + f4) / 2.0f));
        this.transformationMatrix.postScale(1.0f / f3, 1.0f / f6);
        return new Size(Math.round(i * f3), Math.round(i2 * f6));
    }

    @Override // androidx.media3.effect.MatrixTransformation
    public Matrix getMatrix(long j) {
        return (Matrix) Assertions.checkStateNotNull(this.transformationMatrix, "configure must be called first");
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        Size sizeConfigure = configure(i, i2);
        return ((Matrix) Assertions.checkStateNotNull(this.transformationMatrix)).isIdentity() && i == sizeConfigure.getWidth() && i2 == sizeConfigure.getHeight();
    }
}
