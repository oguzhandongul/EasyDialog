package com.oguzhandongul.easydialog.customviews;

import android.content.Context;
import android.support.design.internal.ForegroundLinearLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzhandongul.easydialog.R;
import com.oguzhandongul.easydialog.dialogs.BaseDialogFragment;
import com.oguzhandongul.easydialog.models.SelectionModel;


public class CVSelectionItem extends ForegroundLinearLayout {
    Context mContext;
    SelectionModel currentData = null;

    public TextView tvTitle;
    public ImageView ivShare;
    public  int id;
    CVSelectionItem.OnItemClickListener onItemClickListener;

    public CVSelectionItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
        this.setForeground(ContextCompat.getDrawable(getContext(), R.drawable.flat_button_dark));
    }


    public CVSelectionItem(Context context) {
        super(context);
    }

    public void init() {
        LayoutInflater.from(mContext).inflate(R.layout.customview_share_item, this);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        ivShare = (ImageView) findViewById(R.id.ivShare);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                onItemClickListener.onSelectionClick(id,null);
            }
        });


    }

    public void setData(final SelectionModel currentData, final CVSelectionItem.OnItemClickListener onItemClickListener) {
        this.currentData = currentData;
        this.onItemClickListener = onItemClickListener;
        id = currentData.getId();
        ivShare.setImageResource(currentData.getShareIcon());
        tvTitle.setText(currentData.getShareTitle());
    }

    public interface OnItemClickListener {
        public void onSelectionClick(int id, BaseDialogFragment dialogFragment);
    }
}