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

public class Cse3sub extends AppCompatActivity {
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
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        recyclerView.addOnItemTouchListener(
                new SubjectsItemClickListener(getApplicationContext(), recyclerView ,new SubjectsItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        if(position==0)
                        {
                            Toast.makeText(getApplicationContext(),"shiva",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(Cse3sub.this,Os.class);
                            startActivity(intent);
                        }
                        else if(position==1)
                        {
                            //Toast.makeText(getApplicationContext(),"shiva",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(Cse3sub.this,Cn.class);
                            startActivity(intent);
                        }
                        else if(position==2)
                        {
                            Intent intent= new Intent(Cse3sub.this,Toc.class);
                            startActivity(intent);
                        }
                        else if(position==3)
                        {
                            Intent intent= new Intent(Cse3sub.this,Or.class);
                            startActivity(intent);
                        }
                        else if(position==4)
                        {
                            Intent intent= new Intent(Cse3sub.this,Ooad.class);
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

        Subjects movie = new Subjects("OPERATING SYSTEMS(OS)");
        movieList.add(movie);

        movie = new Subjects("COMPUTER NETWORKS(CN)");
        movieList.add(movie);

        movie = new Subjects("THEORY OF COMPUTATION(TOC)");
        movieList.add(movie);

        movie = new Subjects("OPERATIONS RESEARCH(OR)");
        movieList.add(movie);

        movie = new Subjects("OBJECT ORIENTED ANALYSIS AND DESIGN(OOAD)");
        movieList.add(movie);
        movie = new Subjects("SOFTWARE ENGINEERING(SE)");
        movieList.add(movie);

        movie = new Subjects("ENTERPRENURSHIP(EP)");
        movieList.add(movie);

        movie = new Subjects("PRODUCT AND SERVICE DESIGN(PSD)");
        movieList.add(movie);

        movie = new Subjects("WEB TECHNOLOGIES(WT)");
        movieList.add(movie);

        movie = new Subjects("COMPUTER GRAPHICS(CG)");
        movieList.add(movie);

        movie = new Subjects("COMPILER DESIGN(CD)");
        movieList.add(movie);

        movie = new Subjects("INFORMATION SECURITY(IS)");
        movieList.add(movie);
        movie = new Subjects("BANKING OPERATIONS INSURANCE AND RISK MANAGEMENT(BOIRM)");
        movieList.add(movie);





        mAdapter.notifyDataSetChanged();
    }


}