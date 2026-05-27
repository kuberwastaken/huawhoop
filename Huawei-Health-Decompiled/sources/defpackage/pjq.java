package defpackage;

import android.util.SparseArray;
import com.huawei.ui.commonui.tablewidget.ViewHolder;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: loaded from: classes7.dex */
public class pjq {
    private SparseArray<Deque<ViewHolder>> d = new SparseArray<>(6);

    public void c(ViewHolder viewHolder) {
        Deque<ViewHolder> arrayDeque = this.d.get(viewHolder.getItemType());
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            this.d.put(viewHolder.getItemType(), arrayDeque);
        }
        arrayDeque.push(viewHolder);
    }

    public ViewHolder c(int i) {
        Deque<ViewHolder> deque = this.d.get(i);
        if (deque == null || deque.isEmpty()) {
            return null;
        }
        return deque.pop();
    }
}
