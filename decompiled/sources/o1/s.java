package o1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LongSerializationPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f5451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f5452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ s[] f5453d;

    /* JADX INFO: compiled from: LongSerializationPolicy.java */
    final enum a extends s {
        a(String str, int i3) {
            super(str, i3, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f5451b = aVar;
        s sVar = new s("STRING", 1) { // from class: o1.s.b
            {
                a aVar2 = null;
            }
        };
        f5452c = sVar;
        f5453d = new s[]{aVar, sVar};
    }

    private s(String str, int i3) {
        super(str, i3);
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f5453d.clone();
    }

    /* synthetic */ s(String str, int i3, a aVar) {
        this(str, i3);
    }
}
