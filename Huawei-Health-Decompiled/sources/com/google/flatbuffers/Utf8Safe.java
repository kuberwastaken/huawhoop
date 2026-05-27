package com.google.flatbuffers;

import androidx.media3.extractor.ts.PsExtractor;
import com.google.flatbuffers.Utf8;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class Utf8Safe extends Utf8 {
    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    public static String decodeUtf8Array(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = bArr[i];
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (Utf8.DecodeUtil.isOneByte(b2)) {
                Utf8.DecodeUtil.handleOneByte(b2, cArr, i5);
                i5++;
                i = i6;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (!Utf8.DecodeUtil.isOneByte(b3)) {
                        break;
                    }
                    i++;
                    Utf8.DecodeUtil.handleOneByte(b3, cArr, i5);
                    i5++;
                }
            } else {
                if (Utf8.DecodeUtil.isTwoBytes(b2)) {
                    if (i6 >= i3) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.handleTwoBytes(b2, bArr[i6], cArr, i5);
                    i += 2;
                } else if (Utf8.DecodeUtil.isThreeBytes(b2)) {
                    if (i6 >= i3 - 1) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.handleThreeBytes(b2, bArr[i6], bArr[i + 2], cArr, i5);
                    i += 3;
                } else {
                    if (i6 >= i3 - 2) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.handleFourBytes(b2, bArr[i6], bArr[i + 2], bArr[i + 3], cArr, i5);
                    i += 4;
                    i5 += 2;
                }
                i5++;
            }
        }
        return new String(cArr, 0, i5);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i, int i2) {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (Utf8.DecodeUtil.isOneByte(b2)) {
                Utf8.DecodeUtil.handleOneByte(b2, cArr, i5);
                i5++;
                i = i6;
                while (i < i3) {
                    byte b3 = byteBuffer.get(i);
                    if (!Utf8.DecodeUtil.isOneByte(b3)) {
                        break;
                    }
                    i++;
                    Utf8.DecodeUtil.handleOneByte(b3, cArr, i5);
                    i5++;
                }
            } else {
                if (Utf8.DecodeUtil.isTwoBytes(b2)) {
                    if (i6 >= i3) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i6), cArr, i5);
                    i += 2;
                } else if (Utf8.DecodeUtil.isThreeBytes(b2)) {
                    if (i6 >= i3 - 1) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i6), byteBuffer.get(i + 2), cArr, i5);
                    i += 3;
                } else {
                    if (i6 >= i3 - 2) {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                    Utf8.DecodeUtil.handleFourBytes(b2, byteBuffer.get(i6), byteBuffer.get(i + 2), byteBuffer.get(i + 3), cArr, i5);
                    i += 4;
                    i5 += 2;
                }
                i5++;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.flatbuffers.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }

    @Override // com.google.flatbuffers.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        }
        return decodeUtf8Buffer(byteBuffer, i, i2);
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i2 = 0;
        while (i2 < length) {
            try {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i2, (byte) cCharAt);
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                i = iPosition;
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (i - byteBuffer.position()) + 1)));
            }
        }
        if (i2 == length) {
            byteBuffer.position(iPosition + i2);
            return;
        }
        int i3 = iPosition + i2;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 < 128) {
                byteBuffer.put(i3, (byte) cCharAt2);
            } else if (cCharAt2 < 2048) {
                int i4 = i3 + 1;
                try {
                    byteBuffer.put(i3, (byte) ((cCharAt2 >>> 6) | PsExtractor.AUDIO_STREAM));
                    byteBuffer.put(i4, (byte) ((cCharAt2 & '?') | 128));
                    i3 = i4;
                } catch (IndexOutOfBoundsException unused2) {
                    i = i4;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (i - byteBuffer.position()) + 1)));
                }
            } else if (cCharAt2 < 55296 || 57343 < cCharAt2) {
                int i5 = i3 + 1;
                byteBuffer.put(i3, (byte) ((cCharAt2 >>> '\f') | 224));
                i3 += 2;
                byteBuffer.put(i5, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                byteBuffer.put(i3, (byte) ((cCharAt2 & '?') | 128));
            } else {
                int i6 = i2 + 1;
                if (i6 != length) {
                    try {
                        char cCharAt3 = charSequence.charAt(i6);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            i = i3 + 1;
                            try {
                                byteBuffer.put(i3, (byte) ((codePoint >>> 18) | 240));
                                int i7 = i3 + 2;
                                try {
                                    byteBuffer.put(i, (byte) (((codePoint >>> 12) & 63) | 128));
                                    i3 += 3;
                                    byteBuffer.put(i7, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i3, (byte) ((codePoint & 63) | 128));
                                    i2 = i6;
                                } catch (IndexOutOfBoundsException unused3) {
                                    i3 = i7;
                                    i = i3;
                                    i2 = i6;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (i - byteBuffer.position()) + 1)));
                                }
                            } catch (IndexOutOfBoundsException unused4) {
                                i2 = i6;
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (byteBuffer.position() + Math.max(i2, (i - byteBuffer.position()) + 1)));
                            }
                        } else {
                            i2 = i6;
                        }
                    } catch (IndexOutOfBoundsException unused5) {
                    }
                }
                throw new UnpairedSurrogateException(i2, length);
            }
            i2++;
            i3++;
        }
        byteBuffer.position(i3);
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char cCharAt;
        int length = charSequence.length();
        int i6 = i2 + i;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i) < i6 && (cCharAt = charSequence.charAt(i7)) < 128) {
            bArr[i5] = (byte) cCharAt;
            i7++;
        }
        if (i7 == length) {
            return i + length;
        }
        int i8 = i + i7;
        while (i7 < length) {
            char cCharAt2 = charSequence.charAt(i7);
            if (cCharAt2 >= 128 || i8 >= i6) {
                if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                    i8 += 2;
                    bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                        if (i8 <= i6 - 4) {
                            int i10 = i7 + 1;
                            if (i10 != charSequence.length()) {
                                char cCharAt3 = charSequence.charAt(i10);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                    bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i11 = i8 + 3;
                                    bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i8 += 4;
                                    bArr[i11] = (byte) ((codePoint & 63) | 128);
                                    i7 = i10;
                                } else {
                                    i7 = i10;
                                }
                            }
                            throw new UnpairedSurrogateException(i7 - 1, length);
                        }
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                            throw new UnpairedSurrogateException(i7, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                    }
                    bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                    bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i3 = i8 + 3;
                    bArr[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                }
                i7++;
            } else {
                i3 = i8 + 1;
                bArr[i8] = (byte) cCharAt2;
            }
            i8 = i3;
            i7++;
        }
        return i8;
    }

    @Override // com.google.flatbuffers.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            return;
        }
        encodeUtf8Buffer(charSequence, byteBuffer);
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }
}
