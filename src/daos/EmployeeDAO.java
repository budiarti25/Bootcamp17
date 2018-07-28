/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Employee;
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
 * @author iqbael17
 */
public class EmployeeDAO implements EmployeeIntefaceDAO {

    private Connection connection;

    public EmployeeDAO() {

        
    }

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(Employee employee) {

        boolean flag = false;
        String query = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setDate(6, employee.getHireDate());
            preparedStatement.setString(7, employee.getJobId());
            preparedStatement.setInt(8, employee.getSalary());
            preparedStatement.setDouble(9, employee.getCommisionPct());
            preparedStatement.setDouble(10, employee.getManagerid());
            preparedStatement.setDouble(11, employee.getDepartmentid());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean update(Employee employee) {
        try {
            String query = "UPDATE Employees SET first_name=?, Last_name=?,email=?,"
                    + "phone_number=?,hire_date=?,job_id=?,salary=?,commission_pct=?,"
                    + "manager_id=?,department_id=?"
                    + " WHERE employee_id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setString(6, employee.getJobId());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setDouble(8, employee.getCommisionPct());
            preparedStatement.setDouble(9, employee.getManagerid());
            preparedStatement.setDouble(10, employee.getDepartmentid());
            preparedStatement.setInt(11, employee.getEmployeeId());
            preparedStatement.executeUpdate();
            preparedStatement.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean delete(int id) {
        try {
            String query = "DELETE FROM Employees Where employee_id=?";

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
    public List<Employee> getAll() {
        List<Employee> datas = new ArrayList<>();
        String query = "SELECT *From Employees";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setEmail(rs.getString(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setHireDate(rs.getDate(6));
                employee.setJobId(rs.getString(7));
                employee.setSalary(rs.getInt(8));
                employee.setCommisionPct(rs.getDouble(9));
                employee.setManagerid(rs.getInt(10));
                employee.setDepartmentid(rs.getInt(11));
                datas.add(employee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    @Override
    public List<Employee> getAll(String category, String sort) {
        List<Employee> datas = new ArrayList<>();
        String query = "SELECT *FROM Employees ORDER BY " + category + " " + sort;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setEmail(rs.getString(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setHireDate(rs.getDate(6));
                employee.setJobId(rs.getString(7));
                employee.setSalary(rs.getInt(8));
                employee.setCommisionPct(rs.getDouble(9));
                employee.setManagerid(rs.getInt(10));
                employee.setDepartmentid(rs.getInt(11));
                datas.add(employee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public List<Employee> search(String category, String data) {
        List<Employee> datas = new ArrayList<>();
        String query = "SELECT *FROM Employees WHERE " + category + " " + " like '%" + data + "%'";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setEmail(rs.getString(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setHireDate(rs.getDate(6));
                employee.setJobId(rs.getString(7));
                employee.setSalary(rs.getInt(8));
                employee.setCommisionPct(rs.getDouble(9));
                employee.setManagerid(rs.getInt(10));
                employee.setDepartmentid(rs.getInt(11));
                datas.add(employee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        String query = "SELECT *FROM Employees WHERE employee_id = " + id + "'";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                employee.setEmployeeId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setEmail(rs.getString(4));
                employee.setPhoneNumber(rs.getString(5));
                employee.setHireDate(rs.getDate(6));
                employee.setJobId(rs.getString(7));
                employee.setJobId(rs.getString(8));
                employee.setSalary(rs.getInt(8));
                employee.setCommisionPct(rs.getDouble(9));
                employee.setManagerid(rs.getInt(10));
                employee.setDepartmentid(rs.getInt(11));

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

}
