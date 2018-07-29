/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import entities.Job;
import java.util.List;
/**
 *
 * @author Dayinta Warih Wulandari
 */
public interface JobInterfaceDAO {
    public boolean insert(Job job);
    public boolean update(Job job);
    public boolean delete(String id);
    public List<Job> getAll();
    public List<Job> getAll(String category, String sort);
    public List<Job> search(String category, String data);
    public Job getById(String id);
}
