package com.example.depthours;

import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author Aida
 * 
 */
	
public class Department {
	private String departmentId;
	private String name;
	private List<HoursForDayOfWeek> hoursOfOperation;
	private String url;

	public Department(String departmentId, String name,
			List<HoursForDayOfWeek> hoursOfOperation, String url) {
		this.departmentId = departmentId;
		this.name = name;
		this.hoursOfOperation = hoursOfOperation;
		this.url = url;
	}
	//Gettters
	public String getId() {
		return departmentId;
	}

	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}

<<<<<<< HEAD
	public void setId(String id){
		this.departmentId = id;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public List<HoursForDayOfWeek> getHoursOfOperation() {
		return hoursOfOperation;
	}
	
	
	public HoursForDayOfWeek getCurrentDay()
	{
=======
	public boolean isOpen() {
>>>>>>> parent of e51b360... modified classes, main activity to display list
		Calendar currentDateTime = Calendar.getInstance();
		int currentDayOfWeek = currentDateTime.get(Calendar.DAY_OF_WEEK);
		for (HoursForDayOfWeek day : hoursOfOperation) {
			if (day.getDayOfWeek() == currentDayOfWeek) {
				int currentTime = currentDateTime.get(Calendar.HOUR_OF_DAY) * 100
						+ currentDateTime.get(Calendar.MINUTE);
				return (currentTime > day.getOpeningHour() && day
						.getClosingHour() > currentTime);
			}
		}
		return false;
	}
<<<<<<< HEAD
	
	public HoursForDayOfWeek getDayByName(String name)
	{
		
//		TODO: return a single day, HoursForDayOfWeek object.
		return null;
	}
	
=======
>>>>>>> parent of e51b360... modified classes, main activity to display list
}