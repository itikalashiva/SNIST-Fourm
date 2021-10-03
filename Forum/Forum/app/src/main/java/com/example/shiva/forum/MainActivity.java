package com.example.shiva.forum;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView signin;
    TextView signup,quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




            setContentView(R.layout.activity_main);


            signin = (TextView) findViewById(R.id.signin);
            signup = (TextView) findViewById(R.id.signup);
        quote = (TextView) findViewById(R.id.quote);
        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"bot.ttf");
        signin.setTypeface(mytypeface);
        signup.setTypeface(mytypeface);
        quote.setTypeface(mytypeface);
            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, Signin.class));
                }
            });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Signup.class);
                    startActivity(intent);
                }
            });
        }

}