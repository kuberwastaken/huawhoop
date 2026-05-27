package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class kkx {
    public static boolean bJm_(BluetoothDevice bluetoothDevice, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (bluetoothDevice == null) {
            return false;
        }
        Object objInvoke = bluetoothDevice.getClass().getMethod(str, new Class[0]).invoke(bluetoothDevice, new Object[0]);
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }

    public static boolean bJn_(BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (bluetoothHeadset == null || bluetoothDevice == null) {
            return false;
        }
        Object objInvoke = bluetoothHeadset.getClass().getMethod("connect", BluetoothDevice.class).invoke(bluetoothHeadset, bluetoothDevice);
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }

    public static boolean bJo_(BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice, int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (bluetoothHeadset == null || bluetoothDevice == null) {
            return false;
        }
        Object objInvoke = bluetoothHeadset.getClass().getMethod("setPriority", BluetoothDevice.class, Integer.TYPE).invoke(bluetoothHeadset, bluetoothDevice, Integer.valueOf(i));
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }
}
