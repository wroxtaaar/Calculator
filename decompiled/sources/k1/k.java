package k1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: ShapeAppearanceModel.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final k1.c f5127m = new i(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f5128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f5129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f5130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f5131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    k1.c f5132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    k1.c f5133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    k1.c f5134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    k1.c f5135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    f f5136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    f f5137j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    f f5138k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    f f5139l;

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public interface c {
        k1.c a(k1.c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i3, int i4) {
        return c(context, i3, i4, 0);
    }

    private static b c(Context context, int i3, int i4, int i5) {
        return d(context, i3, i4, new k1.a(i5));
    }

    private static b d(Context context, int i3, int i4, k1.c cVar) {
        if (i4 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i3);
            i3 = i4;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, t0.k.ShapeAppearance);
        try {
            int i5 = typedArrayObtainStyledAttributes.getInt(t0.k.ShapeAppearance_cornerFamily, 0);
            int i6 = typedArrayObtainStyledAttributes.getInt(t0.k.ShapeAppearance_cornerFamilyTopLeft, i5);
            int i7 = typedArrayObtainStyledAttributes.getInt(t0.k.ShapeAppearance_cornerFamilyTopRight, i5);
            int i8 = typedArrayObtainStyledAttributes.getInt(t0.k.ShapeAppearance_cornerFamilyBottomRight, i5);
            int i9 = typedArrayObtainStyledAttributes.getInt(t0.k.ShapeAppearance_cornerFamilyBottomLeft, i5);
            k1.c cVarM = m(typedArrayObtainStyledAttributes, t0.k.ShapeAppearance_cornerSize, cVar);
            k1.c cVarM2 = m(typedArrayObtainStyledAttributes, t0.k.ShapeAppearance_cornerSizeTopLeft, cVarM);
            k1.c cVarM3 = m(typedArrayObtainStyledAttributes, t0.k.ShapeAppearance_cornerSizeTopRight, cVarM);
            k1.c cVarM4 = m(typedArrayObtainStyledAttributes, t0.k.ShapeAppearance_cornerSizeBottomRight, cVarM);
            return new b().y(i6, cVarM2).C(i7, cVarM3).u(i8, cVarM4).q(i9, m(typedArrayObtainStyledAttributes, t0.k.ShapeAppearance_cornerSizeBottomLeft, cVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i3, int i4) {
        return f(context, attributeSet, i3, i4, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i3, int i4, int i5) {
        return g(context, attributeSet, i3, i4, new k1.a(i5));
    }

    public static b g(Context context, AttributeSet attributeSet, int i3, int i4, k1.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t0.k.MaterialShape, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(t0.k.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static k1.c m(TypedArray typedArray, int i3, k1.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i4 = typedValuePeekValue.type;
        if (i4 == 5) {
            return new k1.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i4 == 6 ? new i(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f5138k;
    }

    public d i() {
        return this.f5131d;
    }

    public k1.c j() {
        return this.f5135h;
    }

    public d k() {
        return this.f5130c;
    }

    public k1.c l() {
        return this.f5134g;
    }

    public f n() {
        return this.f5139l;
    }

    public f o() {
        return this.f5137j;
    }

    public f p() {
        return this.f5136i;
    }

    public d q() {
        return this.f5128a;
    }

    public k1.c r() {
        return this.f5132e;
    }

    public d s() {
        return this.f5129b;
    }

    public k1.c t() {
        return this.f5133f;
    }

    public boolean u(RectF rectF) {
        boolean z2 = this.f5139l.getClass().equals(f.class) && this.f5137j.getClass().equals(f.class) && this.f5136i.getClass().equals(f.class) && this.f5138k.getClass().equals(f.class);
        float fA = this.f5132e.a(rectF);
        return z2 && ((this.f5133f.a(rectF) > fA ? 1 : (this.f5133f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f5135h.a(rectF) > fA ? 1 : (this.f5135h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f5134g.a(rectF) > fA ? 1 : (this.f5134g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f5129b instanceof j) && (this.f5128a instanceof j) && (this.f5130c instanceof j) && (this.f5131d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f3) {
        return v().o(f3).m();
    }

    public k x(k1.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    private k(b bVar) {
        this.f5128a = bVar.f5140a;
        this.f5129b = bVar.f5141b;
        this.f5130c = bVar.f5142c;
        this.f5131d = bVar.f5143d;
        this.f5132e = bVar.f5144e;
        this.f5133f = bVar.f5145f;
        this.f5134g = bVar.f5146g;
        this.f5135h = bVar.f5147h;
        this.f5136i = bVar.f5148i;
        this.f5137j = bVar.f5149j;
        this.f5138k = bVar.f5150k;
        this.f5139l = bVar.f5151l;
    }

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f5140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f5141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f5142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f5143d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private k1.c f5144e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private k1.c f5145f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private k1.c f5146g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private k1.c f5147h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private f f5148i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private f f5149j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private f f5150k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private f f5151l;

        public b() {
            this.f5140a = h.b();
            this.f5141b = h.b();
            this.f5142c = h.b();
            this.f5143d = h.b();
            this.f5144e = new k1.a(0.0f);
            this.f5145f = new k1.a(0.0f);
            this.f5146g = new k1.a(0.0f);
            this.f5147h = new k1.a(0.0f);
            this.f5148i = h.c();
            this.f5149j = h.c();
            this.f5150k = h.c();
            this.f5151l = h.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f5126a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f5074a;
            }
            return -1.0f;
        }

        public b A(float f3) {
            this.f5144e = new k1.a(f3);
            return this;
        }

        public b B(k1.c cVar) {
            this.f5144e = cVar;
            return this;
        }

        public b C(int i3, k1.c cVar) {
            return D(h.a(i3)).F(cVar);
        }

        public b D(d dVar) {
            this.f5141b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                E(fN);
            }
            return this;
        }

        public b E(float f3) {
            this.f5145f = new k1.a(f3);
            return this;
        }

        public b F(k1.c cVar) {
            this.f5145f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f3) {
            return A(f3).E(f3).w(f3).s(f3);
        }

        public b p(k1.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i3, k1.c cVar) {
            return r(h.a(i3)).t(cVar);
        }

        public b r(d dVar) {
            this.f5143d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                s(fN);
            }
            return this;
        }

        public b s(float f3) {
            this.f5147h = new k1.a(f3);
            return this;
        }

        public b t(k1.c cVar) {
            this.f5147h = cVar;
            return this;
        }

        public b u(int i3, k1.c cVar) {
            return v(h.a(i3)).x(cVar);
        }

        public b v(d dVar) {
            this.f5142c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        public b w(float f3) {
            this.f5146g = new k1.a(f3);
            return this;
        }

        public b x(k1.c cVar) {
            this.f5146g = cVar;
            return this;
        }

        public b y(int i3, k1.c cVar) {
            return z(h.a(i3)).B(cVar);
        }

        public b z(d dVar) {
            this.f5140a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                A(fN);
            }
            return this;
        }

        public b(k kVar) {
            this.f5140a = h.b();
            this.f5141b = h.b();
            this.f5142c = h.b();
            this.f5143d = h.b();
            this.f5144e = new k1.a(0.0f);
            this.f5145f = new k1.a(0.0f);
            this.f5146g = new k1.a(0.0f);
            this.f5147h = new k1.a(0.0f);
            this.f5148i = h.c();
            this.f5149j = h.c();
            this.f5150k = h.c();
            this.f5151l = h.c();
            this.f5140a = kVar.f5128a;
            this.f5141b = kVar.f5129b;
            this.f5142c = kVar.f5130c;
            this.f5143d = kVar.f5131d;
            this.f5144e = kVar.f5132e;
            this.f5145f = kVar.f5133f;
            this.f5146g = kVar.f5134g;
            this.f5147h = kVar.f5135h;
            this.f5148i = kVar.f5136i;
            this.f5149j = kVar.f5137j;
            this.f5150k = kVar.f5138k;
            this.f5151l = kVar.f5139l;
        }
    }

    public k() {
        this.f5128a = h.b();
        this.f5129b = h.b();
        this.f5130c = h.b();
        this.f5131d = h.b();
        this.f5132e = new k1.a(0.0f);
        this.f5133f = new k1.a(0.0f);
        this.f5134g = new k1.a(0.0f);
        this.f5135h = new k1.a(0.0f);
        this.f5136i = h.c();
        this.f5137j = h.c();
        this.f5138k = h.c();
        this.f5139l = h.c();
    }
}
