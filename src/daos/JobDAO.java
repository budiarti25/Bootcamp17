/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Job;
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
 * @author Dayinta Warih Wulandari
 */
public class JobDAO implements JobInterfaceDAO {
/**
 * Membuat koneksi
 */
    private Connection connection;

    public JobDAO() {
    }

    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Fungsi untuk insert data yang merupakan method override dari interface JobInterfaceDAO dengan parameter objek Job
     * @param job instansiasi objek dari class Job
     * @return true ketika berhasil dan false ketika gagal
     */
    @Override
    public boolean insert(Job job) {
        boolean flag = false;
        String query = "INSERT INTO Jobs VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job.getJobId());
            preparedStatement.setString(2, job.getJobTitle());
            preparedStatement.setInt(3, job.getMinSalary());
            preparedStatement.setInt(4, job.getMaxSalary());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * Fungsi untuk update data yang merupakan method override dari interface JobInterfaceDAO dengan parameter objek Job
     * @param job instansiasi objek dari class Job
     * @return true ketika berhasil dan false ketika gagal
     */
    @Override
    public boolean update(Job job) {
        String query = "UPDATE Jobs SET job_title=?, min_salary=?, max_salary=? WHERE job_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job.getJobTitle());
            preparedStatement.setInt(2, job.getMinSalary());
            preparedStatement.setInt(3, job.getMaxSalary());
            preparedStatement.setString(4, job.getJobId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * Fungsi untuk delete data yang merupakan method override dari interface JobInterfaceDAO dengan parameter String
     * @param id merupakan job_id dari kolom yang akan dihapus bertipe data String
     * @return true ketika berhasil dan false ketika gagal
     */
    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM Jobs WHERE job_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * Fungsi untuk menampilkan semua data yang merupakan method override dari interface JobInterfaceDAO
     * @return variabel datas yaitu sebuah variabel bertipe ArrayList yang digunakan untuk menampung hasil dari SELECT
     */
    @Override
    public List<Job> getAll() {
        List<Job> datas = new ArrayList<>();
        String query = "SELECT * FROM Jobs";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setMinSalary(rs.getInt(3));
                job.setMaxSalary(rs.getInt(4));
                datas.add(job);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * Fungsi untuk menampilkan semua data dengan urut yang merupakan method override dari interface JobInterfaceDAO dengan parameter String dan String
     * @param category urutan berdasarkan oleh variabel ini
     * @param sort jenis sortir
     * @return variabel datas yaitu sebuah variabel bertipe ArrayList yang digunakan untuk menampung hasil dari SELECT
     */
    @Override
    public List<Job> getAll(String category, String sort) {
        List<Job> datas = new ArrayList<>();
        String query = "SELECT * FROM Jobs ORDER BY " + category + " " + sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setMinSalary(rs.getInt(3));
                job.setMaxSalary(rs.getInt(4));
                datas.add(job);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * Fungsi untuk menampilkan data tertentu yang merupakan method override dari interface JobInterfaceDAO dengan parameter String dan String
     * @param category varibel yang digunakan untuk mencari
     * @param data keyword untuk mencari
     * @return variabel datas yaitu sebuah variabel bertipe ArrayList yang digunakan untuk menampung hasil dari SELECT
     */
    @Override
    public List<Job> search(String category, String data) {
        List<Job> datas = new ArrayList<>();
        String query = "SELECT * FROM Jobs WHERE " + category + " LIKE '%" + data + "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setMinSalary(rs.getInt(3));
                job.setMaxSalary(rs.getInt(4));
                datas.add(job);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * Fungsi untuk menampilkan data tertentu berdasarkan job_id yang merupakan method override dari interface JobInterfaceDAO dengan parameter String
     * @param id job_id yang ingin dicari
     * @return berupa objek yang mana merupakan hasil dari SELECT
     */
    @Override
    public Job getById(String id) {
        Job job = new Job();
        String query = "SELECT * FROM Jobs WHERE job_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setMinSalary(rs.getInt(3));
                job.setMaxSalary(rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return job;
    }
}

