package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: compiled from: FragmentLayoutInflaterFactory.java */
/* JADX INFO: loaded from: classes.dex */
class j implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f1340b;

    j(l lVar) {
        this.f1340b = lVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f1340b);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k0.c.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(k0.c.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k0.c.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(k0.c.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !h.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentW = resourceId != -1 ? this.f1340b.W(resourceId) : null;
        if (fragmentW == null && string != null) {
            fragmentW = this.f1340b.X(string);
        }
        if (fragmentW == null && id != -1) {
            fragmentW = this.f1340b.W(id);
        }
        if (l.p0(2)) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragmentW);
        }
        if (fragmentW == null) {
            fragmentW = this.f1340b.e0().a(context.getClassLoader(), attributeValue);
            fragmentW.f1235n = true;
            fragmentW.f1244w = resourceId != 0 ? resourceId : id;
            fragmentW.f1245x = id;
            fragmentW.f1246y = string;
            fragmentW.f1236o = true;
            l lVar = this.f1340b;
            fragmentW.f1240s = lVar;
            i<?> iVar = lVar.f1359o;
            fragmentW.f1241t = iVar;
            fragmentW.t0(iVar.h(), attributeSet, fragmentW.f1224c);
            this.f1340b.d(fragmentW);
            this.f1340b.A0(fragmentW);
        } else {
            if (fragmentW.f1236o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentW.f1236o = true;
            i<?> iVar2 = this.f1340b.f1359o;
            fragmentW.f1241t = iVar2;
            fragmentW.t0(iVar2.h(), attributeSet, fragmentW.f1224c);
        }
        l lVar2 = this.f1340b;
        if (lVar2.f1358n >= 1 || !fragmentW.f1235n) {
            lVar2.A0(fragmentW);
        } else {
            lVar2.B0(fragmentW, 1);
        }
        View view2 = fragmentW.H;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragmentW.H.getTag() == null) {
                fragmentW.H.setTag(string);
            }
            return fragmentW.H;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
