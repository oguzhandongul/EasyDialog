package com.oguzhandongul.easydialog.dialogs;

import android.content.DialogInterface;
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
import com.oguzhandongul.easydialog.customviews.loadingviews.AVLoadingIndicatorView;
import com.oguzhandongul.easydialog.utils.DrawableCreator;

/**
 * Created by oguzhandongul on 23/09/2016.
 */

public class ProgressDialogFragment extends BaseDialogFragment implements DialogInterface.OnCancelListener {

    RelativeLayout rlParent;
    DialogDataModel dialogDataModel;

    ImageView ivCheck;
    AVLoadingIndicatorView progress;
    TextView tvTitle;
    BaseDialogFragment instance = this;


    public ProgressDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ProgressDialogFragment newInstance(DialogDataModel dialogDataModel) {
        ProgressDialogFragment frag = new ProgressDialogFragment();
        frag.setDialogDataModel(dialogDataModel);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress_dialog, container);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rlParent = (RelativeLayout) view.findViewById(R.id.rlParent);
        ivCheck = (ImageView) view.findViewById(R.id.ivCheck);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        progress = (AVLoadingIndicatorView) view.findViewById(R.id.progress);


        setDataModel();
        super.onViewCreated(view, savedInstanceState);

    }


    private void setDataModel() {
        if (dialogDataModel != null) {


            //Title
            if (dialogDataModel.isTitleSet()) {
                tvTitle.setText(dialogDataModel.getDialogTitle());
                if (dialogDataModel.isTitleColorSet()) {
                    tvTitle.setTextColor(ContextCompat.getColor(getActivity(), dialogDataModel.getDialogTitleColor()));
                }
                if (dialogDataModel.isDialogFontSet()) {
                    tvTitle.setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogFont(), getActivity()));
                }
                if (dialogDataModel.isTitleFontSet()) {
                    tvTitle.setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogTitleFont(), getActivity()));
                }
            } else {
                tvTitle.setVisibility(View.GONE);
            }


            if (dialogDataModel.isIconBgColorSet()) {
                new DrawableCreator.Builder(getActivity())
                        .shape(DrawableCreator.Builder.SHAPE_OVAL)
                        .radius(40)
                        .strokeColor(0xFFFFFFFF)
                        .backgroundColor(ContextCompat.getColor(getActivity(),dialogDataModel.getDialogIconBgColor()))
                        .strokeWidth(2)
                        .createBackground(ivCheck);

            }

            if(dialogDataModel.isDialogCancelTouchOutside()){
                rlParent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProgressDialogFragment.this.dismiss();
                    }
                });
            }
        }
    }


    public void setDialogDataModel(DialogDataModel dialogDataModel) {
        this.dialogDataModel = dialogDataModel;
    }
}