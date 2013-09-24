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

	public String getId() {
		return departmentId;
	}

	public String getName() {
		return name;
	}

	public List<HoursForDayOfWeek> getHoursOfOperation() {
		return hoursOfOperation;
	}
	
	public String getUrl() {
		return url;
	}

	public HoursForDayOfWeek getCurrentDay()
	{
		Calendar currentDateTime = Calendar.getInstance();
		for (HoursForDayOfWeek day : hoursOfOperation)
		{
			if (day.getDayOfWeek() == currentDateTime.get(Calendar.DAY_OF_WEEK))
			{
				return day;
			}
		}
		return new HoursForDayOfWeek();
	}
	
	public boolean isOpen() {
		Calendar currentDateTime = Calendar.getInstance();
		HoursForDayOfWeek day = getCurrentDay();
		int currentTime = currentDateTime.get(Calendar.HOUR_OF_DAY) * 100 + currentDateTime.get(Calendar.MINUTE);
		return (currentTime > day.getOpeningHour() && day.getClosingHour() > currentTime);
	}
	
}