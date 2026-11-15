package h1;

import android.graphics.Typeface;

/* JADX INFO: compiled from: CancelableFontCallback.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f4844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0064a f4845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4846c;

    /* JADX INFO: renamed from: h1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancelableFontCallback.java */
    public interface InterfaceC0064a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0064a interfaceC0064a, Typeface typeface) {
        this.f4844a = typeface;
        this.f4845b = interfaceC0064a;
    }

    private void d(Typeface typeface) {
        if (this.f4846c) {
            return;
        }
        this.f4845b.a(typeface);
    }

    @Override // h1.f
    public void a(int i3) {
        d(this.f4844a);
    }

    @Override // h1.f
    public void b(Typeface typeface, boolean z2) {
        d(typeface);
    }

    public void c() {
        this.f4846c = true;
    }
}
