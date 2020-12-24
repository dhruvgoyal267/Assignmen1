package com.example.assignmen1.presenter;

import android.content.Context;

import com.example.assignmen1.db.mydb;
import com.example.assignmen1.model.User;

public class MainActivityPresenter {
    private final User user;
    private final mydb db;

    public MainActivityPresenter(View view) {
        this.user = new User();
        this.db = new mydb((Context) view);
    }

    public void updateName(String name){
        user.setFullName(name);
    }

    public void updateEmail(String email){
        user.setEmail(email);
    }
    public void updatePassword(String password){
        user.setPassword(password);
    }
    public void updatePhoneNumber(String phone){
        user.setPhoneNumber(phone);
    }
    public void updateUser(){
        db.insertUser(user.getFullName(),user.getEmail(),user.getPassword(),user.getPhoneNumber());
    }

    public interface View{
        void showProgressBar();
        void hideProgressBar();
        void signUp();
    }
}
