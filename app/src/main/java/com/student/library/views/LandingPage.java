package com.student.library.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.student.library.R;

public class LandingPage extends AppCompatActivity {

    Button mSearchByTitleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        mSearchByTitleBtn = findViewById(R.id.searchByTitleBtn);

        mSearchByTitleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = MainActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent intentFactory(Context context) {
        Intent intent = new Intent(context, LandingPage.class);
        return intent;
    }
}