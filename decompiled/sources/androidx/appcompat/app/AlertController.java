package androidx.appcompat.app;

import a.j;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.i0;
import androidx.core.widget.NestedScrollView;
import e0.t;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b.f f39b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f40c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f41d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f42e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f43f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ListView f44g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f45h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f48k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f49l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f50m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Button f52o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f53p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Message f54q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f55r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Button f56s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f57t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Message f58u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f59v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Button f60w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f61x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Message f62y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f63z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f51n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f64b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f65c;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void a(boolean z2, boolean z3) {
            if (z3 && z2) {
                return;
            }
            setPadding(getPaddingLeft(), z2 ? getPaddingTop() : this.f64b, getPaddingRight(), z3 ? getPaddingBottom() : this.f65c);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.f65c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.f64b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.f52o && (message3 = alertController.f54q) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != alertController.f56s || (message2 = alertController.f58u) == null) {
                messageObtain = (view != alertController.f60w || (message = alertController.f62y) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f39b).sendToTarget();
        }
    }

    class b implements NestedScrollView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f67a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f68b;

        b(View view, View view2) {
            this.f67a = view;
            this.f68b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
            AlertController.g(nestedScrollView, this.f67a, this.f68b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f70b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f71c;

        c(View view, View view2) {
            this.f70b = view;
            this.f71c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.A, this.f70b, this.f71c);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f73a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f74b;

        d(View view, View view2) {
            this.f73a = view;
            this.f74b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
            AlertController.g(absListView, this.f73a, this.f74b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f76b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f77c;

        e(View view, View view2) {
            this.f76b = view;
            this.f77c = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f44g, this.f76b, this.f77c);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f79a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f80b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f82d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f84f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f85g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f86h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f87i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f88j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f89k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f90l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f91m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f92n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f93o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f94p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f95q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f97s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f98t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f99u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f100v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f101w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f102x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f103y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f104z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f81c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f83e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f96r = true;

        class a extends ArrayAdapter<CharSequence> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ RecycleListView f105b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i3, int i4, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i3, i4, charSequenceArr);
                this.f105b = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i3, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i3, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i3]) {
                    this.f105b.setItemChecked(i3, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f107b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final int f108c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecycleListView f109d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ AlertController f110e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z2, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z2);
                this.f109d = recycleListView;
                this.f110e = alertController;
                Cursor cursor2 = getCursor();
                this.f107b = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f108c = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f107b));
                this.f109d.setItemChecked(cursor.getPosition(), cursor.getInt(this.f108c) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f80b.inflate(this.f110e.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f112b;

            c(AlertController alertController) {
                this.f112b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                f.this.f102x.onClick(this.f112b.f39b, i3);
                if (f.this.H) {
                    return;
                }
                this.f112b.f39b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ RecycleListView f114b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AlertController f115c;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f114b = recycleListView;
                this.f115c = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i3] = this.f114b.isItemChecked(i3);
                }
                f.this.J.onClick(this.f115c.f39b, i3, this.f114b.isItemChecked(i3));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f79a = context;
            this.f80b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter hVar;
            RecycleListView recycleListView = (RecycleListView) this.f80b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                hVar = this.K == null ? new a(this.f79a, alertController.M, R.id.text1, this.f100v, recycleListView) : new b(this.f79a, this.K, false, recycleListView, alertController);
            } else {
                int i3 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    hVar = new SimpleCursorAdapter(this.f79a, i3, this.K, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    hVar = this.f101w;
                    if (hVar == null) {
                        hVar = new h(this.f79a, i3, R.id.text1, this.f100v);
                    }
                }
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = hVar;
            alertController.I = this.I;
            if (this.f102x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f44g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f85g;
            if (view != null) {
                alertController.m(view);
            } else {
                CharSequence charSequence = this.f84f;
                if (charSequence != null) {
                    alertController.r(charSequence);
                }
                Drawable drawable = this.f82d;
                if (drawable != null) {
                    alertController.o(drawable);
                }
                int i3 = this.f81c;
                if (i3 != 0) {
                    alertController.n(i3);
                }
                int i4 = this.f83e;
                if (i4 != 0) {
                    alertController.n(alertController.d(i4));
                }
            }
            CharSequence charSequence2 = this.f86h;
            if (charSequence2 != null) {
                alertController.p(charSequence2);
            }
            CharSequence charSequence3 = this.f87i;
            if (charSequence3 != null || this.f88j != null) {
                alertController.l(-1, charSequence3, this.f89k, null, this.f88j);
            }
            CharSequence charSequence4 = this.f90l;
            if (charSequence4 != null || this.f91m != null) {
                alertController.l(-2, charSequence4, this.f92n, null, this.f91m);
            }
            CharSequence charSequence5 = this.f93o;
            if (charSequence5 != null || this.f94p != null) {
                alertController.l(-3, charSequence5, this.f95q, null, this.f94p);
            }
            if (this.f100v != null || this.K != null || this.f101w != null) {
                b(alertController);
            }
            View view2 = this.f104z;
            if (view2 != null) {
                if (this.E) {
                    alertController.u(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.t(view2);
                    return;
                }
            }
            int i5 = this.f103y;
            if (i5 != 0) {
                alertController.s(i5);
            }
        }
    }

    private static final class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f117a;

        public g(DialogInterface dialogInterface) {
            this.f117a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -3 || i3 == -2 || i3 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f117a.get(), message.what);
            } else {
                if (i3 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i3, int i4, CharSequence[] charSequenceArr) {
            super(context, i3, i4, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, b.f fVar, Window window) {
        this.f38a = context;
        this.f39b = fVar;
        this.f40c = window;
        this.R = new g(fVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, a.a.alertDialogStyle, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        this.f41d = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        fVar.d(1);
    }

    private static boolean A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i3 = this.K;
        if (i3 == 0) {
            return this.J;
        }
        return this.Q == 1 ? i3 : this.J;
    }

    private void q(ViewGroup viewGroup, View view, int i3, int i4) {
        View viewFindViewById = this.f40c.findViewById(a.f.scrollIndicatorUp);
        View viewFindViewById2 = this.f40c.findViewById(a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            t.z0(view, i3, i4);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i3 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i3 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f43f != null) {
            this.A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.A.post(new c(viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.f44g;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f44g.post(new e(viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void v(ViewGroup viewGroup) {
        int i3;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f52o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f53p) && this.f55r == null) {
            this.f52o.setVisibility(8);
            i3 = 0;
        } else {
            this.f52o.setText(this.f53p);
            Drawable drawable = this.f55r;
            if (drawable != null) {
                int i4 = this.f41d;
                drawable.setBounds(0, 0, i4, i4);
                this.f52o.setCompoundDrawables(this.f55r, null, null, null);
            }
            this.f52o.setVisibility(0);
            i3 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f56s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f57t) && this.f59v == null) {
            this.f56s.setVisibility(8);
        } else {
            this.f56s.setText(this.f57t);
            Drawable drawable2 = this.f59v;
            if (drawable2 != null) {
                int i5 = this.f41d;
                drawable2.setBounds(0, 0, i5, i5);
                this.f56s.setCompoundDrawables(this.f59v, null, null, null);
            }
            this.f56s.setVisibility(0);
            i3 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f60w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f61x) && this.f63z == null) {
            this.f60w.setVisibility(8);
        } else {
            this.f60w.setText(this.f61x);
            Drawable drawable3 = this.f63z;
            if (drawable3 != null) {
                int i6 = this.f41d;
                drawable3.setBounds(0, 0, i6, i6);
                this.f60w.setCompoundDrawables(this.f63z, null, null, null);
            }
            this.f60w.setVisibility(0);
            i3 |= 4;
        }
        if (A(this.f38a)) {
            if (i3 == 1) {
                b(this.f52o);
            } else if (i3 == 2) {
                b(this.f56s);
            } else if (i3 == 4) {
                b(this.f60w);
            }
        }
        if (i3 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void w(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f40c.findViewById(a.f.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f43f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f44g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f44g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void x(ViewGroup viewGroup) {
        View viewInflate = this.f45h;
        if (viewInflate == null) {
            viewInflate = this.f46i != 0 ? LayoutInflater.from(this.f38a).inflate(this.f46i, viewGroup, false) : null;
        }
        boolean z2 = viewInflate != null;
        if (!z2 || !a(viewInflate)) {
            this.f40c.setFlags(131072, 131072);
        }
        if (!z2) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f40c.findViewById(a.f.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f51n) {
            frameLayout.setPadding(this.f47j, this.f48k, this.f49l, this.f50m);
        }
        if (this.f44g != null) {
            ((i0.a) viewGroup.getLayoutParams()).f636a = 0.0f;
        }
    }

    private void y(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f40c.findViewById(a.f.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f40c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f42e)) || !this.P) {
            this.f40c.findViewById(a.f.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f40c.findViewById(a.f.alertTitle);
        this.E = textView;
        textView.setText(this.f42e);
        int i3 = this.B;
        if (i3 != 0) {
            this.D.setImageResource(i3);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f40c.findViewById(a.f.parentPanel);
        int i3 = a.f.topPanel;
        View viewFindViewById4 = viewFindViewById3.findViewById(i3);
        int i4 = a.f.contentPanel;
        View viewFindViewById5 = viewFindViewById3.findViewById(i4);
        int i5 = a.f.buttonPanel;
        View viewFindViewById6 = viewFindViewById3.findViewById(i5);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(a.f.customPanel);
        x(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i3);
        View viewFindViewById8 = viewGroup.findViewById(i4);
        View viewFindViewById9 = viewGroup.findViewById(i5);
        ViewGroup viewGroupJ = j(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupJ2 = j(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupJ3 = j(viewFindViewById9, viewFindViewById6);
        w(viewGroupJ2);
        v(viewGroupJ3);
        y(viewGroupJ);
        boolean z2 = viewGroup.getVisibility() != 8;
        boolean z3 = (viewGroupJ == null || viewGroupJ.getVisibility() == 8) ? 0 : 1;
        boolean z4 = (viewGroupJ3 == null || viewGroupJ3.getVisibility() == 8) ? false : true;
        if (!z4 && viewGroupJ2 != null && (viewFindViewById2 = viewGroupJ2.findViewById(a.f.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z3 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f43f == null && this.f44g == null) ? null : viewGroupJ.findViewById(a.f.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupJ2 != null && (viewFindViewById = viewGroupJ2.findViewById(a.f.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f44g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view = this.f44g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                q(viewGroupJ2, view, z3 | (z4 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f44g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i6 = this.I;
        if (i6 > -1) {
            listView2.setItemChecked(i6, true);
            listView2.setSelection(i6);
        }
    }

    public Button c(int i3) {
        if (i3 == -3) {
            return this.f60w;
        }
        if (i3 == -2) {
            return this.f56s;
        }
        if (i3 != -1) {
            return null;
        }
        return this.f52o;
    }

    public int d(int i3) {
        TypedValue typedValue = new TypedValue();
        this.f38a.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f44g;
    }

    public void f() {
        this.f39b.setContentView(k());
        z();
    }

    public boolean h(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean i(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void l(int i3, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i3, onClickListener);
        }
        if (i3 == -3) {
            this.f61x = charSequence;
            this.f62y = message;
            this.f63z = drawable;
        } else if (i3 == -2) {
            this.f57t = charSequence;
            this.f58u = message;
            this.f59v = drawable;
        } else {
            if (i3 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f53p = charSequence;
            this.f54q = message;
            this.f55r = drawable;
        }
    }

    public void m(View view) {
        this.G = view;
    }

    public void n(int i3) {
        this.C = null;
        this.B = i3;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i3 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void o(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void p(CharSequence charSequence) {
        this.f43f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(CharSequence charSequence) {
        this.f42e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(int i3) {
        this.f45h = null;
        this.f46i = i3;
        this.f51n = false;
    }

    public void t(View view) {
        this.f45h = view;
        this.f46i = 0;
        this.f51n = false;
    }

    public void u(View view, int i3, int i4, int i5, int i6) {
        this.f45h = view;
        this.f46i = 0;
        this.f51n = true;
        this.f47j = i3;
        this.f48k = i4;
        this.f49l = i5;
        this.f50m = i6;
    }
}
