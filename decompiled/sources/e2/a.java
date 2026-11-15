package e2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.seckeysdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vivo.util.VLog;

/* JADX INFO: compiled from: DomainHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f4615d = "a";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f4616e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f4617f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f4618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f4619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, List<d>> f4620c;

    /* JADX INFO: compiled from: DomainHelper.java */
    private abstract class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4621a;

        public String c() {
            return this.f4621a;
        }

        private b(String str) {
            this.f4621a = str;
        }
    }

    /* JADX INFO: compiled from: DomainHelper.java */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VLog.d(a.f4615d, "receive domain change broadcast");
            a.this.f();
        }
    }

    /* JADX INFO: compiled from: DomainHelper.java */
    private interface d {
        boolean a();

        String b(String str);
    }

    /* JADX INFO: compiled from: DomainHelper.java */
    private final class e extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, String> f4624c;

        private void d() throws Throwable {
            if (this.f4624c == null) {
                this.f4624c = new HashMap();
                byte[] bArrM = a.this.m(new File("oem/etc/domains/" + c()));
                if (bArrM == null) {
                    return;
                }
                try {
                    Map<? extends String, ? extends String> mapL = a.this.l(bArrM);
                    if (mapL != null) {
                        this.f4624c.putAll(mapL);
                    }
                } catch (Exception e3) {
                    VLog.e(a.f4615d, "confirmLocalDefaultMap e" + e3);
                }
            }
        }

        @Override // e2.a.d
        public boolean a() {
            if (this.f4624c != null) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("oem/etc/domains/");
            sb.append(c());
            return new File(sb.toString()).exists();
        }

        @Override // e2.a.d
        public String b(String str) throws Throwable {
            d();
            String str2 = this.f4624c.get(str);
            return TextUtils.isEmpty(str2) ? BuildConfig.FLAVOR : str2;
        }

        private e(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: DomainHelper.java */
    private final class f extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, ?> f4626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4627d;

        /* JADX INFO: renamed from: e2.a$f$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DomainHelper.java */
        class C0058a implements FileFilter {
            C0058a() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file == null) {
                    return false;
                }
                String path = file.getPath();
                return !TextUtils.isEmpty(path) && path.endsWith(f.this.c());
            }
        }

        private void d() throws Throwable {
            String name;
            int iLastIndexOf;
            File[] fileArrListFiles;
            if (this.f4627d) {
                return;
            }
            this.f4627d = true;
            File file = new File("data/bbkcore/domains/");
            File file2 = null;
            if (file.exists() && (fileArrListFiles = file.listFiles(new C0058a())) != null && fileArrListFiles.length > 0) {
                file2 = fileArrListFiles[0];
            }
            if (file2 == null || !file2.exists() || (iLastIndexOf = (name = file2.getName()).lastIndexOf(c())) <= 0) {
                return;
            }
            try {
                SharedPreferences sharedPreferences = a.this.f4619b.getSharedPreferences("sp_vivo_damons_domain_cache", 0);
                String strSubstring = name.substring(0, iLastIndexOf);
                if (sharedPreferences.getString("sp_key_crc_" + c(), BuildConfig.FLAVOR).equals(strSubstring)) {
                    VLog.i(a.f4615d, "skip read vivo damons file");
                    return;
                }
                byte[] bArrM = a.this.m(file2);
                if (bArrM == null) {
                    VLog.e(a.f4615d, "read vivoDomainFile error");
                    return;
                }
                CRC32 crc32 = new CRC32();
                crc32.update(bArrM);
                String str = String.format("%08x", Long.valueOf(crc32.getValue()));
                if (!strSubstring.equals(str)) {
                    VLog.e(a.f4615d, "skip read vivo damons file");
                    return;
                }
                Map mapL = a.this.l(bArrM);
                if (mapL == null || mapL.size() <= 0) {
                    return;
                }
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("sp_key_crc_" + c(), str);
                for (Map.Entry entry : mapL.entrySet()) {
                    editorEdit.putString((String) entry.getKey(), (String) entry.getValue());
                }
                if (editorEdit.commit()) {
                    return;
                }
                VLog.e(a.f4615d, "commit failed!");
            } catch (Exception e3) {
                VLog.e(a.f4615d, "read or parse error", e3);
            }
        }

        @Override // e2.a.d
        public boolean a() throws Throwable {
            d();
            return true;
        }

        @Override // e2.a.d
        public String b(String str) {
            SharedPreferences sharedPreferences = a.this.f4619b.getSharedPreferences("sp_vivo_damons_domain_cache", 0);
            if (this.f4626c == null) {
                this.f4626c = sharedPreferences.getAll();
            }
            Object obj = this.f4626c.get(str);
            return (obj != null && (obj instanceof String)) ? (String) obj : BuildConfig.FLAVOR;
        }

        private f(String str) {
            super(str);
            this.f4627d = false;
        }
    }

    /* JADX INFO: compiled from: DomainHelper.java */
    private final class g extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, String> f4630c;

        /* JADX INFO: renamed from: e2.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DomainHelper.java */
        class C0059a implements FileFilter {
            C0059a() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file == null) {
                    return false;
                }
                String path = file.getPath();
                return !TextUtils.isEmpty(path) && path.endsWith(g.this.c());
            }
        }

        private void d() throws Throwable {
            String name;
            int iLastIndexOf;
            File[] fileArrListFiles;
            if (this.f4630c == null) {
                this.f4630c = new HashMap();
                File file = new File("data/bbkcore/domains/");
                File file2 = null;
                if (file.exists() && (fileArrListFiles = file.listFiles(new C0059a())) != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                if (file2 == null || !file2.exists() || (iLastIndexOf = (name = file2.getName()).lastIndexOf(c())) <= 0) {
                    return;
                }
                try {
                    byte[] bArrM = a.this.m(file2);
                    if (bArrM == null) {
                        VLog.e(a.f4615d, "read vivoDomainFile error");
                        return;
                    }
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArrM);
                    if (!name.substring(0, iLastIndexOf).equals(String.format("%08x", Long.valueOf(crc32.getValue())))) {
                        VLog.e(a.f4615d, "skip read vivo damons file");
                        return;
                    }
                    Map<? extends String, ? extends String> mapL = a.this.l(bArrM);
                    if (mapL != null) {
                        this.f4630c.putAll(mapL);
                    }
                } catch (Exception e3) {
                    VLog.e(a.f4615d, "read or parse error", e3);
                }
            }
        }

        @Override // e2.a.d
        public boolean a() throws Throwable {
            d();
            return true;
        }

        @Override // e2.a.d
        public String b(String str) {
            String str2 = this.f4630c.get(str);
            return (str2 != null && (str2 instanceof String)) ? str2 : BuildConfig.FLAVOR;
        }

        private g(String str) {
            super(str);
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        Map<String, List<d>> map = this.f4620c;
        if (map != null) {
            map.clear();
        }
    }

    public static a i() {
        if (f4617f == null) {
            synchronized (a.class) {
                if (f4617f == null) {
                    f4617f = new a();
                }
            }
        }
        return f4617f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> l(byte[] bArr) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8").trim());
        if (!jSONObject.has("metadatas")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("metadatas");
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            String string = jSONObject2.getString("key");
            String string2 = jSONObject2.getString("value");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                map.put(string, string2);
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:54:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[SYNTHETIC] */
    public byte[] m(File file) throws Throwable {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    while (true) {
                        try {
                            int i3 = fileInputStream.read(bArr);
                            if (i3 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i3);
                        } catch (Exception e3) {
                            e = e3;
                            VLog.e(f4615d, "read or parse error", e);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    VLog.e(f4615d, "readFile e" + e4);
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e5) {
                                    VLog.e(f4615d, "readFile e 2 " + e5);
                                }
                            }
                            return null;
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        VLog.e(f4615d, "readFile e" + e6);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        VLog.e(f4615d, "readFile e 2 " + e7);
                    }
                    return byteArray;
                } catch (Exception e8) {
                    e = e8;
                    byteArrayOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e9) {
                            VLog.e(f4615d, "readFile e" + e9);
                        }
                    }
                    if (fileInputStream2 != 0) {
                        throw th;
                    }
                    try {
                        fileInputStream2.close();
                        throw th;
                    } catch (IOException e10) {
                        VLog.e(f4615d, "readFile e 2 " + e10);
                        throw th;
                    }
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileInputStream2 != 0) {
                    throw th;
                }
                fileInputStream2.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private String n(String str, List<d> list) {
        String strB = null;
        for (d dVar : list) {
            if (dVar.a()) {
                strB = dVar.b(str);
                if (!TextUtils.isEmpty(strB)) {
                    break;
                }
            }
        }
        return TextUtils.isEmpty(strB) ? BuildConfig.FLAVOR : strB;
    }

    public String g(String str, String str2) {
        return h(str, str2, null);
    }

    public synchronized String h(String str, String str2, String str3) {
        if (this.f4619b == null) {
            return str2;
        }
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String str4 = "com.android.bbkcalculator";
        if (this.f4620c == null) {
            this.f4620c = new HashMap();
        }
        List<d> arrayList = this.f4620c.get("com.android.bbkcalculator");
        if (arrayList == null) {
            VLog.d(f4615d, "Create Repo List By packageName:com.android.bbkcalculator,key:" + str);
            arrayList = new ArrayList<>();
            if (f4616e) {
                arrayList.add(new g(str4));
            } else {
                arrayList.add(new f(str4));
            }
            arrayList.add(new e(str4));
            this.f4620c.put("com.android.bbkcalculator", arrayList);
        }
        String strN = n(str, arrayList);
        if (!TextUtils.isEmpty(strN) && !BuildConfig.FLAVOR.equals(strN)) {
            str2 = strN;
        }
        return str2;
    }

    public void j(Context context) {
        k(context, false, false);
    }

    public void k(Context context, boolean z2, boolean z3) {
        f4616e = z3;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f4619b = context.getApplicationContext().createDeviceProtectedStorageContext();
        } else {
            this.f4619b = context.getApplicationContext();
        }
        if (z2) {
            c cVar = this.f4618a;
            if (cVar == null) {
                this.f4618a = new c();
            } else {
                try {
                    this.f4619b.unregisterReceiver(cVar);
                } catch (Exception e3) {
                    VLog.e(f4615d, "unregisterReceiver fatal! " + e3.toString());
                }
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.vivo.domainsync.action.DOMAINS_UPDATE");
            this.f4619b.registerReceiver(this.f4618a, intentFilter);
        }
    }
}
