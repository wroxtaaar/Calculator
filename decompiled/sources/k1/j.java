package k1;

/* JADX INFO: compiled from: RoundedCornerTreatment.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f5126a = -1.0f;

    @Override // k1.d
    public void a(m mVar, float f3, float f4, float f5) {
        mVar.o(0.0f, f5 * f4, 180.0f, 180.0f - f3);
        float f6 = f5 * 2.0f * f4;
        mVar.a(0.0f, 0.0f, f6, f6, 180.0f, f3);
    }
}
