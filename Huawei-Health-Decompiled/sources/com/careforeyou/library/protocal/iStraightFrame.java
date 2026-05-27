package com.careforeyou.library.protocal;

import com.careforeyou.library.bean.CsFatScale;
import com.careforeyou.library.enums.EnumProcessResult;
import defpackage.wb;

/* JADX INFO: loaded from: classes3.dex */
public interface iStraightFrame {
    CsFatScale getFatScale();

    EnumProcessResult process(byte[] bArr, String str) throws wb;
}
