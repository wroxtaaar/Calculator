package k2;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static boolean a(CharSequence charSequence) {
        if (!(charSequence != null && charSequence.length() > 0)) {
            return false;
        }
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isWhitespace(charSequence.charAt(i3))) {
                return true;
            }
        }
        return false;
    }
}
