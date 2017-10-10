package com.lapremavera.groentenzoeker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
    public Integer []thumbnail = {
            R.drawable.artisjok, R.drawable.broccoli,
            R.drawable.courgette, R.drawable.doperwt,
            R.drawable.tomaat, R.drawable.rucola
    };
    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return thumbnail.length;
    }

    @Override
    public Object getItem(int position) {
        return thumbnail[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(thumbnail[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 200));
        return imageView;
    }
}
