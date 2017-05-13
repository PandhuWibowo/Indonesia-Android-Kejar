package com.example.root.androidkejar.mainview;

import android.text.TextUtils;

import com.example.root.androidkejar.interactor.InterfaceMain;
import com.example.root.androidkejar.interactor.InterfacePresenter;

/**
 * Created by root on 13/05/17.
 */

public class MainPresenter implements InterfacePresenter{

    private InterfaceMain mInterfaceMain;

    public MainPresenter(InterfaceMain mInterfaceMain) {
        this.mInterfaceMain = mInterfaceMain;
    }

    @Override
    public void login(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mInterfaceMain.messageError();
        } else {
            if(username.equals("pandhu") && password.equals("pandhu")){
                mInterfaceMain.loginSuccess();
            }else{
                mInterfaceMain.loginError();
            }
        }
    }
}
