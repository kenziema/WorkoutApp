package com.UAS.uasmobprog;

import android.content.Context;
import android.graphics.Movie;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.UAS.uasmobprog.model.Result;
import com.bumptech.glide.Glide;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Result> dataList;
    private Context context;

    public CustomAdapter(Context context, List<Result> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.movieTitle.setText(dataList.get(position).getTitle());
        holder.movieDescription.setText(dataList.get(position).getOverview());
//        Picasso.Builder pBuilder = new Picasso.Builder(context);
//        pBuilder.downloader(new OkHttp3Downloader(context));
//        pBuilder.build().load(dataList.get(position).getPosterPath())
//                .error(R.drawable.ic_launcher_background)
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(holder.imgPoster);

        Glide.with(context).load("https://image.tmdb.org/t/p/w185" + dataList.get(position)
                .getPosterPath())
                .into(holder.imgPoster);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPoster;
        TextView movieTitle, movieDescription;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.imgMovie);
            movieTitle = itemView.findViewById(R.id.movieTitle);
            movieDescription = itemView.findViewById(R.id.movieDescription);
        }
    }
}
