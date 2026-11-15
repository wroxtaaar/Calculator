package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class c extends k1.g {
    private final Paint A;
    private final RectF B;

    c() {
        this(null);
    }

    private void n0() {
        this.A.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A.setColor(-1);
        this.A.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    boolean j0() {
        return !this.B.isEmpty();
    }

    void k0() {
        l0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void l0(float f3, float f4, float f5, float f6) {
        RectF rectF = this.B;
        if (f3 == rectF.left && f4 == rectF.top && f5 == rectF.right && f6 == rectF.bottom) {
            return;
        }
        rectF.set(f3, f4, f5, f6);
        invalidateSelf();
    }

    void m0(RectF rectF) {
        l0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // k1.g
    protected void r(Canvas canvas) {
        if (this.B.isEmpty()) {
            super.r(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.B);
        } else {
            canvas.clipRect(this.B, Region.Op.DIFFERENCE);
        }
        super.r(canvas);
        canvas.restore();
    }

    c(k1.k kVar) {
        super(kVar == null ? new k1.k() : kVar);
        this.A = new Paint(1);
        n0();
        this.B = new RectF();
    }
}
