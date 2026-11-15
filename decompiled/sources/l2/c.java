package l2;

import com.vivo.seckeysdk.utils.SecurityKeyException;

/* JADX INFO: compiled from: Base64Utils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f5285a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f5286b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int i5 = bArr[i3] & 255;
            if (i4 == length) {
                stringBuffer.append(f5285a[i5 >>> 2]);
                stringBuffer.append(f5285a[(i5 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            if (i6 == length) {
                stringBuffer.append(f5285a[i5 >>> 2]);
                stringBuffer.append(f5285a[((i5 & 3) << 4) | ((i7 & 240) >>> 4)]);
                stringBuffer.append(f5285a[(i7 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i8 = i6 + 1;
            int i9 = bArr[i6] & 255;
            stringBuffer.append(f5285a[i5 >>> 2]);
            stringBuffer.append(f5285a[((i5 & 3) << 4) | ((i7 & 240) >>> 4)]);
            stringBuffer.append(f5285a[((i7 & 15) << 2) | ((i9 & 192) >>> 6)]);
            stringBuffer.append(f5285a[i9 & 63]);
            i3 = i8;
        }
        return stringBuffer.toString();
    }

    public static byte[] b(String str) throws SecurityKeyException {
        int i3;
        byte b3;
        int i4;
        byte b4;
        int i5;
        byte b5;
        int i6;
        byte b6;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bytes = str.getBytes("US-ASCII");
            int length = bytes.length;
            int i7 = 0;
            while (i7 < length) {
                while (true) {
                    i3 = i7 + 1;
                    b3 = f5286b[bytes[i7]];
                    if (i3 >= length || b3 != -1) {
                        break;
                        break;
                    }
                    i7 = i3;
                }
                if (b3 == -1) {
                    break;
                }
                while (true) {
                    i4 = i3 + 1;
                    b4 = f5286b[bytes[i3]];
                    if (i4 >= length || b4 != -1) {
                        break;
                        break;
                    }
                    i3 = i4;
                }
                if (b4 == -1) {
                    break;
                }
                stringBuffer.append((char) ((b3 << 2) | ((b4 & 48) >>> 4)));
                while (true) {
                    i5 = i4 + 1;
                    byte b7 = bytes[i4];
                    if (b7 != 61) {
                        b5 = f5286b[b7];
                        if (i5 >= length || b5 != -1) {
                            break;
                            break;
                        }
                        i4 = i5;
                    } else {
                        return stringBuffer.toString().getBytes("iso8859-1");
                    }
                }
                if (b5 == -1) {
                    break;
                }
                stringBuffer.append((char) (((b4 & 15) << 4) | ((b5 & 60) >>> 2)));
                while (true) {
                    i6 = i5 + 1;
                    byte b8 = bytes[i5];
                    if (b8 != 61) {
                        b6 = f5286b[b8];
                        if (i6 >= length || b6 != -1) {
                            break;
                            break;
                        }
                        i5 = i6;
                    } else {
                        return stringBuffer.toString().getBytes("iso8859-1");
                    }
                }
                if (b6 == -1) {
                    break;
                }
                stringBuffer.append((char) (b6 | ((b5 & 3) << 6)));
                i7 = i6;
            }
            return stringBuffer.toString().getBytes("iso8859-1");
        } catch (Throwable th) {
            i.e("SecurityKey", "Error: " + th.getMessage(), th);
            throw new SecurityKeyException("This data is illegal ciphertext, please check！:base64 decode failed:" + th.getMessage(), SecurityKeyException.SK_ERROR_BASE64_DECODE_FAIL);
        }
    }
}
