package com.oguzhandongul.easydialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.oguzhandongul.easydialog.callbacks.DialogButtonCallback;
import com.oguzhandongul.easydialog.customviews.CVSelectionItem;
import com.oguzhandongul.easydialog.dialogs.CustomDialogFragment;
import com.oguzhandongul.easydialog.dialogs.ErrorDialogFragment;
import com.oguzhandongul.easydialog.dialogs.ProgressDialogFragment;
import com.oguzhandongul.easydialog.dialogs.SelectionDialogFragment;
import com.oguzhandongul.easydialog.dialogs.SuccessDialogFragment;
import com.oguzhandongul.easydialog.models.SelectionModel;

import java.util.ArrayList;

/**
 * Created by oguzhandongul on 02/12/2016.
 */

public class EasyDialog {

    public EasyDialog() {
    }

    public static class Builder {
        protected final FragmentActivity activityCompat;
        protected Context context;
        public static final int DIALOG_CUSTOM = -1;
        public static final int DIALOG_SUCCESS = 0;
        public static final int DIALOG_INFO = 1;
        public static final int DIALOG_ERROR = 2;
        public static final int DIALOG_PROGRESS = 3;
        public static final int DIALOG_SELECTION = 4;


        protected DialogDataModel dialogDataModel = null;


        public Builder(@NonNull FragmentActivity activityCompat) {
            this.activityCompat = activityCompat;
            this.context = activityCompat.getApplicationContext();
            this.dialogDataModel = new DialogDataModel();
        }

        public Builder type(int dialogType) {
            this.dialogDataModel.setDialogType(dialogType);
            return this;
        }

        //Title
        public Builder title(String dialogTitle) {
            this.dialogDataModel.setDialogTitle(dialogTitle);
            return this;
        }

        public Builder title(int dialogTitle) {
            this.dialogDataModel.setDialogTitle(context.getResources().getString(dialogTitle));
            return this;
        }

        public Builder titleFont(String dialogTitleFont) {
            this.dialogDataModel.setDialogTitleFont(dialogTitleFont);
            return this;
        }

        public Builder titleColor(int dialogTitleColor) {
            this.dialogDataModel.setDialogTitleColor(dialogTitleColor);
            return this;
        }

        //Content
        public Builder content(String dialogContent) {
            this.dialogDataModel.setDialogContent(dialogContent);
            return this;
        }

        public Builder content(int dialogContent) {
            this.dialogDataModel.setDialogContent(context.getResources().getString(dialogContent));
            return this;
        }

        public Builder contentFont(String dialogContentFont) {
            this.dialogDataModel.setDialogContentFont(dialogContentFont);
            return this;
        }

        public Builder contentColor(int dialogContentColor) {
            this.dialogDataModel.setDialogContentColor(dialogContentColor);
            return this;
        }

        //Icon
        public Builder icon(int dialogIcon) {
            this.dialogDataModel.setDialogIcon(dialogIcon);
            return this;
        }

        public Builder iconColor(int dialogIconColor) {
            this.dialogDataModel.setDialogIconColor(dialogIconColor);
            return this;
        }

        public Builder iconBgColor(int dialogIconBgColor) {
            this.dialogDataModel.setDialogIconBgColor(dialogIconBgColor);
            return this;
        }


        //PositiveButton
        public Builder addPositiveButton(String positiveText, DialogButtonCallback positiveCallback) {
            this.dialogDataModel.setPositiveText(positiveText);
            this.dialogDataModel.setPositiveCallback(positiveCallback);
            return this;
        }

        public Builder addPositiveButton(String positiveText) {
            this.dialogDataModel.setPositiveText(positiveText);
            return this;
        }

        //PositiveButton
        public Builder addPositiveButton(int positiveText, DialogButtonCallback positiveCallback) {
            this.dialogDataModel.setPositiveText(context.getResources().getString(positiveText));
            this.dialogDataModel.setPositiveCallback(positiveCallback);
            return this;
        }

        public Builder addPositiveButton(int positiveText) {
            this.dialogDataModel.setPositiveText(context.getResources().getString(positiveText));
            return this;
        }

