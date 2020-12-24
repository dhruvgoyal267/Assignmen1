package com.example.assignmen1.presenter;

import android.content.Context;
import android.view.View;

import com.example.assignmen1.R;
import com.example.assignmen1.db.mydb;
import com.example.assignmen1.model.User;

public class HomeActivityPresenter {
    User user;
    mydb db;
    View view;

    public HomeActivityPresenter(Context context) {
        this.user = new User();
        this.db = new mydb(context);
        this.user = this.db.getUser();
    }

    public void updateUser() {
        view.updateName(this.user.getFullName());
        view.updateEmail(this.user.getEmail());
        view.updatePhone(this.user.getPhoneNumber());
    }

    public interface View {
        public void updateEmail(String email);

        public void updateName(String name);

        public void updatePhone(String phone);
    }
}
