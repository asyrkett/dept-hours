package com.example.depthours;

public class HoursForDayOfWeek {
	
	private int dayOfWeek;
	private int openingHour;
	private int closingHour;
	
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
}