package com.example.depthours;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DepartmentAdapter extends BaseAdapter {

	private Context context;
	/*private List<String> names;
	private List<String> openClosed;
	private List<String> hours;*/
	
	private List<Department> departments;
	
	public DepartmentAdapter(Context context, List<Department> departments) {
		this.context = context;
		/*this.names = names;
		this.openClosed = openClosed;
		this.hours = hours;*/
		this.departments = departments;
	}
	
	@Override
	public int getCount() {
		return departments.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		// inflate view from xml, why not do this with code? i like to keep code to a minimum :)
		LinearLayout row = new LinearLayout(context);
		View.inflate(context, R.layout.activity_depthours_detail, row);
		
		TextView nameText = (TextView) row.findViewById(R.id.depthours_name);
		TextView openClosedText = (TextView) row.findViewById(R.id.depthours_open_closed);
		TextView hoursText = (TextView) row.findViewById(R.id.depthours_hours);

		nameText.setText(departments.get(position).getName());
		
		if (departments.get(position).isOpen())
		{
			openClosedText.setText("OPEN");
		}
		else
		{
			openClosedText.setText("CLOSED");
		}
		hoursText.setText(Html.fromHtml(departments.get(position).getCurrentDay().hoursToHtmlString()));

		return row;
	}
}