package com.example.depthours;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import department_database.DatabaseHelper;
import department_database.helper_Department;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.app.ListActivity;
import android.content.Context;
=======
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
>>>>>>> parent of e51b360... modified classes, main activity to display list

public class DeptHoursMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_depthours_main);
<<<<<<< HEAD
		
		CreateDB();
		
		departments = new ArrayList<Department>();
		context = this;
		
		new DeptHoursTask().execute();
		
	}

	
	private void CreateDB() {
		  db = new DatabaseHelper(getApplicationContext());
		  
	        // Creating tags
	        helper_Department dept1 = new helper_Department("Library","0800","2200", "Monday");
	        db.createDepartment(dept1);
	 
	        // Getting all department names
	        Log.d("Get department", "Getting departments");	 
	        List<helper_Department> allDepts= db.getAllToDepartments();
	        
	 
	        // Don't forget to close database connection
	        db.closeDB();
	}


	// Database Helper
    DatabaseHelper db;
 
   
      
	
	private class DeptHoursTask extends AsyncTask<Void, Void, Void>
	{
		private boolean isNetworkAvailable() 
		{
		    ConnectivityManager connectivityManager = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);
		    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
		}
		
		
		
		
		
		protected Void doInBackground(Void... arg0) {
			
				
			
			
			
			
			// TODO Auto-generated method stub
			/*List<HoursForDayOfWeek> hoursOfOperation1 = new ArrayList<HoursForDayOfWeek>();
			List<HoursForDayOfWeek> hoursOfOperation2 = new ArrayList<HoursForDayOfWeek>();
			for(int i = 1; i <= 7; i++)
			{
				HoursForDayOfWeek h1 = new HoursForDayOfWeek(i, 800, 2200);
				hoursOfOperation1.add(h1);
				HoursForDayOfWeek h2 = new HoursForDayOfWeek(i, 800, 1500);
				hoursOfOperation2.add(h2);
			}
			Department d1 = new Department("1", "Library", hoursOfOperation1, "www.ggc.edu/library");
			Department d2 = new Department("2", "AEC", hoursOfOperation2, "www.ggc.edu/aec");
			
			departments.add(d1);
			departments.add(d2);*/
			return null;
		}
		
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			DepartmentAdapter adapter = new DepartmentAdapter(context, departments);
			setListAdapter(adapter);
		}
		
		
=======
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dept_hours_main, menu);
		return true;
>>>>>>> parent of e51b360... modified classes, main activity to display list
	}

}
