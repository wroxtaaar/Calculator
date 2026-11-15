package k1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f5170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f5171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f5172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f5173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f5174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f5175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<f> f5176g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f5177h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5178i;

    /* JADX INFO: compiled from: ShapePath.java */
    class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f5179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f5180c;

        a(List list, Matrix matrix) {
            this.f5179b = list;
            this.f5180c = matrix;
        }

        @Override // k1.m.g
        public void a(Matrix matrix, j1.a aVar, int i3, Canvas canvas) {
            Iterator it = this.f5179b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f5180c, aVar, i3, canvas);
            }
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f5182b;

        public b(d dVar) {
            this.f5182b = dVar;
        }

        @Override // k1.m.g
        public void a(Matrix matrix, j1.a aVar, int i3, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f5182b.k(), this.f5182b.o(), this.f5182b.l(), this.f5182b.j()), i3, this.f5182b.m(), this.f5182b.n());
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f5183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f5184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f5185d;

        public c(e eVar, float f3, float f4) {
            this.f5183b = eVar;
            this.f5184c = f3;
            this.f5185d = f4;
        }

        @Override // k1.m.g
        public void a(Matrix matrix, j1.a aVar, int i3, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f5183b.f5194c - this.f5185d, this.f5183b.f5193b - this.f5184c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f5184c, this.f5185d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i3);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f5183b.f5194c - this.f5185d) / (this.f5183b.f5193b - this.f5184c)));
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final RectF f5186h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f5187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f5188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f5189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f5190e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f5191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f5192g;

        public d(float f3, float f4, float f5, float f6) {
            q(f3);
            u(f4);
            r(f5);
            p(f6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f5190e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f5187b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f5189d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f5191f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f5192g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f5188c;
        }

        private void p(float f3) {
            this.f5190e = f3;
        }

        private void q(float f3) {
            this.f5187b = f3;
        }

        private void r(float f3) {
            this.f5189d = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f3) {
            this.f5191f = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f3) {
            this.f5192g = f3;
        }

        private void u(float f3) {
            this.f5188c = f3;
        }

        @Override // k1.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f5195a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f5186h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f5193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f5194c;

        @Override // k1.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f5195a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f5193b, this.f5194c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Matrix f5195a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Matrix f5196a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, j1.a aVar, int i3, Canvas canvas);

        public final void b(j1.a aVar, int i3, Canvas canvas) {
            a(f5196a, aVar, i3, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f3) {
        if (g() == f3) {
            return;
        }
        float fG = ((f3 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f5177h.add(new b(dVar));
        p(f3);
    }

    private void c(g gVar, float f3, float f4) {
        b(f3);
        this.f5177h.add(gVar);
        p(f4);
    }

    private float g() {
        return this.f5174e;
    }

    private float h() {
        return this.f5175f;
    }

    private void p(float f3) {
        this.f5174e = f3;
    }

    private void q(float f3) {
        this.f5175f = f3;
    }

    private void r(float f3) {
        this.f5172c = f3;
    }

    private void s(float f3) {
        this.f5173d = f3;
    }

    private void t(float f3) {
        this.f5170a = f3;
    }

    private void u(float f3) {
        this.f5171b = f3;
    }

    public void a(float f3, float f4, float f5, float f6, float f7, float f8) {
        d dVar = new d(f3, f4, f5, f6);
        dVar.s(f7);
        dVar.t(f8);
        this.f5176g.add(dVar);
        b bVar = new b(dVar);
        float f9 = f7 + f8;
        boolean z2 = f8 < 0.0f;
        if (z2) {
            f7 = (f7 + 180.0f) % 360.0f;
        }
        c(bVar, f7, z2 ? (180.0f + f9) % 360.0f : f9);
        double d3 = f9;
        r(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.cos(Math.toRadians(d3)))));
        s(((f4 + f6) * 0.5f) + (((f6 - f4) / 2.0f) * ((float) Math.sin(Math.toRadians(d3)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f5176g.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f5176g.get(i3).a(matrix, path);
        }
    }

    boolean e() {
        return this.f5178i;
    }

    g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f5177h), new Matrix(matrix));
    }

    float i() {
        return this.f5172c;
    }

    float j() {
        return this.f5173d;
    }

    float k() {
        return this.f5170a;
    }

    float l() {
        return this.f5171b;
    }

    public void m(float f3, float f4) {
        e eVar = new e();
        eVar.f5193b = f3;
        eVar.f5194c = f4;
        this.f5176g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f3);
        s(f4);
    }

    public void n(float f3, float f4) {
        o(f3, f4, 270.0f, 0.0f);
    }

    public void o(float f3, float f4, float f5, float f6) {
        t(f3);
        u(f4);
        r(f3);
        s(f4);
        p(f5);
        q((f5 + f6) % 360.0f);
        this.f5176g.clear();
        this.f5177h.clear();
        this.f5178i = false;
    }
}
