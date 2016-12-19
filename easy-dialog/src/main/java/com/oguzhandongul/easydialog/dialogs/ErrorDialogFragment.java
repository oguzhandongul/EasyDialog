package com.oguzhandongul.easydialog.dialogs;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.oguzhandongul.easydialog.DialogDataModel;
import com.oguzhandongul.easydialog.FontCacheHelper;
import com.oguzhandongul.easydialog.R;
import com.oguzhandongul.easydialog.customviews.CVDialogButton;
import com.oguzhandongul.easydialog.utils.DrawableCreator;

/**
 * Created by oguzhandongul on 23/09/2016.
 */

public class ErrorDialogFragment extends BaseDialogFragment implements DialogInterface.OnCancelListener {

    RelativeLayout rlParent;
    CVDialogButton cvPositive;
    CVDialogButton cvNegative;
    DialogDataModel dialogDataModel;

    ImageView ivCheck;
    TextView tvTitle, tvContent;
    BaseDialogFragment instance = this;


    public ErrorDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ErrorDialogFragment newInstance(DialogDataModel dialogDataModel) {
        ErrorDialogFragment frag = new ErrorDialogFragment();
        frag.setDialogDataModel(dialogDataModel);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_error_dialog, container);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rlParent = (RelativeLayout) view.findViewById(R.id.rlParent);
        cvPositive = (CVDialogButton) view.findViewById(R.id.cvPositive);
        cvNegative = (CVDialogButton) view.findViewById(R.id.cvNegative);
        ivCheck = (ImageView) view.findViewById(R.id.ivCheck);
        tvContent = (TextView) view.findViewById(R.id.tvMessage);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);


        cvPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ErrorDialogFragment.this.dismiss();
            }
        });
        cvNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ErrorDialogFragment.this.dismiss();
            }
        });

        setDataModel();
        super.onViewCreated(view, savedInstanceState);

    }


    private void setDataModel() {
        if (dialogDataModel != null) {

            if (dialogDataModel.isDialogFontSet()) {
                tvTitle.setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogFont(), getActivity()));
                tvContent.setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogFont(), getActivity()));
                cvPositive.getTextView().setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogFont(), getActivity()));
                cvNegative.getTextView().setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogFont(), getActivity()));
            }

            //Content
            if (dialogDataModel.isContentSet()) {
                tvContent.setText(dialogDataModel.getDialogContent());
                if (dialogDataModel.isContentColorSet()) {
                    tvContent.setTextColor(ContextCompat.getColor(getActivity(), dialogDataModel.getDialogContentColor()));
                }
                if (dialogDataModel.isContentFontSet()) {
                    tvContent.setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogContentFont(), getActivity()));
                }
            }


            //Title
            if (dialogDataModel.isTitleSet()) {
                tvTitle.setText(dialogDataModel.getDialogTitle());
                if (dialogDataModel.isTitleColorSet()) {
                    tvTitle.setTextColor(ContextCompat.getColor(getActivity(), dialogDataModel.getDialogTitleColor()));
                }
                if (dialogDataModel.isTitleFontSet()) {
                    tvTitle.setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogTitleFont(), getActivity()));
                }
            } else {
                tvTitle.setVisibility(View.GONE);
            }


            //Corners
            int cornerRadius = 5;
            if (dialogDataModel.isCornerRadiusSet()) {
                cornerRadius = dialogDataModel.getDialogCornerRadius();
            }

            //Positive Button
            cvPositive.setVisibility(View.VISIBLE);
            if (dialogDataModel.isPositiveSet()) {
                cvPositive.getTextView().setText(dialogDataModel.getPositiveText());
                int color = R.color.red;

                if (dialogDataModel.isPositiveColorSet()) {
                    color = dialogDataModel.getPositiveColor();
                }
                if (dialogDataModel.isPositiveTextColorSet()) {
                    cvPositive.getTextView().setTextColor(dialogDataModel.getPositiveTextColor());
                }
                if (dialogDataModel.isPositiveFontSet()) {
                    cvPositive.getTextView().setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getPositiveFont(), getActivity()));
                }
                if (dialogDataModel.isPositiveCallbackSet()) {
                    cvPositive.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialogDataModel.getPositiveCallback().onClick(instance);
                        }
                    });
                }
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    cvPositive.setBackground(new DrawableCreator.Builder(getActivity()).createLayerList(ContextCompat.getColor(getActivity(), color), DrawableCreator.getDarkerColor(ContextCompat.getColor(getActivity(), color), 0.85f), cornerRadius));
                }else{
                    cvPositive.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.rounded_green_bg));
                }
            }

            //Negative Button
            if (dialogDataModel.isNegativeSet()) {
                cvNegative.setVisibility(View.VISIBLE);
                cvNegative.getTextView().setText(dialogDataModel.getNegativeText());

                int color = R.color.grey;

                if (dialogDataModel.isNegativeColorSet()) {
                    color = dialogDataModel.getNegativeColor();
                }
                if (dialogDataModel.isNegativeTextColorSet()) {
                    cvNegative.getTextView().setTextColor(dialogDataModel.getNegativeTextColor());
                }
                if (dialogDataModel.isNegativeFontSet()) {
                    cvNegative.getTextView().setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getNegativeFont(), getActivity()));
                }
                if (dialogDataModel.isNegativeCallbackSet()) {
                    cvNegative.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialogDataModel.getNegativeCallback().onClick(instance);
                        }
                    });
                }
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    cvNegative.setBackground(new DrawableCreator.Builder(getActivity()).createLayerList(ContextCompat.getColor(getActivity(), color), DrawableCreator.getDarkerColor(ContextCompat.getColor(getActivity(), color), 0.85f), cornerRadius));
                }else {
                    cvNegative.setBackground(ContextCompat.getDrawable(getActivity(),R.drawable.rounded_red_bg));
                }
            }

            if (dialogDataModel.isDialogCancelTouchOutside()) {
                rlParent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ErrorDialogFragment.this.dismiss();
                    }
                });
            }
        }
    }


    public void setDialogDataModel(DialogDataModel dialogDataModel) {
        this.dialogDataModel = dialogDataModel;
    }
}