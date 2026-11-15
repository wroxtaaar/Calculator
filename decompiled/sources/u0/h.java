package u0;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MotionSpec.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l.g<String, i> f6270a = new l.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l.g<String, PropertyValuesHolder[]> f6271b = new l.g<>();

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.h(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.i(objectAnimator.getPropertyName(), i.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public static h b(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return c(context, resourceId);
    }

    public static h c(Context context, int i3) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i3);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return d(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return d(arrayList);
        } catch (Exception e3) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i3), e3);
            return null;
        }
    }

    private static h d(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(hVar, list.get(i3));
        }
        return hVar;
    }

    public i e(String str) {
        if (g(str)) {
            return this.f6270a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f6270a.equals(((h) obj).f6270a);
        }
        return false;
    }

    public long f() {
        int size = this.f6270a.size();
        long jMax = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i iVarM = this.f6270a.m(i3);
            jMax = Math.max(jMax, iVarM.c() + iVarM.d());
        }
        return jMax;
    }

    public boolean g(String str) {
        return this.f6270a.get(str) != null;
    }

    public void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f6271b.put(str, propertyValuesHolderArr);
    }

    public int hashCode() {
        return this.f6270a.hashCode();
    }

    public void i(String str, i iVar) {
        this.f6270a.put(str, iVar);
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f6270a + "}\n";
    }
}
