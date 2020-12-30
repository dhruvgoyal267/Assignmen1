package com.example.assignmen1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.assignmen1.R;
import com.example.assignmen1.presenter.HomeActivityPresenter;
import com.example.assignmen1.presenter.MainActivityPresenter;

public class HomeActivity extends AppCompatActivity implements HomeActivityPresenter.View {

    TextView nameText,emailText,phoneText;
    HomeActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nameText = findViewById(R.id.name);
        emailText = findViewById(R.id.email);
        phoneText = findViewById(R.id.phoneNumber);
        presenter = new HomeActivityPresenter(this,getBaseContext());
        presenter.updateUser();
    }

    @Override
    public void updateEmail(String email) {
            emailText.setText(email);
    }

    @Override
    public void updateName(String name) {
            nameText.setText(name);
    }

    @Override
    public void updatePhone(String phone) {
        phoneText.setText(phone);
    }
}