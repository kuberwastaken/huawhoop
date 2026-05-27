package defpackage;

import com.huawei.ui.commonui.linechart.icommon.IStorageModel;
import com.huawei.ui.commonui.linechart.model.StorageGenericModel;

/* JADX INFO: loaded from: classes7.dex */
public class pgu {
    public static boolean c(IStorageModel iStorageModel) {
        if (iStorageModel instanceof StorageGenericModel) {
            return ((StorageGenericModel) iStorageModel).a() instanceof StorageGenericModel.c;
        }
        return false;
    }
}
