package department_database;

import java.util.List;

import com.example.depthours.Department;
import com.example.depthours.HoursForDayOfWeek;

public class helper_Department {

	
		 
	    int id;
	    String name;
	    String timeOpen;
	    String timeClose;
	    String dayOfTheWeek;
	    	 
	    // constructors
	    public helper_Department() {
	    }
	 
	    public helper_Department(String name)
	    {
	        this.name = name;
	    }
	    public helper_Department(String name, String timeOpen)
	    {
	        this.name = name;
	        this.timeOpen = timeOpen;
	    }
	    public helper_Department(String name, String timeOpen, String timeClose, String dayOfTheWeek)
	    {
	        this.name = name;
	        this.timeOpen = timeOpen;
	        this.timeClose = timeClose;
	        this.dayOfTheWeek = dayOfTheWeek;
	    }
	 
	    
	    // setters
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void setTimeOpen(String timeOpen) {
	        this.timeOpen = timeOpen;
	    }
	    
	    public void setTimeClose(String timeClose) {
	        this.timeClose = timeClose;
	    }
	    
	    public void setDayOfWeek(String dayOfTheWeek) {
	        this.dayOfTheWeek = dayOfTheWeek;
	    }

	    // getters
	    public long getId() {
	        return this.id;
	    }
	 
	    public String getName() {
	        return this.name;
	    }
	    
	    public String getTimeOpen()
	    {
	    	return this.timeOpen;
	    }
	    
	    public String getTimeClose()
	    {
	    	return this.timeClose;
	    }
	    
	    public String getDayOfTheWeek()
	    {
	    	return this.dayOfTheWeek;
	    }
	    
	    public  Department ConverttoDepartment()
	    {
	    	//TODO: change from the department database object to the actual department object.
	    	return null;
	    }
	 
	   
	}
	

