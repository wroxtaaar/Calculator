package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: compiled from: TooltipPopup.java */
/* JADX INFO: loaded from: classes.dex */
class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f538g;

    a1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f535d = layoutParams;
        this.f536e = new Rect();
        this.f537f = new int[2];
        this.f538g = new int[2];
        this.f532a = context;
        View viewInflate = LayoutInflater.from(context).inflate(a.g.abc_tooltip, (ViewGroup) null);
        this.f533b = viewInflate;
        this.f534c = (TextView) viewInflate.findViewById(a.f.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = a.i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i3, int i4, boolean z2, WindowManager.LayoutParams layoutParams) {
        int height;
        int i5;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f532a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i3 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f532a.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
            height = i4 + dimensionPixelOffset2;
            i5 = i4 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i5 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f532a.getResources().getDimensionPixelOffset(z2 ? a.d.tooltip_y_offset_touch : a.d.tooltip_y_offset_non_touch);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f536e);
        Rect rect = this.f536e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f532a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f536e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f538g);
        view.getLocationOnScreen(this.f537f);
        int[] iArr = this.f537f;
        int i6 = iArr[0];
        int[] iArr2 = this.f538g;
        iArr[0] = i6 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i3) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f533b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f533b.getMeasuredHeight();
        int[] iArr3 = this.f537f;
        int i7 = ((iArr3[1] + i5) - dimensionPixelOffset3) - measuredHeight;
        int i8 = iArr3[1] + height + dimensionPixelOffset3;
        if (z2) {
            if (i7 >= 0) {
                layoutParams.y = i7;
                return;
            } else {
                layoutParams.y = i8;
                return;
            }
        }
        if (measuredHeight + i8 <= this.f536e.height()) {
            layoutParams.y = i8;
        } else {
            layoutParams.y = i7;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f532a.getSystemService("window")).removeView(this.f533b);
        }
    }

    boolean d() {
        return this.f533b.getParent() != null;
    }

    void e(View view, int i3, int i4, boolean z2, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f534c.setText(charSequence);
        a(view, i3, i4, z2, this.f535d);
        ((WindowManager) this.f532a.getSystemService("window")).addView(this.f533b, this.f535d);
    }
}
