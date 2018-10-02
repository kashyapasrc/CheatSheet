package com.kashyap.cheatsheet.utils;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.kashyap.cheatsheet.R;

public class DisplayMessage {
    public static void displayErrorMsg(View view, String msg) {
        prepareSnackBar(view, msg, R.color.error_color);
    }

    public static void displaySuccessMsg(View view, String msg) {
        prepareSnackBar(view, msg, R.color.success_color);
    }

    public static void displayInfoMsg(View view, String msg) {
        prepareSnackBar(view, msg, R.color.info_color);
    }

    public static void displayWarningMsg(View view, String msg) {
        prepareSnackBar(view, msg, R.color.warning_color);
    }

    private static void prepareSnackBar(View view, String msg, int color) {
        try {
            Snackbar mSnackBar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
            mSnackBar.getView().setBackgroundColor(ContextCompat.getColor(view.getContext(), color));
            mSnackBar.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
