/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entities.Job;
import java.util.List;
/**
 *
 * @author Dayinta Warih Wulandari
 */
public interface JobInterfaceController {
    public boolean save(String jobId, String jobTitle, String minSalary, String maxSalary);
    public boolean edit(String jobId, String jobTitle, String minSalary, String maxSalary);
    public boolean drop(String id);
    public List<Job> binding();
    public List<Job> binding(String category, String sort);
    public List<Job> find(String category, String data);
    public Job findById(String id);
}
