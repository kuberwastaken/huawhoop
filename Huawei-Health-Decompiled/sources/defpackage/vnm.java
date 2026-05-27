package defpackage;

import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes8.dex */
public class vnm {
    public static void ezl_(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }
}
