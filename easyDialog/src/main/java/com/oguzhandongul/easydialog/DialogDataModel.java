package com.oguzhandongul.easydialog;

import com.oguzhandongul.easydialog.callbacks.DialogButtonCallback;
import com.oguzhandongul.easydialog.customviews.CVSelectionItem;
import com.oguzhandongul.easydialog.models.SelectionModel;

import java.util.ArrayList;

/**
 * Created by oguzhandongul on 02/12/2016.
 */

public class DialogDataModel {
    //Title Optional
    protected boolean titleColorSet = false;
    protected boolean titleFontSet = false;
    protected boolean titleSet = false;

    //Content Must
    protected boolean contentColorSet = false;
    protected boolean contentFontSet = false;
    protected boolean contentSet = false;

    //Icon Optional
    protected boolean iconColorSet = false;
    protected boolean iconBgColorSet = false;
    protected boolean iconSet = false;

    //Positive Button
    protected boolean positiveColorSet = false;
    protected boolean positiveTextColorSet = false;
    protected boolean positiveSet = false;
    protected boolean positiveFontSet = false;
    protected boolean positiveCallbackSet = false;

    //Negative Button
    protected boolean negativeColorSet = false;
    protected boolean negativeTextColorSet = false;
    protected boolean negativeSet = false;
    protected boolean negativeFontSet = false;
    protected boolean negativeCallbackSet = false;

    //Button Radius
    protected boolean cornerRadiusSet = false;
    protected boolean dialogFontSet = false;
    protected boolean selectionListSet = false;
    protected boolean selectionCallbackSet = false;

    private int dialogType;
    private String dialogTitle;
    private String dialogTitleFont;
    private int dialogTitleColor;

    private String dialogContent;
    private String dialogContentFont;
    private int dialogContentColor;

    private int dialogIcon;
    private int dialogIconColor;
    private int dialogIconBgColor;

    private String positiveText;
    private int positiveTextColor;
    private String positiveFont;
    private int positiveColor;
    private DialogButtonCallback positiveCallback;

    private String negativeText;
    private int negativeTextColor;
    private String negativeFont;
    private int negativeColor;
    private DialogButtonCallback negativeCallback;

    private String dialogFont;
    private int dialogCornerRadius;
    private boolean dialogCancelTouchOutside;

    private ArrayList<SelectionModel> selectionItems;
    private CVSelectionItem.OnItemClickListener onItemClickListener;

    public DialogDataModel() {
    }

    public int getDialogType() {
        return dialogType;
    }

    public void setDialogType(int dialogType) {
        this.dialogType = dialogType;
    }

    public String getDialogTitle() {
        return dialogTitle;
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
        this.titleSet = true;
    }

    public String getDialogTitleFont() {
        return dialogTitleFont;
    }

    public void setDialogTitleFont(String dialogTitleFont) {
        this.dialogTitleFont = dialogTitleFont;
        this.titleFontSet = true;
    }

    public int getDialogTitleColor() {
        return dialogTitleColor;
    }

    public void setDialogTitleColor(int dialogTitleColor) {
        this.dialogTitleColor = dialogTitleColor;
        this.titleColorSet = true;
    }

    public String getDialogContent() {
        return dialogContent;
    }

    public void setDialogContent(String dialogContent) {
        this.dialogContent = dialogContent;
        this.contentSet = true;
    }

    public String getDialogContentFont() {
        return dialogContentFont;
    }

    public void setDialogContentFont(String dialogContentFont) {
        this.dialogContentFont = dialogContentFont;
        this.contentFontSet = true;
    }

    public int getDialogContentColor() {
        return dialogContentColor;
    }

    public void setDialogContentColor(int dialogContentColor) {
        this.dialogContentColor = dialogContentColor;
        this.contentColorSet = true;
    }

    public int getDialogIcon() {
        return dialogIcon;
    }

    public void setDialogIcon(int dialogIcon) {
        this.dialogIcon = dialogIcon;
        this.iconSet = true;
    }

    public int getDialogIconColor() {
        return dialogIconColor;
    }

