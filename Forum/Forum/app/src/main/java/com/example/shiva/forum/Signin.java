package com.example.shiva.forum;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
ImageView back;
    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
private  TextView signin,topsignin;
    public static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if ((sharedpreferences.getBoolean(IS_USER_LOGIN,false)))
        {
            Intent intent = new Intent(Signin.this,Branch.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_signin);
        auth = FirebaseAuth.getInstance();
        Toast.makeText(this,"hai",Toast.LENGTH_LONG).show();

        inputEmail = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);
        signin=(TextView)findViewById(R.id.signin);
        topsignin=(TextView)findViewById(R.id.topsignin);
        back = (ImageView)findViewById(R.id.back);
        Typeface mytypeface=Typeface.createFromAsset(getAssets(),"bot.ttf");
        signin.setTypeface(mytypeface);
        topsignin.setTypeface(mytypeface);
        inputEmail.setTypeface(mytypeface);
        inputPassword.setTypeface(mytypeface);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }



                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(Signin.this, "authfailed", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    //Intent intent = new Intent(Signin.this, MainActivity.class);
                                    //startActivity(intent);
                                    //finish();
                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putBoolean(IS_USER_LOGIN, true);
                                    editor.commit();

                                    Toast.makeText(Signin.this, "sucess", Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(Signin.this,Branch.class);
                                    startActivity(intent);
                                }
                            }
                        });

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent it = new Intent(Signin.this, MainActivity.class);
                startActivity(it);

            }
        });

    }
}
