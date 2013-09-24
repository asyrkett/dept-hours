package com.example.depthours;

public class HoursForDayOfWeek {
	
	// Use the static constants from the Calendar class for the dayOfWeek
	// like Calendar.TUESDAY = 3, Calendar.SATURDAY = 7, etc.
	private int dayOfWeek;
	private int openingHour;
	private int closingHour;
	
	public HoursForDayOfWeek()
	{
		this(0, 0, 0);
	}
	
	public HoursForDayOfWeek(int dayOfWeek, int openingHour, int closingHour) {
		this.dayOfWeek = dayOfWeek;
		this.openingHour = openingHour;
		this.closingHour = closingHour;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public int getOpeningHour() {
		return openingHour;
	}

	public int getClosingHour() {
		return closingHour;
	}
	
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
		return "<html>Opens: " + militaryToStandardTime(openingHour) + "<br>" +
				"Closes: " + militaryToStandardTime(closingHour) + "</html>";
	}
}