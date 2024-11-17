package com.amrrabbie.mvpmarvelltask.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.amrrabbie.mvpmarvelltask.R;
import com.amrrabbie.mvpmarvelltask.model.Marvell;
import com.amrrabbie.mvpmarvelltask.model.Result;
import com.amrrabbie.mvpmarvelltask.model.Thumbnail;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;


public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder> {

    List<Result> resultList;

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int)v.getTag();
                Result result = resultList.get(pos);
                //Toast.makeText(parent.getContext(), "Movie Name: " + result.getName(), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(parent.getContext(),DetailsActivity.class);
                intent.putExtra("result",(Serializable) result);
                parent.getContext().startActivity(intent);
            }
        });

        return new MoviesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {

        holder.txt.setText(resultList.get(position).getName());

        Result result=resultList.get(position);

        Thumbnail thumbnail = result.getThumbnail();

        String imgurl=thumbnail.getPath() + "/" + "portrait_uncanny" + "." + thumbnail.getExtension();

        Picasso.get()
                .load(imgurl)
                .resize(50, 50)
                .centerCrop()
                .into(holder.img);

        holder.cview.setTag(position);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView img;
        CardView cview;
        public MoviesViewHolder(@NonNull View v) {
            super(v);
            txt=v.findViewById(R.id.txt);
            img=v.findViewById(R.id.img);
            cview=v.findViewById(R.id.cview);
        }
    }

    public void setList(List<Result> resultList){
        this.resultList=resultList;
    }
}
