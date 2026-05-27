package com.huawei.watchface.mvp.model.datatype;

import com.huawei.watchface.ea;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Tlv {
    private List<Tlv> childList;
    private int length;
    private String tag;
    private String value;

    public Tlv(String str, int i, String str2, List<Tlv> list) {
        this.tag = str;
        this.length = i;
        this.value = str2;
        this.childList = list;
    }

    public Tlv(String str, int i, String str2) {
        this.tag = str;
        this.length = i;
        this.value = str2;
    }

    public Tlv() {
    }

    public String getTag() {
        return (String) ea.a(this.tag);
    }

    public void setTag(String str) {
        this.tag = (String) ea.a(str);
    }

    public int getLength() {
        return ((Integer) ea.a(Integer.valueOf(this.length))).intValue();
    }

    public void setLength(int i) {
        this.length = ((Integer) ea.a(Integer.valueOf(i))).intValue();
    }

    public String getValue() {
        return (String) ea.a(this.value);
    }

    public void setValue(String str) {
        this.value = (String) ea.a(str);
    }

    public List<Tlv> getChildList() {
        return (List) ea.a(this.childList);
    }

    public void setChildList(List<Tlv> list) {
        this.childList = (List) ea.a(list);
    }
}
