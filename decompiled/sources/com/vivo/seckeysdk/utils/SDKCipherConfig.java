package com.vivo.seckeysdk.utils;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SDKCipherConfig {
    private static boolean isAntiFrida = false;
    private static boolean isAntiInject = false;
    private static boolean isAntiNativeDebug = false;
    private static boolean isAntiSmaliDebug = false;
    private static boolean isAntiSubstrate = true;
    private static boolean isAntiXposed = true;
    private static boolean isExitWhenSignVerifyFail = true;
    private static boolean isOpenDarkPoint = true;
    public static Map<String, Object> userConfigs = new HashMap();
    public static int cacheResponseMaxTime = 1440;
    public static boolean cacheUpdateKeyResponse = true;
    public static int soEncryptMaxLen = 10485760;
    private static int currentProtectionMode = a.NONE.ordinal();

    public enum a {
        NONE,
        SDK_PROTECTION,
        APP_PROTECTION,
        END
    }

    public static int getCacheResponseMaxTime() {
        return cacheResponseMaxTime;
    }

    public static int getCurrentProtectionMode() {
        return currentProtectionMode;
    }

    public static int getSoEncryptMaxLen() {
        return soEncryptMaxLen;
    }

    public static boolean isAntiFrida() {
        return isAntiFrida;
    }

    public static boolean isAntiInject() {
        return isAntiInject;
    }

    public static boolean isAntiNativeDebug() {
        return isAntiNativeDebug;
    }

    public static boolean isAntiSmaliDebug() {
        return isAntiSmaliDebug;
    }

    public static boolean isAntiSubstrate() {
        return isAntiSubstrate;
    }

    public static boolean isAntiXposed() {
        return isAntiXposed;
    }

    public static boolean isCacheUpdateKeyResponse() {
        return cacheUpdateKeyResponse;
    }

    public static boolean isExitWhenSignVerifyFail() {
        return isExitWhenSignVerifyFail;
    }

    public static boolean isOpenDarkPoint() {
        return isOpenDarkPoint;
    }

    public static void setAntiFrida(boolean z2) {
        userConfigs.put("setAntiFrida", Boolean.valueOf(z2));
        isAntiFrida = z2;
    }

    public static void setAntiInject(boolean z2) {
        userConfigs.put("setAntiInject", Boolean.valueOf(z2));
        isAntiInject = z2;
    }

    public static void setAntiNativeDebug(boolean z2) {
        userConfigs.put("setAntiNativeDebug", Boolean.valueOf(z2));
        isAntiNativeDebug = z2;
    }

    public static void setAntiSmaliDebug(boolean z2) {
        userConfigs.put("setAntiSmaliDebug", Boolean.valueOf(z2));
        isAntiSmaliDebug = z2;
    }

    public static void setAntiSubstrate(boolean z2) {
        userConfigs.put("setAntiSubstrate", Boolean.valueOf(z2));
        isAntiSubstrate = z2;
    }

    public static void setAntiXposed(boolean z2) {
        userConfigs.put("setAntiXposed", Boolean.valueOf(z2));
        isAntiXposed = z2;
    }

    public static void setCacheResponseMaxTime(int i3) {
        cacheResponseMaxTime = i3;
    }

    public static void setCacheUpdateKeyResponse(boolean z2) {
        cacheUpdateKeyResponse = z2;
    }

    public static void setCurrentProtectionMode(int i3) {
        userConfigs.put("setCurrentProtectionMode", Integer.valueOf(i3));
        currentProtectionMode = i3;
    }

    public static void setExitWhenSignVerifyFail(boolean z2) {
        userConfigs.put("setExitWhenSignVerifyFail", Boolean.valueOf(z2));
        isExitWhenSignVerifyFail = z2;
    }

    public static void setOpenDarkPoint(boolean z2) {
        userConfigs.put("setOpenDarkPoint", Boolean.valueOf(z2));
        isOpenDarkPoint = z2;
    }

    public static void setSecurityMode(String str, int i3) {
        if (i3 != -1) {
            if (userConfigs.get("setAntiSubstrate") == null) {
                if ((i3 & 2) == 2) {
                    setAntiSubstrate(true);
                } else {
                    setAntiSubstrate(false);
                }
            }
            if (userConfigs.get("setExitWhenSignVerifyFail") == null) {
                if ((i3 & 128) == 128) {
                    setExitWhenSignVerifyFail(true);
                } else {
                    setExitWhenSignVerifyFail(false);
                }
            }
            if (userConfigs.get("setOpenDarkPoint") == null) {
                if ((i3 & 64) == 64) {
                    setOpenDarkPoint(true);
                } else {
                    setOpenDarkPoint(false);
                }
            }
            if (userConfigs.get("setAntiXposed") == null) {
                if ((i3 & 1) == 1) {
                    setAntiXposed(true);
                } else {
                    setAntiXposed(false);
                }
            }
            if (userConfigs.get("setAntiFrida") == null) {
                if ((i3 & 32) == 32) {
                    setAntiFrida(true);
                } else {
                    setAntiFrida(false);
                }
            }
            if (userConfigs.get("setAntiSmaliDebug") == null) {
                if ((i3 & 8) == 8) {
                    setAntiSmaliDebug(true);
                } else {
                    setAntiSmaliDebug(false);
                }
            }
            if (userConfigs.get("setAntiNativeDebug") == null) {
                if ((i3 & 16) == 16) {
                    setAntiNativeDebug(true);
                } else {
                    setAntiNativeDebug(false);
                }
            }
            if (userConfigs.get("setAntiInject") != null) {
                return;
            }
            if ((i3 & 4) == 4) {
                setAntiInject(true);
                return;
            }
        } else {
            if (TextUtils.isEmpty(str) || !str.equals("Close")) {
                return;
            }
            if (userConfigs.get("setAntiSubstrate") == null) {
                setAntiSubstrate(false);
            }
            if (userConfigs.get("setExitWhenSignVerifyFail") == null) {
                setExitWhenSignVerifyFail(false);
            }
            if (userConfigs.get("setOpenDarkPoint") == null) {
                setOpenDarkPoint(false);
            }
            if (userConfigs.get("setAntiXposed") == null) {
                setAntiXposed(false);
            }
            if (userConfigs.get("setAntiFrida") == null) {
                setAntiFrida(false);
            }
            if (userConfigs.get("setAntiSmaliDebug") == null) {
                setAntiSmaliDebug(false);
            }
            if (userConfigs.get("setAntiNativeDebug") == null) {
                setAntiNativeDebug(false);
            }
            if (userConfigs.get("setAntiInject") != null) {
                return;
            }
        }
        setAntiInject(false);
    }

    public static void setSoEncryptMaxLen(int i3) {
        soEncryptMaxLen = i3;
    }
}
