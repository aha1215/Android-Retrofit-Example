package com.student.library;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.room.Room;
import androidx.test.espresso.internal.inject.InstrumentationContext;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.student.library.DB.AppDatabase;
import com.student.library.DB.UserDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *  Instrumented test
 */

@RunWith(AndroidJUnit4.class)
public class UserDAO_Test {
    @Test
    public void userInsertTest() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        AppDatabase mDB = AppDatabase.getInstance(appContext);
        UserDAO myTestDB = mDB.UserDAO();

        User user = new User("Hernandez", "notPassword");
        myTestDB.insert(user);

        User user2 = myTestDB.getUserByUsername(user.getUsername());

        assertEquals(user, user2);
    }

}
