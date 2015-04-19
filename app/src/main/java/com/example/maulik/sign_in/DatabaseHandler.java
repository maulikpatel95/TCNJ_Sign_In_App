package com.example.maulik.sign_in;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maulik on 4/16/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="Visitors";

    private static final String TABLE_VISITORS="Visitors";

    private static final String KEY_NAME="VisitorName";
    private static final String KEY_EMAIL="Email";
    private static final String KEY_PHONENUMBER="PhoneNumber";

    public DatabaseHandler(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_VISITOR_TABLE="CREATE TABLE "+ TABLE_VISITORS + "("
                + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_PHONENUMBER + " TEXT" + ")";
        db.execSQL(CREATE_VISITOR_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITORS);
        onCreate(db);

    }

    public void addVisitor(Visitor newVisitor)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,newVisitor.getVisitorName());
        values.put(KEY_EMAIL,newVisitor.getEmail());
        values.put(KEY_PHONENUMBER,newVisitor.getPhoneNumber());

        db.insert(TABLE_VISITORS,null,values);
        db.close();
    }

    /**public Visitor getVisitor(String name)
    {

    }**/

    public ArrayList<Visitor> getAllVisitors()
    {
        ArrayList<Visitor> TableList=new ArrayList<Visitor>();

        String selectQuery="SELECT  *  FROM " + TABLE_VISITORS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor search=db.rawQuery(selectQuery,null);

        if(search.moveToFirst())
        {
            while(search.moveToNext())
            {
                Visitor visitor=new Visitor();
                visitor.setVisitorName(search.getString(0));
                visitor.setEmail(search.getString(1));
                visitor.setPhoneNumber(search.getString(2));
                TableList.add(visitor);
            }
        }

            return TableList;
    }


    public void DeleteDatabaseRecords()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM "+ TABLE_VISITORS;
        db.execSQL(query);
        addVisitor(new Visitor("Dummy Person","no email","no number"));

    }



}
