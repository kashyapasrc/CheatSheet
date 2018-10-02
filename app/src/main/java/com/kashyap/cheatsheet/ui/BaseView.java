package com.kashyap.cheatsheet.ui;

import android.app.Activity;
import android.content.Context;

public interface BaseView<Presenter extends BasePresenter> {

    void setPresenter(Presenter presenter);

    Context getCurrentFragmentContext();

    Activity getCurrentFragmentActivity();


    void displaySuccessMsg(String msg);

    void displayInfoMsg(String msg);

    void displayErrorMsg(String msg);

    void displayWarningMsg(String msg);

    void showProgressBar(String msg);

    void hideProgressBar();
}