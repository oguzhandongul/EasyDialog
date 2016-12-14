package com.oguzhandongul.easydialog.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.oguzhandongul.easydialog.DialogDataModel;
import com.oguzhandongul.easydialog.FontCacheHelper;
import com.oguzhandongul.easydialog.R;
import com.oguzhandongul.easydialog.adapters.AdapterSelectionItemList;
import com.oguzhandongul.easydialog.customviews.CVDialogButton;
import com.oguzhandongul.easydialog.customviews.CVSelectionItem;
import com.oguzhandongul.easydialog.models.SelectionModel;
import com.oguzhandongul.easydialog.utils.DrawableCreator;

import java.util.ArrayList;

/**
 * Created by oguzhandongul on 23/09/2016.
 */

public class SelectionDialogFragment extends BaseDialogFragment implements DialogInterface.OnCancelListener {

    RelativeLayout rlParent;
    CVDialogButton cvPositive;
    DialogDataModel dialogDataModel;

    ImageView ivCheck;
    BaseDialogFragment instance = this;

    private RecyclerView.LayoutManager layoutManager;
    RecyclerView rvSelection;
    private AdapterSelectionItemList adapterSelectionItemList;
    private ArrayList<Object> selectionItemsList = new ArrayList<>();
    CVSelectionItem.OnItemClickListener onItemClickListener;


    public SelectionDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static SelectionDialogFragment newInstance(DialogDataModel dialogDataModel) {
        SelectionDialogFragment frag = new SelectionDialogFragment();
        frag.setDialogDataModel(dialogDataModel);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share_dialog, container);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rlParent = (RelativeLayout) view.findViewById(R.id.rlParent);
        cvPositive = (CVDialogButton) view.findViewById(R.id.cvPositive);
        ivCheck = (ImageView) view.findViewById(R.id.ivCheck);
        rvSelection = (RecyclerView) view.findViewById(R.id.rvShare);


        cvPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectionDialogFragment.this.dismiss();
            }
        });

        setDataModel();
        super.onViewCreated(view, savedInstanceState);

    }

    private void initRecycler() {
        ArrayList<SelectionModel> selectionItem = dialogDataModel.getSelectionItems();

        if (adapterSelectionItemList == null) {
            adapterSelectionItemList = new AdapterSelectionItemList(selectionItemsList, getActivity(), null, onItemClickListener);
            adapterSelectionItemList.setPaginationEnabled(false);

            layoutManager = new LinearLayoutManager(getActivity());
            rvSelection.setLayoutManager(layoutManager);
            rvSelection.setAdapter(adapterSelectionItemList);
        }

        for (int i = 0; i < selectionItem.size(); i++) {
            adapterSelectionItemList.addItem(selectionItem.get(i), adapterSelectionItemList.getItemCount());
        }
    }

    private void setDataModel() {
        if (dialogDataModel != null) {

            if (dialogDataModel.isDialogFontSet()) {
                cvPositive.getTextView().setTypeface(FontCacheHelper.getFontOrGenerateOne(dialogDataModel.getDialogFont(), getActivity()));
            }



            //Icon
            if (dialogDataModel.isIconSet()) {
                ivCheck.setImageResource(dialogDataModel.getDialogIcon());

            }
            if (dialogDataModel.isIconColorSet()) {
                DrawableCreator.overlayImageColor(ivCheck, ContextCompat.getColor(getActivity(), dialogDataModel.getDialogIconColor()));

            }
            if (dialogDataModel.isIconBgColorSet()) {
                new DrawableCreator.Builder(getActivity())
                        .shape(DrawableCreator.Builder.SHAPE_OVAL)
                        .radius(40)
                        .strokeColor(0xFFFFFFFF)
                        .backgroundColor(ContextCompat.getColor(getActivity(), dialogDataModel.getDialogIconBgColor()))
                        .strokeWidth(2)
                        .createBackground(ivCheck);

            }

            //Corners
            int cornerRadius = 5;
            if (dialogDataModel.isCornerRadiusSet()) {
                cornerRadius = dialogDataModel.getDialogCornerRadius();
            }

            //Positive Button
            if (dialogDataModel.isPositiveSet()) {
                cvPositive.setVisibility(View.VISIBLE);
                cvPositive.getTextView().setText(dialogDataModel.getPositiveText());
                int color = R.color.green;

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

                cvPositive.setBackground(new DrawableCreator.Builder(getActivity()).createLayerList(ContextCompat.getColor(getActivity(), color), DrawableCreator.getDarkerColor(ContextCompat.getColor(getActivity(), color), 0.85f), cornerRadius));
            }


            if (dialogDataModel.isDialogCancelTouchOutside()) {
                rlParent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SelectionDialogFragment.this.dismiss();
                    }
                });
            }

            if(dialogDataModel.isSelectionCallbackSet()){
                setOnItemClickListener(new CVSelectionItem.OnItemClickListener() {
                    @Override
                    public void onSelectionClick(int id, BaseDialogFragment dialogFragment) {
                        dialogDataModel.getOnItemClickListener().onSelectionClick(id, SelectionDialogFragment.this);
                    }
                });
            }

            if (dialogDataModel.isSelectionListSet()) {
                initRecycler();
            }

        }
    }


    public void setDialogDataModel(DialogDataModel dialogDataModel) {
        this.dialogDataModel = dialogDataModel;
    }

    public void setOnItemClickListener(CVSelectionItem.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}