package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/* JADX INFO: compiled from: Placeholder.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f1079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1080d;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f1079c == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f1079c.getLayoutParams();
        bVar2.f929n0.A0(0);
        p.e.b bVarW = bVar.f929n0.w();
        p.e.b bVar3 = p.e.b.FIXED;
        if (bVarW != bVar3) {
            bVar.f929n0.B0(bVar2.f929n0.N());
        }
        if (bVar.f929n0.K() != bVar3) {
            bVar.f929n0.e0(bVar2.f929n0.t());
        }
        bVar2.f929n0.A0(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f1078b == -1 && !isInEditMode()) {
            setVisibility(this.f1080d);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f1078b);
        this.f1079c = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.b) viewFindViewById.getLayoutParams()).f905b0 = true;
            this.f1079c.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f1079c;
    }

    public int getEmptyVisibility() {
        return this.f1080d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i3) {
        View viewFindViewById;
        if (this.f1078b == i3) {
            return;
        }
        View view = this.f1079c;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f1079c.getLayoutParams()).f905b0 = false;
            this.f1079c = null;
        }
        this.f1078b = i3;
        if (i3 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i3)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i3) {
        this.f1080d = i3;
    }
}
