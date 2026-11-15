package t1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import o1.k;

/* JADX INFO: compiled from: UnsafeReflectionAccessor.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Class f6236d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f6237b = d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Field f6238c = c();

    c() {
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object d() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f6236d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // t1.b
    public void b(AccessibleObject accessibleObject) {
        if (e(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e3) {
            throw new k("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e3);
        }
    }

    boolean e(AccessibleObject accessibleObject) {
        if (this.f6237b != null && this.f6238c != null) {
            try {
                f6236d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f6237b, accessibleObject, Long.valueOf(((Long) f6236d.getMethod("objectFieldOffset", Field.class).invoke(this.f6237b, this.f6238c)).longValue()), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
