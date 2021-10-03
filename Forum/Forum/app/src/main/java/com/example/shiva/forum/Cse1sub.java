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

public class Cse1sub extends AppCompatActivity {
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
       // recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        recyclerView.addOnItemTouchListener(
                new SubjectsItemClickListener(getApplicationContext(), recyclerView ,new SubjectsItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        if(position==0)
                        {
                            //Toast.makeText(getApplicationContext(),"shiva",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(Cse1sub.this,Cp.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {

                            Intent intent= new Intent(Cse1sub.this,Ep1.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {

                            Intent intent= new Intent(Cse1sub.this,Ec1.class);
                            startActivity(intent);
                        }
                        else if(position==3)
                        {

                            Intent intent= new Intent(Cse1sub.this,Dsc.class);
                            startActivity(intent);
                        }
                        else if(position==4)
                        {

                            Intent intent= new Intent(Cse1sub.this,Ep2.class);
                            startActivity(intent);
                        }
                        else if(position==5)
                        {

                            Intent intent= new Intent(Cse1sub.this,Ec2.class);
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

        Subjects movie = new Subjects("COMPUTER PROGRAMMING(CP)");
        movieList.add(movie);

        movie = new Subjects("PHYSICS-I");
        movieList.add(movie);

        movie = new Subjects("CHEMISTRY-I");
        movieList.add(movie);

        movie = new Subjects("DATA STRUCTURES(DS&C++)");
        movieList.add(movie);

        movie = new Subjects("PHYSICS-II");
        movieList.add(movie);
        movie = new Subjects("CHEMISTRY-II");
        movieList.add(movie);

        movie = new Subjects("BASIC MECHANICAL ENGINEERING(BME)");
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }


}