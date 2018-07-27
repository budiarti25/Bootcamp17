/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.DepartmentDAO;
import entities.Department;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class DepartmentController implements DepartmentInterfaceController{
    private Connection connection;
    private DepartmentDAO departmentDAO;
    public DepartmentController(){
    }
    
     public DepartmentController(Connection connection) {
        this.departmentDAO = new DepartmentDAO(connection);
    }
    

    @Override
    public boolean save(String departmentId, String departmentName, String managerId, String locationId) {
        Department department = new Department();
        department.setDepartmentId(Integer.parseInt(departmentId));
        department.setDepartmentName(departmentName);
        department.setManagerId(Integer.parseInt(managerId));
        department.setLocationId(Integer.parseInt(locationId));
        return this.departmentDAO.insert(department);
    }

    @Override
    public boolean edit(String departmentId, String departmentName, String managerId, String locationId) {
        Department department = new Department();
        department.setDepartmentId(Integer.parseInt(departmentId));
        department.setDepartmentName(departmentName);
        department.setManagerId(Integer.parseInt(managerId));
        department.setLocationId(Integer.parseInt(locationId));
        department.getDepartmentId();
        department.getDepartmentName();
        department.getManagerId();
        department.getLocationId();
        return this.departmentDAO.update(department);
    }

    @Override
    public boolean drop(int id) {
        return this.departmentDAO.delete(id);
    }

    @Override
    public List<Department> binding() {
        return this.departmentDAO.getAll();
    }

    @Override
    public List<Department> binding(String category, String sort) {
        return this.departmentDAO.getAll(category, sort);
    }

    @Override
    public List<Department> find(String category, String data) {
        return this.departmentDAO.search(category, data);

    }

    @Override
    public Department findById(int id) {
        return this.departmentDAO.getById(id);
    }
    
}
