package com.huawei.hwmap.model;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ReverseGeocodeResponse {
    private String returnCode;
    private String returnDesc;
    private List<Site> sites;

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(String str) {
        this.returnCode = str;
    }

    public List<Site> getSites() {
        return this.sites;
    }

    public void setSites(List<Site> list) {
        this.sites = list;
    }

    public String getReturnDesc() {
        return this.returnDesc;
    }

    public void setReturnDesc(String str) {
        this.returnDesc = str;
    }

    public String toString() {
        return "ReverseGeocodeResponse{returnCode='" + this.returnCode + "', sites=" + this.sites + ", returnDesc='" + this.returnDesc + "'}";
    }

    public static class Site {
        private Address address;
        private boolean aoiFlag;
        private String formatAddress;
        private Location location;
        private String name;
        private Poi poi;
        private String siteId;
        private Viewport viewport;

        public String getFormatAddress() {
            return this.formatAddress;
        }

        public void setFormatAddress(String str) {
            this.formatAddress = str;
        }

        public Address getAddress() {
            return this.address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public boolean isAoiFlag() {
            return this.aoiFlag;
        }

        public void setAoiFlag(boolean z) {
            this.aoiFlag = z;
        }

        public Poi getPoi() {
            return this.poi;
        }

        public void setPoi(Poi poi) {
            this.poi = poi;
        }

        public Viewport getViewport() {
            return this.viewport;
        }

        public void setViewport(Viewport viewport) {
            this.viewport = viewport;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getSiteId() {
            return this.siteId;
        }

        public void setSiteId(String str) {
            this.siteId = str;
        }

        public Location getLocation() {
            return this.location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String toString() {
            return "Site{formatAddress='" + this.formatAddress + "', address=" + this.address + ", aoiFlag=" + this.aoiFlag + ", poi=" + this.poi + ", viewport=" + this.viewport + ", name='" + this.name + "', siteId='" + this.siteId + "', location=" + this.location + '}';
        }
    }

    public static class Address {
        private String adminArea;
        private String adminCode;
        private String city;
        private String cityCode;
        private String country;
        private String countryCode;
        private String locality;
        private String subAdminArea;
        private String subLocality;
        private String tertiaryAdminArea;

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public String getTertiaryAdminArea() {
            return this.tertiaryAdminArea;
        }

        public void setTertiaryAdminArea(String str) {
            this.tertiaryAdminArea = str;
        }

        public String getSubLocality() {
            return this.subLocality;
        }

        public void setSubLocality(String str) {
            this.subLocality = str;
        }

        public String getCityCode() {
            return this.cityCode;
        }

        public void setCityCode(String str) {
            this.cityCode = str;
        }

        public String getLocality() {
            return this.locality;
        }

        public void setLocality(String str) {
            this.locality = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getAdminArea() {
            return this.adminArea;
        }

        public void setAdminArea(String str) {
            this.adminArea = str;
        }

        public String getAdminCode() {
            return this.adminCode;
        }

        public void setAdminCode(String str) {
            this.adminCode = str;
        }

        public String getSubAdminArea() {
            return this.subAdminArea;
        }

        public void setSubAdminArea(String str) {
            this.subAdminArea = str;
        }

        public String toString() {
            return "Address{country='" + this.country + "', city='" + this.city + "', tertiaryAdminArea='" + this.tertiaryAdminArea + "', subLocality='" + this.subLocality + "', cityCode='" + this.cityCode + "', locality='" + this.locality + "', countryCode='" + this.countryCode + "', adminArea='" + this.adminArea + "', adminCode='" + this.adminCode + "', subAdminArea='" + this.subAdminArea + "'}";
        }
    }

    public static class Poi {
        private List<String> hwPoiTypes;
        private String internationalPhone;
        private List<String> poiTypes;
        private double rating;

        public double getRating() {
            return this.rating;
        }

        public void setRating(double d) {
            this.rating = d;
        }

        public List<String> getPoiTypes() {
            return this.poiTypes;
        }

        public void setPoiTypes(List<String> list) {
            this.poiTypes = list;
        }

        public List<String> getHwPoiTypes() {
            return this.hwPoiTypes;
        }

        public void setHwPoiTypes(List<String> list) {
            this.hwPoiTypes = list;
        }

        public String getInternationalPhone() {
            return this.internationalPhone;
        }

        public void setInternationalPhone(String str) {
            this.internationalPhone = str;
        }

        public String toString() {
            return "Poi{rating=" + this.rating + ", poiTypes=" + this.poiTypes + ", hwPoiTypes=" + this.hwPoiTypes + ", internationalPhone='" + this.internationalPhone + "'}";
        }
    }

    public static class Viewport {
        private Location northeast;
        private Location southwest;

        public Location getSouthwest() {
            return this.southwest;
        }

        public void setSouthwest(Location location) {
            this.southwest = location;
        }

        public Location getNortheast() {
            return this.northeast;
        }

        public void setNortheast(Location location) {
            this.northeast = location;
        }

        public String toString() {
            return "Viewport{southwest=" + this.southwest + ", northeast=" + this.northeast + '}';
        }
    }

    public static class Location {
        private double lat;
        private double lng;

        public double getLng() {
            return this.lng;
        }

        public void setLng(double d) {
            this.lng = d;
        }

        public double getLat() {
            return this.lat;
        }

        public void setLat(double d) {
            this.lat = d;
        }

        public String toString() {
            return "Location{lng=" + this.lng + ", lat=" + this.lat + '}';
        }
    }
}
