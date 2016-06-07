package com.db.oliviergoutay.greendao_vs_realm;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

import com.db.oliviergoutay.greendao_vs_realm.realm.RealmDailyMealManager;


/**
 * Created by oliviergoutay on 10/8/15.
 * Gives you access to {@link io.realm.Realm} and a bunch of things like that needed in the unit tests.
 * Don't provide access to the views or anything else.
 */
public class AbstractAndroidTestCase extends AndroidTestCase {

    private static final String TAG = "AbstractAndroidTestCase";

    public RealmDailyMealManager realmDailyMealManager;

    private int numberOfTry;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        numberOfTry = 0;
        createApplication();

        realmDailyMealManager = RealmDailyMealManager.getInstance(getContext());
    }

    @Override protected void tearDown() throws Exception {
        DbApp.getRealm().beginTransaction();
        DbApp.getRealm().deleteAll();
        DbApp.getRealm().commitTransaction();

        super.tearDown();
    }

    /**
     * Create the {@link DbApp} by calling {@link DbApp#setupDatabase(Context)}.
     * If init failed (often the database not ready, then we wait for 1 sec and recall the same function.
     * Will try 5 times.
     */
    private void createApplication() {
        if (numberOfTry >= 5) {
            throw new RuntimeException("Could not create application database in five times");
        }

        try {
            DbApp.setupDatabase(getContext());
        } catch (Exception e) {
            Log.e(TAG, "Error creating the app, retry in 1sec");
            numberOfTry++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                Log.e(TAG, "Error waiting to create the app");
            }
            createApplication();
        }
    }
}
