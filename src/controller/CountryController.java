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
    
    public CountryController() {
    }

    public CountryController(Connection connection) {
        this.countryDAO = new CountryDAO(connection);
    }
 
    /**
     * fungsi save untuk menyimpan data yang di inputkan ke tabel country, dihubungakan dengan countryDAO
     * @param countryId String
     * @param countryName String
     * @param regionId String
     * @return controller perintah simppan
     */
    @Override
    public boolean save(String countryId, String countryName, String regionId) {
        return this.countryDAO.insert(new Country(countryId, countryName, Integer.parseInt(regionId)));
    }

    /**
     * fungsi edit untuk mengubah data yang ingin diubah di tabel country, dihubungakan dengan countryDAO
     * @param countryId String
     * @param countryName String
     * @param regionId String
     * @return controller perintah ubah
     */
    @Override
    public boolean edit(String countryId, String countryName, String regionId) {
        return this.countryDAO.update(new Country(countryId, countryName, Integer.parseInt(regionId)));
    }

    /**
     * fungsi drop untuk menghapus data yang di tabel country dihubungakan dengan countryDAO
     * @param id
     * @return controller perintah hapus
     */
    @Override
    public boolean drop(String id) {
        return this.countryDAO.delete(id);
    }

    /**
     * fungsi binding untuk menampilkan seluruh data yang di tabel country, dihubungakan dengan countryDAO
     * @return controller perintah tampil
     */
    @Override
    public List<Country> binding() {
        return this.countryDAO.getAll();
    }

    /**
     * fungsi bindingSort untuk menampilkan seluruh data yang di tabel country berdasarkan kondisi, dihubungakan dengan countryDAO
     * @param category String
     * @param sort String
     * @return controller perintah tampil berdasarkan parameter
     */
    @Override
    public List<Country> bindingSort(String category, String sort) {
        return this.countryDAO.getAllSort(category, sort);
    }

    /**
     * fungsi find untuk pencarian data yang di tabel country berdasarkan kondisi, dihubungakan dengan countryDAO
     * @param category String
     * @param data String
     * @return controller perintah cari
     */
    @Override
    public List<Country> find(String category, String data) {
        return this.countryDAO.search(category, data);
    }

    /**
     * fungsi findById untuk pencarian data yang di tabel country berdasarkan kondisi, dihubungakan dengan countryDAO
     * @param id
     * @return controller perintah menampilkan data berdasarkan kondisi
     */
    @Override
    public Country findById(int id) {
        return this.countryDAO.getById(id);
    }
    
}
