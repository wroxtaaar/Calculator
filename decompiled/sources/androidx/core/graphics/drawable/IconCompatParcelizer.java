package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1143a = aVar.p(iconCompat.f1143a, 1);
        iconCompat.f1145c = aVar.j(iconCompat.f1145c, 2);
        iconCompat.f1146d = aVar.r(iconCompat.f1146d, 3);
        iconCompat.f1147e = aVar.p(iconCompat.f1147e, 4);
        iconCompat.f1148f = aVar.p(iconCompat.f1148f, 5);
        iconCompat.f1149g = (ColorStateList) aVar.r(iconCompat.f1149g, 6);
        iconCompat.f1151i = aVar.t(iconCompat.f1151i, 7);
        iconCompat.f1152j = aVar.t(iconCompat.f1152j, 8);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.d(aVar.f());
        int i3 = iconCompat.f1143a;
        if (-1 != i3) {
            aVar.F(i3, 1);
        }
        byte[] bArr = iconCompat.f1145c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1146d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i4 = iconCompat.f1147e;
        if (i4 != 0) {
            aVar.F(i4, 4);
        }
        int i5 = iconCompat.f1148f;
        if (i5 != 0) {
            aVar.F(i5, 5);
        }
        ColorStateList colorStateList = iconCompat.f1149g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f1151i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f1152j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
