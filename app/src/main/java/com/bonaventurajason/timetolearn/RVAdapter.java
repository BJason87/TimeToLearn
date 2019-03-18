package com.bonaventurajason.timetolearn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MovieViewHolder> {

    List<MovieData> movies;

    RVAdapter(List<MovieData> movies){
        this.movies = movies;
    }

    @NonNull
    @Override
    public RVAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);
        MovieViewHolder mvh = new MovieViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.MovieViewHolder movieViewHolder, int position) {
        movieViewHolder.movieName.setText(movies.get(position).name);
        movieViewHolder.movieYear.setText(movies.get(position).year);
        new DownloadImageTask(movieViewHolder.movieImage).execute(movies.get(position).imageUrl);


    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIconll = null;
            try{
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIconll = BitmapFactory.decodeStream(in);

            }catch (Exception e){
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIconll;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView movieName;
        TextView movieYear;
        ImageView movieImage;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            movieName = itemView.findViewById(R.id.movie_name);
            movieYear = itemView.findViewById(R.id.movie_year);
            movieImage = itemView.findViewById(R.id.movie_image);


        }
    }

}
