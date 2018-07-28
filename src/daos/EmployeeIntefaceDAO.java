/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Employee;
import java.util.List;

/**
 *
 * @author iqbael17
 */
public interface EmployeeIntefaceDAO {
    public boolean insert(Employee employee);
    public boolean update(Employee employee);
    public boolean delete(int id);
    public List<Employee> getAll();
    public List<Employee> getAll(String category,String sort);
    public List<Employee> search(String category,String data);
    public Employee getById(int id);
    
}
