package com.codegnan;

import java.util.List;

import com.codegnan.dao.EmployeeDao;
import com.codegnan.entity.Employee;
import com.codegnan.exception.InvalidEmployeeIdException;

public class App 
{
    public static void main( String[] args )
    {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();
        for(Employee employee : employees) {
        	System.out.println(employee);
        }
        System.out.println();
        
        Employee employee;
		try {
			employee = employeeDao.findById(102);
			System.out.println(employee);
		} catch (InvalidEmployeeIdException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		Employee e = new Employee("Satya", "Prasad");
		int id = employeeDao.save(e);
		System.out.println("ID of new employee : "+id);
        
    }
}
