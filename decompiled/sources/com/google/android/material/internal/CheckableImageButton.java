package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import com.vivo.seckeysdk.SecurityKeyCipher;
import e0.t;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends androidx.appcompat.widget.m implements Checkable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f3039g = {R.attr.state_checked};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3042f;

    class a extends e0.a {
        a() {
        }

        @Override // e0.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // e0.a
        public void g(View view, f0.d dVar) {
            super.g(view, dVar);
            dVar.V(CheckableImageButton.this.a());
            dVar.W(CheckableImageButton.this.isChecked());
        }
    }

    static class b extends i0.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f3044d;

        class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void k(Parcel parcel) {
            this.f3044d = parcel.readInt() == 1;
        }

        @Override // i0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f3044d ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            k(parcel);
        }
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public boolean a() {
        return this.f3041e;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f3040d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i3) {
        if (!this.f3040d) {
            return super.onCreateDrawableState(i3);
        }
        int[] iArr = f3039g;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i3 + iArr.length), iArr);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.j());
        setChecked(bVar.f3044d);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f3044d = this.f3040d;
        return bVar;
    }

    public void setCheckable(boolean z2) {
        if (this.f3041e != z2) {
            this.f3041e = z2;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (!this.f3041e || this.f3040d == z2) {
            return;
        }
        this.f3040d = z2;
        refreshDrawableState();
        sendAccessibilityEvent(SecurityKeyCipher.SECURITY_DATA_SIZE_MAX);
    }

    public void setPressable(boolean z2) {
        this.f3042f = z2;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        if (this.f3042f) {
            super.setPressed(z2);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f3040d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3041e = true;
        this.f3042f = true;
        t.m0(this, new a());
    }
}