    public void setDialogIconColor(int dialogIconColor) {
        this.dialogIconColor = dialogIconColor;
        this.iconColorSet = true;
    }

    public String getPositiveText() {
        return positiveText;
    }

    public void setPositiveText(String positiveText) {
        this.positiveText = positiveText;
        this.positiveSet = true;
    }

    public int getPositiveTextColor() {
        return positiveTextColor;
    }

    public void setPositiveTextColor(int positiveTextColor) {
        this.positiveTextColor = positiveTextColor;
        this.positiveTextColorSet = true;
    }

    public String getPositiveFont() {
        return positiveFont;
    }

    public void setPositiveFont(String positiveFont) {
        this.positiveFont = positiveFont;
        this.positiveFontSet = true;
    }

    public int getPositiveColor() {
        return positiveColor;
    }

    public void setPositiveColor(int positiveColor) {
        this.positiveColor = positiveColor;
        this.positiveColorSet = true;
    }

    public DialogButtonCallback getPositiveCallback() {
        return positiveCallback;
    }

    public void setPositiveCallback(DialogButtonCallback positiveCallback) {
        this.positiveCallback = positiveCallback;
        this.positiveCallbackSet = true;
    }

    public String getNegativeText() {
        return negativeText;
    }

    public void setNegativeText(String negativeText) {
        this.negativeText = negativeText;
        this.negativeSet = true;
    }

    public int getNegativeTextColor() {
        return negativeTextColor;
    }

    public void setNegativeTextColor(int negativeTextColor) {
        this.negativeTextColor = negativeTextColor;
        this.negativeTextColorSet = true;
    }

    public String getNegativeFont() {
        return negativeFont;
    }

    public void setNegativeFont(String negativeFont) {
        this.negativeFont = negativeFont;
        this.negativeFontSet = true;
    }

    public int getNegativeColor() {
        return negativeColor;
    }

    public void setNegativeColor(int negativeColor) {
        this.negativeColor = negativeColor;
        this.negativeColorSet = true;
    }

    public DialogButtonCallback getNegativeCallback() {
        return negativeCallback;
    }

    public void setNegativeCallback(DialogButtonCallback negativeCallback) {
        this.negativeCallback = negativeCallback;
        this.negativeCallbackSet = true;
    }

    public int getDialogCornerRadius() {
        return dialogCornerRadius;
    }

    public void setDialogCornerRadius(int dialogCornerRadius) {
        this.dialogCornerRadius = dialogCornerRadius;
        this.cornerRadiusSet = true;
    }

    public boolean isTitleColorSet() {
        return titleColorSet;
    }

    public void setTitleColorSet(boolean titleColorSet) {
        this.titleColorSet = titleColorSet;
    }

    public boolean isTitleFontSet() {
        return titleFontSet;
    }

    public void setTitleFontSet(boolean titleFontSet) {
        this.titleFontSet = titleFontSet;
    }

    public boolean isTitleSet() {
        return titleSet;
    }

    public void setTitleSet(boolean titleSet) {
        this.titleSet = titleSet;
    }

    public boolean isContentColorSet() {
        return contentColorSet;
    }

    public void setContentColorSet(boolean contentColorSet) {
        this.contentColorSet = contentColorSet;
    }

    public boolean isContentFontSet() {
        return contentFontSet;
    }

    public void setContentFontSet(boolean contentFontSet) {
        this.contentFontSet = contentFontSet;
    }

    public boolean isContentSet() {
        return contentSet;
    }

    public void setContentSet(boolean contentSet) {
        this.contentSet = contentSet;
    }

    public boolean isIconColorSet() {
        return iconColorSet;
    }

    public void setIconColorSet(boolean iconColorSet) {
        this.iconColorSet = iconColorSet;
    }

    public boolean isIconSet() {
        return iconSet;
    }

    public void setIconSet(boolean iconSet) {
        this.iconSet = iconSet;
    }

    public boolean isPositiveColorSet() {
        return positiveColorSet;
    }

    public void setPositiveColorSet(boolean positiveColorSet) {
        this.positiveColorSet = positiveColorSet;
    }

