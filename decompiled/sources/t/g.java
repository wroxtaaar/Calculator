package t;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TaskStackBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Iterable<Intent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<Intent> f6233b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f6234c;

    /* JADX INFO: compiled from: TaskStackBuilder.java */
    public interface a {
        Intent g();
    }

    private g(Context context) {
        this.f6234c = context;
    }

    public static g d(Context context) {
        return new g(context);
    }

    public g a(Intent intent) {
        this.f6233b.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g b(Activity activity) {
        Intent intentG = activity instanceof a ? ((a) activity).g() : null;
        if (intentG == null) {
            intentG = e.a(activity);
        }
        if (intentG != null) {
            ComponentName component = intentG.getComponent();
            if (component == null) {
                component = intentG.resolveActivity(this.f6234c.getPackageManager());
            }
            c(component);
            a(intentG);
        }
        return this;
    }

    public g c(ComponentName componentName) {
        int size = this.f6233b.size();
        try {
            Intent intentB = e.b(this.f6234c, componentName);
            while (intentB != null) {
                this.f6233b.add(size, intentB);
                intentB = e.b(this.f6234c, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e3);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f6233b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f6233b;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (u.a.e(this.f6234c, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f6234c.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f6233b.iterator();
    }
}
