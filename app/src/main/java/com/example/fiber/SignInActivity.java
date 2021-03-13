package com.example.fiber;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fiber.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    ActivitySignInBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignInBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        auth=FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog(SignInActivity.this);
        progressDialog.setTitle("login");
        progressDialog.setMessage("Login to your account");
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                auth.signInWithEmailAndPassword(binding.etEmail.getText().toString(),binding.etPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                                else{

                                    Toast.makeText(SignInActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

        if(auth.getCurrentUser()!=null)
        {
            Intent intent=new Intent(SignInActivity.this,MainActivity.class);
            startActivity(intent);
        }

    }
}