    public boolean isPositiveTextColorSet() {
        return positiveTextColorSet;
    }

    public void setPositiveTextColorSet(boolean positiveTextColorSet) {
        this.positiveTextColorSet = positiveTextColorSet;
    }

    public boolean isPositiveSet() {
        return positiveSet;
    }

    public void setPositiveSet(boolean positiveSet) {
        this.positiveSet = positiveSet;
    }

    public boolean isPositiveFontSet() {
        return positiveFontSet;
    }

    public void setPositiveFontSet(boolean positiveFontSet) {
        this.positiveFontSet = positiveFontSet;
    }

    public boolean isPositiveCallbackSet() {
        return positiveCallbackSet;
    }

    public void setPositiveCallbackSet(boolean positiveCallbackSet) {
        this.positiveCallbackSet = positiveCallbackSet;
    }

    public boolean isNegativeColorSet() {
        return negativeColorSet;
    }

    public void setNegativeColorSet(boolean negativeColorSet) {
        this.negativeColorSet = negativeColorSet;
    }

    public boolean isNegativeTextColorSet() {
        return negativeTextColorSet;
    }

    public void setNegativeTextColorSet(boolean negativeTextColorSet) {
        this.negativeTextColorSet = negativeTextColorSet;
    }

    public boolean isNegativeSet() {
        return negativeSet;
    }

    public void setNegativeSet(boolean negativeSet) {
        this.negativeSet = negativeSet;
    }

    public boolean isNegativeFontSet() {
        return negativeFontSet;
    }

    public void setNegativeFontSet(boolean negativeFontSet) {
        this.negativeFontSet = negativeFontSet;
    }

    public boolean isNegativeCallbackSet() {
        return negativeCallbackSet;
    }

    public void setNegativeCallbackSet(boolean negativeCallbackSet) {
        this.negativeCallbackSet = negativeCallbackSet;
    }

    public boolean isCornerRadiusSet() {
        return cornerRadiusSet;
    }

    public void setCornerRadiusSet(boolean cornerRadiusSet) {
        this.cornerRadiusSet = cornerRadiusSet;
    }

    public boolean isIconBgColorSet() {
        return iconBgColorSet;
    }

    public void setIconBgColorSet(boolean iconBgColorSet) {
        this.iconBgColorSet = iconBgColorSet;
    }

    public int getDialogIconBgColor() {
        return dialogIconBgColor;
    }

    public void setDialogIconBgColor(int dialogIconBgColor) {
        this.dialogIconBgColor = dialogIconBgColor;
        this.iconBgColorSet = true;
    }

    public boolean isDialogFontSet() {
        return dialogFontSet;
    }

    public void setDialogFontSet(boolean dialogFontSet) {
        this.dialogFontSet = dialogFontSet;

    }

    public String getDialogFont() {
        return dialogFont;
    }

    public void setDialogFont(String dialogFont) {
        this.dialogFont = dialogFont;
        this.dialogFontSet = true;
    }

    public boolean isDialogCancelTouchOutside() {
        return dialogCancelTouchOutside;
    }

    public void setDialogCancelTouchOutside(boolean dialogCancelTouchOutside) {
        this.dialogCancelTouchOutside = dialogCancelTouchOutside;
    }

    public ArrayList<SelectionModel> getSelectionItems() {
        return selectionItems;
    }

    public void setSelectionItems(ArrayList<SelectionModel> selectionItems) {
        this.selectionItems = selectionItems;
        this.selectionListSet = true;
    }

    public boolean isSelectionListSet() {
        return selectionListSet;
    }

    public CVSelectionItem.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(CVSelectionItem.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.selectionCallbackSet = true;
    }

    public void setSelectionListSet(boolean selectionListSet) {
        this.selectionListSet = selectionListSet;
    }

    public boolean isSelectionCallbackSet() {
        return selectionCallbackSet;
    }

    public void setSelectionCallbackSet(boolean selectionCallbackSet) {
        this.selectionCallbackSet = selectionCallbackSet;
    }
}
