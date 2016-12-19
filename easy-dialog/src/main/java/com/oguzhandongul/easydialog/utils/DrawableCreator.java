package com.oguzhandongul.easydialog.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by oguzhandongul on 14/10/2016.
 */

public class DrawableCreator {

    public DrawableCreator() {
    }


    public static int getDarkerColor(int color, float factor) {
        int a = Color.alpha(color);
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);

        return Color.argb(a,
                Math.max((int) (r * factor), 0),
                Math.max((int) (g * factor), 0),
                Math.max((int) (b * factor), 0));
    }

    public static class Builder {
        protected final Context context;
        public static final int SHAPE_RECT = 0;
        public static final int SHAPE_OVAL = 1;
        public static final int SHAPE_CIRCLE = 2;
        public static final int SHAPE_GRADIENT = 3;

        public static final int SELECTOR_RECT = 0;
        public static final int SELECTOR_OVAL = 1;
        public static final int SELECTOR_RIPPLE = 2;

        public static final int LINEAR_GRADIENT = 0;
        public static final int RADIAL_GRADIENT = 1;
        public static final int SWEEP_GRADIENT = 2;

        protected int shapeType = 0;
        protected int selectorType = 0;
        protected int backgroundColor = 0;
        protected int backgroundPressedColor = 0;
        protected int sColor = 0;
        protected int sPressedColor = 0;
        protected int sWidth = 0;
        protected int sPressedWidth = 0;
        protected int radius = 0;
        protected int gradientType = 0;
        protected Orientation gradientOri;
        protected int gradientColors[];


        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder shape(int shapeType) {
            this.shapeType = shapeType;
            return this;
        }

        public Builder selector(int selectorType) {
            this.selectorType = selectorType;
            return this;
        }

        public Builder backgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder backgroundPressedColor(int backgroundPressedColor) {
            this.backgroundPressedColor = backgroundPressedColor;
            return this;
        }

        public Builder strokePressedColor(int sPressedColor) {
            this.sPressedColor = sPressedColor;
            return this;
        }

        public Builder strokePressedWidth(int sPressedWidth) {
            this.sPressedWidth = sPressedWidth;
            return this;
        }

        public Builder radius(int radius) {
            this.radius = radius;
            return this;
        }

        public Builder strokeColor(int sColor) {
            this.sColor = sColor;
            return this;
        }

        public Builder strokeWidth(int sWidth) {
            this.sWidth = sWidth;
            return this;
        }

        public Builder gradientType(int gradientType) {
            this.gradientType = gradientType;
            return this;
        }

        public Builder gradientOrientation(Orientation gradientOri) {
            this.gradientOri = gradientOri;
            return this;
        }

        public Builder gradientColors(int gradientColors[]) {
            this.gradientColors = gradientColors;
            return this;
        }

        public Drawable createBackground() {
            return createShape(null);
        }

        public Drawable createLayerList(int color, int darkerColor, int corner) {
            try {
                float radius = convertDpiToPixel(corner);

                float[] radiusArray = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};

                ShapeDrawable top_shape_drawable = new ShapeDrawable(new RoundRectShape(radiusArray, null, null));
                top_shape_drawable.getPaint().setColor(darkerColor);

                ShapeDrawable bottom_shape_drawable = new ShapeDrawable(new RoundRectShape(radiusArray, null, null));
                bottom_shape_drawable.getPaint().setColor(color);

                Drawable[] drawarray = {top_shape_drawable, bottom_shape_drawable};
                LayerDrawable layerdrawable = new LayerDrawable(drawarray);

                layerdrawable.setLayerInset(0, 0, 0, 0, 0); //darker layer
                layerdrawable.setLayerInset(1, 0, 0, 0, convertDpiToPixel(2)); //main top layer

                return layerdrawable;

            } catch (Exception ex) {
                ex.printStackTrace();
                GradientDrawable shape = null;
                shape = new GradientDrawable();
                shape.setColor(color);
                shape.setCornerRadius(convertDpiToPixel(corner));
                return shape;
            }
        }

        public Drawable createBackground(@NonNull View view) {
            return createShape(view);
        }

        private Drawable createShape(@Nullable View view) {
            GradientDrawable shape = null;

            switch (shapeType) {
                case SHAPE_RECT:
                    shape = new GradientDrawable();
                    shape.setColor(backgroundColor);
                    shape.setCornerRadius(convertDpiToPixel(radius));
                    shape.setStroke(convertDpiToPixel(sWidth), sColor);
                    break;
                case SHAPE_GRADIENT:
                    shape = new GradientDrawable();
                    shape.setColor(backgroundColor);
                    shape.setCornerRadius(convertDpiToPixel(radius));
                    shape.setStroke(convertDpiToPixel(sWidth), sColor);
                    shape.setColors(gradientColors);

                    if (gradientType == RADIAL_GRADIENT) {
                        shape.setGradientType(GradientDrawable.RADIAL_GRADIENT);
                    } else if (gradientType == SWEEP_GRADIENT) {
                        shape.setGradientType(GradientDrawable.SWEEP_GRADIENT);
                    } else {
                        shape.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                    }

                    if (gradientOri == Orientation.BL_TR) {
                        shape.setOrientation(GradientDrawable.Orientation.BL_TR);
                    } else if (gradientOri == Orientation.BOTTOM_TOP) {
                        shape.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                    } else if (gradientOri == Orientation.BR_TL) {
                        shape.setOrientation(GradientDrawable.Orientation.BR_TL);
                    } else if (gradientOri == Orientation.LEFT_RIGHT) {
                        shape.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    } else if (gradientOri == Orientation.RIGHT_LEFT) {
                        shape.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                    } else if (gradientOri == Orientation.TL_BR) {
                        shape.setOrientation(GradientDrawable.Orientation.TL_BR);
                    } else if (gradientOri == Orientation.TR_BL) {
                        shape.setOrientation(GradientDrawable.Orientation.TR_BL);
                    }


                    break;
                case SHAPE_OVAL:
                    shape = new GradientDrawable();
                    shape.setColor(backgroundColor);
                    shape.setCornerRadius(convertDpiToPixel(radius));
                    shape.setStroke(convertDpiToPixel(sWidth), sColor);
                    break;
                case SHAPE_CIRCLE:
                    shape = new GradientDrawable();
                    shape.setColor(0x00000000);
                    shape.setCornerRadius(convertDpiToPixel(radius));
                    shape.setStroke(convertDpiToPixel(sWidth), sColor);
                    break;
            }

            if (view != null) {
                view.setBackground(shape);

            }
            return shape;

        }


        private Drawable createNormalState() {
            GradientDrawable shape = null;
            shape = new GradientDrawable();
            shape.setColor(backgroundColor);
            shape.setCornerRadius(convertDpiToPixel(radius));
            shape.setStroke(convertDpiToPixel(sWidth), sColor);

            return shape;
        }

        private Drawable createPressedState() {
            GradientDrawable shape = null;
            shape = new GradientDrawable();
            shape.setColor(backgroundPressedColor);
            shape.setCornerRadius(convertDpiToPixel(radius));
            shape.setStroke(convertDpiToPixel(sPressedWidth), sPressedColor);

            return shape;
        }

        public void createSelector(View view) {


            switch (selectorType) {
                case SELECTOR_RECT:
                    //Selector
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, createPressedState());
                    stateListDrawable.addState(StateSet.WILD_CARD, createNormalState());
                    view.setBackground(stateListDrawable);
                    break;
                case SELECTOR_RIPPLE:

                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        // only for API v21+
                        view.setBackground(getPressedColorRippleDrawable(backgroundColor, backgroundPressedColor));
                    } else {
                        StateListDrawable stateListDrawable2 = new StateListDrawable();
                        stateListDrawable2.addState(new int[]{android.R.attr.state_pressed}, createPressedState());
                        stateListDrawable2.addState(StateSet.WILD_CARD, createNormalState());
                        view.setBackground(stateListDrawable2);
                    }

                    break;
                case SELECTOR_OVAL:
                    radius = 500;
                    StateListDrawable stateListDrawable3 = new StateListDrawable();
                    stateListDrawable3.addState(new int[]{android.R.attr.state_pressed}, createPressedState());
                    stateListDrawable3.addState(StateSet.WILD_CARD, createNormalState());
                    view.setBackground(stateListDrawable3);
                    break;
            }
        }


        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public static RippleDrawable getPressedColorRippleDrawable(int normalColor, int pressedColor) {
            return new RippleDrawable(getPressedColorSelector(0xAA666666, pressedColor), getColorDrawableFromColor(normalColor), null);
        }

        public static ColorStateList getPressedColorSelector(int normalColor, int pressedColor) {
            return new ColorStateList(
                    new int[][]
                            {
                                    new int[]{android.R.attr.state_pressed},
                                    new int[]{android.R.attr.state_focused},
                                    new int[]{android.R.attr.state_activated},
                                    new int[]{}
                            },
                    new int[]
                            {
                                    pressedColor,
                                    pressedColor,
                                    pressedColor,
                                    normalColor
                            }
            );
        }

        public static ColorDrawable getColorDrawableFromColor(int color) {
            return new ColorDrawable(color);
        }

        int convertDpiToPixel(int dpi) {
            float pixel = 0;
            try {
                Resources r = context.getResources();
                pixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpi,
                        r.getDisplayMetrics());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return (int) pixel;
        }
    }

    public static enum Orientation {
        BL_TR,
        BOTTOM_TOP,
        BR_TL,
        LEFT_RIGHT,
        RIGHT_LEFT,
        TL_BR,
        TOP_BOTTOM,
        TR_BL;

        private Orientation() {
        }
    }

    public static void overlayImageColor(ImageView imageView, int color) {
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

}
