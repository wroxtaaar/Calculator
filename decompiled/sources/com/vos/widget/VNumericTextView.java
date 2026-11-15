package com.vos.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;
import com.vivo.seckeysdk.BuildConfig;
import y1.b;

/* JADX INFO: loaded from: classes.dex */
public class VNumericTextView extends TextView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final double f4372j = Math.log(10.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f4380i;

    public interface a {
        void a(VNumericTextView vNumericTextView, int i3, boolean z2, boolean z3);
    }

    public VNumericTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4373b = 0;
        this.f4374c = 99;
        this.f4375d = 2;
        this.f4376e = true;
        setHintTextColor(context.getColor(b.vigour_textColor_disable));
        setFocusable(true);
    }

    private boolean a(int i3) {
        int iC;
        String str;
        if (i3 == 67) {
            int i4 = this.f4378g;
            if (i4 > 0) {
                this.f4377f /= 10;
                this.f4378g = i4 - 1;
            }
        } else {
            if (!b(i3)) {
                return false;
            }
            if (this.f4378g < this.f4375d && (iC = (this.f4377f * 10) + c(i3)) <= this.f4374c) {
                this.f4377f = iC;
                this.f4378g++;
            }
        }
        if (this.f4378g > 0) {
            str = String.format("%0" + this.f4378g + "d", Integer.valueOf(this.f4377f));
        } else {
            str = BuildConfig.FLAVOR;
        }
        setText(str);
        a aVar = this.f4380i;
        if (aVar != null) {
            int i5 = this.f4377f;
            aVar.a(this, i5, i5 >= this.f4373b, this.f4378g >= this.f4375d || i5 * 10 > this.f4374c);
        }
        return true;
    }

    private static boolean b(int i3) {
        return i3 == 7 || i3 == 8 || i3 == 9 || i3 == 10 || i3 == 11 || i3 == 12 || i3 == 13 || i3 == 14 || i3 == 15 || i3 == 16;
    }

    private static int c(int i3) {
        return i3 - 7;
    }

    private void d() {
        String str;
        if (this.f4376e) {
            str = "%0" + this.f4375d + "d";
        } else {
            str = "%d";
        }
        setText(String.format(str, Integer.valueOf(this.f4377f)));
    }

    public final a getOnDigitEnteredListener() {
        return this.f4380i;
    }

    public final int getRangeMaximum() {
        return this.f4374c;
    }

    public final int getRangeMinimum() {
        return this.f4373b;
    }

    public final boolean getShowLeadingZeroes() {
        return this.f4376e;
    }

    public final int getValue() {
        return this.f4377f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z2, int i3, Rect rect) {
        super.onFocusChanged(z2, i3, rect);
        if (z2) {
            this.f4379h = this.f4377f;
            this.f4377f = 0;
            this.f4378g = 0;
            setHint(getText());
            setText(BuildConfig.FLAVOR);
            return;
        }
        if (this.f4378g == 0) {
            this.f4377f = this.f4379h;
            setText(getHint());
            setHint(BuildConfig.FLAVOR);
        }
        int i4 = this.f4377f;
        int i5 = this.f4373b;
        if (i4 < i5) {
            this.f4377f = i5;
        }
        setValue(this.f4377f);
        a aVar = this.f4380i;
        if (aVar != null) {
            aVar.a(this, this.f4377f, true, true);
        }
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return b(i3) || i3 == 67 || super.onKeyDown(i3, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i4, KeyEvent keyEvent) {
        return b(i3) || i3 == 67 || super.onKeyMultiple(i3, i4, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        return a(i3) || super.onKeyUp(i3, keyEvent);
    }

    public final void setOnDigitEnteredListener(a aVar) {
        this.f4380i = aVar;
    }

    public final void setShowLeadingZeroes(boolean z2) {
        if (this.f4376e != z2) {
            this.f4376e = z2;
            d();
        }
    }

    public final void setValue(int i3) {
        if (this.f4377f != i3) {
            this.f4377f = i3;
            d();
        }
    }
}
