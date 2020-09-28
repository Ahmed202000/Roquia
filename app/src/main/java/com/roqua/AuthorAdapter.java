package com.roqua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


public class AuthorAdapter extends BaseAdapter {
    ArrayList<AuthorItem> list = new ArrayList<>();
    Context context;

    public AuthorAdapter(ArrayList<AuthorItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.author_item, null);
        CircleImageView iv = view.findViewById(R.id.author_item_iv_image);
        TextView name = view.findViewById(R.id.author_item_tv_name);
        TextView type = view.findViewById(R.id.author_item_tv_type);
        iv.setImageResource(list.get(position).getImage());
        name.setText(list.get(position).getName());
        type.setText(list.get(position).getType());
        return view;
    }
}
