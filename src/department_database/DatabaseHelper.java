package department_database;

import java.util.ArrayList;
import java.util.List;

import com.example.depthours.Department;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper
{
	// Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "departmentHours";
 
    // Table Names
    private static final String TABLE_DEPARTMENT = "departments";
  
    
 
    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";
 
    // DEPARTMENT Table - column names
    private static final String KEY_DEPARTMENT_NAME = "department_name";
    private static final String KEY_DEPARTMENT_TIMEOPEN = "timeOpen";
    private static final String KEY_DEPARTMENT_TIMECLOSE = "timeClose";
 
    // Table Create Statements
    // Department table create statement
    private static final String CREATE_TABLE_DEPARTMENT = "CREATE TABLE "
            + TABLE_DEPARTMENT + "(" + KEY_ID + " INTEGER PRIMARY KEY," 
    		+ KEY_DEPARTMENT_NAME + " TEXT )"
			+ KEY_DEPARTMENT_TIMEOPEN + "TEXT ,"
			+ KEY_DEPARTMENT_TIMECLOSE + "TEXT ," 
		    + KEY_CREATED_AT + " DATETIME" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
 
        // creating required tables
        db.execSQL(CREATE_TABLE_DEPARTMENT);
        
        
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_DEPARTMENT);
        
        
 
        // create new tables
        onCreate(db);
    }
    
    
    
    
///////////////////
//CRUD
///////////////////
    /*
     * Creating a department
     */
    public long createDepartment(helper_Department dept) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_DEPARTMENT_NAME, dept.getName());
        values.put(KEY_DEPARTMENT_TIMEOPEN,dept.getTimeOpen() );
        values.put(KEY_DEPARTMENT_TIMECLOSE,dept.getTimeClose() );   
     
        // insert row
        long department_id = db.insert(TABLE_DEPARTMENT, null, values);     
             
        return department_id;
    }
    
    
    //Get Department by ID
    public helper_Department getDepartment(long departmentID) {
        SQLiteDatabase db = this.getReadableDatabase();
     
        String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENT + " WHERE "
                + KEY_ID + " = " + departmentID;
     
        Log.e(LOG, selectQuery);
     
        Cursor c = db.rawQuery(selectQuery, null);
     
        if (c != null)
            c.moveToFirst();
     
        helper_Department td = new helper_Department();
        td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        td.setName(c.getString(c.getColumnIndex(KEY_DEPARTMENT_NAME)));
        td.setTimeOpen(c.getString(c.getColumnIndex(KEY_DEPARTMENT_TIMEOPEN)));
        td.setTimeClose(c.getString(c.getColumnIndex(KEY_DEPARTMENT_TIMECLOSE)));
     
        return td;
    }
    
    
    
    /*
     * SELECT ALL Departments
     * */
    public List<helper_Department> getAllToDepartments() {
        List<helper_Department> departments = new ArrayList<helper_Department>();
        String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENT;
     
        Log.e(LOG, selectQuery);
     
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
            	helper_Department td = new helper_Department();
            	   td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                   td.setName(c.getString(c.getColumnIndex(KEY_DEPARTMENT_NAME)));
                   td.setTimeOpen(c.getString(c.getColumnIndex(KEY_DEPARTMENT_TIMEOPEN)));
                   td.setTimeClose(c.getString(c.getColumnIndex(KEY_DEPARTMENT_TIMECLOSE)));
               
     
                // adding to todo list
                departments.add(td);
            } while (c.moveToNext());
        }     
        return departments;
    }
    
    //Select department by name
    public List<helper_Department> getAllToDosByTag(String departmentName) {
        List<helper_Department> departments = new ArrayList<helper_Department>();
     
        String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENT + " td, "
        		+	" WHERE td."
                + KEY_DEPARTMENT_NAME + " = '" + departmentName + "'";
     
        Log.e(LOG, selectQuery);
     
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                helper_Department td = new helper_Department();
         	   td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
               td.setName(c.getString(c.getColumnIndex(KEY_DEPARTMENT_NAME)));
               td.setTimeOpen(c.getString(c.getColumnIndex(KEY_DEPARTMENT_TIMEOPEN)));
               td.setTimeClose(c.getString(c.getColumnIndex(KEY_DEPARTMENT_TIMECLOSE)));
           
                // adding to depatments list
                departments.add(td);
            } while (c.moveToNext());
        }
     
        return departments;
    }
    
    
    //Update a department
    public int updateToDo(helper_Department dept) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_DEPARTMENT_NAME, dept.getName());
        values.put(KEY_DEPARTMENT_TIMEOPEN,dept.getTimeOpen() );
        values.put(KEY_DEPARTMENT_TIMECLOSE,dept.getTimeClose() );   
     
     
        // updating row
        return db.update(TABLE_DEPARTMENT, values, KEY_ID + " = ?",
                new String[] { String.valueOf(dept.getId()) });
    }
    
    
    

    /*
     * Deleting a Department
     */
    public void deleteToDo(long deptID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DEPARTMENT, KEY_ID + " = ?",
                new String[] { String.valueOf(deptID) });
    }
    
    
 // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
    
    
}
