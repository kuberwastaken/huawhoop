package androidx.media3.effect;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes2.dex */
public interface MatrixTransformation extends GlMatrixTransformation {
    Matrix getMatrix(long j);

    @Override // androidx.media3.effect.GlMatrixTransformation
    default float[] getGlMatrixArray(long j) {
        return MatrixUtils.getGlMatrixArray(getMatrix(j));
    }
}
