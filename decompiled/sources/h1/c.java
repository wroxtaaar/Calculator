package h1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.w0;

/* JADX INFO: compiled from: MaterialResources.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i3) {
        int color;
        int resourceId;
        ColorStateList colorStateListC;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (colorStateListC = c.a.c(context, resourceId)) == null) {
            return (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i3, -1)) == -1) ? typedArray.getColorStateList(i3) : ColorStateList.valueOf(color);
        }
        return colorStateListC;
    }

    public static ColorStateList b(Context context, w0 w0Var, int i3) {
        int iB;
        int iN;
        ColorStateList colorStateListC;
        if (!w0Var.s(i3) || (iN = w0Var.n(i3, 0)) == 0 || (colorStateListC = c.a.c(context, iN)) == null) {
            return (Build.VERSION.SDK_INT > 15 || (iB = w0Var.b(i3, -1)) == -1) ? w0Var.c(i3) : ColorStateList.valueOf(iB);
        }
        return colorStateListC;
    }

    public static int c(Context context, TypedArray typedArray, int i3, int i4) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i3, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i3, i4);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i4);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        Drawable drawableD;
        return (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0 || (drawableD = c.a.d(context, resourceId)) == null) ? typedArray.getDrawable(i3) : drawableD;
    }

    static int e(TypedArray typedArray, int i3, int i4) {
        return typedArray.hasValue(i3) ? i3 : i4;
    }

    public static d f(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
