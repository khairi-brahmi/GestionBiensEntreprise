package com.ems.if4_project.utils;

import android.app.AlertDialog;
import android.content.Context;


public class Message {
    private Context _context;


    public Message(Context context) {
        this._context = context;
    }


    public void show(String title, final String text, int icon) {
        AlertDialog.Builder msg = new AlertDialog.Builder(_context);
        msg.setIcon(icon);
        msg.setTitle(title);
        msg.setMessage(text);
        msg.setPositiveButton("OK", null);

        msg.show();

    }
}
