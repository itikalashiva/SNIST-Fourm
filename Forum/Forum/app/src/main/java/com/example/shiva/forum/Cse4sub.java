package com.example.shiva.forum;

/**
 * Created by shiva on 4/1/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cse4sub extends AppCompatActivity {
    private List<Subjects> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SubjectsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse3sub);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new SubjectsAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    //        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        recyclerView.addOnItemTouchListener(
                new SubjectsItemClickListener(getApplicationContext(), recyclerView ,new SubjectsItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        if(position==0)
                        {
                            //Toast.makeText(getApplicationContext(),"shiva",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(Cse4sub.this,St.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {

                            Intent intent= new Intent(Cse4sub.this,Ms.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {

                            Intent intent= new Intent(Cse4sub.this,Mc.class);
                            startActivity(intent);
                        }
                        else if(position==3)
                        {

                            Intent intent= new Intent(Cse4sub.this,Dwdm.class);
                            startActivity(intent);
                        }
                        else if(position==5)
                        {

                            Intent intent= new Intent(Cse4sub.this,Cvipr.class);
                            startActivity(intent);
                        }
                        else if(position==6)
                        {

                            Intent intent= new Intent(Cse4sub.this,Aca.class);
                            startActivity(intent);
                        }
                        else if(position==7)
                        {

                            Intent intent= new Intent(Cse4sub.this,Sl.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(getApplicationContext(),"orange",Toast.LENGTH_SHORT).show();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        prepareMovieData();





    }

    private void prepareMovieData() {

        Subjects movie = new Subjects("ST");
        movieList.add(movie);

        movie = new Subjects("MS");
        movieList.add(movie);

        movie = new Subjects("MC");
        movieList.add(movie);

        movie = new Subjects("DWDM");
        movieList.add(movie);

        movie = new Subjects("ES");
        movieList.add(movie);
        movie = new Subjects("CVPEIPR");
        movieList.add(movie);

        movie = new Subjects("ACA");
        movieList.add(movie);

        movie = new Subjects("HCI");
        movieList.add(movie);

        movie = new Subjects("ERS");
        movieList.add(movie);

        movie = new Subjects("SL");
        movieList.add(movie);

        movie = new Subjects("EC");
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }


}