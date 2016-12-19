package com.oguzhandongul.easydialog.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.design.internal.ForegroundLinearLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oguzhandongul.easydialog.R;
import com.oguzhandongul.easydialog.utils.DrawableCreator;


public class CVDialogButton extends ForegroundLinearLayout {
    Context mContext;
    public TextView tvTitle;
    int colorMain = R.color.green;
    int colorSecond = R.color.green_dark;
    int cornerRadius = 0;
    String titleString = "OK";


    public CVDialogButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(context, attrs);
    }


    public CVDialogButton(Context context) {
        super(context);
    }

    public void init(Context context, AttributeSet attrs) {

        TypedArray values = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CVDialogButton,
                0, 0);


        try {
            tvTitle = new TextView(mContext);
            tvTitle.setTextColor(ContextCompat.getColor(context, R.color.white));
            tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.gravity = Gravity.CENTER;
            tvTitle.setLayoutParams(params);
            tvTitle.setGravity(Gravity.CENTER);

            titleString = values.getString(R.styleable.CVDialogButton_ad_text);
            colorMain = values.getColor(R.styleable.CVDialogButton_ad_colorMain, Color.GREEN);
            colorSecond = values.getColor(R.styleable.CVDialogButton_ad_colorSecond, Color.GREEN);
            cornerRadius = values.getInt(R.styleable.CVDialogButton_ad_cornerRadius, 0);


            this.addView(tvTitle);
        } finally {
            values.recycle();
        }
        try {
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.setBackground(new DrawableCreator.Builder(mContext).createLayerList(colorMain, colorSecond, cornerRadius));
                // only for gingerbread and newer versions
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        this.setForeground(ContextCompat.getDrawable(mContext, R.drawable.flat_button_dark));
        this.setClickable(true);
        tvTitle.setText(titleString);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void setColorMain(int colorMain) {
        this.colorMain = colorMain;
    }

    private void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    private void setColorSecond(int colorSecond) {
        this.colorSecond = colorSecond;
    }

    public void updateBackground(int color, int darkerColor, int corner) {
        setColorMain(color);
        setColorSecond(darkerColor);
        setCornerRadius(corner);
        this.setBackground(new DrawableCreator.Builder(mContext).createLayerList(colorMain, colorSecond, cornerRadius));
    }

    public TextView getTextView() {
        return tvTitle;
    }
}