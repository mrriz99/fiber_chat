package com.example.fiber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fiber.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
     ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
    }
}