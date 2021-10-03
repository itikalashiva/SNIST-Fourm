package com.example.shiva.forum;

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

public class Cse2sub extends AppCompatActivity {
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
                           // Toast.makeText(getApplicationContext(),"shiva",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(Cse2sub.this,Oopj.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {

                            Intent intent= new Intent(Cse2sub.this,Mfcs.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {

                            Intent intent= new Intent(Cse2sub.this,Stld.class);
                            startActivity(intent);
                        }
                        else if(position==3)
                        {

                            Intent intent= new Intent(Cse2sub.this,Edc.class);
                            startActivity(intent);
                        }
                        else if(position==4)
                        {

                            Intent intent= new Intent(Cse2sub.this,Bee.class);
                            startActivity(intent);
                        }
                        else if(position==5)
                        {

                            Intent intent= new Intent(Cse2sub.this,Dbms.class);
                            startActivity(intent);
                        }
                        else if(position==6)
                        {

                            Intent intent= new Intent(Cse2sub.this,Daa.class);
                            startActivity(intent);
                        }
                        else if(position==7)
                        {

                            Intent intent= new Intent(Cse2sub.this,Compi.class);
                            startActivity(intent);
                        }
                        else if(position==8)
                        {

                            Intent intent= new Intent(Cse2sub.this,PS.class);
                            startActivity(intent);
                        }
                        else if(position==9)
                        {

                            Intent intent= new Intent(Cse2sub.this,Dc.class);
                            startActivity(intent);
                        }
                        else if(position==10)
                        {

                            Intent intent= new Intent(Cse2sub.this,Mefa.class);
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

        Subjects movie = new Subjects("OBJECTT ORIENTED PROGRAMMING THROUGH JAVA(OOPJ)");
        movieList.add(movie);

        movie = new Subjects("MATHEMATICAL FOUNDATIONS OF COMPUTER SCIENCE(MFCS)");
        movieList.add(movie);

        movie = new Subjects("SWITCHING THEORY AND LOGIC DESIGN(STLD)");
        movieList.add(movie);

        movie = new Subjects("BASIC ELECTRONICS(BE,EDC)");
        movieList.add(movie);

        movie = new Subjects("BASIC ELECTRICAL ENGINEERING(BEE)");
        movieList.add(movie);
        movie = new Subjects("DATA BASE MANAGEMENT SYSTEMS(DBMS)");
        movieList.add(movie);

        movie = new Subjects("DESIGN AND ANALYSIS OF ALGORITHMS(DAA)");
        movieList.add(movie);

        movie = new Subjects("COMPUTER ORGANIZATION AND MICROPROCESSOR AND INTERFACING(COMPI)");
        movieList.add(movie);

        movie = new Subjects("PROBABILITY AND STATISTICS(P&S)");
        movieList.add(movie);

        movie = new Subjects("DATA COMMUNICATIONS(DC)");
        movieList.add(movie);

        movie = new Subjects("MANERGERIAL ECONOMICS & FINANCIAL ANALYSIS(MEFA)");
        movieList.add(movie);

        movie = new Subjects("COMPREHENSIVE VIVA I");
        movieList.add(movie);





        mAdapter.notifyDataSetChanged();
    }


}
