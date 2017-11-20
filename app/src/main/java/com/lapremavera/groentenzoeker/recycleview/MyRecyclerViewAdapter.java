package com.lapremavera.groentenzoeker.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.lapremavera.Groente;
import com.lapremavera.groentenzoeker.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter{

    private final Integer[] thumbnail;
    private final Context context;
    private List<Groente> groenteList;
    private AdapterView.OnItemClickListener onItemClickListener;
    private AdapterView.OnItemLongClickListener onItemLongClickListener;
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
    private void onItemHolderClick(CustomRecycleViewHolder itemHolder) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }
    private void onItemHolderLongClick(CustomRecycleViewHolder itemHolder) {
        if (onItemLongClickListener != null) {
            onItemLongClickListener.onItemLongClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }

    public MyRecyclerViewAdapter(Integer[] thumbnail, Context context, List<Groente> groenteList) {
    this.context = context;
    this.groenteList = groenteList;
    this.thumbnail = thumbnail;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.images_groente, parent, false);
        return new CustomRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CustomRecycleViewHolder crv = (CustomRecycleViewHolder) holder;
       // Integer currentGroente = thumbnail[position];
//        crv.groenteImage.setImageResource(currentGroente);
//        Picasso.with(context).load(currentGroente).into(crv.groenteImage);


        String url = groenteList.get(position).getUrlAfbeelding();
        if (url != "" && url != null) {
            Picasso.with(context).load( groenteList.get(position).getUrlAfbeelding()).into(crv.groenteImage);

        }
        else {
            //TODO
        }

          }

    @Override
    public int getItemCount() {
        return groenteList.size();
    }

    public class CustomRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        ImageView groenteImage;
        public CustomRecycleViewHolder(View itemView) {
            super(itemView);
            groenteImage = itemView.findViewById(R.id.ivItemGridImage);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        @Override
        public void onClick(View v) {
            onItemHolderClick(this);
        }
        @Override
        public boolean onLongClick(View v) {
            onItemHolderLongClick(this);
            return true;
        }
    }
}
