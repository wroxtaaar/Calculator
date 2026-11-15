package s1;

import com.vivo.seckeysdk.BuildConfig;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: ISO8601Utils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f6209a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i3, char c3) {
        return i3 < str.length() && str.charAt(i3) == c3;
    }

    private static int b(String str, int i3) {
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                return i3;
            }
            i3++;
        }
        return str.length();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00cf A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:90:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d6 A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:90:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:60:0x0107 A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:90:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0181 A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:90:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01b4 A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:90:0x0004 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x0107, please report this as an issue */
    public static Date c(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i3;
        int i4;
        int i5;
        int iD;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int iD2 = d(str, index, i6);
            if (a(str, i6, '-')) {
                i6++;
            }
            int i7 = i6 + 2;
            int iD3 = d(str, i6, i7);
            if (a(str, i7, '-')) {
                i7++;
            }
            int i8 = i7 + 2;
            int iD4 = d(str, i7, i8);
            boolean zA = a(str, i8, 'T');
            if (!zA && str.length() <= i8) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iD2, iD3 - 1, iD4);
                parsePosition.setIndex(i8);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i9 = i8 + 1;
                int i10 = i9 + 2;
                int iD5 = d(str, i9, i10);
                if (a(str, i10, ':')) {
                    i10++;
                }
                int i11 = i10 + 2;
                int iD6 = d(str, i10, i11);
                if (a(str, i11, ':')) {
                    i11++;
                }
                if (str.length() <= i11 || (cCharAt2 = str.charAt(i11)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i4 = iD6;
                    i5 = 0;
                    i3 = iD5;
                    i8 = i11;
                } else {
                    int i12 = i11 + 2;
                    iD = d(str, i11, i12);
                    if (iD > 59 && iD < 63) {
                        iD = 59;
                    }
                    if (a(str, i12, '.')) {
                        int i13 = i12 + 1;
                        int iB = b(str, i13 + 1);
                        int iMin = Math.min(iB, i13 + 3);
                        int iD7 = d(str, i13, iMin);
                        int i14 = iMin - i13;
                        if (i14 == 1) {
                            iD7 *= 100;
                        } else if (i14 == 2) {
                            iD7 *= 10;
                        }
                        i4 = iD6;
                        i5 = iD7;
                        i3 = iD5;
                        i8 = iB;
                    } else {
                        i4 = iD6;
                        i3 = iD5;
                        i8 = i12;
                        i5 = 0;
                    }
                }
                if (str.length() > i8) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i8);
                if (cCharAt == 'Z') {
                    timeZone = f6209a;
                    length = i8 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i8);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring + "00";
                    }
                    length = i8 + strSubstring.length();
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = f6209a;
                    } else {
                        String str3 = "GMT" + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                        String id = timeZone2.getID();
                        if (!id.equals(str3) && !id.replace(":", BuildConfig.FLAVOR).equals(str3)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, iD2);
                gregorianCalendar2.set(2, iD3 - 1);
                gregorianCalendar2.set(5, iD4);
                gregorianCalendar2.set(11, i3);
                gregorianCalendar2.set(12, i4);
                gregorianCalendar2.set(13, iD);
                gregorianCalendar2.set(14, i5);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i3 = 0;
            i4 = 0;
            i5 = 0;
            iD = 0;
            if (str.length() > i8) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i8);
            if (cCharAt == 'Z') {
                timeZone = f6209a;
                length = i8 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i8);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i8 + strSubstring.length();
                if ("+0000".equals(strSubstring)) {
                    timeZone = f6209a;
                } else {
                    timeZone = f6209a;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, iD2);
            gregorianCalendar3.set(2, iD3 - 1);
            gregorianCalendar3.set(5, iD4);
            gregorianCalendar3.set(11, i3);
            gregorianCalendar3.set(12, i4);
            gregorianCalendar3.set(13, iD);
            gregorianCalendar3.set(14, i5);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException e3) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e3.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e3.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e3);
            throw parseException;
        }
    }

    private static int d(String str, int i3, int i4) throws NumberFormatException {
        int i5;
        int i6;
        if (i3 < 0 || i4 > str.length() || i3 > i4) {
            throw new NumberFormatException(str);
        }
        if (i3 < i4) {
            i6 = i3 + 1;
            int iDigit = Character.digit(str.charAt(i3), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i4));
            }
            i5 = -iDigit;
        } else {
            i5 = 0;
            i6 = i3;
        }
        while (i6 < i4) {
            int i7 = i6 + 1;
            int iDigit2 = Character.digit(str.charAt(i6), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i3, i4));
            }
            i5 = (i5 * 10) - iDigit2;
            i6 = i7;
        }
        return -i5;
    }
}
