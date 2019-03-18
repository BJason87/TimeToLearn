package com.bonaventurajason.timetolearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<MovieData> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initializedata();
        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RVAdapter(movies));
    }

    private void initializedata() {
        movies = new ArrayList<>();
        movies.add(new MovieData("Harry Potter and the Sorcerer Stone", "https://m.media-amazon.com/images/M/MV5BNjQ3NWNlNmQtMTE5ZS00MDdmLTlkZjUtZTBlM2UxMGFiMTU3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg","2001"));
        movies.add(new MovieData("Harry Potter and the Chamber of Secrets", "https://m.media-amazon.com/images/M/MV5BMTcxODgwMDkxNV5BMl5BanBnXkFtZTYwMDk2MDg3._V1_.jpg","2002"));
        movies.add(new MovieData("Harry Potter and the Prisoner of Azkaban", "https://m.media-amazon.com/images/M/MV5BMTY4NTIwODg0N15BMl5BanBnXkFtZTcwOTc0MjEzMw@@._V1_SY1000_CR0,0,676,1000_AL_.jpg","2004"));
        movies.add(new MovieData("Harry Potter and the Goblet of Fire", "https://m.media-amazon.com/images/M/MV5BMTI1NDMyMjExOF5BMl5BanBnXkFtZTcwOTc4MjQzMQ@@._V1_.jpg","2005"));
        movies.add(new MovieData("Harry Potter and the Order of the Phoenix", "https://m.media-amazon.com/images/M/MV5BMTM0NTczMTUzOV5BMl5BanBnXkFtZTYwMzIxNTg3._V1_.jpg","2007"));
    }
}
