package h1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: compiled from: TypefaceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static Typeface a(Context context, Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        int i3;
        if (Build.VERSION.SDK_INT < 31 || (i3 = configuration.fontWeightAdjustment) == Integer.MAX_VALUE || i3 == 0) {
            return null;
        }
        return Typeface.create(typeface, z.a.b(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }
}
