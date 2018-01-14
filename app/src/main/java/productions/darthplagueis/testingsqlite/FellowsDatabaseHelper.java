package productions.darthplagueis.testingsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import productions.darthplagueis.testingsqlite.model.Fellow;

/**
 * Created by oleg on 1/14/18.
 */

public class FellowsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "fellows.db";
    private static final String TABLE_NAME = "fellows";
    private static final int SCHEMA_VERSION = 1;

    public FellowsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "last_name TEXT, first_name TEXT, company TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Ignored for now. Important for when you update an entire database with a new version.
    }

    public void addFellow(Fellow fellow) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE first_name = '" + fellow.getFirstName() +
                        "' AND last_name = '" + fellow.getLastName() + "' AND company = '" + fellow.getCompany() +
                        "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(last_name, first_name, company) VALUES('" +
                    fellow.getLastName() + "', '" +
                    fellow.getFirstName() + "', '" +
                    fellow.getCompany() + "');");
        }
        cursor.close();
    }

    public List<Fellow> getFellowList() {
        List<Fellow> fellowList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if(cursor != null) {
            if(cursor.moveToFirst()) {
                do {
                    Fellow fellow = new Fellow(
                            cursor.getString(cursor.getColumnIndex("last_name")),
                            cursor.getString(cursor.getColumnIndex("first_name")),
                            cursor.getString(cursor.getColumnIndex("company")));
                    fellowList.add(fellow);
                } while (cursor.moveToNext());
            }
        }
        return fellowList;
    }
}
