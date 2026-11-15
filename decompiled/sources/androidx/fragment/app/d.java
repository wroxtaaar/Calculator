package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: FragmentActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ComponentActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f1307k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f1308l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f1310n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f1311o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f1312p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    l.h<String> f1313q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final g f1305i = g.b(new a());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final androidx.lifecycle.h f1306j = new androidx.lifecycle.h(this);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f1309m = true;

    /* JADX INFO: compiled from: FragmentActivity.java */
    class a extends i<d> implements androidx.lifecycle.s, androidx.activity.c {
        public a() {
            super(d.this);
        }

        @Override // androidx.lifecycle.g
        public androidx.lifecycle.d b() {
            return d.this.f1306j;
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher c() {
            return d.this.c();
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.f
        public View e(int i3) {
            return d.this.findViewById(i3);
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.f
        public boolean f() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.s
        public androidx.lifecycle.r i() {
            return d.this.i();
        }

        @Override // androidx.fragment.app.i
        public void k(Fragment fragment) {
            d.this.r(fragment);
        }

        @Override // androidx.fragment.app.i
        public LayoutInflater m() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.i
        public boolean n(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.i
        public void o() {
            d.this.u();
        }

        @Override // androidx.fragment.app.i
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public d l() {
            return d.this;
        }
    }

    static void m(int i3) {
        if ((i3 & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void p() {
        while (q(o(), androidx.lifecycle.d.b.CREATED)) {
        }
    }

    private static boolean q(l lVar, androidx.lifecycle.d.b bVar) {
        boolean zQ = false;
        for (Fragment fragment : lVar.f0()) {
            if (fragment != null) {
                if (fragment.A() != null) {
                    zQ |= q(fragment.t(), bVar);
                }
                w wVar = fragment.T;
                if (wVar != null && wVar.b().b().a(androidx.lifecycle.d.b.STARTED)) {
                    fragment.T.g(bVar);
                    zQ = true;
                }
                if (fragment.S.b().a(androidx.lifecycle.d.b.STARTED)) {
                    fragment.S.p(bVar);
                    zQ = true;
                }
            }
        }
        return zQ;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1307k);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1308l);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1309m);
        if (getApplication() != null) {
            androidx.loader.app.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1305i.u().M(str, fileDescriptor, printWriter, strArr);
    }

    final View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1305i.w(view, str, context, attributeSet);
    }

    public l o() {
        return this.f1305i.u();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        this.f1305i.v();
        int i5 = i3 >> 16;
        if (i5 == 0) {
            t.a.b bVarG = t.a.g();
            if (bVarG == null || !bVarG.a(this, i3, i4, intent)) {
                super.onActivityResult(i3, i4, intent);
                return;
            }
            return;
        }
        int i6 = i5 - 1;
        String strE = this.f1313q.e(i6);
        this.f1313q.j(i6);
        if (strE == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment fragmentT = this.f1305i.t(strE);
        if (fragmentT != null) {
            fragmentT.c0(i3 & 65535, i4, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strE);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1305i.v();
        this.f1305i.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity, t.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f1305i.a(null);
        if (bundle != null) {
            this.f1305i.x(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f1312p = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f1313q = new l.h<>(intArray.length);
                    for (int i3 = 0; i3 < intArray.length; i3++) {
                        this.f1313q.i(intArray[i3], stringArray[i3]);
                    }
                }
            }
        }
        if (this.f1313q == null) {
            this.f1313q = new l.h<>();
            this.f1312p = 0;
        }
        super.onCreate(bundle);
        this.f1306j.i(androidx.lifecycle.d.a.ON_CREATE);
        this.f1305i.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            return super.onCreatePanelMenu(i3, menu);
        }
        return this.f1305i.g(menu, getMenuInflater()) | super.onCreatePanelMenu(i3, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewN = n(view, str, context, attributeSet);
        return viewN == null ? super.onCreateView(view, str, context, attributeSet) : viewN;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f1305i.h();
        this.f1306j.i(androidx.lifecycle.d.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f1305i.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 == 0) {
            return this.f1305i.k(menuItem);
        }
        if (i3 != 6) {
            return false;
        }
        return this.f1305i.e(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        this.f1305i.j(z2);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.f1305i.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        if (i3 == 0) {
            this.f1305i.l(menu);
        }
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f1308l = false;
        this.f1305i.m();
        this.f1306j.i(androidx.lifecycle.d.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2) {
        this.f1305i.n(z2);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        t();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            return super.onPreparePanel(i3, view, menu);
        }
        return this.f1305i.o(menu) | s(view, menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.f1305i.v();
        int i4 = (i3 >> 16) & 65535;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String strE = this.f1313q.e(i5);
            this.f1313q.j(i5);
            if (strE == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment fragmentT = this.f1305i.t(strE);
            if (fragmentT != null) {
                fragmentT.B0(i3 & 65535, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strE);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f1308l = true;
        this.f1305i.v();
        this.f1305i.s();
    }

    @Override // androidx.activity.ComponentActivity, t.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        p();
        this.f1306j.i(androidx.lifecycle.d.a.ON_STOP);
        Parcelable parcelableY = this.f1305i.y();
        if (parcelableY != null) {
            bundle.putParcelable("android:support:fragments", parcelableY);
        }
        if (this.f1313q.k() > 0) {
            bundle.putInt("android:support:next_request_index", this.f1312p);
            int[] iArr = new int[this.f1313q.k()];
            String[] strArr = new String[this.f1313q.k()];
            for (int i3 = 0; i3 < this.f1313q.k(); i3++) {
                iArr[i3] = this.f1313q.h(i3);
                strArr[i3] = this.f1313q.l(i3);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f1309m = false;
        if (!this.f1307k) {
            this.f1307k = true;
            this.f1305i.c();
        }
        this.f1305i.v();
        this.f1305i.s();
        this.f1306j.i(androidx.lifecycle.d.a.ON_START);
        this.f1305i.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f1305i.v();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f1309m = true;
        p();
        this.f1305i.r();
        this.f1306j.i(androidx.lifecycle.d.a.ON_STOP);
    }

    public void r(Fragment fragment) {
    }

    @Deprecated
    protected boolean s(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i3) {
        if (!this.f1311o && i3 != -1) {
            m(i3);
        }
        super.startActivityForResult(intent, i3);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6) throws IntentSender.SendIntentException {
        if (!this.f1310n && i3 != -1) {
            m(i3);
        }
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6);
    }

    protected void t() {
        this.f1306j.i(androidx.lifecycle.d.a.ON_RESUME);
        this.f1305i.p();
    }

    @Deprecated
    public void u() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewN = n(null, str, context, attributeSet);
        return viewN == null ? super.onCreateView(str, context, attributeSet) : viewN;
    }

    @Override // android.app.Activity
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i3, Bundle bundle) {
        if (!this.f1311o && i3 != -1) {
            m(i3);
        }
        super.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.f1310n && i3 != -1) {
            m(i3);
        }
        super.startIntentSenderForResult(intentSender, i3, intent, i4, i5, i6, bundle);
    }
}
