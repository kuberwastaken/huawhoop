package ohos.ace.adapter;

import android.content.ContentResolver;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ohos.ace.adapter.AccessibilityCrossPlatformBridge;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class AccessibilityCrossPlatformBridge extends AccessibilityNodeProvider {
    private static final String ACE_COMPONENT_BUTTON = "Button";
    private static final String ACE_COMPONENT_CHECKBOX = "CheckBox";
    private static final String ACE_COMPONENT_COLUMN = "Column";
    private static final String ACE_COMPONENT_DIALOG = "Dialog";
    private static final String ACE_COMPONENT_GRID = "Grid";
    private static final String ACE_COMPONENT_GRIDCOL = "GridCol";
    private static final String ACE_COMPONENT_GRIDITEM = "GridItem";
    private static final String ACE_COMPONENT_GRIDROW = "GridRow";
    private static final String ACE_COMPONENT_IMAGE = "Image";
    private static final String ACE_COMPONENT_IMAGEVIEW = "ImageView";
    private static final String ACE_COMPONENT_LEFTARROW = "LeftArrow";
    private static final String ACE_COMPONENT_LIST = "List";
    private static final String ACE_COMPONENT_MENU = "Menu";
    private static final String ACE_COMPONENT_NAVIGATION = "Navigation";
    private static final String ACE_COMPONENT_PAGE = "page";
    private static final String ACE_COMPONENT_POPUP = "Popup";
    private static final String ACE_COMPONENT_RADIO = "Radio";
    private static final String ACE_COMPONENT_RADIOBUTTON = "RadioButton";
    private static final String ACE_COMPONENT_RIGHTARROW = "RightArrow";
    private static final String ACE_COMPONENT_ROW = "Row";
    private static final String ACE_COMPONENT_SCROLL = "Scroll";
    private static final String ACE_COMPONENT_SLIDER = "Slider";
    private static final String ACE_COMPONENT_SWIPER = "Swiper";
    private static final String ACE_COMPONENT_SWIPERINDICATOR = "SwiperIndicator";
    private static final String ACE_COMPONENT_SWITCH = "Switch";
    private static final String ACE_COMPONENT_TABS = "Tabs";
    private static final String ACE_COMPONENT_TEXT = "Text";
    private static final String ACE_COMPONENT_TEXTAREA = "TextArea";
    private static final String ACE_COMPONENT_TEXTINPUT = "TextInput";
    private static final String ACE_COMPONENT_TOGGLE = "Toggle";
    private static final String ACE_COMPONENT_VIDEO = "Video";
    private static final int ANDROID_API_24 = 24;
    private static final int ANDROID_API_28 = 28;
    private static final int ANDROID_API_35 = 35;
    private static final int EVENT_DELAY_TIME = 1000;
    private static final int INVALID_PARENT_ID = -2100000;
    private static final String KEY_ACCESSIBILITY_TEXT = "AccessibilityText";
    private static final String KEY_COMPONENT_TYPE = "ComponentType";
    private static final String KEY_DESCRIPTION_INFO = "DescriptionInfo";
    private static final int ROOT_NODE_ID = 0;
    private static final String TAG = "ArkUIAccessbilityProvider";
    private static final int TYPE_PAGE_CLOSE = 2050;
    private static final int TYPE_PAGE_OPEN = 2049;
    private static final int UNDEFINED_ACCESSIBILITY_ID = -1;
    private static FocusedNode currentFocusNode;
    private final AccessibilityManager accessibilityManager;
    private View arkuiRootAccessibilityView;
    private final AccessibilityManager.AccessibilityStateChangeListener stateChangeListener;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
    private int windowId;
    Runnable updateNodeIds = new Runnable() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda6
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.m1377lambda$new$0$ohosaceadapterAccessibilityCrossPlatformBridge();
        }
    };
    private long jsAccessibilityStateObserverPtr = 0;
    private List<Integer> currentPageNodeIds = new ArrayList();
    private Map<Integer, ArkUiAccessibilityNodeInfo> arkUiframeNodes = new LinkedHashMap();
    private Map<Integer, HashSet<Integer>> SwiperChldId = new LinkedHashMap();
    private int inputFocusNodeId = -1;
    private int accessFocusNodeId = -1;
    private List<FocusedNode> arkUiAccFocusRouteNodes = new ArrayList();
    private boolean isNoFocusable = false;
    private boolean isMenuFocus = false;
    private boolean isStateChanged = true;
    private boolean disabledDelay = false;

    private native void nativeAccessibilityStateChanged(boolean z, long j);

    private native String nativeCreateAccessibilityNodeInfo(int i, int i2);

    private native String nativeFindFocusedElementInfo(int i, int i2);

    private native int nativeGetRootElementId(int i);

    private native int[] nativeGetTreeIdArray(int i);

    private native boolean nativePerformAction(int[] iArr, String str);

    private native boolean nativeRelease(int i);

    private native void nativeSetupJsAccessibilityManager(int i);

    private native void nativeTouchExplorationStateChange(boolean z, int i);

    /* JADX INFO: renamed from: lambda$new$0$ohos-ace-adapter-AccessibilityCrossPlatformBridge, reason: not valid java name */
    /* synthetic */ void m1377lambda$new$0$ohosaceadapterAccessibilityCrossPlatformBridge() {
        int[] iArrNativeGetTreeIdArray;
        if (isTouchExplorationEnabled() && (iArrNativeGetTreeIdArray = nativeGetTreeIdArray(this.windowId)) != null && iArrNativeGetTreeIdArray.length > 0) {
            updateAccessibilityNodeInfod(iArrNativeGetTreeIdArray);
        }
    }

    /* JADX INFO: renamed from: lambda$new$1$ohos-ace-adapter-AccessibilityCrossPlatformBridge, reason: not valid java name */
    /* synthetic */ void m1378lambda$new$1$ohosaceadapterAccessibilityCrossPlatformBridge(boolean z) {
        onChanged(z);
        this.isStateChanged = false;
    }

    /* JADX INFO: renamed from: lambda$new$2$ohos-ace-adapter-AccessibilityCrossPlatformBridge, reason: not valid java name */
    /* synthetic */ void m1379lambda$new$2$ohosaceadapterAccessibilityCrossPlatformBridge(boolean z) {
        if (this.isStateChanged) {
            onChanged(z);
        }
        if (z && isAccessibilityEnabled()) {
            this.arkUiAccFocusRouteNodes.clear();
            View view = this.arkuiRootAccessibilityView;
            if (view != null) {
                view.removeCallbacks(this.updateNodeIds);
                this.isMenuFocus = false;
                this.inputFocusNodeId = -1;
                this.arkuiRootAccessibilityView.post(this.updateNodeIds);
            }
        }
        if (!z) {
            this.isStateChanged = true;
        }
        if (isAccessibilityEnabled()) {
            nativeTouchExplorationStateChange(true, this.windowId);
        }
    }

    public static class ArkUiAccessibilityNodeInfo {
        private int nodeId = -1;
        private int[] childIds = new int[0];
        private String componentType = "";
        private boolean isDirty = true;
        private AccessibilityNodeInfo nodeInfo = null;

        private ArkUiAccessibilityNodeInfo() {
        }

        public static ArkUiAccessibilityNodeInfo obtain(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo = new ArkUiAccessibilityNodeInfo();
            arkUiAccessibilityNodeInfo.nodeInfo = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            arkUiAccessibilityNodeInfo.nodeId = i;
            return arkUiAccessibilityNodeInfo;
        }

        public void init(String str) {
            if (str.isEmpty()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.componentType = jSONObject.getString(AccessibilityCrossPlatformBridge.KEY_COMPONENT_TYPE);
                JSONArray jSONArray = new JSONArray(jSONObject.getString("childIDs"));
                this.childIds = new int[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.childIds[i] = jSONArray.getInt(i);
                }
            } catch (JSONException e) {
                Log.e(AccessibilityCrossPlatformBridge.TAG, "createAccessibilityNodeInfo failed; err is " + e.getMessage());
            }
        }
    }

    static class FocusedNode {
        public int nodeId;
        public int pageId;
        public int windowId;

        private FocusedNode(int i, int i2) {
            this.pageId = -1;
            this.nodeId = i;
            this.windowId = i2;
        }

        private FocusedNode(int i, int i2, int i3) {
            this.nodeId = i;
            this.windowId = i2;
            this.pageId = i3;
        }

        public static FocusedNode obtain(int i, int i2) {
            return new FocusedNode(i, i2);
        }

        public static FocusedNode obtain(int i, int i2, int i3) {
            return new FocusedNode(i, i2, i3);
        }
    }

    class TextMoveUnit {
        public static final int STEP_CHARACTER = 1;
        public static final int STEP_INVALID = 0;
        public static final int STEP_LINE = 4;
        public static final int STEP_PAGE = 16;
        public static final int STEP_PARAGRAPH = 8;
        public static final int STEP_WORD = 2;

        private TextMoveUnit() {
        }
    }

    class ScrollType {
        public static final int SCROLL_DEFAULT = -1;
        public static final int SCROLL_FULL = 1;
        public static final int SCROLL_HALF = 0;

        private ScrollType() {
        }
    }

    public AccessibilityCrossPlatformBridge(AccessibilityManager accessibilityManager, ContentResolver contentResolver, View view, int i) {
        this.arkuiRootAccessibilityView = null;
        this.windowId = 0;
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda7
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                this.f$0.m1378lambda$new$1$ohosaceadapterAccessibilityCrossPlatformBridge(z);
            }
        };
        this.stateChangeListener = accessibilityStateChangeListener;
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda8
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                this.f$0.m1379lambda$new$2$ohosaceadapterAccessibilityCrossPlatformBridge(z);
            }
        };
        this.touchExplorationStateChangeListener = touchExplorationStateChangeListener;
        this.accessibilityManager = accessibilityManager;
        this.arkuiRootAccessibilityView = view;
        accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
        this.windowId = i;
        nativeSetupJsAccessibilityManager(i);
    }

    private void onChanged(boolean z) {
        this.disabledDelay = false;
        if (z && isAccessibilityEnabled()) {
            accessibilityStateChanged(true);
            if (currentFocusNode != null) {
                currentFocusNode = null;
                return;
            }
            return;
        }
        this.disabledDelay = true;
        FocusedNode focusedNode = currentFocusNode;
        if (focusedNode != null) {
            nativePerformAction(new int[]{focusedNode.nodeId, 128, currentFocusNode.windowId}, "{}");
            currentFocusNode = null;
        }
        this.disabledDelay = false;
        accessibilityStateChanged(false);
    }

    public void release() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this.stateChangeListener);
            this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        int i = this.windowId;
        if (i > 0) {
            nativeRelease(i);
        }
        this.arkUiframeNodes.clear();
        this.arkUiAccFocusRouteNodes.clear();
        View view = this.arkuiRootAccessibilityView;
        if (view != null) {
            view.removeCallbacks(this.updateNodeIds);
            this.arkuiRootAccessibilityView = null;
        }
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            return accessibilityManager.isEnabled();
        }
        return false;
    }

    public boolean isTouchExplorationEnabled() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            return accessibilityManager.isTouchExplorationEnabled();
        }
        return false;
    }

    ArkUiAccessibilityNodeInfo findChildAccessNodeInfo(ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo) {
        int i = arkUiAccessibilityNodeInfo.nodeId;
        if (arkUiAccessibilityNodeInfo.childIds.length <= 0) {
            return null;
        }
        Iterator<Integer> it = this.arkUiframeNodes.keySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (z || iIntValue == i) {
                ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo2 = this.arkUiframeNodes.get(Integer.valueOf(iIntValue));
                if (arkUiAccessibilityNodeInfo2 != null && arkUiAccessibilityNodeInfo2.nodeInfo != null) {
                    CharSequence text = arkUiAccessibilityNodeInfo2.nodeInfo.getText();
                    CharSequence contentDescription = arkUiAccessibilityNodeInfo2.nodeInfo.getContentDescription();
                    if ((text != null && !text.toString().isEmpty()) || (contentDescription != null && !contentDescription.toString().isEmpty())) {
                        return arkUiAccessibilityNodeInfo2;
                    }
                }
                z = true;
            }
        }
        return null;
    }

    ArkUiAccessibilityNodeInfo findNodeInfo(ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo, Predicate<ArkUiAccessibilityNodeInfo> predicate) {
        if (arkUiAccessibilityNodeInfo == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(arkUiAccessibilityNodeInfo);
        while (!linkedList.isEmpty()) {
            ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo2 = (ArkUiAccessibilityNodeInfo) linkedList.poll();
            if (predicate.test(arkUiAccessibilityNodeInfo2)) {
                return arkUiAccessibilityNodeInfo2;
            }
            for (int i : arkUiAccessibilityNodeInfo2.childIds) {
                ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo3 = this.arkUiframeNodes.get(Integer.valueOf(i));
                if (arkUiAccessibilityNodeInfo3 != null) {
                    linkedList.add(arkUiAccessibilityNodeInfo3);
                }
            }
        }
        return null;
    }

    ArkUiAccessibilityNodeInfo findMenuChildAccessNodeInfo(ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo) {
        return findNodeInfo(arkUiAccessibilityNodeInfo, new Predicate() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AccessibilityCrossPlatformBridge.lambda$findMenuChildAccessNodeInfo$3((AccessibilityCrossPlatformBridge.ArkUiAccessibilityNodeInfo) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$findMenuChildAccessNodeInfo$3(ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo) {
        CharSequence text = arkUiAccessibilityNodeInfo.nodeInfo.getText();
        CharSequence contentDescription = arkUiAccessibilityNodeInfo.nodeInfo.getContentDescription();
        return ((text == null || text.toString().isEmpty()) && (contentDescription == null || contentDescription.toString().isEmpty())) ? false : true;
    }

    ArkUiAccessibilityNodeInfo findMenuFocusAccessNodeInfo(ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo) {
        return findNodeInfo(arkUiAccessibilityNodeInfo, new Predicate() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((AccessibilityCrossPlatformBridge.ArkUiAccessibilityNodeInfo) obj).nodeInfo.isAccessibilityFocused();
            }
        });
    }

    public void updateAccessibilityNodeInfod(int[] iArr) {
        int accFocusRouteAndReset;
        synchronized (this) {
            if (iArr != null) {
                if (iArr.length > 0 && isTouchExplorationEnabled()) {
                    this.currentPageNodeIds.clear();
                    this.currentPageNodeIds.addAll((Collection) Arrays.stream(iArr).boxed().collect(Collectors.toList()));
                    this.arkUiframeNodes.clear();
                    for (int i = 0; i < this.currentPageNodeIds.size(); i++) {
                        if (!this.arkUiframeNodes.containsKey(this.currentPageNodeIds.get(i))) {
                            createAccessibilityNodeInfo(this.currentPageNodeIds.get(i).intValue(), true);
                        }
                    }
                    sendWindowContentChangeEvent(this.currentPageNodeIds.get(0).intValue());
                    if (this.isMenuFocus || !performPopup()) {
                        if (!this.isMenuFocus && (accFocusRouteAndReset = getAccFocusRouteAndReset()) > -1) {
                            performAction(accFocusRouteAndReset, 64, new Bundle());
                            return;
                        }
                        if (this.isMenuFocus) {
                            ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfoFindMenuFocusAccessNodeInfo = findMenuFocusAccessNodeInfo(this.arkUiframeNodes.get(Integer.valueOf(this.inputFocusNodeId)));
                            if (arkUiAccessibilityNodeInfoFindMenuFocusAccessNodeInfo == null) {
                                arkUiAccessibilityNodeInfoFindMenuFocusAccessNodeInfo = findMenuChildAccessNodeInfo(this.arkUiframeNodes.get(Integer.valueOf(this.inputFocusNodeId)));
                            }
                            if (arkUiAccessibilityNodeInfoFindMenuFocusAccessNodeInfo != null) {
                                performAction(arkUiAccessibilityNodeInfoFindMenuFocusAccessNodeInfo.nodeId, 64, new Bundle());
                                return;
                            }
                        }
                        int i2 = this.inputFocusNodeId;
                        if (i2 > 0 && this.currentPageNodeIds.contains(Integer.valueOf(i2))) {
                            ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfoFindChildAccessNodeInfo = findChildAccessNodeInfo(this.arkUiframeNodes.get(Integer.valueOf(this.inputFocusNodeId)));
                            if (arkUiAccessibilityNodeInfoFindChildAccessNodeInfo == null) {
                                return;
                            }
                            int i3 = arkUiAccessibilityNodeInfoFindChildAccessNodeInfo.nodeId;
                            if (i3 != -1) {
                                performAction(i3, 64, new Bundle());
                            } else {
                                performAction(this.inputFocusNodeId, 64, new Bundle());
                            }
                            return;
                        }
                        handleDefaultFocus();
                    }
                }
            }
        }
    }

    private void handleDefaultFocus() {
        if (this.arkUiframeNodes.values().stream().anyMatch(new Predicate() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((AccessibilityCrossPlatformBridge.ArkUiAccessibilityNodeInfo) obj).nodeInfo.isAccessibilityFocused();
            }
        })) {
            return;
        }
        for (Map.Entry<Integer, ArkUiAccessibilityNodeInfo> entry : this.arkUiframeNodes.entrySet()) {
            AccessibilityNodeInfo accessibilityNodeInfo = entry.getValue().nodeInfo;
            CharSequence text = accessibilityNodeInfo.getText();
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if ((text != null && !text.toString().isEmpty()) || (contentDescription != null && !contentDescription.toString().isEmpty())) {
                performAction(entry.getKey().intValue(), 64, new Bundle());
                return;
            }
        }
    }

    private boolean performPopup() {
        if (!this.arkUiframeNodes.values().stream().anyMatch(new Predicate() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AccessibilityCrossPlatformBridge.ACE_COMPONENT_POPUP.equals(((AccessibilityCrossPlatformBridge.ArkUiAccessibilityNodeInfo) obj).componentType);
            }
        })) {
            return false;
        }
        this.arkUiframeNodes.entrySet().stream().filter(new Predicate() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AccessibilityCrossPlatformBridge.ACE_COMPONENT_POPUP.equals(((AccessibilityCrossPlatformBridge.ArkUiAccessibilityNodeInfo) ((Map.Entry) obj).getValue()).componentType);
            }
        }).findFirst().ifPresent(new Consumer() { // from class: ohos.ace.adapter.AccessibilityCrossPlatformBridge$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m1380lambda$performPopup$8$ohosaceadapterAccessibilityCrossPlatformBridge((Map.Entry) obj);
            }
        });
        return true;
    }

    /* JADX INFO: renamed from: lambda$performPopup$8$ohos-ace-adapter-AccessibilityCrossPlatformBridge, reason: not valid java name */
    /* synthetic */ void m1380lambda$performPopup$8$ohosaceadapterAccessibilityCrossPlatformBridge(Map.Entry entry) {
        int iIntValue = ((Integer) entry.getKey()).intValue();
        int length = ((ArkUiAccessibilityNodeInfo) entry.getValue()).childIds.length;
        ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfoFindChildAccessNodeInfo = findChildAccessNodeInfo((ArkUiAccessibilityNodeInfo) entry.getValue());
        if (arkUiAccessibilityNodeInfoFindChildAccessNodeInfo != null) {
            int i = arkUiAccessibilityNodeInfoFindChildAccessNodeInfo.nodeId;
            if (i != -1) {
                performAction(i, 64, new Bundle());
                return;
            } else {
                performAction(iIntValue, 64, new Bundle());
                return;
            }
        }
        ALog.e(TAG, "childInfo:null");
    }

    AccessibilityNodeInfo createAccessibilityNodeInfo(int i, boolean z) {
        View view;
        boolean z2 = true;
        if (i == -1 && (view = this.arkuiRootAccessibilityView) != null) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
            this.arkuiRootAccessibilityView.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            accessibilityNodeInfoObtain.setImportantForAccessibility(true);
            int iNativeGetRootElementId = nativeGetRootElementId(this.windowId);
            accessibilityNodeInfoObtain.addChild(this.arkuiRootAccessibilityView, iNativeGetRootElementId);
            accessibilityNodeInfoObtain.setImportantForAccessibility(false);
            if (z) {
                this.arkUiframeNodes.put(Integer.valueOf(iNativeGetRootElementId), ArkUiAccessibilityNodeInfo.obtain(accessibilityNodeInfoObtain, iNativeGetRootElementId));
            }
            return accessibilityNodeInfoObtain;
        }
        if (!z && this.arkUiframeNodes.containsKey(Integer.valueOf(i))) {
            z2 = this.arkUiframeNodes.get(Integer.valueOf(i)).isDirty;
            if (!this.arkUiframeNodes.get(Integer.valueOf(i)).isDirty) {
                return AccessibilityNodeInfo.obtain(this.arkUiframeNodes.get(Integer.valueOf(i)).nodeInfo);
            }
        }
        String strNativeCreateAccessibilityNodeInfo = nativeCreateAccessibilityNodeInfo(i, this.windowId);
        AccessibilityNodeInfo accessibilityNodeInfoConvertJsonToNodeInfo = convertJsonToNodeInfo(strNativeCreateAccessibilityNodeInfo);
        if (accessibilityNodeInfoConvertJsonToNodeInfo == null) {
            Log.e(TAG, "Failed to convert JSON to NodeInfo for virtualViewId: " + i + ", windowId: " + this.windowId + ", JSON: " + strNativeCreateAccessibilityNodeInfo);
            return accessibilityNodeInfoConvertJsonToNodeInfo;
        }
        if (z) {
            ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfoObtain = ArkUiAccessibilityNodeInfo.obtain(accessibilityNodeInfoConvertJsonToNodeInfo, i);
            arkUiAccessibilityNodeInfoObtain.init(strNativeCreateAccessibilityNodeInfo);
            arkUiAccessibilityNodeInfoObtain.isDirty = false;
            this.arkUiframeNodes.put(Integer.valueOf(i), arkUiAccessibilityNodeInfoObtain);
        } else if (z2 && this.arkUiframeNodes.containsKey(Integer.valueOf(i))) {
            ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfoObtain2 = ArkUiAccessibilityNodeInfo.obtain(accessibilityNodeInfoConvertJsonToNodeInfo, i);
            arkUiAccessibilityNodeInfoObtain2.init(strNativeCreateAccessibilityNodeInfo);
            arkUiAccessibilityNodeInfoObtain2.isDirty = false;
            this.arkUiframeNodes.replace(Integer.valueOf(i), arkUiAccessibilityNodeInfoObtain2);
        }
        return accessibilityNodeInfoConvertJsonToNodeInfo;
    }

    private Rect getBoundsInScreen(Rect rect) {
        int[] iArr = new int[2];
        this.arkuiRootAccessibilityView.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = this.arkuiRootAccessibilityView.getWidth();
        int height = this.arkuiRootAccessibilityView.getHeight();
        Rect rect2 = new Rect();
        rect2.left = Math.max(i, rect.left + i);
        rect2.top = Math.max(i2, rect.top + i2);
        rect2.right = Math.min(width + i, rect.right + i);
        rect2.bottom = Math.min(height + i2, rect.bottom + i2);
        return rect2;
    }

    AccessibilityNodeInfo convertJsonToNodeInfo(String str) {
        StringBuilder sb;
        String str2 = ACE_COMPONENT_BUTTON;
        if (str.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("AccessibilityId");
            String string = jSONObject.getString(KEY_COMPONENT_TYPE);
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(this.arkuiRootAccessibilityView, i);
            populateNodeInfoFromJson(accessibilityNodeInfoObtain, jSONObject);
            boolean z = ACE_COMPONENT_LEFTARROW.equals(string) || ACE_COMPONENT_RIGHTARROW.equals(string);
            boolean zIsChildOfComponentType = isChildOfComponentType(i, string, "Stack", ACE_COMPONENT_TEXTINPUT);
            boolean zIsChildOfComponentType2 = isChildOfComponentType(i, string, ACE_COMPONENT_BUTTON, "SideBarContainer");
            if (!zIsChildOfComponentType) {
                str2 = string;
            }
            accessibilityNodeInfoObtain.setClassName(getClassNameString(str2));
            String strTrim = jSONObject.getString(KEY_ACCESSIBILITY_TEXT).trim();
            String strTrim2 = jSONObject.getString(KEY_DESCRIPTION_INFO).trim();
            String strCounterCovertContent = counterCovertContent(jSONObject.getString("Content"), jSONObject.getInt("AccessibilityId"), string);
            accessibilityNodeInfoObtain.setFocusable((!jSONObject.getBoolean("IsFocusable") && !jSONObject.getBoolean("ImportantForAccessibility") && strCounterCovertContent.isEmpty() && strTrim.isEmpty() && strTrim2.isEmpty()) ? false : true);
            setMovementGranularities(accessibilityNodeInfoObtain, jSONObject);
            setParentID(accessibilityNodeInfoObtain, jSONObject);
            setBounds(accessibilityNodeInfoObtain, jSONObject);
            setCollection(accessibilityNodeInfoObtain, jSONObject);
            accessibilityNodeInfoObtain.setText(zIsChildOfComponentType ? "显示或隐藏密码" : strCounterCovertContent);
            accessibilityNodeInfoObtain.setHintText(jSONObject.getString("Hint"));
            if (strTrim.isEmpty()) {
                sb = new StringBuilder();
                sb.append(strCounterCovertContent);
                sb.append("\n");
                sb.append(strTrim2);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(strTrim);
                sb2.append("\n");
                sb2.append(strTrim2);
                sb = sb2;
            }
            accessibilityNodeInfoObtain.setContentDescription(sb.toString().trim());
            setChildren(accessibilityNodeInfoObtain, jSONObject, zIsChildOfComponentType || zIsChildOfComponentType2 || z || ACE_COMPONENT_SLIDER.equals(string));
            if (setTooltipTextAndText(accessibilityNodeInfoObtain, jSONObject)) {
                return accessibilityNodeInfoObtain;
            }
            Log.e(TAG, "!setTooltipTextAndText, jsonStr: " + str);
            return null;
        } catch (JSONException e) {
            Log.e(TAG, "createAccessibilityNodeInfo failed; err is " + e.getMessage());
            return null;
        }
    }

    private void populateNodeInfoFromJson(AccessibilityNodeInfo accessibilityNodeInfo, JSONObject jSONObject) {
        try {
            accessibilityNodeInfo.setImportantForAccessibility(jSONObject.getBoolean("ImportantForAccessibility"));
            accessibilityNodeInfo.setViewIdResourceName(jSONObject.getString("ComponentResourceId"));
            accessibilityNodeInfo.setPackageName(jSONObject.getString("BundleName"));
            accessibilityNodeInfo.setFocused(jSONObject.getBoolean("IsFocused"));
            accessibilityNodeInfo.setAccessibilityFocused(jSONObject.getBoolean("HasAccessibilityFocus"));
            accessibilityNodeInfo.setPassword(jSONObject.getBoolean("IsPassword"));
            accessibilityNodeInfo.setEditable(jSONObject.getBoolean("IsEditable"));
            accessibilityNodeInfo.setTextSelection(jSONObject.getInt("SelectedBegin"), jSONObject.getInt("SelectedEnd"));
            accessibilityNodeInfo.setLiveRegion(jSONObject.getInt("LiveRegion"));
            accessibilityNodeInfo.setMaxTextLength(jSONObject.getInt("TextLengthLimit"));
            accessibilityNodeInfo.setVisibleToUser(jSONObject.getBoolean("IsVisible"));
            accessibilityNodeInfo.setEnabled(jSONObject.getBoolean("IsEnabled"));
            accessibilityNodeInfo.setClickable(jSONObject.getBoolean("IsClickable"));
            accessibilityNodeInfo.setLongClickable(jSONObject.getBoolean("IsLongClickable"));
            accessibilityNodeInfo.setScrollable(jSONObject.getBoolean("IsScrollable"));
            accessibilityNodeInfo.setCheckable(jSONObject.getBoolean("IsCheckable"));
            accessibilityNodeInfo.setChecked(jSONObject.getBoolean("IsChecked"));
            accessibilityNodeInfo.setSelected(jSONObject.getBoolean("IsSelected"));
        } catch (JSONException e) {
            Log.e(TAG, "populateNodeInfoFromJson failed; err is " + e.getMessage());
        }
    }

    private boolean isChildOfComponentType(int i, String str, String str2, String str3) {
        if (!str.equals(str2)) {
            return false;
        }
        for (ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo : this.arkUiframeNodes.values()) {
            if (arkUiAccessibilityNodeInfo.componentType.equals(str3)) {
                for (int i2 : arkUiAccessibilityNodeInfo.childIds) {
                    if (i2 == i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String counterCovertContent(String str, int i, String str2) {
        if (ACE_COMPONENT_TEXT.equals(str2) && Constants.LINK.equals(str)) {
            for (ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo : this.arkUiframeNodes.values()) {
                for (int i2 : arkUiAccessibilityNodeInfo.childIds) {
                    if (i2 == i) {
                        return ACE_COMPONENT_BUTTON.equals(arkUiAccessibilityNodeInfo.componentType) ? "减" : str;
                    }
                }
            }
        }
        return str;
    }

    private void setParentID(AccessibilityNodeInfo accessibilityNodeInfo, JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt("ParentNodeId");
        if (i != INVALID_PARENT_ID) {
            accessibilityNodeInfo.setParent(this.arkuiRootAccessibilityView, i);
        } else {
            accessibilityNodeInfo.setParent(this.arkuiRootAccessibilityView);
        }
    }

    private void setChildren(AccessibilityNodeInfo accessibilityNodeInfo, JSONObject jSONObject, boolean z) throws JSONException {
        String string = jSONObject.getString(KEY_COMPONENT_TYPE);
        if (ACE_COMPONENT_TEXTINPUT.equals(string) || ACE_COMPONENT_BUTTON.equals(string) || z) {
            return;
        }
        JSONArray jSONArray = new JSONArray(jSONObject.getString("childIDs"));
        for (int i = 0; i < jSONArray.length(); i++) {
            accessibilityNodeInfo.addChild(this.arkuiRootAccessibilityView, jSONArray.getInt(i));
        }
    }

    private void setBounds(AccessibilityNodeInfo accessibilityNodeInfo, JSONObject jSONObject) throws JSONException {
        Rect rect = new Rect();
        rect.left = jSONObject.getInt("RectInScreen_leftTopX");
        rect.top = jSONObject.getInt("RectInScreen_leftTopY");
        rect.right = jSONObject.getInt("RectInScreen_rightBottomX");
        rect.bottom = jSONObject.getInt("RectInScreen_rightBottomY");
        accessibilityNodeInfo.setBoundsInScreen(getBoundsInScreen(rect));
    }

    private void setCollection(AccessibilityNodeInfo accessibilityNodeInfo, JSONObject jSONObject) throws JSONException {
        if (jSONObject.getBoolean("IsScrollable")) {
            if (jSONObject.getInt("GirdInfoRows") > 0 || jSONObject.getInt("GirdInfoColumns") > 0) {
                accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(jSONObject.getInt("GirdInfoRows"), jSONObject.getInt("GirdInfoColumns"), false));
            } else {
                accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(jSONObject.getInt("ItemCounts"), 0, false));
            }
        }
        if (ACE_COMPONENT_GRIDITEM.equals(jSONObject.getString(KEY_COMPONENT_TYPE))) {
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(jSONObject.getInt("GridItemRowIndex"), jSONObject.getInt("GridItemRowSpan"), jSONObject.getInt("GridItemColumnIndex"), jSONObject.getInt("GridItemColumnSpan"), jSONObject.getBoolean("GridItemIsHeading"), jSONObject.getBoolean("GridItemIsSelected")));
        }
    }

    private void setMovementGranularities(AccessibilityNodeInfo accessibilityNodeInfo, JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray(jSONObject.getString("ActionList"));
        int i = jSONObject.getInt("TextMoveStep");
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            int i4 = jSONArray.getInt(i3);
            accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(i4, "ace"));
            if (i4 == 256 || i4 == 512) {
                if (i == 1) {
                    i2 |= 1;
                } else if (i == 2) {
                    i2 |= 2;
                } else if (i == 4) {
                    i2 |= 4;
                } else if (i == 8) {
                    i2 |= 8;
                } else if (i == 16) {
                    i2 |= 16;
                }
            }
        }
        accessibilityNodeInfo.setMovementGranularities(i2);
    }

    private boolean setTooltipTextAndText(AccessibilityNodeInfo accessibilityNodeInfo, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT > 28) {
            try {
                Class<?> cls = accessibilityNodeInfo.getClass();
                cls.getMethod("setTooltipText", CharSequence.class).invoke(accessibilityNodeInfo, "");
                cls.getMethod("setHeading", Boolean.TYPE).invoke(accessibilityNodeInfo, Boolean.valueOf(jSONObject.getBoolean("GridItemIsHeading")));
            } catch (IllegalAccessException unused) {
                Log.e(TAG, "createAccessibilityNodeInfo failed, IllegalAccessException.");
                return false;
            } catch (NoSuchMethodException unused2) {
                Log.e(TAG, "createAccessibilityNodeInfo failed, NoSuchMethodException.");
                return false;
            } catch (InvocationTargetException unused3) {
                Log.e(TAG, "createAccessibilityNodeInfo failed, InvocationTargetException.");
                return false;
            }
        }
        return true;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return createAccessibilityNodeInfo(i, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getClassNameString(java.lang.String r2) {
        /*
            Method dump skipped, instruction units count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ohos.ace.adapter.AccessibilityCrossPlatformBridge.getClassNameString(java.lang.String):java.lang.String");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        super.addExtraDataToAccessibilityNodeInfo(i, accessibilityNodeInfo, str, bundle);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        if (!isEnableFocus(i, "Calendar")) {
            return true;
        }
        String string = "{}";
        if (i2 == 64) {
            if (this.isNoFocusable) {
                this.isNoFocusable = false;
                return false;
            }
            FocusedNode focusedNode = currentFocusNode;
            if (focusedNode != null && focusedNode.windowId != this.windowId) {
                nativePerformAction(new int[]{currentFocusNode.nodeId, 128, currentFocusNode.windowId}, "{}");
            }
            boolean zPerformAction = performAction(i, i2, "{}");
            currentFocusNode = FocusedNode.obtain(i, this.windowId);
            return zPerformAction;
        }
        if (i2 == 128) {
            currentFocusNode = null;
        } else if (i2 == 4096) {
            this.isNoFocusable = !isEnableFocus(i, ACE_COMPONENT_GRID);
        }
        if (bundle != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)) {
                    jSONObject.put("selectTextBegin", bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT));
                }
                if (bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    jSONObject.put("selectTextEnd", bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT));
                }
                if (bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE)) {
                    jSONObject.put("setText", bundle.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE));
                }
                setMovementGranularityArg(bundle, jSONObject);
                setScrollAmountArg(bundle, jSONObject);
                string = jSONObject.toString();
            } catch (JSONException e) {
                Log.e(TAG, "performAction failed; err is " + e.getMessage());
                return false;
            }
        }
        return performAction(i, i2, string);
    }

    private void setMovementGranularityArg(Bundle bundle, JSONObject jSONObject) throws JSONException {
        if (bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT)) {
            int i = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 4;
                    if (i != 4) {
                        i2 = 8;
                        if (i != 8) {
                            i2 = 16;
                            if (i != 16) {
                                i2 = 0;
                            }
                        }
                    }
                }
            }
            jSONObject.put("textMoveUnit", i2);
        }
    }

    private void setScrollAmountArg(Bundle bundle, JSONObject jSONObject) throws JSONException {
        if (Build.VERSION.SDK_INT < 35 || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT")) {
            return;
        }
        float f = bundle.getFloat("android.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT");
        jSONObject.put("scrolltype", (f <= 0.25f || f >= 0.75f) ? f >= 0.75f ? 1 : -1 : 0);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return super.findAccessibilityNodeInfosByText(str, i);
    }

    public void sendAccessibilityEvent(int i, int i2) {
        if (isEnabled()) {
            if (i == 0) {
                this.arkuiRootAccessibilityView.sendAccessibilityEvent(i2);
            } else {
                sendAccessibilityEvent(obtainAccessibilityEvent(i, i2));
            }
        }
    }

    private AccessibilityEvent obtainAccessibilityEvent(int i, int i2) {
        AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(i2);
        accessibilityEventObtainAccessibilityEvent.setPackageName(this.arkuiRootAccessibilityView.getContext().getPackageName());
        accessibilityEventObtainAccessibilityEvent.setSource(this.arkuiRootAccessibilityView, i);
        return accessibilityEventObtainAccessibilityEvent;
    }

    public AccessibilityEvent obtainAccessibilityEvent(int i) {
        return AccessibilityEvent.obtain(i);
    }

    private boolean sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.arkuiRootAccessibilityView.getParent() == null) {
            Log.e(TAG, "sendAccessibilityEvent getParent is null");
            this.accessibilityManager.sendAccessibilityEvent(accessibilityEvent);
            return false;
        }
        return this.arkuiRootAccessibilityView.getParent().requestSendAccessibilityEvent(this.arkuiRootAccessibilityView, accessibilityEvent);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i) {
        if (i == 1 || i == 2) {
            return convertJsonToNodeInfo(nativeFindFocusedElementInfo(i, this.windowId));
        }
        return null;
    }

    public void sendWindowContentChangeEvent(int i) {
        AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(i, 2048);
        accessibilityEventObtainAccessibilityEvent.setContentChangeTypes(1);
        sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent);
    }

    public void sendAccessibilityFocusInvalidate(int i) {
        if (i < 0) {
            i = this.accessFocusNodeId;
        }
        if (i >= 0) {
            performAction(i, 128, new Bundle());
            performAction(i, 64, new Bundle());
        }
    }

    private int getChildItemCount(int i) {
        ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo = this.arkUiframeNodes.get(Integer.valueOf(i));
        if (arkUiAccessibilityNodeInfo == null) {
            return 0;
        }
        int length = arkUiAccessibilityNodeInfo.childIds.length;
        for (int i2 = 0; i2 < arkUiAccessibilityNodeInfo.childIds.length; i2++) {
            length += getChildItemCount(arkUiAccessibilityNodeInfo.childIds[i2]);
        }
        return length;
    }

    public boolean onSendAccessibilityEvent(int i, int i2, String str) {
        AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(i, i2);
        this.isNoFocusable = false;
        if (str.isEmpty()) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("ParentNodeId");
            accessibilityEventObtainAccessibilityEvent.setSource(this.arkuiRootAccessibilityView, sliderPerformAction(i, i3));
            convertJsonToEvent(i, accessibilityEventObtainAccessibilityEvent, jSONObject);
            String string = jSONObject.getString(KEY_COMPONENT_TYPE);
            if (this.arkUiframeNodes.containsKey(Integer.valueOf(i))) {
                int length = this.arkUiframeNodes.get(Integer.valueOf(i)).childIds.length;
                if (this.arkUiframeNodes.get(Integer.valueOf(i)).nodeInfo.isVisibleToUser() != jSONObject.getBoolean("IsVisible")) {
                    sendWindowContentChangeEvent(i);
                }
                this.arkUiframeNodes.get(Integer.valueOf(i)).isDirty = true;
                if (i2 == 4096 && length > 0) {
                    updateAllNodeInfo();
                    int childItemCount = getChildItemCount(i);
                    int iIndexOf = this.currentPageNodeIds.indexOf(Integer.valueOf(i));
                    int size = childItemCount + 1 + iIndexOf;
                    if (size > this.currentPageNodeIds.size()) {
                        size = this.currentPageNodeIds.size();
                    }
                    while (iIndexOf < size) {
                        this.arkUiframeNodes.get(this.currentPageNodeIds.get(iIndexOf)).isDirty = true;
                        iIndexOf++;
                    }
                    sendWindowContentChangeEvent(i);
                }
            }
            int i4 = jSONObject.getInt("PageId");
            boolean[] zArr = {false};
            performEvent(i, i2, string, i4, zArr);
            if (!zArr[0]) {
                zArr[0] = performFocusAction(i, i3, i2);
            }
            if (i2 == TYPE_PAGE_OPEN || i2 == TYPE_PAGE_CLOSE) {
                accessibilityEventObtainAccessibilityEvent.setEventType(2048);
            }
            if (zArr[0]) {
                return true;
            }
            return sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent);
        } catch (JSONException e) {
            Log.e(TAG, "onSendAccessibilityEvent failed; err is " + e.getMessage());
            return false;
        }
    }

    private void convertJsonToEvent(int i, AccessibilityEvent accessibilityEvent, JSONObject jSONObject) {
        try {
            accessibilityEvent.setAction(jSONObject.getInt(ParsedFieldTag.ACTION_TYPE));
            accessibilityEvent.setContentChangeTypes(jSONObject.getInt("contentChangeType"));
            accessibilityEvent.setMovementGranularity(jSONObject.getInt("TextMoveStep"));
            accessibilityEvent.setAddedCount(jSONObject.getInt("InputType"));
            accessibilityEvent.setBeforeText(jSONObject.getString("beforeText"));
            accessibilityEvent.setChecked(jSONObject.getBoolean("IsChecked"));
            accessibilityEvent.setClassName(getClassNameString(jSONObject.getString(KEY_COMPONENT_TYPE)));
            accessibilityEvent.setSource(this.arkuiRootAccessibilityView, sliderPerformAction(i, jSONObject.getInt("ParentNodeId")));
            accessibilityEvent.setContentDescription(jSONObject.getString(KEY_DESCRIPTION_INFO).trim());
            accessibilityEvent.setEnabled(jSONObject.getBoolean("IsEnabled"));
            accessibilityEvent.setFromIndex(jSONObject.getInt("currentIndex"));
            accessibilityEvent.setItemCount(jSONObject.getInt("itemCounts"));
            accessibilityEvent.setCurrentItemIndex(jSONObject.getInt("currentIndex"));
            accessibilityEvent.setPassword(jSONObject.getBoolean("IsPassword"));
            accessibilityEvent.setScrollable(jSONObject.getBoolean("IsScrollable"));
        } catch (JSONException e) {
            Log.e(TAG, "ConvertJsonToEvent failed; err is " + e.getMessage());
        }
    }

    private void performEvent(int i, int i2, String str, int i3, boolean[] zArr) {
        if (i2 == 8) {
            performUpdateNodeId(i, i2, str, false, zArr);
        }
        if (i2 == 32768) {
            this.accessFocusNodeId = i;
            addAccFocusRoute(i, i3);
        }
        if (i2 == 65536) {
            this.accessFocusNodeId = -1;
        }
        if (i2 == 2048 || i2 == 32) {
            this.inputFocusNodeId = -1;
            this.accessFocusNodeId = -1;
            this.SwiperChldId.clear();
            performUpdateNodeId(i, i2, str, true, zArr);
        }
        if (i2 == TYPE_PAGE_OPEN) {
            this.inputFocusNodeId = -1;
            this.accessFocusNodeId = -1;
            this.SwiperChldId.clear();
            performUpdateNodeId(i, i2, str, false, zArr);
        }
        if (i2 == TYPE_PAGE_CLOSE) {
            int i4 = this.accessFocusNodeId;
            if (i4 >= 0) {
                performAction(i4, 128, new Bundle());
            }
            this.inputFocusNodeId = -1;
            this.accessFocusNodeId = -1;
            this.SwiperChldId.clear();
            performUpdateNodeId(i, i2, str, false, zArr);
        }
        if (i2 == 4096) {
            performUpdateNodeId(i, i2, str, false, zArr);
        }
        if (i2 == 16) {
            zArr[0] = true;
        }
    }

    private void performUpdateNodeId(int i, int i2, String str, boolean z, boolean[] zArr) {
        if (this.arkuiRootAccessibilityView == null) {
            return;
        }
        if ("page".equals(str) || ACE_COMPONENT_POPUP.equals(str) || ACE_COMPONENT_DIALOG.equals(str) || ACE_COMPONENT_SCROLL.equals(str) || ACE_COMPONENT_NAVIGATION.equals(str)) {
            this.arkuiRootAccessibilityView.removeCallbacks(this.updateNodeIds);
            this.isMenuFocus = false;
            this.inputFocusNodeId = i;
            if (z) {
                this.arkuiRootAccessibilityView.postDelayed(this.updateNodeIds, 1000L);
                return;
            } else {
                this.arkuiRootAccessibilityView.post(this.updateNodeIds);
                return;
            }
        }
        if (ACE_COMPONENT_MENU.equals(str)) {
            this.arkuiRootAccessibilityView.removeCallbacks(this.updateNodeIds);
            if (i2 == TYPE_PAGE_CLOSE) {
                this.isMenuFocus = false;
            } else {
                this.isMenuFocus = true;
                zArr[0] = true;
            }
            this.inputFocusNodeId = i;
            if (z) {
                this.arkuiRootAccessibilityView.postDelayed(this.updateNodeIds, 1000L);
            } else {
                this.arkuiRootAccessibilityView.post(this.updateNodeIds);
            }
        }
    }

    public boolean performAction(int i, int i2, String str) {
        return nativePerformAction(new int[]{i, i2, this.windowId}, str);
    }

    public boolean isEnabled() {
        return (isAccessibilityEnabled() && isTouchExplorationEnabled()) || this.disabledDelay;
    }

    public boolean registerJsAccessibilityStateObserver(long j) {
        long j2 = this.jsAccessibilityStateObserverPtr;
        if (j2 == 0) {
            this.jsAccessibilityStateObserverPtr = j;
            return true;
        }
        if (j2 == j) {
            ALog.i(TAG, "registerObserver successed. Ptr already existed. Ptr = " + j + " windowId = " + this.windowId);
            return true;
        }
        ALog.e(TAG, "registerObserver failed. Ptr=" + j + " windowId = " + this.windowId);
        return false;
    }

    public boolean unregisterJsAccessibilityStateObserver() {
        if (this.jsAccessibilityStateObserverPtr != 0) {
            this.jsAccessibilityStateObserverPtr = 0L;
            return true;
        }
        ALog.e(TAG, "unregisterObserver called. Ptr not exists. windowId = " + this.windowId);
        return false;
    }

    public void accessibilityStateChanged(boolean z) {
        long j = this.jsAccessibilityStateObserverPtr;
        if (j != 0) {
            nativeAccessibilityStateChanged(z, j);
        }
    }

    private void addAccFocusRoute(int i, int i2) {
        if (i < 0) {
            return;
        }
        updateSwiperChildID();
        Iterator<FocusedNode> it = this.arkUiAccFocusRouteNodes.iterator();
        while (it.hasNext()) {
            if (it.next().nodeId == i) {
                return;
            }
        }
        this.arkUiAccFocusRouteNodes.add(FocusedNode.obtain(i, this.windowId, i2));
    }

    private boolean isSwiperChildFocused(int i) {
        if (this.SwiperChldId.containsKey(Integer.valueOf(i))) {
            return this.SwiperChldId.get(Integer.valueOf(i)).contains(Integer.valueOf(this.accessFocusNodeId));
        }
        return false;
    }

    private boolean performFocusAction(int i, int i2, int i3) {
        ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo;
        if (i3 != 4096) {
            return false;
        }
        updateSwiperChildID();
        if (!isSwiperChildFocused(i) || (arkUiAccessibilityNodeInfo = this.arkUiframeNodes.get(Integer.valueOf(i))) == null || arkUiAccessibilityNodeInfo.childIds.length <= 0) {
            return false;
        }
        performAction(arkUiAccessibilityNodeInfo.childIds[0], 64, new Bundle());
        return true;
    }

    private int sliderPerformAction(int i, int i2) {
        ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo = this.arkUiframeNodes.get(Integer.valueOf(i));
        if (arkUiAccessibilityNodeInfo != null && ACE_COMPONENT_SLIDER.equals(arkUiAccessibilityNodeInfo.componentType)) {
            return i;
        }
        for (ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo2 : this.arkUiframeNodes.values()) {
            if (ACE_COMPONENT_SLIDER.equals(arkUiAccessibilityNodeInfo2.componentType)) {
                for (int i3 : arkUiAccessibilityNodeInfo2.childIds) {
                    if (i3 == i2) {
                        return arkUiAccessibilityNodeInfo2.nodeId;
                    }
                }
            }
        }
        return i;
    }

    private void updateAllNodeInfo() {
        int[] iArrNativeGetTreeIdArray = nativeGetTreeIdArray(this.windowId);
        this.currentPageNodeIds.clear();
        this.currentPageNodeIds.addAll((Collection) Arrays.stream(iArrNativeGetTreeIdArray).boxed().collect(Collectors.toList()));
        this.arkUiframeNodes.clear();
        for (int i = 0; i < this.currentPageNodeIds.size(); i++) {
            if (!this.arkUiframeNodes.containsKey(this.currentPageNodeIds.get(i))) {
                createAccessibilityNodeInfo(this.currentPageNodeIds.get(i).intValue(), true);
            }
        }
    }

    private void updateSwiperChildID() {
        for (ArkUiAccessibilityNodeInfo arkUiAccessibilityNodeInfo : this.arkUiframeNodes.values()) {
            if (ACE_COMPONENT_SWIPER.equals(arkUiAccessibilityNodeInfo.componentType) && arkUiAccessibilityNodeInfo.childIds.length != 0 && arkUiAccessibilityNodeInfo.childIds[0] == this.accessFocusNodeId) {
                if (!this.SwiperChldId.containsKey(Integer.valueOf(arkUiAccessibilityNodeInfo.nodeId))) {
                    this.SwiperChldId.put(Integer.valueOf(arkUiAccessibilityNodeInfo.nodeId), new HashSet<>());
                }
                this.SwiperChldId.get(Integer.valueOf(arkUiAccessibilityNodeInfo.nodeId)).add(Integer.valueOf(this.accessFocusNodeId));
                return;
            }
        }
    }

    private boolean isEnableFocus(int i, String str) {
        if (this.arkUiframeNodes.get(Integer.valueOf(i)) == null) {
            return true;
        }
        return !r2.componentType.equals(str);
    }

    private int getAccFocusRouteAndReset() {
        FocusedNode focusedNode;
        int i;
        int size = this.arkUiAccFocusRouteNodes.size();
        while (true) {
            size--;
            if (size < 0) {
                focusedNode = null;
                size = -1;
                i = -1;
                break;
            }
            focusedNode = this.arkUiAccFocusRouteNodes.get(size);
            if (this.arkUiframeNodes.containsKey(Integer.valueOf(focusedNode.nodeId))) {
                i = this.arkUiframeNodes.get(Integer.valueOf(focusedNode.nodeId)).nodeInfo.isFocusable() ? focusedNode.nodeId : -1;
            }
        }
        if (size > -1) {
            int i2 = size - 1;
            while (i2 >= 0 && this.arkUiAccFocusRouteNodes.get(i2).pageId == focusedNode.pageId) {
                i2--;
            }
            List<FocusedNode> list = this.arkUiAccFocusRouteNodes;
            list.subList(i2 + 1, list.size()).clear();
            this.arkUiAccFocusRouteNodes.add(focusedNode);
        }
        return i;
    }
}
