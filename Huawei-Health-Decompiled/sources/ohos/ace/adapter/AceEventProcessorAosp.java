package ohos.ace.adapter;

import android.view.KeyEvent;
import android.view.MotionEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes8.dex */
public class AceEventProcessorAosp {
    private static final int BYTES_PER_FIELD = 8;
    private static final int MOUSE_FIELD_COUNT = 15;
    private static final int PONITER_FIELD_COUNT = 13;
    private static final double TOUCH_ATCION_MULTI = 2.0d;
    private static final long TOUCH_EVENT_TIMEUNIT = 1000;

    /* JADX INFO: loaded from: classes11.dex */
    interface ActionType {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int HOVER_ENTER = 7;
        public static final int HOVER_EXIT = 9;
        public static final int HOVER_MOVE = 8;
        public static final int MOVE = 5;
        public static final int REMOVE = 2;
        public static final int UNKNOWN = -1;
        public static final int UP = 6;
    }

    /* JADX INFO: loaded from: classes11.dex */
    interface CtrlKeysBit {
        public static final int ALT = 4;
        public static final int CTRL = 1;
        public static final int META = 8;
        public static final int SHIFT = 2;
    }

    /* JADX INFO: loaded from: classes11.dex */
    interface KeySourceType {
        public static final int KEYBOARD = 4;
        public static final int MOUSE = 1;
        public static final int NONE = 0;
        public static final int TOUCH = 2;
        public static final int TOUCH_PAD = 3;
    }

    /* JADX INFO: loaded from: classes11.dex */
    interface MouseActionButton {
        public static final int BACK_BUTTON = 8;
        public static final int FORWARD_BUTTON = 16;
        public static final int LEFT_BUTTON = 1;
        public static final int MIDDLE_BUTTON = 4;
        public static final int NONE_BUTTON = 0;
        public static final int RIGHT_BUTTON = 2;
    }

    /* JADX INFO: loaded from: classes11.dex */
    interface MouseActionType {
        public static final int HOVER_ENTER = 4;
        public static final int HOVER_EXIT = 6;
        public static final int HOVER_MOVE = 5;
        public static final int MOVE = 3;
        public static final int NONE = 0;
        public static final int PRESS = 1;
        public static final int RELEASE = 2;
    }

    /* JADX INFO: loaded from: classes11.dex */
    interface SourceTool {
        public static final int AIRBRUSH = 5;
        public static final int BRUSH = 3;
        public static final int FINGER = 0;
        public static final int LENS = 7;
        public static final int MOUSE = 6;
        public static final int PEN = 1;
        public static final int PENCIL = 4;
        public static final int RUBBER = 2;
        public static final int TOUCHPAD = 8;
        public static final int UNKNOWN = -1;
    }

    private static int actionMaskToHoverActionType(int i) {
        if (i == 7) {
            return 8;
        }
        if (i != 9) {
            return i != 10 ? -1 : 9;
        }
        return 7;
    }

    private static int actionMaskedToActionType(int i) {
        switch (i) {
            case 0:
            case 5:
                return 4;
            case 1:
            case 6:
                return 6;
            case 2:
                return 5;
            case 3:
                return 0;
            case 4:
            default:
                return -1;
            case 7:
            case 8:
                return 3;
        }
    }

