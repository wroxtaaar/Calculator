package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: ConstraintHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int[] f968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Context f970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected p.h f971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View[] f974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HashMap<Integer, String> f975i;

    public b(Context context) {
        super(context);
        this.f968b = new int[32];
        this.f972f = false;
        this.f974h = null;
        this.f975i = new HashMap<>();
        this.f970d = context;
        g(null);
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.f970d == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iF = f(strTrim);
        if (iF != 0) {
            this.f975i.put(Integer.valueOf(iF), strTrim);
            b(iF);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void b(int i3) {
        if (i3 == getId()) {
            return;
        }
        int i4 = this.f969c + 1;
        int[] iArr = this.f968b;
        if (i4 > iArr.length) {
            this.f968b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f968b;
        int i5 = this.f969c;
        iArr2[i5] = i3;
        this.f969c = i5 + 1;
    }

    private int e(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f970d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            if (childAt.getId() != -1) {
                String resourceEntryName = null;
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int f(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iE = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objF = constraintLayout.f(0, str);
            if (objF instanceof Integer) {
                iE = ((Integer) objF).intValue();
            }
        }
        if (iE == 0 && constraintLayout != null) {
            iE = e(constraintLayout, str);
        }
        if (iE == 0) {
            try {
                iE = h.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iE == 0 ? this.f970d.getResources().getIdentifier(str, "id", this.f970d.getPackageName()) : iE;
    }

    protected void c() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        d((ConstraintLayout) parent);
    }

    protected void d(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i3 = 0; i3 < this.f969c; i3++) {
            View viewH = constraintLayout.h(this.f968b[i3]);
            if (viewH != null) {
                viewH.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewH.setTranslationZ(viewH.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == i.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f973g = string;
                    setIds(string);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f968b, this.f969c);
    }

    public void h(p.e eVar, boolean z2) {
    }

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public void k(ConstraintLayout constraintLayout) {
    }

    public void l(ConstraintLayout constraintLayout) {
        String str;
        int iE;
        if (isInEditMode()) {
            setIds(this.f973g);
        }
        p.h hVar = this.f971e;
        if (hVar == null) {
            return;
        }
        hVar.a();
        for (int i3 = 0; i3 < this.f969c; i3++) {
            int i4 = this.f968b[i3];
            View viewH = constraintLayout.h(i4);
            if (viewH == null && (iE = e(constraintLayout, (str = this.f975i.get(Integer.valueOf(i4))))) != 0) {
                this.f968b[i3] = iE;
                this.f975i.put(Integer.valueOf(iE), str);
                viewH = constraintLayout.h(iE);
            }
            if (viewH != null) {
                this.f971e.c(constraintLayout.i(viewH));
            }
        }
        this.f971e.b(constraintLayout.f880d);
    }

    public void m() {
        if (this.f971e == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f929n0 = (p.e) this.f971e;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f973g;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f972f) {
            super.onMeasure(i3, i4);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    protected void setIds(String str) {
        this.f973g = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f969c = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                a(str.substring(i3));
                return;
            } else {
                a(str.substring(i3, iIndexOf));
                i3 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f973g = null;
        this.f969c = 0;
        for (int i3 : iArr) {
            b(i3);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f968b = new int[32];
        this.f972f = false;
        this.f974h = null;
        this.f975i = new HashMap<>();
        this.f970d = context;
        g(attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f968b = new int[32];
        this.f972f = false;
        this.f974h = null;
        this.f975i = new HashMap<>();
        this.f970d = context;
        g(attributeSet);
    }
}
