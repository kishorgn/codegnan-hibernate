package com.codegnan;

import java.util.List;

import com.codegnan.dao.EmployeeDao;
import com.codegnan.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();
        for(Employee employee : employees) {
        	System.out.println(employee);
        }
        /*
        Employee employee;
		try {
			employee = employeeDao.findById(111);
			System.out.println(employee);
		} catch (InvalidEmployeeIdException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
        
    }
}
