package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
public class w extends Spinner implements e0.s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f790j = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.appcompat.widget.e f791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h0 f793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SpinnerAdapter f794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Rect f798i;

    /* JADX INFO: compiled from: AppCompatSpinner.java */
    class a extends h0 {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ e f799k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f799k = eVar;
        }

        @Override // androidx.appcompat.widget.h0
        public h.e b() {
            return this.f799k;
        }

        @Override // androidx.appcompat.widget.h0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (w.this.getInternalPopup().c()) {
                return true;
            }
            w.this.b();
            return true;
        }
    }

    /* JADX INFO: compiled from: AppCompatSpinner.java */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!w.this.getInternalPopup().c()) {
                w.this.b();
            }
            ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatSpinner.java */
    class c implements g, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        androidx.appcompat.app.a f802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ListAdapter f803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f804d;

        c() {
        }

        @Override // androidx.appcompat.widget.w.g
        public boolean c() {
            androidx.appcompat.app.a aVar = this.f802b;
            if (aVar != null) {
                return aVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.w.g
        public void d(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void dismiss() {
            androidx.appcompat.app.a aVar = this.f802b;
            if (aVar != null) {
                aVar.dismiss();
                this.f802b = null;
            }
        }

        @Override // androidx.appcompat.widget.w.g
        public void e(int i3) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public int f() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public void g(int i3, int i4) {
            if (this.f803c == null) {
                return;
            }
            androidx.appcompat.app.a.C0000a c0000a = new androidx.appcompat.app.a.C0000a(w.this.getPopupContext());
            CharSequence charSequence = this.f804d;
            if (charSequence != null) {
                c0000a.p(charSequence);
            }
            androidx.appcompat.app.a aVarA = c0000a.n(this.f803c, w.this.getSelectedItemPosition(), this).a();
            this.f802b = aVarA;
            ListView listViewG = aVarA.g();
            if (Build.VERSION.SDK_INT >= 17) {
                listViewG.setTextDirection(i3);
                listViewG.setTextAlignment(i4);
            }
            this.f802b.show();
        }

        @Override // androidx.appcompat.widget.w.g
        public int h() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public Drawable j() {
            return null;
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence k() {
            return this.f804d;
        }

        @Override // androidx.appcompat.widget.w.g
        public void m(CharSequence charSequence) {
            this.f804d = charSequence;
        }

        @Override // androidx.appcompat.widget.w.g
        public void n(int i3) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void o(ListAdapter listAdapter) {
            this.f803c = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            w.this.setSelection(i3);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i3, this.f803c.getItemId(i3));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.w.g
        public void p(int i3) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* JADX INFO: compiled from: AppCompatSpinner.java */
    private static class d implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SpinnerAdapter f806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ListAdapter f807c;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f806b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f807c = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof s0) {
                    s0 s0Var = (s0) spinnerAdapter;
                    if (s0Var.getDropDownViewTheme() == null) {
                        s0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f807c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f806b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f806b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i3, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            SpinnerAdapter spinnerAdapter = this.f806b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            SpinnerAdapter spinnerAdapter = this.f806b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i3);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i3) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            return getDropDownView(i3, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f806b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            ListAdapter listAdapter = this.f807c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i3);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f806b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f806b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: compiled from: AppCompatSpinner.java */
    class e extends j0 implements g {
        private CharSequence K;
        ListAdapter L;
        private final Rect M;
        private int N;

        /* JADX INFO: compiled from: AppCompatSpinner.java */
        class a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ w f808b;

            a(w wVar) {
                this.f808b = wVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                w.this.setSelection(i3);
                if (w.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    w.this.performItemClick(view, i3, eVar.L.getItemId(i3));
                }
                e.this.dismiss();
            }
        }

        /* JADX INFO: compiled from: AppCompatSpinner.java */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.U(w.this)) {
                    e.this.dismiss();
                } else {
                    e.this.S();
                    e.super.a();
                }
            }
        }

        /* JADX INFO: compiled from: AppCompatSpinner.java */
        class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f811b;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f811b = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f811b);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.M = new Rect();
            D(w.this);
            J(true);
            O(0);
            L(new a(w.this));
        }

        void S() {
            Drawable drawableJ = j();
            int i3 = 0;
            if (drawableJ != null) {
                drawableJ.getPadding(w.this.f798i);
                i3 = c1.b(w.this) ? w.this.f798i.right : -w.this.f798i.left;
            } else {
                Rect rect = w.this.f798i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = w.this.getPaddingLeft();
            int paddingRight = w.this.getPaddingRight();
            int width = w.this.getWidth();
            w wVar = w.this;
            int i4 = wVar.f797h;
            if (i4 == -2) {
                int iA = wVar.a((SpinnerAdapter) this.L, j());
                int i5 = w.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = w.this.f798i;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (iA > i6) {
                    iA = i6;
                }
                F(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                F((width - paddingLeft) - paddingRight);
            } else {
                F(i4);
            }
            e(c1.b(w.this) ? i3 + (((width - paddingRight) - z()) - T()) : i3 + paddingLeft + T());
        }

        public int T() {
            return this.N;
        }

        boolean U(View view) {
            return e0.t.R(view) && view.getGlobalVisibleRect(this.M);
        }

        @Override // androidx.appcompat.widget.w.g
        public void g(int i3, int i4) {
            ViewTreeObserver viewTreeObserver;
            boolean zC = c();
            S();
            I(2);
            super.a();
            ListView listViewL = l();
            listViewL.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listViewL.setTextDirection(i3);
                listViewL.setTextAlignment(i4);
            }
            P(w.this.getSelectedItemPosition());
            if (zC || (viewTreeObserver = w.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            K(new c(bVar));
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence k() {
            return this.K;
        }

        @Override // androidx.appcompat.widget.w.g
        public void m(CharSequence charSequence) {
            this.K = charSequence;
        }

        @Override // androidx.appcompat.widget.j0, androidx.appcompat.widget.w.g
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.L = listAdapter;
        }

        @Override // androidx.appcompat.widget.w.g
        public void p(int i3) {
            this.N = i3;
        }
    }

    /* JADX INFO: compiled from: AppCompatSpinner.java */
    static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f813b;

        /* JADX INFO: compiled from: AppCompatSpinner.java */
        class a implements Parcelable.Creator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i3) {
                return new f[i3];
            }
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.f813b ? (byte) 1 : (byte) 0);
        }

        f(Parcel parcel) {
            super(parcel);
            this.f813b = parcel.readByte() != 0;
        }
    }

    /* JADX INFO: compiled from: AppCompatSpinner.java */
    interface g {
        boolean c();

        void d(Drawable drawable);

        void dismiss();

        void e(int i3);

        int f();

        void g(int i3, int i4);

        int h();

        Drawable j();

        CharSequence k();

        void m(CharSequence charSequence);

        void n(int i3);

        void o(ListAdapter listAdapter);

        void p(int i3);
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.spinnerStyle);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i3 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f798i);
        Rect rect = this.f798i;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f796g.g(getTextDirection(), getTextAlignment());
        } else {
            this.f796g.g(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.f791b;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f796g;
        if (gVar != null) {
            return gVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f796g;
        if (gVar != null) {
            return gVar.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f796g != null) {
            return this.f797h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    final g getInternalPopup() {
        return this.f796g;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f796g;
        if (gVar != null) {
            return gVar.j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f792c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f796g;
        return gVar != null ? gVar.k() : super.getPrompt();
    }

    @Override // e0.s
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.f791b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // e0.s
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.f791b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f796g;
        if (gVar == null || !gVar.c()) {
            return;
        }
        this.f796g.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f796g == null || View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (!fVar.f813b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f796g;
        fVar.f813b = gVar != null && gVar.c();
        return fVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var = this.f793d;
        if (h0Var == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f796g;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.c()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.f791b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        androidx.appcompat.widget.e eVar = this.f791b;
        if (eVar != null) {
            eVar.g(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i3) {
        g gVar = this.f796g;
        if (gVar != null) {
            gVar.p(i3);
            this.f796g.e(i3);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i3) {
        g gVar = this.f796g;
        if (gVar != null) {
            gVar.n(i3);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i3) {
        if (this.f796g != null) {
            this.f797h = i3;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f796g;
        if (gVar != null) {
            gVar.d(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i3) {
        setPopupBackgroundDrawable(c.a.d(getPopupContext(), i3));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f796g;
        if (gVar != null) {
            gVar.m(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.f791b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // e0.s
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.f791b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public w(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f795f) {
            this.f794e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f796g != null) {
            Context context = this.f792c;
            if (context == null) {
                context = getContext();
            }
            this.f796g.o(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public w(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(context, attributeSet, i3, i4, null);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, android.widget.Spinner, androidx.appcompat.widget.w] */
    public w(Context context, AttributeSet attributeSet, int i3, int i4, Resources.Theme theme) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] charSequenceArrQ;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i3);
        this.f798i = new Rect();
        r0.a(this, getContext());
        w0 w0VarV = w0.v(context, attributeSet, a.j.Spinner, i3, 0);
        this.f791b = new androidx.appcompat.widget.e(this);
        if (theme != null) {
            this.f792c = new g.d(context, theme);
        } else {
            int iN = w0VarV.n(a.j.Spinner_popupTheme, 0);
            if (iN != 0) {
                this.f792c = new g.d(context, iN);
            } else {
                this.f792c = context;
            }
        }
        ?? r11 = -1;
        ?? r3 = 0;
        try {
            if (i4 == -1) {
                try {
                    typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f790j, i3, 0);
                    try {
                        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
                        r11 = typedArrayObtainStyledAttributes;
                        if (zHasValue) {
                            i4 = typedArrayObtainStyledAttributes.getInt(0, 0);
                            r11 = typedArrayObtainStyledAttributes;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        r11 = typedArrayObtainStyledAttributes;
                        if (typedArrayObtainStyledAttributes != null) {
                        }
                        if (i4 != 0) {
                            c cVar = new c();
                            this.f796g = cVar;
                            cVar.m(w0VarV.o(a.j.Spinner_android_prompt));
                        } else if (i4 == 1) {
                            e eVar = new e(this.f792c, attributeSet, i3);
                            w0 w0VarV2 = w0.v(this.f792c, attributeSet, a.j.Spinner, i3, 0);
                            this.f797h = w0VarV2.m(a.j.Spinner_android_dropDownWidth, -2);
                            eVar.d(w0VarV2.g(a.j.Spinner_android_popupBackground));
                            eVar.m(w0VarV.o(a.j.Spinner_android_prompt));
                            w0VarV2.w();
                            this.f796g = eVar;
                            this.f793d = new a(this, eVar);
                        }
                        charSequenceArrQ = w0VarV.q(a.j.Spinner_android_entries);
                        if (charSequenceArrQ != null) {
                            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrQ);
                            arrayAdapter.setDropDownViewResource(a.g.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        w0VarV.w();
                        this.f795f = true;
                        spinnerAdapter = this.f794e;
                        if (spinnerAdapter != null) {
                            setAdapter(spinnerAdapter);
                            this.f794e = null;
                        }
                        this.f791b.e(attributeSet, i3);
                    }
                } catch (Exception e4) {
                    e = e4;
                    typedArrayObtainStyledAttributes = null;
                } catch (Throwable th) {
                    th = th;
                    if (r3 != 0) {
                        r3.recycle();
                    }
                    throw th;
                }
                r11.recycle();
            }
            if (i4 != 0) {
                c cVar2 = new c();
                this.f796g = cVar2;
                cVar2.m(w0VarV.o(a.j.Spinner_android_prompt));
            } else if (i4 == 1) {
                e eVar2 = new e(this.f792c, attributeSet, i3);
                w0 w0VarV3 = w0.v(this.f792c, attributeSet, a.j.Spinner, i3, 0);
                this.f797h = w0VarV3.m(a.j.Spinner_android_dropDownWidth, -2);
                eVar2.d(w0VarV3.g(a.j.Spinner_android_popupBackground));
                eVar2.m(w0VarV.o(a.j.Spinner_android_prompt));
                w0VarV3.w();
                this.f796g = eVar2;
                this.f793d = new a(this, eVar2);
            }
            charSequenceArrQ = w0VarV.q(a.j.Spinner_android_entries);
            if (charSequenceArrQ != null) {
                ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrQ);
                arrayAdapter2.setDropDownViewResource(a.g.support_simple_spinner_dropdown_item);
                setAdapter(arrayAdapter2);
            }
            w0VarV.w();
            this.f795f = true;
            spinnerAdapter = this.f794e;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f794e = null;
            }
            this.f791b.e(attributeSet, i3);
        } catch (Throwable th2) {
            th = th2;
            r3 = r11;
        }
    }
}
