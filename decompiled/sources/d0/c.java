package d0;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: LogWriter.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class c extends Writer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuilder f4501c = new StringBuilder(128);

    public c(String str) {
        this.f4500b = str;
    }

    private void a() {
        if (this.f4501c.length() > 0) {
            Log.d(this.f4500b, this.f4501c.toString());
            StringBuilder sb = this.f4501c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c3 = cArr[i3 + i5];
            if (c3 == '\n') {
                a();
            } else {
                this.f4501c.append(c3);
            }
        }
    }
}
