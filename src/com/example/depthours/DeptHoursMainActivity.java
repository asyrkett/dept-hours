package com.example.depthours;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;

public class DeptHoursMainActivity extends ListActivity {

	private List<Department> departments;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_depthours_main);
		
		departments = new ArrayList<Department>();
		context = this;
		
		new DeptHoursTask().execute();
	}

	private class DeptHoursTask extends AsyncTask<Void, Void, Void>
	{
		@Override
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
	}
}