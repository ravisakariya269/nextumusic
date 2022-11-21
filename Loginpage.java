package com.example.nextu;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loginpage extends AppCompatActivity {

    EditText username,password;
    Button loginbtn;
    TextView createaccount;
    String emailpatten = "[A_Za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        if(getActionBar()!= null)
        {
            getActionBar().hide();
        }

        username =findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        createaccount = findViewById(R.id.createaccount);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Loginpage.this);


        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Register = new Intent(Loginpage.this,Register.class);
                startActivity(Register);
            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                perforauth();
            }
        });
    }

    private void perforauth() {
        String Email = username.getText().toString();
        String Password = password.getText().toString();

        if(!Email.matches(emailpatten))
        {
            username.setError("Please Valid Email");
        }
        else if(Password.isEmpty() || Password.length()<5)
        {
            password.setError("Please proper Password");
        }

        else
        {
            progressDialog.setMessage("Please Waiting....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

        }
        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
//                    progressDialog.dismiss();
                    Toast.makeText(Loginpage.this,"Login Successful", Toast.LENGTH_SHORT).show();
                    sendUserToNextActivvity();
                }
                else
                {
//                    progressDialog.dismiss();
                    Toast.makeText(Loginpage.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                }
            }

            private void sendUserToNextActivvity() {
                Intent Main = new Intent(Loginpage.this, Homepage.class);
                startActivity(Main);
                finish();

            }
        });

    }
}