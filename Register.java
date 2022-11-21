package com.example.nextu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class Register extends AppCompatActivity {

    Button btnregister;
    EditText firstname,lastname,email,password1;
    TextView loginp;
    String emailpatten = "[A_Za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressbar;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        password1 = findViewById(R.id.password1);
        btnregister = findViewById(R.id.btnregister);
        loginp = findViewById(R.id.loginp);
        mAuth = FirebaseAuth.getInstance();
        progressbar = new ProgressDialog(Register.this);

        loginp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(Register.this,Loginpage.class);
                startActivity(Login);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                perforauth();
            }
        });
    }

    private void perforauth() {
        String Email = email.getText().toString();
        String Password = password1.getText().toString();

        if(!Email.matches(emailpatten))
        {
            email.setError("Please Valid Email");
        }
        else if(Password.isEmpty() || Password.length()<6)
        {
            password1.setError("Please proper Password");
        }

        else
        {
            progressbar.setMessage("Please Waiting....");
            progressbar.setTitle("Registration");
            progressbar.setCanceledOnTouchOutside(false);
            progressbar.show();

            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
//                        progressbar.dismiss();
                        Toast.makeText(Register.this,"Registation", Toast.LENGTH_SHORT).show();
                        sendUserToNextActivity();
                    }
                    else
                    {
//                        progressbar.dismiss();
                        Toast.makeText(Register.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {

        Intent Main = new Intent(Register.this,Loginpage.class);
        startActivity(Main);

    }
}
