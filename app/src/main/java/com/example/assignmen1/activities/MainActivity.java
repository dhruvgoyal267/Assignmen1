package com.example.assignmen1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.assignmen1.R;
import com.example.assignmen1.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    MainActivityPresenter presenter;
    EditText userName,email,password,phone;
    AppCompatButton signUpButton;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.userName);
        email = findViewById(R.id.userEmail);
        password = findViewById(R.id.userPassword);
        phone = findViewById(R.id.userPhoneNumber);
        signUpButton = findViewById(R.id.signUpButton);
        progressBar = findViewById(R.id.progressBar);

        presenter = new MainActivityPresenter(this);

        signUpButton.setOnClickListener(v -> {
            presenter.updateUser(userName.getText().toString(),email.getText().toString(),password.getText().toString(),phone.getText().toString());
            presenter.signUp();
        });
    }

    @Override
    public void showProgressBar() {
            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFailure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}