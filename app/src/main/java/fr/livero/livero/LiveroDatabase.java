package fr.livero.livero;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Rohit on 5/27/2018.
 */

@Database(entities = {CustomerDb.class},version = 1)
public abstract class LiveroDatabase extends RoomDatabase {

    private static LiveroDatabase INSTANCE;

    public abstract DataAccess dataAccess();

    public static LiveroDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), LiveroDatabase.class, "customer")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}