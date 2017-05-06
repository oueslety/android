package com.example.kamran.eleganttheme;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;


public class LoginDataBaseAdapter {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( "
            + "ID" + " integer primary key autoincrement,"
            + "EMAIL  text ,USERNAME  text,PASSWORD text,PHONE  text); ";
    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;

    public LoginDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public LoginDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String email, String userName, String password, String phone) {
        ContentValues newValues = new ContentValues();
        newValues.put("EMAIL", "xxx");
        newValues.put("USERNAME", "xxx");
        newValues.put("PASSWORD", "xxx");
        newValues.put("PHONE", "xxx");
        db.insert("LOGIN", null, newValues);

    }



    public String getSinlgeEntry(String usrusr) {
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?",
                new String[] { usrusr }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }


}