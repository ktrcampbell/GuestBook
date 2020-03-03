package com.bb.guestbook.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.bb.guestbook.R;
import com.bb.guestbook.adapter.GuestAdapter;
import com.bb.guestbook.model.Guest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int guestCount = 0;
    private String guestKeyPrefix = "GUEST_";
    private String roomKeyPrefix = "ROOM_";
    private SharedPreferences sharedPreferences;

    private ImageView mainImageView;
    private GuestAdapter guestAdapter;

    private EditText guestNameEditText;
    private EditText guestRoomEditText;
    private ListView guestListView;
    private Button addGuestButton;
    private Button closeApp;

    private List totGuestList = new ArrayList<String>();
    private List guestList = new ArrayList<Guest>();

    private final String GUEST_COUNT_KEY = "guest.count.key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("com.bb.guestbook", Context.MODE_PRIVATE);

        mainImageView = findViewById(R.id.home_imageView);
        Glide.with(this)
                .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                .load(R.drawable.hotel)
                .into(mainImageView);
        closeApp = findViewById(R.id.close_button);

        guestNameEditText = findViewById(R.id.guestname_text);
        guestCount = sharedPreferences.getInt(GUEST_COUNT_KEY, 0);
        addGuestButton = findViewById(R.id.addguest_button);
        guestListView = findViewById(R.id.guest_listview);
        guestRoomEditText = findViewById(R.id.room_edit_text);

        addGuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String guestName = guestNameEditText.getText().toString().trim();
                String guestRoom = guestRoomEditText.getText().toString().trim();
                guestCount++;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(guestKeyPrefix + guestCount, guestName);
                editor.putInt(GUEST_COUNT_KEY, guestCount);
                editor.apply();

                readGuests();
                guestNameEditText.setText("");
                guestRoomEditText.setText("");
            }
            });

                readGuests();
            }

            private void readGuests() {
                guestCount = sharedPreferences.getInt(GUEST_COUNT_KEY, 0);
                guestList.clear();

                for (int i = 0; i < guestCount; i++) {
                    String guest = sharedPreferences.getString(guestKeyPrefix + (i + 1), "unknown");
                    String room = sharedPreferences.getString(roomKeyPrefix + (i + 1), "unknown");
                    guestList.add(guest);
                    guestList.add(room);
                    totGuestList.add(new Guest(guest,room));
                    Log.d("TAG_X", guest);
                }

                updateGuestList();
            }

            private void updateGuestList() {
                guestAdapter = new GuestAdapter(totGuestList);
                guestListView.setAdapter(guestAdapter);
            }

    public void closeActivity (View view){
        closeApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


        @Override
            public void onConfigurationChanged(@NonNull Configuration newConfig) {
                super.onConfigurationChanged(newConfig);
            }

            @Override
            protected void onResume() {
                super.onResume();
            }

            @Override
            protected void onStop() {
                super.onStop();
            }

}

