package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f28a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayDeque<b> f29b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements e, androidx.activity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f30a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f31b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private androidx.activity.a f32c;

        LifecycleOnBackPressedCancellable(d dVar, b bVar) {
            this.f30a = dVar;
            this.f31b = bVar;
            dVar.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f30a.c(this);
            this.f31b.e(this);
            androidx.activity.a aVar = this.f32c;
            if (aVar != null) {
                aVar.cancel();
                this.f32c = null;
            }
        }

        @Override // androidx.lifecycle.e
        public void d(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                this.f32c = OnBackPressedDispatcher.this.b(this.f31b);
                return;
            }
            if (aVar != d.a.ON_STOP) {
                if (aVar == d.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar2 = this.f32c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }

    private class a implements androidx.activity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f34a;

        a(b bVar) {
            this.f34a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f29b.remove(this.f34a);
            this.f34a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f28a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(g gVar, b bVar) {
        d dVarB = gVar.b();
        if (dVarB.b() == d.b.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(dVarB, bVar));
    }

    androidx.activity.a b(b bVar) {
        this.f29b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> itDescendingIterator = this.f29b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            b next = itDescendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f28a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
