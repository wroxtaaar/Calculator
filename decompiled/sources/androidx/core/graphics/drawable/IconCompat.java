package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f1142k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f1144b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f1152j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1143a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f1145c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f1146d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1147e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1148f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f1149g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f1150h = f1142k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1151i = null;

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (NoSuchMethodException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        } catch (InvocationTargetException e5) {
            Log.e("IconCompat", "Unable to get icon resource", e5);
            return 0;
        }
    }

    private static String e(int i3) {
        switch (i3) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int a() {
        int i3 = this.f1143a;
        if (i3 == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f1144b);
        }
        if (i3 == 2) {
            return this.f1147e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public void c() {
        this.f1150h = PorterDuff.Mode.valueOf(this.f1151i);
        switch (this.f1143a) {
            case -1:
                Parcelable parcelable = this.f1146d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f1144b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f1146d;
                if (parcelable2 != null) {
                    this.f1144b = parcelable2;
                    return;
                }
                byte[] bArr = this.f1145c;
                this.f1144b = bArr;
                this.f1143a = 3;
                this.f1147e = 0;
                this.f1148f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1145c, Charset.forName("UTF-16"));
                this.f1144b = str;
                if (this.f1143a == 2 && this.f1152j == null) {
                    this.f1152j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1144b = this.f1145c;
                return;
        }
    }

    public void d(boolean z2) {
        this.f1151i = this.f1150h.name();
        switch (this.f1143a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f1146d = (Parcelable) this.f1144b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z2) {
                    this.f1146d = (Parcelable) this.f1144b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f1144b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f1145c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f1145c = ((String) this.f1144b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1145c = (byte[]) this.f1144b;
                return;
            case 4:
            case 6:
                this.f1145c = this.f1144b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public String toString() {
        if (this.f1143a == -1) {
            return String.valueOf(this.f1144b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(e(this.f1143a));
        switch (this.f1143a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1144b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1144b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1152j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(a())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1147e);
                if (this.f1148f != 0) {
                    sb.append(" off=");
                    sb.append(this.f1148f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1144b);
                break;
        }
        if (this.f1149g != null) {
            sb.append(" tint=");
            sb.append(this.f1149g);
        }
        if (this.f1150h != f1142k) {
            sb.append(" mode=");
            sb.append(this.f1150h);
        }
        sb.append(")");
        return sb.toString();
    }
}
