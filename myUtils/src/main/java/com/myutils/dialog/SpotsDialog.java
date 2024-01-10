package com.myutils.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.textview.MaterialTextView;
import com.myutils.R;

public class SpotsDialog extends AlertDialog {

    public static class Builder {

        private Context context;
        private String message;
        private int messageColor = Color.parseColor("#808080");
        private int messageTextSize = 16;
        private int dotsCount = 5;
        private int dotsColor = Color.parseColor("#FF0000");
        private int bgColor = Color.WHITE;
        private boolean cancelable = true;
        private OnCancelListener cancelListener;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setDotsCount(int dotsCount) {
            this.dotsCount = dotsCount;
            return this;
        }

        public Builder setDotsColor(int dotsColor) {
            this.dotsColor = dotsColor;
            return this;
        }

        public Builder setBgColor(int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = context.getString(message);
            return this;
        }

        public Builder setMessageColor(int messageColor) {
            this.messageColor = messageColor;
            return this;
        }

        public Builder setMessageTextSize(int messageTextSize) {
            this.messageTextSize = messageTextSize;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setCancelListener(OnCancelListener cancelListener) {
            this.cancelListener = cancelListener;
            return this;
        }

        public AlertDialog build() {
            return new SpotsDialog(
                    context,
                    message == null ? "Loading..." : message,
                    messageColor,
                    messageTextSize,
                    cancelable,
                    cancelListener,
                    dotsCount,
                    dotsColor,
                    bgColor
            );
        }
    }

    private static final int DELAY = 150;
    private static final int DURATION = 1500;

    private int size;
    private final int dotsCount;
    private final int dotsColor;
    private final int messageColor;
    private final int bgColor;
    private final int messageTextSize;
    private AnimatedView[] spots;
    private AnimatorPlayer animator;
    private CharSequence message;

    private SpotsDialog(Context context,
                        String message,
                        int messageColor,
                        int messageTextSize,
                        boolean cancelable,
                        OnCancelListener cancelListener,
                        int dotsCount,
                        int dotsColor,
                        int bgColor
    ) {
        super(context, R.style.SpotsDialogDefault);
        this.message = message;
        this.messageColor = messageColor;
        this.messageTextSize = messageTextSize;
        this.dotsCount = dotsCount;
        this.dotsColor = dotsColor;
        this.bgColor = bgColor;

        setCancelable(cancelable);
        if (cancelListener != null) setOnCancelListener(cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dmax_spots_dialog);
        setCanceledOnTouchOutside(false);

        initMessage();
        initProgress();
    }

    @Override
    protected void onStart() {
        super.onStart();

        for (AnimatedView view : spots) view.setVisibility(View.VISIBLE);

        animator = new AnimatorPlayer(createAnimations());
        animator.play();
    }

    @Override
    protected void onStop() {
        super.onStop();

        animator.stop();
    }

    @Override
    public void setMessage(CharSequence message) {
        this.message = message;
        if (isShowing()) initMessage();
    }

    //~

    private void initMessage() {
        if (message != null && message.length() > 0) {
            MaterialTextView lblTitle = findViewById(R.id.lblTitle);
            lblTitle.setText(message);
            lblTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, messageTextSize);
                lblTitle.setTextColor(messageColor);
        }
    }

    private void initProgress() {
        FrameLayout progress = findViewById(R.id.dmax_spots_progress);
        size = dotsCount;

        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(dotsColor);

        spots = new AnimatedView[size];
        int size = getContext().getResources().getDimensionPixelSize(R.dimen.spot_size);
        int progressWidth = getContext().getResources().getDimensionPixelSize(R.dimen.progress_width);
        for (int i = 0; i < spots.length; i++) {
            AnimatedView v = new AnimatedView(getContext());
            v.setBackground(shapeDrawable);
            v.setTarget(progressWidth);
            v.setXFactor(-1f);
            v.setVisibility(View.INVISIBLE);
            progress.addView(v, size, size);
            spots[i] = v;
        }

        ViewGroup containingLayout = (ViewGroup) progress.getParent();
        containingLayout.setBackgroundColor(bgColor);
//        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) containingLayout.getParent();
//        linearLayoutCompat.setBackgroundColor(bgColor);
    }

    private Animator[] createAnimations() {
        Animator[] animators = new Animator[size];
        for (int i = 0; i < spots.length; i++) {
            final AnimatedView animatedView = spots[i];
            Animator move = ObjectAnimator.ofFloat(animatedView, "xFactor", 0, 1);
            move.setDuration(DURATION);
            move.setInterpolator(new HesitateInterpolator());
            move.setStartDelay((long) DELAY * i);
            move.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    animatedView.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationStart(Animator animation) {
                    animatedView.setVisibility(View.VISIBLE);
                }
            });
            animators[i] = move;
        }
        return animators;
    }
}
