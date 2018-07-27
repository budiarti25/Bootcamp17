/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Country;
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
 * @author budiarti
 */
public class CountryDAO implements CountryInterfaceDAO{
    private Connection connection;

    public CountryDAO() {
    }

    /**
     * fungsi untuk memanggil koneksi
     * @param connection 
     */
    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * fungsi insert untuk Tabel country
     * @param country
     * @return 
     */
    @Override
    public boolean insert(Country country) {
        boolean flag=false;
        String query="INSERT INTO Countries VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, country.getCountryId());
            preparedStatement.setString(2, country.getCountryName());
            preparedStatement.setInt(3, country.getRegionId());
            preparedStatement.executeUpdate();
            flag=true;
        } catch (SQLException e) {
             Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return flag;
    }
    
    /**
     * fungsi update untuk Tabel country
     * @param country
     * @return 
     */
    @Override
    public boolean update(Country country) {
        boolean flag=false;
        String query="UPDATE Countries SET country_name=? , region_id=? WHERE country_id=? ";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, country.getCountryName());
            preparedStatement.setInt(2, country.getRegionId());
            preparedStatement.setString(3, country.getCountryId());
            preparedStatement.executeUpdate();
            flag=true;
        } catch (SQLException e) {
             Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return flag;
    }

    /**
     * fungsi delete untuk Tabel country
     * @param id
     * @return 
     */
    @Override
    public boolean delete(String id) {
        boolean flag=false;
        String query="DELEtE Countries WHERE country_id=? ";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            flag=true;
        } catch (SQLException e) {
             Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return flag;
    }

    /**
     * fungsi menggambil/menampilkan data dari Tabel country
     * @return 
     */
    @Override
    public List<Country> getAll() {
        List<Country> datas = new ArrayList<>();
        String query="SELECT * FROM Countries";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Country country=new Country();
                country.setCountryId(rs.getString("country_id"));
                country.setCountryName(rs.getString("country_name"));
                country.setRegionId(rs.getInt("region_id"));
                datas.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas ;
    }

    /**
     * fungsi tampil data dari Tabel country berdasarkan parameter
     * @param category bertipe String untuk parameter kategori yg akan dijadikan acuan mengurutkan data
     * @param sort bertipe String untuk mengurutkan data berdasar asc/ desc
     * @return 
     */
    @Override
    public List<Country> getAllSort(String category, String sort) {
        List<Country> datas = new ArrayList<>();
        String query="SELECT * FROM Countries ORDER BY "+category+" "+sort;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Country country=new Country();
                country.setCountryId(rs.getString("country_id"));
                country.setCountryName(rs.getString("country_name"));
                country.setRegionId(rs.getInt("region_id"));
                datas.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * fungsi search dari Tabel country dengan parameter tertentu
     * @param category bertipe String untuk parameter kategori yg akan ddicari
     * @param data bertipe String untuk parameter kata kunci
     * @return 
     */
    @Override
    public List<Country> search(String category, String data) {
        List<Country> datas = new ArrayList<>();
        String query="SELECT * FROM Countries WHERE "+category+" LIKE '%"+data+"%'";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Country country=new Country();
                country.setCountryId(rs.getString("country_id"));
                country.setCountryName(rs.getString("country_name"));
                country.setRegionId(rs.getInt("region_id"));
                datas.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * fungsi getById untuk menampilkan data Tabel country dengan parameter id
     * @param id bertipe integer
     * @return 
     */
    @Override
    public Country getById(int id) {
        Country country = new Country();
        String query="SELECT * FROM Countries WHERE country_id="+id;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                country.setCountryId(rs.getString("country_id"));
                country.setCountryName(rs.getString("country_name"));
                country.setRegionId(rs.getInt("region_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return country;
    }
}
