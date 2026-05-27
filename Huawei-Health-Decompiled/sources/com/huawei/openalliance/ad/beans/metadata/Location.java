package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.a;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.annotations.f;
import com.huawei.openalliance.ad.beans.inner.LocationSwitches;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.openalliance.ad.hq;
import com.huawei.openalliance.ad.utils.bp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Location {

    @a
    private String city;

    @a
    private String cityCode;
    private int clctSource;
    private Long clctTime;

    @a
    private String district;
    private Integer lastfix;

    @d(a = "lat")
    @a
    private Double latitude;

    @f
    private LocationSwitches locationSwitches;

    @d(a = "lon")
    @a
    private Double longitude;

    @a
    private String province;

    @a
    private String provinceCode;

    public boolean m() {
        return (this.longitude == null || this.latitude == null) ? false : true;
    }

    public String l() {
        return this.district;
    }

    public String k() {
        return this.cityCode;
    }

    public String j() {
        return this.city;
    }

    public String i() {
        return this.provinceCode;
    }

    public String h() {
        return this.province;
    }

    public int g() {
        return this.clctSource;
    }

    public LocationSwitches f() {
        return this.locationSwitches;
    }

    public Integer e() {
        return this.lastfix;
    }

    public Long d() {
        return this.clctTime;
    }

    public Double c() {
        return this.latitude;
    }

    public void b(Double d) {
        this.latitude = bp.a(d, 4, 4);
    }

    public Double b() {
        return this.longitude;
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.province = jSONObject.optString(Constants.CA_LOCATION_PROVINCE);
            this.provinceCode = "";
            this.city = jSONObject.optString(Constants.CA_LOCATION_CITY);
            this.cityCode = String.valueOf(jSONObject.optInt(Constants.CA_LOCATION_CITY_CODE));
            this.district = jSONObject.optString(Constants.CA_LOCATION_DISTRICT);
        } catch (Exception unused) {
            hq.c("CA", "parse ca failed");
        }
    }

    public void a(Long l) {
        this.clctTime = l;
    }

    public void a(Double d) {
        this.longitude = bp.a(d, 4, 4);
    }

    public void a(LocationSwitches locationSwitches) {
        this.locationSwitches = locationSwitches;
    }

    public void a(long j) {
        Long l = this.clctTime;
        if (l == null || l.longValue() >= j) {
            return;
        }
        this.lastfix = Integer.valueOf(Math.round((j - this.clctTime.longValue()) / 1000.0f));
    }

    public void a(int i) {
        this.clctSource = i;
    }

    public Location a() {
        Location location = new Location();
        location.longitude = this.longitude;
        location.latitude = this.latitude;
        location.lastfix = this.lastfix;
        location.clctTime = this.clctTime;
        location.clctSource = this.clctSource;
        location.province = this.province;
        location.provinceCode = this.provinceCode;
        location.city = this.city;
        location.cityCode = this.cityCode;
        location.district = this.district;
        return location;
    }

    public Location(Double d, Double d2) {
        this.longitude = bp.a(d, 4, 4);
        this.latitude = bp.a(d2, 4, 4);
    }

    public Location() {
    }
}
