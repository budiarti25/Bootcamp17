/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.LocationDAO;
import entities.Location;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Gusma
 */
public class LocationController implements LocationInterfaceController {

    private LocationDAO locationDAO;

    public LocationController() {
    }

    public LocationController(Connection connection) {
        this.locationDAO = new LocationDAO(connection);
    }

    @Override
    public boolean save(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        Location location = new Location(Integer.parseInt(locationId), streetAddress, postalCode, city, stateProvince, countryId);
        return this.locationDAO.insert(location);
    }
    
    @Override
    public boolean edit(String locationId, String streetAddress, String postalCode, String city, String stateProvince, String countryId) {
        return this.locationDAO.update(new Location(Integer.parseInt(locationId), streetAddress,postalCode, city, stateProvince, countryId));

    }

    @Override
    public boolean drop(int id) {
        return this.locationDAO.delete(id);

    }

    @Override
    public List<Location> binding() {
        return this.locationDAO.getAll();

    }

    @Override
    public List<Location> bindingsort(String category, String sort) {
        return this.locationDAO.getAllCs(category, sort);

    }

    @Override
    public List<Location> find(String category, String data) {
        return this.locationDAO.search(category, data);
    }

    @Override
    public Location findById(int id) {
        return this.locationDAO.getById(id);

    }

}
