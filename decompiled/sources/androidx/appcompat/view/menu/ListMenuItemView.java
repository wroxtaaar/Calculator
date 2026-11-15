package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.w0;
import e0.t;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RadioButton f138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CheckBox f140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView f143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinearLayout f144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Context f147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f148n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Drawable f149o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f150p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LayoutInflater f151q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f152r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.listMenuViewStyle);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i3) {
        LinearLayout linearLayout = this.f144j;
        if (linearLayout != null) {
            linearLayout.addView(view, i3);
        } else {
            addView(view, i3);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(a.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f140f = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(a.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f137c = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(a.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f138d = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f151q == null) {
            this.f151q = LayoutInflater.from(getContext());
        }
        return this.f151q;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.f142h;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f143i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f143i.getLayoutParams();
        rect.top += this.f143i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i3) {
        this.f136b = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f136b;
    }

    public void h(boolean z2, char c3) {
        int i3 = (z2 && this.f136b.A()) ? 0 : 8;
        if (i3 == 0) {
            this.f141g.setText(this.f136b.h());
        }
        if (this.f141g.getVisibility() != i3) {
            this.f141g.setVisibility(i3);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        t.p0(this, this.f145k);
        TextView textView = (TextView) findViewById(a.f.title);
        this.f139e = textView;
        int i3 = this.f146l;
        if (i3 != -1) {
            textView.setTextAppearance(this.f147m, i3);
        }
        this.f141g = (TextView) findViewById(a.f.shortcut);
        ImageView imageView = (ImageView) findViewById(a.f.submenuarrow);
        this.f142h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f149o);
        }
        this.f143i = (ImageView) findViewById(a.f.group_divider);
        this.f144j = (LinearLayout) findViewById(a.f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f137c != null && this.f148n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f137c.getLayoutParams();
            int i5 = layoutParams.height;
            if (i5 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i5;
            }
        }
        super.onMeasure(i3, i4);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z2 && this.f138d == null && this.f140f == null) {
            return;
        }
        if (this.f136b.m()) {
            if (this.f138d == null) {
                g();
            }
            compoundButton = this.f138d;
            compoundButton2 = this.f140f;
        } else {
            if (this.f140f == null) {
                c();
            }
            compoundButton = this.f140f;
            compoundButton2 = this.f138d;
        }
        if (z2) {
            compoundButton.setChecked(this.f136b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f140f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f138d;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.f136b.m()) {
            if (this.f138d == null) {
                g();
            }
            compoundButton = this.f138d;
        } else {
            if (this.f140f == null) {
                c();
            }
            compoundButton = this.f140f;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f152r = z2;
        this.f148n = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.f143i;
        if (imageView != null) {
            imageView.setVisibility((this.f150p || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2 = this.f136b.z() || this.f152r;
        if (z2 || this.f148n) {
            ImageView imageView = this.f137c;
            if (imageView == null && drawable == null && !this.f148n) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f148n) {
                this.f137c.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f137c;
            if (!z2) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f137c.getVisibility() != 0) {
                this.f137c.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f139e.getVisibility() != 8) {
                this.f139e.setVisibility(8);
            }
        } else {
            this.f139e.setText(charSequence);
            if (this.f139e.getVisibility() != 0) {
                this.f139e.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        w0 w0VarV = w0.v(getContext(), attributeSet, a.j.MenuView, i3, 0);
        this.f145k = w0VarV.g(a.j.MenuView_android_itemBackground);
        this.f146l = w0VarV.n(a.j.MenuView_android_itemTextAppearance, -1);
        this.f148n = w0VarV.a(a.j.MenuView_preserveIconSpacing, false);
        this.f147m = context;
        this.f149o = w0VarV.g(a.j.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, a.a.dropDownListViewStyle, 0);
        this.f150p = typedArrayObtainStyledAttributes.hasValue(0);
        w0VarV.w();
        typedArrayObtainStyledAttributes.recycle();
    }
}
