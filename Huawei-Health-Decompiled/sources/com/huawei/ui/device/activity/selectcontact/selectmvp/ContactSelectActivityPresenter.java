package com.huawei.ui.device.activity.selectcontact.selectmvp;

import defpackage.prr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface ContactSelectActivityPresenter {
    void contactsSort(List<prr> list);

    String formatNumbers(String str);

    List<prr> getContacts();

    List<prr> getContactsByInputType(int i, String str);

    int getInputType(String str);

    void getResultList();

    int getSelectedCount();

    void initData();

    void itemSelectDataChange(int i, List<prr> list);

    void itemSelected(int i);

    void onEditTextInputChange(String str);

    int optionalQuantity();

    void saveDataToContactList(String str, String str2, String str3, String str4);

    void selectAll();

    void selectAllDataChange(List<prr> list);

    void setContactData(Map<String, prr> map, Map<String, prr> map2);

    void setContactSortData(prr prrVar);

    void setIsSelectAll(boolean z);

    void setMaxSelectCount(int i);

    void setOldContactList(ArrayList<String> arrayList);
}
