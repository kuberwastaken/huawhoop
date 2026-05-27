package com.huawei.hihealth.dictionary.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hihealth.dictionary.utils.DicDataTypeUtil;
import health.compact.a.util.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HiHealthDictionary implements Mergable<HiHealthDictionary> {

    @SerializedName("dictTypes")
    private List<HiHealthDictType> e;

    @SerializedName("version")
    private int g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Map<Integer, HiHealthDictType> f4294a = new HashMap();
    private transient Map<Integer, HiHealthDictStat> b = new HashMap();
    private transient Map<Integer, HiHealthDictField> c = new HashMap();
    private transient Map<Integer, HiHealthDictType> j = new HashMap();
    private transient Map<Integer, HiHealthDictType> d = new HashMap();

    @Override // com.huawei.hihealth.dictionary.model.Mergable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void merge(HiHealthDictionary hiHealthDictionary) {
        if (this.g > hiHealthDictionary.h()) {
            LogUtil.d("HiH_HiHealthDictionary", "merge failed. src version:", Integer.valueOf(this.g), " dst version:", Integer.valueOf(hiHealthDictionary.h()));
        } else {
            this.f4294a.putAll(hiHealthDictionary.j());
        }
    }

    public List<Integer> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.f4294a.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, HiHealthDictType>> it = this.f4294a.entrySet().iterator();
        while (it.hasNext()) {
            HiHealthDictType value = it.next().getValue();
            int iN = value.n();
            int i = value.i();
            if (i != 0 && iN < DicDataTypeUtil.DataType.ONE_SECOND_SPORT_DATA_TYPE.value()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public HiHealthDictType a(int i) {
        return this.f4294a.get(Integer.valueOf(i));
    }

    public HiHealthDictStat b(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public HiHealthDictField e(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public HiHealthDictType c(int i) {
        return this.j.get(Integer.valueOf(i));
    }

    public HiHealthDictType d(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    public void d() {
        LogUtil.b("HiH_HiHealthDictionary", "start to generate validateExpressions.");
        List<HiHealthDictType> list = this.e;
        if (list == null || list.isEmpty()) {
            LogUtil.d("HiH_HiHealthDictionary", "There is no dictTypes.");
            return;
        }
        Iterator<HiHealthDictType> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public void e() {
        LogUtil.b("HiH_HiHealthDictionary", "start to generate dict ids.");
        List<HiHealthDictType> list = this.e;
        if (list == null || list.isEmpty()) {
            LogUtil.d("HiH_HiHealthDictionary", "There is no dictTypes.");
            return;
        }
        for (HiHealthDictType hiHealthDictType : this.e) {
            Iterator<HiHealthDictField> it = hiHealthDictType.j().iterator();
            while (it.hasNext()) {
                it.next().d(hiHealthDictType.n());
            }
        }
    }

    public void c() {
        LogUtil.b("HiH_HiHealthDictionary", "start to generate cache maps.");
        for (HiHealthDictType hiHealthDictType : this.e) {
            if (this.f4294a.containsKey(Integer.valueOf(hiHealthDictType.n()))) {
                LogUtil.d("HiH_HiHealthDictionary", "Duplicated typeId for dictType:", hiHealthDictType.g());
                throw new IllegalArgumentException("Duplicated typeId for dictType:" + hiHealthDictType.g());
            }
            this.f4294a.put(Integer.valueOf(hiHealthDictType.n()), hiHealthDictType);
            for (HiHealthDictField hiHealthDictField : hiHealthDictType.j()) {
                if (h(hiHealthDictField.e())) {
                    LogUtil.d("HiH_HiHealthDictionary", "Duplicated typeId for field:", hiHealthDictField.d());
                    throw new IllegalArgumentException("Duplicated typeId for field:" + hiHealthDictField.d());
                }
                this.c.put(Integer.valueOf(hiHealthDictField.e()), hiHealthDictField);
                this.d.put(Integer.valueOf(hiHealthDictField.e()), hiHealthDictType);
                if (hiHealthDictField.b() != null) {
                    for (HiHealthDictStat hiHealthDictStat : hiHealthDictField.b()) {
                        if (h(hiHealthDictStat.c())) {
                            LogUtil.d("HiH_HiHealthDictionary", "Duplicated typeId for stat:", hiHealthDictStat.e());
                            throw new IllegalArgumentException("Duplicated typeId for stat:" + hiHealthDictStat.e());
                        }
                        this.b.put(Integer.valueOf(hiHealthDictStat.c()), hiHealthDictStat);
                        this.j.put(Integer.valueOf(hiHealthDictStat.c()), hiHealthDictType);
                    }
                }
            }
            hiHealthDictType.b();
        }
    }

    public boolean g() {
        int i = this.g;
        if (i < 0) {
            LogUtil.d("HiH_HiHealthDictionary", "dict version error:", Integer.valueOf(i));
            return false;
        }
        List<HiHealthDictType> list = this.e;
        if (list == null || list.isEmpty()) {
            LogUtil.d("HiH_HiHealthDictionary", "dictTypes is null or empty.");
            return false;
        }
        Iterator<HiHealthDictType> it = this.e.iterator();
        while (it.hasNext()) {
            if (!it.next().k()) {
                LogUtil.d("HiH_HiHealthDictionary", "dictType data is illegal.");
                return false;
            }
        }
        return true;
    }

    public int h() {
        return this.g;
    }

    public void f(int i) {
        this.g = i;
    }

    private Map<Integer, HiHealthDictType> j() {
        return this.f4294a;
    }

    private boolean h(int i) {
        return this.c.containsKey(Integer.valueOf(i)) || this.b.containsKey(Integer.valueOf(i));
    }
}
