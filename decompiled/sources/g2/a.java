package g2;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static ObjectAnimator a(View view, float f3, float f4, long j3, Interpolator interpolator) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", f3, f4);
        objectAnimatorOfFloat.setDuration(j3);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        return objectAnimatorOfFloat;
    }

    public static Interpolator b(float f3, float f4, float f5, float f6) {
        return g0.b.a(f3, f4, f5, f6);
    }

    public static ObjectAnimator c(View view, float f3, float f4, long j3, Interpolator interpolator) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", f3, f4);
        objectAnimatorOfFloat.setDuration(j3);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        return objectAnimatorOfFloat;
    }

    public static ObjectAnimator d(View view, float f3, float f4, long j3, Interpolator interpolator) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleY", f3, f4);
        objectAnimatorOfFloat.setDuration(j3);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        return objectAnimatorOfFloat;
    }
}