        public Builder positiveColor(int positiveColor) {
            this.dialogDataModel.setPositiveColor(positiveColor);
            return this;
        }

        public Builder positiveTextColor(int positiveTextColor) {
            this.dialogDataModel.setPositiveTextColor(positiveTextColor);
            return this;
        }

        public Builder positiveFont(String positiveFont) {
            this.dialogDataModel.setPositiveFont(positiveFont);
            return this;
        }

        //NegativeButton
        public Builder addNegativeButton(String negativeText, DialogButtonCallback negativeCallback) {
            this.dialogDataModel.setNegativeText(negativeText);
            this.dialogDataModel.setNegativeCallback(negativeCallback);
            return this;
        }

        public Builder addNegativeButton(String negativeText) {
            this.dialogDataModel.setNegativeText(negativeText);
            return this;
        }

        public Builder addNegativeButton(int negativeText, DialogButtonCallback negativeCallback) {
            this.dialogDataModel.setNegativeText(context.getResources().getString(negativeText));
            this.dialogDataModel.setNegativeCallback(negativeCallback);
            return this;
        }

        public Builder addNegativeButton(int negativeText) {
            this.dialogDataModel.setNegativeText(context.getResources().getString(negativeText));
            return this;
        }

        public Builder negativeColor(int negativeColor) {
            this.dialogDataModel.setNegativeColor(negativeColor);
            return this;
        }

        public Builder negativeTextColor(int negativeTextColor) {
            this.dialogDataModel.setNegativeTextColor(negativeTextColor);
            return this;
        }

        public Builder negativeFont(String negativeFont) {
            this.dialogDataModel.setNegativeFont(negativeFont);
            return this;
        }

        public Builder cancelTouchOutside(boolean cancelTouchOutside) {
            this.dialogDataModel.setDialogCancelTouchOutside(cancelTouchOutside);
            return this;
        }

        public Builder cornerRadius(int dialogCornerRadius) {
            this.dialogDataModel.setDialogCornerRadius(dialogCornerRadius);
            return this;
        }

        public Builder dialogFont(String dialogFont) {
            this.dialogDataModel.setDialogFont(dialogFont);
            return this;
        }


        public Builder selectionList(ArrayList<SelectionModel> selectionModelArrayList) {
            this.dialogDataModel.setSelectionItems(selectionModelArrayList);
            return this;
        }

        public Builder addSelectionCallback(CVSelectionItem.OnItemClickListener onItemClickListener) {
            this.dialogDataModel.setOnItemClickListener(onItemClickListener);
            return this;
        }

        public void build() {

            switch (this.dialogDataModel.getDialogType()) {
                case DIALOG_CUSTOM:
                    CustomDialogFragment customDialogFragment = CustomDialogFragment.newInstance(dialogDataModel);
                    customDialogFragment.show(activityCompat.getSupportFragmentManager(), "DIALOG");
                    break;
                case DIALOG_SUCCESS:
                    SuccessDialogFragment successDialogFragment = SuccessDialogFragment.newInstance(dialogDataModel);
                    successDialogFragment.show(activityCompat.getSupportFragmentManager(), "DIALOG");
                    break;

                case DIALOG_ERROR:
                    ErrorDialogFragment errorDialogFragment = ErrorDialogFragment.newInstance(dialogDataModel);
                    errorDialogFragment.show(activityCompat.getSupportFragmentManager(), "DIALOG");
                    break;

                case DIALOG_PROGRESS:
                    ProgressDialogFragment progressDialogFragment = ProgressDialogFragment.newInstance(dialogDataModel);
                    progressDialogFragment.show(activityCompat.getSupportFragmentManager(), "DIALOG");
                    break;
                case DIALOG_SELECTION:
                    SelectionDialogFragment selectionDialogFragment = SelectionDialogFragment.newInstance(dialogDataModel);
                    selectionDialogFragment.show(activityCompat.getSupportFragmentManager(), "DIALOG");
                    break;
            }

        }
    }
}
