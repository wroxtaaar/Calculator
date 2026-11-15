package d;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

/* JADX INFO: compiled from: StateListDrawable.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
class d extends b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f4498n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4499o;

    /* JADX INFO: compiled from: StateListDrawable.java */
    static class a extends b.c {
        int[][] J;

        a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int iH = h();
            for (int i3 = 0; i3 < iH; i3++) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // d.b.c
        public void o(int i3, int i4) {
            super.o(i3, i4);
            int[][] iArr = new int[i4][];
            System.arraycopy(this.J, 0, iArr, 0, i3);
            this.J = iArr;
        }

        @Override // d.b.c
        void r() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        int z(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.J[iA] = iArr;
            return iA;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // d.b
    void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof a) {
            this.f4498n = (a) cVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d.b
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a b() {
        return new a(this.f4498n, this, null);
    }

    int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i3 = 0;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i4);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i5 = i3 + 1;
                if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i3] = attributeNameResource;
                i3 = i5;
            }
        }
        return StateSet.trimStateSet(iArr, i3);
    }

    @Override // d.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f4499o && super.mutate() == this) {
            this.f4498n.r();
            this.f4499o = true;
        }
        return this;
    }

    @Override // d.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iA = this.f4498n.A(iArr);
        if (iA < 0) {
            iA = this.f4498n.A(StateSet.WILD_CARD);
        }
        return g(iA) || zOnStateChange;
    }

    d(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }
}
