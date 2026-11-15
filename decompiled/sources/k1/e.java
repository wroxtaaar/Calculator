package k1;

/* JADX INFO: compiled from: CutCornerTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f5074a = -1.0f;

    @Override // k1.d
    public void a(m mVar, float f3, float f4, float f5) {
        mVar.o(0.0f, f5 * f4, 180.0f, 180.0f - f3);
        double d3 = f5;
        double d4 = f4;
        mVar.m((float) (Math.sin(Math.toRadians(f3)) * d3 * d4), (float) (Math.sin(Math.toRadians(90.0f - f3)) * d3 * d4));
    }
}
