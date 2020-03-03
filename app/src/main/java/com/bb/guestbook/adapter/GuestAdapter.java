package com.bb.guestbook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bb.guestbook.R;
import com.bb.guestbook.model.Guest;

import java.util.List;

public class GuestAdapter extends BaseAdapter {

    public GuestAdapter(List<Guest> guest){
        this.guest = guest;
    }

    private List<Guest> guest;

    @Override
    public int getCount(){
        return guest.size();
    }

    @Override
    public Guest getItem(int position){
        return guest.get(position);
    }

    @Override
    // associate position with actual id (i.e., position 1 = id 1)
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guest_item_layout, parent, false);


        ((TextView) view.findViewById(R.id.guestname_text)).setText(
                guest.get(position).getFullName());

        ((TextView) view.findViewById(R.id.room_edit_text)).setText(
                guest.get(position).getRoomNumber());
        return view;
    }
}
