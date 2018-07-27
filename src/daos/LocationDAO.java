/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Location;
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
 * @author Gusma
 */
public class LocationDAO implements LocationInterfaceDAO {
     private Connection connection;

    public LocationDAO() {
    }
     
     public LocationDAO(Connection connection) {
        this.connection = connection;
    }
     /**
      * Fungsi Insert
      * @param location
      * @return 
      */
     public boolean insert(Location location) {
        boolean flag = false;
        String query = "INSERT INTO Locations VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, location.getLocationId());
            preparedStatement.setString(2, location.getStreetAddress());
            preparedStatement.setString(3, location.getPostalCode());
            preparedStatement.setString(4, location.getCity());
            preparedStatement.setString(5, location.getStateProvince());
            preparedStatement.setString(6, location.getCountryId());
            
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    
    @Override
    public boolean update(Location location) {
        String query = "UPDATE Locations SET street_address=?,postal_code=?,city=?,state_province=?,country_id=? WHERE location_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(6, location.getLocationId());
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setString(2, location.getPostalCode());
            preparedStatement.setString(3, location.getCity());
            preparedStatement.setString(4, location.getStateProvince());
            preparedStatement.setString(5, location.getCountryId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    @Override
    public boolean delete(int id) {
        try {
            String query = "DELETE FROM Locations WHERE location_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    @Override
    public List<Location> getAll() {
        List<Location> datas = new ArrayList<>();
        String query = "SELECT * FROM Locations";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Location location = new Location();
                location.setLocationId(rs.getInt("location_id"));
                location.setStreetAddress(rs.getString("street_address"));
                location.setPostalCode(rs.getString("postal_code"));
                location.setCity(rs.getString("city"));
                location.setStateProvince(rs.getString("state_province"));
                location.setCountryId(rs.getString("country_id"));
                datas.add(location);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    
    @Override
    public List<Location> getAllCs(String category, String sort) {

        List<Location> datas = new ArrayList<>();
        String query = "SELECT * FROM Locations ORDER BY "+category+" "+ sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Location location = new Location();
                location.setLocationId(rs.getInt("location_id"));
                location.setStreetAddress(rs.getString("street_address"));
                location.setPostalCode(rs.getString("postal_code"));
                location.setCity(rs.getString("city"));
                location.setStateProvince(rs.getString("state_province"));
                location.setCountryId(rs.getString("country_id"));
                datas.add(location);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public List<Location> search(String category, String data) {
        List<Location> datas = new ArrayList<>();
        String query = "SELECT * FROM Locations WHERE "+category+" LIKE '%"+data+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Location location = new Location();
                location.setLocationId(rs.getInt("location_id"));
                location.setStreetAddress(rs.getString("street_address"));
                location.setPostalCode(rs.getString("postal_code"));
                location.setCity(rs.getString("city"));
                location.setStateProvince(rs.getString("state_province"));
                location.setCountryId(rs.getString("country_id"));
                datas.add(location);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public Location getById(int id) {
        Location location = new Location();
        String query = "SELECT * FROM Locations WHERE location_id="+id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                
                location.setLocationId(rs.getInt(1));
                location.setStreetAddress(rs.getString(2));
                location.setPostalCode(rs.getString(3));
                location.setCity(rs.getString(4));
                location.setStateProvince(rs.getString(5));
                location.setCountryId(rs.getString(6));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return location;
    }

}
