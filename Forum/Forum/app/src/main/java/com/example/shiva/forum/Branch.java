package com.example.shiva.forum;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Branch extends AppCompatActivity {
    private ArrayList  deom;
    private com.github.clans.fab.FloatingActionButton rams,ak,frn;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        textView =(TextView)findViewById(R.id.name);

        ak=(com.github.clans.fab.FloatingActionButton)findViewById(R.id.button_deep);
        ak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        rams=(com.github.clans.fab.FloatingActionButton)findViewById(R.id.button_ak);
        rams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        frn=(com.github.clans.fab.FloatingActionButton)findViewById(R.id.button_rams);
        frn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast.makeText(getApplicationContext(),"logout",Toast.LENGTH_LONG).show();
                SharedPreferences sharedpreferences = getSharedPreferences(Signin.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });

        intiative();
    }

    public  void intiative(){

        RecyclerView rv = (RecyclerView)findViewById(R.id.rcv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);


        deom = new ArrayList<>();
        deom.add(new Deom("Electronics and Communication", R.drawable.ece));
        deom.add(new Deom("Electrical Engineering", R.drawable.eee));
        deom.add(new Deom("Compute Science", R.drawable.csedark));
        deom.add(new Deom("Information Technology", R.drawable.it));
        deom.add(new Deom("Electronics and Computers", R.drawable.ecm));
        deom.add(new Deom("Mechanical Engineering", R.drawable.mech));
        deom.add(new Deom("Bio Technology", R.drawable.biotech));

        RVAdapter adapter = new RVAdapter(deom);
        rv.setAdapter(adapter);

        rv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    if(position==0) {
                        Toast.makeText(getApplicationContext(), "hai", Toast.LENGTH_SHORT).show();

                    }

                    if(position==2) {

                       Intent i =new Intent(Branch.this,Cseyears.class);
                        startActivity(i);
                    }
                    if(position==6) {

                    }
                    else
                        Toast.makeText(getApplicationContext(),"bye", Toast.LENGTH_SHORT).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }



}