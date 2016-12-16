package com.oguzhandongul.easydialog.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oguzhandongul.easydialog.R;
import com.oguzhandongul.easydialog.customviews.CVSelectionItem;
import com.oguzhandongul.easydialog.models.SelectionModel;

import java.util.ArrayList;

/**
 * Created by oguzhandongul on 02/11/2016.
 */

public class AdapterSelectionItemList extends AdapterBase {

    private Context context;
    private ArrayList<Object> objects;
    private CVSelectionItem.OnItemClickListener onItemClickListener;
    private String font;

    public AdapterSelectionItemList(ArrayList<Object> objects, Context context, OnLoadListener onLoadListener,String font, CVSelectionItem.OnItemClickListener onItemClickListener) {
        super(objects, context, onLoadListener);
        this.objects = objects;
        this.context = context;
        this.font = font;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateCustomViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_share_items, parent, false);
        return new ShareObjectHolder(view);

    }

    @Override
    protected void onBindCustomViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindCustomViewHolder(holder, position);
        ((ShareObjectHolder) holder).cvShare.setData((SelectionModel) objects.get(position),font, onItemClickListener);
    }


    public static class ShareObjectHolder extends RecyclerView.ViewHolder {
        CVSelectionItem cvShare;

        public ShareObjectHolder(View itemView) {
            super(itemView);
            cvShare = (CVSelectionItem) itemView.findViewById(R.id.cvShare);
        }

    }


    @Override
    public int getItemViewType(int position) {
        if (objects.get(position) instanceof LoadingItem) {
            return TYPE_LOAD;
        }
        return 1;
    }
}
