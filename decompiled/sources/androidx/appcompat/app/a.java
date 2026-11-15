package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import b.f;

/* JADX INFO: compiled from: AlertDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AlertController f118d;

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlertDialog.java */
    public static class C0000a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlertController.f f119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f120b;

        public C0000a(Context context) {
            this(context, a.i(context, 0));
        }

        public a a() {
            a aVar = new a(this.f119a.f79a, this.f120b);
            this.f119a.a(aVar.f118d);
            aVar.setCancelable(this.f119a.f96r);
            if (this.f119a.f96r) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.f119a.f97s);
            aVar.setOnDismissListener(this.f119a.f98t);
            DialogInterface.OnKeyListener onKeyListener = this.f119a.f99u;
            if (onKeyListener != null) {
                aVar.setOnKeyListener(onKeyListener);
            }
            return aVar;
        }

        public Context b() {
            return this.f119a.f79a;
        }

        public C0000a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f101w = listAdapter;
            fVar.f102x = onClickListener;
            return this;
        }

        public C0000a d(View view) {
            this.f119a.f85g = view;
            return this;
        }

        public C0000a e(Drawable drawable) {
            this.f119a.f82d = drawable;
            return this;
        }

        public C0000a f(int i3) {
            AlertController.f fVar = this.f119a;
            fVar.f86h = fVar.f79a.getText(i3);
            return this;
        }

        public C0000a g(CharSequence charSequence) {
            this.f119a.f86h = charSequence;
            return this;
        }

        public C0000a h(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f100v = charSequenceArr;
            fVar.J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public C0000a i(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f90l = fVar.f79a.getText(i3);
            this.f119a.f92n = onClickListener;
            return this;
        }

        public C0000a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f90l = charSequence;
            fVar.f92n = onClickListener;
            return this;
        }

        public C0000a k(DialogInterface.OnKeyListener onKeyListener) {
            this.f119a.f99u = onKeyListener;
            return this;
        }

        public C0000a l(int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f87i = fVar.f79a.getText(i3);
            this.f119a.f89k = onClickListener;
            return this;
        }

        public C0000a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f87i = charSequence;
            fVar.f89k = onClickListener;
            return this;
        }

        public C0000a n(ListAdapter listAdapter, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f101w = listAdapter;
            fVar.f102x = onClickListener;
            fVar.I = i3;
            fVar.H = true;
            return this;
        }

        public C0000a o(CharSequence[] charSequenceArr, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f119a;
            fVar.f100v = charSequenceArr;
            fVar.f102x = onClickListener;
            fVar.I = i3;
            fVar.H = true;
            return this;
        }

        public C0000a p(CharSequence charSequence) {
            this.f119a.f84f = charSequence;
            return this;
        }

        public C0000a q(View view) {
            AlertController.f fVar = this.f119a;
            fVar.f104z = view;
            fVar.f103y = 0;
            fVar.E = false;
            return this;
        }

        public C0000a(Context context, int i3) {
            this.f119a = new AlertController.f(new ContextThemeWrapper(context, a.i(context, i3)));
            this.f120b = i3;
        }
    }

    protected a(Context context, int i3) {
        super(context, i(context, i3));
        this.f118d = new AlertController(getContext(), this, getWindow());
    }

    static int i(Context context, int i3) {
        if (((i3 >>> 24) & 255) >= 1) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button f(int i3) {
        return this.f118d.c(i3);
    }

    public ListView g() {
        return this.f118d.e();
    }

    @Override // b.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f118d.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (this.f118d.h(i3, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (this.f118d.i(i3, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i3, keyEvent);
    }

    @Override // b.f, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f118d.r(charSequence);
    }
}
