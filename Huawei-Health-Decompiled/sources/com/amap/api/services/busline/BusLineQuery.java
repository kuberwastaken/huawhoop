package com.amap.api.services.busline;

/* JADX INFO: loaded from: classes9.dex */
public class BusLineQuery implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1428a;
    private String b;
    private SearchType e;
    private int c = 20;
    private int d = 1;
    private String f = "base";

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f1428a = str;
        this.e = searchType;
        this.b = str2;
    }

    public SearchType getCategory() {
        return this.e;
    }

    public String getQueryString() {
        return this.f1428a;
    }

    public void setQueryString(String str) {
        this.f1428a = str;
    }

    public String getCity() {
        return this.b;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public int getPageSize() {
        return this.c;
    }

    public void setPageSize(int i) {
        this.c = i;
    }

    public int getPageNumber() {
        return this.d;
    }

    public void setPageNumber(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.d = i;
    }

    public void setCategory(SearchType searchType) {
        this.e = searchType;
    }

    public String getExtensions() {
        return this.f;
    }

    public void setExtensions(String str) {
        this.f = str;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BusLineQuery m317clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f1428a, this.e, this.b);
        busLineQuery.setPageNumber(this.d);
        busLineQuery.setPageSize(this.c);
        busLineQuery.setExtensions(this.f);
        return busLineQuery;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f1428a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f1428a)) {
            return false;
        }
        if (this.b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.b)) {
            return false;
        }
        return this.c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.e) == 0;
    }

    public int hashCode() {
        SearchType searchType = this.e;
        int iHashCode = searchType == null ? 0 : searchType.hashCode();
        String str = this.b;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        int i = this.d;
        int i2 = this.c;
        String str2 = this.f1428a;
        int iHashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.f;
        return ((((((((((iHashCode + 31) * 31) + iHashCode2) * 31) + i) * 31) + i2) * 31) + iHashCode3) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.e != busLineQuery.e) {
            return false;
        }
        String str = this.b;
        if (str == null) {
            if (busLineQuery.b != null) {
                return false;
            }
        } else if (!str.equals(busLineQuery.b)) {
            return false;
        }
        if (this.d != busLineQuery.d || this.c != busLineQuery.c) {
            return false;
        }
        String str2 = this.f1428a;
        if (str2 == null) {
            if (busLineQuery.f1428a != null) {
                return false;
            }
        } else if (!str2.equals(busLineQuery.f1428a)) {
            return false;
        }
        String str3 = this.f;
        if (str3 == null) {
            if (busLineQuery.f != null) {
                return false;
            }
        } else if (!str3.equals(busLineQuery.f)) {
            return false;
        }
        return true;
    }
}
