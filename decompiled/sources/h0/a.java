package h0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: compiled from: CursorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, h0.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f4830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f4831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Cursor f4832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Context f4833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f4834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected C0063a f4835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected DataSetObserver f4836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected h0.b f4837i;

    /* JADX INFO: renamed from: h0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CursorAdapter.java */
    private class C0063a extends ContentObserver {
        C0063a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            a.this.i();
        }
    }

    /* JADX INFO: compiled from: CursorAdapter.java */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f4830b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f4830b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z2) {
        f(context, cursor, z2 ? 1 : 2);
    }

    public abstract CharSequence a(Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    @Override // h0.b.a
    public Cursor c() {
        return this.f4832d;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i3) {
        if ((i3 & 1) == 1) {
            i3 |= 2;
            this.f4831c = true;
        } else {
            this.f4831c = false;
        }
        boolean z2 = cursor != null;
        this.f4832d = cursor;
        this.f4830b = z2;
        this.f4833e = context;
        this.f4834f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i3 & 2) == 2) {
            this.f4835g = new C0063a();
            this.f4836h = new b();
        } else {
            this.f4835g = null;
            this.f4836h = null;
        }
        if (z2) {
            C0063a c0063a = this.f4835g;
            if (c0063a != null) {
                cursor.registerContentObserver(c0063a);
            }
            DataSetObserver dataSetObserver = this.f4836h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f4830b || (cursor = this.f4832d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f4830b) {
            return null;
        }
        this.f4832d.moveToPosition(i3);
        if (view == null) {
            view = g(this.f4833e, this.f4832d, viewGroup);
        }
        e(view, this.f4833e, this.f4832d);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f4837i == null) {
            this.f4837i = new h0.b(this);
        }
        return this.f4837i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        Cursor cursor;
        if (!this.f4830b || (cursor = this.f4832d) == null) {
            return null;
        }
        cursor.moveToPosition(i3);
        return this.f4832d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        Cursor cursor;
        if (this.f4830b && (cursor = this.f4832d) != null && cursor.moveToPosition(i3)) {
            return this.f4832d.getLong(this.f4834f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f4830b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f4832d.moveToPosition(i3)) {
            if (view == null) {
                view = h(this.f4833e, this.f4832d, viewGroup);
            }
            e(view, this.f4833e, this.f4832d);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i3);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f4831c || (cursor = this.f4832d) == null || cursor.isClosed()) {
            return;
        }
        this.f4830b = this.f4832d.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f4832d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0063a c0063a = this.f4835g;
            if (c0063a != null) {
                cursor2.unregisterContentObserver(c0063a);
            }
            DataSetObserver dataSetObserver = this.f4836h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f4832d = cursor;
        if (cursor != null) {
            C0063a c0063a2 = this.f4835g;
            if (c0063a2 != null) {
                cursor.registerContentObserver(c0063a2);
            }
            DataSetObserver dataSetObserver2 = this.f4836h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f4834f = cursor.getColumnIndexOrThrow("_id");
            this.f4830b = true;
            notifyDataSetChanged();
        } else {
            this.f4834f = -1;
            this.f4830b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
