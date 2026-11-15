package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PorterDuff.Mode f638b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static j f639c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m0 f640a;

    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    class a implements m0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f641a = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f642b = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f643c = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f644d = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f645e = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f646f = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material, a.e.abc_btn_check_material_anim, a.e.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i3) {
            for (int i4 : iArr) {
                if (i4 == i3) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i3) {
            int iC = r0.c(context, a.a.colorControlHighlight);
            return new ColorStateList(new int[][]{r0.f761b, r0.f764e, r0.f762c, r0.f768i}, new int[]{r0.b(context, a.a.colorButtonNormal), w.a.e(iC, i3), w.a.e(iC, i3), i3});
        }

        private ColorStateList i(Context context) {
            return h(context, r0.c(context, a.a.colorAccent));
        }

        private ColorStateList j(Context context) {
            return h(context, r0.c(context, a.a.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i3 = a.a.colorSwitchThumbNormal;
            ColorStateList colorStateListE = r0.e(context, i3);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = r0.f761b;
                iArr2[0] = r0.b(context, i3);
                iArr[1] = r0.f765f;
                iArr2[1] = r0.c(context, a.a.colorControlActivated);
                iArr[2] = r0.f768i;
                iArr2[2] = r0.c(context, i3);
            } else {
                iArr[0] = r0.f761b;
                iArr2[0] = colorStateListE.getColorForState(iArr[0], 0);
                iArr[1] = r0.f765f;
                iArr2[1] = r0.c(context, a.a.colorControlActivated);
                iArr[2] = r0.f768i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i3, PorterDuff.Mode mode) {
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f638b;
            }
            drawable.setColorFilter(j.e(i3, mode));
        }

        @Override // androidx.appcompat.widget.m0.e
        public Drawable a(m0 m0Var, Context context, int i3) {
            if (i3 == a.e.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{m0Var.j(context, a.e.abc_cab_background_internal_bg), m0Var.j(context, a.e.abc_cab_background_top_mtrl_alpha)});
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0046  */
        /* JADX WARN: Code duplicated, block: B:23:0x004c  */
        /* JADX WARN: Code duplicated, block: B:26:0x005d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.m0.e
        public boolean b(Context context, int i3, Drawable drawable) {
            int iRound;
            boolean z2;
            PorterDuff.Mode mode = j.f638b;
            boolean zF = f(this.f641a, i3);
            int i4 = R.attr.colorBackground;
            if (zF) {
                i4 = a.a.colorControlNormal;
            } else if (f(this.f643c, i3)) {
                i4 = a.a.colorControlActivated;
            } else {
                if (!f(this.f644d, i3)) {
                    if (i3 == a.e.abc_list_divider_mtrl_alpha) {
                        i4 = R.attr.colorForeground;
                        iRound = Math.round(40.8f);
                        z2 = true;
                    } else if (i3 != a.e.abc_dialog_material_background) {
                        iRound = -1;
                        z2 = false;
                        i4 = 0;
                    }
                    if (z2) {
                        return false;
                    }
                    if (e0.a(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(j.e(r0.c(context, i4), mode));
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
                mode = PorterDuff.Mode.MULTIPLY;
            }
            iRound = -1;
            z2 = true;
            if (z2) {
                return false;
            }
            if (e0.a(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(j.e(r0.c(context, i4), mode));
            if (iRound != -1) {
                drawable.setAlpha(iRound);
            }
            return true;
        }

        @Override // androidx.appcompat.widget.m0.e
        public ColorStateList c(Context context, int i3) {
            if (i3 == a.e.abc_edit_text_material) {
                return c.a.c(context, a.c.abc_tint_edittext);
            }
            if (i3 == a.e.abc_switch_track_mtrl_alpha) {
                return c.a.c(context, a.c.abc_tint_switch_track);
            }
            if (i3 == a.e.abc_switch_thumb_material) {
                return k(context);
            }
            if (i3 == a.e.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i3 == a.e.abc_btn_borderless_material) {
                return g(context);
            }
            if (i3 == a.e.abc_btn_colored_material) {
                return i(context);
            }
            if (i3 == a.e.abc_spinner_mtrl_am_alpha || i3 == a.e.abc_spinner_textfield_background_material) {
                return c.a.c(context, a.c.abc_tint_spinner);
            }
            if (f(this.f642b, i3)) {
                return r0.e(context, a.a.colorControlNormal);
            }
            if (f(this.f645e, i3)) {
                return c.a.c(context, a.c.abc_tint_default);
            }
            if (f(this.f646f, i3)) {
                return c.a.c(context, a.c.abc_tint_btn_checkable);
            }
            if (i3 == a.e.abc_seekbar_thumb_material) {
                return c.a.c(context, a.c.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.m0.e
        public boolean d(Context context, int i3, Drawable drawable) {
            if (i3 == a.e.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i4 = a.a.colorControlNormal;
                l(drawableFindDrawableByLayerId, r0.c(context, i4), j.f638b);
                l(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), r0.c(context, i4), j.f638b);
                l(layerDrawable.findDrawableByLayerId(R.id.progress), r0.c(context, a.a.colorControlActivated), j.f638b);
                return true;
            }
            if (i3 != a.e.abc_ratingbar_material && i3 != a.e.abc_ratingbar_indicator_material && i3 != a.e.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            l(layerDrawable2.findDrawableByLayerId(R.id.background), r0.b(context, a.a.colorControlNormal), j.f638b);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i5 = a.a.colorControlActivated;
            l(drawableFindDrawableByLayerId2, r0.c(context, i5), j.f638b);
            l(layerDrawable2.findDrawableByLayerId(R.id.progress), r0.c(context, i5), j.f638b);
            return true;
        }

        @Override // androidx.appcompat.widget.m0.e
        public PorterDuff.Mode e(int i3) {
            if (i3 == a.e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized j b() {
        if (f639c == null) {
            h();
        }
        return f639c;
    }

    public static synchronized PorterDuffColorFilter e(int i3, PorterDuff.Mode mode) {
        return m0.l(i3, mode);
    }

    public static synchronized void h() {
        if (f639c == null) {
            j jVar = new j();
            f639c = jVar;
            jVar.f640a = m0.h();
            f639c.f640a.u(new a());
        }
    }

    static void i(Drawable drawable, u0 u0Var, int[] iArr) {
        m0.w(drawable, u0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i3) {
        return this.f640a.j(context, i3);
    }

    synchronized Drawable d(Context context, int i3, boolean z2) {
        return this.f640a.k(context, i3, z2);
    }

    synchronized ColorStateList f(Context context, int i3) {
        return this.f640a.m(context, i3);
    }

    public synchronized void g(Context context) {
        this.f640a.s(context);
    }
}
