package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1136a = (IconCompat) aVar.v(remoteActionCompat.f1136a, 1);
        remoteActionCompat.f1137b = aVar.l(remoteActionCompat.f1137b, 2);
        remoteActionCompat.f1138c = aVar.l(remoteActionCompat.f1138c, 3);
        remoteActionCompat.f1139d = (PendingIntent) aVar.r(remoteActionCompat.f1139d, 4);
        remoteActionCompat.f1140e = aVar.h(remoteActionCompat.f1140e, 5);
        remoteActionCompat.f1141f = aVar.h(remoteActionCompat.f1141f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f1136a, 1);
        aVar.D(remoteActionCompat.f1137b, 2);
        aVar.D(remoteActionCompat.f1138c, 3);
        aVar.H(remoteActionCompat.f1139d, 4);
        aVar.z(remoteActionCompat.f1140e, 5);
        aVar.z(remoteActionCompat.f1141f, 6);
    }
}
