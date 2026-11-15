package b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: compiled from: TwilightManager.java */
/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static j f2329d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationManager f2331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2332c = new a();

    /* JADX INFO: compiled from: TwilightManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f2336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f2337e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f2338f;

        a() {
        }
    }

    j(Context context, LocationManager locationManager) {
        this.f2330a = context;
        this.f2331b = locationManager;
    }

    static j a(Context context) {
        if (f2329d == null) {
            Context applicationContext = context.getApplicationContext();
            f2329d = new j(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f2329d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationC = u.b.b(this.f2330a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = u.b.b(this.f2330a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.f2331b.isProviderEnabled(str)) {
                return this.f2331b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e3) {
            Log.d("TwilightManager", "Failed to get last known location", e3);
            return null;
        }
    }

    private boolean e() {
        return this.f2332c.f2338f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j3;
        long j4;
        a aVar = this.f2332c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        i iVarB = i.b();
        iVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j5 = iVarB.f2326a;
        iVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z2 = iVarB.f2328c == 1;
        long j6 = iVarB.f2327b;
        long j7 = iVarB.f2326a;
        iVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j8 = iVarB.f2327b;
        if (j6 == -1 || j7 == -1) {
            j3 = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j7) {
                j4 = 0 + j8;
            } else {
                j4 = jCurrentTimeMillis > j6 ? 0 + j7 : 0 + j6;
            }
            j3 = j4 + 60000;
        }
        aVar.f2333a = z2;
        aVar.f2334b = j5;
        aVar.f2335c = j6;
        aVar.f2336d = j7;
        aVar.f2337e = j8;
        aVar.f2338f = j3;
    }

    boolean d() {
        a aVar = this.f2332c;
        if (e()) {
            return aVar.f2333a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f2333a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i3 = Calendar.getInstance().get(11);
        return i3 < 6 || i3 >= 22;
    }
}
