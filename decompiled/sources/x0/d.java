package x0;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: compiled from: CircularRevealWidget.java */
/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f6429b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f6430a = new e();

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f3, e eVar, e eVar2) {
            this.f6430a.a(e1.a.c(eVar.f6433a, eVar2.f6433a, f3), e1.a.c(eVar.f6434b, eVar2.f6434b, f3), e1.a.c(eVar.f6435c, eVar2.f6435c, f3));
            return this.f6430a;
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class c extends Property<d, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<d, e> f6431a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* JADX INFO: renamed from: x0.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class C0098d extends Property<d, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f6432a = new C0098d("circularRevealScrimColor");

        private C0098d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f6434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6435c;

        public void a(float f3, float f4, float f5) {
            this.f6433a = f3;
            this.f6434b = f4;
            this.f6435c = f5;
        }

        private e() {
        }

        public e(float f3, float f4, float f5) {
            this.f6433a = f3;
            this.f6434b = f4;
            this.f6435c = f5;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i3);

    void setRevealInfo(e eVar);
}
