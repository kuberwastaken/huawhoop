package com.amap.api.services.geocoder;

/* JADX INFO: loaded from: classes3.dex */
public class GeocodeQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1458a;
    private String b;
    private String c;

    public GeocodeQuery(String str, String str2) {
        this.f1458a = str;
        this.b = str2;
    }

    public String getLocationName() {
        return this.f1458a;
    }

    public void setLocationName(String str) {
        this.f1458a = str;
    }

    public String getCity() {
        return this.b;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public String getCountry() {
        return this.c;
    }

    public void setCountry(String str) {
        this.c = str;
    }

    public int hashCode() {
        String str = this.b;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f1458a;
        return ((iHashCode + 31) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        String str = this.b;
        if (str == null) {
            if (geocodeQuery.b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.b)) {
            return false;
        }
        String str2 = this.f1458a;
        if (str2 == null) {
            if (geocodeQuery.f1458a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.f1458a)) {
            return false;
        }
        return true;
    }
}
