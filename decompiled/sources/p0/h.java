package p0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: compiled from: PathProperty.java */
/* JADX INFO: loaded from: classes.dex */
class h<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Property<T, PointF> f5648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathMeasure f5649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f5650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f5651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PointF f5652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f5653f;

    h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f5651d = new float[2];
        this.f5652e = new PointF();
        this.f5648a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f5649b = pathMeasure;
        this.f5650c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t3) {
        return Float.valueOf(this.f5653f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t3, Float f3) {
        this.f5653f = f3.floatValue();
        this.f5649b.getPosTan(this.f5650c * f3.floatValue(), this.f5651d, null);
        PointF pointF = this.f5652e;
        float[] fArr = this.f5651d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f5648a.set(t3, pointF);
    }
}
