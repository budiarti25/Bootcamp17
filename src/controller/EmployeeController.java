/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.EmployeeDAO;
import entities.Employee;
import java.util.List;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iqbael17
 */
public class EmployeeController implements EmployeeInterfaceController {

    private EmployeeDAO employeeDAO;

    public EmployeeController() {

    }

    public EmployeeController(Connection connection) {
        this.employeeDAO= new EmployeeDAO(connection);
    }

 

    @Override
    public boolean save(String employeeId, String firsName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commission, String managerId, String departmentId) {
        Employee employee = new Employee();
        employee.setEmployeeId(Integer.parseInt(employeeId));
        employee.setFirstName(firsName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setHireDate(java.sql.Date.valueOf(hireDate));
        employee.setJobId(jobId);
        employee.setSalary(Integer.parseInt(salary));
        employee.setCommisionPct(Double.parseDouble(commission));
        employee.setManagerid(Integer.parseInt(managerId));
        employee.setDepartmentid(Integer.parseInt(departmentId));
        
        return this.employeeDAO.insert(employee);
    }

    @Override
    public boolean edit(String employeeId, String firsName, String lastName, String email, String phoneNumber, String hireDate, String jobId, String salary, String commission, String managerId, String departmentId) {
         Employee employee = new Employee();
        employee.setEmployeeId(Integer.parseInt(employeeId));
        employee.setFirstName(firsName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setHireDate(java.sql.Date.valueOf(hireDate));
        employee.setJobId(jobId);
        employee.setSalary(Integer.parseInt(salary));
        employee.setCommisionPct(Double.parseDouble(commission));
        employee.setManagerid(Integer.parseInt(managerId));
        employee.setDepartmentid(Integer.parseInt(departmentId));
        
        return this.employeeDAO.update(employee);
    
    
    }

    @Override
    public boolean drop(int id) {
         return this.employeeDAO.delete(id); }

    @Override
    public List<Employee> binding() {
        return this.employeeDAO.getAll(); }

    @Override
    public List<Employee> bindingsort(String category, String sort) {
        return this.employeeDAO.getAll(category, sort); }

    @Override
    public List<Employee> find(String category, String Data) {
        return this.employeeDAO.search(category, Data);  }

    @Override
    public Employee findbyId(int id) {
     return this.employeeDAO.getById(id);  }

}
