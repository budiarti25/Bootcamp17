/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Country;
import java.util.List;

/**
 *
 * @author budiarti
 */
public interface CountryInterfaceController {
    public boolean save(String countryId, String countryName, String regionId);
    public boolean edit(String countryId, String countryName, String regionId);
    public boolean drop(String id);
    public List<Country> binding();
    public List<Country> bindingSort(String category, String sort);
    public List<Country> find(String category, String data);
    public Country findById(int id);
//    public Country findRegId(int id);
}
