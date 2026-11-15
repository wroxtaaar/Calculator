package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected LayoutInflater f157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j.a f158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected k f161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f162k;

    public a(Context context, int i3, int i4) {
        this.f153b = context;
        this.f156e = LayoutInflater.from(context);
        this.f159h = i3;
        this.f160i = i4;
    }

    protected void a(View view, int i3) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f161j).addView(view, i3);
    }

    @Override // androidx.appcompat.view.menu.j
    public void b(e eVar, boolean z2) {
        j.a aVar = this.f158g;
        if (aVar != null) {
            aVar.b(eVar, z2);
        }
    }

    public abstract void c(g gVar, k.a aVar);

    @Override // androidx.appcompat.view.menu.j
    public void e(Context context, e eVar) {
        this.f154c = context;
        this.f157f = LayoutInflater.from(context);
        this.f155d = eVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f158g = aVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.j
    public boolean i(m mVar) {
        j.a aVar = this.f158g;
        e eVar = mVar;
        if (aVar == null) {
            return false;
        }
        if (mVar == null) {
            eVar = this.f155d;
        }
        return aVar.c(eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public void j(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) this.f161j;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f155d;
        int i3 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList<g> arrayListE = this.f155d.E();
            int size = arrayListE.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                g gVar = arrayListE.get(i5);
                if (q(i4, gVar)) {
                    View childAt = viewGroup.getChildAt(i4);
                    g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View viewN = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        a(viewN, i4);
                    }
                    i4++;
                }
            }
            i3 = i4;
        }
        while (i3 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i3)) {
                i3++;
            }
        }
    }

    public k.a k(ViewGroup viewGroup) {
        return (k.a) this.f156e.inflate(this.f160i, viewGroup, false);
    }

    protected boolean l(ViewGroup viewGroup, int i3) {
        viewGroup.removeViewAt(i3);
        return true;
    }

    public j.a m() {
        return this.f158g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(g gVar, View view, ViewGroup viewGroup) {
        k.a aVarK = view instanceof k.a ? (k.a) view : k(viewGroup);
        c(gVar, aVarK);
        return (View) aVarK;
    }

    public k o(ViewGroup viewGroup) {
        if (this.f161j == null) {
            k kVar = (k) this.f156e.inflate(this.f159h, viewGroup, false);
            this.f161j = kVar;
            kVar.b(this.f155d);
            j(true);
        }
        return this.f161j;
    }

    public void p(int i3) {
        this.f162k = i3;
    }

    public abstract boolean q(int i3, g gVar);
}
