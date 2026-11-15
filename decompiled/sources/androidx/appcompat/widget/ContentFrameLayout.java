package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TypedValue f380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypedValue f382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TypedValue f383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TypedValue f384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TypedValue f385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f387i;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void b(int i3, int i4, int i5, int i6) {
        this.f386h.set(i3, i4, i5, i6);
        if (e0.t.S(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f384f == null) {
            this.f384f = new TypedValue();
        }
        return this.f384f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f385g == null) {
            this.f385g = new TypedValue();
        }
        return this.f385g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f382d == null) {
            this.f382d = new TypedValue();
        }
        return this.f382d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f383e == null) {
            this.f383e = new TypedValue();
        }
        return this.f383e;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f380b == null) {
            this.f380b = new TypedValue();
        }
        return this.f380b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f381c == null) {
            this.f381c = new TypedValue();
        }
        return this.f381c;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f387i;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f387i;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        float fraction;
        int i7;
        int i8;
        float fraction2;
        int i9;
        int i10;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z3 = true;
        boolean z4 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode != Integer.MIN_VALUE) {
            z2 = false;
        } else {
            TypedValue typedValue = z4 ? this.f383e : this.f382d;
            if (typedValue == null || (i9 = typedValue.type) == 0) {
                z2 = false;
            } else {
                if (i9 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i9 == 6) {
                        int i11 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i11, i11);
                    } else {
                        i10 = 0;
                    }
                    if (i10 > 0) {
                        Rect rect = this.f386h;
                        i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i10 - (rect.left + rect.right), View.MeasureSpec.getSize(i3)), 1073741824);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                i10 = (int) fraction3;
                if (i10 > 0) {
                    Rect rect2 = this.f386h;
                    i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i10 - (rect2.left + rect2.right), View.MeasureSpec.getSize(i3)), 1073741824);
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z4 ? this.f384f : this.f385g;
            if (typedValue2 != null && (i7 = typedValue2.type) != 0) {
                if (i7 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i7 == 6) {
                        int i12 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i12, i12);
                    } else {
                        i8 = 0;
                    }
                    if (i8 > 0) {
                        Rect rect3 = this.f386h;
                        i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect3.top + rect3.bottom), View.MeasureSpec.getSize(i4)), 1073741824);
                    }
                }
                i8 = (int) fraction2;
                if (i8 > 0) {
                    Rect rect4 = this.f386h;
                    i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i8 - (rect4.top + rect4.bottom), View.MeasureSpec.getSize(i4)), 1073741824);
                }
            }
        }
        super.onMeasure(i3, i4);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z2 || mode != Integer.MIN_VALUE) {
            z3 = false;
        } else {
            TypedValue typedValue3 = z4 ? this.f381c : this.f380b;
            if (typedValue3 == null || (i5 = typedValue3.type) == 0) {
                z3 = false;
            } else {
                if (i5 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i5 == 6) {
                        int i13 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i13, i13);
                    } else {
                        i6 = 0;
                    }
                    if (i6 > 0) {
                        Rect rect5 = this.f386h;
                        i6 -= rect5.left + rect5.right;
                    }
                    if (measuredWidth < i6) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                    } else {
                        z3 = false;
                    }
                }
                i6 = (int) fraction;
                if (i6 > 0) {
                    Rect rect6 = this.f386h;
                    i6 -= rect6.left + rect6.right;
                }
                if (measuredWidth < i6) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                } else {
                    z3 = false;
                }
            }
        }
        if (z3) {
            super.onMeasure(iMakeMeasureSpec, i4);
        }
    }

    public void setAttachListener(a aVar) {
        this.f387i = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f386h = new Rect();
    }
}
