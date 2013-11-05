package com.example.depthours;

public class HoursForDayOfWeek {
	
	// Use the static constants from the Calendar class for the dayOfWeek
	// like Calendar.TUESDAY = 3, Calendar.SATURDAY = 7, etc.
	/*
	 * Sunday = 1
	 * Monday = 2
	 * Tuesday = 3
	 * Wednesday = 4
	 * Thursday = 5
	 * Friday = 6
	 * Saturday = 7
	 * 
	 * */
	private int dayOfWeek;
	private int openingTime;
	private int closingTime;
	
	public HoursForDayOfWeek(int dayOfWeek, int openingHour, int closingHour) {
		this.dayOfWeek = dayOfWeek;
		this.openingTime = openingHour;
		this.closingTime = closingHour;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public int getOpeningHour() {
		return openingTime;
	}

	public int getClosingHour() {
		return closingTime;
	}
<<<<<<< HEAD
	
	private String militaryToStandardTime(int militaryTime)
	{
		String standardTime = "";
		int hourOfDay = militaryTime / 100;
		int minuteOfHour = militaryTime % 100;
		String minutes = "";
		if(minuteOfHour < 10)
			minutes += "0" + minuteOfHour;
		else
			minutes += minuteOfHour;
		if (hourOfDay >= 1 && hourOfDay <= 12)
		{
			standardTime = hourOfDay + ":" + minutes;
			if (hourOfDay != 12)
				standardTime += " AM";
			else
				standardTime += " PM";
		}
		else if (hourOfDay == 0 || hourOfDay <= 23)
		{
			if (hourOfDay == 0)
				standardTime = "12:" + minutes + " AM";
			else 
				standardTime = (hourOfDay - 12) + ":" + minutes + " PM";
		}
		return standardTime;
	}
	
	public String hoursToHtmlString()
	{
		return "<html>Opens: " + militaryToStandardTime(openingTime) + "<br>" +
				"Closes: " + militaryToStandardTime(closingTime) + "</html>";
	}
=======
>>>>>>> parent of e51b360... modified classes, main activity to display list
}