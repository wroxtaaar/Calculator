package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private p.a f877l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void o(p.e eVar, int i3, boolean z2) {
        this.f876k = i3;
        if (Build.VERSION.SDK_INT < 17) {
            int i4 = this.f875j;
            if (i4 == 5) {
                this.f876k = 0;
            } else if (i4 == 6) {
                this.f876k = 1;
            }
        } else if (z2) {
            int i5 = this.f875j;
            if (i5 == 5) {
                this.f876k = 1;
            } else if (i5 == 6) {
                this.f876k = 0;
            }
        } else {
            int i6 = this.f875j;
            if (i6 == 5) {
                this.f876k = 0;
            } else if (i6 == 6) {
                this.f876k = 1;
            }
        }
        if (eVar instanceof p.a) {
            ((p.a) eVar).M0(this.f876k);
        }
    }

    @Override // androidx.constraintlayout.widget.b
    protected void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f877l = new p.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == i.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == i.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f877l.L0(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == i.ConstraintLayout_Layout_barrierMargin) {
                    this.f877l.N0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
        }
        this.f971e = this.f877l;
        m();
    }

    public int getMargin() {
        return this.f877l.J0();
    }

    public int getType() {
        return this.f875j;
    }

    @Override // androidx.constraintlayout.widget.b
    public void h(p.e eVar, boolean z2) {
        o(eVar, this.f875j, z2);
    }

    public boolean n() {
        return this.f877l.H0();
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.f877l.L0(z2);
    }

    public void setDpMargin(int i3) {
        this.f877l.N0((int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i3) {
        this.f877l.N0(i3);
    }

    public void setType(int i3) {
        this.f875j = i3;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        super.setVisibility(8);
    }
}
