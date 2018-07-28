/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Employee;
import java.util.List;

/**
 *
 * @author iqbael17
 */
public interface EmployeeInterfaceController {
    
    public boolean save(String employeeId, String firsName, String lastName, String email, String phoneNumber
    , String hireDate, String jobId, String salary,String commission, String managerId,String departmentId);
    public boolean edit(String employeeId, String firsName, String lastName, String email, String phoneNumber
    , String hireDate, String jobId, String salary,String commission, String managerId,String departmentId);
    public boolean drop (int id);
    public List<Employee> binding();
    public List<Employee> bindingsort(String category, String sort);
    public List<Employee> find(String category, String Data);
    public Employee findbyId(int id);
}
