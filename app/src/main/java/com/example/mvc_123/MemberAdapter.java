package com.example.mvc_123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MemberAdapter extends ArrayAdapter {
    public  MemberAdapter(Context context, List<User> users){
        super(context,0,users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertview, @NonNull ViewGroup parent){
        View view = convertview;
        if( view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.listitem_members, parent, false);
        }

        User user = (User) getItem(position);
        TextView tv = view.findViewById(R.id.tv_name);
        tv.setText(user.getUserName());
        return view;
    }
}
