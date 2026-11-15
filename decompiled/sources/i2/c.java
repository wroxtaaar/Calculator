package i2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.seckeysdk.SecurityKeyCipher;
import com.vivo.seckeysdk.utils.ProtocolPackage;
import com.vivo.seckeysdk.utils.SecurityKeyException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import l2.g;
import l2.h;
import l2.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlatformCipher.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile Map<String, c> f4899h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f4900i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected j2.c f4901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f4902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f4903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f4906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4907g;

    private c(Context context) {
        j2.c cVar = new j2.c();
        this.f4901a = cVar;
        this.f4902b = false;
        this.f4903c = true;
        this.f4904d = 0;
        this.f4905e = 0;
        this.f4906f = false;
        this.f4907g = 7;
        cVar.d(context);
        this.f4901a.n(1);
        if (!S(context)) {
            this.f4901a.l(context.getPackageName());
            this.f4901a.a().j(context, null);
        }
        i.b("SecurityKey", this.f4901a, "Create new PlatformCipher");
    }

    private static int A(int i3, int i4) {
        int i5;
        if (i4 == 1) {
            return i3 & 255;
        }
        if (i4 == 2) {
            i5 = i3 >> 8;
        } else {
            if (i4 != 4) {
                return 0;
            }
            i5 = i3 >> 16;
        }
        return i5 & 255;
    }

    public static c B(Context context) {
        return M(context);
    }

    private void C(ProtocolPackage protocolPackage, int i3, String str) throws SecurityKeyException {
        if (protocolPackage.getCipherMode() == 2 && protocolPackage.getCipherMode() == 2 && protocolPackage.getKeyVersion() != A(this.f4905e, i3)) {
            i.h("SecurityKey", this.f4901a, str + " key version is not match current:" + this.f4901a.f(i3) + " target:" + protocolPackage.getKeyVersion());
            i.h("SecurityKey", this.f4901a, str + " Please check env info. machine's env:" + ProtocolPackage.kv2EnvStr(this.f4901a.f(i3)) + ". but cipher's env:" + ProtocolPackage.kv2EnvStr(protocolPackage.getKeyVersion()));
            if (!t()) {
                throw new SecurityKeyException("security key not match", 153);
            }
            if (!U(i3)) {
                i.j("SecurityKey", this.f4901a, str + " update key fail");
                throw new SecurityKeyException("update key fail", 155);
            }
            if (protocolPackage.getKeyVersion() == A(this.f4905e, i3)) {
                return;
            }
            i.j("SecurityKey", this.f4901a, str + " key version still not match after sync key with server");
            throw new SecurityKeyException("security key not match", 153);
        }
    }

    private void D(j2.b bVar, ProtocolPackage protocolPackage, int i3, String str) throws SecurityKeyException {
        if (bVar == null) {
            return;
        }
        int i4 = bVar.f5011b;
        StringBuilder sb = new StringBuilder(str);
        sb.append(" error: ");
        sb.append(i4);
        if (SecurityKeyException.keyVersionNotMatched(i4)) {
            sb.append(" Please check env info ");
            sb.append(Z(i3));
            if (protocolPackage != null) {
                sb.append(protocolPackage.toString());
            }
        }
        i.j("SecurityKey", this.f4901a, sb.toString());
    }

    private void E(byte[] bArr) throws SecurityKeyException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!G(1)) {
            i.j("SecurityKey", this.f4901a, "security key cipher is not available while aE");
            throw new SecurityKeyException("not available!", 101);
        }
        if (jCurrentTimeMillis > this.f4901a.y() && jCurrentTimeMillis - this.f4901a.y() < 20) {
            try {
                Thread.sleep(20 - (jCurrentTimeMillis - this.f4901a.y()));
            } catch (InterruptedException e3) {
                i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            }
        }
        if (bArr == null) {
            i.j("SecurityKey", this.f4901a, "aesEncrypt input data is null");
            throw new SecurityKeyException("invalid input params!", 102);
        }
        if (bArr.length <= 204800) {
            return;
        }
        i.j("SecurityKey", this.f4901a, "aesEncrypt input data length " + bArr.length + " max length:204800");
        throw new SecurityKeyException("input length > 200k", 120);
    }

    public static boolean F() {
        int i3 = f4900i;
        if (i3 != -1) {
            return i3 == 1;
        }
        boolean zA0 = a0();
        if (zA0) {
            f4900i = 1;
        } else {
            f4900i = 0;
        }
        return zA0;
    }

    private synchronized boolean G(int i3) throws SecurityKeyException {
        boolean zU;
        if (!this.f4902b) {
            I(true);
        }
        if (!t()) {
            return this.f4901a.f(i3) != 0;
        }
        if ((this.f4901a.m() == 2 || this.f4901a.u() == 3) && this.f4901a.f(i3) != 0) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iL = L();
        if (this.f4901a.m() == 2) {
            i.h("SecurityKey", this.f4901a, "Try to get key " + i3 + "again");
            this.f4901a.c(jCurrentTimeMillis);
            return U(iL);
        }
        if (this.f4901a.w() == 1 && this.f4901a.u() == 1 && this.f4901a.m() == 3 && jCurrentTimeMillis - this.f4901a.x() > 28800000) {
            i.b("SecurityKey", this.f4901a, "Auto try to get keyType " + i3 + " again");
            try {
                this.f4901a.b(2);
                I(false);
                zU = U(L());
            } catch (SecurityKeyException e3) {
                if (!R(e3.getErrorCode())) {
                    this.f4901a.v();
                }
                zU = false;
            }
            if (!zU) {
                this.f4901a.c(jCurrentTimeMillis);
                this.f4901a.b(3);
                I(false);
            }
        }
        return true;
    }

    private boolean H(int i3, int i4, j2.b bVar) {
        if (bVar != null) {
            if (i3 != 21322) {
                h.e();
            }
            if (bVar.f5011b != 0) {
                i.j("SecurityKey", this.f4901a, "Actiontype " + h.a(i3) + "error: " + bVar.f5011b);
                return i4 < 2;
            }
        } else {
            if (i3 != 21322) {
                h.e();
            }
            i.j("SecurityKey", this.f4901a, "Actiontype " + h.a(i3) + "return null");
            if (i4 < 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003e A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x005e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067 A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006b A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0075 A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007b A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b5 A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c5 A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e3 A[Catch: all -> 0x017d, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0130 A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0028, B:9:0x0036, B:12:0x003e, B:15:0x0048, B:17:0x0050, B:26:0x0067, B:28:0x006b, B:30:0x0075, B:32:0x0080, B:34:0x0091, B:36:0x009d, B:38:0x00a3, B:39:0x00a8, B:41:0x00b5, B:43:0x00d0, B:42:0x00c5, B:31:0x007b, B:46:0x00e3, B:47:0x012f, B:48:0x0130, B:49:0x017c, B:20:0x0058, B:7:0x002f), top: B:53:0x0001 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x00e3, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:48:0x0130, please report this as an issue */
    private synchronized boolean I(boolean z2) throws SecurityKeyException {
        j2.b bVarV;
        j2.b bVarT;
        String strB;
        int iM = this.f4901a.m();
        i.f("SecurityKey", this.f4901a, "sync device information getAll=" + z2 + ",realCipherMode=" + iM);
        j2.b bVarT2 = null;
        if (z2) {
            bVarV = V();
        } else {
            if (iM == 2) {
                bVarV = V();
                bVarT = null;
            } else {
                bVarV = null;
            }
            if (iM == 2) {
                if (this.f4901a.u() == 1 || !(bVarV == null || N(bVarV.f5011b))) {
                    bVarT2 = bVarV;
                } else {
                    this.f4901a.b(3);
                    bVarT2 = bVarT != null ? bVarT : T();
                }
            } else if (iM == 3 && bVarT != null) {
            }
            if (bVarT2 != null) {
                i.j("SecurityKey", this.f4901a, "Get device information return null,".concat(String.valueOf("realCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.m()) + ",mCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.u()) + ",getAll=" + z2)));
                throw new SecurityKeyException("init failed!", 1000);
            }
            if (bVarT2.f5011b == 0) {
                i.j("SecurityKey", this.f4901a, "Get device information error: " + bVarT2.f5011b + ",realCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.m()) + ",mCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.u()) + ",getAll=" + z2);
                throw new SecurityKeyException("init failed!", bVarT2.f5011b);
            }
            if (bVarT2.f5014e.equals("0000")) {
                this.f4901a.b(3);
            } else {
                this.f4901a.b(2);
            }
            this.f4901a.e(bVarT2.f5014e);
            if (bVarT2.f5014e.equals("0000") && (strB = this.f4901a.a().b()) != null && !TextUtils.isEmpty(strB)) {
                this.f4901a.e(strB);
            }
            this.f4901a.k(bVarT2.f5013d);
            if (Build.VERSION.SDK_INT == 27) {
                this.f4901a.i(this.f4901a.a().e());
            } else {
                this.f4901a.i(l2.c.a(bVarT2.f5015f));
            }
            this.f4901a.o(W(this.f4901a.m()));
            this.f4902b = true;
        }
        bVarT = T();
        if (iM == 2) {
            if (this.f4901a.u() == 1) {
                bVarT2 = bVarV;
            } else {
                bVarT2 = bVarV;
            }
        } else if (iM == 3) {
        }
        if (bVarT2 != null) {
            i.j("SecurityKey", this.f4901a, "Get device information return null,".concat(String.valueOf("realCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.m()) + ",mCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.u()) + ",getAll=" + z2)));
            throw new SecurityKeyException("init failed!", 1000);
        }
        if (bVarT2.f5011b == 0) {
            i.j("SecurityKey", this.f4901a, "Get device information error: " + bVarT2.f5011b + ",realCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.m()) + ",mCipherMode=" + SecurityKeyCipher.modeToString(this.f4901a.u()) + ",getAll=" + z2);
            throw new SecurityKeyException("init failed!", bVarT2.f5011b);
        }
        if (bVarT2.f5014e.equals("0000")) {
            this.f4901a.b(3);
        } else {
            this.f4901a.b(2);
        }
        this.f4901a.e(bVarT2.f5014e);
        if (bVarT2.f5014e.equals("0000")) {
            this.f4901a.e(strB);
        }
        this.f4901a.k(bVarT2.f5013d);
        if (Build.VERSION.SDK_INT == 27) {
            this.f4901a.i(this.f4901a.a().e());
        } else {
            this.f4901a.i(l2.c.a(bVarT2.f5015f));
        }
        this.f4901a.o(W(this.f4901a.m()));
        this.f4902b = true;
        return true;
    }

    private byte[] J(byte[] bArr, int i3) throws SecurityKeyException {
        j2.b bVarA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strW = W(i3);
        if (bArr == null) {
            i.j("SecurityKey", this.f4901a, "rsaEncrypt input data is null");
            throw new SecurityKeyException("invalid input params!", 102);
        }
        if (bArr.length > 245) {
            i.j("SecurityKey", this.f4901a, "rsaEncrypt input data length:" + bArr.length + "max length:245");
            throw new SecurityKeyException("input length > 245", 130);
        }
        if (!G(4)) {
            i.j("SecurityKey", this.f4901a, "security key cipher is not available while rE");
            throw new SecurityKeyException("not available!", 101);
        }
        int i4 = 0;
        do {
            bVarA = this.f4901a.a().a(i3, bArr);
            i4++;
        } while (H(21314, i4, bVarA));
        if (bVarA == null) {
            i.j("SecurityKey", this.f4901a, "rsaEncrypt result is null");
            throw new SecurityKeyException("rsa encrypt error", 1000);
        }
        if (bVarA.f5011b != 0) {
            i.j("SecurityKey", this.f4901a, "rsaEncrypt error:" + bVarA.f5011b);
            throw new SecurityKeyException("rsa encrypt error", bVarA.f5011b);
        }
        byte[] bArr2 = bVarA.f5012c;
        if (bArr2 == null) {
            i.j("SecurityKey", this.f4901a, "rsaEncrypt operateData is null");
            throw new SecurityKeyException("rsa encrypt error", 1000);
        }
        byte[] bArr3 = new ProtocolPackage(strW, bVarA.f5013d, 7, bArr2).getbytes();
        i.f("SecurityKey", this.f4901a, "rsaEncrypt consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bArr3;
    }

    private byte[] K(byte[] bArr, int i3, int i4) throws SecurityKeyException {
        j2.b bVarG;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strW = W(i3);
        int i5 = 0;
        do {
            bVarG = this.f4901a.a().g(i3, bArr);
            i5++;
        } while (H(21312, i5, bVarG));
        if (bVarG == null) {
            i.j("SecurityKey", this.f4901a, "aesEncrypt result is null");
            throw new SecurityKeyException("aes encrypt error", 1000);
        }
        if (bVarG.f5011b != 0) {
            i.j("SecurityKey", this.f4901a, "aesEncrypt error: " + bVarG.f5011b);
            throw new SecurityKeyException("aes encrypt error", bVarG.f5011b);
        }
        byte[] bArr2 = bVarG.f5012c;
        if (bArr2 == null) {
            i.j("SecurityKey", this.f4901a, "aesEncrypt operateData is null ");
            throw new SecurityKeyException("aes encrypt error", 1000);
        }
        byte[] bArr3 = new ProtocolPackage(strW, bVarG.f5013d, i4, bArr2).getbytes();
        i.f("SecurityKey", this.f4901a, "aesEncrypt consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        this.f4901a.h(System.currentTimeMillis());
        return bArr3;
    }

    private int L() {
        int i3 = this.f4901a.f(1) != 0 ? 0 : 1;
        if (this.f4901a.f(2) == 0) {
            i3 |= 2;
        }
        return this.f4901a.f(4) == 0 ? i3 | 4 : i3;
    }

    private static synchronized c M(Context context) {
        if (context == null) {
            i.k("SecurityKey", "getInstance context inputed is null");
            return null;
        }
        if (S(context)) {
            i.k("SecurityKey", "getInstance moduleName inputed is null");
            return null;
        }
        String packageName = S(context) ? null : context.getPackageName();
        if (packageName != null && !TextUtils.isEmpty(packageName)) {
            if (f4899h.containsKey(packageName)) {
                return f4899h.get(packageName);
            }
            c cVar = new c(context);
            f4899h.put(packageName, cVar);
            try {
                cVar.I(true);
                cVar.f4902b = true;
            } catch (Exception e3) {
                i.e("SecurityKey", "PlatformCipher init fail,Error: " + e3.getMessage(), e3);
            }
            return cVar;
        }
        i.k("SecurityKey", "getInstance package name is null or empty");
        return null;
    }

    private boolean N(int i3) {
        if (this.f4901a.m() != 2) {
            return false;
        }
        return i3 < 0 || R(i3);
    }

    private byte[] O(byte[] bArr, int i3) throws SecurityKeyException {
        j2.b bVarC;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strW = W(i3);
        if (bArr == null) {
            i.j("SecurityKey", this.f4901a, "sign input data is null");
            throw new SecurityKeyException("invalid input params!", 102);
        }
        if (bArr.length > 204800) {
            i.j("SecurityKey", this.f4901a, "sign input data length " + bArr.length + " max length:204800");
            throw new SecurityKeyException("input length > 200k", 140);
        }
        if (!G(2)) {
            i.j("SecurityKey", this.f4901a, "security key cipher is not available while s");
            throw new SecurityKeyException("not available!", 101);
        }
        int i4 = 0;
        do {
            bVarC = this.f4901a.a().c(i3, bArr);
            i4++;
        } while (H(21316, i4, bVarC));
        if (bVarC == null) {
            i.j("SecurityKey", this.f4901a, "sign result is null");
            throw new SecurityKeyException("sk sign error:", 1000);
        }
        if (bVarC.f5011b != 0) {
            i.j("SecurityKey", this.f4901a, "sign error: " + bVarC.f5011b);
            throw new SecurityKeyException("sk sign error:", bVarC.f5011b);
        }
        byte[] bArr2 = bVarC.f5012c;
        if (bArr2 == null) {
            i.j("SecurityKey", this.f4901a, "sign operateData is null");
            throw new SecurityKeyException("sk sign error:", 1000);
        }
        byte[] bArr3 = new ProtocolPackage(strW, bVarC.f5013d, 9, bArr2).getbytes();
        i.f("SecurityKey", this.f4901a, "sign consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bArr3;
    }

    private byte[] P(byte[] bArr, int i3, int i4) throws SecurityKeyException {
        j2.b bVarG;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strW = W(i3);
        int i5 = 0;
        do {
            bVarG = this.f4901a.a().g(i3, bArr);
            i5++;
        } while (H(i4, i5, bVarG));
        if (bVarG == null) {
            i.j("SecurityKey", this.f4901a, "signFastImpl result is null");
            throw new SecurityKeyException("aes encrypt error", 1000);
        }
        if (bVarG.f5011b != 0) {
            i.j("SecurityKey", this.f4901a, "signFastImpl error: " + bVarG.f5011b);
            throw new SecurityKeyException("aes encrypt error", bVarG.f5011b);
        }
        byte[] bArr2 = bVarG.f5012c;
        if (bArr2 == null) {
            i.j("SecurityKey", this.f4901a, "signFastImpl operateData is null ");
            throw new SecurityKeyException("aes encrypt error", 1000);
        }
        byte[] bArr3 = new ProtocolPackage(strW, bVarG.f5013d, 17, bArr2).getbytes();
        i.f("SecurityKey", this.f4901a, "signFastImpl consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        this.f4901a.h(System.currentTimeMillis());
        return bArr3;
    }

    private boolean Q() {
        i.f("SecurityKey", this.f4901a, "PlatformCipher internal switch mode of cipher to 3");
        if (this.f4901a.u() != 1) {
            i.j("SecurityKey", this.f4901a, "Current mode is not auto");
            return false;
        }
        this.f4901a.b(3);
        try {
            return I(false);
        } catch (SecurityKeyException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            return false;
        }
    }

    private static boolean R(int i3) {
        return i3 == 162 || i3 == 157 || i3 == 161 || i3 == 163 || i3 == 156 || i3 == 166 || i3 == 167 || i3 == 164 || i3 == 168 || i3 == 169 || i3 == 170 || i3 == 171 || i3 == 172 || i3 == 165;
    }

    private static boolean S(Context context) {
        return context.getPackageName().equals("android");
    }

    private j2.b T() {
        j2.b bVarL;
        int i3 = 0;
        do {
            bVarL = this.f4901a.a().l(3);
            if (bVarL != null && bVarL.f5011b == 0) {
                this.f4904d = bVarL.f5013d;
            }
            i3++;
        } while (H(21310, i3, bVarL));
        return bVarL;
    }

    private synchronized boolean U(int i3) throws SecurityKeyException {
        i.f("SecurityKey", this.f4901a, "Update key " + i3 + ", autoUpdateKey " + this.f4903c);
        throw new SecurityKeyException("update key fail, device is not supported tee for GDPR", 1000);
    }

    private j2.b V() {
        j2.b bVarL;
        int i3 = 0;
        do {
            bVarL = this.f4901a.a().l(2);
            if (bVarL != null && bVarL.f5011b == 0) {
                this.f4905e = bVarL.f5013d;
                if (!TextUtils.isEmpty(bVarL.f5014e)) {
                    this.f4906f = true;
                    this.f4901a.q(bVarL.f5014e);
                }
            }
            i3++;
        } while (H(21310, i3, bVarL));
        return bVarL;
    }

    private String W(int i3) {
        if (i3 == 2) {
            return this.f4901a.r();
        }
        if (A(this.f4904d, 1) >= 2) {
            return "jnisgmain_v2@" + this.f4901a.r();
        }
        return "jnisgmain@" + this.f4901a.r();
    }

    private String X(int i3) {
        if (!TextUtils.isEmpty(this.f4901a.z()) && !TextUtils.isEmpty(this.f4901a.r())) {
            if ((i3 > 0 && i3 <= 7) && !TextUtils.isEmpty(this.f4901a.p())) {
                HashMap map = new HashMap();
                map.put("uid", this.f4901a.z());
                map.put("kt", this.f4901a.r());
                map.put("ktp", String.valueOf(i3));
                map.put("pkh", this.f4901a.p());
                map.put("cc", j2.d.a(this.f4901a.j()));
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    for (Map.Entry entry : map.entrySet()) {
                        stringBuffer.append((String) entry.getKey());
                        stringBuffer.append("=");
                        stringBuffer.append(URLEncoder.encode((String) entry.getValue(), "utf-8"));
                        stringBuffer.append("&");
                    }
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    return stringBuffer.toString();
                } catch (Exception e3) {
                    i.c("SecurityKey", this.f4901a, "Build request data Error: " + e3.getMessage(), e3);
                    return null;
                }
            }
        }
        i.j("SecurityKey", this.f4901a, "Request(update key) params: id=" + this.f4901a.g() + ";packageName=" + this.f4901a.t() + ";keyType=" + i3 + ";appSignHash=" + this.f4901a.p());
        return null;
    }

    private static boolean Y() {
        try {
            Class.forName("com.vivo.services.cipher.SecurityKeyCipher").getDeclaredMethod("exportKey", Integer.TYPE).setAccessible(true);
            return true;
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    private String Z(int i3) {
        int iF = f(i3);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{device kt= " + i3 + ", kv=" + iF);
        stringBuffer.append(", mode= ");
        int iW = w();
        stringBuffer.append(iW);
        if (iW == 3) {
            stringBuffer.append("-Soft");
        } else if (iW == 2) {
            stringBuffer.append("-TEE, env= ");
            stringBuffer.append(ProtocolPackage.kv2EnvStr(f(i3)));
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private static boolean a0() {
        try {
            Class.forName("com.vivo.services.cipher.SecurityKeyCipher");
            return true;
        } catch (Exception e3) {
            i.e("SecurityKey", "PlatformCipher Exception:" + e3.getMessage(), e3);
            return false;
        }
    }

    @Override // i2.a
    public int a(int i3) {
        return A(this.f4904d, i3);
    }

    @Override // l2.a
    public boolean b() throws SecurityKeyException {
        i.b("SecurityKey", this.f4901a, "Update all key");
        return U(7);
    }

    @Override // l2.a
    public byte[] c(byte[] bArr) throws SecurityKeyException {
        try {
            E(bArr);
            return P(g.d(bArr).getBytes(), this.f4901a.m(), 21321);
        } catch (SecurityKeyException e3) {
            if (!N(e3.getErrorCode()) || !Q()) {
                throw e3;
            }
            i.h("SecurityKey", this.f4901a, "Aes Encrypt Auto Switch to Soft Mode");
            E(bArr);
            return P(g.d(bArr).getBytes(), this.f4901a.m(), 21321);
        }
    }

    @Override // i2.a
    public boolean d() {
        return this.f4906f;
    }

    @Override // l2.a
    public byte[] e(int i3) throws SecurityKeyException {
        j2.b bVarH;
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArr = null;
        if (!Y()) {
            i.j("SecurityKey", this.f4901a, "exportKey interface not exist");
            return null;
        }
        if (!G(1)) {
            i.j("SecurityKey", this.f4901a, "security key cipher is not available while e");
            throw new SecurityKeyException("not available!", 101);
        }
        if (this.f4901a.m() != 2) {
            i.j("SecurityKey", this.f4901a, "Not support key exported");
            throw new SecurityKeyException("not available!", 101);
        }
        int i4 = 0;
        do {
            bVarH = this.f4901a.a().h(this.f4901a.m(), i3);
            i4++;
        } while (H(21319, i4, bVarH));
        if (bVarH == null) {
            i.j("SecurityKey", this.f4901a, "exportKey result is null");
            throw new SecurityKeyException("security storage read error", 1000);
        }
        if (bVarH.f5011b == 0) {
            bArr = bVarH.f5012c;
            if (bArr == null) {
                i.j("SecurityKey", this.f4901a, "exportKey operateData is null");
                throw new SecurityKeyException("security storage read error", 1000);
            }
        } else {
            i.j("SecurityKey", this.f4901a, "exportKey error: " + bVarH.f5011b);
            int i5 = bVarH.f5011b;
            if (i5 != -16 && i5 != -26) {
                throw new SecurityKeyException("security storage read error", bVarH.f5011b);
            }
        }
        i.b("SecurityKey", this.f4901a, "exportKey consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bArr;
    }

    @Override // l2.a
    public int f(int i3) {
        try {
            if (this.f4901a.m() == 2 && this.f4901a.u() == 1 && !G(i3)) {
                Q();
            }
        } catch (SecurityKeyException e3) {
            i.c("SecurityKey", this.f4901a, "isKeyReady Fail. Error: " + e3.getMessage(), e3);
            Q();
        }
        return this.f4901a.f(i3);
    }

    @Override // l2.a
    public boolean g(byte[] bArr, byte[] bArr2) throws SecurityKeyException {
        j2.b bVarI;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bArr == null || bArr2 == null) {
            i.j("SecurityKey", this.f4901a, "signatureVerify input data is null");
            throw new SecurityKeyException("invalid input params!", 102);
        }
        if (bArr.length > 204800) {
            i.j("SecurityKey", this.f4901a, "signatureVerify input data length " + bArr.length + " max length:204800");
            throw new SecurityKeyException("input length > 200k", 141);
        }
        if (!G(4)) {
            i.j("SecurityKey", this.f4901a, "security key cipher is not available while v");
            throw new SecurityKeyException("not available!", 101);
        }
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr2);
        if (protocolPackageBuildProtocolPackage.getData().length != 256) {
            i.j("SecurityKey", this.f4901a, "signatureVerify length: " + protocolPackageBuildProtocolPackage.getData().length + " must equals 256");
            throw new SecurityKeyException("sign length != 256", 142);
        }
        C(protocolPackageBuildProtocolPackage, 4, "signatureVerify");
        if (10 != protocolPackageBuildProtocolPackage.getType() && 9 != protocolPackageBuildProtocolPackage.getType()) {
            i.j("SecurityKey", this.f4901a, "signatureVerify decrypt type " + protocolPackageBuildProtocolPackage.getType() + "is not supported");
            throw new SecurityKeyException("encrypt type of data is not supported", 154);
        }
        byte[] bArr3 = new byte[bArr.length + protocolPackageBuildProtocolPackage.getData().length];
        int i3 = 0;
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(protocolPackageBuildProtocolPackage.getData(), 0, bArr3, bArr.length, protocolPackageBuildProtocolPackage.getData().length);
        do {
            bVarI = this.f4901a.a().i(protocolPackageBuildProtocolPackage.getCipherMode(), protocolPackageBuildProtocolPackage.getKeyVersion(), bArr3);
            i3++;
        } while (H(21317, i3, bVarI));
        if (bVarI == null) {
            i.j("SecurityKey", this.f4901a, "signatureVerify result is null");
            throw new SecurityKeyException("unknown error!", 1000);
        }
        if (bVarI.f5011b != 0) {
            D(bVarI, protocolPackageBuildProtocolPackage, 4, "signatureVerify");
            throw new SecurityKeyException("sign verify error ", bVarI.f5011b);
        }
        i.f("SecurityKey", this.f4901a, "signatureVerify consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return true;
    }

    @Override // l2.a
    public boolean h(int i3) throws SecurityKeyException {
        i.f("SecurityKey", this.f4901a, "switch mode of cipher to ".concat(String.valueOf(i3)));
        this.f4901a.n(i3);
        if (i3 == 1) {
            this.f4901a.b(d() ? 2 : 3);
        } else {
            this.f4901a.b(i3);
        }
        return I(false);
    }

    @Override // i2.a
    public boolean i(String str) throws SecurityKeyException {
        if (!TextUtils.isEmpty(str)) {
            throw new SecurityKeyException("update key fail, device is not supported tee for GDPR", 1000);
        }
        i.k("SecurityKey", "updateKeyFromBusinessServer url4GET is empty");
        throw new SecurityKeyException("Invalied url", SecurityKeyException.SK_ERROR_INPUT_URL_INVALIED);
    }

    @Override // l2.a
    public byte[] j(byte[] bArr, String str) throws SecurityKeyException, JSONException {
        E(bArr);
        int iM = this.f4901a.m();
        int i3 = 5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("cipherMode")) {
                iM = jSONObject.getInt("cipherMode");
            }
            if (jSONObject.has("encryptionType")) {
                i3 = jSONObject.getInt("encryptionType");
            }
        } catch (JSONException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
        try {
            return K(bArr, iM, i3);
        } catch (SecurityKeyException e4) {
            if (!N(e4.getErrorCode()) || !Q()) {
                throw e4;
            }
            i.h("SecurityKey", this.f4901a, "Aes Encrypt Auto Switch to Soft Mode");
            return K(bArr, 3, i3);
        }
    }

    @Override // l2.a
    public boolean k(String str) throws SecurityKeyException {
        j2.b bVarD;
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        byte[] bArrB = l2.c.b(str);
        if (bArrB == null || bArrB.length < 32) {
            i.j("SecurityKey", this.f4901a, "storeKey: input keyData error");
            throw new SecurityKeyException("update key fail", 103);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        do {
            bVarD = this.f4901a.a().d(2, this.f4907g, bArrB);
            i3++;
        } while (H(21311, i3, bVarD));
        if (bVarD == null) {
            i.j("SecurityKey", this.f4901a, "updateKeyV2 return null");
            throw new SecurityKeyException("update key fail", 1000);
        }
        if (bVarD.f5011b == 0) {
            I(true);
            i.f("SecurityKey", this.f4901a, "Save Key consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return true;
        }
        i.j("SecurityKey", this.f4901a, "updateKeyV2 error: " + bVarD.f5011b);
        this.f4901a.v();
        throw new SecurityKeyException("update key fail", bVarD.f5011b);
    }

    @Override // l2.a
    public String l() {
        return this.f4901a.t();
    }

    @Override // l2.a
    public byte[] m(byte[] bArr, String str) throws SecurityKeyException {
        int iM = this.f4901a.m();
        try {
            iM = new JSONObject(str).getInt("cipherMode");
        } catch (JSONException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
        try {
            return J(bArr, iM);
        } catch (SecurityKeyException e4) {
            if (!N(e4.getErrorCode()) || !Q()) {
                throw e4;
            }
            i.h("SecurityKey", this.f4901a, "rsa Encrypt Auto Switch to Soft Mode");
            return J(bArr, 3);
        }
    }

    @Override // l2.a
    public byte[] n(byte[] bArr) throws SecurityKeyException {
        j2.b bVarF;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bArr == null) {
            i.j("SecurityKey", this.f4901a, "rsaDecrypt input data is null");
            throw new SecurityKeyException("invalid input params!", 102);
        }
        if (!G(2)) {
            i.j("SecurityKey", this.f4901a, "security key cipher is not available rD");
            throw new SecurityKeyException("not available!", 101);
        }
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr);
        if (protocolPackageBuildProtocolPackage.getData().length > 256) {
            i.j("SecurityKey", this.f4901a, "rsaDecrypt input data length:" + protocolPackageBuildProtocolPackage.getData().length + " max length:256");
            throw new SecurityKeyException("input length > 256", 131);
        }
        C(protocolPackageBuildProtocolPackage, 2, "rsaDecrypt");
        if (6 != protocolPackageBuildProtocolPackage.getType() && 7 != protocolPackageBuildProtocolPackage.getType()) {
            i.j("SecurityKey", this.f4901a, "rsaDecrypt decrypt type " + protocolPackageBuildProtocolPackage.getType() + " is not supported");
            throw new SecurityKeyException("encrypt type of data is not supported", 154);
        }
        int i3 = 0;
        do {
            bVarF = this.f4901a.a().f(protocolPackageBuildProtocolPackage.getCipherMode(), protocolPackageBuildProtocolPackage.getKeyVersion(), protocolPackageBuildProtocolPackage.getData());
            i3++;
        } while (H(21315, i3, bVarF));
        if (bVarF == null) {
            i.j("SecurityKey", this.f4901a, "rsaDecrypt result is null");
            throw new SecurityKeyException("rsa decrypt error", 1000);
        }
        if (bVarF.f5011b != 0) {
            D(bVarF, protocolPackageBuildProtocolPackage, 2, "rsaDecrypt");
            throw new SecurityKeyException("rsa decrypt error", bVarF.f5011b);
        }
        byte[] bArr2 = bVarF.f5012c;
        if (bArr2 == null) {
            i.j("SecurityKey", this.f4901a, "rsaDecrypt operateData is null");
            throw new SecurityKeyException("rsa decrypt error", 1000);
        }
        i.f("SecurityKey", this.f4901a, "rsaDecrypt consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bArr2;
    }

    @Override // l2.a
    public byte[] o(byte[] bArr) throws SecurityKeyException {
        j2.b bVarK;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bArr == null) {
            i.j("SecurityKey", this.f4901a, "aesDecrypt input data is null");
            throw new SecurityKeyException("invalid input params!", 102);
        }
        if (!G(1)) {
            i.j("SecurityKey", this.f4901a, "security key cipher is not available while aD");
            throw new SecurityKeyException("not available!", 101);
        }
        if (jCurrentTimeMillis > this.f4901a.y() && jCurrentTimeMillis - this.f4901a.y() < 20) {
            try {
                Thread.sleep(20 - (jCurrentTimeMillis - this.f4901a.y()));
            } catch (InterruptedException e3) {
                i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
            }
        }
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArr);
        if (protocolPackageBuildProtocolPackage.getData().length > 204816) {
            i.j("SecurityKey", this.f4901a, "aesDecrypt input data length " + protocolPackageBuildProtocolPackage.getData().length + " max length:204816");
            throw new SecurityKeyException("input length > 200k + 16", 121);
        }
        C(protocolPackageBuildProtocolPackage, 1, "aesDecrypt");
        int i3 = 0;
        if (5 != protocolPackageBuildProtocolPackage.getType()) {
            i.j("SecurityKey", this.f4901a, "aesDecrypt decrypt type " + protocolPackageBuildProtocolPackage.getType() + " is not supported");
            throw new SecurityKeyException("encrypt type of data is not supported", 154);
        }
        do {
            bVarK = this.f4901a.a().k(protocolPackageBuildProtocolPackage.getCipherMode(), protocolPackageBuildProtocolPackage.getKeyVersion(), protocolPackageBuildProtocolPackage.getData());
            i3++;
        } while (H(21313, i3, bVarK));
        if (bVarK == null) {
            i.j("SecurityKey", this.f4901a, "aesDecrypt result is null");
            throw new SecurityKeyException("aes decrypt error", 1000);
        }
        if (bVarK.f5011b != 0) {
            D(bVarK, protocolPackageBuildProtocolPackage, 1, "aesDecrypt");
            throw new SecurityKeyException("aes decrypt error", bVarK.f5011b);
        }
        byte[] bArr2 = bVarK.f5012c;
        if (bArr2 == null) {
            i.j("SecurityKey", this.f4901a, "aesDecrypt operateData is null");
            throw new SecurityKeyException("aes decrypt error", 1000);
        }
        i.f("SecurityKey", this.f4901a, "aesDecrypt consume time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        this.f4901a.h(System.currentTimeMillis());
        return bArr2;
    }

    @Override // l2.a
    public boolean p(byte[] bArr, byte[] bArr2) throws SecurityKeyException {
        byte[] bArrP;
        try {
            E(bArr);
            bArrP = P(g.d(bArr).getBytes(), this.f4901a.m(), 21322);
        } catch (SecurityKeyException e3) {
            if (!N(e3.getErrorCode()) || !Q()) {
                throw e3;
            }
            i.h("SecurityKey", this.f4901a, "Aes Encrypt Auto Switch to Soft Mode");
            E(bArr);
            bArrP = P(g.d(bArr).getBytes(), this.f4901a.m(), 21322);
        }
        ProtocolPackage protocolPackageBuildProtocolPackage = ProtocolPackage.buildProtocolPackage(bArrP);
        return Arrays.equals(protocolPackageBuildProtocolPackage.getCipherData(), ProtocolPackage.buildProtocolPackage(bArr2).getCipherData());
    }

    @Override // l2.a
    public byte[] q(byte[] bArr) throws SecurityKeyException {
        try {
            return O(bArr, this.f4901a.m());
        } catch (SecurityKeyException e3) {
            if (!N(e3.getErrorCode()) || !Q()) {
                throw e3;
            }
            i.h("SecurityKey", this.f4901a, "Sign Auto Switch to Soft Mode");
            return O(bArr, this.f4901a.m());
        }
    }

    @Override // l2.a
    public byte[] r(byte[] bArr, String str) throws SecurityKeyException {
        int iM = this.f4901a.m();
        try {
            iM = new JSONObject(str).getInt("cipherMode");
        } catch (JSONException e3) {
            i.e("SecurityKey", "Error: " + e3.getMessage(), e3);
        }
        try {
            return O(bArr, iM);
        } catch (SecurityKeyException e4) {
            if (!N(e4.getErrorCode()) || !Q()) {
                throw e4;
            }
            i.h("SecurityKey", this.f4901a, "Sign Auto Switch to Soft Mode");
            return O(bArr, 3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // l2.a
    public byte[] s(int i3) throws SecurityKeyException {
        int i4 = 2;
        if (i3 == 5) {
            i4 = 1;
        } else if (i3 != 6 && i3 != 10) {
            if (i3 == 15 || i3 == 17) {
                i4 = 1;
            } else {
                i4 = 0;
            }
        }
        return new ProtocolPackage(this.f4901a.t(), f(i4), i3, null).getHeaderbytes();
    }

    @Override // l2.a
    public boolean t() {
        return this.f4903c;
    }

    @Override // l2.a
    public String u() {
        return X(this.f4907g);
    }

    @Override // l2.a
    public byte[] v(byte[] bArr) throws SecurityKeyException {
        try {
            E(bArr);
            return K(bArr, this.f4901a.m(), 5);
        } catch (SecurityKeyException e3) {
            if (!N(e3.getErrorCode()) || !Q()) {
                throw e3;
            }
            i.h("SecurityKey", this.f4901a, "Aes Encrypt Auto Switch to Soft Mode");
            E(bArr);
            return K(bArr, this.f4901a.m(), 5);
        }
    }

    @Override // l2.a
    public int w() {
        try {
            if (this.f4901a.m() == 2 && this.f4901a.u() == 1 && !G(1) && !G(2) && !G(4)) {
                Q();
            }
        } catch (SecurityKeyException e3) {
            i.c("SecurityKey", this.f4901a, "isKeyReady Fail. Error: " + e3.getMessage(), e3);
            Q();
        }
        return this.f4901a.m();
    }

    @Override // l2.a
    public byte[] x(byte[] bArr) throws SecurityKeyException {
        try {
            return J(bArr, this.f4901a.m());
        } catch (SecurityKeyException e3) {
            if (!N(e3.getErrorCode()) || !Q()) {
                throw e3;
            }
            i.h("SecurityKey", this.f4901a, "rsa Encrypt Auto Switch to Soft Mode");
            return J(bArr, this.f4901a.m());
        }
    }

    @Override // i2.a
    public int y(int i3) {
        return A(this.f4905e, i3);
    }

    @Override // l2.a
    public boolean z(boolean z2) {
        i.f("SecurityKey", this.f4901a, "setAutoUpdateKey  ".concat(String.valueOf(z2)));
        this.f4903c = z2;
        return z2;
    }
}
