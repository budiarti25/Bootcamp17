/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controller.CountryController;
import controller.RegionController;
import entities.Region;
import entities.Job;
import controller.JobController;
import java.sql.Connection;

/**
 *
 * @author Budiarti
 */
public class ManualTester {
    public static void main(String[] args) {
//        System.out.println(new MyConnection().getConnection());
        Connection connection =new MyConnection().getConnection();
        String countryId="KS";
        String countryName="Korea Selatan";
        int regionId = 3;
        
        RegionController regionController=new RegionController(connection);
        CountryController countryController=new CountryController(connection);
//        System.out.println(countryController.save(countryId, countryName, Integer.toString(regionId)));
//        System.out.println(regionController.edit(regionId, regionName));
//        System.out.println(regionController.drop(Integer.parseInt(regionId)));
        for (Region region : regionController.binding()) {
            System.out.println(region.getRegionId()+"-"+region.getRegionName());
        }
//        System.out.println("pakai sort");
//        regionController.bindingSort("region_id", "desc").forEach((region)->{
//            System.out.println(region.getRegionId()+"-"+region.getRegionName());
//            });
//        regionController.find("region_name", "a").forEach((region)->{
//            System.out.println(region.getRegionId()+"-"+region.getRegionName());
//            });
//        System.out.println(regionController.findById(9).getRegionName());
//-------------------TESTER JOB
                String jobId = "DEV_JR";
        String jobTitle = "Developer Junior";
        String minSalary = "5000";
        String maxSalary = "10000";
        JobController jobController = new JobController(connection);
//        System.out.println(jobController.save(jobId, jobTitle, minSalary, maxSalary));   
//        System.out.println(jobController.edit(jobId, jobTitle, minSalary, maxSalary));
//        System.out.println(jobController.drop(jobId));
        for (Job job : jobController.binding()) {
            System.out.println(job.getJobId() + " - " + job.getJobTitle()
                    + " - " + job.getMinSalary() + " - " + job.getMaxSalary());
        }
//        System.out.println("---------------DENGAN SORT---------------------");
//        for (Job job : jobController.binding("job_id", "asc")) {
//            System.out.println(job.getJobId() + " - " + job.getJobTitle()
//                    + " - " + job.getMinSalary() + " - " + job.getMaxSalary());
//        }
//        jobController.find("job_title", "v").forEach((job) -> {
//            System.out.println(job.getJobId() + " - " + job.getJobTitle()
//                    + " - " + job.getMinSalary() + " - " + job.getMaxSalary());
//        });
        System.out.println(jobController.findById("SA_REP").getJobTitle());   
    }
}
    

