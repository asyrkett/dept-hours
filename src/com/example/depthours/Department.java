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

	public Department(String departmentId, String name,
			List<HoursForDayOfWeek> hoursOfOperation) {
		this.departmentId = departmentId;
		this.name = name;
		this.hoursOfOperation = hoursOfOperation;
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

	public boolean isOpen() {
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
}