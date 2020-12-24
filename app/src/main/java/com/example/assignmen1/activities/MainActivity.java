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
           signUp();
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
    public void signUp() {
       showProgressBar();
        String nameText = userName.getText().toString().trim();
        String emailText = email.getText().toString().trim();
        String passText = password.getText().toString().trim();
        String phoneText = phone.getText().toString().trim();

        boolean flag = true;

        if(TextUtils.isEmpty(nameText)) {
            userName.setError("Name can't be empty");
            flag = false;
        }else
            presenter.updateName(nameText);

        if(TextUtils.isEmpty(emailText)){
            email.setError("Email can't be empty");
            flag = false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            email.setError("Invalid email format");
            flag = false;
        }
        else
            presenter.updateEmail(emailText);

        if(TextUtils.isEmpty(passText)){
            password.setError("Password can't be empty");
            flag = false;
        }
        else
            presenter.updatePassword(passText);

        if(TextUtils.isEmpty(phoneText)){
            phone.setError("Phone Number can't be empty");
            flag = false;
        }
        else if(!Patterns.PHONE.matcher(phoneText).matches()){
            phone.setError("Invalid Phone Number");
            flag = false;
        }
        else
            presenter.updatePhoneNumber(phoneText);
        if(flag){
            presenter.updateUser();
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        }
        hideProgressBar();
    }
}