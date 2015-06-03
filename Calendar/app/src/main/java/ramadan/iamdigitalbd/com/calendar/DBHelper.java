package ramadan.iamdigitalbd.com.calendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wolverine on 5/30/2015.
 */

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, StaticVars.DB_NAME, null, StaticVars.DB_VER);

        }

        // database table-column declaration
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE ramadan("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " r_date TEXT NOT NULL,"  + " r_day TEXT,"+"r_sehri TEXT," + "r_iftar TEXT)");

            PRE_DEFINED_VALUES(db);
        }

        // pre defined values insertion
        private void PRE_DEFINED_VALUES(SQLiteDatabase db) {
            db.execSQL("INSERT INTO ramadan(r_date, r_day, r_sehri, r_iftar) VALUES ('18/06/2015','Thursday','5:30am','6:30pm')");
            db.execSQL("INSERT INTO ramadan(r_date, r_day, r_sehri, r_iftar) VALUES ('19/06/2015','Friday','5:29am','6:29pm')");

        }

        // update table - dropping and renewing
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS ramadan");
            onCreate(db);

        }
    }

