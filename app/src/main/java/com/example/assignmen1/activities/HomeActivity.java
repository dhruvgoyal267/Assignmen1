package com.example.assignmen1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.assignmen1.R;
import com.example.assignmen1.presenter.HomeActivityPresenter;
import com.example.assignmen1.presenter.MainActivityPresenter;

public class HomeActivity extends AppCompatActivity implements HomeActivityPresenter.View {

    TextView name,email,phone;
    HomeActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phoneNumber);
        presenter = new HomeActivityPresenter(this);
        presenter.updateUser();
    }

    @Override
    public void updateEmail(String email) {

    }

    @Override
    public void updateName(String name) {

    }

    @Override
    public void updatePhone(String phone) {

    }
}