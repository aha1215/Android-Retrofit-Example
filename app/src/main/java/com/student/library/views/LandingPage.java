package com.student.library.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.student.library.DB.AppDatabase;
import com.student.library.DB.UserDAO;
import com.student.library.R;
import com.student.library.User;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LandingPage extends AppCompatActivity {

    private Button mSearchByTitleBtn;

    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        mDb = AppDatabase.getInstance(getApplicationContext());
        addDefaultUsers();

        mSearchByTitleBtn = findViewById(R.id.searchByTitleBtn);

        mSearchByTitleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = MainActivity.intentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    /**
     *  Method to add default users to Room database
     */
    private void addDefaultUsers() {
        User defaultUser = new User("user", "password");
        executor.execute(new Runnable() {
            @Override
            public void run() { mDb.UserDAO().insert(defaultUser); }
        });
    }

    public static Intent intentFactory(Context context) {
        Intent intent = new Intent(context, LandingPage.class);
        return intent;
    }
}