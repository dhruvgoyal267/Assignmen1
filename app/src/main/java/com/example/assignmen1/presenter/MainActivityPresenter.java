package com.example.assignmen1.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.assignmen1.activities.HomeActivity;
import com.example.assignmen1.db.mydb;
import com.example.assignmen1.model.User;

public class MainActivityPresenter {
    private final User user;
    private final mydb db;
    private final View view;

    public MainActivityPresenter(View view) {
        this.user = new User();
        this.view = view;
        this.db = new mydb((Context) view);
    }

    public void updateUser(String nameText, String emailText, String passText, String phoneText) {
        if (TextUtils.isEmpty(nameText) || TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passText) || TextUtils.isEmpty(phoneText))
            view.onFailure("All fields must be filled..");
        else {
            user.setFullName(nameText);
            user.setEmail(emailText);
            user.setPassword(passText);
            user.setPhoneNumber(phoneText);
        }
    }

    public void signUp() {
        view.showProgressBar();
        db.insertUser(user.getFullName(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
        view.hideProgressBar();
        view.onSuccess();
       }

    public interface View {
        void showProgressBar();
        void hideProgressBar();
        void onSuccess();
        void onFailure(String msg);
    }
}
