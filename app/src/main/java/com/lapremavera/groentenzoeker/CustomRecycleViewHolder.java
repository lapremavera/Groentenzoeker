//package com.lapremavera.groentenzoeker;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.AdapterView;
//
//
//public class CustomRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
//
//    public CustomRecycleViewHolder(View itemView) {
//        super(itemView);
//        itemView.setOnClickListener(this);
//        itemView.setOnLongClickListener(this);
//    }
//    @Override
//    public void onClick(View view) {
//        onItemHolderClick(this);
//
//    }
//
//    @Override
//    public boolean onLongClick(View view) {
//        onItemHolderLongClick(this);
//        return true;
//    }
//
//    private AdapterView.OnItemClickListener onItemClickListener;
//    private AdapterView.OnItemLongClickListener onItemLongClickListener;
//    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
//    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
//        this.onItemLongClickListener = onItemLongClickListener;
//    }
//    private void onItemHolderClick(CustomRecycleViewHolder itemHolder) {
//        if (onItemClickListener != null) {
//            onItemClickListener.onItemClick(null, itemHolder.itemView,
//                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
//        }
//    }
//    private void onItemHolderLongClick(CustomRecycleViewHolder itemHolder) {
//        if (onItemLongClickListener != null) {
//            onItemLongClickListener.onItemLongClick(null, itemHolder.itemView,
//                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
//        }
//    }
//}

