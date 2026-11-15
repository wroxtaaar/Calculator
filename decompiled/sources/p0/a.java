package p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: p0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatorUtils.java */
    interface InterfaceC0078a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                Animator.AnimatorListener animatorListener = listeners.get(i3);
                if (animatorListener instanceof InterfaceC0078a) {
                    ((InterfaceC0078a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    static void c(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                Animator.AnimatorListener animatorListener = listeners.get(i3);
                if (animatorListener instanceof InterfaceC0078a) {
                    ((InterfaceC0078a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
