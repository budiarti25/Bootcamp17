/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Department;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface DepartmentInterfaceDAO {
    public boolean insert(Department department); 
    public boolean update(Department department);
    public boolean delete(int id);
    public List<Department> getAll(); //view = lihat semua
    public List<Department> getAll(String category, String sort);
    public List<Department> search(String category, String data);
    public Department getById(int id);
}
