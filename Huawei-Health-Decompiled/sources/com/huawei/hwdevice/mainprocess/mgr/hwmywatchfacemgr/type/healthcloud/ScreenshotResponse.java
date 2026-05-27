package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.healthcloud;

/* JADX INFO: loaded from: classes6.dex */
public class ScreenshotResponse extends Response {
    private TypeInfo deviceTypeInfo;

    public TypeInfo getDeviceTypeInfo() {
        return this.deviceTypeInfo;
    }

    public void setDeviceTypeInfo(TypeInfo typeInfo) {
        this.deviceTypeInfo = typeInfo;
    }

    public static class TypeInfo {
        private String deviceType;
        private ScaleOffsetInfo watchcaseImgPosition;

        public String getDeviceType() {
            return this.deviceType;
        }

        public void setDeviceType(String str) {
            this.deviceType = str;
        }

        public ScaleOffsetInfo getWatchcaseImgPosition() {
            return this.watchcaseImgPosition;
        }

        public void setWatchcaseImgPosition(ScaleOffsetInfo scaleOffsetInfo) {
            this.watchcaseImgPosition = scaleOffsetInfo;
        }
    }

    public static class ScaleOffsetInfo {
        private double scale;
        private double translateX;
        private double translateY;

        public ScaleOffsetInfo(double d, double d2, double d3) {
            this.scale = d;
            this.translateX = d2;
            this.translateY = d3;
        }

        public double getScale() {
            return this.scale;
        }

        public void setScale(double d) {
            this.scale = d;
        }

        public double getTranslateX() {
            return this.translateX;
        }

        public void setTranslateX(double d) {
            this.translateX = d;
        }

        public double getTranslateY() {
            return this.translateY;
        }

        public void setTranslateY(double d) {
            this.translateY = d;
        }

        public String toString() {
            return "ScaleOffsetInfo{scale=" + this.scale + ", translateX=" + this.translateX + ", translateY=" + this.translateY + '}';
        }
    }
}
