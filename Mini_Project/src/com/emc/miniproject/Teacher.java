package com.emc.miniproject;

/**
 * 
 * @author Yichen LI
 *
 */

public class Teacher {

	private int tea_id;
	private String tea_name;
	private int tea_salary;
	
		
	public Teacher(int tea_id, String tea_name, int tea_salary)
	{
		super();
		this.tea_id = tea_id;
		this.tea_name = tea_name;
		this.tea_salary = tea_salary;
	}
	
	
	
	public int getTea_id() {
		return tea_id;
	}
	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public int getTea_salary() {
		return tea_salary;
	}
	public void setTea_salary(int tea_salary) {
		this.tea_salary = tea_salary;
	}
	
	
	
	
}
