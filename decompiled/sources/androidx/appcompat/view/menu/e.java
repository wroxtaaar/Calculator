package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import e0.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MenuBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements y.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f218e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    CharSequence f227n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Drawable f228o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    View f229p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private g f237x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f239z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f225l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f230q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f231r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f232s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f233t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f234u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ArrayList<g> f235v = new ArrayList<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<j>> f236w = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f238y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<g> f219f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<g> f220g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f221h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<g> f222i = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<g> f223j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f224k = true;

    /* JADX INFO: compiled from: MenuBuilder.java */
    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    /* JADX INFO: compiled from: MenuBuilder.java */
    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f214a = context;
        this.f215b = context.getResources();
        b0(true);
    }

    private static int B(int i3) {
        int i4 = ((-65536) & i3) >> 16;
        if (i4 >= 0) {
            int[] iArr = A;
            if (i4 < iArr.length) {
                return (i3 & 65535) | (iArr[i4] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i3, boolean z2) {
        if (i3 < 0 || i3 >= this.f219f.size()) {
            return;
        }
        this.f219f.remove(i3);
        if (z2) {
            K(true);
        }
    }

    private void W(int i3, CharSequence charSequence, int i4, Drawable drawable, View view) {
        Resources resourcesC = C();
        if (view != null) {
            this.f229p = view;
            this.f227n = null;
            this.f228o = null;
        } else {
            if (i3 > 0) {
                this.f227n = resourcesC.getText(i3);
            } else if (charSequence != null) {
                this.f227n = charSequence;
            }
            if (i4 > 0) {
                this.f228o = u.a.d(u(), i4);
            } else if (drawable != null) {
                this.f228o = drawable;
            }
            this.f229p = null;
        }
        K(false);
    }

    private void b0(boolean z2) {
        this.f217d = z2 && this.f215b.getConfiguration().keyboard != 1 && u.e(ViewConfiguration.get(this.f214a), this.f214a);
    }

    private g g(int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        return new g(this, i3, i4, i5, i6, charSequence, i7);
    }

    private void i(boolean z2) {
        if (this.f236w.isEmpty()) {
            return;
        }
        d0();
        for (WeakReference<j> weakReference : this.f236w) {
            j jVar = weakReference.get();
            if (jVar == null) {
                this.f236w.remove(weakReference);
            } else {
                jVar.j(z2);
            }
        }
        c0();
    }

    private boolean j(m mVar, j jVar) {
        if (this.f236w.isEmpty()) {
            return false;
        }
        boolean zI = jVar != null ? jVar.i(mVar) : false;
        for (WeakReference<j> weakReference : this.f236w) {
            j jVar2 = weakReference.get();
            if (jVar2 == null) {
                this.f236w.remove(weakReference);
            } else if (!zI) {
                zI = jVar2.i(mVar);
            }
        }
        return zI;
    }

    private static int n(ArrayList<g> arrayList, int i3) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i3) {
                return size + 1;
            }
        }
        return 0;
    }

    boolean A() {
        return this.f233t;
    }

    Resources C() {
        return this.f215b;
    }

    public e D() {
        return this;
    }

    public ArrayList<g> E() {
        if (!this.f221h) {
            return this.f220g;
        }
        this.f220g.clear();
        int size = this.f219f.size();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.f219f.get(i3);
            if (gVar.isVisible()) {
                this.f220g.add(gVar);
            }
        }
        this.f221h = false;
        this.f224k = true;
        return this.f220g;
    }

    public boolean F() {
        return this.f238y;
    }

    boolean G() {
        return this.f216c;
    }

    public boolean H() {
        return this.f217d;
    }

    void I(g gVar) {
        this.f224k = true;
        K(true);
    }

    void J(g gVar) {
        this.f221h = true;
        K(true);
    }

    public void K(boolean z2) {
        if (this.f230q) {
            this.f231r = true;
            if (z2) {
                this.f232s = true;
                return;
            }
            return;
        }
        if (z2) {
            this.f221h = true;
            this.f224k = true;
        }
        i(z2);
    }

    public boolean L(MenuItem menuItem, int i3) {
        return M(menuItem, null, i3);
    }

    public boolean M(MenuItem menuItem, j jVar, int i3) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        e0.b bVarB = gVar.b();
        boolean z2 = bVarB != null && bVarB.a();
        if (gVar.j()) {
            zK |= gVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (gVar.hasSubMenu() || z2) {
            if ((i3 & 4) == 0) {
                e(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new m(u(), this, gVar));
            }
            m mVar = (m) gVar.getSubMenu();
            if (z2) {
                bVarB.f(mVar);
            }
            zK |= j(mVar, jVar);
            if (!zK) {
                e(true);
            }
        } else if ((i3 & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public void O(j jVar) {
        for (WeakReference<j> weakReference : this.f236w) {
            j jVar2 = weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f236w.remove(weakReference);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).P(bundle);
            }
        }
        int i4 = bundle.getInt("android:menu:expandedactionview");
        if (i4 <= 0 || (menuItemFindItem = findItem(i4)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f218e = aVar;
    }

    public e S(int i3) {
        this.f225l = i3;
        return this;
    }

    void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f219f.size();
        d0();
        for (int i3 = 0; i3 < size; i3++) {
            g gVar = this.f219f.get(i3);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        c0();
    }

    protected e U(int i3) {
        W(0, null, i3, null, null);
        return this;
    }

    protected e V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    protected e X(int i3) {
        W(i3, null, 0, null, null);
        return this;
    }

    protected e Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    protected e Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    protected MenuItem a(int i3, int i4, int i5, CharSequence charSequence) {
        int iB = B(i5);
        g gVarG = g(i3, i4, i5, iB, charSequence, this.f225l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f226m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f219f;
        arrayList.add(n(arrayList, iB), gVarG);
        K(true);
        return gVarG;
    }

    public void a0(boolean z2) {
        this.f239z = z2;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        int i7;
        PackageManager packageManager = this.f214a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i6 & 1) == 0) {
            removeGroup(i3);
        }
        for (int i8 = 0; i8 < size; i8++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i9 < 0 ? intent : intentArr[i9]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i3, i4, i5, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.f214a);
    }

    public void c(j jVar, Context context) {
        this.f236w.add(new WeakReference<>(jVar));
        jVar.e(context, this);
        this.f224k = true;
    }

    public void c0() {
        this.f230q = false;
        if (this.f231r) {
            this.f231r = false;
            K(this.f232s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f237x;
        if (gVar != null) {
            f(gVar);
        }
        this.f219f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f228o = null;
        this.f227n = null;
        this.f229p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f218e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.f230q) {
            return;
        }
        this.f230q = true;
        this.f231r = false;
        this.f232s = false;
    }

    public final void e(boolean z2) {
        if (this.f234u) {
            return;
        }
        this.f234u = true;
        for (WeakReference<j> weakReference : this.f236w) {
            j jVar = weakReference.get();
            if (jVar == null) {
                this.f236w.remove(weakReference);
            } else {
                jVar.b(this, z2);
            }
        }
        this.f234u = false;
    }

    public boolean f(g gVar) {
        boolean zF = false;
        if (!this.f236w.isEmpty() && this.f237x == gVar) {
            d0();
            for (WeakReference<j> weakReference : this.f236w) {
                j jVar = weakReference.get();
                if (jVar != null) {
                    zF = jVar.f(this, gVar);
                    if (zF) {
                        break;
                    }
                } else {
                    this.f236w.remove(weakReference);
                }
            }
            c0();
            if (zF) {
                this.f237x = null;
            }
        }
        return zF;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            g gVar = this.f219f.get(i4);
            if (gVar.getItemId() == i3) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i3)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return this.f219f.get(i3);
    }

    boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f218e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f239z) {
            return true;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f219f.get(i3).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return p(i3, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean zG = false;
        if (this.f236w.isEmpty()) {
            return false;
        }
        d0();
        for (WeakReference<j> weakReference : this.f236w) {
            j jVar = weakReference.get();
            if (jVar != null) {
                zG = jVar.g(this, gVar);
                if (zG) {
                    break;
                }
            } else {
                this.f236w.remove(weakReference);
            }
        }
        c0();
        if (zG) {
            this.f237x = gVar;
        }
        return zG;
    }

    public int l(int i3) {
        return m(i3, 0);
    }

    public int m(int i3, int i4) {
        int size = size();
        if (i4 < 0) {
            i4 = 0;
        }
        while (i4 < size) {
            if (this.f219f.get(i4).getGroupId() == i3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public int o(int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f219f.get(i4).getItemId() == i3) {
                return i4;
            }
        }
        return -1;
    }

    g p(int i3, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f235v;
        arrayList.clear();
        q(arrayList, i3, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zG = G();
        for (int i4 = 0; i4 < size; i4++) {
            g gVar = arrayList.get(i4);
            char alphabeticShortcut = zG ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zG && alphabeticShortcut == '\b' && i3 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i4) {
        return L(findItem(i3), i4);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i4) {
        g gVarP = p(i3, keyEvent);
        boolean zL = gVarP != null ? L(gVarP, i4) : false;
        if ((i4 & 2) != 0) {
            e(true);
        }
        return zL;
    }

    void q(List<g> list, int i3, KeyEvent keyEvent) {
        boolean zG = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i3 == 67) {
            int size = this.f219f.size();
            for (int i4 = 0; i4 < size; i4++) {
                g gVar = this.f219f.get(i4);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i3, keyEvent);
                }
                char alphabeticShortcut = zG ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & 69647) == ((zG ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zG && alphabeticShortcut == '\b' && i3 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<g> arrayListE = E();
        if (this.f224k) {
            boolean zD = false;
            for (WeakReference<j> weakReference : this.f236w) {
                j jVar = weakReference.get();
                if (jVar == null) {
                    this.f236w.remove(weakReference);
                } else {
                    zD |= jVar.d();
                }
            }
            if (zD) {
                this.f222i.clear();
                this.f223j.clear();
                int size = arrayListE.size();
                for (int i3 = 0; i3 < size; i3++) {
                    g gVar = arrayListE.get(i3);
                    if (gVar.l()) {
                        this.f222i.add(gVar);
                    } else {
                        this.f223j.add(gVar);
                    }
                }
            } else {
                this.f222i.clear();
                this.f223j.clear();
                this.f223j.addAll(E());
            }
            this.f224k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
        int iL = l(i3);
        if (iL >= 0) {
            int size = this.f219f.size() - iL;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size || this.f219f.get(iL).getGroupId() != i3) {
                    break;
                }
                N(iL, false);
                i4 = i5;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        N(o(i3), true);
    }

    public ArrayList<g> s() {
        r();
        return this.f222i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z2, boolean z3) {
        int size = this.f219f.size();
        for (int i4 = 0; i4 < size; i4++) {
            g gVar = this.f219f.get(i4);
            if (gVar.getGroupId() == i3) {
                gVar.t(z3);
                gVar.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f238y = z2;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z2) {
        int size = this.f219f.size();
        for (int i4 = 0; i4 < size; i4++) {
            g gVar = this.f219f.get(i4);
            if (gVar.getGroupId() == i3) {
                gVar.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z2) {
        int size = this.f219f.size();
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            g gVar = this.f219f.get(i4);
            if (gVar.getGroupId() == i3 && gVar.y(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f216c = z2;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f219f.size();
    }

    protected String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f214a;
    }

    public g v() {
        return this.f237x;
    }

    public Drawable w() {
        return this.f228o;
    }

    public CharSequence x() {
        return this.f227n;
    }

    public View y() {
        return this.f229p;
    }

    public ArrayList<g> z() {
        r();
        return this.f223j;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        return a(0, 0, 0, this.f215b.getString(i3));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return addSubMenu(0, 0, 0, this.f215b.getString(i3));
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, CharSequence charSequence) {
        return a(i3, i4, i5, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        g gVar = (g) a(i3, i4, i5, charSequence);
        m mVar = new m(this.f214a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, int i6) {
        return a(i3, i4, i5, this.f215b.getString(i6));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, int i6) {
        return addSubMenu(i3, i4, i5, this.f215b.getString(i6));
    }
}
