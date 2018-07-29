/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entities.Job;
import java.util.List;
import daos.JobDAO;
import java.sql.Connection;

/**
 * 
 * @author Dayinta Warih Wulandari
 */
public class JobController implements JobInterfaceController{
    private JobDAO jobDAO;

    public JobController() {
    }

    /**
     * Membuat koneksi
     * @param connection instansiasi dari class Connection
     * @param jobDAO instansiasi dari class JobDAO
     */
    public JobController(Connection connection) {
        this.jobDAO = new JobDAO(connection);
    }
    /**
     * Fungsi untuk melakukan insert/save data
     * @param jobId job_id dari Tabel Jobs
     * @param jobTitle job_title dari Tabel Jobs
     * @param minSalary min_Salary dari Tabel Jobs
     * @param maxSalary max_salary dari Tabel Jobs
     * @return memanggil instan dari class JobDAO dan memanggil method insert dengan parameter variabel di atas dimana untuk minSalary dan masSalary dilakukan parseInt karena nilai yang dibutuhkan adalah Integer
     */
    @Override
    public boolean save(String jobId, String jobTitle, String minSalary, String maxSalary) {
        return this.jobDAO.insert(new Job(jobId, jobTitle, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)));
    }

    /**
     * Fungsi untuk melakukan edit/update data
     * @param jobId job_id dari Tabel Jobs
     * @param jobTitle job_title dari Tabel Jobs
     * @param minSalary min_Salary dari Tabel Jobs
     * @param maxSalary max_salary dari Tabel Jobs
     * @return memanggil instan dari class JobDAO dan memanggil method update dengan parameter variabel di atas dimana untuk minSalary dan masSalary dilakukan parseInt karena nilai yang dibutuhkan adalah Integer
     */
    @Override
    public boolean edit(String jobId, String jobTitle, String minSalary, String maxSalary) {
        return this.jobDAO.update(new Job(jobId, jobTitle, Integer.parseInt(minSalary), Integer.parseInt(maxSalary)));
    }

    /**
     * Fungsi untuk drop/delete data
     * @param id job_id yang datanya akan dihapus
     * @return memanggil instan dari class JobDAO dan memanggil method delete dengan parameter idJob
     */
    @Override
    public boolean drop(String id) {
        return this.jobDAO.delete(id);
    }

    /**
     * Fungsi untuk menampilkan semua data
     * @return memanggil instan dari class JobDAO dan memanggil method getAll
     */
    @Override
    public List<Job> binding() {
        return this.jobDAO.getAll();
    }

    /**
     * Fungsi untuk menampilkan semua data dengan sorting
     * @param category variabel yang digunakan sebagai patokan untuk sorting
     * @param sort jenis sorting
     * @return memanggil instan dari class JobDAO dan memanggil method getAll(category, sort)
     */
    @Override
    public List<Job> binding(String category, String sort) {
        return this.jobDAO.getAll(category, sort);
    }

    /**
     * Fungsi untuk menampilkan data tertentu / search
     * @param category variabel yang digunakan sebagai kategori dalam pencarian
     * @param data keyword pencarian
     * @return memanggil instan dari class JobDAO dan memanggil method search(category, data)
     */
    @Override
    public List<Job> find(String category, String data) {
        return this.jobDAO.search(category, data);
    }

    /**
     * Fungsi untuk menampilkan data tertentu berdasarkan job_id
     * @param id job_id yang dicari
     * @return memanggil instan dari class JobDAO dan memanggil method getById(id)
     */
    @Override
    public Job findById(String id) {
        return this.jobDAO.getById(id);
    }

}
