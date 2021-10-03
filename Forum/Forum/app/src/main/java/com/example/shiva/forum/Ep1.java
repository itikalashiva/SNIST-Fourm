package com.example.shiva.forum;

/**
 * Created by shiva on 4/2/2017.
 */
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Ep1 extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference db;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Row> rows = new ArrayList<Row>();
    RecyclerViewAdapter rva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os);

        recyclerView=(RecyclerView) findViewById(R.id.rv);
        rows=new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        db= FirebaseDatabase.getInstance().getReference("ep1");

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                datachanged(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    void datachanged(DataSnapshot ds)
    {
        rows=new ArrayList<>();
        for(DataSnapshot data : ds.getChildren()) {
            Row r = data.getValue(Row.class);
            rows.add(r);
            rva = new RecyclerViewAdapter(this, rows);
            recyclerView.setAdapter(rva);
        }
    }
}

