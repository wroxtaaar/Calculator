package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<View> f504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LayoutInflater f505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f506f;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f502b == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflaterFrom = this.f505e;
        if (layoutInflaterFrom == null) {
            layoutInflaterFrom = LayoutInflater.from(getContext());
        }
        View viewInflate = layoutInflaterFrom.inflate(this.f502b, viewGroup, false);
        int i3 = this.f503c;
        if (i3 != -1) {
            viewInflate.setId(i3);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f504d = new WeakReference<>(viewInflate);
        a aVar = this.f506f;
        if (aVar != null) {
            aVar.a(this, viewInflate);
        }
        return viewInflate;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f503c;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f505e;
    }

    public int getLayoutResource() {
        return this.f502b;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i3) {
        this.f503c = i3;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f505e = layoutInflater;
    }

    public void setLayoutResource(int i3) {
        this.f502b = i3;
    }

    public void setOnInflateListener(a aVar) {
        this.f506f = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        WeakReference<View> weakReference = this.f504d;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i3);
            return;
        }
        super.setVisibility(i3);
        if (i3 == 0 || i3 == 4) {
            a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f502b = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ViewStubCompat, i3, 0);
        this.f503c = typedArrayObtainStyledAttributes.getResourceId(a.j.ViewStubCompat_android_inflatedId, -1);
        this.f502b = typedArrayObtainStyledAttributes.getResourceId(a.j.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(a.j.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
