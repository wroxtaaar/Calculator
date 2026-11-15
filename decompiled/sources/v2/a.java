package v2;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;

/* JADX INFO: compiled from: BezierUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static ArrayList<PointF> a(ArrayList<PointF> arrayList) {
        ArrayList<PointF> arrayList2 = new ArrayList<>();
        int size = arrayList.size() - 1;
        for (float f3 = 0.0f; f3 <= 1.0f; f3 += 0.001f) {
            arrayList2.add(new PointF(c(size, 0, f3, arrayList), d(size, 0, f3, arrayList)));
        }
        return arrayList2;
    }

    public static Path b(PointF... pointFArr) {
        ArrayList arrayList = new ArrayList();
        Path path = new Path();
        arrayList.add(new PointF(0.0f, 0.0f));
        for (PointF pointF : pointFArr) {
            arrayList.add(pointF);
        }
        arrayList.add(new PointF(1.0f, 1.0f));
        ArrayList<PointF> arrayListA = a(arrayList);
        path.reset();
        path.moveTo(0.0f, 0.0f);
        for (PointF pointF2 : arrayListA) {
            path.lineTo(pointF2.x, pointF2.y);
        }
        path.lineTo(1.0f, 1.0f);
        return path;
    }

    private static float c(int i3, int i4, float f3, ArrayList<PointF> arrayList) {
        float fC;
        float fC2;
        if (i3 == 1) {
            fC = (1.0f - f3) * arrayList.get(i4).x;
            fC2 = arrayList.get(i4 + 1).x;
        } else {
            int i5 = i3 - 1;
            fC = (1.0f - f3) * c(i5, i4, f3, arrayList);
            fC2 = c(i5, i4 + 1, f3, arrayList);
        }
        return fC + (f3 * fC2);
    }

    private static float d(int i3, int i4, float f3, ArrayList<PointF> arrayList) {
        float fD;
        float fD2;
        if (i3 == 1) {
            fD = (1.0f - f3) * arrayList.get(i4).y;
            fD2 = arrayList.get(i4 + 1).y;
        } else {
            int i5 = i3 - 1;
            fD = (1.0f - f3) * d(i5, i4, f3, arrayList);
            fD2 = d(i5, i4 + 1, f3, arrayList);
        }
        return fD + (f3 * fD2);
    }
}
