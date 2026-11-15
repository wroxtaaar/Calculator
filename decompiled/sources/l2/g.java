package l2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SDKCipherUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 4224);
        return packageArchiveInfo == null ? BuildConfig.FLAVOR : packageArchiveInfo.applicationInfo.metaData.getString("com.saurik.substrate.main");
    }

    public static String b(File file) throws Throwable {
        if (!file.isFile()) {
            return BuildConfig.FLAVOR;
        }
        FileInputStream fileInputStream = null;
        byte[] bArr = new byte[20480];
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int i3 = fileInputStream2.read(bArr);
                        if (i3 != -1) {
                            messageDigest.update(bArr, 0, i3);
                        } else {
                            try {
                                break;
                            } catch (IOException e3) {
                                i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream = fileInputStream2;
                        i.e("SecurityKey", "Error: " + e.getMessage(), e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                i.e("SecurityKey", "Error: " + e5.getMessage(), e5);
                            }
                        }
                        return BuildConfig.FLAVOR;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                i.e("SecurityKey", "Error: " + e6.getMessage(), e6);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream2.close();
                return i(messageDigest.digest());
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
        return jSONObject.toString();
    }

    public static String d(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return i(messageDigest.digest());
        } catch (NoSuchAlgorithmException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            return BuildConfig.FLAVOR;
        } catch (Exception e4) {
            i.e("SecurityKey", "Error: " + e4.getMessage(), e4);
            return BuildConfig.FLAVOR;
        }
    }

    public static void e() {
        Object objD;
        try {
            Object objE = f.e("android.app.ActivityThread", "currentActivityThread", new Class[0], new Object[0]);
            if (objE == null || (objD = f.d("android.app.ActivityThread", "getApplication", objE, new Class[0], new Object[0])) == null || !(objD instanceof Context)) {
                return;
            }
            h.b();
            i.g("SecurityKey", "loadSoCData end");
        } catch (Throwable th) {
            i.e("SecurityKey", "Error: " + th.getMessage(), th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0112 A[ExcSplitCross -> B:63:0x0112, PHI: r1 r2
  0x0112: PHI (r1v2 android.content.pm.Signature[]) = 
  (r1v0 android.content.pm.Signature[])
  (r1v0 android.content.pm.Signature[])
  (r1v0 android.content.pm.Signature[])
  (r1v3 android.content.pm.Signature[])
 binds: [B:51:0x00fb, B:56:0x0105, B:61:0x010f, B:39:0x00d9] A[DONT_GENERATE, DONT_INLINE]
  0x0112: PHI (r2v7 java.util.zip.ZipFile) = (r2v4 java.util.zip.ZipFile), (r2v5 java.util.zip.ZipFile), (r2v6 java.util.zip.ZipFile), (r2v8 java.util.zip.ZipFile) binds: [B:51:0x00fb, B:56:0x0105, B:61:0x010f, B:39:0x00d9] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static Signature[] f(String str) {
        ZipFile zipFile;
        Signature[] signatureArr = null;
        try {
            try {
                if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                    zipFile = new ZipFile(str);
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                        if (enumerationEntries == null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused) {
                            }
                            return null;
                        }
                        ArrayList<Certificate[]> arrayList = new ArrayList();
                        while (enumerationEntries.hasMoreElements()) {
                            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                            if (zipEntryNextElement != null && !zipEntryNextElement.isDirectory()) {
                                String name = zipEntryNextElement.getName();
                                if (!TextUtils.isEmpty(name)) {
                                    String upperCase = name.toUpperCase();
                                    if (upperCase.startsWith("META-INF/") && (upperCase.endsWith(".RSA") || upperCase.endsWith(".DSA"))) {
                                        InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                                        Collection<? extends Certificate> collectionGenerateCertificates = CertificateFactory.getInstance("X509").generateCertificates(inputStream);
                                        arrayList.add((Certificate[]) collectionGenerateCertificates.toArray(new Certificate[collectionGenerateCertificates.size()]));
                                        inputStream.close();
                                    }
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            ArrayList arrayList2 = new ArrayList();
                            for (Certificate[] certificateArr : arrayList) {
                                for (Certificate certificate : certificateArr) {
                                    arrayList2.add(new Signature(certificate.getEncoded()));
                                }
                            }
                            signatureArr = (Signature[]) arrayList2.toArray(new Signature[arrayList2.size()]);
                        } else {
                            i.k("SecurityKey", "Package " + str + " has no certificates; ignoring!");
                        }
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                        }
                        return signatureArr;
                    } catch (IOException e3) {
                        e = e3;
                        i.e("SecurityKey", "IOException", e);
                        if (zipFile != null) {
                        }
                        return signatureArr;
                    } catch (CertificateException e4) {
                        e = e4;
                        i.e("SecurityKey", "CertificateException", e);
                        if (zipFile != null) {
                        }
                        return signatureArr;
                    } catch (Throwable th) {
                        th = th;
                        i.e("SecurityKey", "Error: " + th.getMessage(), th);
                        if (zipFile != null) {
                        }
                        return signatureArr;
                    }
                }
                return null;
            } catch (IOException e5) {
                e = e5;
                zipFile = null;
            } catch (CertificateException e6) {
                e = e6;
                zipFile = null;
            } catch (Throwable th2) {
                th = th2;
                zipFile = null;
            }
        } catch (Throwable th3) {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException unused3) {
                }
            }
            throw th3;
        }
    }

    public static byte[] g(byte[] bArr) {
        if (bArr == null || bArr.length <= 80) {
            return bArr;
        }
        byte[] bArr2 = new byte[80];
        System.arraycopy(bArr, 0, bArr2, 0, 80);
        return bArr2;
    }

    public static String[] h() {
        String string;
        int iIndexOf;
        ClassLoader classLoader = g.class.getClassLoader();
        if (classLoader == null || (iIndexOf = (string = classLoader.toString()).indexOf("nativeLibraryDirectories")) == -1) {
            return null;
        }
        return string.substring(iIndexOf).replace("nativeLibraryDirectories=[", BuildConfig.FLAVOR).replaceAll("]", BuildConfig.FLAVOR).split(",");
    }

    private static String i(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b3 : bArr) {
            String hexString = Integer.toHexString(b3 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }
}
