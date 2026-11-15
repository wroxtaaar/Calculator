package u0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TimeInterpolator f6274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6276e;

    public i(long j3, long j4) {
        this.f6272a = 0L;
        this.f6273b = 300L;
        this.f6274c = null;
        this.f6275d = 0;
        this.f6276e = 1;
        this.f6272a = j3;
        this.f6273b = j4;
    }

    static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f6275d = valueAnimator.getRepeatCount();
        iVar.f6276e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f6258b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f6259c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f6260d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f6272a;
    }

    public long d() {
        return this.f6273b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f6274c;
        return timeInterpolator != null ? timeInterpolator : a.f6258b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f6275d;
    }

    public int h() {
        return this.f6276e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j3, long j4, TimeInterpolator timeInterpolator) {
        this.f6272a = 0L;
        this.f6273b = 300L;
        this.f6274c = null;
        this.f6275d = 0;
        this.f6276e = 1;
        this.f6272a = j3;
        this.f6273b = j4;
        this.f6274c = timeInterpolator;
    }
}
