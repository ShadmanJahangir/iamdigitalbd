package ramadan.iamdigitalbd.com.calendar;

/**
 * Created by Wolverine on 5/30/2015.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
    private Context context;
    private DBHelper dbHelper;
    public SQLiteDatabase db;

    public static final String ID = "_id",
            RDATE = "r_date", RDAY = "r_day",
            RSEHRI = "r_sehri",RIFTAR = "r_iftar",TABLE_RAMADAN = "ramadan";

    // set Context to access the database
    public DBAdapter(Context context) {
        this.context = context;
    }

    // open the database
    public DBAdapter open() throws SQLException {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    // close the database
    public void close() {
        dbHelper.close();
    }

    public Cursor getAllBusStoppage() {
        Cursor cursor = db.query(DBAdapter.TABLE_RAMADAN, new String[] {
                        DBAdapter.ID,DBAdapter.RDATE,
                        DBAdapter.RDAY, DBAdapter.RSEHRI, DBAdapter.RIFTAR, }, null, null, null,
                null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public Cursor getAllRamadanInfoByID(long id) {
        String where = DBAdapter.ID + "=" + id;
        Cursor cursor = db.query(DBAdapter.TABLE_RAMADAN, new String[] {
                        DBAdapter.ID, DBAdapter.RDATE,
                        DBAdapter.RDAY, DBAdapter.RSEHRI, DBAdapter.RIFTAR, }, where, null, null,
                null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
        }

        return cursor;
    }
}
