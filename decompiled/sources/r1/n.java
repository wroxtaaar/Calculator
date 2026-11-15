package r1;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final o1.v<BigInteger> A;
    public static final o1.w B;
    public static final o1.v<StringBuilder> C;
    public static final o1.w D;
    public static final o1.v<StringBuffer> E;
    public static final o1.w F;
    public static final o1.v<URL> G;
    public static final o1.w H;
    public static final o1.v<URI> I;
    public static final o1.w J;
    public static final o1.v<InetAddress> K;
    public static final o1.w L;
    public static final o1.v<UUID> M;
    public static final o1.w N;
    public static final o1.v<Currency> O;
    public static final o1.w P;
    public static final o1.v<Calendar> Q;
    public static final o1.w R;
    public static final o1.v<Locale> S;
    public static final o1.w T;
    public static final o1.v<o1.j> U;
    public static final o1.w V;
    public static final o1.w W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1.v<Class> f6129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o1.w f6130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o1.v<BitSet> f6131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o1.w f6132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o1.v<Boolean> f6133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o1.v<Boolean> f6134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o1.w f6135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o1.v<Number> f6136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o1.w f6137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final o1.v<Number> f6138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final o1.w f6139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o1.v<Number> f6140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final o1.w f6141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final o1.v<AtomicInteger> f6142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final o1.w f6143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final o1.v<AtomicBoolean> f6144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final o1.w f6145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final o1.v<AtomicIntegerArray> f6146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final o1.w f6147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final o1.v<Number> f6148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final o1.v<Number> f6149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final o1.v<Number> f6150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final o1.v<Character> f6151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final o1.w f6152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final o1.v<String> f6153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final o1.v<BigDecimal> f6154z;

    /* JADX INFO: compiled from: TypeAdapters.java */
    class a extends o1.v<AtomicIntegerArray> {
        a() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(w1.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.j()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.p()));
                } catch (NumberFormatException e3) {
                    throw new o1.r(e3);
                }
            }
            aVar.f();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i3 = 0; i3 < size; i3++) {
                atomicIntegerArray.set(i3, ((Integer) arrayList.get(i3)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.c();
            int length = atomicIntegerArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                cVar.s(atomicIntegerArray.get(i3));
            }
            cVar.f();
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class a0 extends o1.v<Boolean> {
        a0() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(w1.a aVar) throws IOException {
            w1.b bVarX = aVar.x();
            if (bVarX != w1.b.NULL) {
                return bVarX == w1.b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.v())) : Boolean.valueOf(aVar.n());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Boolean bool) throws IOException {
            cVar.t(bool);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class b extends o1.v<Number> {
        b() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            try {
                return Long.valueOf(aVar.q());
            } catch (NumberFormatException e3) {
                throw new o1.r(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            cVar.u(number);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class b0 extends o1.v<Boolean> {
        b0() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return Boolean.valueOf(aVar.v());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Boolean bool) throws IOException {
            cVar.v(bool == null ? "null" : bool.toString());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class c extends o1.v<Number> {
        c() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return Float.valueOf((float) aVar.o());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            cVar.u(number);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class c0 extends o1.v<Number> {
        c0() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.p());
            } catch (NumberFormatException e3) {
                throw new o1.r(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            cVar.u(number);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class d extends o1.v<Number> {
        d() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return Double.valueOf(aVar.o());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            cVar.u(number);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class d0 extends o1.v<Number> {
        d0() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.p());
            } catch (NumberFormatException e3) {
                throw new o1.r(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            cVar.u(number);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class e extends o1.v<Character> {
        e() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            String strV = aVar.v();
            if (strV.length() == 1) {
                return Character.valueOf(strV.charAt(0));
            }
            throw new o1.r("Expecting character, got: " + strV);
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Character ch) throws IOException {
            cVar.v(ch == null ? null : String.valueOf(ch));
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class e0 extends o1.v<Number> {
        e0() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            try {
                return Integer.valueOf(aVar.p());
            } catch (NumberFormatException e3) {
                throw new o1.r(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Number number) throws IOException {
            cVar.u(number);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class f extends o1.v<String> {
        f() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b(w1.a aVar) throws IOException {
            w1.b bVarX = aVar.x();
            if (bVarX != w1.b.NULL) {
                return bVarX == w1.b.BOOLEAN ? Boolean.toString(aVar.n()) : aVar.v();
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, String str) throws IOException {
            cVar.v(str);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class f0 extends o1.v<AtomicInteger> {
        f0() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(w1.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.p());
            } catch (NumberFormatException e3) {
                throw new o1.r(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.s(atomicInteger.get());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class g extends o1.v<BigDecimal> {
        g() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            try {
                return new BigDecimal(aVar.v());
            } catch (NumberFormatException e3) {
                throw new o1.r(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.u(bigDecimal);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class g0 extends o1.v<AtomicBoolean> {
        g0() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(w1.a aVar) throws IOException {
            return new AtomicBoolean(aVar.n());
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.w(atomicBoolean.get());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class h extends o1.v<BigInteger> {
        h() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            try {
                return new BigInteger(aVar.v());
            } catch (NumberFormatException e3) {
                throw new o1.r(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, BigInteger bigInteger) throws IOException {
            cVar.u(bigInteger);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    private static final class h0<T extends Enum<T>> extends o1.v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f6155a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<T, String> f6156b = new HashMap();

        /* JADX INFO: compiled from: TypeAdapters.java */
        class a implements PrivilegedAction<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Field f6157a;

            a(Field field) {
                this.f6157a = field;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void run() {
                this.f6157a.setAccessible(true);
                return null;
            }
        }

        public h0(Class<T> cls) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isEnumConstant()) {
                        AccessController.doPrivileged(new a(field));
                        Enum r4 = (Enum) field.get(null);
                        String strName = r4.name();
                        p1.c cVar = (p1.c) field.getAnnotation(p1.c.class);
                        if (cVar != null) {
                            strName = cVar.value();
                            for (String str : cVar.alternate()) {
                                this.f6155a.put(str, (T) r4);
                            }
                        }
                        this.f6155a.put(strName, (T) r4);
                        this.f6156b.put((T) r4, strName);
                    }
                }
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return this.f6155a.get(aVar.v());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, T t3) throws IOException {
            cVar.v(t3 == null ? null : this.f6156b.get(t3));
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class i extends o1.v<StringBuilder> {
        i() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return new StringBuilder(aVar.v());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, StringBuilder sb) throws IOException {
            cVar.v(sb == null ? null : sb.toString());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class j extends o1.v<StringBuffer> {
        j() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return new StringBuffer(aVar.v());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.v(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class k extends o1.v<Class> {
        k() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Class b(w1.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class l extends o1.v<URL> {
        l() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public URL b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            String strV = aVar.v();
            if ("null".equals(strV)) {
                return null;
            }
            return new URL(strV);
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, URL url) throws IOException {
            cVar.v(url == null ? null : url.toExternalForm());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class m extends o1.v<URI> {
        m() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public URI b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            try {
                String strV = aVar.v();
                if ("null".equals(strV)) {
                    return null;
                }
                return new URI(strV);
            } catch (URISyntaxException e3) {
                throw new o1.k(e3);
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, URI uri) throws IOException {
            cVar.v(uri == null ? null : uri.toASCIIString());
        }
    }

    /* JADX INFO: renamed from: r1.n$n, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TypeAdapters.java */
    class C0088n extends o1.v<InetAddress> {
        C0088n() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InetAddress b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return InetAddress.getByName(aVar.v());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, InetAddress inetAddress) throws IOException {
            cVar.v(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class o extends o1.v<UUID> {
        o() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public UUID b(w1.a aVar) throws IOException {
            if (aVar.x() != w1.b.NULL) {
                return UUID.fromString(aVar.v());
            }
            aVar.t();
            return null;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, UUID uuid) throws IOException {
            cVar.v(uuid == null ? null : uuid.toString());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class p extends o1.v<Currency> {
        p() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Currency b(w1.a aVar) throws IOException {
            return Currency.getInstance(aVar.v());
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Currency currency) throws IOException {
            cVar.v(currency.getCurrencyCode());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class q extends o1.v<Calendar> {
        q() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Calendar b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            aVar.b();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (aVar.x() != w1.b.END_OBJECT) {
                String strR = aVar.r();
                int iP = aVar.p();
                if ("year".equals(strR)) {
                    i3 = iP;
                } else if ("month".equals(strR)) {
                    i4 = iP;
                } else if ("dayOfMonth".equals(strR)) {
                    i5 = iP;
                } else if ("hourOfDay".equals(strR)) {
                    i6 = iP;
                } else if ("minute".equals(strR)) {
                    i7 = iP;
                } else if ("second".equals(strR)) {
                    i8 = iP;
                }
            }
            aVar.g();
            return new GregorianCalendar(i3, i4, i5, i6, i7, i8);
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.l();
                return;
            }
            cVar.d();
            cVar.j("year");
            cVar.s(calendar.get(1));
            cVar.j("month");
            cVar.s(calendar.get(2));
            cVar.j("dayOfMonth");
            cVar.s(calendar.get(5));
            cVar.j("hourOfDay");
            cVar.s(calendar.get(11));
            cVar.j("minute");
            cVar.s(calendar.get(12));
            cVar.j("second");
            cVar.s(calendar.get(13));
            cVar.g();
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class r extends o1.v<Locale> {
        r() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Locale b(w1.a aVar) throws IOException {
            if (aVar.x() == w1.b.NULL) {
                aVar.t();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.v(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, Locale locale) throws IOException {
            cVar.v(locale == null ? null : locale.toString());
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class s extends o1.v<o1.j> {
        s() {
        }

        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public o1.j b(w1.a aVar) throws IOException {
            if (aVar instanceof r1.f) {
                return ((r1.f) aVar).K();
            }
            switch (z.f6171a[aVar.x().ordinal()]) {
                case 1:
                    return new o1.o(new q1.g(aVar.v()));
                case 2:
                    return new o1.o(Boolean.valueOf(aVar.n()));
                case 3:
                    return new o1.o(aVar.v());
                case 4:
                    aVar.t();
                    return o1.l.f5448a;
                case 5:
                    o1.g gVar = new o1.g();
                    aVar.a();
                    while (aVar.j()) {
                        gVar.h(b(aVar));
                    }
                    aVar.f();
                    return gVar;
                case 6:
                    o1.m mVar = new o1.m();
                    aVar.b();
                    while (aVar.j()) {
                        mVar.h(aVar.r(), b(aVar));
                    }
                    aVar.g();
                    return mVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, o1.j jVar) throws IOException {
            if (jVar == null || jVar.e()) {
                cVar.l();
                return;
            }
            if (jVar.g()) {
                o1.o oVarC = jVar.c();
                if (oVarC.p()) {
                    cVar.u(oVarC.l());
                    return;
                } else if (oVarC.n()) {
                    cVar.w(oVarC.h());
                    return;
                } else {
                    cVar.v(oVarC.m());
                    return;
                }
            }
            if (jVar.d()) {
                cVar.c();
                Iterator<o1.j> it = jVar.a().iterator();
                while (it.hasNext()) {
                    d(cVar, it.next());
                }
                cVar.f();
                return;
            }
            if (!jVar.f()) {
                throw new IllegalArgumentException("Couldn't write " + jVar.getClass());
            }
            cVar.d();
            for (Map.Entry<String, o1.j> entry : jVar.b().i()) {
                cVar.j(entry.getKey());
                d(cVar, entry.getValue());
            }
            cVar.g();
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class t implements o1.w {
        t() {
        }

        @Override // o1.w
        public <T> o1.v<T> a(o1.e eVar, v1.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (!Enum.class.isAssignableFrom(clsC) || clsC == Enum.class) {
                return null;
            }
            if (!clsC.isEnum()) {
                clsC = clsC.getSuperclass();
            }
            return new h0(clsC);
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class u extends o1.v<BitSet> {
        u() {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x002e  */
        @Override // o1.v
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public BitSet b(w1.a aVar) throws IOException {
            BitSet bitSet = new BitSet();
            aVar.a();
            w1.b bVarX = aVar.x();
            int i3 = 0;
            while (bVarX != w1.b.END_ARRAY) {
                int i4 = z.f6171a[bVarX.ordinal()];
                boolean zN = true;
                if (i4 != 1) {
                    if (i4 == 2) {
                        zN = aVar.n();
                    } else {
                        if (i4 != 3) {
                            throw new o1.r("Invalid bitset value type: " + bVarX);
                        }
                        String strV = aVar.v();
                        try {
                            if (Integer.parseInt(strV) == 0) {
                                zN = false;
                            }
                        } catch (NumberFormatException unused) {
                            throw new o1.r("Error: Expecting: bitset number value (1, 0), Found: " + strV);
                        }
                    }
                } else if (aVar.p() == 0) {
                    zN = false;
                }
                if (zN) {
                    bitSet.set(i3);
                }
                i3++;
                bVarX = aVar.x();
            }
            aVar.f();
            return bitSet;
        }

        @Override // o1.v
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(w1.c cVar, BitSet bitSet) throws IOException {
            cVar.c();
            int length = bitSet.length();
            for (int i3 = 0; i3 < length; i3++) {
                cVar.s(bitSet.get(i3) ? 1L : 0L);
            }
            cVar.f();
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class v implements o1.w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f6159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o1.v f6160c;

        v(Class cls, o1.v vVar) {
            this.f6159b = cls;
            this.f6160c = vVar;
        }

        @Override // o1.w
        public <T> o1.v<T> a(o1.e eVar, v1.a<T> aVar) {
            if (aVar.c() == this.f6159b) {
                return this.f6160c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f6159b.getName() + ",adapter=" + this.f6160c + "]";
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class w implements o1.w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f6161b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f6162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o1.v f6163d;

        w(Class cls, Class cls2, o1.v vVar) {
            this.f6161b = cls;
            this.f6162c = cls2;
            this.f6163d = vVar;
        }

        @Override // o1.w
        public <T> o1.v<T> a(o1.e eVar, v1.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (clsC == this.f6161b || clsC == this.f6162c) {
                return this.f6163d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f6162c.getName() + "+" + this.f6161b.getName() + ",adapter=" + this.f6163d + "]";
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class x implements o1.w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f6164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f6165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o1.v f6166d;

        x(Class cls, Class cls2, o1.v vVar) {
            this.f6164b = cls;
            this.f6165c = cls2;
            this.f6166d = vVar;
        }

        @Override // o1.w
        public <T> o1.v<T> a(o1.e eVar, v1.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (clsC == this.f6164b || clsC == this.f6165c) {
                return this.f6166d;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f6164b.getName() + "+" + this.f6165c.getName() + ",adapter=" + this.f6166d + "]";
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    class y implements o1.w {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f6167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o1.v f6168c;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* JADX INFO: compiled from: TypeAdapters.java */
        class a<T1> extends o1.v<T1> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f6169a;

            a(Class cls) {
                this.f6169a = cls;
            }

            @Override // o1.v
            public T1 b(w1.a aVar) throws IOException {
                T1 t3 = (T1) y.this.f6168c.b(aVar);
                if (t3 == null || this.f6169a.isInstance(t3)) {
                    return t3;
                }
                throw new o1.r("Expected a " + this.f6169a.getName() + " but was " + t3.getClass().getName());
            }

            @Override // o1.v
            public void d(w1.c cVar, T1 t3) throws IOException {
                y.this.f6168c.d(cVar, t3);
            }
        }

        y(Class cls, o1.v vVar) {
            this.f6167b = cls;
            this.f6168c = vVar;
        }

        @Override // o1.w
        public <T2> o1.v<T2> a(o1.e eVar, v1.a<T2> aVar) {
            Class<? super T2> clsC = aVar.c();
            if (this.f6167b.isAssignableFrom(clsC)) {
                return new a(clsC);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f6167b.getName() + ",adapter=" + this.f6168c + "]";
        }
    }

    /* JADX INFO: compiled from: TypeAdapters.java */
    static /* synthetic */ class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6171a;

        static {
            int[] iArr = new int[w1.b.values().length];
            f6171a = iArr;
            try {
                iArr[w1.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6171a[w1.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6171a[w1.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6171a[w1.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6171a[w1.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6171a[w1.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6171a[w1.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6171a[w1.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6171a[w1.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6171a[w1.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static {
        o1.v<Class> vVarA = new k().a();
        f6129a = vVarA;
        f6130b = b(Class.class, vVarA);
        o1.v<BitSet> vVarA2 = new u().a();
        f6131c = vVarA2;
        f6132d = b(BitSet.class, vVarA2);
        a0 a0Var = new a0();
        f6133e = a0Var;
        f6134f = new b0();
        f6135g = a(Boolean.TYPE, Boolean.class, a0Var);
        c0 c0Var = new c0();
        f6136h = c0Var;
        f6137i = a(Byte.TYPE, Byte.class, c0Var);
        d0 d0Var = new d0();
        f6138j = d0Var;
        f6139k = a(Short.TYPE, Short.class, d0Var);
        e0 e0Var = new e0();
        f6140l = e0Var;
        f6141m = a(Integer.TYPE, Integer.class, e0Var);
        o1.v<AtomicInteger> vVarA3 = new f0().a();
        f6142n = vVarA3;
        f6143o = b(AtomicInteger.class, vVarA3);
        o1.v<AtomicBoolean> vVarA4 = new g0().a();
        f6144p = vVarA4;
        f6145q = b(AtomicBoolean.class, vVarA4);
        o1.v<AtomicIntegerArray> vVarA5 = new a().a();
        f6146r = vVarA5;
        f6147s = b(AtomicIntegerArray.class, vVarA5);
        f6148t = new b();
        f6149u = new c();
        f6150v = new d();
        e eVar = new e();
        f6151w = eVar;
        f6152x = a(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f6153y = fVar;
        f6154z = new g();
        A = new h();
        B = b(String.class, fVar);
        i iVar = new i();
        C = iVar;
        D = b(StringBuilder.class, iVar);
        j jVar = new j();
        E = jVar;
        F = b(StringBuffer.class, jVar);
        l lVar = new l();
        G = lVar;
        H = b(URL.class, lVar);
        m mVar = new m();
        I = mVar;
        J = b(URI.class, mVar);
        C0088n c0088n = new C0088n();
        K = c0088n;
        L = d(InetAddress.class, c0088n);
        o oVar = new o();
        M = oVar;
        N = b(UUID.class, oVar);
        o1.v<Currency> vVarA6 = new p().a();
        O = vVarA6;
        P = b(Currency.class, vVarA6);
        q qVar = new q();
        Q = qVar;
        R = c(Calendar.class, GregorianCalendar.class, qVar);
        r rVar = new r();
        S = rVar;
        T = b(Locale.class, rVar);
        s sVar = new s();
        U = sVar;
        V = d(o1.j.class, sVar);
        W = new t();
    }

    public static <TT> o1.w a(Class<TT> cls, Class<TT> cls2, o1.v<? super TT> vVar) {
        return new w(cls, cls2, vVar);
    }

    public static <TT> o1.w b(Class<TT> cls, o1.v<TT> vVar) {
        return new v(cls, vVar);
    }

    public static <TT> o1.w c(Class<TT> cls, Class<? extends TT> cls2, o1.v<? super TT> vVar) {
        return new x(cls, cls2, vVar);
    }

    public static <T1> o1.w d(Class<T1> cls, o1.v<T1> vVar) {
        return new y(cls, vVar);
    }
}
