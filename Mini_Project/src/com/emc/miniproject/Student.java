package com.emc.miniproject;

/**
 * 
 * @author Yichen LI
 *
 */

public class Student {

	
	private int stu_id;
	private String stu_name;
//	private String stu_email;
	private String stu_cell;
	
	
	
	
	public Student(int stu_id, String stu_name,
			String stu_cell) 
	{
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
//		this.stu_email = stu_email;
		this.stu_cell = stu_cell;
	}
	
	
	
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
//	public String getStu_email() {
//		return stu_email;
//	}
//	public void setStu_email(String stu_email) {
//		this.stu_email = stu_email;
//	}
	public String getStu_cell() {
		return stu_cell;
	}
	public void setStu_cell(String stu_cell) {
		this.stu_cell = stu_cell;
	}
	
	
}
