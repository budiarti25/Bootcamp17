/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.CountryDAO;
import daos.RegionDAO;
import entities.Country;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author budiarti
 */
public class CountryController implements CountryInterfaceController{
    
    private CountryDAO countryDAO;
    private RegionDAO regionDAO;
    
    public CountryController() {
    }

    public CountryController(Connection connection) {
        this.countryDAO = new CountryDAO(connection);
    }
 
    @Override
    public boolean save(String countryId, String countryName, String regionId) {
        return this.countryDAO.insert(new Country(countryId, countryName, Integer.parseInt(regionId)));
    }

    @Override
    public boolean edit(String countryId, String countryName, String regionId) {
        return this.countryDAO.update(new Country(countryId, countryName, Integer.parseInt(regionId)));
    }

    @Override
    public boolean drop(String id) {
        return this.countryDAO.delete(id);
    }

    @Override
    public List<Country> binding() {
        return this.countryDAO.getAll();
    }

    @Override
    public List<Country> bindingSort(String category, String sort) {
        return this.countryDAO.getAllSort(category, sort);
    }

    @Override
    public List<Country> find(String category, String data) {
        return this.countryDAO.search(category, data);
    }

    @Override
    public Country findById(int id) {
        return this.countryDAO.getById(id);
    }
    
}
