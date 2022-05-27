package com.sata.movieclip.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sata.movieclip.Model.MovieListModel;
import com.sata.movieclip.R;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.AdapterHolder> {
    private Context context;
    private List<MovieListModel.Search> searches;

    public MovieListAdapter(Context context, List<MovieListModel.Search> searches){
        this.context = context;
        this.searches = searches;
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list_item,parent,false);
        AdapterHolder holder = new AdapterHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {
        final MovieListModel.Search search = searches.get(position);

        String title = search.getTitle();
        String poster = search.getPoster();
        String tahun = search.getYear();
        String type = search.getType();
        String imdbID = search.getImdbID();


    }

    @Override
    public int getItemCount() {
        return searches.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder{
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
