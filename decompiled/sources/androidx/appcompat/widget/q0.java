package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.vivo.seckeysdk.BuildConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SuggestionsAdapter.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
class q0 extends h0.c implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SearchView f738m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final SearchableInfo f739n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f740o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f741p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f742q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f743r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f744s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ColorStateList f745t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f746u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f747v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f748w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f749x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f750y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f751z;

    /* JADX INFO: compiled from: SuggestionsAdapter.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f755d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f756e;

        public a(View view) {
            this.f752a = (TextView) view.findViewById(R.id.text1);
            this.f753b = (TextView) view.findViewById(R.id.text2);
            this.f754c = (ImageView) view.findViewById(R.id.icon1);
            this.f755d = (ImageView) view.findViewById(R.id.icon2);
            this.f756e = (ImageView) view.findViewById(a.f.edit_query);
        }
    }

    public q0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f743r = false;
        this.f744s = 1;
        this.f746u = -1;
        this.f747v = -1;
        this.f748w = -1;
        this.f749x = -1;
        this.f750y = -1;
        this.f751z = -1;
        this.f738m = searchView;
        this.f739n = searchableInfo;
        this.f742q = searchView.getSuggestionCommitIconResId();
        this.f740o = context;
        this.f741p = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f741p.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.f741p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f745t == null) {
            TypedValue typedValue = new TypedValue();
            this.f4833e.getTheme().resolveAttribute(a.a.textColorSearchUrl, typedValue, true);
            this.f745t = this.f4833e.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f745t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f4833e.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("SuggestionsAdapter", e3.toString());
            return null;
        }
    }

    private Drawable n(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f741p.containsKey(strFlattenToShortString)) {
            Drawable drawableM = m(componentName);
            this.f741p.put(strFlattenToShortString, drawableM != null ? drawableM.getConstantState() : null);
            return drawableM;
        }
        Drawable.ConstantState constantState = this.f741p.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f740o.getResources());
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p() {
        Drawable drawableN = n(this.f739n.getSearchActivity());
        return drawableN != null ? drawableN : this.f4833e.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f740o.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e3) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e3);
                }
                return drawableCreateFromStream;
            } catch (Throwable th) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e4) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i3 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f740o.getPackageName() + "/" + i3;
            Drawable drawableK = k(str2);
            if (drawableK != null) {
                return drawableK;
            }
            Drawable drawableD = u.a.d(this.f740o, i3);
            A(str2, drawableD);
            return drawableD;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableK2 = k(str);
            if (drawableK2 != null) {
                return drawableK2;
            }
            Drawable drawableQ = q(Uri.parse(str));
            A(str, drawableQ);
            return drawableQ;
        }
    }

    private Drawable t(Cursor cursor) {
        int i3 = this.f749x;
        if (i3 == -1) {
            return null;
        }
        Drawable drawableS = s(cursor.getString(i3));
        return drawableS != null ? drawableS : p();
    }

    private Drawable u(Cursor cursor) {
        int i3 = this.f750y;
        if (i3 == -1) {
            return null;
        }
        return s(cursor.getString(i3));
    }

    private static String w(Cursor cursor, int i3) {
        if (i3 == -1) {
            return null;
        }
        try {
            return cursor.getString(i3);
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e3);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i3) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i3);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    @Override // h0.a, h0.b.a
    public CharSequence a(Cursor cursor) {
        String strO;
        String strO2;
        if (cursor == null) {
            return null;
        }
        String strO3 = o(cursor, "suggest_intent_query");
        if (strO3 != null) {
            return strO3;
        }
        if (this.f739n.shouldRewriteQueryFromData() && (strO2 = o(cursor, "suggest_intent_data")) != null) {
            return strO2;
        }
        if (!this.f739n.shouldRewriteQueryFromText() || (strO = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strO;
    }

    @Override // h0.a, h0.b.a
    public void b(Cursor cursor) {
        if (this.f743r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f746u = cursor.getColumnIndex("suggest_text_1");
                this.f747v = cursor.getColumnIndex("suggest_text_2");
                this.f748w = cursor.getColumnIndex("suggest_text_2_url");
                this.f749x = cursor.getColumnIndex("suggest_icon_1");
                this.f750y = cursor.getColumnIndex("suggest_icon_2");
                this.f751z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e3);
        }
    }

    @Override // h0.b.a
    public Cursor d(CharSequence charSequence) {
        String string = charSequence == null ? BuildConfig.FLAVOR : charSequence.toString();
        if (this.f738m.getVisibility() == 0 && this.f738m.getWindowVisibility() == 0) {
            try {
                Cursor cursorV = v(this.f739n, string, 50);
                if (cursorV != null) {
                    cursorV.getCount();
                    return cursorV;
                }
            } catch (RuntimeException e3) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e3);
            }
        }
        return null;
    }

    @Override // h0.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i3 = this.f751z;
        int i4 = i3 != -1 ? cursor.getInt(i3) : 0;
        if (aVar.f752a != null) {
            z(aVar.f752a, w(cursor, this.f746u));
        }
        if (aVar.f753b != null) {
            String strW = w(cursor, this.f748w);
            CharSequence charSequenceL = strW != null ? l(strW) : w(cursor, this.f747v);
            if (TextUtils.isEmpty(charSequenceL)) {
                TextView textView = aVar.f752a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f752a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f752a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f752a.setMaxLines(1);
                }
            }
            z(aVar.f753b, charSequenceL);
        }
        ImageView imageView = aVar.f754c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f755d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i5 = this.f744s;
        if (i5 != 2 && (i5 != 1 || (i4 & 1) == 0)) {
            aVar.f756e.setVisibility(8);
            return;
        }
        aVar.f756e.setVisibility(0);
        aVar.f756e.setTag(aVar.f752a.getText());
        aVar.f756e.setOnClickListener(this);
    }

    @Override // h0.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewG = g(this.f4833e, this.f4832d, viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f752a.setText(e3.toString());
            }
            return viewG;
        }
    }

    @Override // h0.a, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewH = h(this.f4833e, this.f4832d, viewGroup);
            if (viewH != null) {
                ((a) viewH.getTag()).f752a.setText(e3.toString());
            }
            return viewH;
        }
    }

    @Override // h0.c, h0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewH = super.h(context, cursor, viewGroup);
        viewH.setTag(new a(viewH));
        ((ImageView) viewH.findViewById(a.f.edit_query)).setImageResource(this.f742q);
        return viewH;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(c());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f738m.U((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f4833e.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i3) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i3 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i3));
        }
        return this.f4833e.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i3) {
        this.f744s = i3;
    }
}
