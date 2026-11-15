package f2;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import com.vivo.calculator.BBKCalculatorApplication;
import com.vivo.calculator.R;
import g2.h;
import java.util.ArrayList;
import java.util.HashMap;
import vivo.util.VLog;

/* JADX INFO: compiled from: RhythmTonePlayer.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements SoundPool.OnLoadCompleteListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4679g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SoundPool f4673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4674b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4675c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f4676d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f4677e = BBKCalculatorApplication.a().getApplicationContext();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4678f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f4680h = {R.raw.tone0_numbers, R.raw.tone1_operationalsign, R.raw.tone2_equal, R.raw.tone1_operationalsign, R.raw.tone4_clearall};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HashMap<Integer, Integer> f4681i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Handler f4682j = new HandlerC0061a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f4683k = 991;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f4684l = 1009;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f4685m = -40;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f4686n = 20;

    /* JADX INFO: renamed from: f2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RhythmTonePlayer.java */
    class HandlerC0061a extends Handler {
        HandlerC0061a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 107) {
                return;
            }
            int i3 = message.arg1;
            VLog.d("BBKCalculator/RhythmTonePlayer", "play  soundId " + i3);
            if (i3 != -1) {
                try {
                    float fE = a.this.e(1.0f);
                    VLog.d("BBKCalculator/RhythmTonePlayer", "play  ranV  ==  " + fE);
                    a.this.f4673a.play(i3, fE, fE, 1, 0, a.this.d());
                } catch (Exception e3) {
                    VLog.e("BBKCalculator/RhythmTonePlayer", "play soundId: " + i3 + " exception: " + e3);
                }
            }
        }
    }

    public a() {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float d() {
        return Math.round((this.f4683k + ((int) (Math.random() * ((double) ((this.f4684l - this.f4683k) + 1))))) * 1000) / 1000000.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float e(float f3) {
        float fRound = f3 + ((Math.round((this.f4685m + ((int) (Math.random() * ((double) ((this.f4686n - this.f4685m) + 1))))) * 1000) * f3) / 100000.0f);
        if (fRound > 1.0d) {
            return 1.0f;
        }
        return fRound;
    }

    private void f() {
        SoundPool soundPoolBuild = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(1).build()).setMaxStreams(1).build();
        this.f4673a = soundPoolBuild;
        soundPoolBuild.setOnLoadCompleteListener(this);
    }

    private void h(String str) {
        if (h.i(str)) {
            VLog.e("BBKCalculator/RhythmTonePlayer", "loadPathSound path = null ");
            return;
        }
        if (this.f4675c == this.f4676d.size() && this.f4676d.size() == 5) {
            this.f4678f = 0;
            k();
            this.f4674b = true;
        }
        SoundPool soundPool = this.f4673a;
        if (soundPool == null || this.f4676d == null) {
            return;
        }
        try {
            int iLoad = soundPool.load(str, 1);
            if (iLoad != 0) {
                this.f4676d.add(Integer.valueOf(iLoad));
            }
        } catch (Exception e3) {
            VLog.e("BBKCalculator/RhythmTonePlayer", "Rhythm resource path: " + str + "  load  exception: " + e3);
        }
    }

    private void i(int i3) {
        SoundPool soundPool = this.f4673a;
        if (soundPool == null || this.f4676d == null) {
            return;
        }
        try {
            int iLoad = soundPool.load(this.f4677e, this.f4680h[i3], 1);
            if (iLoad != 0) {
                this.f4676d.add(Integer.valueOf(iLoad));
            }
        } catch (Exception e3) {
            VLog.e("BBKCalculator/RhythmTonePlayer", "Rhythm resource index " + i3 + "  load  exception: " + e3);
        }
    }

    private void k() {
        if (this.f4681i.size() > 0) {
            this.f4681i.clear();
        }
        this.f4681i.put(0, this.f4676d.get(0));
        this.f4681i.put(1, this.f4676d.get(1));
        this.f4681i.put(2, this.f4676d.get(2));
        this.f4681i.put(3, this.f4676d.get(3));
        this.f4681i.put(4, this.f4676d.get(4));
        if (!h.i(this.f4679g) && this.f4676d.size() > 5) {
            this.f4681i.put(5, this.f4676d.get(5));
        }
        VLog.d("BBKCalculator/RhythmTonePlayer", "rhythmSources success");
    }

    private void o() {
        VLog.w("BBKCalculator/RhythmTonePlayer", "Rhythm resource load failure and try to reload.");
        n();
        int i3 = this.f4678f + 1;
        this.f4678f = i3;
        if (i3 > 2) {
            VLog.e("BBKCalculator/RhythmTonePlayer", "Rhythm reload too many times and failed!");
            this.f4678f = 0;
        } else {
            f();
            j();
        }
    }

    public boolean g() {
        return this.f4674b && this.f4681i.size() >= 5;
    }

    public void j() {
        this.f4675c = 0;
        this.f4674b = false;
        if (this.f4676d == null) {
            this.f4676d = new ArrayList<>();
        }
        this.f4676d.clear();
        i(this.f4675c);
    }

    public void l() {
        if (this.f4682j.hasMessages(107)) {
            this.f4682j.removeMessages(107);
        }
    }

    public void m(int i3) {
        if (i3 == 5 && Settings.System.getInt(this.f4677e.getContentResolver(), "vivo_delete_sounds_enabled", 1) == 0) {
            return;
        }
        Message messageObtainMessage = this.f4682j.obtainMessage(107);
        int iIntValue = -1;
        try {
            iIntValue = this.f4681i.get(Integer.valueOf(i3)).intValue();
        } catch (Exception e3) {
            VLog.e("BBKCalculator/RhythmTonePlayer", "mRhythmToneMap.get exception : " + e3.getMessage());
        }
        VLog.d("BBKCalculator/RhythmTonePlayer", "soundid:" + iIntValue);
        messageObtainMessage.arg1 = iIntValue;
        messageObtainMessage.sendToTarget();
    }

    public void n() {
        l();
        SoundPool soundPool = this.f4673a;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(null);
            this.f4673a.release();
            this.f4673a = null;
        }
        this.f4675c = 0;
        this.f4674b = false;
        ArrayList<Integer> arrayList = this.f4676d;
        if (arrayList != null && arrayList.size() > 0) {
            this.f4676d.clear();
        }
        HashMap<Integer, Integer> map = this.f4681i;
        if (map == null || map.size() <= 0) {
            return;
        }
        this.f4681i.clear();
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i3, int i4) {
        VLog.d("BBKCalculator/RhythmTonePlayer", "onLoadComplete status: " + i4 + " soundId: " + i3);
        if (i4 != 0 || i3 == 0) {
            o();
            return;
        }
        int i5 = this.f4675c + 1;
        this.f4675c = i5;
        int[] iArr = this.f4680h;
        if (i5 < iArr.length) {
            i(i5);
        } else if (i5 == iArr.length) {
            String string = Settings.System.getString(this.f4677e.getContentResolver(), "vivo_delete_sound_path");
            this.f4679g = string;
            h(string);
        }
        if (!h.i(this.f4679g) ? !(this.f4675c == this.f4676d.size() && this.f4676d.size() == 6) : !(this.f4675c == this.f4676d.size() && this.f4676d.size() == 5)) {
            this.f4678f = 0;
            k();
            this.f4674b = true;
        }
    }
}
