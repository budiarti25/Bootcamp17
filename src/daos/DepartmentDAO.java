/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simbok_pc
 */
public class DepartmentDAO implements DepartmentInterfaceDAO{
    private Connection connection;
    public List<Department> getAll;

    public DepartmentDAO() {
    }

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(Department department) {
        boolean flag = false;
        String query = "INSERT INTO Departments VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setInt(3, department.getManagerId());
            preparedStatement.setInt(4, department.getLocationId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Department department) {
        String query = "UPDATE Departments SET department_name=?, manager_id=?, location_id=? WHERE department_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getManagerId());
            preparedStatement.setInt(3, department.getLocationId());
            preparedStatement.setInt(4, department.getDepartmentId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM Departments WHERE department_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Department> getAll() {
        List<Department> datas = new ArrayList<>();
        String query = "SELECT * FROM Departments";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt(1));
                department.setDepartmentName(rs.getString(2));
                department.setLocationId(rs.getInt(4));
                department.setManagerId(rs.getInt(3));
                datas.add(department);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public List<Department> getAll(String category, String sort) {
         List<Department> datas = new ArrayList<>();
        String query = "SELECT * FROM Departments ORDER BY " + category + " " + sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt(1));
                department.setDepartmentName(rs.getString(2));
                department.setLocationId(rs.getInt(3));
                department.setManagerId(rs.getInt(4));
                datas.add(department);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public List<Department> search(String category, String data) {
        List<Department> datas = new ArrayList<>();
        String query = "SELECT * FROM Departments WHERE " + category + " LIKE '%" + data+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt(1));
                department.setDepartmentName(rs.getString(2));
                department.setLocationId(rs.getInt(3));
                department.setManagerId(rs.getInt(4));
                datas.add(department);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public Department getById(int id) {
        Department department = new Department();
        String query = "SELECT * FROM Departments WHERE department_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                department.setDepartmentId(rs.getInt(1));
                department.setDepartmentName(rs.getString(2));
                department.setLocationId(rs.getInt(3));
                department.setManagerId(rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return department;
    }
}
