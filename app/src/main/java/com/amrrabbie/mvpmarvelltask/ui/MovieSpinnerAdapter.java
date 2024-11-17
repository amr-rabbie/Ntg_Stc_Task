package com.amrrabbie.mvpmarvelltask.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.amrrabbie.mvpmarvelltask.R;
import com.amrrabbie.mvpmarvelltask.model.Result;
import com.amrrabbie.mvpmarvelltask.model.Thumbnail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieSpinnerAdapter  extends BaseAdapter implements SpinnerAdapter {

    List<Result> resultList;
    Context context;
    String[] colors = {"#13edea","#e20ecd","#15ea0d"};
    String[] colorsback = {"#FF000000","#FFF5F1EC","#ea950d"};

    public MovieSpinnerAdapter(Context context, List<Result> resultList) {
        this.resultList = resultList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Result getItem(int position) {
        return resultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =  View.inflate(context, R.layout.movie_spinner_item, null);
        TextView textView = (TextView) view.findViewById(R.id.txt);
        textView.setText(resultList.get(position).getName());
        Result result=resultList.get(position);

        ImageView img = (ImageView) view.findViewById(R.id.img);
        Thumbnail thumbnail = result.getThumbnail();

        String imgurl=thumbnail.getPath() + "/" + "portrait_uncanny" + "." + thumbnail.getExtension();

        Picasso.get()
                .load(imgurl)
                .resize(50, 50)
                .centerCrop()
                .into(img);

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        View view;
        view =  View.inflate(context, R.layout.movie_spinner_item, null);
        final TextView textView = (TextView) view.findViewById(R.id.txt);
        textView.setText(resultList.get(position).getName());

        textView.setTextColor(Color.parseColor(colors[position]));
        textView.setBackgroundColor(Color.parseColor(colorsback[position]));

        Result result=resultList.get(position);

        ImageView img = (ImageView) view.findViewById(R.id.img);
        Thumbnail thumbnail = result.getThumbnail();

        String imgurl=thumbnail.getPath() + "/" + "portrait_uncanny" + "." + thumbnail.getExtension();

        Picasso.get()
                .load(imgurl)
                .resize(50, 50)
                .centerCrop()
                .into(img);


        return view;
    }
}