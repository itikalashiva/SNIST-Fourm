package com.example.shiva.forum;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by shiva on 4/1/2017.
 */
public class Cseyears extends AppCompatActivity {
   Button y1,y2,y3,y4;
    private ArrayList  deom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.years);
        intiative();
    }
    public  void intiative(){

        RecyclerView rv = (RecyclerView)findViewById(R.id.rcv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        deom = new ArrayList<>();
        deom.add(new Deom("I YEAR", R.drawable.one1));
        deom.add(new Deom("II YEAR", R.drawable.two1));
        deom.add(new Deom("III YEAR", R.drawable.three1));
        deom.add(new Deom("IV YEAR", R.drawable.four));


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
                    if (position == 0) {
                        Toast.makeText(getApplicationContext(), "hai", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Cseyears.this, Cse1sub.class);
                        startActivity(i);
                    }

                    if (position == 1) {
                        Toast.makeText(getApplicationContext(), "hai", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Cseyears.this, Cse2sub.class);
                        startActivity(i);
                    }
                    if (position == 2) {
                        Intent i = new Intent(Cseyears.this, Cse3sub.class);
                        startActivity(i);
                    }if(position==3) {
                        Intent i = new Intent(Cseyears.this, Cse4sub.class);
                        startActivity(i);
                    }
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
