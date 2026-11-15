package c0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: compiled from: PrecomputedTextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Spannable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f2465e = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Spannable f2466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PrecomputedText f2468d;

    public a a() {
        return this.f2467c;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f2466b;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return this.f2466b.charAt(i3);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2466b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2466b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2466b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i3, int i4, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f2468d.getSpans(i3, i4, cls) : (T[]) this.f2466b.getSpans(i3, i4, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2466b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        return this.f2466b.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2468d.removeSpan(obj);
        } else {
            this.f2466b.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i3, int i4, int i5) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2468d.setSpan(obj, i3, i4, i5);
        } else {
            this.f2466b.setSpan(obj, i3, i4, i5);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return this.f2466b.subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2466b.toString();
    }

    /* JADX INFO: compiled from: PrecomputedTextCompat.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextPaint f2469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f2470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f2472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f2473e;

        /* JADX INFO: renamed from: c0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PrecomputedTextCompat.java */
        public static class C0032a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final TextPaint f2474a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f2475b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f2476c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f2477d;

            public C0032a(TextPaint textPaint) {
                this.f2474a = textPaint;
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 23) {
                    this.f2476c = 1;
                    this.f2477d = 1;
                } else {
                    this.f2477d = 0;
                    this.f2476c = 0;
                }
                if (i3 >= 18) {
                    this.f2475b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2475b = null;
                }
            }

            public a a() {
                return new a(this.f2474a, this.f2475b, this.f2476c, this.f2477d);
            }

            public C0032a b(int i3) {
                this.f2476c = i3;
                return this;
            }

            public C0032a c(int i3) {
                this.f2477d = i3;
                return this;
            }

            public C0032a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2475b = textDirectionHeuristic;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i3, int i4) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2473e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i3).setHyphenationFrequency(i4).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2473e = null;
            }
            this.f2469a = textPaint;
            this.f2470b = textDirectionHeuristic;
            this.f2471c = i3;
            this.f2472d = i4;
        }

        public boolean a(a aVar) {
            int i3 = Build.VERSION.SDK_INT;
            if ((i3 >= 23 && (this.f2471c != aVar.b() || this.f2472d != aVar.c())) || this.f2469a.getTextSize() != aVar.e().getTextSize() || this.f2469a.getTextScaleX() != aVar.e().getTextScaleX() || this.f2469a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i3 >= 21 && (this.f2469a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f2469a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f2469a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i3 >= 24) {
                if (!this.f2469a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (i3 >= 17 && !this.f2469a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.f2469a.getTypeface() == null) {
                return aVar.e().getTypeface() == null;
            }
            return this.f2469a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f2471c;
        }

        public int c() {
            return this.f2472d;
        }

        public TextDirectionHeuristic d() {
            return this.f2470b;
        }

        public TextPaint e() {
            return this.f2469a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.f2470b == aVar.d();
            }
            return false;
        }

        public int hashCode() {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                return d0.d.b(Float.valueOf(this.f2469a.getTextSize()), Float.valueOf(this.f2469a.getTextScaleX()), Float.valueOf(this.f2469a.getTextSkewX()), Float.valueOf(this.f2469a.getLetterSpacing()), Integer.valueOf(this.f2469a.getFlags()), this.f2469a.getTextLocales(), this.f2469a.getTypeface(), Boolean.valueOf(this.f2469a.isElegantTextHeight()), this.f2470b, Integer.valueOf(this.f2471c), Integer.valueOf(this.f2472d));
            }
            if (i3 >= 21) {
                return d0.d.b(Float.valueOf(this.f2469a.getTextSize()), Float.valueOf(this.f2469a.getTextScaleX()), Float.valueOf(this.f2469a.getTextSkewX()), Float.valueOf(this.f2469a.getLetterSpacing()), Integer.valueOf(this.f2469a.getFlags()), this.f2469a.getTextLocale(), this.f2469a.getTypeface(), Boolean.valueOf(this.f2469a.isElegantTextHeight()), this.f2470b, Integer.valueOf(this.f2471c), Integer.valueOf(this.f2472d));
            }
            if (i3 >= 18) {
                return d0.d.b(Float.valueOf(this.f2469a.getTextSize()), Float.valueOf(this.f2469a.getTextScaleX()), Float.valueOf(this.f2469a.getTextSkewX()), Integer.valueOf(this.f2469a.getFlags()), this.f2469a.getTextLocale(), this.f2469a.getTypeface(), this.f2470b, Integer.valueOf(this.f2471c), Integer.valueOf(this.f2472d));
            }
            return i3 >= 17 ? d0.d.b(Float.valueOf(this.f2469a.getTextSize()), Float.valueOf(this.f2469a.getTextScaleX()), Float.valueOf(this.f2469a.getTextSkewX()), Integer.valueOf(this.f2469a.getFlags()), this.f2469a.getTextLocale(), this.f2469a.getTypeface(), this.f2470b, Integer.valueOf(this.f2471c), Integer.valueOf(this.f2472d)) : d0.d.b(Float.valueOf(this.f2469a.getTextSize()), Float.valueOf(this.f2469a.getTextScaleX()), Float.valueOf(this.f2469a.getTextSkewX()), Integer.valueOf(this.f2469a.getFlags()), this.f2469a.getTypeface(), this.f2470b, Integer.valueOf(this.f2471c), Integer.valueOf(this.f2472d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2469a.getTextSize());
            sb.append(", textScaleX=" + this.f2469a.getTextScaleX());
            sb.append(", textSkewX=" + this.f2469a.getTextSkewX());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 21) {
                sb.append(", letterSpacing=" + this.f2469a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f2469a.isElegantTextHeight());
            }
            if (i3 >= 24) {
                sb.append(", textLocale=" + this.f2469a.getTextLocales());
            } else if (i3 >= 17) {
                sb.append(", textLocale=" + this.f2469a.getTextLocale());
            }
            sb.append(", typeface=" + this.f2469a.getTypeface());
            if (i3 >= 26) {
                sb.append(", variationSettings=" + this.f2469a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2470b);
            sb.append(", breakStrategy=" + this.f2471c);
            sb.append(", hyphenationFrequency=" + this.f2472d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f2469a = params.getTextPaint();
            this.f2470b = params.getTextDirection();
            this.f2471c = params.getBreakStrategy();
            this.f2472d = params.getHyphenationFrequency();
            this.f2473e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
