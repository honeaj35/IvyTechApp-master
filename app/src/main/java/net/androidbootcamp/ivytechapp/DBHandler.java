package net.androidbootcamp.ivytechapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by jamesdrewery on 10/26/16.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper
    {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "CLASSROOMS";
    // Classroom table name
    private static final String CLASSROOMS = "classrooms";
    // Classroom Table Columns names
    private static final String KEY_ID = "roomNumber";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CLASSROOM_TABLE = "CREATE TABLE " + CLASSROOMS + "("
        + KEY_ID + " STRING PRIMARY KEY," + KEY_LATITUDE + " DOUBLE,"
        + KEY_LONGITUDE + " DOUBLE" + ")";
        db.execSQL(CREATE_CLASSROOM_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + CLASSROOMS);
        // Creating tables again
        onCreate(db);
    }

    // Adding new classroom
    public void addClassroom(Classroom classroom) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, classroom.getRoomNumber() );
        values.put(KEY_LATITUDE, classroom.getLatitude());
        values.put(KEY_LONGITUDE, classroom.getLongitude());

        // Inserting Row
        db.insert(CLASSROOMS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single classroom
    public Classroom getClassroom(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(CLASSROOMS, new String[] { KEY_ID,
                        KEY_LATITUDE, KEY_LONGITUDE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Classroom classroom = new Classroom(cursor.getString(0), cursor.getString(1),
                                            cursor.getString(2));
        // return contact
        return classroom;
    }

    // Getting All classrooms
    public List<Classroom> getAllClassrooms()
    {
        List<Classroom> classroomList = new ArrayList<Classroom>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + CLASSROOMS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()){
            do {
                Classroom classroom = new Classroom();
                classroom.setRoomNumber(cursor.getString(0));
                classroom.setLatitude(cursor.getString(1));
                classroom.setLongitude(cursor.getString(2));
                // Adding contact to list
                classroomList.add(classroom);
            } while (cursor.moveToNext());
        }
        // return classroom list
        return classroomList;
    }

    // Getting classrooms Count
    public int getClassroomCount() {
        String countQuery = "SELECT  * FROM " + CLASSROOMS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single classroom
    public int updateContact(Classroom classroom) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LATITUDE, classroom.getLatitude());
        values.put(KEY_LONGITUDE, classroom.getLongitude());

        // updating row
        return db.update(CLASSROOMS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(classroom.getRoomNumber()) });
    }

    // Deleting single classroom
    public void deleteClassroom(Classroom classroom) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(CLASSROOMS, KEY_ID + " =?",
                new String[] {String.valueOf(classroom.getRoomNumber())});
        db.close();
    }
}


