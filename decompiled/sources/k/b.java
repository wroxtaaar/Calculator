package k;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: compiled from: CardViewApi17Impl.java */
/* JADX INFO: loaded from: classes.dex */
class b extends d {

    /* JADX INFO: compiled from: CardViewApi17Impl.java */
    class a implements h.a {
        a() {
        }

        @Override // k.h.a
        public void a(Canvas canvas, RectF rectF, float f3, Paint paint) {
            canvas.drawRoundRect(rectF, f3, f3, paint);
        }
    }

    b() {
    }

    @Override // k.d, k.f
    public void k() {
        h.f5054r = new a();
    }
}
