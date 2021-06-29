package com.ems.if4_project.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ems.if4_project.R;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<Bien> {
    public MyListAdapter(Context context, ArrayList<Bien> biens) {

        super(context, 0, biens);


    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {



        Bien bien = getItem(position);



        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bien, parent, false);

        }



        TextView tvName = (TextView) convertView.findViewById(R.id.bien_nom);

        TextView tvDate = (TextView) convertView.findViewById(R.id.bien_date);
        TextView tvType = (TextView) convertView.findViewById(R.id.bien_type);



        tvName.setText(bien.getNom());

        tvDate.setText(bien.getDateBien());
        tvType.setText(bien.getTypeBien());



        return convertView;

    }

}
