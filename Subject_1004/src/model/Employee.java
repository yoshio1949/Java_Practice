package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable{
	private int employeeId;
	private String employeeName;
	private int age;
	private String address;
	private int departmentId;
	private LocalDate date;
//	public Employee() {}
//	public Employee(String employeeName, int age, String address, int department_id, LocalDate date) {
//		this.employeeName = employeeName;
//		this.age = age;
//		this.address = address;
//		this.departmentId = department_id;
//		this.date = date;
//	}
//	public Employee(int employeeId,String employeeName, int age, String address, int department_id, LocalDate date) {
//		this(employeeName, age, address, department_id, date);
//		this.employeeId = employeeId;
//	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
