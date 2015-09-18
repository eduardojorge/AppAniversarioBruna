package com.emjorge.brunaniver;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter {
 private Context context;
 private int layoutResourceId;
 private ArrayList data = new ArrayList();

 public GridViewAdapter(Context context, int layoutResourceId, ArrayList data) {
 super(context, layoutResourceId, data);
 this.layoutResourceId = layoutResourceId;
 this.context = context;
 this.data = data;
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    ViewHolder holder = null;

    if (row == null) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();


        row = inflater.inflate(layoutResourceId, parent, false);

        //row = inflater.inflate(layoutResourceId, null);

    holder = new ViewHolder();
    //holder.imageTitle = (TextView) row.findViewById(R.id.text);
    holder.image = (ImageView) row.findViewById(R.id.image);
    row.setTag(holder);


       // holder.image.setLayoutParams(new GridView.LayoutParams(85, 85));
        holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.image.setPadding(0, 0, 0, 0);

    } else {
        holder = (ViewHolder) row.getTag();
    }

 ImageItem item = (ImageItem)data.get(position);
 //holder.imageTitle.setText(item.getTitle());
 holder.image.setImageBitmap(item.getImage());
 return row;
 }

 static class ViewHolder {
 TextView imageTitle;
 ImageView image;
 }
 }