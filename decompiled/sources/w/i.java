package w;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: TypefaceCompatApi29Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends j {
    @Override // w.j
    public Typeface b(Context context, v.c.b bVar, Resources resources, int i3) {
        try {
            v.c.C0092c[] c0092cArrA = bVar.a();
            int length = c0092cArrA.length;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    break;
                }
                v.c.C0092c c0092c = c0092cArrA[i4];
                try {
                    Font.Builder weight = new Font.Builder(resources, c0092c.b()).setWeight(c0092c.e());
                    if (!c0092c.f()) {
                        i5 = 0;
                    }
                    Font fontBuild = weight.setSlant(i5).setTtcIndex(c0092c.c()).setFontVariationSettings(c0092c.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
                i4++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i3 & 1) != 0 ? 700 : 400, (i3 & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // w.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, b0.f.b[] bVarArr, int i3) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = bVarArr.length;
            FontFamily.Builder builder = null;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i3 & 1) != 0 ? 700 : 400, (i3 & 2) != 0 ? 1 : 0)).build();
                }
                b0.f.b bVar = bVarArr[i4];
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(bVar.d(), "r", cancellationSignal);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                        i4++;
                    } else {
                        try {
                            Font.Builder weight = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(bVar.e());
                            if (!bVar.f()) {
                                i5 = 0;
                            }
                            Font fontBuild = weight.setSlant(i5).setTtcIndex(bVar.c()).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(fontBuild);
                            } else {
                                builder.addFont(fontBuild);
                            }
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException unused) {
                }
                i4++;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // w.j
    protected Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // w.j
    public Typeface e(Context context, Resources resources, int i3, String str, int i4) {
        try {
            Font fontBuild = new Font.Builder(resources, i3).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // w.j
    protected b0.f.b h(b0.f.b[] bVarArr, int i3) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
