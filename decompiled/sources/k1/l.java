package k1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

/* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m[] f5152a = new m[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f5153b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f5154c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f5155d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f5156e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f5157f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f5158g = new m();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f5159h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f5160i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f5161j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f5162k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f5163l = true;

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final l f5164a = new l();
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    public interface b {
        void a(m mVar, Matrix matrix, int i3);

        void b(m mVar, Matrix matrix, int i3);
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f5165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f5166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f5167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f5168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f5169e;

        c(k kVar, float f3, RectF rectF, b bVar, Path path) {
            this.f5168d = bVar;
            this.f5165a = kVar;
            this.f5169e = f3;
            this.f5167c = rectF;
            this.f5166b = path;
        }
    }

    public l() {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f5152a[i3] = new m();
            this.f5153b[i3] = new Matrix();
            this.f5154c[i3] = new Matrix();
        }
    }

    private float a(int i3) {
        return (i3 + 1) * 90;
    }

    private void b(c cVar, int i3) {
        this.f5159h[0] = this.f5152a[i3].k();
        this.f5159h[1] = this.f5152a[i3].l();
        this.f5153b[i3].mapPoints(this.f5159h);
        if (i3 == 0) {
            Path path = cVar.f5166b;
            float[] fArr = this.f5159h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f5166b;
            float[] fArr2 = this.f5159h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f5152a[i3].d(this.f5153b[i3], cVar.f5166b);
        b bVar = cVar.f5168d;
        if (bVar != null) {
            bVar.a(this.f5152a[i3], this.f5153b[i3], i3);
        }
    }

    private void c(c cVar, int i3) {
        int i4 = (i3 + 1) % 4;
        this.f5159h[0] = this.f5152a[i3].i();
        this.f5159h[1] = this.f5152a[i3].j();
        this.f5153b[i3].mapPoints(this.f5159h);
        this.f5160i[0] = this.f5152a[i4].k();
        this.f5160i[1] = this.f5152a[i4].l();
        this.f5153b[i4].mapPoints(this.f5160i);
        float[] fArr = this.f5159h;
        float f3 = fArr[0];
        float[] fArr2 = this.f5160i;
        float fMax = Math.max(((float) Math.hypot(f3 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f5167c, i3);
        this.f5158g.n(0.0f, 0.0f);
        f fVarJ = j(i3, cVar.f5165a);
        fVarJ.b(fMax, fI, cVar.f5169e, this.f5158g);
        this.f5161j.reset();
        this.f5158g.d(this.f5154c[i3], this.f5161j);
        if (this.f5163l && Build.VERSION.SDK_INT >= 19 && (fVarJ.a() || l(this.f5161j, i3) || l(this.f5161j, i4))) {
            Path path = this.f5161j;
            path.op(path, this.f5157f, Path.Op.DIFFERENCE);
            this.f5159h[0] = this.f5158g.k();
            this.f5159h[1] = this.f5158g.l();
            this.f5154c[i3].mapPoints(this.f5159h);
            Path path2 = this.f5156e;
            float[] fArr3 = this.f5159h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f5158g.d(this.f5154c[i3], this.f5156e);
        } else {
            this.f5158g.d(this.f5154c[i3], cVar.f5166b);
        }
        b bVar = cVar.f5168d;
        if (bVar != null) {
            bVar.b(this.f5158g, this.f5154c[i3], i3);
        }
    }

    private void f(int i3, RectF rectF, PointF pointF) {
        if (i3 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i3 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i3 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private k1.c g(int i3, k kVar) {
        if (i3 == 1) {
            return kVar.l();
        }
        if (i3 != 2) {
            return i3 != 3 ? kVar.t() : kVar.r();
        }
        return kVar.j();
    }

    private d h(int i3, k kVar) {
        if (i3 == 1) {
            return kVar.k();
        }
        if (i3 != 2) {
            return i3 != 3 ? kVar.s() : kVar.q();
        }
        return kVar.i();
    }

    private float i(RectF rectF, int i3) {
        float[] fArr = this.f5159h;
        m[] mVarArr = this.f5152a;
        fArr[0] = mVarArr[i3].f5172c;
        fArr[1] = mVarArr[i3].f5173d;
        this.f5153b[i3].mapPoints(fArr);
        return (i3 == 1 || i3 == 3) ? Math.abs(rectF.centerX() - this.f5159h[0]) : Math.abs(rectF.centerY() - this.f5159h[1]);
    }

    private f j(int i3, k kVar) {
        if (i3 == 1) {
            return kVar.h();
        }
        if (i3 != 2) {
            return i3 != 3 ? kVar.o() : kVar.p();
        }
        return kVar.n();
    }

    public static l k() {
        return a.f5164a;
    }

    private boolean l(Path path, int i3) {
        this.f5162k.reset();
        this.f5152a[i3].d(this.f5153b[i3], this.f5162k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f5162k.computeBounds(rectF, true);
        path.op(this.f5162k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(c cVar, int i3) {
        h(i3, cVar.f5165a).b(this.f5152a[i3], 90.0f, cVar.f5169e, cVar.f5167c, g(i3, cVar.f5165a));
        float fA = a(i3);
        this.f5153b[i3].reset();
        f(i3, cVar.f5167c, this.f5155d);
        Matrix matrix = this.f5153b[i3];
        PointF pointF = this.f5155d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f5153b[i3].preRotate(fA);
    }

    private void n(int i3) {
        this.f5159h[0] = this.f5152a[i3].i();
        this.f5159h[1] = this.f5152a[i3].j();
        this.f5153b[i3].mapPoints(this.f5159h);
        float fA = a(i3);
        this.f5154c[i3].reset();
        Matrix matrix = this.f5154c[i3];
        float[] fArr = this.f5159h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f5154c[i3].preRotate(fA);
    }

    public void d(k kVar, float f3, RectF rectF, Path path) {
        e(kVar, f3, rectF, null, path);
    }

    public void e(k kVar, float f3, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f5156e.rewind();
        this.f5157f.rewind();
        this.f5157f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f3, rectF, bVar, path);
        for (int i3 = 0; i3 < 4; i3++) {
            m(cVar, i3);
            n(i3);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            b(cVar, i4);
            c(cVar, i4);
        }
        path.close();
        this.f5156e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f5156e.isEmpty()) {
            return;
        }
        path.op(this.f5156e, Path.Op.UNION);
    }
}
