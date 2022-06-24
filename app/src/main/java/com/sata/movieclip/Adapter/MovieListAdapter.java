package com.sata.movieclip.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sata.movieclip.DetailActivity;
import com.sata.movieclip.MainActivity;
import com.sata.movieclip.Model.MovieListModel;
import com.sata.movieclip.R;
import com.squareup.picasso.Picasso;

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

        String deskripsi = "Type: "+type +" | Tahun :"+tahun;
        holder.tvTitle.setText(title.toString());
        holder.tvDeskripsi.setText(deskripsi);
        Picasso.get().load(poster).into(holder.imgPoster);

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("imdbID",imdbID);
                intent.     putExtra("title",title);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searches.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvDeskripsi;
        ImageView imgPoster;
        Button btnDetail;

        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.judulFilem);
            tvDeskripsi = itemView.findViewById(R.id.deskripsiFilem);
            imgPoster = itemView.findViewById(R.id.imgPoster);
            btnDetail = itemView.findViewById(R.id.btnDetail);

        }
    }
}
