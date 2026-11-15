package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.vivo.seckeysdk.BuildConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<View> f1270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<View> f1271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1272d;

    public FragmentContainerView(Context context) {
        super(context);
        this.f1272d = true;
    }

    private void a(View view) {
        ArrayList<View> arrayList;
        if (view.getAnimation() != null || ((arrayList = this.f1271c) != null && arrayList.contains(view))) {
            if (this.f1270b == null) {
                this.f1270b = new ArrayList<>();
            }
            this.f1270b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (l.k0(view) != null) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z2) {
        if (l.k0(view) != null) {
            return super.addViewInLayout(view, i3, layoutParams, z2);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f1272d && this.f1270b != null) {
            for (int i3 = 0; i3 < this.f1270b.size(); i3++) {
                super.drawChild(canvas, this.f1270b.get(i3), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        ArrayList<View> arrayList;
        if (!this.f1272d || (arrayList = this.f1270b) == null || arrayList.size() <= 0 || !this.f1270b.contains(view)) {
            return super.drawChild(canvas, view, j3);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f1271c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f1270b;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1272d = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        if (z2) {
            a(view);
        }
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i3) {
        a(getChildAt(i3));
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViews(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            a(getChildAt(i5));
        }
        super.removeViewsInLayout(i3, i4);
    }

    void setDrawDisappearingViewsLast(boolean z2) {
        this.f1272d = z2;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT >= 18) {
            throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        }
        super.setLayoutTransition(layoutTransition);
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1271c == null) {
                this.f1271c = new ArrayList<>();
            }
            this.f1271c.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1272d = true;
        if (!isInEditMode()) {
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to be instantiated from XML.");
        }
    }

    FragmentContainerView(Context context, AttributeSet attributeSet, l lVar) {
        String str;
        super(context, attributeSet);
        this.f1272d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k0.c.FragmentContainerView);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(k0.c.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(k0.c.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentW = lVar.W(id);
        if (classAttribute == null || fragmentW != null) {
            return;
        }
        if (id <= 0) {
            if (string != null) {
                str = " with tag " + string;
            } else {
                str = BuildConfig.FLAVOR;
            }
            throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
        }
        Fragment fragmentA = lVar.e0().a(context.getClassLoader(), classAttribute);
        fragmentA.t0(context, attributeSet, null);
        lVar.i().o(true).c(this, fragmentA, string).i();
    }
}
