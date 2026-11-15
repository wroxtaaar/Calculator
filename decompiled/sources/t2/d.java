package t2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ThumbSelector.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ImageButton {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static boolean f6239p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static Method f6240q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f6241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f6246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Bitmap> f6247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Bitmap> f6248i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6249j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6250k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6251l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Vibrator f6252m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Context f6253n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f6254o;

    /* JADX INFO: compiled from: ThumbSelector.java */
    public interface a {
        void a(View view, int i3);

        void b(View view, int i3);

        void c(View view);
    }

    public d(Context context) {
        this(context, null);
    }

    private Bitmap a(int i3, int i4) {
        float f3;
        float fAbs;
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Paint.FontMetrics fontMetrics = this.f6241b.getFontMetrics();
        int i5 = this.f6243d;
        int i6 = this.f6242c;
        canvas.setBitmap(bitmapCreateBitmap);
        Iterator<Bitmap> it = this.f6247h.iterator();
        int i7 = 0;
        while (true) {
            float width = 0.0f;
            if (!it.hasNext()) {
                break;
            }
            Bitmap next = it.next();
            Rect rect = new Rect(0, 0, next.getWidth(), next.getHeight());
            if (i5 > next.getWidth()) {
                width = (i5 - next.getWidth()) / 2;
            }
            float f4 = (i7 * i6) + this.f6251l;
            canvas.drawBitmap(next, rect, new Rect((int) width, (int) f4, i5, (int) (f4 + i6)), this.f6241b);
            i7++;
        }
        int iAbs = (int) Math.abs(fontMetrics.top - fontMetrics.bottom);
        for (String str : this.f6246g) {
            float f5 = i5;
            float fMeasureText = f5 > this.f6241b.measureText(str) ? (f5 - this.f6241b.measureText(str)) / 2.0f : 0.0f;
            float f6 = this.f6251l;
            if (i6 > iAbs) {
                f3 = (i7 * i6) + ((i6 - iAbs) / 2) + iAbs;
                fAbs = Math.abs(fontMetrics.descent);
            } else {
                f3 = (i7 + 1) * i6;
                fAbs = Math.abs(fontMetrics.descent);
            }
            float f7 = f6 + (f3 - fAbs);
            Log.d("Thumb", str + " : [ " + fMeasureText + " " + f7 + " ]");
            canvas.drawText(str, fMeasureText, f7, this.f6241b);
            i7++;
        }
        for (Bitmap bitmap : this.f6248i) {
            Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            float width2 = i5 > bitmap.getWidth() ? (i5 - bitmap.getWidth()) / 2 : 0.0f;
            float f8 = (i7 * i6) + this.f6251l;
            canvas.drawBitmap(bitmap, rect2, new Rect((int) width2, (int) f8, i5, (int) (f8 + i6)), this.f6241b);
            i7++;
        }
        return bitmapCreateBitmap;
    }

    private void b(int i3, int i4) {
        int paddingLeft = (i3 - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (i4 - getPaddingTop()) - getPaddingBottom();
        if (paddingLeft <= 0 || paddingTop <= 0) {
            return;
        }
        if (this.f6244e != i3 || this.f6245f != i4) {
            this.f6244e = i3;
            this.f6245f = i4;
            this.f6249j = true;
        }
        if (!this.f6249j || d() <= 0) {
            return;
        }
        this.f6242c = paddingTop / d();
        this.f6243d = paddingLeft;
        int iD = (paddingTop - (d() * this.f6242c)) / 2;
        this.f6251l = iD;
        if (iD <= 0) {
            iD = 0;
        }
        this.f6251l = iD;
        Log.d("Thumb", "contentHeight = " + paddingTop + " TextHeight = " + this.f6242c);
        setImageBitmap(a(paddingLeft, paddingTop));
        this.f6249j = false;
    }

    public static String c(String str, String str2) {
        try {
            if (f6240q == null) {
                f6240q = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            }
            return (String) f6240q.invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    private int d() {
        return this.f6246g.size() + this.f6247h.size() + this.f6248i.size();
    }

    private void g() {
        if (this.f6252m == null || Settings.System.getInt(this.f6253n.getContentResolver(), "haptic_feedback_enabled", -1) == 0) {
            return;
        }
        Class<?> cls = this.f6252m.getClass();
        try {
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("vibratorPro", cls2, Long.TYPE, cls2);
            if (declaredMethod != null) {
                ((Long) declaredMethod.invoke(this.f6252m, 112, -1, -1)).longValue();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Log.d("Thumb", "dispatchTouchEvent event.getY():" + motionEvent.getY());
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void e(MotionEvent motionEvent, int i3) {
    }

    public void f() {
        if (getVisibility() == 0) {
            this.f6249j = true;
            requestLayout();
        }
    }

    public List<String> getAlphabet() {
        return this.f6246g;
    }

    public List<Bitmap> getFooter() {
        return this.f6248i;
    }

    public List<Bitmap> getHeader() {
        return this.f6247h;
    }

    public int getTextColor() {
        return this.f6241b.getColor();
    }

    public float getTextSize() {
        return this.f6241b.getTextSize();
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        b(i5 - i3, i6 - i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (mode != 1073741824) {
            int iMeasureText = 0;
            for (String str : this.f6246g) {
                if (iMeasureText < ((int) this.f6241b.measureText(str))) {
                    iMeasureText = (int) this.f6241b.measureText(str);
                }
            }
            int paddingLeft = iMeasureText + getPaddingLeft() + getPaddingRight();
            if (paddingLeft > measuredWidth) {
                measuredWidth = paddingLeft;
            }
        }
        if (mode2 != 1073741824) {
            Paint.FontMetrics fontMetrics = this.f6241b.getFontMetrics();
            int iAbs = (((int) Math.abs(fontMetrics.bottom - fontMetrics.top)) * d()) + getPaddingTop() + getPaddingBottom();
            if (iAbs > measuredHeight) {
                measuredHeight = iAbs;
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0097  */
    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        int paddingTop = this.f6251l + getPaddingTop();
        if (d() > 0 && this.f6242c > 0) {
            int y3 = (int) ((motionEvent.getY() - paddingTop) / this.f6242c);
            Log.d("Thumb", "paddingTop = " + paddingTop + " eventY = " + motionEvent.getY());
            Log.d("Thumb", "alphabetNumber = " + d() + "  alphbetPos = " + y3);
            if (y3 >= d() || y3 < 0) {
                y3 = -1;
            }
            if (y3 >= 0 || motionEvent.getAction() != 0) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    if (f6239p) {
                        g();
                    }
                    a aVar2 = this.f6254o;
                    if (aVar2 != null) {
                        aVar2.b(this, y3);
                    }
                } else if (action == 1) {
                    this.f6250k = -1;
                    aVar = this.f6254o;
                    if (aVar != null) {
                        aVar.c(this);
                    }
                } else if (action == 2) {
                    a aVar3 = this.f6254o;
                    if (aVar3 != null && y3 >= 0 && y3 != this.f6250k) {
                        aVar3.a(this, y3);
                        this.f6250k = y3;
                        if (f6239p) {
                            g();
                        }
                    }
                } else if (action == 3) {
                    this.f6250k = -1;
                    aVar = this.f6254o;
                    if (aVar != null) {
                        aVar.c(this);
                    }
                }
            }
            e(motionEvent, y3);
        }
        return true;
    }

    public void setAlphabet(List<String> list) {
        this.f6246g.clear();
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f6246g.add(it.next());
            }
        }
        f();
    }

    public void setSlideListener(a aVar) {
        this.f6254o = aVar;
    }

    public void setTextColor(int i3) {
        this.f6241b.setColor(i3);
        f();
    }

    public void setTextSize(float f3) {
        this.f6241b.setTextSize(f3);
        f();
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, t2.a.ThumbSelectorStyle);
    }

    public d(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f6241b = new Paint(1);
        this.f6242c = 0;
        this.f6243d = 0;
        this.f6244e = 0;
        this.f6245f = 0;
        this.f6246g = new ArrayList();
        this.f6247h = new ArrayList();
        this.f6248i = new ArrayList();
        this.f6249j = true;
        this.f6250k = -1;
        this.f6251l = 0;
        this.f6254o = null;
        float f3 = context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.ThumbSelector, i3, b.Widget_Vigour_ThumbSelector);
        this.f6241b.setTextSize(typedArrayObtainStyledAttributes.getDimension(c.ThumbSelector_thumbSelectorTextSize, f3 * 14.0f));
        this.f6241b.setColor(typedArrayObtainStyledAttributes.getColor(c.ThumbSelector_thumbSelectorTextColor, -16777216));
        this.f6241b.setAntiAlias(true);
        this.f6252m = (Vibrator) context.getSystemService("vibrator");
        f6239p = "1".equals(c("persist.vivo.support.lra", "0"));
        typedArrayObtainStyledAttributes.recycle();
        this.f6253n = context;
    }
}
