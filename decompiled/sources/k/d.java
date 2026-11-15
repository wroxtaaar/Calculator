package k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: CardViewBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RectF f5040a = new RectF();

    /* JADX INFO: compiled from: CardViewBaseImpl.java */
    class a implements h.a {
        a() {
        }

        @Override // k.h.a
        public void a(Canvas canvas, RectF rectF, float f3, Paint paint) {
            float f4 = 2.0f * f3;
            float fWidth = (rectF.width() - f4) - 1.0f;
            float fHeight = (rectF.height() - f4) - 1.0f;
            if (f3 >= 1.0f) {
                float f5 = f3 + 0.5f;
                float f6 = -f5;
                d.this.f5040a.set(f6, f6, f5, f5);
                int iSave = canvas.save();
                canvas.translate(rectF.left + f5, rectF.top + f5);
                canvas.drawArc(d.this.f5040a, 180.0f, 90.0f, true, paint);
                canvas.translate(fWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d.this.f5040a, 180.0f, 90.0f, true, paint);
                canvas.translate(fHeight, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d.this.f5040a, 180.0f, 90.0f, true, paint);
                canvas.translate(fWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d.this.f5040a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(iSave);
                float f7 = (rectF.left + f5) - 1.0f;
                float f8 = rectF.top;
                canvas.drawRect(f7, f8, (rectF.right - f5) + 1.0f, f8 + f5, paint);
                float f9 = (rectF.left + f5) - 1.0f;
                float f10 = rectF.bottom;
                canvas.drawRect(f9, f10 - f5, (rectF.right - f5) + 1.0f, f10, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f3, rectF.right, rectF.bottom - f3, paint);
        }
    }

    d() {
    }

    private h n(e eVar) {
        return (h) eVar.d();
    }

    @Override // k.f
    public void a(e eVar) {
        n(eVar).m(eVar.f());
        o(eVar);
    }

    @Override // k.f
    public void b(e eVar) {
    }

    @Override // k.f
    public float c(e eVar) {
        return n(eVar).k();
    }

    @Override // k.f
    public float d(e eVar) {
        return n(eVar).g();
    }

    @Override // k.f
    public float e(e eVar) {
        return n(eVar).i();
    }

    @Override // k.f
    public void f(e eVar, float f3) {
        n(eVar).q(f3);
        o(eVar);
    }

    @Override // k.f
    public void g(e eVar, ColorStateList colorStateList) {
        n(eVar).o(colorStateList);
    }

    @Override // k.f
    public void h(e eVar, float f3) {
        n(eVar).p(f3);
        o(eVar);
    }

    @Override // k.f
    public float i(e eVar) {
        return n(eVar).j();
    }

    @Override // k.f
    public ColorStateList j(e eVar) {
        return n(eVar).f();
    }

    @Override // k.f
    public void k() {
        h.f5054r = new a();
    }

    @Override // k.f
    public void l(e eVar, float f3) {
        n(eVar).r(f3);
    }

    @Override // k.f
    public float m(e eVar) {
        return n(eVar).l();
    }

    public void o(e eVar) {
        Rect rect = new Rect();
        n(eVar).h(rect);
        eVar.e((int) Math.ceil(c(eVar)), (int) Math.ceil(i(eVar)));
        eVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
