/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Department;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface DepartmentInterfaceController {
    public boolean save (String departmentId, String departmentName, 
            String managerId, String locationId);
    public boolean edit (String departmentId, String departmentName, 
            String managerId, String locationId);
    public boolean drop (int id);
    public List<Department> binding();
    public List<Department> binding(String category, String sort);
    public List<Department> find(String category, String data);
    public Department findById (int id);
}
