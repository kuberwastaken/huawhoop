package defpackage;

import com.huawei.hwlogsmodel.LogUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class omf {
    private LinkedList<Object> e = new LinkedList<>();

    public void c(Integer num) {
        this.e.add(num);
    }

    public void e(Double d) {
        this.e.add(d);
    }

    public void d(String str) {
        this.e.add(str);
    }

    public boolean b() {
        return this.e.isEmpty();
    }

    public boolean d() {
        if (b()) {
            return false;
        }
        Object objPeekFirst = this.e.peekFirst();
        return (objPeekFirst instanceof Integer) || (objPeekFirst instanceof Double);
    }

    public boolean e() {
        return !b() && (this.e.peekFirst() instanceof String);
    }

    public Number a() {
        if (!d()) {
            LogUtil.a("MultilingualAudio_BusinessInput", "first item is not number");
            return 0;
        }
        return (Number) this.e.pollFirst();
    }

    public String c() {
        if (!e()) {
            LogUtil.a("MultilingualAudio_BusinessInput", "first item is not url");
            return "";
        }
        return (String) this.e.pollFirst();
    }

    public omf b(List<Integer> list) {
        if (list.isEmpty()) {
            return this;
        }
        if (this.e.size() != list.size()) {
            LogUtil.a("MultilingualAudio_BusinessInput", "sequence size not equal to data size");
            return this;
        }
        LinkedList<Object> linkedList = new LinkedList<>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(this.e.get(it.next().intValue()));
        }
        omf omfVar = new omf();
        omfVar.e = linkedList;
        return omfVar;
    }

    public String toString() {
        return "BusinessInputParameter{mInputData=" + this.e + '}';
    }
}
