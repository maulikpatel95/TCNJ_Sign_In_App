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
 *
 * This class creates the SQLite Database manager that the application will use
 * to manage user information.  The database will have three fields:  User name,
 * email, and phone number.  SQL statements will be initialized as strings with database
 * methods available to parse the string into SQL queries.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Visitors";
    private static final String TABLE_VISITORS="Visitors";

    /** Each row will create three columns that will store data into
     * each of these three header rows
     */
    private static final String KEY_NAME="VisitorName";
    private static final String KEY_EMAIL="Email";
    private static final String KEY_PHONENUMBER="PhoneNumber";

    public DatabaseHandler(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /**
         *  String variable that will take SQL statements and have the Database
         *  parse it into SQL statements
         */
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

    /**
     * Adds a new visitor into the Database
     * @param newVisitor
     */
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
        //COMING SOON
    }**/

    /**
     * This method will return an ArrayList data structure in which
     * each row in the database will be read and stored.  The ArrayList will
     * return a list of Visitor objects that were stored in each row.  Once there
     * are no more rows left to process, the list will return to the method
     * @return
     */
    public ArrayList<Visitor> getAllVisitors()
    {
        ArrayList<Visitor> TableList=new ArrayList<Visitor>();

        String selectQuery="SELECT  *  FROM " + TABLE_VISITORS; //SQL statments from Table TABLE_VISITORS
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor search=db.rawQuery(selectQuery,null); //Cursor object that will traverse through database

        if(search.moveToFirst())// Determines whether the current table contains any rows
        {
            while(search.moveToNext()) //Traverse through each row and retrieve information
            {
                Visitor visitor=new Visitor();
                visitor.setVisitorName(search.getString(0));
                visitor.setEmail(search.getString(1));
                visitor.setPhoneNumber(search.getString(2));
                TableList.add(visitor);
            }
        }

            return TableList;  //returns database list
    }

    /**
     * Delete all records from the specified table in the database
     */
    public void DeleteDatabaseRecords()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM "+ TABLE_VISITORS;
        db.execSQL(query);
        addVisitor(new Visitor("Dummy Person","no email","no number")); //After records have been deleted, this is a dummy add to move table back to first row.  No impact on program

    }



}
