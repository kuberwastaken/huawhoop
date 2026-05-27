package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e0 f5962a;
    private Point b;
    private Point c;

    private Point a(List list, Point point) {
        double d = ((double) point.x) / ((double) point.y);
        Iterator it = list.iterator();
        int i = 0;
        double dAbs = Double.MAX_VALUE;
        int i2 = 0;
        while (it.hasNext()) {
            Camera.Size size = (Camera.Size) it.next();
            int i3 = size.width;
            int i4 = size.height;
            if (i3 == point.x && i4 == point.y) {
                return new Point(i3, i4);
            }
            if (i3 * i4 >= 153600.0d) {
                double d2 = (((double) i3) / ((double) i4)) - d;
                if (Math.abs(d2) < dAbs) {
                    dAbs = Math.abs(d2);
                    i2 = i4;
                    i = i3;
                }
            }
        }
        return new Point(i, i2);
    }

    private void c(Camera.Parameters parameters) {
        String str;
        String[] strArr = {"continuous-picture", "continuous-video", TtmlNode.TEXT_EMPHASIS_AUTO};
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            Log.w("CameraManager", "setFocusMode failed, use default");
            return;
        }
        int i = 0;
        while (true) {
            if (i >= 3) {
                str = null;
                break;
            }
            str = strArr[i];
            if (supportedFocusModes.contains(str)) {
                break;
            } else {
                i++;
            }
        }
        if (str != null) {
            Log.i("CameraManager", "setFocusMode: " + str);
            parameters.setFocusMode(str);
        }
    }

    private void b(Camera.Parameters parameters) {
        if (parameters.isZoomSupported()) {
            parameters.setZoom(1);
        } else {
            Log.w("CameraManager", "initCameraParameters::setDefaultZoom not support zoom");
        }
    }

    private Point a(Camera.Parameters parameters, Point point, boolean z) {
        List<Camera.Size> supportedPictureSizes;
        if (!z) {
            supportedPictureSizes = parameters.getSupportedPreviewSizes();
        } else {
            supportedPictureSizes = parameters.getSupportedPictureSizes();
        }
        if (supportedPictureSizes != null && !supportedPictureSizes.isEmpty()) {
            return a(supportedPictureSizes, point);
        }
        Log.e("CameraManager", "CameraConfigImpl::findCameraResolution camera not support");
        return new Point(0, 0);
    }

    Point a() {
        return this.b;
    }

    void a(Camera camera, e0 e0Var) {
        if (camera != null && e0Var != null) {
            Camera.Parameters parameters = camera.getParameters();
            this.f5962a = e0Var;
            this.b = a(parameters, e0Var.a(), false);
            Log.d("CameraManager", "initCameraParameters previewCameraSize: " + this.b.toString());
            if (e0Var.c() == 0) {
                this.c = a(parameters, e0Var.a(), true);
                Log.d("CameraManager", "initCameraParameters pictureCameraSize: " + this.c.toString());
            }
            a(camera, this.b, this.c);
            return;
        }
        throw new IllegalArgumentException("initCameraParameters param is invalid");
    }

    private void a(Camera.Parameters parameters) {
        e0 e0Var = this.f5962a;
        if (e0Var == null) {
            return;
        }
        String strF = e0Var.f();
        if (!strF.equals("off") && !strF.equals("torch")) {
            strF = "off";
        }
        parameters.setFlashMode(strF);
    }

    private void a(Camera camera, Point point, Point point2) {
        if (this.f5962a == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(point.x, point.y);
        if (this.f5962a.c() == 0) {
            parameters.setPictureSize(point2.x, point2.y);
        }
        if (this.f5962a.b() != 1) {
            a(parameters);
        }
        c(parameters);
        b(parameters);
        if (this.f5962a.e()) {
            parameters.setRecordingHint(true);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            a(parameters, true);
        }
        camera.setParameters(parameters);
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        try {
            Method method = Camera.Parameters.class.getMethod("setScanOptEnable", Boolean.TYPE);
            if (method != null) {
                method.invoke(parameters, Boolean.valueOf(z));
                Log.i("CameraManager", "setScanOptEnable isOpt " + z);
            }
        } catch (IllegalAccessException unused) {
            Log.e("CameraManager", "setScanOptEnable reflection IllegalAccessException");
        } catch (NoSuchMethodException unused2) {
            Log.e("CameraManager", "setScanOptEnable reflection NoSuchMethodException");
        } catch (InvocationTargetException unused3) {
            Log.e("CameraManager", "setScanOptEnable reflection InvocationTargetException");
        } catch (Exception unused4) {
            Log.e("CameraManager", "setScanOptEnable reflection Exception");
        }
    }
}
