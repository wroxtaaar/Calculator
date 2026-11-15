package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f3116a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f3117b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ValueAnimator f3118c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f3119d = new a();

    /* JADX INFO: compiled from: StateListAnimator.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i iVar = i.this;
            if (iVar.f3118c == animator) {
                iVar.f3118c = null;
            }
        }
    }

    /* JADX INFO: compiled from: StateListAnimator.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f3121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f3122b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f3121a = iArr;
            this.f3122b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f3118c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f3118c = null;
        }
    }

    private void e(b bVar) {
        ValueAnimator valueAnimator = bVar.f3122b;
        this.f3118c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f3119d);
        this.f3116a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f3118c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f3118c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f3116a.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f3116a.get(i3);
            if (StateSet.stateSetMatches(bVar.f3121a, iArr)) {
                break;
            } else {
                i3++;
            }
        }
        b bVar2 = this.f3117b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f3117b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}
