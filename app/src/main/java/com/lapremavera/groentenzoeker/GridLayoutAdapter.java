//package com.lapremavera.groentenzoeker;
//
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.BitmapFactory;
//import android.graphics.Point;
//import android.support.v7.widget.RecyclerView;
//import android.view.Display;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.widget.ImageView;
//
//import com.lapremavera.groentenzoeker.recycleview.MyRecyclerViewAdapter;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//public class GridLayoutAdapter extends MyRecyclerViewAdapter {
//
//    private Activity activity;
//    private ArrayList<String> images;
//    private int screenWidth;
//
//    public GridLayoutAdapter(Activity activity, ArrayList<String> images) {
//        super(thumbnail);
//        this.activity = activity;
//        this.images = images;
//        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        screenWidth = size.x;
//    }
//    public CustomRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(activity)
//                .inflate(R.layout.images_groente, parent, false);
//        Holder dataObjectHolder = new Holder(view);
//        return dataObjectHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    public void onBindViewHolder(final CustomRecycleViewHolder holder, final int position) {
//        final Holder myHolder = (Holder) holder;
//        BitmapFactory.Options opts = new BitmapFactory.Options();
//        opts.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(images.get(position), opts);
//        opts.inJustDecodeBounds = false;
//        Picasso.with(activity)
//                .load(images.get(position))
//                .placeholder(R.drawable.artisjok)
//                .resize(screenWidth / 2, 300)
//                .error(R.drawable.ic_empty)
//                .centerCrop()
//                .into((myHolder.images));
//    }
//    @Override
//    public int getItemCount() {
//        return images.size();
//    }
//    public class Holder extends CustomRecycleViewHolder {
//        private ImageView images;
//        public Holder(View itemView) {
//            super(itemView);
//            images = (ImageView) itemView.findViewById(R.id.ivItemGridImage);
//        }
//    }
//}
//


