package productions.darthplagueis.testingsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import productions.darthplagueis.testingsqlite.model.LaptopSighting;

/**
 * Created by oleg on 1/14/18.
 */

public class LaptopSightingDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "laptopSighting.db";
    private static final String TABLE_NAME = "laptopSightings";
    private static final int SCHEMA_VERSION = 1;

    public LaptopSightingDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, time_stamp DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                        "laptop_type TEXT, is_open INTEGER, is_using INTEGER, location TEXT," +
                        "is_fellow INTEGER, total_laptops INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addSighting(LaptopSighting sighting) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + sighting.getName() +
                        "' AND laptop_type = '" + sighting.getLaptopType() + "' AND is_open = '" +
                        sighting.isOpen() + "' AND is_using = '" + sighting.isUsing() + "' AND location = '" +
                        sighting.getLocation() + "' AND is_fellow = '" + sighting.isFellow() + "' AND total_laptops = '"
                        + sighting.getTotalLaptops() + "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, laptop_type, is_open, is_using, location, is_fellow, total_laptops) VALUES('" +
                    sighting.getName() + "', '" +
                    sighting.getLaptopType() + "', '" +
                    sighting.isOpen() + "', '" +
                    sighting.isUsing() + "', '" +
                    sighting.getLocation() + "', '" +
                    sighting.isFellow() + "', '" +
                    sighting.getTotalLaptops() + "');");
        }
        cursor.close();
    }

    public List<LaptopSighting> getSightingList() {
        List<LaptopSighting> sightingList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    LaptopSighting sighting = new LaptopSighting(
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("time_stamp")),
                            cursor.getString(cursor.getColumnIndex("laptop_type")),
                            cursor.getInt(cursor.getColumnIndex("is_open")),
                            cursor.getInt(cursor.getColumnIndex("is_using")),
                            cursor.getString(cursor.getColumnIndex("location")),
                            cursor.getInt(cursor.getColumnIndex("is_fellow")),
                            cursor.getInt(cursor.getColumnIndex("total_laptops")));
                    sightingList.add(sighting);
                } while (cursor.moveToNext());
            }
        }
        return sightingList;
    }
}