    private static int actionMaskedToMouseActionType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 5) {
                    return 1;
                }
                if (i != 6) {
                    if (i != 7) {
                        if (i != 9) {
                            return i != 10 ? 0 : 6;
                        }
                        return 4;
                    }
                }
            }
            return 3;
        }
        return 2;
    }

    public static int eventSourceTransKeySource(int i) {
        if (i == -256 || i == 0) {
            return 0;
        }
        if (i == 257) {
            return 4;
        }
        if (i != 4098) {
            if (i == 8194) {
                return 1;
            }
            if (i == 1048584) {
                return 3;
            }
        }
        return 2;
    }

    public static int toolTypeTransSourceTool(int i) {
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? -1 : 6;
        }
        return 1;
    }

    private AceEventProcessorAosp() {
    }

    public static ByteBuffer processTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            throw new AssertionError("event is null");
        }
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(pointerCount * 104);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int iActionMaskedToActionType = actionMaskedToActionType(motionEvent.getActionMasked());
        for (int i = 0; i < pointerCount; i++) {
            addEventToBuffer(motionEvent, i, iActionMaskedToActionType, byteBufferAllocateDirect);
        }
        if (byteBufferAllocateDirect.position() % 104 == 0) {
            return byteBufferAllocateDirect;
        }
        throw new AssertionError("Packet position is not multiple of pointer length");
    }

    public static ByteBuffer processHoverTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            throw new AssertionError("event is null");
        }
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(pointerCount * 104);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int iActionMaskToHoverActionType = actionMaskToHoverActionType(motionEvent.getActionMasked());
        for (int i = 0; i < pointerCount; i++) {
            addHoverEventToBuffer(motionEvent, i, iActionMaskToHoverActionType, byteBufferAllocateDirect);
        }
        if (byteBufferAllocateDirect.position() % 104 == 0) {
            return byteBufferAllocateDirect;
        }
        throw new AssertionError("Packet position is not multiple of pointer length");
    }

    private static void addHoverEventToBuffer(MotionEvent motionEvent, int i, int i2, ByteBuffer byteBuffer) {
        if (i2 == -1) {
            return;
        }
        byteBuffer.putLong(motionEvent.getPointerId(i));
        byteBuffer.putLong(i2);
        byteBuffer.putDouble(motionEvent.getX(i));
        byteBuffer.putDouble(motionEvent.getY(i));
        byteBuffer.putDouble(((double) motionEvent.getTouchMinor(i)) * 2.0d);
        byteBuffer.putDouble(((double) motionEvent.getTouchMajor(i)) * 2.0d);
        byteBuffer.putDouble(motionEvent.getPressure(i));
        byteBuffer.putLong(motionEvent.getDeviceId());
        byteBuffer.putLong(motionEvent.getDownTime() * 1000);
        byteBuffer.putLong(motionEvent.getEventTime() * 1000);
        byteBuffer.putLong(eventSourceTransKeySource(motionEvent.getSource()));
        byteBuffer.putLong(toolTypeTransSourceTool(motionEvent.getToolType(i)));
        byteBuffer.putLong(((i2 == 6 || i2 == 4) && i != motionEvent.getActionIndex()) ? 0 : 1);
    }

    private static void addEventToBuffer(MotionEvent motionEvent, int i, int i2, ByteBuffer byteBuffer) {
        if (i2 == -1) {
            return;
        }
        byteBuffer.putLong(motionEvent.getPointerId(i));
        byteBuffer.putLong(i2);
        byteBuffer.putDouble(motionEvent.getX(i));
        byteBuffer.putDouble(motionEvent.getY(i));
        byteBuffer.putDouble(((double) motionEvent.getTouchMinor(i)) * 2.0d);
        byteBuffer.putDouble(((double) motionEvent.getTouchMajor(i)) * 2.0d);
        byteBuffer.putDouble(motionEvent.getPressure(i));
        byteBuffer.putLong(motionEvent.getDeviceId());
        byteBuffer.putLong(motionEvent.getDownTime() * 1000);
        byteBuffer.putLong(motionEvent.getEventTime() * 1000);
        byteBuffer.putLong(eventSourceTransKeySource(motionEvent.getSource()));
        byteBuffer.putLong(toolTypeTransSourceTool(motionEvent.getToolType(i)));
        byteBuffer.putLong(((i2 == 6 || i2 == 4) && i != motionEvent.getActionIndex()) ? 0 : 1);
    }

    public static ByteBuffer processMouseEvent(MotionEvent motionEvent, int i, float f, float f2) {
        if (motionEvent == null) {
            throw new AssertionError("event is null");
        }
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(pointerCount * 120);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int i2 = i & 15;
        int i3 = i >> 4;
        int iActionMaskedToMouseActionType = actionMaskedToMouseActionType(i2);
        if (i2 == 0 || i2 == 5 || i2 == 1 || i2 == 6) {
            addMouseToBuffer(motionEvent, motionEvent.getActionIndex(), iActionMaskedToMouseActionType, i3, byteBufferAllocateDirect, f, f2);
        } else {
            for (int i4 = 0; i4 < pointerCount; i4++) {
                addMouseToBuffer(motionEvent, i4, iActionMaskedToMouseActionType, i3, byteBufferAllocateDirect, f, f2);
            }
        }
        if (byteBufferAllocateDirect.position() % 120 == 0) {
            return byteBufferAllocateDirect;
        }
        throw new AssertionError("Packet position is not multiple of pointer length");
    }

    public static ByteBuffer processMouseEvent(KeyEvent keyEvent, float f, float f2) {
        if (keyEvent == null) {
            throw new AssertionError("event is null");
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(120);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addMouseToBuffer(keyEvent, keyEvent.getAction() == 1 ? 2 : 1, byteBufferAllocateDirect, f, f2);
        if (byteBufferAllocateDirect.position() % 120 == 0) {
            return byteBufferAllocateDirect;
        }
        throw new AssertionError("Packet position is not multiple of pointer length");
    }

    private static void addMouseToBuffer(KeyEvent keyEvent, int i, ByteBuffer byteBuffer, float f, float f2) {
        if (i == -1) {
            return;
        }
        long eventTime = keyEvent.getEventTime();
        byteBuffer.putDouble(f);
        byteBuffer.putDouble(f2);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(i);
        int keyCode = keyEvent.getKeyCode();
        long j = keyCode == 125 ? 16 : keyCode == 4 ? 8 : 0;
        byteBuffer.putLong(j);
        byteBuffer.putLong(j);
        byteBuffer.putLong(eventTime * 1000);
        byteBuffer.putLong(keyEvent.getDeviceId());
        byteBuffer.putLong(eventSourceTransKeySource(keyEvent.getSource()));
    }

    private static void addMouseToBuffer(MotionEvent motionEvent, int i, int i2, int i3, ByteBuffer byteBuffer, float f, float f2) {
        if (i2 == -1) {
            return;
        }
        long eventTime = motionEvent.getEventTime();
        byteBuffer.putDouble(motionEvent.getX(i));
        byteBuffer.putDouble(motionEvent.getY(i));
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(motionEvent.getX(i) - f);
        byteBuffer.putDouble(motionEvent.getY(i) - f2);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(i2);
        byteBuffer.putLong(i3);
        byteBuffer.putLong(motionEvent.getButtonState());
        byteBuffer.putLong(eventTime * 1000);
        byteBuffer.putLong(motionEvent.getDeviceId());
        byteBuffer.putLong(eventSourceTransKeySource(motionEvent.getSource()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getModifierKeys(KeyEvent keyEvent) {
        boolean zIsCtrlPressed = keyEvent.isCtrlPressed();
        boolean zIsShiftPressed = keyEvent.isShiftPressed();
        boolean zIsAltPressed = keyEvent.isAltPressed();
        boolean zIsMetaPressed = keyEvent.isMetaPressed();
        int i = zIsCtrlPressed;
        if (zIsShiftPressed) {
            i = (zIsCtrlPressed ? 1 : 0) | 2;
        }
        if (zIsAltPressed) {
            i = (i == true ? 1 : 0) | 4;
        }
        return zIsMetaPressed ? i | 8 : i;
    }
}
