package com.oguzhandongul.easydialog.utils;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.oguzhandongul.easydialog.R;

/**
 * Created by oguzhandongul on 02/12/2016.
 */

public class BackgroundUtils {

    public static void animateReverse(Context context, final View view) {
        int colorFrom;
        int colorTo;
        colorFrom = ContextCompat.getColor(context, R.color.black_transparent);
        colorTo = ContextCompat.getColor(context, android.R.color.transparent);
        view.setOnClickListener(null);
        view.setClickable(false);


        if (Build.VERSION.SDK_INT > 13) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setBackgroundColor((Integer) animator.getAnimatedValue());

                }

            });
            colorAnimation.setDuration(300);
            colorAnimation.start();
        } else {
            view.setBackgroundColor(colorTo);
        }

    }

    public static void animateDarker(Context context, final View view) {
        int colorFrom;
        int colorTo;
        colorFrom = ContextCompat.getColor(context, android.R.color.transparent);
        colorTo = ContextCompat.getColor(context, R.color.black_transparent);
        view.setClickable(true);


        if (Build.VERSION.SDK_INT > 13) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setBackgroundColor((Integer) animator.getAnimatedValue());

                }

            });
            colorAnimation.setDuration(600);
            colorAnimation.start();
        } else {
            view.setBackgroundColor(colorTo);
        }

    }
}
