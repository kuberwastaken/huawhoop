package com.huawei.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.cgt;
import defpackage.kqt;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Contact implements Serializable {

    @SerializedName("icon_index")
    private String iconIndex;
    private int index;
    private String name;
    private String note;
    private List<PhoneNumber> phoneNumbers;

    public Contact() {
        this.index = 1;
        this.note = "";
        this.iconIndex = "-1";
    }

    public Contact(String str, String str2, List<PhoneNumber> list) {
        this.index = 1;
        this.note = "";
        this.iconIndex = "-1";
        this.name = (String) kqt.e(str2);
        this.phoneNumbers = (List) kqt.e(list);
        this.iconIndex = (String) kqt.e(str);
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getName() {
        return (String) kqt.e(this.name);
    }

    public void setName(String str) {
        this.name = (String) kqt.e(str);
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return (List) kqt.e(this.phoneNumbers);
    }

    public void setPhoneNumbers(List<PhoneNumber> list) {
        this.phoneNumbers = (List) kqt.e(list);
    }

    public String getNote() {
        return (String) kqt.e(this.note);
    }

    public String getIconIndex() {
        return (String) kqt.e(this.iconIndex);
    }

    public void setIconIndex(String str) {
        this.iconIndex = (String) kqt.e(str);
    }

    public String toString() {
        return "[Contact: name = " + cgt.b(this.name) + ", note = " + this.note + ", icon_index = " + this.iconIndex + ", phoneNumbers = " + this.phoneNumbers + "]";
    }
}
