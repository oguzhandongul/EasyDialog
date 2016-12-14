package com.oguzhandongul.easydialog.adapters;

/**
 * Created by Oguzhan on 30.11.2015.
 */

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterBase extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static String LOG_TAG = "AdapterBase";
    public static final int TYPE_LOAD = -1;
    private Context context;
    private ArrayList<Object> objects;
    private OnLoadListener onLoadListener;
    private RecyclerView recyclerView;
    private boolean isPaginationEnabled = false;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private int page = 0;


    public AdapterBase(ArrayList<Object> objects, Context context, OnLoadListener onLoadListener) {
        this.context = context;
        this.onLoadListener = onLoadListener;
        this.objects = objects;
    }

    public AdapterBase(ArrayList<Object> objects, Context context) {
        this.context = context;
        this.objects = objects;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = onCreateCustomViewHolder(parent, viewType);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (objects.get(position) instanceof LoadingItem) {
            Log.d("ADAPTER", "onBindViewHolder: Loading item");
            return;
        }
        onBindCustomViewHolder(holder, position);

    }

    protected RecyclerView.ViewHolder onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    protected void onBindCustomViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


    public void addItem(Object dataObj, int index) {
        objects.add(dataObj);
        notifyItemInserted(index);
    }

    public void removeItem(int index) {
        objects.remove(index);
        notifyItemRemoved(index);
    }

    public void removeAllItems() {
        objects.clear();
        notifyDataSetChanged();
    }

    public void hideLoadingItem() {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) instanceof LoadingItem) {
                objects.remove(i);
                notifyItemRemoved(i);
                return;
            }
        }

    }

    public void addLoadingItem() {
        objects.add(new LoadingItem());

        recyclerView.post(new Runnable() {
            public void run() {
                notifyItemInserted(getItemCount() - 1);
            }
        });
    }


    public void setPaginationEnabled(boolean paginationEnabled) {
        isPaginationEnabled = paginationEnabled;
    }

    public void setPaginationListener(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        recyclerView.addOnScrollListener(paginationListener);
    }

    RecyclerView.OnScrollListener paginationListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            visibleItemCount = recyclerView.getLayoutManager().getChildCount();
            totalItemCount = recyclerView.getLayoutManager().getItemCount();

            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                pastVisiblesItems = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                pastVisiblesItems = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            } else {
                int[] firstVisibleItems = null;
                firstVisibleItems = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPositions(firstVisibleItems);
                if (firstVisibleItems != null && firstVisibleItems.length > 0) {
                    pastVisiblesItems = firstVisibleItems[0];
                }
            }

            if (isPaginationEnabled) {
                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    isPaginationEnabled = false;
                    page++;
                    addLoadingItem();
                    if (onLoadListener != null) {
                        onLoadListener.makeRequest(page);

                    }
                }
            }
        }

    };

    @Override
    public int getItemCount() {
        return objects.size();
    }


    public interface OnLoadListener {
        void makeRequest(int page);

    }

    public class LoadingItem {

        public LoadingItem() {
        }
    }

    @Override
    public int getItemViewType(int position) {

        return 1;
    }
}