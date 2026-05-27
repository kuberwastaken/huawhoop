package ohos.ace.adapter.capability.texture;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.HashMap;
import java.util.Map;
import ohos.ace.adapter.ALog;
import ohos.ace.adapter.AceTextureHolder;
import ohos.ace.adapter.IAceOnCallResourceMethod;
import ohos.ace.adapter.IAceOnResourceEvent;

/* JADX INFO: loaded from: classes8.dex */
public class AceTexture {
    private static final String EVENT = "event";
    private static final String FALSE = "false";
    private static final String LOG_TAG = "AceTexture";
    private static final String METHOD = "method";
    private static final String PARAM_BEGIN = "#HWJS-?-#";
    private static final String PARAM_EQUALS = "#HWJS-=-#";
    private static final String SUCCESS = "success";
    private static final String TEXTURE_ATTACH_TO_GL_CONTEXT_KEY = "attachToGLContext";
    private static final String TEXTURE_FLAG = "texture@";
    private static final String TEXTURE_HEIGHT_KEY = "textureHeight";
    private static final String TEXTURE_ID_KEY = "textureId";
    private static final String TEXTURE_INIT_PARAM_KEY = "initParam";
    private static final String TEXTURE_IS_ATTACH = "isAttach";
    private static final String TEXTURE_REGISTER_SURFACE_VALUE = "registerSurface";
    private static final String TEXTURE_SET_TEXTURE_SIZE_KEY = "setTextureSize";
    private static final String TEXTURE_UPDATE_TEXTURE_IMAGE_KEY = "updateTextureImage";
    private static final String TEXTURE_WIDTH_KEY = "textureWidth";
    private Map<String, IAceOnCallResourceMethod> callMethodMap;
    private final IAceOnResourceEvent callback;
    protected final long id;
    private int instanceId;
    protected final SurfaceTexture surfaceTexture;
    protected final IAceTexture textureImpl;
    protected Surface surface = null;
    protected boolean hasRegisterSurface = false;
    private boolean hasRegisterTexture = false;
    private int textureWidth = 0;
    private int textureHeight = 0;
    private float[] transform = new float[16];
    private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: ohos.ace.adapter.capability.texture.AceTexture.1
        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            AceTexture.this.markTextureFrame();
        }
    };

    public AceTexture(int i, long j, IAceTexture iAceTexture, IAceOnResourceEvent iAceOnResourceEvent, Map<String, String> map) {
        this.instanceId = -1;
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.detachFromGLContext();
        surfaceTexture.setOnFrameAvailableListener(this.onFrameListener);
        this.instanceId = i;
        this.id = j;
        this.textureImpl = iAceTexture;
        this.callback = iAceOnResourceEvent;
        this.callMethodMap = new HashMap();
        IAceOnCallResourceMethod iAceOnCallResourceMethod = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.texture.AceTexture.2
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                return AceTexture.this.setTextureSize(map2);
            }
        };
        this.callMethodMap.put(TEXTURE_FLAG + j + "method#HWJS-=-#setTextureSize#HWJS-?-#", iAceOnCallResourceMethod);
        IAceOnCallResourceMethod iAceOnCallResourceMethod2 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.texture.AceTexture.3
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                return AceTexture.this.attachToGLContext(map2);
            }
        };
        this.callMethodMap.put(TEXTURE_FLAG + j + "method#HWJS-=-#attachToGLContext#HWJS-?-#", iAceOnCallResourceMethod2);
        IAceOnCallResourceMethod iAceOnCallResourceMethod3 = new IAceOnCallResourceMethod() { // from class: ohos.ace.adapter.capability.texture.AceTexture.4
            @Override // ohos.ace.adapter.IAceOnCallResourceMethod
            public String onCall(Map<String, String> map2) {
                return AceTexture.this.updateTextureImage(map2);
            }
        };
        this.callMethodMap.put(TEXTURE_FLAG + j + "method#HWJS-=-#updateTextureImage#HWJS-?-#", iAceOnCallResourceMethod3);
        registerSurface();
        AceTextureHolder.addSurfaceTexture(j, surfaceTexture);
    }

    public Map<String, IAceOnCallResourceMethod> getCallMethod() {
        return this.callMethodMap;
    }

    public String setTextureSize(Map<String, String> map) {
        if (!map.containsKey(TEXTURE_WIDTH_KEY) || !map.containsKey(TEXTURE_HEIGHT_KEY)) {
            return FALSE;
        }
        try {
            this.textureWidth = Integer.parseInt(map.get(TEXTURE_WIDTH_KEY));
            int i = Integer.parseInt(map.get(TEXTURE_HEIGHT_KEY));
            this.textureHeight = i;
            setDefaultBufferSize(this.textureWidth, i);
            return "success";
        } catch (NumberFormatException unused) {
            ALog.e(LOG_TAG, "NumberFormatException, setTextureSize failed");
            return FALSE;
        }
    }

    public String updateTextureImage(Map<String, String> map) {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture == null) {
            ALog.e(LOG_TAG, "updateTextureImage surfaceTexture is null.");
            return FALSE;
        }
        surfaceTexture.updateTexImage();
        this.surfaceTexture.getTransformMatrix(this.transform);
        long timestamp = this.surfaceTexture.getTimestamp();
        if (timestamp == 0) {
            ALog.e(LOG_TAG, "updateTextureImage etimestamp " + timestamp);
        }
        String str = "transform=[" + this.transform[0];
        for (int i = 1; i < this.transform.length; i++) {
            str = (str + ",") + this.transform[i];
        }
        return str + "]";
    }

    public String attachToGLContext(Map<String, String> map) {
        ALog.i(LOG_TAG, "attachToGLContext start.");
        if (!map.containsKey(TEXTURE_ID_KEY)) {
            ALog.e(LOG_TAG, "attachToGLContext texture id is empty.");
            return FALSE;
        }
        if (this.surfaceTexture == null) {
            ALog.e(LOG_TAG, "attachToGLContext surfaceTexture is null.");
            return FALSE;
        }
        int i = Integer.parseInt(map.get(TEXTURE_ID_KEY));
        if (Integer.parseInt(map.get(TEXTURE_IS_ATTACH)) == 1) {
            this.surfaceTexture.attachToGLContext(i);
        } else {
            this.surfaceTexture.detachFromGLContext();
        }
        ALog.i(LOG_TAG, "attachToGLContext end." + i);
        return "success";
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public void setDefaultBufferSize(int i, int i2) {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i, i2);
        }
    }

    public void registerSurface() {
        if (this.surface == null) {
            this.surface = new Surface(this.surfaceTexture);
        }
        if (this.hasRegisterSurface) {
            return;
        }
        ALog.i(LOG_TAG, "registerSurface, id:" + this.id);
        this.textureImpl.registerSurface(this.id, this.surface);
        this.hasRegisterSurface = true;
    }

    public Surface getSurface() {
        return new Surface(this.surfaceTexture);
    }

    public long getId() {
        return this.id;
    }

    public void release() {
        this.surfaceTexture.setOnFrameAvailableListener(null);
        this.textureImpl.unregisterTexture(this.id);
        this.textureImpl.unregisterSurface(this.id);
        AceTextureHolder.removeSurfaceTexture(this.id);
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surfaceTexture.release();
    }

    public void setSurfaceTexture() {
        this.textureImpl.registerTexture(this.id, this.surfaceTexture);
    }

    public void markTextureFrame() {
        if (!this.hasRegisterTexture) {
            setSurfaceTexture();
            this.hasRegisterTexture = true;
        }
        this.textureImpl.markTextureFrameAvailable(this.id);
        String str = "instanceId=" + this.instanceId + "&textureId=" + this.id;
        this.callback.onEvent(TEXTURE_FLAG + this.id + "event#HWJS-=-#markTextureAvailable#HWJS-?-#", str);
    }
}
